package test.polymorphism;

public class Test {
	public static void main(String[] args) {
		//다형성
		//오버라이딩 - 런타임 시 결정되기 때문에, 
		System.out.println("****다형성 오버라이딩 테스트");
		Parent p = new Son();
		p.foo();
		p = new Parent();
		p.foo();
		
		//오버로딩 - 컴파일 시 결정
		//Overload 클래스가 동일 이름의 함수 foo를 가지고 있고
		//각각 매개변수가 Parent와 Son일 경우,
		//컴파일 시에 결정 됐기 때문에
		//인자로 들어오는 클래스가 실제로 new 키워드를 통해 어떤 객체가 생성됐는지 검사하지 않고, 
		//선언된 클래스로만 판별하고 기능한다.
//		System.out.println("****다형성 오버로딩 테스트");
//		Overload o = new Overload();
//		System.out.println("--foo(Parent p) 메소드");
//		o.foo(new Parent());
//		
//		System.out.println("--foo(Son s) 메소드");
//		o.foo(new Son());
//		
//		System.out.println("Parent 클래스로 선언 후, Son 객체로 생성하여 foo 메소드에 넣는다면, 컴파일 시 결정된 선언된 Parent로 인식");
//		Parent who = new Son();
//		o.foo(who);
		
		
		//접근제어자 
		//public : 어디든 오픈
		//protected : 자식 클래스
		//default 
		Parent son = new Son();
		son.boo();
		son.soo();
	}
}
