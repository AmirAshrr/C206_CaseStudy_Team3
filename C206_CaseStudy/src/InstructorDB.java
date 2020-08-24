import java.util.ArrayList;

public class InstructorDB {

	public static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();

	public static void addInstructor(Instructor instructor) {

		instructorList.add(instructor);

	}

	public static void removeInstructor(Instructor instructor) {

		instructorList.remove(instructor);

	}

	public static String viewAllInstructor() {

		String output = ""; // empty string

		if (instructorList.size() == 0) {

			output = "Instructor information is not displayed";

		} else {

		}

		return output;

	}

	public static void updateInstructorDetails(String name, String email, String password) {

		for (Instructor i : instructorList) {

			if (name.equals(i.getName())) {

				i.setEmail(email);
				i.setPassword(password);

			}
		}

		
		
	}
	
	public static ArrayList<CCA> CCAList = new ArrayList<CCA>();
	
	
	
	
}  // end of class 
