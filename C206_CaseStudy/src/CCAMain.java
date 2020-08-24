
public class CCAMain {
	// Create by OngJunJie at 24/08/2020
	public static void main(String[] args) {
		start();
	}

	static void start() {

		int option = 0;
		while (option != 5) {
			CCADB.showCCAMenu();
			option = Helper.readInt("Enter your option: ");
			if (option == 1) {
				Helper.line(30, "-");
				System.out.println("ADDING CCA");
				Helper.line(30, "-");
				//CCADB.inputCCA();
				//String ccac = CCADB.inputCCA();
				String cca_result = CCADB.addCCA(CCADB.CCAList, CCADB.inputCCA());
				System.out.println(cca_result);
			}
			else if (option == 2) {
				Helper.line(30, "-");
				System.out.println("REMOVING CCA");
				Helper.line(30, "-");
				String remove_cca = Helper.readString("Enter CCA to remove: ");
				String remove_result = CCADB.removeCCA(remove_cca);
				Helper.line(30, "-");
				System.out.println(remove_result);
				Helper.line(30, "-");
			}
			
			else if (option == 3) {
				Helper.line(30, "-");
				System.out.println("UPDATE CCA");
				Helper.line(30, "-");
				String title = Helper.readString("Enter CCA title: ");
				String description = Helper.readString("Enter CCA description: ");
				int class_size = Helper.readInt("Enter CCA class size: ");
				String week = Helper.readString("Enter CCA day of week: ");
				String time = Helper.readString("Enter CCA time: ");
				String venue = Helper.readString("Enter CCA venue: ");
				String instructor_name = Helper.readString("Enter instructor name: ");
				CCADB.updateCCADetails(title, description, class_size, week, time, venue, instructor_name);
				Helper.line(30, "-");
				System.out.println("CCA UPDATED");
				Helper.line(30, "-");
			}
			
			else if (option == 4) {
				Helper.line(30, "-");
				System.out.println("VIEW ALL CCA");
				Helper.line(30, "-");
				String list = CCADB.viewAllCCA();
				System.out.println(list);
			}
		}
		System.out.println("Thanks!");
		
	}

}
