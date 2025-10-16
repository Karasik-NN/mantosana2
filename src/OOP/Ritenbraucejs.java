package OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Ritenbraucejs {
	
	

	public static void main(String[] args) {
String izvele;
int izvelesID;
String[]darbibas = {"Jauns ritenis","Noņemt riteni",
		"Riteņu saraksts","Kārtot pēc cenas","Izsaukt metode",
		"Aizvērt programmu"};
String[]veidi = {"Velosipēds", "Kalnu Velosipēds",
		"Bernu velosipēds"};
String[]atbilde = {"Jā", "Nē"};
ArrayList<Object>riteni = new ArrayList<>();
do {
	izvele = (String)JOptionPane.showInputDialog(null,
			"Izvelies darbibu","Izvelne",JOptionPane.QUESTION_MESSAGE,
			null,darbibas, darbibas[0]);	
	
	if(izvele == null)
		break;
	
	izvelesID = Arrays.asList(darbibas).indexOf(izvele);
	
	switch(izvelesID) {
	case 0:
		izvele = (String)JOptionPane.showInputDialog(null,
				"Izvelies velosipēdu veidu","Izvelne",JOptionPane.QUESTION_MESSAGE,
				null,veidi, veidi[0]);	
		
		izvelesID = Arrays.asList(veidi).indexOf(izvele);	
		String razotajs = Metodes.virknesParbaude("Norādi ritēņa ražotaju","Rockmachine");
				
		double cena =
				Metodes.skaitlaParbaude("Cik maksā ritenis", 1.00, 9999.99);
		
		double diametrs = 
				Metodes.skaitlaParbaude("Kāds ir diametrs riteņam? ", 12, 26);
				
		int sedPoz = Metodes.iestatitSedekli();
		
		//veido parasto riteni
		if (izvelesID == 0) {
			riteni.add(new Velosipeds((int)diametrs, sedPoz, cena, razotajs));
			JOptionPane.showMessageDialog(null,"Veiksimi izveidots jauns ritenis!","Pazinojums",
					JOptionPane.INFORMATION_MESSAGE);
			
			//veido kalnu riteni
					}else if(izvelesID == 1) {
						int iestatAtr = Metodes.iestatitAtrumu();
						
						
						izvele = (String)JOptionPane.showInputDialog(null,
								"Vai ritenim ir papildus amortizācija", "Izvēle",
								JOptionPane.QUESTION_MESSAGE,null,atbilde,atbilde[0]);
						
						
						if(izvele == null)
							
							izvelesID = Arrays.asList(atbilde).indexOf(izvele);
						boolean atsperes = (izvelesID == 0)? true : false;
						
						riteni.add(new KauluRitenis(iestatAtr,atsperes,(int)diametrs,sedPoz,
								cena, razotajs));
					}else if (izvelesID == 2) {
                    izvele = (String)JOptionPane.showInputDialog(null,
                    		"Vai ritenim ir paligriteni", "Izvēle",
                    		JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
                    if(izvele == null)
                    	break;
                    
                    izvelesID = Arrays.asList(atbilde).indexOf(izvele);
                    boolean paligRit = (izvelesID == 0)? true : false; 
                    
                    izvele = (String)JOptionPane.showInputDialog(null,
                    		"Vai  ir zvanins", "Izvēle",
                    		JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
                    if(izvele == null)
                    	break;
                    
                    izvelesID = Arrays.asList(atbilde).indexOf(izvele);
                    boolean zvanins = (izvelesID == 0)? true : false; 
                    
                    riteni.add(new BernuRitenis(
            				paligRit, zvanins,
                           (int)diametrs , sedPoz, cena, razotajs));
            		break;
                    		}
			
	case 1:
		if(riteni.size()> 0) {
			int ritID = Metodes.ritenaIzvele(riteni);
			
		}else {
			JOptionPane.showMessageDialog(null,
					"Sarakstā nav neviens ritenis!", "Bridinajums",
					JOptionPane.WARNING_MESSAGE);
			
		}
				break;
	}

		
	
	
}while(izvelesID != 5);

	}

}

