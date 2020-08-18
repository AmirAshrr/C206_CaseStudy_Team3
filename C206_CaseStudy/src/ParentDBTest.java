import java.util.ArrayList;

public class ParentDBTest {
	
	public static ArrayList<ParentTest> parentList = new ArrayList<ParentTest>();
	
	public static void addParent(ParentTest parent) {
		parentList.add(parent);
		
	}

	public static void removeParent(ParentTest parent) {
		parentList.remove(parent);
	}

	public static String viewAllParents() {
		String output = "";
		if (parentList.size() == 0) {
			output = "Parent information not found";	
		}
		else {
			for (int i = 0; i < parentList.size(); i++) {
			output = String.format("%-10s %-20s %-20s %-10d", parentList.get(i).getName(), parentList.get(i).getEmail(), parentList.get(i).getAddress(), parentList.get(i).getContact_num());
			}
		}
		return output;
	}
}
