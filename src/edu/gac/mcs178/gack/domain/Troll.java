package edu.gac.mcs178.gack.domain;
import java.util.List;
import edu.gac.mcs178.gack.Utility;

public class Troll extends AutoPerson{ 
		
		private Place pond;
		
		public Troll(String name, Place place, int threshold) {
			super(name, place, threshold);
			//this.pond = pond;
		}

		@Override
		public void act() {
			List<Person> others = otherPeopleAtSamePlace();
			if (!others.isEmpty()) {
				Person victim = others.get(Utility.randInt(others.size()));
				//get the list of chocolates a victim has 
				List<Chocolate> chocolates = Chocolate.chocolateList(victim);
				if(!(chocolates.isEmpty())) { 
					say("I am going to take " + victim.getName() + "'s chocolate"); 
					//take and eat victims chocolate
					for (Chocolate chocolate : chocolates) {
						victim.lose(chocolate);
						this.take(chocolate); 
						this.eat(chocolate);
						return; 
					}
				}
				
			} else {
				super.act();
			}
		}

}

