
public class Category {
	private String ID; 
	private String name; 

	
public Category(String id, String name) {
	this.ID = ID;
	this.name = name; 
}

public String getID() {
	return ID;
	
}

public void setID(String id) {
	this.ID = ID; 
}

public String getName() {
	return name;
	
}

public String setName(String name) {
	return this.name = name;
}

public String toString() {
	String output = "";
	output += "ID: " + ID + "\n";
	output += "Name: " + name + "\n";
	return output;
}

}
