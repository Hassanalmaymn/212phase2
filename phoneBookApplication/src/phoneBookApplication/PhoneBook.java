package phoneBookApplication;

import java.util.Scanner;
import java.util.InputMismatchException;
//CSC212 Data structures - Project phase I
//Fall 2023
//EDIT DATE:
//17/10/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)

public class PhoneBook {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		LinkedListOfContacts ContactsList = new LinkedListOfContacts();
		LinkedListOfEvents eventList = new LinkedListOfEvents();

		int numberofreEnterWronginput = 0;
		int ChoosenChoice = 0;
		boolean Exceptionvalue = false;// this variable for the (wrong loop)
		while (ChoosenChoice != 8) {
			System.out.println("############################################");
			System.out.println("hello welcome to Phonebook list application ");
			System.out.println("please choose one of theese choices ");
			System.out.println("1:Add new contact ");
			System.out.println("2:Search for contact");
			System.out.println("3:Delete a contact");
			System.out.println("4:schedule a new event");
			System.out.println("5:Print event details");
			System.out.println("6:Print contact has same first name");
			System.out.println("7:Print all events alphabetically");
			System.out.println("8:Exit");
			System.out.println("############################################");
			// 8 so it will changes to false and exit from
			// the loop

			System.out.print("Enter your choice :");// no problem to change this line
			try {// here start wrong loop, can't change change this line
				ChoosenChoice = input.nextInt();// no problem to change this line

			} catch (Exception Errorchoice) {// can't change change this line

				System.out.println("wrong input");// can't change this line
				Exceptionvalue = true;// true to go inside loop,can't change this line

				input.next();// can't change this line

			}

			while (Exceptionvalue || ChoosenChoice < 1 || ChoosenChoice > 8) {// can't change this line exapt
																				// ||ChoosenChoice<1||ChoosenChoice>8)
				Exceptionvalue = false;// can't change this line
				try {// can't change this line
					System.out.print("Enter your choice agine :"); // no problem to change this line
					ChoosenChoice = input.nextInt();// no problem to change this line

				} catch (InputMismatchException Errorchoice) {// can't change this line

					System.out.println("wrong input"); // can't change this line
					input.next();//// here to fix problem and compiler wo't read it,can't change this line
					Exceptionvalue = true;
				} // can't change this line

			} // end (wrong loop) this loop it will repeated in the code

			input.nextLine(); // here to fix problem and compiler wo't read it

			// to make it run until user choose
			// switch is most appropriate with menus
			switch (ChoosenChoice) {
			case 1:
				boolean Addition = false;// This condition to check if Contacts is already exists
				numberofreEnterWronginput = 0;// to limit Wrong input

				while (!Addition) {
					Contact contact = null;// to fix local var

					String name = null, phoneNumber = null, EmailAddress = null, address = null, birthday = null,
							notes = null;// to fix local var

					Exceptionvalue = true;// go loop

					while (Exceptionvalue) {

						Exceptionvalue = false;

						System.out.print("please write Conact's   name :");

						name = input.nextLine();
						// to do: linked.search && loop wrong input
						System.out.print("please write Conact's  Phone number :");

						phoneNumber = input.nextLine();

						System.out.print("please write Conact's  Email address  :");

						EmailAddress = input.nextLine();

						System.out.print("please write Conact's address :");

						address = input.nextLine();

						System.out.print("please write Conact's  birthday in format of dd/mm/yyyy :");

						birthday = input.nextLine();

						System.out.print("please write notes about Conact :");

						notes = input.nextLine();

						// hello
						try {// to solve speace error

							contact = new Contact(name, phoneNumber, EmailAddress, address, birthday, notes);

						} catch (Exception erro) {

							System.out.println("wrong input");// can't change this line

							Exceptionvalue = true;// true to go inside loop,can't change this line
						}
					}

					Addition = ContactsList.insert(contact);// This condition to check if the Contacts is already exists
															// or no, and insert if dose not exists
					if (Addition == true)
						System.out.println("Contacts added successfully!");

					if (Addition == false) {
						System.out.println("This Contacts already exists");
						break;
					}

					if (numberofreEnterWronginput == 3) {// to limit Wrong input in loop,allowed only 3 times wrong
															// input
						Addition = true;// to end loop,and go to menu
						System.out.println("try agine ,many wrong input");
					}

					numberofreEnterWronginput++;

				} // end loop case 1
				break;
//-----------------------------------------------------------------------------------------------------------				
			case 2:

				char Chooice;
				do {

					System.out.println("Enter Search Criteria : ");
					System.out.println("1- Name ");
					System.out.println("2- Phone Number ");
					System.out.println("3- Email Address ");
					System.out.println("4- Address ");
					System.out.println("5- Birthday ");
					System.out.print("Enter Your Choice : ");
					Chooice = input.next().charAt(0);
					input.nextLine();

					if (Chooice == '1') {
						System.out.print("Enter The Contac's Name : ");
						String Name = input.nextLine();
						if (ContactsList.searchByname(Name) == false)
							System.out.println("Wrong Name or Not Exists");

					}
					if (Chooice == '2') {

						System.out.print("Enter The Contac's Phone Number : ");
						String PNumber = input.nextLine();
						if (ContactsList.searchByPnumber(PNumber) == false)
							System.out.println("Wrong Phone Number or Not Exists");

					}

					if (Chooice == '3') {

						System.out.print("Enter The Contac's Email Address : ");
						String Email = input.nextLine();
						if (ContactsList.searchByEmial(Email) == false)
							System.out.println("Wrong Email Address or Not Exists");

					}

					if (Chooice == '4') {

						System.out.print("Enter The Contac's Address : ");
						String Address = input.nextLine();
						if (ContactsList.searchByAddress(Address) == false)
							System.out.println("Wrong Address or Not Exists");

					}

					if (Chooice == '5') {

						System.out.print("Enter The Contac's Birthday : ");
						String Birthday = input.nextLine();
						if (ContactsList.searchByBirthday(Birthday) == false)
							System.out.println("Wrong Birthday or Not Exists");

					}

					if (!(Chooice == '1' || Chooice == '2' || Chooice == '3' || Chooice == '4' || Chooice == '5'))
						System.out.println(" Wrong input Please Try Agin ");

				} while (!(Chooice == '1' || Chooice == '2' || Chooice == '3' || Chooice == '4' || Chooice == '5'));

				break;
//-----------------------------------------------------------------------------------------------------------				
			case 3:

				System.out.print("Enter the name of the Contact you want to delete : ");
				String name = input.nextLine();

				boolean isDeleted = ContactsList.DeleteContactByName(name);

				if (isDeleted) {

					int NumberOfEvents = ContactsList.Search(name).EventsRelatedToThisContact.getSize();

					for (int i = 1; i <= NumberOfEvents; i++) {

						eventList.removeSpecific(eventList.search(name));

					}
				}

				break;
//-----------------------------------------------------------------------------------------------------------				
			case 4:

				System.out.println("Enter  title of event :");

				String nameOftitle = input.nextLine();

				System.out.println("Enter contact name:");

				String contactname = input.nextLine();

				numberofreEnterWronginput = 0;// to limit Wrong input

				Contact contactinlinst = ContactsList.Search(contactname);// to check this contact is exist?

				while (contactinlinst == null) {// to check this contact is exist,Search() return null when not
												// exist;
					// condition true if we can't found this contact inside the list

					System.out.println("can't found this contact");

					System.out.println("Enter contact name agine please:");

					contactname = input.nextLine();

					contactinlinst = ContactsList.Search(contactname);

					if (numberofreEnterWronginput == 3) { // limit Wrong input
						// here if condition true it will go out
						System.out.println("many wrong input bay.");
						System.exit(0);
					}
					numberofreEnterWronginput++;
				} // end loob

				System.out.println("Enter event date");

				String eventdate = input.nextLine();

				double startingtimeofevent = 0, endingtimeofevent = 0;

				try {// Start (wrong input loop).
					System.out.println("when the event will start?");

					startingtimeofevent = input.nextDouble();

					System.out.println("when the event will end?");

					endingtimeofevent = input.nextDouble();

					input.nextLine();// here to fix problem and compiler wo't read it

				} catch (Exception errorDouble) {

					System.out.println("wrong input");

					Exceptionvalue = true;

					input.next();

				}

				while (Exceptionvalue) {

					Exceptionvalue = false;

					try {
						System.out.println("sorry when the event will start?");
						startingtimeofevent = input.nextDouble();

						System.out.println("when the event will end?");
						endingtimeofevent = input.nextDouble();

						input.nextLine();// here to fix problem and compiler wo't read it

					} catch (Exception errorDouble) {

						System.out.println("wrong input ");

						Exceptionvalue = true;

						input.next();
					}
				} // end (wrong input loop).

				// input.nextLine();
				System.out.println("Enter event location:");

				String location = input.nextLine();

				Event checkEvent = new Event(nameOftitle, eventdate, startingtimeofevent, endingtimeofevent, location);

				ContactsList.findFirst();

				while (!ContactsList.isLast()) { // loop search and place the current on contactname

					if (ContactsList.Retrive().equals(contactinlinst))
						break;
					ContactsList.findNext();
				}

				boolean ispossibl = ContactsList.Retrive().EventsRelatedToThisContact.serchByTime(checkEvent);
				// to check if time is possible to initiate new event in class event so it will
				// not have any conflicts
				// IF true ,start (loop wrong input).

				while (ispossibl) {

					System.out.println("please change the time:");

					try {
						System.out.println("Enter event date");

						eventdate = input.nextLine();

						System.out.println("when the event will start?");

						startingtimeofevent = input.nextDouble();

						System.out.println("when the event will end?");

						endingtimeofevent = input.nextDouble();

						checkEvent = new Event(nameOftitle, eventdate, startingtimeofevent, endingtimeofevent,
								location);
						ispossibl = ContactsList.Retrive().EventsRelatedToThisContact.serchByTime(checkEvent);

						input.nextLine();

					} catch (InputMismatchException errorDouble) {

						System.out.println("wrong input");

						ispossibl = true;

						input.next();
					}
				} // end loop

				ContactsList.findFirst();

				while (!ContactsList.isLast()) { // loop search and place the current on contactname to add event

					if (ContactsList.Retrive().equals(contactinlinst))
						break;
					ContactsList.findNext();
				} // end loop search and place the current on contactname to add event

				ContactsList.Retrive().EventsRelatedToThisContact.insert(checkEvent);
				checkEvent.contactsRelatedToThisEvent.insert(contactinlinst);

				System.out.println("Event scheduled successfully!");

				int numOfContacts = 0;

				try {// Start (wrong input loop).
					System.out.print("how many conacts you want to make Event with please write a number ? : ");

					numOfContacts = input.nextInt();

				} catch (InputMismatchException ErrornumOfContacts) {

					System.out.println("wrong input");

					Exceptionvalue = true;

					input.next();
				}
				while (Exceptionvalue) {
					Exceptionvalue = false;
					try {
						System.out.print(
								"how many conacts you want to make Event with please write a number agine pleaese? : ");

						numOfContacts = input.nextInt();

					} catch (Exception ErrornumOfContacts) {
						System.out.println("wrong input");

						Exceptionvalue = true;

						input.next();
					}
				}
				input.nextLine();// here to fix problem and compiler wo't read it
				for (int i = 0; i < numOfContacts; i++) {
					System.out.println("Enter contact name:");

					contactname = input.nextLine();

					numberofreEnterWronginput = 0;// to limit Wrong input

					contactinlinst = ContactsList.Search(contactname);// to check this contact is exist?

					while (contactinlinst == null) {// to check this contact is exist,Search() return null when not
													// exist;
						// condition true if we can't found this contact inside the list

						System.out.println("can't found this contact");

						System.out.println("Enter contact name agine please:");

						contactname = input.nextLine();

						contactinlinst = ContactsList.Search(contactname);

						if (numberofreEnterWronginput == 3) { // limit Wrong input
							// here if condition true it will go out
							System.out.println("many wrong input bay.");
							System.exit(0);
						}
						numberofreEnterWronginput++;
					} // end loob

					ContactsList.findFirst();

					while (!ContactsList.isLast()) { // loop search and place the current on contactname to add event

						if (ContactsList.Retrive().equals(contactinlinst))
							break;
						ContactsList.findNext();
					} // end loop search and place the current on contactname to add event

					ispossibl = ContactsList.Retrive().EventsRelatedToThisContact.serchByTime(checkEvent);
					if (ispossibl) {
						System.out.println("can't add this event to contact (conflicts)");
					} else {
						ContactsList.Retrive().EventsRelatedToThisContact.insert(checkEvent);
						checkEvent.contactsRelatedToThisEvent.insert(contactinlinst);
						System.out.println("Event scheduled successfully!");
					}

				}

				eventList.insert(checkEvent);

				break;
			case 5:
				System.out.println("Enter search criteria: ");
				System.out.println(" ");
				System.out.println("1. contact name");
				System.out.println("2. Event tittle");
				System.out.println(" ");
				System.out.println(" ");
				int choice = 0;
				try {// start loop wrong input
					System.out.print("Enter your choice:");
					choice = input.nextInt();
					input.nextLine();

				} catch (InputMismatchException errorchoice) {
					System.out.println("wrong input");

					Exceptionvalue = true;

					input.next();
				}

				while (Exceptionvalue || choice < 1 || choice > 2) {
					Exceptionvalue = false;
					try {
						System.out.print("Enter your choice agine please:");
						choice = input.nextInt();
						input.nextLine();

					} catch (InputMismatchException errorchoice) {
						System.out.println("wrong input");

						Exceptionvalue = true;

						input.next();
					}
				} // end loop wrong input

				if (choice == 1) {

					System.out.print(" Enter contact name:");

					contactname = input.nextLine();

					contactinlinst = ContactsList.Search(contactname);// to check this contact is exist?

					while (contactinlinst == null) {// to check this contact is exist,Search() return null when not
													// exist;
						// condition true if we can't found this contact inside the list

						System.out.println("can't found this contact");

						System.out.println("Enter contact name agine please:");

						contactname = input.nextLine();

						contactinlinst = ContactsList.Search(contactname);

						if (numberofreEnterWronginput == 3) { // limit Wrong input
							// here if condition true it will go out
							System.out.println("many wrong input bay.");
							System.exit(0);
						}
						numberofreEnterWronginput++;
					} // end loop
					ContactsList.findFirst();

					while (!ContactsList.isLast()) {// loop search and place the current on contact name

						if (ContactsList.Retrive().equals(contactinlinst)) {
							ContactsList.Retrive().EventsRelatedToThisContact.printAllEvents();

						}
						ContactsList.findNext();

					} // end loop search and place the current on contactname

					if (ContactsList.Retrive().equals(contactinlinst))// check last element
						ContactsList.Retrive().EventsRelatedToThisContact.printAllEvents();
				}

				if (choice == 2) {

					// eventList while to find check and print lincofcontact

					System.out.println("Enter the event title:");
					String eventtitle = input.nextLine();
					try {
						/*
						 * Event event =eventList.search(eventtitle);
						 * 
						 * eventList.findFirst();
						 * 
						 * while(!eventList.isLast()) { if(event.equals(eventList.search(eventtitle)))
						 * break;
						 * 
						 * }
						 * 
						 * System.out.println(eventList.retrieve().toString());
						 */
						ContactsList.findFirst();

						ContactsList.Retrive().EventsRelatedToThisContact.searhbytitle(eventtitle);

						while (!ContactsList.isLast()) {// loop search and place the current on contactname

							ContactsList.findNext();

							ContactsList.Retrive().EventsRelatedToThisContact.searhbytitle(eventtitle);

						}
						// end loop search and place the current on contactname

					} catch (Exception eventtitleErorr) {
						System.out.println("Can't found this event");
					}
				}
				break;
//-------------------------------------------------------------------------------------------------------------------				
			case 6:

				System.out.print("Enter The First Name : ");
				String Fname = input.nextLine();
				ContactsList.SearchByFirstName(Fname);

				break;
//---------------------------------------------------------------------------------------------------------------------				
			case 7:

				if (!(eventList.isempty())) {

					eventList.findFirst();
					while (!eventList.isLast()) {
						System.out.println(eventList.retrieve().toString());

						eventList.findNext();
					}
					System.out.println(eventList.retrieve().toString());
				} else
					System.out.println("Event List is Empty");
				/*
				 * System.out.
				 * print("please write contact name that you want to print his events :");
				 * String cntactName = input.nextLine(); System.out.println();
				 * ContactsList.Search(cntactName).EventsRelatedToThisContact.printAllEvents();
				 */
//				ContactsList.findFirst();
//				
//				while (!ContactsList.isLast()) {//loop search and place the current on contactname					
//				
//					ContactsList.Retrive().EventsRelatedToThisContact.printAllEvents();
//					
//					ContactsList.findNext();	
//				}				
//				ContactsList.Retrive().EventsRelatedToThisContact.printAllEvents();
				// @@@@@@@

				break;
			case 8:
				System.out.println("thank you for using our program good bye");
				System.exit(0);
				break;
			default:
				System.out.println("default");
				break;
			}
		}
		/*
		 * catch (InputMismatchException i) { System.out.println("wrong input"); }
		 */
	}
}
