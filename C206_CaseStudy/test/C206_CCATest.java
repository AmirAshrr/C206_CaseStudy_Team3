import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CCATest {
	
	private CCA cca1;
	private CCA cca2;
	
	@Before
	public void setUp() throws Exception {
	
	
	cca1 = new CCA("Soccer", "Little League", 20, "Tuesday", 2, "Soccer Field", "Mr. Jack");
	cca2 = new CCA("Bakery", "Bakery can be rewarding and uplifting. Join us today!", 15, "Wednesday", 3, "Kitchen Room", "Ms Rose");
	
	
	}
	@After
	public void tearDown() throws Exception {
		
		cca1 = null;
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
	
	@Test
	public void deleteCCATest() {
		
		
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the CCA arraylist is not null: ", CCADB.CCAList);
		
		// Test that the size of the CCA arrayList is 1 before deleting 1 any CCAs.
		CCADB.addCCA(cca1);
		assertEquals("Test that the size of the category arrayList is 1 before deleting any CCA's", 1, CCADB.CCAList.size());
		
		// Test that the size of the CCA arrayList is 0 after deleting 1 CCA.
		CCADB.removeCCA(cca1);
		assertEquals("Test that the size of the category arrayList is 1 after adding any CCA", 0, CCADB.CCAList.size());

		
				
		
	}
	
	@Test
	public void viewCCATest() {
		
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the CCA array is not null: ", CCADB.CCAList);
		
		
		
		// Test if an appropriate message is displayed when array list size is 0.
		assertEquals("Test that the size of the CCA arrayList is 1 before deleting any CCA's: ", "CCA information is not displayed", CCADB.viewAllCCA());

		
		
		// Test if the array list size is 1 
		CCADB.addCCA(cca1);
		assertEquals("Test that the array list size  is > 0: ", 1, CCADB.CCAList.size());
		
		
	}
	
	
}
	
	
	
	


