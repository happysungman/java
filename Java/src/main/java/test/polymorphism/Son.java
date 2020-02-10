package test.polymorphism;

public class Son extends Parent {
	@Override
	public void foo() {
		System.out.println("아들");
	}
	
	@Override
	public void boo() {
		System.out.println("아들 boo 오버라이딩 프로텍티드 -> 퍼블릭으로");
	}
	
	public void ssoo() {
		System.out.println("아들 boo 오버라이딩 프로텍티드 -> 퍼블릭으로");
	}
}
