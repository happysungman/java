package test.polymorphism;

public class Parent {
	public void foo() {
		System.out.println("아빠");
	}

	protected void boo() {
		System.out.println("프로택티드");
	}

	void soo() {
		System.out.println("디폴트");
	}
}
