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
		
		String output = "" ;
				
		if (instructorList.size() == 0 ) { 
			
			output = "Instructor information is not displayed";
		
		} else { 
			
		}
		
		return output; 
			
	}
}
