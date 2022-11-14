package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;



public class ConcreteProduct extends Product{
	private BufferedWriter aus;

	@Override
	public void fuegeInDateiHinzu(Freizeitbad object) throws IOException {
		
		aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv",true));
		aus.write(object.gibFreizeitbadZurueck(';'));
		aus.close();
		
	}

	@Override
	public void schlieﬂeDatei() throws IOException {
		aus.close();
		
	}

}
