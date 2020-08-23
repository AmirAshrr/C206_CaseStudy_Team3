import java.util.ArrayList;

public class CCADB {
	
	public static ArrayList<CCA> CCAList = new ArrayList<CCA>();

	public static void addCCA(CCA cca) {


		CCAList.add(cca);
		
	}
	

	
		  
	public static void removeCCA(CCA cca) {
		CCAList.remove(cca);
	}




	public static String viewAllCCA() {
		
		String output = "";
		if (CCAList.size() == 0) {
			output = "CCA information is not displayed";
		} else { 
		}
		
		return output;
	}

	
	
}
