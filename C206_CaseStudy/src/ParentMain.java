
public class ParentMain {
// Create by OngJunJie at 24/08/2020
	
	public static void main(String[] args) {
		//ParentMain pm = new ParentMain();
		//pm.start();
		start();
	}

	static void start() {

		int option = 0;
		
		while (option != 6) {
			menu();
			option = Helper.readInt("Enter your option: ");
			if (option == 1) {
				Helper.line(30, "-");
				System.out.println("ADD PARENT");
				Helper.line(30, "-");
				String name = Helper.readString("Enter name: ");
				String email = Helper.readString("Enter email: ");
				while (ParentDB.checkEmail(email) == false) {
					email = Helper.readString("Missing \"@\"\nEnter email: ");	
				}
				String address = Helper.readString("Enter address: ");
				int contact_num = Helper.readInt("Enter contact number: ");
				int default_registrationNum = 00000;
				
				Parent new_parent = new Parent(name, email, address, contact_num, default_registrationNum);
				ParentDB.addParent(new_parent);
				Helper.line(30, "-");
				System.out.println("PARENT ADDED!");
				Helper.line(30, "-");
			}
			else if (option == 2) {
				Helper.line(30, "-");
				System.out.println("DELETE PARENT");
				Helper.line(30, "-");
				String name = Helper.readString("Enter your name: ");
				String email = Helper.readString("Enter your email: ");
				for (int i = 0; i < ParentDB.parentList.size(); i++) {
					if (ParentDB.parentList.get(i).getName().equalsIgnoreCase(name) && ParentDB.parentList.get(i).getEmail().equalsIgnoreCase(email)) {
						ParentDB.removeParent(ParentDB.parentList.get(i));
						Helper.line(30, "-");
						System.out.println("PARENT DELETED!");
						Helper.line(30, "-");
					}
					else {
						System.out.println("Parent's name or email cannot be found!");
					}
				}
			}
			
			else if (option == 3) {
				Helper.line(30, "-");
				System.out.println("UPDATE PARENT");
				Helper.line(30, "-");
				String name = Helper.readString("Enter your name: ");
				for (int i = 0; i < ParentDB.parentList.size(); i++) {
					if (ParentDB.parentList.get(i).getName().equalsIgnoreCase(name)) {
						Helper.line(30, "-");
						System.out.println("UPDATE OPTION");
						Helper.line(30, "-");
						updateParentMenu();
						int updateOption = 0;
						while (updateOption != 5) {
							updateOption = Helper.readInt("Enter your update option: ");
							updateParentInput(name, i, updateOption);
						}
					}
				}

			}
			else if (option == 4) {
				Helper.line(30, "-");
				System.out.println("VIEW ALL PARENTS");
				Helper.line(30, "-");
				String list = ParentDB.viewAllParents();
				System.out.println(list);
			}
			
			else if (option == 5) {
				Helper.line(30, "-");
				System.out.println("Register student!");
				Helper.line(30, "-");
				String name = Helper.readString("Enter parent name: ");
				String email = Helper.readString("Enter parent email: ");
				int studentID = Helper.readInt("Enter student ID: ");
				String CCA = Helper.readString("Enter CCA name: ");
				ParentDB.parentGenerateID(email);
				ParentDB.registerStudent(studentID, CCA);
				Helper.line(30, "-");
				System.out.println("Student: " + studentID + " has sucessfully reigstered for " + CCA);
				Helper.line(30, "-");
			}
		}
	}

	private static void updateParentInput(String name, int i, int updateOption) {
		if (updateOption == 1) {
			String email = Helper.readString("Enter your new Email: ");
			while (ParentDB.checkEmail(email) == false) {
				email = Helper.readString("Missing \"@\"\nEnter email: ");	
			}
			String address = ParentDB.parentList.get(i).getAddress();
			int contact_Num = ParentDB.parentList.get(i).getContact_num();
			ParentDB.updateParent(name, email, address, contact_Num);

		}
		else if (updateOption == 2 ) {
			String  address = Helper.readString("Enter your new Address: ");
			String email = ParentDB.parentList.get(i).getEmail();
			int contact_Num = ParentDB.parentList.get(i).getContact_num();
			ParentDB.updateParent(name, email, address, contact_Num);
		}
		else if (updateOption == 3) {
			int contact_Num = Helper.readInt("Enter your new contact number: ");
			String address = ParentDB.parentList.get(i).getAddress();
			String email = ParentDB.parentList.get(i).getEmail();
			ParentDB.updateParent(name, email, address, contact_Num);
		}
		else if (updateOption == 4) {
			String email = Helper.readString("Enter your new Email: ");
			while (ParentDB.checkEmail(email) == false) {
				email = Helper.readString("Missing \"@\"\nEnter email: ");	
			}
			String  address = Helper.readString("Enter your new Address: ");
			int contact_Num = Helper.readInt("Enter your new contact number: ");
			ParentDB.updateParent(name, email, address, contact_Num);
		}
	}

	private static void updateParentMenu() {
		System.out.println("UPDATE DETAILS");
		Helper.line(30, "-");
		System.out.println("1. Update Email ");
		System.out.println("2. Update Address");
		System.out.println("3. Update Contact Number ");
		System.out.println("4. Update all");
		System.out.println("5. Quit");
	}

	private static void menu() {
		Helper.line(30, "-");
		System.out.println("Parent portal");
		Helper.line(30, "-");
		System.out.println("1. Add Parent");
		System.out.println("2. Delete Parent");
		System.out.println("3. Update Parent");
		System.out.println("4. View all Parents");
		System.out.println("5. Register student for CCA");
		System.out.println("6. Quit");
	}

}
