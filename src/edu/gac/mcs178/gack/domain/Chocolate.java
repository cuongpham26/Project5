package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility; 


public class Chocolate extends Thing {
	public Chocolate(String name) {
		super(name);
	}
	
	//beEaten method 
	public void beEaten(){
		Person owner = getOwner();
		//if chocolate doesn't have an owner
		if (owner==null) {
			Utility.displayMessage("No one has " + getName()); 
			return;
		}	
		Place ownerPlace=owner.getPlace(); 
		owner.lose(this); //owner looses chocolate 
		ownerPlace.lose(this); //gone from owners place
		Utility.displayMessage(owner.getName()+" has eaten the " + getName()); 
  } 
	//method that stores and returns a players list of chocolate
	public static List<Chocolate> chocolateList(Person person) {
		ArrayList<Chocolate> chocolateAvailable = new ArrayList<Chocolate>();
		for (Thing thing : person.getPossessions()) {
			if (thing instanceof Chocolate) {
				chocolateAvailable.add((Chocolate) thing);
			}
		}
		return chocolateAvailable; 
	}
} 

