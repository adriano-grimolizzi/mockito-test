package main;

import java.util.List;

import model.Wizard;

public class WizardController {
	
	private WizardService service;
	
	public WizardController(WizardService service) {
		this.service = service;
	}
	
	public List<Wizard> getWizardList() {
		return this.service.getWizardList();
	}
}
