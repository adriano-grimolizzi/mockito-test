package main;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.House;
import model.Wizard;

public class WizardControllerTest {
	
//	To unit test the controller, we must mock the service.	
	private WizardService service;

	private WizardController controller;
	
	private final String WIZARD_1_NAME = "Ernie";
	private final String WIZARD_1_SURNAME = "Ernie";
	private final House WIZARD_1_HOUSE = House.HUFFLEPUFF;
	
	private final String WIZARD_2_NAME = "Penelope";
	private final String WIZARD_2_SURNAME = "Clearwater";
	private final House WIZARD_2_HOUSE = House.RAVENCLAW;	
	
	@Before
	public void init() {
		
		this.service = mock(WizardService.class);
		this.controller = new WizardController(this.service);
		
		when(this.service.getWizardList()).thenReturn(getMockWizardList());
	}
	
	@Test
	public void shouldGetWizardList() {
		List<Wizard> wizardList = this.controller.getWizardList();
		
		assertTrue(wizardList.size() == 2);
		
		assertTrue(wizardList.get(0).getName().equals(WIZARD_1_NAME));
		assertTrue(wizardList.get(0).getSurname().equals(WIZARD_1_SURNAME));
		assertTrue(wizardList.get(0).getHouse().equals(WIZARD_1_HOUSE));
		
		assertTrue(wizardList.get(1).getName().equals(WIZARD_2_NAME));
		assertTrue(wizardList.get(1).getSurname().equals(WIZARD_2_SURNAME));
		assertTrue(wizardList.get(1).getHouse().equals(WIZARD_2_HOUSE));
	}
	
	private List<Wizard> getMockWizardList() {
		List<Wizard> wizardList = new ArrayList<>();
		wizardList.add(new Wizard(WIZARD_1_NAME, WIZARD_1_SURNAME, WIZARD_1_HOUSE));
		wizardList.add(new Wizard(WIZARD_2_NAME, WIZARD_2_SURNAME, WIZARD_2_HOUSE));
		return wizardList;
	}
}
