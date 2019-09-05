package main;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import exceptions.CreateWizardException;
import exceptions.WizardNotFoundException;
import model.House;
import model.Wizard;

@RunWith(MockitoJUnitRunner.class)
public class WizardControllerTest {
	
	@InjectMocks
	private WizardController controller;
	@Mock
	private Service<Wizard> service;
	
	private final String WIZARD_1_NAME = "Ernie";
	private final String WIZARD_1_SURNAME = "MacMillan";
	private final House WIZARD_1_HOUSE = House.HUFFLEPUFF;
	
	private final String WIZARD_2_NAME = "Penelope";
	private final String WIZARD_2_SURNAME = "Clearwater";
	private final House WIZARD_2_HOUSE = House.RAVENCLAW;
	
	private final int WIZARD_3_ID = 1;
	private final String WIZARD_3_NAME = "Hannah";
	private final String WIZARD_3_SURNAME = "Abbott";
	private final House WIZARD_3_HOUSE = House.HUFFLEPUFF;
	
	private final int NON_EXISTING_WIZARD_ID = 0;
	
	@Test(expected = CreateWizardException.class)
	public void shouldThrowCreateWizardException() throws CreateWizardException {
		
		doThrow(CreateWizardException.class)
				.when(this.service)
				.create(any(Wizard.class));
		
		Wizard wizard = new Wizard(WIZARD_3_NAME, WIZARD_3_SURNAME, WIZARD_3_HOUSE);
		this.controller.createWizard(wizard);
	}
	
	@Test(expected = WizardNotFoundException.class)
	public void shouldReturnWizardNotFoundException() throws WizardNotFoundException {
		
		doThrow(WizardNotFoundException.class)
				.when(this.service)
				.get(any(int.class));
		
		this.controller.getWizardById(NON_EXISTING_WIZARD_ID);
	}
	
	@Test
	public void shouldGetWizardById() throws WizardNotFoundException {
		
		when(this.service.get(WIZARD_3_ID))
				.thenReturn(new Wizard(WIZARD_3_NAME, WIZARD_3_SURNAME, WIZARD_3_HOUSE));
		
		Wizard wizard = this.controller.getWizardById(WIZARD_3_ID);
		
		assertTrue(wizard.getName().equals(WIZARD_3_NAME));
		assertTrue(wizard.getSurname().equals(WIZARD_3_SURNAME));
		assertTrue(wizard.getHouse().equals(WIZARD_3_HOUSE));
	}
	
	@Test
	public void shouldGetWizardList() {
		when(this.service.getAll())
				.thenReturn(this.getMockWizardList());
		
		List<Wizard> wizardList = this.controller.getWizardList();
		
		assertTrue(wizardList.size() == getMockWizardList().size());
		
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
