import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_ParentTest {

	private Parent parent1;
	private Parent parent2;
	private Student student1;
	
	@Before
	public void setUp() throws Exception {
		
		parent1 = new Parent("Adam" , "Adamgmail.com",
				"blk 111 street 00", 88888888, 00000);
		parent2 = new Parent("Sally", "Sally@gmail.com",
				"blk 222 street 11", 87777777, 00001);
		
		student1 = new Student(12345, "JunJie", 3, "4A", "Mr Ong");
		
	}

	@After
	public void tearDown() throws Exception {
		parent1 = null;
		parent2 = null;
		student1 = null;
		ParentDB.parentList.clear();
		StudentDB.studentList.clear();
		
	}

	@Test
	public void doAddParentTest() {
		//Test if the arrayList is not null 
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);
		
		// Test the size of arrayList is 0 before adding any parent
		assertEquals("Test the size of arrayList is 0 before adding any parent: " , 0 , ParentDB.parentList.size());
		
		// Test the size of arraylist is 1 after adding 1 parent   
		ParentDB.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDB.parentList.size());
		
		// Test if the first parent in the arrayList equals to the first parent added in
		assertSame("Test if the first parent in the arrayList equals to the first parent added in: " , parent1 , ParentDB.parentList.get(0));
	}
	
	@Test
	public void doDeleteParentTest() {
		//Test if the arrayList is not null 
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);

		// Test the size of arraylist is 1 before deleting 1 parent 
		ParentDB.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 before deleting 1 parent: ", 1 , ParentDB.parentList.size());
		
		// Test the size of arraylist is 0 after deleting 1 parent(arraylist should be 1 before deleting) 
		ParentDB.removeParent(parent1);
		assertEquals("Test the size of arraylist is 0 after deleting 1 parent(arraylist should be 1 before deleting) : ", 0 , ParentDB.parentList.size());
	}

	@Test
	public void doViewParents() {
		//Test if the arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDB.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 0
		assertEquals("Test if an appropriate message is displayed when arrayList size is 0" , "Parent information not found", ParentDB.viewAllParents());			
		
		// Test if an appropriate message is displayed when arrayList size is >0		
		ParentDB.addParent(parent1);
		assertEquals("Test if an appropriate message is displayed when arrayList size is 0" ,String.format("%-10s %-20s %-20s %-10d", ParentDB.parentList.get(0).getName(), ParentDB.parentList.get(0).getEmail(), ParentDB.parentList.get(0).getAddress(), ParentDB.parentList.get(0).getContact_num()), ParentDB.viewAllParents());
	
	}
	
	@Test
	public void doCheckEmail() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDB.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDB.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDB.parentList.size());

		// Test if an appropriate message is displayed when the email does not contains "@" symbol
		assertEquals("Test if an appropriate message is displayed when the email does not contains \"@\" symbol", "Email does not contain \"@\" symbol", ParentDB.checkEmail());
		ParentDB.removeParent(parent1);
		
		// Test if an appropriate message is displayed when the email contains "@" symbol
		ParentDB.addParent(parent2);
		assertEquals("Test if an appropriate message is displayed when the email does not contains \"@\" symbol", "Email contain \"@\" symbol", ParentDB.checkEmail());

	}
	
	@Test
	public void updateParent() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDB.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDB.addParent(parent1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDB.parentList.size());
		
		// Test if parent email, address and mobile_num is changed to Adam@gmail.com, blk 111 street 01, 88888887
		ParentDB.updateParent("Adam", "Adam@gmail.com", "blk 111 street 01", 88888887);
		assertEquals("Test if parent email is changed to Adam@gmai.com", "Adam@gmail.com", ParentDB.parentList.get(0).getEmail());
		assertEquals("Test if parent address is changed to blk 111 street 01", "blk 111 street 01", ParentDB.parentList.get(0).getAddress());
		assertEquals("Test if parent mobile_num is changed to 88888887", 88888887, ParentDB.parentList.get(0).getContact_num());
	}
	
	@Test 
	public void parentRegistrationID() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDB.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDB.addParent(parent2);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDB.parentList.size());
		
		// Test if an appropriate message is displayed when the email is found 
		assertEquals("Test if an appropirate message is displayed when the registration ID matches", "Registration ID has been assigned!", ParentDB.parentGenerateID("Sally@gmail.com"));	
	
		// Test if an appropriate message is displayed email is not found
		ParentDB.removeParent(parent2);
		ParentDB.addParent(parent1);
		assertEquals("Test if an appropirate message is displayed when the registration ID matches", "Email cannot be found!", ParentDB.parentGenerateID("Adam@gmail.com"));	
	}
	
	@Test 
	public void parentLogIn() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDB.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDB.addParent(parent2);
		StudentDB.addStudent(student1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDB.parentList.size());
		
		// Test if an appropriate message is displayed when successfully logged in
		assertEquals("Test if an appropriate message is displayed when successfully logged in", "Log in successful!", ParentDB.parentLogIn("Sally@gmail.com", 00001, 12345, "JunJie"));
	}
	
	@Test
	public void registerStudentForCCA() {
		// Test if arrayList is not null
		assertNotNull("Test if the arrayList is not null: ", ParentDB.parentList);
		
		// Test if the arrayList size is 0
		assertEquals("Test if the arrayList size is 0: ", 0 , ParentDB.parentList.size());

		// Test if an appropriate message is displayed when arrayList size is 1		
		ParentDB.addParent(parent2);
		StudentDB.addStudent(student1);
		assertEquals("Test the size of arraylist is 1 after adding 1 parent: ", 1 , ParentDB.parentList.size());
		
		// Test if an appropriate message is displayed when a student successfully joined a CCA
		assertEquals("Test if an appropriate message is displayed when a student successfully joined a CCA", "Student has successfully registered!", ParentDB.registerStudent(12345, "Basketball"));
	}
	
}
