import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_InsructorTest {


    private Instructor instructor1;
    private Instructor instructor2;


    @Before
    public void setUp() throws Exception {


        instructor1 = new Instructor("John", "john@gmail.com", "john91");
        instructor2 = new Instructor("Sarah", "sarah@gmail.com", "sarah22");
    }


    @After
    public void tearDown() throws Exception {


        instructor1 = null; // resetting the variable
        instructor2 = null;


        InstructorDB.instructorList.clear();
    }


    @Test
    public void addInstructorTest() {


        // Test that the instructor array list is not null


        assertNotNull("Test that the student array list is not null: ", InstructorDB.instructorList);


        // Test that the size of the instructor array list is 0 before adding any instructor


        assertEquals("Test that the size of the instructor array list is 0 before adding any instructor: ", 0, InstructorDB.instructorList.size());


        // Given an empty list, test that the size of instructor array list will increase by 1, after adding 1


        InstructorDB.addInstructor(instructor1);
        assertEquals("Test that the size of instructor array list will increase by 1, after adding 1 ", 1, InstructorDB.instructorList.size());


        // Test that the first element in the instructor array list is the same as the instructor that is added


        assertSame("Test that the first element in the instructor array list is the same as the instructor that is added: ", instructor1, InstructorDB.instructorList.get(0));


    }


    @Test
    public void deleteInstructorTest() {


        // Test that the instructor array is not null


        assertNotNull("Test that the instructor array is not null: ", InstructorDB.instructorList);


        // Test the size of instructor array list is 1 before deleting 1 instructor


        InstructorDB.addInstructor(instructor1);
        assertEquals("Test that the size of the instructor array list is 1 before deleting any instructor: ", 1, InstructorDB.instructorList.size());


        // Test the size of instructor array list is 0 after deleting 1 instructor


        InstructorDB.removeInstructor(InstructorDB.instructorList.get(0).getName());
        assertEquals("Test that the size of the instructor array list is 1 before deleting any instructor: ", 0, InstructorDB.instructorList.size());


    }
    
    @Test 
    public void viewAllInstructor() { 
        
        // Test if the instructor array list is not null 
        
        assertNotNull("Test that the instructor array is not null: ", InstructorDB.instructorList); 
        
        // Test if an appropriate message is displayed when array list size is 0
        
        assertEquals("Test if an appropriate message is displayed when array list size is 0 ", "Instructor information is not displayed", InstructorDB.viewAllInstructors());
        
        //     Test if the array list size is 1
        
        InstructorDB.addInstructor(instructor1);
        
        assertEquals("Test that the array list size is > 0:  ", 1, InstructorDB.instructorList.size());
            
    } 



    @Test
    public void updateInstructorTest() {


        // Test if the instructor array list is not null


        assertNotNull("Test that the instructor array is not null: ", InstructorDB.instructorList);


        // Test that the size of instructor array list is 2 after adding 2 instructor


        InstructorDB.addInstructor(instructor1);
        InstructorDB.addInstructor(instructor2);


        // Update the instructor details


        InstructorDB.updateInstructorDetails("John", "john@gmail.com", "johnxx");
        InstructorDB.updateInstructorDetails("Sarah", "sarah@gmail.com", "sarahxx");


        // Test that the instructor 1 password is changed from john91 to johnxx


        assertEquals("Test that instructor 1 password changed from john91 to johnxx: ", instructor1.getPassword(), InstructorDB.instructorList.get(0).getPassword());


        // Test that the instructor 2 password is changed from sarah22 to sarahxx


        assertSame("Test that instructor 1 password changed from sarah22 to sarahxx: ", instructor2.getPassword(), InstructorDB.instructorList.get(1).getPassword());


    }


    @Test
    public void viewRegisteredStudents() {


        // Test if the student array list is not null


        assertNotNull("Test that the student array is not null: ", StudentDB.studentList);


        // Test if an appropriate message is displayed when array list size is 0


        assertEquals("Test if an appropriate message is displayed when array list size is 0 ", "No students registered", StudentDB.viewAllRegisteredStudents());


        // Test if the array list size is 1, after a student registered


        StudentDB.addStudent(null);


        assertEquals("Test that the array list size is > 0:  ", 1, StudentDB.studentList.size());


    }


    @Test
    public void viewCCAByDateandTime() {


        // Test if the cca array list is not null


        assertNotNull("Test that the CCA array is not null: ", CCADB.CCAList);


        // Test if the array list size is 1, after a CCA is added


        CCA cca1 = new CCA("Soccer", "Little League", 20, "Tuesday", "2", "Soccer Field", "Mr. Jack");


        CCADB.addCCA(cca1);


        assertEquals("Test that the array list size is > 0:  ", 1, CCADB.CCAList.size());


        // Test that the CCA date information will be displayed


        assertEquals("Test that the CCA date information will be displayed: ", cca1.getWeek(), CCADB.CCAList.get(0).getWeek());


        // Test that the CCA time information will be displayed


        assertEquals("Test that the CCA date information will be displayed: ", cca1.gettime(), CCADB.CCAList.get(0).gettime());


    }


}