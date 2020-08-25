import java.util.ArrayList;
//Create by Adillah at 24/08/2020

public class InstructorDB {

	public static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();

	public static void addInstructor(Instructor instructor) {

		instructorList.add(instructor);

	}

	public static String removeInstructor(String name) {
		String message = "Delete unsuccessful";
		for(int i = 0;i< instructorList.size(); i++) {
			if(instructorList.get(i).getName().equals(name)) {
				instructorList.remove(i);
				message = "Delete successful";
			}
			
		}
		return message;
	}

	public static String viewAllInstructors() {
		String output = "";
		if(instructorList.size() == 0) {
			output = "Instructor list is empty";
		}else {
			output = String.format("%-15s %-15s\n", "NAME","EMAIL");
			
			for(Instructor i: instructorList) {
				
				String name = i.getName();
				String email = i.getEmail();
				output+=String.format("%-15s %-15s\n", name,email);
		      
			}
		
	}
		return output;
	}

	public static String updateInstructorDetails(String name, String email, String password) {
		String message = "Update unsuccessful";
		for (Instructor i : instructorList) {
			if (name.equals(i.getName())) {
				i.setEmail(email);
				i.setPassword(password);
				message = "Update successful";
			}
		}return message;
	}
	
	
	
	
	
	
}