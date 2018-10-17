package mx.com.dalvik;

import java.util.ArrayList;
import java.util.List;

public class DemoXMLJSON {
	
	public static void main(String[] args) {
		
		TreeXML mTreeXML = new TreeXML();
		Body mBody = new Body();
		Tag mTag = new Tag();
		Nodo mNodo1 = new Nodo(); 
		Nodo mNodo2 = new Nodo();
		
		mNodo1.setEdad(15);
		mNodo1.setValue("Pepe");
		mNodo2.setEdad(20);
		mNodo2.setValue("Miguel");
		
		List<Nodo> list = new ArrayList<Nodo>();
		list.add( mNodo1 );
		list.add( mNodo2 );
		
		mBody.setNodos( list );
		mBody.setTag(mTag);
		mTreeXML.setBody(mBody);
		
		
		TreeXML mTreeXML2 = new TreeXML();
		TreeXML mTreeXML3 = new TreeXML();
		TreeXML mTreeXML4 = new TreeXML();		
		
		mTreeXML2 = mTreeXML.clone();
		mTreeXML3 = mTreeXML.clone();
		mTreeXML4 = mTreeXML.clone();

		mTreeXML.setName("mTreeXML1");
		mTreeXML2.setName("mTreeXML2");
		mTreeXML3.setName("mTreeXML3");
		mTreeXML4.setName("mTreeXML4");
		
		System.out.println( mTreeXML );
		
		mTreeXML.getBody().getNodos().get(1).setEdad(17);
		System.out.println( mTreeXML );
		System.out.println( mTreeXML2 );
		System.out.println( mTreeXML3 );
		
		
	}
}


class TreeXML {
	
	private String name;
	private Body body;

	
	public TreeXML() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public TreeXML(String name, Body body) {
		super();
		this.name = name;
		this.body = body;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}



	@Override
	public String toString() {
		return "TreeXML [name=" + name + ", body=" + body + "]";
	}
	
	public TreeXML clone() {
		
		
		TreeXML mTreeXML = new TreeXML();
		Body mBody = new Body();
		Tag mTag = new Tag();
//		Nodo mNodo1 = new Nodo(); 
//		Nodo mNodo2 = new Nodo();
		
//		mNodo1.setEdad(15);
//		mNodo1.setValue("Pepe");
//		mNodo2.setEdad(20);
//		mNodo2.setValue("Miguel");
		
		List<Nodo> list = new ArrayList<Nodo>();
//		list.add( mNodo1 );
//		list.add( mNodo2 );
		
		for( Nodo nodo: this.getBody().getNodos() ) {
			// list.add( new Nodo( nodo.getEdad(), nodo.getValue() ));
			list.add( nodo.clone() );
			System.out.println( nodo );
		}
		
		
		mBody.setNodos( list );
		mBody.setTag(mTag);
		mTreeXML.setBody(mBody);
		return mTreeXML;
	}
	
}

// Bean - Pojo - Entity - DTO
class Body { 
	
	private Tag tag;	
	private List<Nodo> nodos;
	
	
	public Body() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Body(Tag tag, List<Nodo> nodos) {
		super();
		this.tag = tag;
		this.nodos = nodos;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public List<Nodo> getNodos() {
		return nodos;
	}
	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}
	
	@Override
	public String toString() {
		return "Body [tag=" + tag + ", nodos=" + nodos + "]";
	}	

	
}

class Tag{

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tag []";
	}
	
}

class Nodo {
	
	private Integer edad;
	private String value;
	
	
	
	public Nodo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nodo(Integer edad, String value) {
		super();
		this.edad = edad;
		this.value = value;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Nodo clone() {
		
		return new Nodo( this.edad, this.value );
	}
	
	@Override
	public String toString() {
		return "Nodo [edad=" + edad + ", value=" + value + "]";
	}
	
	
}