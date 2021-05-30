package Application;

import java.util.ArrayList;

public class Municipalité extends Donateur{
	
	private MessagerieMunicipalité MessagerieMunicipalité;
	
			public void donner(float don, Association association) {
				association.getCagnotte().AjoutMontant(don);
			}

}
