package edu.gac.mcs178.gack.domain;

import edu.gac.mcs178.gack.Utility;

public class ScrollOfTeleportation extends MagicScroll {

	public ScrollOfTeleportation(String name, int chargeNumber) {
		super(name, chargeNumber);
	}

	@Override
	public void doMagic() {
		Person owner = getOwner();
		Utility.displayMessage("Abracadabra, I can see you are trying to hide at " + owner.getPlace().getName());
	}
	

}
