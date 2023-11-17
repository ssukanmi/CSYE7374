package edu.neu.csye7374;

import java.text.DecimalFormat;

/**
 * MidtermCSYE7374Fall23 STUDENT SKELETON
 * 
 * 
 * @author dpeters
 * 
 * A Person brings his car to U-Break-I-Fix (UBIF) repairs and afterwards has a HUGE repair bill. 
 * Use design patterns to write a program which models this experience, specifically:
 * 
 * GIVEN:
 * 
 * interface RepairProcedureAPI
 * interface ItemAPI
 * interface PersonAPI (partial skeleton)
 * 
 * COMPLETE THIS CODE SKELETON (a single class) USING INNER CLASSES and INNER INTERFACES
 * 
 * 1. USING APPROPRIATE DESIGN PATTERNS AS REQUIRED, Design a model which attaches dynamic responsibilities to a Repair Bill object
 *    and demonstrate that the customer's bill can be customized at run-time with SPECIFIC customer repair expenses (e.g. Alignment, Diagnostic etc.).
 * 2. Design new objects for MISCELLANEOUS expenses which leverage already existing (unmodified) Legacy classes (e.g. Wash, Wax, etc.);
 * 3. 20 POINTS: Use PersonAPI and DESIGN a LAZY SINGLETON FACTORY and COMPLETE the supplied Person class (partial code below) with Person demo() method to demonstrate your completed model.
 * 4. 40 POINTS: Using RepairProcedureAPI (code below), implement Alignment and Diagnostic using appropriate design pattern;
 * 5. 40 POINTS: Using the ItemAPI and DESIGN EAGER SINGLETON FACTORIES and COMPLETE (code below), design and implement Wash and Wax using appropriate design pattern;
 * 6. SUBMIT CODE SOLUTION BEFORE ALOTED TIME RUNS OUT as directed by TAs
 *
 */
public class MidtermRepairCSYE7374Fall23 {
	public static final int MAJOR = 4;
	public static final int MINOR = 5;
	public static final String[] DEV_LOG = {
			"initial revision",
			"* END OF DEV LOG DO NOT DELETE *"
	};
	public static final String VERSION = MAJOR + "." + MINOR + DEV_LOG.length;

	/*
	 * 
	 */

	/**
	 * interface RepairProcedureAPI is an API which all Repair Procedure subclasses implement
	 * to model the billing for repair procedures incurred during auto repair work.
	 * 
	 * @author dpeters
	 *
	 */
	public interface RepairProcedureAPI {
		
		/**
		 * get the identifying code
		 * 
		 * @return	String code(s) for the specific expenses billed in statement
		 */
		String getCode();
		/**
		 * get a String description of the billing statement to customer
		 * 
		 * @return	String description of the specific expenses billed in statement
		 */
		String getDesc();
		/**
		 * get the cost as billed to the customer for auto repair expenses
		 * 
		 * @return	cost as billed in statement
		 */
		double getCost();
	}

	public static class RepairBill implements RepairProcedureAPI {
		@Override
		public double getCost() {
			return 0;
		}

		@Override
		public String getCode() {
			return "";
		}

		@Override
		public String getDesc() {
			return "";
		}
	}

	public static abstract class RepairProcedureDecoratorAPI implements RepairProcedureAPI {
		@Override
		public String getCode() {
			return null;
		}
		@Override
		public String getDesc() {
			return null;
		}
		@Override
		public double getCost() {
			return 0;
		}
	}

	public static class Alignment extends RepairProcedureDecoratorAPI {
		public static final String DESC = ",\nAlignment: Wheel balancing and alignment";
		public static final String CODE = "\nALIGN";
		public static final double COST = 199.99;
		private final RepairProcedureAPI repairProcedureAPI;
		public Alignment(RepairProcedureAPI repairProcedureAPI) {
			this.repairProcedureAPI = repairProcedureAPI;
		}
		@Override
		public String getCode() {
			return repairProcedureAPI.getCode() + CODE;
		}
		@Override
		public String getDesc() {
			return repairProcedureAPI.getDesc() + DESC;
		}
		@Override
		public double getCost() {
			return repairProcedureAPI.getCost() + COST;
		}
	}

	public static class Diagnostic extends RepairProcedureDecoratorAPI {
		public static final String DESC = ",\nDiagnostic: Car system diagnostic";
		public static final String CODE = "\nDIAG";
		public static final double COST = 99.99;
		private final RepairProcedureAPI repairProcedureAPI;
		public Diagnostic(RepairProcedureAPI repairProcedureAPI) {
			this.repairProcedureAPI = repairProcedureAPI;
		}
		@Override
		public String getCode() {
			return repairProcedureAPI.getCode() + CODE;
		}
		@Override
		public String getDesc() {
			return repairProcedureAPI.getDesc() + DESC;
		}
		@Override
		public double getCost() {
			return repairProcedureAPI.getCost() + COST;
		}
	}



	public interface ItemFactoryAPI {
		public Item getItem();
	}

	public static class WashItemFactory implements ItemFactoryAPI {
		public static WashItemFactory instance = new WashItemFactory();

		private WashItemFactory() { }

		public Item getItem() {
			Item item =  new WashItem();
			item.setId(2222);
			item.setPrice(19.99);
			item.setName("Wash");
			item.setDescription("Washing of vehicle");
			return item;
		}
	}

	public static class WaxItemFactory implements ItemFactoryAPI {
		public static WaxItemFactory instance = new WaxItemFactory();

		private WaxItemFactory() { }

		public Item getItem() {
			Item item = new WaxItem();
			item.setId(1111);
			item.setPrice(14.99);
			item.setName("Wax");
			item.setDescription("Waxing of vehicle");
			return item;
		}
	}

	/**
	 *
	 */

	private interface ItemAPI {
		int getId();
		void setId(int id);
		double getPrice();
		void setPrice(double price);
		String getName();
		void setName(String name);
		String getDescription();
		void setDescription(String description);
	}


	public static class WashItem extends Item {}
	public static class WaxItem extends Item {}
	/**
	 * Item class to model a consumer item that is bought and sold.
	 * 
	 * @author dpeters
	 *
	 */
	public static class Item implements ItemAPI {

		private int id;
		private double price;
		private String name;
		private String description;
		/**
		 * (TO BE COMPLETED BY STUDENT)
		 */
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}


		/**
		 * return a String representation of the object state
		 */
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append("# ").append(id);
			sb.append(" $ ").append(price);
			sb.append(" ").append(name);
			sb.append(" '").append(description).append("'");
			
			return sb.toString();
		}
	}
	/**
	 */

	/**
	 *
	 */

	
	private interface PersonAPI {
		int getId();
		void setId(int id);
		int getAge();
		void setAge(int age);
		String getFirstName();
		void setFirstName(String firstName);
		String getLastName();
		void setLastName(String lastName);
	}

	public static class PersonFactory {
		private static PersonFactory instance;

		private PersonFactory() {
			instance = null;
		}

		public static synchronized PersonFactory getInstance() {
			if (instance == null) {
				instance = new PersonFactory();
			}
			return instance;
		}

		public Person getPerson() {
			return new Person();
		}
	}

	/**
	 * Person class to model a person hospitalized with a resulting medical bill.
	 * 
	 * @author dpeters
	 *
	 */
	public static class Person implements PersonAPI {
		/**
		 * (TO BE COMPLETED BY STUDENT)
		 */
		private int id;
		private int age;
		private String firstName;
		private String lastName;
		private double repairBill;

		@Override
		public int getId() {
			return id;
		}
		@Override
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public int getAge() {
			return age;
		}
		@Override
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String getFirstName() {
			return firstName;
		}
		@Override
		public void setFirstName(String name) {
			this.firstName = name;
		}
		@Override
		public String getLastName() {
			return lastName;
		}
		@Override
		public void setLastName(String name) {
			this.lastName = name;
		}
		public double getRepairBill() {
			return repairBill;
		}
		public void setRepairBill(double bill) {
			this.repairBill = bill;
		}

		/**
		 * return a String representation of the object state
		 */
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append("# ").append(id);
			sb.append(" ").append(firstName);
			sb.append(" ").append(lastName);
			sb.append(", age ").append(age);
			sb.append(", my bill ").append(repairBill);
			
			return sb.toString();
		}

		/**
		 * demonstrate the use of this class
		 */
		public static void demo() {
			System.out.println("\n\t" + Person.class.getName() + ".demo()...");

			PersonFactory personFactory = PersonFactory.getInstance();
			Person dan = personFactory.getPerson();
			dan.setId(1234);
			dan.setAge(21);
			dan.setFirstName("Daniel");
			dan.setLastName("Peters");
			System.out.println(dan);

			/**
			 * My UBIF repair Billing statement
			 * which include expenses for Alignment and Problem Diagnostic
			 * 
			 * (TO BE COMPLETED BY STUDENT)
			 */
			RepairProcedureAPI repairBill = new RepairBill();
			repairBill = new Alignment(repairBill);
			repairBill = new Diagnostic(repairBill);
			dan.setRepairBill(repairBill.getCost() + dan.getRepairBill());

			/**
			 * show all customer information with billing statement
			 */
			System.out.println(dan);
			
			/**
			 * My UBIF billing statement updated with added miscellaneous expenses from Legacy Objects
			 * which include miscellaneous expenses from Wash
			 * 
			 * (TO BE COMPLETED BY STUDENT)
			 */
			Item washItem = WashItemFactory.instance.getItem();
			System.out.println(washItem);
			double washPrice = washItem.getPrice();
			dan.setRepairBill(dan.getRepairBill() + washPrice);
			
			/**
			 * show all customer information with billing statement
			 */
			System.out.println(dan);
			
			/**
			 * My UBIF billing statement updated with added miscellaneous expenses from Legacy Objects
			 * which include miscellaneous expenses from Wax
			 * 
			 * (TO BE COMPLETED BY STUDENT)
			 *
			 */
			Item waxItem = WaxItemFactory.instance.getItem();
			System.out.println(waxItem);
			double waxPrice = waxItem.getPrice();
			dan.setRepairBill(dan.getRepairBill() + waxPrice);

			
			/**
			 * show all patient information with billing statement
			 */
			System.out.println(dan);
			
			System.out.println("\n\t" + Person.class.getName() + ".demo()... done!");
		}
	}
	public static void demo() {
		System.out.println("\n\t" + MidtermRepairCSYE7374Fall23.class.getName() + ".demo() [ version " + VERSION + " ] ...");
		
		Person.demo();
		
		System.out.println("\n\t" + MidtermRepairCSYE7374Fall23.class.getName() + ".demo() ... done!");
	}
}
