package fabrik;

public class ConcreteCreator extends Creator {

	@Override
	public Product factorymethod() {
		// TODO Auto-generated method stub
		return new ConcreteProduct();
	}
	

}
