package fabrik;

import java.io.IOException;

import business.Freizeitbad;

public abstract class Product {
public abstract void fuegeInDateiHinzu(Freizeitbad object) throws  IOException;
public abstract void schlie�eDatei() throws IOException;
}
