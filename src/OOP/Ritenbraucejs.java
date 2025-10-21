package OOP;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Ritenbraucejs {
	
	

	public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
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
            		
                    		}
		break;
			
	case 1:
		if(riteni.size()> 0) {
			int ritID = Metodes.ritenaIzvele(riteni);
			riteni.remove(ritID);
			JOptionPane.showMessageDialog(null,
					"Ritenis ir veiksmigi dzēsts!", "Bridinājums",
					JOptionPane.WARNING_MESSAGE);
			}else {
			JOptionPane.showMessageDialog(null,
					"Sarakstā nav neviens ritenis!", "Bridinajums",
					JOptionPane.WARNING_MESSAGE);
			
		}
		break;
		
		case 2:
			if(riteni.size() > 0) {
				String str = "Riteņu skaits: "+riteni.size()+
						"\n______________________________\n";
				for(int i=0;i<riteni.size();i++) {
					str +=((Velosipeds)riteni.get(i)).izvadit()+
							"\n______________________________\n";
				}
				String [] rSaraksts = new String[riteni.size()];
				
				for(int i=0; i<rSaraksts.length;i++) {
					rSaraksts[i]=
							(((Velosipeds)riteni.get(i)).noteiktRaz())+" "
									+(((Velosipeds)riteni.get(i)).noteiktCenu())+"EUR";
				}
				
				String izveletais = (String)JOptionPane.showInputDialog(null,
						"Riteņu saraksts", "Saraksts",
						JOptionPane.QUESTION_MESSAGE, null, rSaraksts, rSaraksts[0]);
			}else
				JOptionPane.showMessageDialog(null,"Nav neviena velosipeda sarakstā", "Bridīnajums",JOptionPane.WARNING_MESSAGE);
			
		
		break;		
		
		case 3:
			if(riteni.size()>0) {
				String atb = (String)JOptionPane.showInputDialog(null,
						"Kārtot riteņus pēc cenas augosi", "izvele",
						JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde [0]);
							
						if(atb != null) {
							if(atb.equals("Jā")) {
								riteni.sort(null);
								JOptionPane.showMessageDialog(null, "Riteni sakārtoti augoši!", "Kartošana",
										JOptionPane.INFORMATION_MESSAGE);
							}else { 
								riteni.sort(Collections.reverseOrder());
								JOptionPane.showMessageDialog(null,"Riteņi sakartoti dilstoši!", "Kārtošana",
										JOptionPane.INFORMATION_MESSAGE);
							}
							
							
						}else {
							break;
						}
			}
			break;
			
	
		case 4:
			
			if(riteni.size()>0) {
				int kurs = Metodes.ritenaIzvele(riteni);
				String[] metodes = {"Noteikt ritena izmeru","Iestatit sedekli",
						"Noteikt kustibas atrumu","Mities",
						"Bremzet","Noteikt iestatito atrumu",
						"Parslegt ātrumu", "Palīgriteņi", "Zviniņš"};
				
				izvele = (String)JOptionPane.showInputDialog(null,
						"Izvēlies metode", "Metodes izvēle",
						JOptionPane.QUESTION_MESSAGE, null, metodes, metodes[0]);
				
				if(izvele == null) {
					break;
				}
				izvelesID = Arrays.asList(metodes).indexOf(izvele);
				switch(izvelesID) {
				//
				case 0:
					break;
				case 1:
					break;
				case 2: 
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					if(riteni.get(kurs) instanceof BernuRitenis) {
						((BernuRitenis)riteni.get(kurs)).zvanitZvaninu();
					}else
						JOptionPane.showMessageDialog(null, "Šim riteņa veidam nav zvaniņš","Kļuda",
								JOptionPane.ERROR_MESSAGE);
					break;
					
				}
			}else {
				JOptionPane.showMessageDialog(null,
						"Sarakstā nav neviens ritenis!","Bridinājums",
						JOptionPane.WARNING_MESSAGE);

				}
			break;
			
	}

		
	
	
}while(izvelesID != 5);

	}

}

