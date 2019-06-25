package main;

import java.util.List;

import exceptions.CreateWizardException;
import exceptions.WizardNotFoundException;

public interface Service<T> {
	
	public T get(int id) throws WizardNotFoundException;
	
	public List<T> getAll();
	
	public void create(T t) throws CreateWizardException;
}
