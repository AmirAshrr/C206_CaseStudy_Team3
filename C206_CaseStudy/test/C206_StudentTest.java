import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_StudentTest {
Student s1;
Student s2;
Student s3;
	@Before
	public void setUp() throws Exception {
	s1 = new Student(1,"Adam", 4, "W66H", "David Chua");
	s2 = new Student(2,"Beck", 5, "W65E", "Terence Ong");
	s3 = new Student(33333,"Becky", 5, "W65D", "Terence Tan");
	}

	@After
	public void tearDown() throws Exception {
	s1 = null;
	s2 = null;
	StudentDB.studentList.clear();
	}

	@Test
	public void addStudentTest() {
		assertNotNull("Test that student arraylist is not null", StudentDB.studentList);
		assertEquals("Size of student list is 0", 0, StudentDB.studentList.size());
		StudentDB.addStudent(s1);
		assertEquals("Size of student list is 1", 1, StudentDB.studentList.size());
		assertSame("Student's name in arraylist matches with s1 name", s1, StudentDB.studentList.get(0));
	
		
	}
	@Test
	public void deleteStudentTest() {
		StudentDB.addStudent(s1); //method is proven to add Student in public void addStudentTest()
		StudentDB.deleteStudent(s1);
		assertEquals("No student is found in the arraylist", 0, StudentDB.studentList.size());
		
		
	}
	@Test
	public void viewStudentTest() {
		assertEquals("Test that message is displayed when arraylist is empty","Student list is empty",StudentDB.viewStudents());
	    StudentDB.addStudent(s1);
	    StudentDB.addStudent(s2);
	    //Test that all properties of s1/s2 matches with arraylist
	    assertEquals("Test that s1 ID is 1",1, StudentDB.studentList.get(0).getId());
	    assertEquals("Test that s1 ID is 2",2, StudentDB.studentList.get(1).getId());
		//create message to be tested against
		String output = "";
		output = String.format("%-6s %-15s %-8s %-10s %-20s\n", "ID","NAME","GRADE","CLASS","TEACHER");
		output+=String.format("%-6d %-15s %-8d %-10s %-20s\n", s1.getId(),s1.getName(),s1.getGrade(),s1.getStudentClass(),s1.getClassroomTeacher());
		output+=String.format("%-6d %-15s %-8d %-10s %-20s\n", s2.getId(),s2.getName(),s2.getGrade(),s2.getStudentClass(),s2.getClassroomTeacher());
	    assertEquals("Test that s1 info in student list is displayed correctly",output,StudentDB.viewStudents());
		
	}
	@Test
	public void updateStudentTest() {
		StudentDB.addStudent(s1);
		StudentDB.updateStudentDetails(1, 6,"W66", "David Tan");
		assertEquals("Test that s1 grade is changed to 6", 6, StudentDB.studentList.get(0).getGrade());
		assertEquals("Test that s1 class is changed to W66", "W66", StudentDB.studentList.get(0).getStudentClass());
		assertEquals("Test that s1 teacher is changed to David Tan", "David Tan", StudentDB.studentList.get(0).getClassroomTeacher());
		
	}
	@Test
	public void checkStudentIdTest() { 
		StudentDB.addStudent(s1);
		assertEquals("Test that s1 ID is 1",1, StudentDB.studentList.get(0).getId());
		boolean s1idmsg = StudentDB.checkId5dLong(StudentDB.studentList.get(0).getId());
		assertEquals("id of s1 should return false",false,s1idmsg);
		 
		StudentDB.addStudent(s3);
		assertEquals("Test that s3 ID is 33333",33333, StudentDB.studentList.get(1).getId());
	    boolean s3idmsg = StudentDB.checkId5dLong(StudentDB.studentList.get(1).getId());
	    assertEquals("id of s3 should return true", true, s3idmsg);
	
		
	}
	@Test
	public void checkIdsAreUnique() {
		StudentDB.addStudent(s1);
		assertEquals("Test that s1 ID is 1",1, StudentDB.studentList.get(0).getId());
		
		boolean message = StudentDB.checkUniqueId(1);
		assertEquals("Message displayed should return false", false,message);
		
		boolean uniquemessage = StudentDB.checkUniqueId(657);
		assertEquals("Message displayed should return true",true,uniquemessage);
	}

	
	
	
	
	

}
