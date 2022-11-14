package fabrik;

public  class ConcreteTxtCreator extends Creator{

	@Override
	public Product factorymethod() {
		// TODO Auto-generated method stub
		return new ConcreteTxtProduct();
	}

}
