package Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Main 
{
	public static ArrayList<Arbres> getDataFromCSVFile(String csvFilePath)
	{
        String line = "";
        String[] data = null;
        String separator = ";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
    	ArrayList<Arbres> listearbre = new ArrayList<Arbres>();

        
        //Document data
        Integer idBase;
        String typeEmplacement;
        String domanialite;
        String arrondissement;
        String complementAdresse;
        String adresse;
        Integer idEmplacement;
        String libelleFrancais;
        String genre;
        String espece;
        String varieteOuCultivar;
        Integer circonferenceEnCm;
        Integer hauteurEnM;
        String stadeDeveloppement;
        Boolean remarquable;
        Float[] geographicalPoint2D = new Float[2];
        
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(csvFilePath), StandardCharsets.ISO_8859_1)) 
        {
        	//Read the first line
        	line = bufferedReader.readLine();
        	
        	//Get data from the line
        	data = line.split(separator, -1);
        	
        	if(data.length != 17)
        	{
        		System.out.println("[FileReader] The file at " + csvFilePath + " does not contain the right number of columns.");
        	}
        	
        	int i = 1;
        	
        	//Read the file line by line
            while ((line = bufferedReader.readLine()) != null)
            {
            	//Get data from the line
            	data = line.split(separator, -1);
            	
            	//Sort data
            	
            		//Get the base ID
	            	try
	        		{
	            		idBase = Integer.parseInt(data[0]);
	        		}
	        		catch (Exception exception)
	        		{
	        			idBase = null;
	        		}
            		
            		//Get the location type
            		typeEmplacement = data[1];
            		
            		//Get the domain
                	domanialite = data[2];
                
                	//Get the district
                	arrondissement = data[3];
                	
                	//Get the complementary address
                	complementAdresse = data[4];
                	
                	//data[5] is the number
                	
                	//Get the address
                	adresse = data[6];
                
                	//Get the location ID
                	try
	        		{
                		idEmplacement = Integer.parseInt(data[7]);
	        		}
	        		catch (Exception exception)
	        		{
	        			idEmplacement = null;
	        		}
                	
                	//Get the French name
                	libelleFrancais = data[8];
                	
                	//Get the genus
                	genre = data[9];
                	
                	//Get the specie
                	espece = data[10];
                	
                	//Get the variety
                	varieteOuCultivar = data[11];
                	
                	//Get the circumference (cm)
                	try
	        		{
                		circonferenceEnCm = Integer.parseInt(data[12]);
	        		}
	        		catch (Exception exception)
	        		{
	        			circonferenceEnCm = null;
	        		}
                	
                	//Get the height (m)
                	try
	        		{
                		hauteurEnM = Integer.parseInt(data[13]);
	        		}
	        		catch (Exception exception)
	        		{
	        			hauteurEnM = null;
	        		}
                	
                	//Get the development state
                	stadeDeveloppement = data[14];
                	
                	//Get whether the tree is remarquable or not
                	if(data[15].equals("OUI") || data[15].equals("oui"))
                	{
                		remarquable = true;
                	}
                	else
                	{
                		remarquable = false;
                	}
                	
                	//Get the geographical point
                	data = data[16].split(",", -1);
                	try
	        		{
                		geographicalPoint2D[0] = Float.parseFloat(data[0]);
	        		}
	        		catch (Exception exception)
	        		{
	        			geographicalPoint2D[0] = null;
	        		}
                	try
	        		{
                		geographicalPoint2D[1] = Float.parseFloat(data[1]);
	        		}
	        		catch (Exception exception)
	        		{
	        			geographicalPoint2D[1] = null;
	        		}
                
                    
                	Arbres arbre = new Arbres(idBase, adresse, libelleFrancais, genre, espece, circonferenceEnCm, 
                			hauteurEnM, stadeDeveloppement, remarquable, geographicalPoint2D);
                	listearbre.add(arbre);

            }
        } 
        catch (IOException exception) 
        {
            System.err.println(exception);
        }
        return listearbre;
	}

	
	public static void main(String[] args) 
	{	
		ArrayList<Arbres> listearbre = new ArrayList<Arbres>();
		ArrayList<Membre> listemembre = new ArrayList<Membre>();
		ArrayList<Donateur> listdonateur = new ArrayList<Donateur>();
		ArrayList<Messagerie> ListeMessagerie = new ArrayList<Messagerie>();
		Calendar date1 = Calendar.getInstance();		
		date1.set(30, 05, 2021);
		Cagnotte cagnotte = new Cagnotte(0.f);
		
		Personne personne1 = new Personne("Max", "M", "idk", date1);
		Personne personne2 = new Personne("Thomas", "M", "idk", date1);
		Personne personne3 = new Personne("Chien", "M", "idk", date1);

		listearbre = getDataFromCSVFile("donnees.csv");
		Association assoc = new Association(listemembre, listearbre, listdonateur, cagnotte);
		
		
		MessagerieAssociation MessagerieAssociation = new MessagerieAssociation("MessagerieAssociation");
		MessagerieMunicipalité MessagerieMunicipalité = new MessagerieMunicipalité("MessagerieMunicipalité");
		MessagerieEntreprises MessagerieEntreprises = new MessagerieEntreprises("MessagerieEntreprises");
		MessagerieSEV MessagerieSEV = new MessagerieSEV("MessagerieSEV");
		MessageriePersonne Messagerie1 = new MessageriePersonne("Message1");
		MessageriePersonne Messagerie2 = new MessageriePersonne("Message2");
		MessageriePersonne Messagerie3 = new MessageriePersonne("Message3");
		
		
		MessagerieMunicipalité.messagerieON();
		MessagerieAssociation.messagerieON();
		MessagerieEntreprises.messagerieON();
		MessagerieSEV.messagerieON();
		
		Municipalité municipalité = new Municipalité();
		ServiceEspaceVert SEV = new ServiceEspaceVert(MessagerieSEV, ListeMessagerie);
		Entreprises Entreprises = new Entreprises();
		SEV.setListeArbres(listearbre);
		
		SEV.AjoutListeMessagerie(MessagerieAssociation);
		SEV.AjoutListeMessagerie(Messagerie1);
		SEV.AjoutListeMessagerie(Messagerie2);
		SEV.AjoutListeMessagerie(Messagerie3);
		SEV.AjoutListeMessagerie(MessagerieEntreprises);
		
		assoc.AjoutMembre(personne1, assoc, date1);
		assoc.AjoutMembre(personne2, assoc, date1);
		assoc.AjoutMembre(personne3, assoc, date1);
		
		System.out.println(listemembre);
		
		assoc.ListetoMembre(0).Nominer(listearbre.get(1));
		assoc.ListetoMembre(0).Nominer(listearbre.get(2));
		assoc.ListetoMembre(0).Nominer(listearbre.get(3));
		assoc.ListetoMembre(0).Nominer(listearbre.get(4));
		assoc.ListetoMembre(0).Nominer(listearbre.get(6)); //Arbre déjà nominé => Message d'erreur

		assoc.ListetoMembre(1).Nominer(listearbre.get(1));
		assoc.ListetoMembre(1).Nominer(listearbre.get(2));
		assoc.ListetoMembre(1).Nominer(listearbre.get(3));
		assoc.ListetoMembre(1).Nominer(listearbre.get(4));
		assoc.ListetoMembre(1).Nominer(listearbre.get(6));
		//assoc.ListetoMembre(1).Nominer(listearbre.get(6)); //Mise à jour liste, car il en nomine 6
		
		assoc.ListetoMembre(2).Nominer(listearbre.get(1));
		assoc.ListetoMembre(2).Nominer(listearbre.get(2));
		assoc.ListetoMembre(2).Nominer(listearbre.get(3));
		assoc.ListetoMembre(2).Nominer(listearbre.get(4));
		assoc.ListetoMembre(2).Nominer(listearbre.get(5));
		

		System.out.println(assoc.ListetoMembre(0).getNomination());
		System.out.println(assoc.ListetoMembre(1).getNomination());
		System.out.println(assoc.ListetoMembre(2).getNomination());
		
		System.out.println(assoc.ListeFinale(listemembre));
		
		
		SEV.setListeNomination(assoc.ListeFinale(listemembre));		
		
		System.out.println(SEV.getListeNomination());
		
		SEV.remarquable(SEV.getListeNomination(), ListeMessagerie);		
		
		System.out.println(listearbre.get(1).isremarquable());
		System.out.println(listearbre.get(2).isremarquable());
		System.out.println(listearbre.get(3).isremarquable());
		System.out.println(listearbre.get(92).isremarquable());
		
		SEV.Abattage(listearbre.get(3), ListeMessagerie);

		SEV.Plantation(listearbre.get(3), ListeMessagerie);

		/*
		System.out.println(assoc.getCagnotte().getMontant());
		municipalité.donner(500.f, assoc);
		System.out.println(assoc.getCagnotte().getMontant());

		System.out.println(listdonateur);
		assoc.AjoutDonateur(municipalité);
		assoc.AjoutDonateur(Entreprises);
		System.out.println(listdonateur);
		
		
		
		assoc.checkMemberCotise(listemembre);
		System.out.println(listemembre);
		
		MessagerieAssociation.MessageDon(MessagerieMunicipalité, 700.f);
		municipalité.donner(700.f, assoc);
		System.out.println(assoc.getCagnotte().getMontant());
		assoc.PayerFacture(500);
		System.out.println(assoc.getCagnotte().getMontant());		

		MessagerieAssociation.MessageDon(MessagerieMunicipalité, 100.f);
		MessagerieAssociation.MessageDon(MessagerieEntreprises, 200.f);

		SEV.Plantation(arbre7, ListeMessagerie);
		SEV.remarquable(listearbre, ListeMessagerie);


		arbre1.ajoutCompteRendu("Arbre en bon état", date1, assoc.getListeMembre().get(0));
		arbre1.getCompteRendu(date1);*/

	}		
}
