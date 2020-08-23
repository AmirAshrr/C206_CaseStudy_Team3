import java.util.ArrayList;
public class CategoryDB {
	
public static ArrayList<Category> categoryList = new ArrayList<>();
	
	public static void addCategory(Category category) {
		
	}
	
public static String viewAllCategory() {
		String output = "";
		for(int i = 0; i < categoryList.size(); i++) {
			output += "ID: " + categoryList.get(i).getID() + "\n"; 
			output += "Name: " + categoryList.get(i).getName() + "\n"; 
			
		}
		
		return output;
	}
	
public static void removeCategory(String ID) {
		for (int i = 0; i < categoryList.size(); i ++) {
			if(categoryList.get(i).getID().equalsIgnoreCase(ID)) {
				categoryList.remove(i);
				break;
			}
		}
		
		return;
	}

public static void updateCategoryDetails(String ID, String name) {
			for(Category i:categoryList) {
				if(ID.equals(i.getID())) {
					i.setName(name);
					
				}
			}
	}
}
