package mx.com.dalvik;

public class A {
	
	private B b;
	
	// create
	public B makeB() {
		return new B();
	}
	
	// local
	public void f() {
		B b = new B();
	}
	
	// parameter
	public void m( B b ) {
		// use b
	}
	
	// delegate
	public void d() {
		this.b.d();
	}
	
//	// clase interna anónima
//	private class B {
//		
//	}
}

class B {
	
	public void d() {
		// ... 
	}
}