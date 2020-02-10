package test.excutor_service;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

	private static final AtomicInteger THREAD_POOL_NUMBER = new AtomicInteger(1);
	private final ThreadGroup group;
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private static final String NAME_PATTERN = "%s-%d-thread";
	private final String threadNamePrefix;
	
	public NamedThreadFactory(String threadNamePrefix) {
		final SecurityManager s = System.getSecurityManager();
		group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		this.threadNamePrefix = String.format(Locale.ROOT, NAME_PATTERN,
				checkPrefix(threadNamePrefix), THREAD_POOL_NUMBER.getAndIncrement());
	}

	private static String checkPrefix(String prefix) {
		return prefix == null || prefix.length() == 0 ? "Lucene" : prefix;
	}
	
	@Override
	public Thread newThread(Runnable r) {
		final Thread t = new Thread(group, r, String.format(Locale.ROOT, "%s-%d",
				threadNamePrefix, threadNumber.getAndIncrement()), 0);
		t.setDaemon(false);
		t.setPriority(Thread.NORM_PRIORITY);
		return t;
	}
}
