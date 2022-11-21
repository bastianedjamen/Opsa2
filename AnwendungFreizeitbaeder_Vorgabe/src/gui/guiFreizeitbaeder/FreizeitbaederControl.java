package gui.guiFreizeitbaeder;

import java.io.IOException;

import business.Freizeitbad;
import business.FreizeitbaederModel;
import javafx.stage.Stage;
import obs.Observer;
import ownUtil.PlausiException;

public class FreizeitbaederControl implements Observer {
	private FreizeitbaederModel model;
	private FreizeitbaederView view;
	
	
	public FreizeitbaederControl(Stage primarystage) {
		this.model =  FreizeitbaederModel.getTheinstance();
		this.view = new FreizeitbaederView(this , primarystage , model);
		model.addObserver(this);
		
	}
	public void nehmeFreizeitbadAuf(String name, String von, String bis, String laenge, String temperatur)
    {
    	try{
    		model.setFreizeitbad(new Freizeitbad(name, von, bis, laenge, temperatur));
            model.notifyObserver();
//    		view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
       	}
       	catch(PlausiException exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
     	}
    }
	
	void schreibeFreizeitbaederInDatei(String typ)  {
		try {
			if("csv".equals(typ)) {
				model.schreibeFreizeitbaederInCsvDatei();
				view.zeigeInformationsfensterAn("Die CsvFreizeitbäder wurden gespeichert!");
			}
			else if ("txt".equals(typ)) {
				model.schreibeFreizeitbaederInTxtDatei();
				view.zeigeInformationsfensterAn("Die TxtFreizeitbäder wurden gespeichert!");
			}
			else {
				view.zeigeInformationsfensterAn("noch nicht implementiert");
			}
		}
		catch(IOException exc) {
			view.zeigeFehlermeldungsfensterAn("Exception", "IOException beim speichern");
			
		}
		catch(Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Speichungsfehler", "Unbekannter Fehler beim Speichern!");
		}
		
		
		
	}
	@Override
	public void update() {
		view.zeigeFreizeitbaederAn();
		
	}
	
	
	

}
