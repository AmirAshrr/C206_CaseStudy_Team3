import java.util.ArrayList;
//create by Amir at 18/8/2020
public class StudentDB {

	public static ArrayList<Student> studentList = new ArrayList<Student>();

	public static void addStudent(Student s) {
		// TODO Auto-generated method stub
		studentList.add(s);
		
	}

	public static void deleteStudent(Student s) {
		// TODO Auto-generated method stub
		studentList.remove(s);
		
	}
    
	public static String viewStudents() {
		String output = "";
		if(studentList.size() == 0) {
			output = "Student list is empty";
		}else {
			output = String.format("%-6s %-15s %-8s %-10s %-20s\n", "ID","NAME","GRADE","CLASS","TEACHER");
			
			for(Student s: studentList) {
				int id = s.getId();
				String name = s.getName();
				int grade = s.getGrade();
				String sClass = s.getStudentClass();
				String teacher = s.getClassroomTeacher();
				output+=String.format("%-6d %-15s %-8d %-10s %-20s\n", id,name,grade,sClass,teacher);
		      
			}
		
	}
		return output;
	}
	public static void updateStudentDetails(int id, int grade, String class1, String classroomTeacher) {
		
		for(Student s: studentList) {
			if(id==s.getId()) {
				s.setClassroomTeacher(classroomTeacher);
				s.setStudentClass(class1);
				s.setGrade(grade);
				
			}
		}
		 
	}
	public static boolean checkId5dLong(int id) {
		boolean output;
		int idLength = String.valueOf(id).length();
		if(idLength==5) {
			output = true;
		}else {
			output = false;
		}
		return output;
	}
	public static boolean checkUniqueId(int id) {
		boolean message = true;
		for(Student s: studentList) {
			if(id==s.getId()) {
				message = false;
			}
		}
		return message;
	}

	public static String viewAllRegisteredStudents() {
		
		String output = ""; // empty string

		if (studentList.size() == 0) {

			output = "No students registered";

		} else {

		}

		return output;
		
	}

	public static String deleteStudent(int id) {
		// TODO Auto-generated method stub
		String message = "Delete unsuccessful";
		for(Student s: studentList) {
			if(s.getId() == id) {
				studentList.remove(s);
				message = "Delete successful";
			}
			
		}
		return message;
		
		
	}

}
