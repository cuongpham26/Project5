package edu.gac.mcs178.gack;

import edu.gac.mcs178.gack.domain.AutoPerson;
import edu.gac.mcs178.gack.domain.Chocolate;
import edu.gac.mcs178.gack.domain.Person;
import edu.gac.mcs178.gack.domain.Place;
import edu.gac.mcs178.gack.domain.Scroll;
import edu.gac.mcs178.gack.domain.ScrollOfTeleportation;
import edu.gac.mcs178.gack.domain.Thing;
import edu.gac.mcs178.gack.domain.Troll;
import edu.gac.mcs178.gack.domain.Witch;
import edu.gac.mcs178.gack.domain.Wizard;

public class GackWorld extends World {
	
	public GackWorld() {
		super();
		Place foodService = new Place("Food Service");
		Place po = new Place("Post Office");
		Place alumniHall = new Place("Alumni Hall");
		Place chamberOfWizards = new Place("Chamber of Wizards");
		Place library = new Place("Library");
		Place goodShipOlin = new Place("Good Ship Olin");
		Place lounge = new Place("Lounge");
		Place computerLab = new Place("Computer Lab");
		Place offices = new Place("Offices");
		Place dormitory = new Place("Dormitory");
		Place pond = new Place("Pond"); 
		
		foodService.addNewNeighbor("down", po);
		po.addNewNeighbor("south", alumniHall);
		alumniHall.addNewNeighbor("north", foodService);
		alumniHall.addNewNeighbor("east", chamberOfWizards);
		alumniHall.addNewNeighbor("west", library);
		chamberOfWizards.addNewNeighbor("west", alumniHall);
		chamberOfWizards.addNewNeighbor("south", dormitory);
		dormitory.addNewNeighbor("north", chamberOfWizards);
		dormitory.addNewNeighbor("west", goodShipOlin);
		library.addNewNeighbor("east", library);
		library.addNewNeighbor("south", goodShipOlin);
		goodShipOlin.addNewNeighbor("north", library); 
		goodShipOlin.addNewNeighbor("east", dormitory);
		goodShipOlin.addNewNeighbor("up", lounge);
		lounge.addNewNeighbor("west", computerLab);
		lounge.addNewNeighbor("south", offices);
		computerLab.addNewNeighbor("east", lounge);
		offices.addNewNeighbor("north", lounge); 
		
		new Troll("Max", po, 2); 
		new AutoPerson("Karl", computerLab, 4); 
		new Witch("Barbara", offices, 3, pond);
		new Wizard("Elvee", offices, 1, chamberOfWizards);
		//adding chocolate to food service
		foodService.gain(new Chocolate("Snickers"));
		foodService.gain(new Chocolate("Hersheys"));
		foodService.gain(new Chocolate("Kitkat")); 
		
		lounge.gain(new Thing("Karl's glasses"));
		//adding Magicscrolls
		po.gain(new ScrollOfTeleportation("Secret Letter",2));
		
		
		library.gain(new Scroll("Scroll of Enlightenment"));
		String[] someTitles = {"War and Peace", "Iliad", "Collected Works of Rilke"};
		for (String title : someTitles) {
			library.gain(new Scroll(title));
		}
		computerLab.gain(new Scroll("Unix Programmers Manual"));
		computerLab.gain(new Scroll("NeXT User's Reference"));
		//added a new scroll
		dormitory.gain(new Scroll("late lab report"));
		setPlayer(new Person("player", foodService));
	}
}
