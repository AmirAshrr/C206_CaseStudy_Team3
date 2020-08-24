
public class InstructorMain {
	// Create by Amir at 24/08/2020

	private static final int length = 30;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
InstructorMain im = new InstructorMain();
im.start();
	}
	static void start() {
		int defaultOption = -1;
		int quitOption = 5;
		int option = defaultOption;
		System.out.println("Instructor Page");
		while(option!=quitOption) {
			menu();
			option = Helper.readInt("Enter option: ");
			if(option == 1) {
				Helper.line(length, "-");
				String name = Helper.readString("Enter name: ");
				String email = Helper.readString("Enter email: ");
				while (ParentDB.checkEmail(email) == false) {
					email = Helper.readString("Missing \"@\"\nEnter email: ");	
				}
				String password = Helper.readString("Enter password: ");
				InstructorDB.addInstructor(new Instructor(name,email,password));
			}else if(option == 2) {
				Helper.line(length, "-");
				System.out.println("DELETE INSTRUCTOR");
				String name = Helper.readString("Enter name: ");
				System.out.println(InstructorDB.removeInstructor(name));
			}else if(option == 3) {
				Helper.line(length, "-");
				String list = InstructorDB.viewAllInstructors();
				System.out.println(list);
			}else if(option == 4) {
				String name = Helper.readString("Enter name: ");
				String email = Helper.readString("Enter email: ");
				while (ParentDB.checkEmail(email) == false) {
					email = Helper.readString("Missing \"@\"\nEnter email: ");	
				}
				String password = Helper.readString("Enter password");
				System.out.println(InstructorDB.updateInstructorDetails(name, email, password));
			}else if(option == 5) {
				System.out.println("End");
			}else {
				Helper.line(length, "-");
				System.out.println("Invalid option");
			}
		}
	}
	public static void menu() {
		Helper.line(length, "-");
		System.out.println("1.Add instructor");
		System.out.println("2.Delete instructor");
		System.out.println("3.View all instructors");
		System.out.println("4.Update Instructor Details");
		System.out.println("5.Quit");
		Helper.line(length, "-");
		
		
	}

}
