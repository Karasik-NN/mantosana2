package OOP;


public class KauluRitenis extends Velosipeds {
private int iestatAtrums;
private boolean atsperes;

public KauluRitenis(int iestatAtrums, boolean atsperes, int ritenaD, int sedeklaPoz,
		double cena, String razotajs) {
	super(ritenaD, sedeklaPoz, cena, razotajs);
	this.iestatAtrums = iestatAtrums;
	this.atsperes = atsperes;
}

public int noteiktIestatAtr() {
	return iestatAtrums;
}

public void parslegtAtr(int atr) {
	iestatAtrums = atr;
	
}

public String izvadit() {
	return "Riteņa ražotājs: "+noteiktRaz()+
			"\nRiteņa cena: "+noteiktCenu()+" EUR"
			+"\nRiteņa lielums collās: "+noteiktRitenaD()
			+"\nIestatītais sēdekļa augstums"+noteiktSedeklaPoz()
			+"\nKustības ātrums: "+noteiktAtr()+"m/s"
			+"\nIestatītais ātrums: "+noteiktIestatAtr()
			+"\nPapildus amortizācija: "+((atsperes)? "Ir" : "Nav");
}
}
