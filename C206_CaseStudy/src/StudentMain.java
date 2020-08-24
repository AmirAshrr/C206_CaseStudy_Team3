public class StudentMain {
	// Create by Amir at 24/08/2020

	private static final int length = 30;
	public static void main(String[] args) {

	StudentMain sMain = new StudentMain();
    sMain.start();
	}
	public void start() {
		int defaultOption = -1;
		int quitOption = 5;
		int option = defaultOption;
		System.out.println("Student Page");
		while(option!=quitOption) {
			menu();
			option = Helper.readInt("Enter option: ");
			if(option == 1) {
				Helper.line(length, "-");
				int id = Helper.readInt("Enter student id: ");
				while(StudentDB.checkId5dLong(id) == false) {
					System.out.println("Please enter a 5 digit ID");
					id = Helper.readInt("Enter student id: ");
				}
				while(StudentDB.checkUniqueId(id) == false) {
					System.out.println("Please enter a unique ID");
					id = Helper.readInt("Enter student id: ");
				}
				String name = Helper.readString("Enter name: ");
				int grade = Helper.readInt("Enter Grade: ");
				String class1 = Helper.readString("Enter class: ");
				String teacher = Helper.readString("Enter teacher: ");
				Student s = new Student(id, name, grade, class1, teacher);
				StudentDB.addStudent(s);
			}else if(option == 2) {
				Helper.line(length, "-");
				System.out.println("DELETE STUDENT");
				int id = Helper.readInt("Enter student id: ");
				System.out.println(StudentDB.deleteStudent(id));
			}else if(option ==3) {
				Helper.line(length, "-");
				String list = StudentDB.viewStudents();
				System.out.println(list);
			}else if(option ==4){
				int id = Helper.readInt("Enter student id: ");
				String name = Helper.readString("Enter name: ");
				int grade = Helper.readInt("Enter Grade: ");
				String class1 = Helper.readString("Enter class: ");
				String teacher = Helper.readString("Enter teacher: ");
				System.out.println(StudentDB.updateStudentDetails(id,name,grade,class1,teacher));
			}else if(option == 5) {
				System.out.println("End");
			}
			else {
				Helper.line(length, "-");
				System.out.println("Invalid option");
			}
		}
		
		
	}
	public void menu() {
		Helper.line(length, "-");
		System.out.println("1.Add student");
		System.out.println("2.Delete student");
		System.out.println("3.View Students");
		System.out.println("4.Update Students");
		System.out.println("5.Quit");
		Helper.line(length, "-");
		
		
	}

	

}