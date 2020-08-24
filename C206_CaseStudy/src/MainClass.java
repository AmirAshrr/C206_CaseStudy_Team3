
public class MainClass {
	// Create by OngJunJie at 24/08/2020

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		int option = 0;
		while (option !=5) {
			menu();
			option = Helper.readInt("Enter option: ");
			if (option == 1) { 
				StudentMain sm = new StudentMain();
				sm.start();
			}
			else if (option == 2) {
				ParentMain pm = new ParentMain();
				pm.start();
			}
			else if (option == 3) {
				CCAMain cm = new CCAMain();
				cm.start();
			}
			else if (option == 4) {
				InstructorMain im = new InstructorMain();
				im.start();
			}
			else if (option == 5){
				System.out.println("Thank you for using this portal!");
			}
			else {
				System.out.println("Invalid option");
			}
		}
		
	}

	private static void menu() {
		Helper.line(30, "-");
		System.out.println("MAIN MENU");
		Helper.line(30, "-");
		System.out.println("1. Student Portal");
		System.out.println("2. Parent Portal");
		System.out.println("3. CCA Portal");
		System.out.println("4. CCA Instructor Portal");
		System.out.println("5. Quit");
	}

}
