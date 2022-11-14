package business;




import fabrik.ConcreteCreator;
import fabrik.ConcreteTxtCreator;
import fabrik.Creator;
import fabrik.Product;

public class FreizeitbaederModel {
	   // speichert temporaer ein Objekt vom Typ Freizeitbad
    private Freizeitbad freizeitbad;
	
	
	

	public FreizeitbaederModel() {
		
	}
	
	public String getueberschrift() {
		return "Verwaltung von Freizeitbädern";
	}
	
	
	public void schreibeFreizeitbaederInCsvDatei() throws Exception {
		Creator creatorwriter = new ConcreteCreator();
		Product writer = creatorwriter.factorymethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schließeDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws Exception {
		Creator creatorwriter = new ConcreteTxtCreator();
		Product writer = creatorwriter.factorymethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
     	writer.schließeDatei();
	}
	
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}


	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}

	


}
