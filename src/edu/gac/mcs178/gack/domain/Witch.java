package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Witch extends AutoPerson {
	
	private Place pond;
	
	public Witch(String name, Place place, int threshold, Place pond) {
		super(name, place, threshold);
		this.pond = pond;
	}

	@Override
	public void act() {
		List<Person> others = otherPeopleAtSamePlace();
		if (!others.isEmpty()) {
			Person victim = others.get(Utility.randInt(others.size()));
			say("I am going to attack " + victim.getName()); 
			//get the list of chocolates a victim has 
			
			List<Chocolate> chocolates = Chocolate.chocolateList(victim);
			if(chocolates.isEmpty() || !this.getName().equals("Barbara")) { 
				curse(victim); 
			}
			//take and eat victims chocolate
			for (Chocolate chocolate : chocolates) {
				victim.lose(chocolate);
				this.take(chocolate); 
				this.eat(chocolate);
				return; 
			}
		} else {
			super.act();
		}
	}

	public void curse(Person person) {
		say("Hah hah hah, I'm going to turn you into a frog, " + person);
		turnIntoFrog(person);
		say("Hee hee " + person + " looks better in green!");
	}
	
	public void turnIntoFrog(Person person) {
		// need to copy person.getPossessions() in order to avoid a ConcurrentModificationException
		List<Thing> personsPossessions = new ArrayList<Thing>(person.getPossessions());
		for (Thing thing : personsPossessions) {
			person.lose(thing);
		}
		person.say("Ribbitt!");
		person.moveTo(pond);
	}
}
