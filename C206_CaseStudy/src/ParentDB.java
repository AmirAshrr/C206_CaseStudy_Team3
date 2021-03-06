import java.util.ArrayList;
import java.util.Random;

public class ParentDB {
	// Create by OngJunJie at 24/08/2020	
	public static ArrayList<Parent> parentList = new ArrayList<Parent>();
	
	public static void addParent(Parent parent) {
		parentList.add(parent);
		
	}

	public static void removeParent(Parent parent) {
		parentList.remove(parent);
	}

	public static String viewAllParents() {
		String output = String.format("%-10s %-20s %-30s %-20s %-20s\n", "Name", "Email" , "Address", "Contact Number", "Registration ID");
		if (parentList.size() == 0) {
			output = "Parent information not found";	
		}
		else {
			for (int i = 0; i < parentList.size(); i++) {
			output += String.format("%-10s %-20s %-30s %-20d %-20d\n", parentList.get(i).getName(),
					parentList.get(i).getEmail(), parentList.get(i).getAddress(), parentList.get(i).getContact_num(),
					parentList.get(i).getRegistration_ID());
			}
		}
		return output;
		//System.out.println(output);
	}

	public static Boolean checkEmail(String email) {
		Boolean valid_email = true;
		//for (int i = 0;i < parentList.size(); i++) {
			if (!email.contains("@")) {
				valid_email = false;
			}
			else {
				valid_email = true;
			}
		//}
		return valid_email;
	}

	public static String updateParent(String name, String email, String address, int number) {
		String output = "";
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getName().equalsIgnoreCase(name)) {
				parentList.get(i).setEmail(email);
				parentList.get(i).setAddress(address);
				parentList.get(i).setContact_num(number);
			}
			else {
				System.out.println("Parent details cannot be found");
			}
		}
		return output;
	}

	public static String parentGenerateID(String email) {
		String registration_id = "";
		String output = "";
		//int max_num = 9;
		Random rand = new Random();
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getEmail().equalsIgnoreCase(email)) {
				for (int num = 0; num <5; num++) {
					// Obtain a number from  0 - 9
					int random_num = rand.nextInt(10);
					registration_id += "" + random_num;
					//registration_id += random_num;
				}
				int registrationID = Integer.parseInt(registration_id) ;
				output += "Registration ID has been assigned!";
				parentList.get(i).setRegistration_ID(registrationID);

			}
			else if (!parentList.get(i).getEmail().equalsIgnoreCase(email)){
				output += "Email cannot be found!";
			}
		}
		return output;
	}

	public static String parentLogIn(String email, int registration_id, int studentId, String studentName) {
		String output = "";
			for (int i = 0; i <parentList.size(); i++) {
				if (parentList.get(i).getEmail().equalsIgnoreCase(email) && parentList.get(i).getRegistration_ID() == registration_id) {
					//output += "Log in successful!";
					for (int a = 0; a< StudentDB.studentList.size(); a++) {
						if (StudentDB.studentList.get(a).getId() == studentId && StudentDB.studentList.get(a).getName().equalsIgnoreCase(studentName)) {
							output += "Log in successful!";
						}
					}
				}
			}
		
		return output;
	}

	public static String registerStudent(int studentID, String ccaName) {
		String output = "";
		for (int i = 0; i < StudentDB.studentList.size(); i ++) {
			if (StudentDB.studentList.get(i).getId() == studentID) {
				output += "Student has successfully registered!";
			}
		}
		return output;
	}
	
	
}
