package test.excutor_service;

public class ThreadInterruptedException extends RuntimeException {

	private static final long serialVersionUID = -1615568787421169769L;

	public ThreadInterruptedException(InterruptedException e) {
		super(e);
	}
}
