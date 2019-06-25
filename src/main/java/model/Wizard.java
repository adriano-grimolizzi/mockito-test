package model;

public class Wizard {	
	private String name;
	private String surname;
	private House house;
	
	public Wizard(String name, String surname, House house) {
		this.setName(name);
		this.setSurname(surname);
		this.setHouse(house);
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "Wizard [name=" + name + ", surname=" + surname + ", house=" + house.getName() + "]";
	}
	
}
