package main;

import java.util.ArrayList;
import java.util.List;

import exceptions.CreateWizardException;
import exceptions.WizardNotFoundException;
import model.House;
import model.Wizard;

public class WizardService implements Service<Wizard>{
	
	List<Wizard> wizardList;
	
	public WizardService() {
		this.wizardList = new ArrayList<>();		
		this.wizardList.add(new Wizard("Harry", "Potter", House.GRYFFINDOR));
		this.wizardList.add(new Wizard("Draco", "Malfoy", House.SLYTHERIN));		
	}
	
	public List<Wizard> getAll() {
		return this.wizardList;
	}

	public Wizard get(int id) throws WizardNotFoundException {
		return this.wizardList.get(id);
	}

	public void create(Wizard wizard) throws CreateWizardException {
		this.wizardList.add(wizard);
	}
}
