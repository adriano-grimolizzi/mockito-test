package main;

public class App {

	public static void main(String[] args) {

		WizardController controller = new WizardController(new WizardService());
		
		controller.getWizardList().stream().forEach(System.out::println);
	}
}
