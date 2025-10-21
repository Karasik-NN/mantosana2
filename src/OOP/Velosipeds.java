package OOP;

import java.util.Random;

public class Velosipeds implements Comparable<Velosipeds> {

	// Atribūti
	int ritenaD;
	private int sedeklaPoz;
	private double atrumsMS, cena;
	private String razotajs;
	private Random rand = new Random();
	
	
	//Konstruktors
	public Velosipeds(int diametrs,int sedeklaPoz, double cena, String razotajs) {
		this.ritenaD = diametrs;
		this.sedeklaPoz = sedeklaPoz;
		atrumsMS = kustiba();
		this.cena = cena;
		this.razotajs = razotajs;
		
	}
	
	//Metodes
	public int noteiktRitenaD() {
		return ritenaD;
	}
	
	public int noteiktSedeklaPoz() {
		return sedeklaPoz;
	}
	
	public String noteiktRaz() {
		return razotajs;
	}
	
	public double noteiktCenu() {
		return cena;
	}
		
	public double kustibasAtr() {
		return atrumsMS;
	}
	
	public double noteiktAtr() {
		return atrumsMS;
	}
		
	public double kustiba() {
		double celsM, laiksS;
		Random rand = new Random();
		celsM = rand.nextDouble()* (1000-1)+1;
		laiksS = rand.nextDouble()*(60-10)+10;
		return Math.round(celsM/laiksS);
	}
	
	public String izvadit() {
		return "Riteņa ražotājs: "+noteiktRaz()+
				"\nRiteņa cena: "+noteiktCenu()+" EUR"
				+"\nRiteņa lielums collās: "+noteiktRitenaD()
				+"\nIestatītais sēdekļa augstums"+noteiktSedeklaPoz()
				+"\nKustības ātrums: "+kustibasAtr()+"m/s";
	}
	
	public void iestatitSedeklaPoz(int pozicija) {
		sedeklaPoz = pozicija;
	}
	
	public void mities(int minienuSk) {
		atrumsMS += noteiktAtr()+(0.15 * minienuSk);
	}

	public void bremzet(int bremze) {
		if(noteiktAtr()>0) {
			atrumsMS -= (noteiktAtr()*0.55)* bremze;
			
			if(atrumsMS < 0)
				atrumsMS = 0;
		}
	}

	@Override
	public int compareTo(Velosipeds v) {
	    return Double.compare(this.noteiktCenu(), v.noteiktCenu());
	}
}
