import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_ParentTest {

	private ParentTest parent1;
	private ParentTest parent2;
	private Student student1;
	
	@Before
	public void setUp() throws Exception {
		
		parent1 = new ParentTest("Adam" , "Adamgmail.com",
				"blk 111 street 00", 88888888, 00000);
		parent2 = new ParentTest("Sally", "Sally@gmail.com",
				"blk 222 street 11", 87777777, 00001);
		
		student1 = new Student(12345, "JunJie", 3, "4A", "Mr Ong");
		
	}

	@After
	public void tearDown() throws Exception {
		parent1 = null;
		parent2 = null;
		student1 = null;
		ParentDBTest.parentList.clear();
		StudentDB.studentList.clear();
		
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
	
	@Test
	public void doCheckEmail() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDBTest.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDBTest.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDBTest.parentList.size());

		// Test if an appropriate message is displayed when the email does not contains "@" symbol
		assertEquals("Test if an appropriate message is displayed when the email does not contains \"@\" symbol", "Email does not contain \"@\" symbol", ParentDBTest.checkEmail());
		ParentDBTest.removeParent(parent1);
		
		// Test if an appropriate message is displayed when the email contains "@" symbol
		ParentDBTest.addParent(parent2);
		assertEquals("Test if an appropriate message is displayed when the email does not contains \"@\" symbol", "Email contain \"@\" symbol", ParentDBTest.checkEmail());

	}
	
	@Test
	public void updateParent() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDBTest.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDBTest.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDBTest.parentList.size());
		
		// Test if parent email, address and mobile_num is changed to Adam@gmail.com, blk 111 street 01, 88888887
		ParentDBTest.updateParent("Adam", "Adam@gmail.com", "blk 111 street 01", 88888887);
		assertEquals("Test if parent email is changed to Adam@gmai.com", "Adam@gmail.com", ParentDBTest.parentList.get(0).getEmail());
		assertEquals("Test if parent address is changed to blk 111 street 01", "blk 111 street 01", ParentDBTest.parentList.get(0).getAddress());
		assertEquals("Test if parent mobile_num is changed to 88888887", 88888887, ParentDBTest.parentList.get(0).getContact_num());
	}
	
	@Test 
	public void parentRegistrationID() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDBTest.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDBTest.addParent(parent2);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDBTest.parentList.size());
		
		// Test if an appropriate message is displayed when the email is found 
		assertEquals("Test if an appropirate message is displayed when the registration ID matches", "Registration ID has been assigned!", ParentDBTest.parentGenerateID("Sally@gmail.com"));	
	
		// Test if an appropriate message is displayed email is not found
		ParentDBTest.removeParent(parent2);
		ParentDBTest.addParent(parent1);
		assertEquals("Test if an appropirate message is displayed when the registration ID matches", "Email cannot be found!", ParentDBTest.parentGenerateID("Adam@gmail.com"));	
	}
	
	@Test 
	public void parentLogIn() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDBTest.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDBTest.addParent(parent2);
		StudentDB.addStudent(student1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDBTest.parentList.size());
		
		// Test if an appropriate message is displayed when successfully logged in
		assertEquals("Test if an appropriate message is displayed when successfully logged in", "Log in successful!", ParentDBTest.parentLogIn("Sally@gmail.com", 00001, 12345, "JunJie"));
	}
	
	@Test
	public void registerStudentForCCA() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDBTest.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDBTest.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDBTest.addParent(parent2);
		StudentDB.addStudent(student1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDBTest.parentList.size());
		
		// Test if an appropriate message is displayed when a student successfully joined a CCA
		assertEquals("Test if an appropriate message is displayed when a student successfully joined a CCA", "Student has successfully registered!", ParentDBTest.registerStudent(12345, "Basketball"));
	}
	
}
