import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_ParentTest {

	private ParentTest parent1;
	private ParentTest parent2;
	
	@Before
	public void setUp() throws Exception {
		
		parent1 = new ParentTest("Adam" , "Adam@gmail.com",
				"blk 111 street 00", 88888888);
		parent2 = new ParentTest("Sally", "Sally@gmail.com",
				"blk 222 street 11", 87777777);
		
	}

	@After
	public void tearDown() throws Exception {
		parent1 = null;
		parent2 = null;
		ParentDBTest.parentList.clear();
		
	}

	@Test
	public void doAddParentTest() {
		//Test if the arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);
		
		// Test the size of arrayList is 0 before adding any parent
		assertEquals("Test the size of arrayList is 0 before adding any parent: " , 0 , ParentDBTest.parentList.size());
		
		// Test the size of arraylist is 1 after adding 1 parent 
		ParentDBTest.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDBTest.parentList.size());
		
		// Test if the first parent in the arrayList equals to the first parent added in
		assertSame("Test if the first parent in the arrayList equals to the first parent added in: " , parent1 , ParentDBTest.parentList.get(0));
	}
	
	@Test
	public void doDeleteParentTest() {
		//Test if the arrayList is not null 
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);

		// Test the size of arraylist is 1 before deleting 1 parent 
		ParentDBTest.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 before deleting 1 parent: ", 1 , ParentDBTest.parentList.size());
		
		// Test the size of arraylist is 0 after deleting 1 parent(arraylist should be 1 before deleting) 
		ParentDBTest.removeParent(parent1);
		assertEquals("Test the size of arraylist is 0 after deleting 1 parent(arraylist should be 1 before deleting) : ", 0 , ParentDBTest.parentList.size());
	}

	@Test
	public void doViewParents() {
		//Test if the arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDBTest.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 0
		assertEquals("Test if an appropriate message is displayed when arrayList size is 0" , "Parent information not found", ParentDBTest.viewAllParents());			
		
		// Test if an appropriate message is displayed when arrayList size is >0		
		ParentDBTest.addParent(parent1);
		assertEquals("Test if an appropriate message is displayed when arrayList size is 0" ,String.format("%-10s %-20s %-20s %-10d", ParentDBTest.parentList.get(0).getName(), ParentDBTest.parentList.get(0).getEmail(), ParentDBTest.parentList.get(0).getAddress(), ParentDBTest.parentList.get(0).getContact_num()), ParentDBTest.viewAllParents());
	
	}
}
