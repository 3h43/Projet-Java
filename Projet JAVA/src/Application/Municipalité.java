package Application;

import java.util.ArrayList;

public class Municipalit√© extends Donateur{
	
	private MessagerieMunicipalit√© MessagerieMunicipalit√©;
	
			public void donner(float don, Association association) {
				association.getCagnotte().AjoutMontant(don);
			}

}
