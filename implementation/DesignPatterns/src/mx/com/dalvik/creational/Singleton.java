package mx.com.dalvik.creational;

public class Singleton {
	
	private static Singleton INSTANCE;
	private String info;
	
	private Singleton() {
		this.info ="default info ...";
	}
	
	public static Singleton getInstance(){
		
		if( INSTANCE == null )
			INSTANCE = new Singleton();
		
		return INSTANCE;
	}
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
