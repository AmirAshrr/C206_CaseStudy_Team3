import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CCATest {
	
	private CCA cca1;
	private CCA cca2;
	
	@Before
	public void setUp() throws Exception {
	

	
cca1 = new CCA("Soccer", "Intense", 20, "Tues", "2pm", "Field", "Leo");
cca2 = new CCA("Bakery", "Sweet", 15, "Wed", "3pm", "Kitchen", "Ho");
	
	
	}
	@After
	public void tearDown() throws Exception {
		
		cca1 = null;
		cca2 = null;
		CCADB.CCAList.clear();
	}

	@Test
	public void addCCATest() {
		
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the CCA arraylist is not null: ", CCADB.CCAList);
		
		
		// Test that the size of the CCA arrayList is 0 before adding any CCAs.
		assertEquals("Test that the size of the category arrayList is 0 before adding any CCA's", 0, CCADB.CCAList.size());
		
		
		// Test that the size of the CCA arrayList is 1 after adding 1 CCA.
		CCADB.addCCA(cca1);
		assertEquals("Test that the size of the category arrayList is 1 after adding any CCA", 1, CCADB.CCAList.size());

		// Test that the first item in CCA arrayList is the same as the item that was added. 
		assertSame("Test that the first item in CCA arrayList is the same as the item that was added", cca1, CCADB.CCAList.get(0));
	}
	
	public void viewCCATest() {
		
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the CCA array is not null: ", CCADB.CCAList);
		
		
		
		// Test that the list of cca retrieved is empty.
		String allCCA = CCADB.viewAllCCA();
		String testOutput = "";
		assertEquals("Check that ViewCCAList", testOutput, allCCA);
		
		
		
		// Test if the array list size is 1 after adding 1 CCAs.
		CCADB.addCCA(cca1);
		assertEquals("Test that the array list size  is 1 after adding 1 CCASs: ", 1, CCADB.CCAList.size());
		
		
		// Test that expected output string same as the list of CCA retrieved from the cca. 
		
		allCCA = CCADB.viewAllCCA();
		String testoutput = "";
		for (int i = 0; i < CCADB.CCAList.size();i++) {
			testoutput += "Title: " + CCADB.CCAList.get(i).getTitle() + "\n"; 
			testoutput += "Description: " + CCADB.CCAList.get(i).getDescription() + "\n"; 
			testoutput += "Class Size: " + CCADB.CCAList.get(i).getClass_Size() + "\n"; 
			testoutput += "Week: " + CCADB.CCAList.get(i).getWeek() + "\n"; 
			testoutput += "Time: " + CCADB.CCAList.get(i).gettime() + "\n"; 
			testoutput += "Venue: " + CCADB.CCAList.get(i).getVenue() + "\n"; 
			testoutput += "Instructor name: " + CCADB.CCAList.get(i).getInstructor_Name() + "\n"; 
			
		}
		assertEquals("Test that the expected output is same as list of cca retrived", testOutput, allCCA);
	
	
}
	

	
	@Test
	public void updateCCATest() {
		
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the CCA arraylist is not null: ", CCADB.CCAList);
		CCADB.addCCA(cca1);
		CCADB.addCCA(cca2);
		CCADB.updateCCADetails("Soccer", "Intense sport", 20, "Tuesday", "2", "Soccer Field", "Mr. Leo");
		assertEquals("Test that CCA is updated ",cca1.getInstructor_Name(), CCADB.CCAList.get(0).getInstructor_Name()); // index 
		CCADB.updateCCADetails("Soccer", "Intense sport", 20, "Thursday", "2", "Soccer Field", "Mr. Jack");
		assertEquals("Test that CCA is updated ",cca2.getWeek(), CCADB.CCAList.get(1).getWeek()); // index 
	}
	
	
	@Test
	public void deleteCCATest() {
		
		
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the CCA arraylist is not null: ", CCADB.CCAList);
		
		// Test that the size of the CCA arrayList is 1 before deleting 1 any CCAs.
		CCADB.addCCA(cca1);
		assertEquals("Test that the size of the category arrayList is 1 before deleting any CCA's", 1, CCADB.CCAList.size());
		

		// Test that the size of the CCA arrayList is 0 after deleting 1 CCA.
		CCADB.removeCCA(CCADB.CCAList.get(0).getTitle());
		assertEquals("Test that the size of the category arrayList is 1 after adding any CCA", 0, CCADB.CCAList.size());

	
				
		
	}
	


}
	
	
	
	


