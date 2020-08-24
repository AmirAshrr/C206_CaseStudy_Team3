import java.util.ArrayList;


public class CCADB {
	
public static ArrayList<CCA> CCAList = new ArrayList<CCA>();

	public static void addCCA(CCA cca) {


		CCAList.add(cca);
		
	}
	
	public static void showCCAMenu() {
		System.out.println("CCA Menu");
		Helper.line(30, "-");
		System.out.println("1. Add CCA");
		System.out.println("2. Delete CCA");
		System.out.println("3. Update CCA");
		System.out.println("4. View CCA");
		System.out.println("5. Quit");
		Helper.line(30, "-");
	}
	
	public static String viewAllCCA() {
		String output = "";
		if (CCAList.size() > 0) {
			output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n","TITLE", "DESCRIPTION", "CLASS SIZE", "WEEK", "TIME", "VENUE", "INSTRUCTOR NAME"); 
		
		for(int z = 0; z < CCAList.size(); z++) {
			output += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",CCAList.get(z).getTitle(), CCAList.get(z).getDescription(),CCAList.get(z).getClass_Size(), 
					CCAList.get(z).getWeek(),CCAList.get(z).gettime(),CCAList.get(z).getVenue(),CCAList.get(z).getInstructor_Name());  
		}	
	}
		
		else { 
			output = "CCA not found!";
		}
		
			return output;

	}

	public static CCA inputCCA() {
		String title = Helper.readString("Enter CCA Title: ");
		String description = Helper.readString("Enter CCA description: ");
		int class_size = Helper.readInt("Enter CCA class_size: ");
		String week = Helper.readString("Enter CCA week: ");
		String time = Helper.readString("Enter CCA time: ");
		String venue = Helper.readString("Enter CCA venue: ");
		String instructor_name = Helper.readString("Enter CCA Instructor Name: ");
		
		CCA ccac = new CCA(title, description, class_size, week, time, venue, instructor_name);
		return ccac;
		
	}
	
	public static String removeCCA(String remove) {
		boolean isTrue = false;
		String output = "";
		for (int z = 0; z < CCAList.size(); z ++) {
			if(CCAList.get(z).getTitle().equals(remove)) {
				CCAList.remove(z);
				isTrue = true;
			}
		}
		
		if(isTrue == false) {
			//System.out.println("CCA does not exist!");
			output += "CCA does not exist!";
		}
		
		else {
			//System.out.println("CCA removed!");
			output += "CCA removed!";
		}
		return output;
	}
	
	public static String addCCA(ArrayList<CCA> CCAList, CCA ccac) {
		String output = "";
		if((ccac.getClass_Size() <= 50) && (ccac.getWeek().equalsIgnoreCase("Monday")
				|| ccac.getWeek().equalsIgnoreCase("Tuesday") || ccac.getWeek().equalsIgnoreCase("Wednesday") || 
				ccac.getWeek().equalsIgnoreCase("Thursday") || ccac.getWeek().equalsIgnoreCase("Friday")))
		{
			CCAList.add(ccac);
			//System.out.println("CCA sucessfully added!");
			output += "CCA sucessfully added!";
		}
		
		else {
			//System.out.println("Invalid input!");
			output += "Invalid input!";
		}
		return output;
	}
	
	public static void updateCCADetails(String title, String description, int class_size, String week, String time, String venue,
			String instructor_name) {
		for(CCA i:CCAList) {
			if(title.equals(i.getTitle())) {
				i.setDescription(description);
				i.setClass_Size(class_size);
				i.setWeek(week);
				i.setTime(time);
				i.setVenue(venue);
				i.setInstuructor_Name(instructor_name);
				
			}
		}	 
		 

	}
}
