package phoneBookApplication;
//CSC212 Data structures - Project phase I
//Fall 2023
//EDIT DATE:
//17/10/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)
public class LinkedListOfContacts {

	private NodeC head;
	private NodeC current;
	private int size;

	public LinkedListOfContacts() {

		this.head = null;
		this.current = null;
		this.size = 0;
	}

	// check if the linked list is empty or not
	public boolean isEmpty() {
		return head == null;
	}

	// it is return true if the current contact is the last one
	public boolean isLast() {
		return current.getNext() == null;
	}

	public boolean isFull() {
		return false;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.getNext();
	}

	public Contact Retrive() {
		return current.getData();
	}

	public void Update(Contact c) {
		current.setData(c);
	}

	// newContact

	// this method adds a contact , but if it is already exists it will return false
	// otherwise true
	// The addition will be at the end of the LinkedList
	public boolean insert(Contact newContact) {

		if (head == null) {
			head = current = new NodeC(newContact);
			size++;
			return true;
		}

		NodeC tmp = head;
		while (tmp.getNext() != null) {// after loop : tmp =last
			// check if newContact is exist
			if (tmp.getData().getContactPhonenuber().equalsIgnoreCase(newContact.getContactPhonenuber())
					|| tmp.getData().getContactName().equalsIgnoreCase(newContact.getContactName()))
				return false;

			tmp = tmp.getNext();
		}
		if (tmp.getData().getContactPhonenuber().equalsIgnoreCase(newContact.getContactPhonenuber())
				|| tmp.getData().getContactName().equalsIgnoreCase(newContact.getContactName()))
			// check last element with newContact
			return false;

		sorting(newContact);
		return true;

	}

//search by first name only, if there more than contact have the same first name they will display
	public void SearchByFirstName(String firstName) {
		
		if(isEmpty()) {
			System.out.println("Contact List is Empty");
			return;
		}
		
		boolean NotFound=true;
		NodeC tmp=head;
		
		while(tmp != null) {
			if(tmp.getData().getFirstName().equalsIgnoreCase(firstName)) {
				
				System.out.println("Contacts found!");
				System.out.println(tmp.getData().toString());
				NotFound=false;
			} 
				
				tmp=tmp.getNext();
				
		}
				
		 if(NotFound == true) 
				System.out.println("Contact is not Exists");
				
		
	}
	
	


//---------- delete a contact  with maintaining the Linkedlist format ---------

	public boolean DeleteContactByName(String s) {
		   
		if (isEmpty()) {
	        System.out.println("Sorry Contact List is Empty!!");
	        return false;
	    }

	    NodeC choosen = new NodeC(Search(s));
	    
	    // If the contact to delete is the head of the list
	    if (head.getData()==choosen.getData()) {
	        head = head.getNext();
	        System.out.println("Contact Deleted Successfully!");
	        return true;
	    } else {
	        NodeC current = head;
	        NodeC previous = null;
	        boolean found = false;

	        while (current != null) {
	            if (current.getData()==choosen.getData()) {
	                found = true;
	                break;
	            }
	            previous = current;
	            current = current.getNext();
	        }

	        if (found) {
	            // Delete the contact by updating the 'next' reference
	            previous.setNext(current.getNext());
	            System.out.println("Contact Deleted Successfully!");
	            return true;
	        } else {
	            System.out.println("The Contact is not found to delete.");
	            return false;
	        }
	    }
	}

// search for a specific Contact By name
// use for delete and use in Linked list of Events 

	public Contact Search(String name) {

		NodeC tmp = head;
		if (head == null)
			return null;

		if (tmp.getData().getContactName().equalsIgnoreCase(name))
			return tmp.getData();
		else
			while (tmp != null) {
				if (tmp.getData().getContactName().equalsIgnoreCase(name))
					return tmp.getData();

				tmp = tmp.getNext();

			}

		return null;

	}

//============== Search methods for case 2 =======================

//============NAME==============
	public boolean searchByname(String name) {

		NodeC tmp = head;
		boolean found = false;

		while (tmp != null) {
			if (tmp.getData().getContactName().equalsIgnoreCase(name)) {
				System.out.println("Contact found!");
				System.out.println(tmp.getData().toString());
				found = true;
			}
			tmp = tmp.getNext();

		}

		return found;

	}

//============Phone NUMBER==============
	public boolean searchByPnumber(String PhoneNUMBER) {

		NodeC tmp = head;
		boolean found = false;

		while (tmp != null) {
			if (tmp.getData().getContactPhonenuber().equalsIgnoreCase(PhoneNUMBER)) {
				System.out.println("Contact found!");
				System.out.println(tmp.getData().toString());
				found = true;
			}
			tmp = tmp.getNext();

		}

		return found;

	}

//============Email==============
	public boolean searchByEmial(String Email) {

		NodeC tmp = head;
		boolean found = false;

		while (tmp != null) {
			if (tmp.getData().getContactEmailAddress().equalsIgnoreCase(Email)) {
				System.out.println("Contact found!");
				System.out.println(tmp.getData().toString());
				found = true;
			}
			tmp = tmp.getNext();

		}

		return found;

	}

//============Address==============
	public boolean searchByAddress(String Address) {

		NodeC tmp = head;
		boolean found = false;

		while (tmp != null) {
			if (tmp.getData().getContactAddress().equalsIgnoreCase(Address)) {
				System.out.println("Contact found!");
				System.out.println(tmp.getData().toString());
				found = true;
			}
			tmp = tmp.getNext();

		}

		return found;

	}

//============Birthday==============
	public boolean searchByBirthday(String Birthday) {

		NodeC tmp = head;
		boolean found = false;

		while (tmp != null) {
			if (tmp.getData().getContactBirthday().equalsIgnoreCase(Birthday)) {
				System.out.println("Contact found!");
				System.out.println(tmp.getData().toString());
				found = true;
			}
			tmp = tmp.getNext();

		}

		return found;

	}
// this is sorting method to find the correct place for the data and insert it in that place so it will be ordered
	public void sorting(Contact contact) {

		NodeC tmp;

		if (head.getData().compareTo(contact) > 0) {

			tmp = new NodeC(contact);

			tmp.setNext(head);

			head = tmp;
		} else {

			NodeC previous = null;

			current = head;

			while (current != null && current.getData().compareTo(contact) <= 0) {

				previous = current;

				current = current.getNext();

			}
// now we find the correct place
			tmp = new NodeC(contact);

			if (tmp != null) {

				tmp.setNext(current);

				previous.setNext(tmp);
				
				current = tmp;
			} 
			else
				previous.setNext(tmp);
			current = previous.getNext();
		}

		size++;

	}

}