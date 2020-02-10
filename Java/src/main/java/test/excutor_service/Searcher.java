package test.excutor_service;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class Searcher {
	public void search(String[] texts) {

		ExecutorService service = ExecutionHelper.createExecutor(texts.length, "test");
		try {
			final ExecutionHelper<String> runner = new ExecutionHelper<String>(service);

			Random random = new Random();

			for (String text : texts) {
				int randomSec = random.nextInt(3);
				runner.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						// 멀티스레드 동작을 쉽게 확인하기 위해 스레드 sleep 사용
						Thread.sleep(randomSec * 1000);
						return text + " 지연 : " + (randomSec * 1000) + " => " + text.toUpperCase();
					}
				});
			}

			// Iterator
			// while (runner.hasNext()) {
			// String converted = runner.next();
			// System.out.println(converted);
			// }

			// Iterable
			for (String converted : runner) {
				System.out.println(converted);
			}

		} finally {
			ExecutionHelper.shutdownExecutorService(service);
		}
	}

	public static void main(String[] args) {
		Searcher searcher = new Searcher();
		searcher.search(new String[] { "a", "b", "c", "d" });
	}
}
