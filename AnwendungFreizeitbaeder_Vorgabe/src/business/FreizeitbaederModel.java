package business;




import java.util.Vector;

import fabrik.ConcreteCreator;
import fabrik.ConcreteTxtCreator;
import fabrik.Creator;
import fabrik.Product;
import obs.Observable;
import obs.Observer;

public class FreizeitbaederModel implements Observable {
	   // speichert temporaer ein Objekt vom Typ Freizeitbad
    private Freizeitbad freizeitbad;
	private static FreizeitbaederModel theinstance;
	private Vector<Observer> observers = new Vector<Observer>();
	

	private FreizeitbaederModel() {
		
	}
	
	public static FreizeitbaederModel getTheinstance() {
		if(theinstance==null) {
			theinstance = new FreizeitbaederModel();
		}
		return theinstance;
	}
	
	public String getueberschrift() {
		return "Verwaltung von Freizeitb‰dern";
	}
	
	
	public void schreibeFreizeitbaederInCsvDatei() throws Exception {
		Creator creatorwriter = new ConcreteCreator();
		Product writer = creatorwriter.factorymethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schlieﬂeDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws Exception {
		Creator creatorwriter = new ConcreteTxtCreator();
		Product writer = creatorwriter.factorymethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
     	writer.schlieﬂeDatei();
	}
	
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}


	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
		
	}

	@Override
	public void notifyObserver() {
		for(int i=0; i< observers.size();i++) {
			observers.elementAt(i).update();
		}
		
	}

	


}
