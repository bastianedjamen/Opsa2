package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import obs.Observer;

public class SportstaettenControl implements Observer{
	private FreizeitbaederModel model;
	private SportstaettenView spview;
	
	
	public SportstaettenControl(Stage primarystage) {
		this.model =  FreizeitbaederModel.getTheinstance();
		this.spview = new  SportstaettenView(this , primarystage , model);
		model.addObserver(this);
	}


	@Override
	public void update() {
		spview.zeigeFreizeitbaederAn();
		
	}

}
