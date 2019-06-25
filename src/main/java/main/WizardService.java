package main;

import java.util.ArrayList;
import java.util.List;

import model.House;
import model.Wizard;

public class WizardService {
	
	List<Wizard> wizardList;
	
	public WizardService() {
		this.wizardList = new ArrayList<>();		
		this.wizardList.add(new Wizard("Harry", "Potter", House.GRYFFINDOR));
		this.wizardList.add(new Wizard("Draco", "Malfoy", House.SLYTHERIN));		
	}
	
	public List<Wizard> getWizardList() {
		return this.wizardList;
	}

}
