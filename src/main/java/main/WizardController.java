package main;

import java.util.List;

import exceptions.CreateWizardException;
import exceptions.WizardNotFoundException;
import model.Wizard;

public class WizardController {
	
	private Service<Wizard> service;
	
	public WizardController(Service<Wizard> service) {
		this.service = service;
	}
	
	public List<Wizard> getWizardList() {
		return this.service.getAll();
	}
	
	public Wizard getWizardById(int id) throws WizardNotFoundException {
		return this.service.get(id);
	}
	
	public void createWizard(Wizard wizard) throws CreateWizardException {
		this.service.create(wizard);
	}
}
