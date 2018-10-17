package mx.com.dalvik;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class DemoXMLJSON {
	
	public static void main(String[] args) {
		
		
		

		
		
		new DemoXMLJSON().test();
		
		
		
	}
	
	public void test() {
		String xml = ""
				+ "<xml name='process'>"
				+ "	<body>"
				+ "		<entregas>"
				+ "			<entrega>"
				+ "				<estatus>Asignacion</estatus>"
				+ "				<fecha>14/10/2018 21:10:37</fecha>"
				+ "			</entrega>"
				+ "			<entrega>"
				+ "				<estatus>Creacion</estatus>"
				+ "				<fecha>12/10/2018 21:10:37</fecha>"
				+ "			</entrega>"
				+ "			<entrega>"
				+ "				<estatus>Devolucion</estatus>"
				+ "				<fecha>16/10/2018 21:10:37</fecha>"
				+ "			</entrega>"	
				+ "			<entrega>"
				+ "				<estatus>Salida</estatus>"
				+ "				<fecha>13/10/2018 21:10:37</fecha>"
				+ "			</entrega>"
				+ "			<entrega>"
				+ "				<estatus>Recepcion</estatus>"
				+ "				<fecha>15/10/2018 21:10:37</fecha>"
				+ "			</entrega>"
				+ "		</entregas>"
				+ "	</body>"
				+ "</xml>";
		
		
		
		Document doc = convertStringToXMLDocument( xml );
		System.out.println( doc.getDocumentElement().getChildNodes() );
		
		Node node = doc.getDocumentElement();
		List<NodoEntrega> lista = new ArrayList<NodoEntrega>();
		
		
		expandNodes( node, new CheckRule() {
			public void check( Node currentNode ) {
				
				if( currentNode.getNodeName().equals("entrega") ) {
					//System.out.println("entrega");
					NodoEntrega n = createNodesEntrega( currentNode );
					lista.add( n );
					//System.out.println( n );
				}

			}

			
		} );
		
		for( NodoEntrega n: lista )
			System.out.println( n );
		
		Collections.sort( lista, new Comparator<NodoEntrega>() {

			@Override
			public int compare(NodoEntrega a, NodoEntrega b) {
				
				return b.getFecha().compareTo( a.getFecha() );
			}
			
		} );
		
		System.out.println("-----");
		for( NodoEntrega n: lista )
			System.out.println( n );
		
		System.out.println("-----");
		if( lista.size() > 0 ) {
			NodoEntrega ultimo = lista.get(0);
			System.out.println("Ultimo estatus: ");
			System.out.println( ultimo );
		}
		
		
	}
	
	
	private NodoEntrega createNodesEntrega(Node currentNode) {
		
		NodoEntrega nodoEntrega = new NodoEntrega();
		NodeList list = currentNode.getChildNodes();
		for( int i = 0; i<list.getLength(); i++ ) {
			
			Node e = (Node) list.item( i );
			
			if( e.getNodeName().equals("estatus") ) {
				// System.out.println( currentNode.getNodeName()  );
				// System.out.println( e.getFirstChild().getNodeValue()  );
				nodoEntrega.setEstatus( e.getFirstChild().getNodeValue() );
			}
			
			if( e.getNodeName().equals("fecha") ) {
				// System.out.println( currentNode.getNodeName()  );
				// System.out.println( e.getFirstChild().getNodeValue()  );
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				try {
					
					nodoEntrega.setFecha( format.parse( e.getFirstChild().getNodeValue() ) );
				
				} catch (DOMException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		return nodoEntrega;
	}
	

	class NodoEntrega {
		
		private String estatus;
		private Date fecha;
		
		public String getEstatus() {
			return estatus;
		}

		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		@Override
		public String toString() {
			return "NodoEntrega [estatus=" + estatus + ", fecha=" + fecha + "]";
		}
	
		
	}
	
	
	
	
	
	
	
	private void expandNodes(Node node, CheckRule rule ) {
		NodeList nodeList = node.getChildNodes();
		for( int i = 0; i< nodeList.getLength(); i++ ) {
			Node currentNode = nodeList.item( i );
	
			if( currentNode.getNodeType() == Node.ELEMENT_NODE ) {
				
				rule.check( currentNode );
				expandNodes( currentNode, rule  );
				

			}
			
		}
	
	}















	private Document convertStringToXMLDocument(String xml) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		
		try {
			builder = factory.newDocumentBuilder();
			System.out.println( xml );
			doc = builder.parse( new InputSource( new StringReader( xml ) ) );

		} catch ( ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}






	
	public static void _______main(String[] args) {

		// Consultar servicio
		try {
			// to do something....
		}
		catch( Exception e ) {
			// print exception
		}
		
		// Consultar archivo
		try {
			// to do something....
		}
		catch( Exception e ) {
			// print exception
		}
		
		// consultar base
		try {
			// to do something....
		}
		catch( Exception e ) {
			// print exception
		}
		
		// Merge de archivos, parseo
		try {
			// to do something....
		}
		catch( Exception e ) {
			// print exception
		}
	}









	public static void _____main(String[] args) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		List<Date> dateList = new ArrayList<Date>();
		dateList.add( format.parse("12/10/2018 21:10:37"));
		dateList.add( format.parse("10/10/2018 20:10:37"));
		dateList.add( format.parse("13/10/2018 12:10:37"));
		dateList.add( format.parse("13/10/2018 12:10:38"));
		dateList.add( format.parse("12/10/2018 21:10:36"));
		
//		System.out.println( dateList );
		for( Date d: dateList )
			System.out.println( d );
		
		Collections.sort( dateList );
		
		System.out.println("_____");
//		System.out.println( dateList );
		
		for( Date d: dateList )
			System.out.println( d );
		
	}
	
	
	public static void __main(String[] args) {
		
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
		TreeXML mTreeXML5 = new TreeXML();
				
		mTreeXML2 = mTreeXML.clone();
		mTreeXML3 = mTreeXML.clone();
		mTreeXML4 = mTreeXML.clone();
		mTreeXML5 = mTreeXML.clone();
		
		mTreeXML.setName("mTreeXML1");
		mTreeXML2.setName("mTreeXML2");
		mTreeXML3.setName("mTreeXML3");
		mTreeXML4.setName("mTreeXML4");
		mTreeXML5.setName("mTreeXML5");
		
		System.out.println( mTreeXML );
		
		mTreeXML.getBody().getNodos().get(1).setEdad(17);
		System.out.println( mTreeXML );
		System.out.println( mTreeXML2 );
		System.out.println( mTreeXML3 );
		System.out.println("##");
		
		
	}
}

interface CheckRule{
	
	public default void check( Node node ) {};
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