package phoneBookApplication;
//CSC212 Data structures - Project phase I
//Fall 2023
//EDIT DATE:
//17/10/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)
public class Contact implements Comparable<Contact> {
	private String contactName;
	private String contactPhonenumber;
	private String contactEmailAddress;
	private String contactAddress;
	private String contactBirthday;
	private String noteForContact;
	private String FirstName;
//to handle with linkedList easily
	public LinkedListOfEvents EventsRelatedToThisContact;

/// private Event 
	public Contact(String contactName, String contactPhonenuber, String contactEmailAddress, String contactAddress,
			String contactBirthday, String noteForContact) {
		this.EventsRelatedToThisContact = new LinkedListOfEvents();
		this.contactName = contactName;
		this.contactPhonenumber = contactPhonenuber;
		this.contactEmailAddress = contactEmailAddress;
		this.contactAddress = contactAddress;
		this.contactBirthday = contactBirthday;
		this.noteForContact = noteForContact;
		// save the first name for any new contact
	    String[] words = contactName.split(" ");
	    this. FirstName = words[0];
		 

	}
	public Contact(Contact contact) {
		this.contactAddress=contact.contactAddress;
		this.contactName=contact.contactName;
		this.contactPhonenumber=contact.contactPhonenumber;
		this.contactEmailAddress=contact.contactEmailAddress;
		this.contactBirthday=contact.contactBirthday;
		this.noteForContact=contact.noteForContact;
		this.FirstName=contact.FirstName;
		this.EventsRelatedToThisContact.findFirst();
		while(this.EventsRelatedToThisContact.isLast()) {
			contact.EventsRelatedToThisContact.insert(this.EventsRelatedToThisContact.retrieve());
			this.EventsRelatedToThisContact.findNext();
		}
		
		
		
	}

//getters and setters to handle with contact information 
	public String getContactName() {
		return contactName;
	}

	public String getFirstName() {
		return FirstName;
	}
	
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
		String[] words = contactName.split(" ");
		this. FirstName = words[0];
		
	}

	public void setContactPhonenumber(String contactPhonenumber) {
		this.contactPhonenumber = contactPhonenumber;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public void setContactBirthday(String contactBirthday) {
		this.contactBirthday = contactBirthday;
	}

	public void setNoteForContact(String noteForContact) {
		this.noteForContact = noteForContact;
	}

	public void setEventsRelatedToThisContact(LinkedListOfEvents eventsRelatedToThisContact) {
		EventsRelatedToThisContact = eventsRelatedToThisContact;
	}

	public String getContactPhonenumber() {
		return contactPhonenumber;
	}

	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public String getContactBirthday() {
		return contactBirthday;
	}

	public String getNoteForContact() {
		return noteForContact;
	}

//sorting contact in the linked list 
	@Override
	public int compareTo(Contact otherContact) {
		int result = this.contactName.compareTo(otherContact.getContactName());
		return result;
	}

	@Override
	public String toString() {
		return "ContactName=" + contactName + "\nContact Phone Number=" + contactPhonenumber
				+ "\nContact EmailAddress=" + contactEmailAddress + "\nContact Address=" + contactAddress
				+ "\nContact Birthday=" + contactBirthday + "\nNote For Contact=" + noteForContact ;
	}

}