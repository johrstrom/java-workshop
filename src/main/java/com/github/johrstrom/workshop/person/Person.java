package com.github.johrstrom.workshop.person;

/**
 * A very simple representation of a person. Fields are age, which is a double (mostly just to have that type)
 * height in centimeters, weight in kilograms and hair color which is a free form string.
 * 
 * @author jeff ohrstrom
 *
 */
public class Person {
	
	private double age;
	private int height;
	private int weight;
	private String hairColor;
	
	/**
	 * Default constructor sets everything to 0 and hair color to the empty string.
	 */
	public Person() {
		this(0,0,0,"");
	}
	
	public Person(double age, int height, int weight, String hairColor) {
		this.setAge(age);
		this.setHeight(height);
		this.setWeight(weight);
		this.setHairColor(hairColor);
	}
	
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getAge() {
		return age;
	}
	
	public void setAge(double age) {
		this.age = age;
	}
	 

	/**
	 * A very poorly written function to return this object in json format. 
	 * 
	 * @return a json representation of this object
	 */
	public String toJsonString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{").append("\"age\": ").append(this.getAge()).append(", ");
		sb.append("\"height\": ").append(this.getHeight()).append(", ");
		sb.append("\"weight\": ").append(this.getWeight()).append(", ");
		sb.append("\"haircolor\": \"").append(this.getHairColor()).append("\"").append("}");
		
		return sb.toString();
	}

	/**
	 * Two Person objects are equal iff they have the same age, hair color,
	 * height and weight. 
	 * 
	 * @param other 
	 * @return true iff they're equal as stated above. false otherwise
	 */
	public boolean equals(Person other) {
		return this.getAge() == other.getAge() &&
				this.getHairColor().equals(other.getHairColor()) &&
				this.getHeight() == other.getHeight() &&
				this.getWeight() == other.getWeight();
	}
	
	
	
}
