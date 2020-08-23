
public class Parent {
	private String name; 
	private String email;
	private String address;
	private int contact_num;
	private int registration_ID;
	
	public Parent(String name, String email, String address, int contact_num, int registration_ID) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact_num = contact_num;
		this.registration_ID = registration_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContact_num() {
		return contact_num;
	}

	public void setContact_num(int contact_num) {
		this.contact_num = contact_num;
	}
	
	public int getRegistration_ID() {
		return registration_ID;
	}

	public void setRegistration_ID(int registration_ID) {
		this.registration_ID = registration_ID;
	}
}
