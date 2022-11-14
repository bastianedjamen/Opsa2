package fabrik;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.Freizeitbad;

public class ConcreteTxtProduct extends Product{
private PrintWriter in;
	@Override
	public void fuegeInDateiHinzu(Freizeitbad object) throws IOException {
		in = new PrintWriter(new FileWriter("Freizeitbaeder.txt",true));
		in.println("Daten des Freizeitbades");
		in.println("Name des Freizeitbads:              " + object.getName() );
		in.println("�ffnungszeit des Freizeitbads:      " + object.getGeoeffnetVon() + "-" + object.getGeoeffnetBis());
		in.println("Beckl�nge des Freizeitsbad:         " + object.getBeckenlaenge());
		in.println("Wassertemperatur des Freizeitsbad:  " + object.getTemperatur());
		in.close();
		
		
	}

	@Override
	public void schlie�eDatei() throws IOException {
		in.close();
		
	}

}
