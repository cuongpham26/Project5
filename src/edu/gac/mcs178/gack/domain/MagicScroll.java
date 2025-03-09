package edu.gac.mcs178.gack.domain;

public abstract class MagicScroll extends Scroll {
	
	private int chargeNumber;
	private String actualTitle; // store the actual title 
	
	public MagicScroll(String name, int chargeNumber){
		super("a mysterious scroll");
		this.actualTitle = name;
		this.chargeNumber = chargeNumber;
	}
	
	public abstract void doMagic(); 
	
	@Override
	public void beRead() {
		// for charge number of times, call doMagic() when reading
		if (this.chargeNumber > 0) {
			this.doMagic();
			--chargeNumber;
		} else {
			super.beRead();
		}
		this.setName(actualTitle); // reveal name
	}
}
