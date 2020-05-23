package com.revature.AudiDealership;

import java.util.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.revature.DAO.AudiCarDAOPostGreSQL;
import com.revature.DAO.UserDAOPostgreSQL;
import com.revature.DAO.OfferDAOPostgreSQL;
import com.revature.DAO.PaymentDAOPostgreSQL;
import com.revature.Objects.*;
import com.revature.Services.*;

/**
 * @author josecanela
 *
 */

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);
	
	static User user = new User(); // Instantiate a user

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		mainMenu();
		log.info("mainMenu:Running Main Menu");

	}

//Main Menu
	/**
	 * 
	 */
	public static void mainMenu() {
		
		Boolean run = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to The Audi Dealership App!");
		
		do {
			String userInput;
			System.out.println("Please select one of our options:");

			System.out.println("|-1. Login \n|-2. Create Account \n|-3. Close Application\n");

			userInput = scan.nextLine();
			userInput = userInput.toUpperCase();

			switch (userInput.toUpperCase()) {
			case "1":
				signInMenu();
				
				log.info("signInMenu:Running SignIn Menu");
				break;

			case "2":
				registrationMenu();
				
				log.info("registrationMenu:Running Registration Menu");
				break;

			case "3":
				run = false;
				
				log.info("mainMenu:Exited Main Menu");
				break;
			
			default:
				System.out.println("Invalid choice, try again...");
				
				log.info("mainMenu:Invalid Main Menu Choice Given");
				break;
			}

		} while (run == true);

		scan.close();
		
		System.out.println("Goodbye! Thank you for using The Audi Dealership App!");
		
		log.info("mainMenu:Application Closed.");

		System.exit(0);
	}

	//SignIn Menu
	/**
	 * 
	 */
	public static void signInMenu() {
		AuthenticateUser authUser = new AuthenticateUser();
		String username;
		String password;
		String userInput;
		Scanner scan = new Scanner(System.in);

		// Prompt
		System.out.println("LOGIN MENU:");
		
		System.out.println("1. Customer Login: \n2. Employee Login: \n3. Exit");
		userInput = scan.nextLine();
		
		switch (userInput) {
		case "1":
			// CUSTOMER LOGIN
			System.out.println("Username: ");
			userInput = scan.nextLine();
			username = userInput;

			System.out.println("Password : ");
			userInput = scan.nextLine();
			password = userInput;
			if (authUser.authenticateCustomer(username, password)) {
				customerMenu(username, password);
				log.info("signInMenu:Running Customer Menu.");
			} else {
				log.info("signInMenu:Customer failed to login - invalid username or password");
				
				signInMenu();
				log.info("signInMenu:Customer back to SignIn Menu");
				
			}

			break;

		case "2":
			// EMPLOYEE LOGIN
			System.out.println("Username: ");
			userInput = scan.nextLine();
			username = userInput;

			System.out.println("Password : ");
			userInput = scan.nextLine();
			password = userInput;
			
			if (authUser.authenticateEmployee(username, password)) {
				employeeMenu(username,password);
				
				log.info("signInMenu:Running Employee Menu.");
			} else {
				log.info("signInMenu:Employee failed to login - invalid username or password");
				
				signInMenu();
				
				log.info("signInMenu:Employee back to SignIn Menu");
			}

			break;

		case "3":
			mainMenu();
			
			log.info("signInMenu:User back to Main Menu");
			break;

		default:
			System.out.println("Invalid choice, try again...");
			
			log.info("signInMenu:Invalid SignIn Menu Choice Given");
			
			signInMenu();
			
			log.info("signInMenu:User back to SignIn Menu");
			break;
		}

	}

	//Registration Menu
	/**
	 * 
	 */
	public static void registrationMenu() {
		RegisterUser regUser = new RegisterUser();
		String userInput;
		String username;
		String password;
		Scanner scan = new Scanner(System.in);

		System.out.println("\nREGISTRATION MENU");
		System.out.println("|-1. Customer Registration: \n|-2. Employee Registration: \n|-3. Exit\n");
		
		userInput = scan.nextLine();

		switch (userInput) {
		case "1":
			System.out.println("Username: ");
			userInput = scan.nextLine();
			username = userInput;

			System.out.println("Password : ");
			userInput = scan.nextLine();
			password = userInput;

			regUser.registerCustomer(username, password);
			signInMenu();
			
			log.info("registrationMenu:Customer("+ username +") Registered and sent to SignIn Menu");
			break;

		case "2":
			System.out.println("Username: ");
			userInput = scan.nextLine();
			username = userInput;

			System.out.println("Password : ");
			userInput = scan.nextLine();
			password = userInput;

			regUser.registerEmployee(username, password);
			signInMenu();
			
			log.info("registrationMenu:Employee("+ username +") Registered and sent to SignIn Menu");
			break;

		case "3":
			mainMenu();
			log.info("registrationMenu:User back to Main Menu");
			break;

		default:
			System.out.println("Invalid choice, try again...");
			registrationMenu();
			
			log.info("registrationMenu:Invalid Registration Menu Choice Given");
			break;
		}
	}

	//CustomerMenu
	/**
	 * @param username
	 */
	public static void customerMenu(String username, String password) {
		String userInput, vinNumber;
		Double offer;
		Integer vinNumber_id, username_id;
		Scanner scan = new Scanner(System.in);
		ViewAudi viewAudi = new ViewAudi();
		BidOnAudiCar bidOnAudi = new BidOnAudiCar();
		ManageAudiCarPayments mngAudiCarPay = new ManageAudiCarPayments();
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
		
		Customer customer = new Customer();
		customer = userDAO.readCustomerByUsername(username);
				
		System.out.println("CUSTOMER MENU: \n Hello " + username);
	
		System.out.println("|-1. Explore Cars: \n|-2. Make Offer: \n|-3. View My Cars: \n|-4. View My Payment History: \n|-5. Make Monthly Payment: \n|-6. Sign Out");
		
		userInput = scan.nextLine();

		switch (userInput) {
		case "1":
			viewAudi.viewAudis(username, password);
			
			customerMenu(username, password);
			
			log.info("customerMenu: Customer("+ username +") viewed the Audi's in the car lot and was given Customer Menu Options");
			break;

		case "2":
			System.out.println("--MAKE OFFER--");
			viewAudi.viewAudis(username, password);
			
			System.out.println("Enter Vehicle Identification Number(VIN): ");
			vinNumber = scan.nextLine();
			
			scan.nextLine();
			
			System.out.println("Enter Amount: ");
			offer = scan.nextDouble();
			
			username_id = userDAO.readCustomerByUsername(username).getUserId();
			vinNumber_id = audiDAO.readCar(vinNumber).getCarId();
			bidOnAudi.addOffer(vinNumber_id, username_id, offer);
			
			customerMenu(username,password);
			
			log.info("customerMenu: Customer("+ username +") made an offer ($" + offer + ") on car with VIN (" + vinNumber +") and given Customer Menu Options");
			break;
		
		case "3":
			System.out.println("--VIEW MY CARS--");	
			
			mngAudiCarPay.viewAudiCarsAndPaymentInfo(username);
			
			customerMenu(username,password);
			
			log.info("customerMenu: Customer("+ username +") given Customer Menu Options");
			break;
		
		case "4":
			System.out.println("--VIEW MY PAYMENT HISTORY--");
			
			mngAudiCarPay.customerPaymentHistory(username);
			
			customerMenu(username, password);
			
			log.info("customerMenu: Customer("+ username +") was given Customer Menu Options");
			break;
		
		case "5":
			System.out.println("--MAKE MONTHLY PAYMENTS--");
			
			mngAudiCarPay.viewAudiCarsAndPaymentInfo(username);
			
			System.out.println("Enter Vehicle Identification Number(VIN): ");
			
			vinNumber = scan.nextLine();
			username_id = userDAO.readCustomerByUsername(username).getUserId();
			vinNumber_id = audiDAO.readCar(vinNumber).getCarId();
			
			mngAudiCarPay.createPayment(username_id,vinNumber_id,customer.getMonthlyPayment());
			
			customerMenu(username, password);
			
			log.info("customerMenu: Customer("+ username +") was given Customer Menu Options");
		
		case "6":
			System.out.println("--SIGNED OUT--");
			
			signInMenu();
			
			log.info("customerMenu: Customer("+ username +") Signed Out and sent back to SignIn Menu");
			break;
		
		default:
			System.out.println("Invalid choice, try again...");
			
			log.info("customerMenu:Invalid Customer Menu Choice Given");
			
			customerMenu(username, password);
			break;
		}
	}

//EmployeeMenu
	/**
	 * @param username
	 */
	public static void employeeMenu(String username, String password) {
		ViewAudi viewAudi = new ViewAudi();
		BidOnAudiCar bidOnAudi = new BidOnAudiCar();
		RegisterAudi regAudi = new RegisterAudi();
		RemoveRegisteredAudi rmvRegAudi = new RemoveRegisteredAudi();
		RemoveUser rmvCustomer = new RemoveUser();
		ManageAudiCarPayments mngAudiCarPay = new ManageAudiCarPayments();
		String userInput, vinNumber, model, year, customer;
		Double price;
		Scanner scan = new Scanner(System.in);

		System.out.println("\nEMPLOYEE MENU: \n Hello " + username);
		System.out.println(
				"|-1. Explore Cars: \n|-2. Add Cars: \n|-3. Accept Offers: \n|-4. Remove Car From Lot: \n|-5. View All Customer Payments: \n|-6. Delete Customer Account: \n|-7. Sign Out");
		userInput = scan.nextLine();

		switch (userInput) {
		case "1":
			viewAudi.viewAudis(username, password);
			
			employeeMenu(username, password);
			
			log.info("customerMenu: Employee("+ username +") Viewed Audi's in car lot and given Employee Menu Options");
			break;
			
		case "2":
			String exit = "Y";
			do {
				System.out.println("--ADD CARS--");
				
				System.out.println("Enter VIN:");
				vinNumber = scan.nextLine();
				
				System.out.println("Enter Model:");
				model = scan.nextLine();
				
				System.out.println("Enter Year:");
				year = scan.nextLine();
				
				scan.nextLine();
				
				System.out.println("Enter price:");
				price = scan.nextDouble();
				
				regAudi.addAudiCar(vinNumber, model, year, price);
				
				vinNumber = "";
				model = "";
				year = "";
				price = 0D;
				
				employeeMenu(username, password);

				exit = scan.nextLine();

			} while (exit.equals("Y"));
			
			employeeMenu(username, password);
			
			log.info("employeeMenu: Employee("+ username +") stopped adding Audi's and given Employee Menu Options");
			break;
		
		case "3":
			System.out.println("\n--ACCEPT OFFER--");
			
			viewAudi.viewAudis(username, password);
			bidOnAudi.getCurrentOffers();
			
			System.out.println("Do you want to accept any offers? (Y) or (N)");
			exit = scan.nextLine();
			
			switch (exit) {
			
			case "Y":
				System.out.println("Enter Customer: ");
				customer = scan.nextLine();
				
				bidOnAudi.acceptOffer(customer);
				customer = "";
				vinNumber = "";
				
				employeeMenu(username, password);
				
				log.info("employeeMenu: Employee("+ username +") given Employee Menu Options");
				break;
			
			case "N":
				employeeMenu(username, password);
				
				log.info("employeeMenu: Employee("+ username +") stopped accepting offers and given Employee Menu Options");
			
			default:
				System.out.println("Invalid Entry. Try again.\n");
				
				employeeMenu(username, password);
				
				log.info("employeeMenu:Invalid Employee Entry. Employee("+ username +") should enter Y or N");
			}
			break;
		
		case "4":
			System.out.println("--REMOVE CARS--");
			viewAudi.viewAudis(username, password);
			
			System.out.println("Enter Car VIN:");
			vinNumber = scan.nextLine();
			
			rmvRegAudi.removeAudiCar(vinNumber);
			vinNumber = "";
			
			employeeMenu(username, password);
			
			log.info("employeeMenu: Employee("+ username +") given Employee Menu Options");
			break;
		
		case "5":
			System.out.println("--VIEW ALL PAYMENTS--");
			mngAudiCarPay.viewAllPayments();
			
			employeeMenu(username, password);
			
			log.info("employeeMenu: Employee("+ username +") given Employee Menu Options");
			break;
		
		case "6":
			System.out.println("--REMOVE CUSTOMER--\n");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			
			rmvCustomer.viewCustomers();
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("Enter Customer: ");
			customer = scan.nextLine();
			
			rmvCustomer.removeUser(username, password, customer);

			employeeMenu(username, password);
			
			log.info("employeeMenu: Employee("+ username +") Removed Customer ("+ customer +")");
			break;
		
		case "7":
			System.out.println("--SIGNED OUT--\n");
			signInMenu();
			
			log.info("employeeMenu: Employee("+ username +") Signed Out and sent back to SignIn Menu");
			break;
		
		default:
			System.out.println("Invalid choice, try again...");
			
			log.info("employeeMenu:Invalid Employee Menu Choice Given");
			
			employeeMenu(username, password);
			break;
		}
	}

}
