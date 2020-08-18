import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Instructor instructor1;
	private Instructor instructor2; 
	
	

	@Before
	public void setUp() throws Exception {
		
		instructor1 = new Instructor("John", "VolleyBall");
		instructor2 = new Instructor("Sarah", "Badminton");
	}

	@After
	public void tearDown() throws Exception {
		
		instructor1 = null;        // resetting the variable
		instructor2 = null; 
		
		InstructorDB.instructorList.clear();
	}


	@Test
	public void addInstructorTest() {
		
		// Test that the instructor array list is not null 
		
		assertNotNull("Test that the student array list is not null: ", InstructorDB.instructorList); 
		
		// Test that the size of the instructor array list is 0 before adding any instructor
		
		assertEquals("Test that the size of the instructor array list is 0 before adding any instructor: ", 0, InstructorDB.instructorList.size());
		
		// Test that the size of array list is 1 after adding 1 instructor 
		
		InstructorDB.addInstructor(instructor1);
		assertEquals("Test that the size of array list is 1 after adding 1 instructor: ", 1, InstructorDB.instructorList.size()); 
		
		// Test that the first instructor in the instructor array list is the same as the instructor that is added 
		
		assertSame("Test that the first instructor in the instructor array list is the same as the instructor that is added: ", instructor1, InstructorDB.instructorList.get(0));
		
		
	} 
	
	@Test
	public void deleteInstructorTest() { 
		
		// Test that the instructor array is not null 
		
		assertNotNull("Test that the instructor array is not null: ", InstructorDB.instructorList); 
		
		
		// Test the size of instructor array list is 1 before deleting 1 instructor 
		
		InstructorDB.addInstructor(instructor1);
		assertEquals("Test that the size of the instructor array list is 1 before deleting any instructor: ", 1, InstructorDB.instructorList.size());
		
		// Test the size of instructor array list is 0 after deleting 1 instructor  
		
		InstructorDB.removeInstructor(instructor1);
		assertEquals("Test that the size of the instructor array list is 1 before deleting any instructor: ", 0, InstructorDB.instructorList.size());

		
	}
	
	@Test 
	public void viewAllInstructor() { 
		
		// Test if the array list is not null 
		
		assertNotNull("Test that the instructor array is not null: ", InstructorDB.instructorList); 
		
		
		// Test if an appropriate message is displayed when array list size is 0
		
		assertEquals("Test that the size of the instructor array list is 1 before deleting any instructor: ", "Instructor information is not displayed", InstructorDB.viewAllInstructor());
		
		// 	Test if the array list size is 1
		
		InstructorDB.addInstructor(instructor1);
		
		assertEquals("Test that the array list size is > 0:  ", 1, InstructorDB.instructorList.size());
		
		
		
		
	}

}


