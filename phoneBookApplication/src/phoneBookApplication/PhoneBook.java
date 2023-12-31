package phoneBookApplication;

import java.util.Scanner;
import java.util.InputMismatchException;
//CSC212 Data structures - Project phase I I
//Fall 2023
//EDIT DATE:
//02/12/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)

public class PhoneBook {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		BST ContactsBST = new BST();
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
			System.out.println("4:schedule a new event / appointment");
			System.out.println("5:Print event/appointment details");
			System.out.println("6:Print contact has same first name");
			System.out.println("7:Print all events/appointment alphabetically");
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
			try {
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

					Addition = ContactsBST.insert(contact);// This condition to check if the Contacts is already exists
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
				if (ContactsBST.empty()) {
					System.out.println("No contacts exist!");
					break;
				}
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

						if (ContactsBST.SerachByName(ContactsBST.getRoot(), Name) == false)
							System.out.println("Wrong Name or Not Exists");

					}
					if (Chooice == '2') {

						System.out.print("Enter The Contac's Phone Number : ");
						String PNumber = input.nextLine();
						if (ContactsBST.SerachByPnumber(ContactsBST.getRoot(), PNumber) == false)
							System.out.println("Wrong Phone Number or Not Exists");

					}

					if (Chooice == '3') {

						System.out.print("Enter The Contac's Email Address : ");
						String Email = input.nextLine();

						if (ContactsBST.SerachByEmail(ContactsBST.getRoot(), Email) == false)
							System.out.println("Wrong Email Address or Not Exists");

					}

					if (Chooice == '4') {

						System.out.print("Enter The Contac's Address : ");
						String Address = input.nextLine();
						if (ContactsBST.SerachByAddress(ContactsBST.getRoot(), Address) == false)
							System.out.println("Wrong Address or Not Exists");

					}

					if (Chooice == '5') {

						System.out.print("Enter The Contac's Birthday : ");
						String Birthday = input.nextLine();
						if (ContactsBST.SerachByBirthday(ContactsBST.getRoot(), Birthday) == false)
							System.out.println("Wrong Birthday or Not Exists");

					}

					if (!(Chooice == '1' || Chooice == '2' || Chooice == '3' || Chooice == '4' || Chooice == '5'))
						System.out.println(" Wrong input Please Try Agin ");

				} while (!(Chooice == '1' || Chooice == '2' || Chooice == '3' || Chooice == '4' || Chooice == '5'));

				break;
//-----------------------------------------------------------------------------------------------------------				
			case 3:
				if (ContactsBST.empty()) {
				System.out.println("No contacts exist!");

				break;
			}
			System.out.print("Enter the name of the Contact you want to delete : ");
			String name = input.nextLine();
			Event e = eventList.search(name);

			/* boolean isDeleted = */

			if (e != null) {

				// int NumberOfEvents =
				// ContactsList.Search(name).EventsRelatedToThisContact.getSize();
				int NumberOfEvents = eventList.getSize();// //ContactsBST.retrieve().EventsRelatedToThisContact.getSize();
				   
				eventList.findFirst();
				    
						for (int i = 0; i < NumberOfEvents; i++) {

					// E.contactsRelatedToThisEvent.DeleteContactByName(name);
					if (eventList.retrieve() != null) {
						try {
						eventList.retrieve().contactsRelatedToThisEvent.DeleteContactByName(name);
						}catch(Exception pp) {
							
						}
						eventList.findNext();
						
					//	eventList.removeSpecific(e);
					}
				
						}
				
						
			} 
				
			boolean s = ContactsBST.rremove(name);
			
			if(s== true) {
				System.out.println("Contact Deleted Successfully!");
			}else {
				System.out.println("Contact not Exist");
			}

			/*
			 * if (ContactsBST.getRoot() == null) { eventList.removeAll(); }
			 */	break;

//-----------------------------------------------------------------------------------------------------------				
			case 4:

				if (ContactsBST.empty()) {
					System.out.println("No contact exist !");
					break;
				} // no contact exist
				boolean wrong = false;
				int choice = 0;
				System.out.println("Enter type:");
				System.out.println("1. event");
				System.out.println("2. appointment");
				try {

					choice = input.nextInt();
					input.nextLine();

				} catch (Exception t) {
					wrong = true;
					input.nextLine();
					System.out.println("Wrong input !");
				}
				if (wrong)
					break;
				if (choice == 1) {
					System.out.println("Enter  title of event :");

					String nameOftitle = input.nextLine();

					System.out.println("Enter contact name:");

					String contactname = input.nextLine();

					numberofreEnterWronginput = 0;// to limit Wrong input

					Contact contactinlinst = ContactsBST.Search(contactname);// to check this contact is exist?
					wrong = false;
					numberofreEnterWronginput = 0;
					while (contactinlinst == null && !wrong) {// to check this contact is exist,Search() return null
																// when not
						// exist;
						// condition true if we can't found this contact inside the list

						System.out.println("can't found this contact");

						System.out.println("Enter contact name agine please:");

						contactname = input.nextLine();
						// ContactsList
						contactinlinst = ContactsBST.Search(contactname);

						if (numberofreEnterWronginput == 3) { // limit Wrong input
							// here if condition true it will go out
							System.out.println("many wrong input bay.");
							wrong = true;
						}
						numberofreEnterWronginput++;
					} // end loob
					if (wrong)
						break;
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
					wrong = false;
					numberofreEnterWronginput = 0;

					while (Exceptionvalue && !wrong) {

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
							if (numberofreEnterWronginput == 3) { // limit Wrong input
								// here if condition true it will go out
								System.out.println("many wrong input bay.");
								wrong = true;
							}
							numberofreEnterWronginput++;
						}

					} // end (wrong input loop).
					if (wrong)
						break;
					// input.nextLine();
					System.out.println("Enter event location:");

					String location = input.nextLine();

					Event checkEvent = new Event(nameOftitle, eventdate, startingtimeofevent, endingtimeofevent,
							location);

//no need ----------------------------------------

					/*
					 * ContactsList.findFirst();
					 * 
					 * while (!ContactsList.isLast()) { // loop search and place the current on
					 * contactname
					 * 
					 * if (ContactsList.Retrive().equals(contactinlinst)) break;
					 * ContactsList.findNext(); }
					 */

					boolean ispossibl = ContactsBST.retrieve().EventsRelatedToThisContact.serchByTime(checkEvent);
					// to check if time is possible to initiate new event in class event so it will
					// not have any conflicts
					// IF true ,start (loop wrong input).
					wrong = false;
					numberofreEnterWronginput = 0;

					while (ispossibl && !wrong) {

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
							ispossibl = ContactsBST.retrieve().EventsRelatedToThisContact.serchByTime(checkEvent);

							input.nextLine();

						} catch (InputMismatchException errorDouble) {

							System.out.println("wrong input");

							ispossibl = true;

							input.next();
						}
						if (numberofreEnterWronginput == 3) { // limit Wrong input
							// here if condition true it will go out
							System.out.println("many wrong input bay.");
							wrong = true;
						}
						numberofreEnterWronginput++;
					} // end loop
					if (wrong)
						break;
					/*
					 * no need----------------------------------------------
					 * ContactsList.findFirst();
					 * 
					 * while (!ContactsList.isLast()) { // loop search and place the current on
					 * contactname to add event
					 * 
					 * if (ContactsList.Retrive().equals(contactinlinst)) break;
					 * ContactsList.findNext(); } // end loop search and place the current on
					 * contactname to add event
					 */
					ContactsBST.retrieve().EventsRelatedToThisContact.insert(checkEvent);
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

						contactinlinst = ContactsBST.Search(contactname);// to check this contact is exist?

						wrong = false;
						numberofreEnterWronginput = 0;

						while (contactinlinst == null && !wrong) {// to check this contact is exist,Search() return null
																	// when not
							// exist;
							// condition true if we can't found this contact inside the list

							System.out.println("can't found this contact");

							System.out.println("Enter contact name agine please:");

							contactname = input.nextLine();

							contactinlinst = ContactsBST.Search(contactname);

							if (numberofreEnterWronginput == 3) { // limit Wrong input
								// here if condition true it will go out
								System.out.println("many wrong input , who is the next contact?.");
								wrong = true;
							}
							numberofreEnterWronginput++;
						} // end loob

						/*
						 * no need ContactsList.findFirst();
						 * 
						 * while (!ContactsList.isLast()) { // loop search and place the current on
						 * contactname to add event
						 * 
						 * if (ContactsList.Retrive().equals(contactinlinst)) break;
						 * ContactsList.findNext(); } // end loop search and place the current on
						 * contactname to add event
						 */
						if (!wrong) {
							ispossibl = ContactsBST.retrieve().EventsRelatedToThisContact.serchByTime(checkEvent);
							if (ispossibl) {
								System.out.println("can't add this event to contact (conflicts)");
							} else {
								ContactsBST.retrieve().EventsRelatedToThisContact.insert(checkEvent);
								checkEvent.contactsRelatedToThisEvent.insert(contactinlinst);
								System.out.println("Event scheduled successfully!");
							}
						}

					}

					// if (wrong) break;

					eventList.insert(checkEvent);

					break;
				}

				else if (choice == 2) {
					System.out.println("Enter  title of appointment :");

					String nameOftitle = input.nextLine();

					System.out.println("Enter contact name:");

					String contactname = input.nextLine();

					numberofreEnterWronginput = 0;// to limit Wrong input

					Contact contactinlinst = ContactsBST.Search(contactname);// to check this contact is exist?
					wrong = false;
					numberofreEnterWronginput = 0;

					while (contactinlinst == null && !wrong) {// to check this contact is exist,Search() return null
																// when not
						// exist;
						// condition true if we can't found this contact inside the list

						System.out.println("can't found this contact");

						System.out.println("Enter contact name agine please:");

						contactname = input.nextLine();
						// ContactsList
						contactinlinst = ContactsBST.Search(contactname);

						if (numberofreEnterWronginput == 3) { // limit Wrong input
							// here if condition true it will go out
							System.out.println("many wrong input bay.");
							wrong = true;
						}
						numberofreEnterWronginput++;
					} // end loob
					if (wrong)
						break;
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

					Event checkEvent = new Event(nameOftitle, eventdate, startingtimeofevent, endingtimeofevent,
							location);

					// no need ----------------------------------------

					/*
					 * ContactsList.findFirst();
					 * 
					 * while (!ContactsList.isLast()) { // loop search and place the current on
					 * contactname
					 * 
					 * if (ContactsList.Retrive().equals(contactinlinst)) break;
					 * ContactsList.findNext(); }
					 */

					boolean ispossibl = ContactsBST.retrieve().EventsRelatedToThisContact.serchByTime(checkEvent);
					// to check if time is possible to initiate new event in class event so it will
					// not have any conflicts
					// IF true ,start (loop wrong input).
					wrong = false;
					numberofreEnterWronginput = 0;

					while (ispossibl && !wrong) {

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
							ispossibl = ContactsBST.retrieve().EventsRelatedToThisContact.serchByTime(checkEvent);

							input.nextLine();

						} catch (InputMismatchException errorDouble) {

							System.out.println("wrong input");

							ispossibl = true;

							input.next();
							numberofreEnterWronginput++;

						}
						if (numberofreEnterWronginput == 3) { // limit Wrong input
							// here if condition true it will go out
							System.out.println("many wrong input bay.");
							wrong = true;
						}
						numberofreEnterWronginput++;
					} // end loop
					if (wrong)
						break;
					/*
					 * no need----------------------------------------------
					 * ContactsList.findFirst();
					 * 
					 * while (!ContactsList.isLast()) { // loop search and place the current on
					 * contactname to add event
					 * 
					 * if (ContactsList.Retrive().equals(contactinlinst)) break;
					 * ContactsList.findNext(); } // end loop search and place the current on
					 * contactname to add event
					 */
					ContactsBST.retrieve().EventsRelatedToThisContact.insert(checkEvent);
					checkEvent.contactsRelatedToThisEvent.insert(contactinlinst);

					System.out.println("Appointment scheduled successfully!");
					eventList.insert(checkEvent);
					break;
				} else
					break;
			case 5:
				if (ContactsBST.empty()) {
					System.out.println("No contacts exist!");
					break;
				}
				if(eventList.isempty()) {
					System.out.println("No event exist!");
					break;
				}
				wrong = false;
				System.out.println("Enter search criteria: ");
				System.out.println(" ");
				System.out.println("1. contact name");
				System.out.println("2. Event tittle/appointment");
				System.out.println(" ");
				System.out.println(" ");
				choice = 0;
				try {// start loop wrong input
					System.out.print("Enter your choice:");
					choice = input.nextInt();
					input.nextLine();

				} catch (InputMismatchException errorchoice) {
					System.out.println("wrong input");

					Exceptionvalue = true;

					input.next();
				}

				while ((Exceptionvalue || choice < 1 || choice > 2) && !wrong) {
					Exceptionvalue = false;
					try {
						System.out.print("Enter your choice agine please:");
						choice = input.nextInt();
						input.nextLine();

					} catch (InputMismatchException errorchoice) {
						System.out.println("wrong input");
						wrong = true;
						Exceptionvalue = true;

						input.next();
					}
				} // end loop wrong input
				if (wrong) {
					break;
				}
				if (choice == 1) {

					System.out.print(" Enter contact name:");

					String contactname = input.nextLine();

					Contact contactinlinst = ContactsBST.Search(contactname);// to check this contact is exist?

					while (contactinlinst == null && !wrong) {// to check this contact is exist,Search() return null
																// when not
						// exist;
						// condition true if we can't found this contact inside the list

						System.out.println("can't found this contact");

						System.out.println("Enter contact name agine please:");

						contactname = input.nextLine();

						contactinlinst = ContactsBST.Search(contactname);

						if (numberofreEnterWronginput == 3) { // limit Wrong input
							// here if condition true it will go out
							System.out.println("many wrong input bay.");
							wrong = true;
						}
						numberofreEnterWronginput++;
					} // end loop
					if (wrong) {
						break;
					}
					/*
					 * ContactsList.findFirst();
					 * 
					 * while (!ContactsList.isLast()) {// loop search and place the current on
					 * contact name
					 */
//						if (ContactsList.Retrive().equals(contactinlinst)) {
					// ContactsList.Retrive().EventsRelatedToThisContact.printAllEvents();

					/*
					 * } ContactsList.findNext();
					 * 
					 * }
					 */// end loop search and place the current on contactname

					// if (ContactsList.Retrive().equals(contactinlinst))// check last element
					ContactsBST.retrieve().EventsRelatedToThisContact.printAllEvents();
				}

				if (choice == 2) {

					// eventList while to find check and print lincofcontact

					System.out.println("Enter the event title:");
					String eventtitle = input.nextLine();
					eventList.searhbytitle(eventtitle);
					/*
					 * try {
					 * 
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
					 * 
					 * ContactsList.findFirst();
					 * 
					 * ContactsList.Retrive().EventsRelatedToThisContact.searhbytitle(eventtitle);
					 * 
					 * while (!ContactsList.isLast()) {// loop search and place the current on
					 * contactname
					 * 
					 * ContactsList.findNext();
					 * 
					 * ContactsList.Retrive().EventsRelatedToThisContact.searhbytitle(eventtitle);
					 * 
					 * } // end loop search and place the current on contactname
					 * 
					 * } catch (Exception eventtitleErorr) {
					 * System.out.println("Can't found this event"); }
					 */
				}
				break;
//-------------------------------------------------------------------------------------------------------------------				
			case 6:
				if (ContactsBST.empty()) {
					System.out.println("No contacts exist!");
					break;
				}
				System.out.print("Enter The First Name : ");
				String Fname = input.nextLine();
				if (ContactsBST.SerachByFirstName(ContactsBST.getRoot(), Fname)==false)
					System.out.println("Wrong Birthday or Not Exists");

				break;
//---------------------------------------------------------------------------------------------------------------------				
			case 7:
				if (ContactsBST.empty()) {
					System.out.println("No contacts exist!");
					break;
				}
				if (!(eventList.isempty())) {

					eventList.findFirst();
					while (!eventList.isLast()) {
						if(!eventList.retrieve().contactsRelatedToThisEvent.isEmpty())
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
			}}catch(Exception e){
				System.out.println("Sorry! Please Restart The App");
			}
		}
		/*
		 * catch (InputMismatchException i) { System.out.println("wrong input"); }
		 */
	}
}
