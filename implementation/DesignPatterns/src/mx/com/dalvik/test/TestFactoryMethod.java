package mx.com.dalvik.test;


interface IAnimal {
	public void speak();
}

class Duck implements IAnimal{
	
	@Override
	public void speak() {
		System.out.println("Duck.speak");
	}
}

class Tiger implements IAnimal{

	@Override
	public void speak() {
		System.out.println("Tiger.speak()");
		
	}
	
}

abstract class AnimalFactory {
	
	public abstract IAnimal getAnimalType( String type );
}

class ConcreteFactory extends AnimalFactory {

	@Override
	public IAnimal getAnimalType(String type) {
		
		IAnimal animal;
		
		if( type.equals("Duck" ) )
			animal = new Duck();
		else
			animal = new Tiger();
		
		return animal;
	}
	
}


public class TestFactoryMethod {

	public static void main(String[] args) {
		
		AnimalFactory animalFactory = new ConcreteFactory();
		
		IAnimal animal = animalFactory.getAnimalType("Duck");
		
		animal.speak();
		
	}
}
