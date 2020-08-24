import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class C206_CategoryTest {
	
	private Category catg1;
	private Category catg2;
	
	@Before
	public void setUp() throws Exception {
		catg1 = new Category("001", "Soccer");
		catg2 = new Category("002", "Baking");
		
	}
	
	@After
	public void tearDown() throws Exception {
		catg1 = null;
		catg2 = null;
		CategoryDB.categoryList.clear();
	}
	@Test
    public void addCategoryTest() {
		
		// Test that the Category arraylist is not null. 
		assertNotNull("Test that the CCA arraylist is not null: ", CategoryDB.categoryList);
		
		// Test that the size of the Category arrayList is 0 before adding any Categories.
		assertEquals("Test that the size of the category arrayList is 0 before adding any categories", 0, CategoryDB.categoryList.size());
		
		// Test that the size of the Category arrayList is 1 after adding 1 Category.
		CategoryDB.addCategory(catg1);
		assertEquals("Test that the size of the category arrayList is 1 after adding any category", 1, CategoryDB.categoryList.size());
	
		// Test that the first item in Category arrayList is the same as the item that was added. 
		assertSame("Test that the first item in category arrayList is the same as the item that was added", catg1, CategoryDB.categoryList.get(0));
			
}

	public void viewCategoryTest() {
	
		// Test that the Category arraylist is not null. 
		assertNotNull("Test that the CCA arraylist is not null: ", CategoryDB.categoryList);
		

		// Test that the list of category is empty.
		String allCategory = CategoryDB.viewAllCategory();
		String testOutput = "";
		assertEquals("Check that ViewCategoryList", testOutput, allCategory);
		
		// Test if the array list size is 1 after adding 1 Category.
		CategoryDB.addCategory(catg1);
		assertEquals("Test that the array list size  is 1 after adding 1 Category: ", 1, CategoryDB.categoryList.size());
	
	
		// Test that expected output string same as the list of categories retrieved from the category. 
	
		allCategory = CategoryDB.viewAllCategory();
		String testoutput = "";
		for (int i = 0; i < CategoryDB.categoryList.size();i++) {
				testoutput += "ID: " + CategoryDB.categoryList.get(i).getID() + "\n"; 
				testoutput += "Name: " + CategoryDB.categoryList.get(i).getName() + "\n"; 	
			}
		assertEquals("Test that the expected output is same as list of categories retrived", testOutput, allCategory);
		
	}
	

	public void updateCCATest() {
		
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the category arraylist is not null: ", CategoryDB.categoryList);
		CategoryDB.addCategory(catg1);
		CategoryDB.updateCategoryDetails("003", "Soccer");
		assertEquals("Test that CCA is updated ",catg1.getID(), CategoryDB.categoryList.get(0).getID()); // index 
	}
	
   public void deleteCategoryTest() {
	   
		// Test that the CCA arraylist is not null. 
		assertNotNull("Test that the category arraylist is not null: ", CategoryDB.categoryList);
			
		// Test that the size of the CCA arrayList is 1 before deleting 1 any CCAs.
		CategoryDB.addCategory(catg1);
		assertEquals("Test that the size of the category arrayList is 1 before deleting any CCA's", 1, CategoryDB.categoryList.size());
			

		// Test that the size of the CCA arrayList is 0 after deleting 1 CCA.
		CategoryDB.removeCategory(CategoryDB.categoryList.get(0).getID());
		assertEquals("Test that the size of the category arrayList is 1 after adding any CCA", 0, CategoryDB.categoryList.size());

		
					
			
		}
		

		
				
		
	}