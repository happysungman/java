package test.excutor_service;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutionHelper<T> implements Iterator<T>, Iterable<T> {
	private final CompletionService<T> service;
	private int numTasks;
	
	public ExecutionHelper(final Executor executor) {
		this.service = new ExecutorCompletionService<>(executor);
	}

	@Override
	public boolean hasNext() {
		return numTasks > 0;
	}

	@Override
	public T next() {
		if (!this.hasNext()) 
			throw new NoSuchElementException("next() is called but hasNext() returned false");
		try {
			return service.take().get();
		} catch (InterruptedException e) {
			throw new ThreadInterruptedException(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		} finally {
			--numTasks;
		}
	}
	
	public Iterator<T> iterator() {
		return this;
	}
	
	public void submit(Callable<T> task) {
		this.service.submit(task);
		++numTasks;
	}
	
	public static ExecutorService createExecutor(int poolSize, String FactoryName) {
		ExecutorService executor = new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, 
				new LinkedBlockingQueue<Runnable>(), new NamedThreadFactory(FactoryName));
		return executor;
	}
	
	public static void shutdownExecutorService(ExecutorService es) {
		if (es != null) {
			try {
				es.shutdown();
				es.awaitTermination(1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				System.err.println("Could not properly shutdown executor service.");
				e.printStackTrace(System.err);
			}
		}
	}
}
