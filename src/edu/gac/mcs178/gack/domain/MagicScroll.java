package edu.gac.mcs178.gack.domain;

public abstract class MagicScroll extends Scroll {
	
	private int chargeNumber;	
	public MagicScroll(String name, int chargeNumber){
		super(name);
		this.chargeNumber=chargeNumber;
	}
	
	public abstract void doMagic(); 
	
	@Override
	public void beRead() {
		//for charge number of times, call doMagic when reading
		if(this.chargeNumber>0) {
			this.doMagic();
			chargeNumber= chargeNumber-1;
		}else {
			super.beRead();
		}
	}
}
