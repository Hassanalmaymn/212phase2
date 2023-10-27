package phoneBookApplication;

//CSC212 Data structures - Project phase I
//Fall 2023
//EDIT DATE:
//17/10/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)
public class Event {
	private String eventTitle;
	private String appoinmentTitle;
	private String date;
	// to check duration thats have'nt any conflicts
	private double staringTime;
	private double endingTime;
	// double is best way to compare between time
	private String location;
	// to handle with linkedList easily
	public LinkedListOfContacts contactsRelatedToThisEvent;// why?
	// if the event is appointment
	private Contact contactRelatedToTheAppointment;
	private boolean isAppoinment;

	public Event(String eventTitle, String date, double staringTime, double endingTime, String location) {
		this.eventTitle = eventTitle;
		this.date = date;
		this.staringTime = staringTime;
		this.endingTime = endingTime;
		this.location = location;
		this.isAppoinment = false;
		contactsRelatedToThisEvent = new LinkedListOfContacts();
	}

	public Event(String eventTitle, String date, double staringTime, double endingTime, String location,
			Contact relatedToTheAppointment) {
		this.eventTitle = eventTitle;
		this.date = date;
		this.staringTime = staringTime;
		this.endingTime = endingTime;
		this.location = location;
		this.contactRelatedToTheAppointment = new Contact(relatedToTheAppointment);
		this.isAppoinment = true;

	}
	public boolean gitIsAppointment() {
		return this.isAppoinment;
	}

	public void setAppointmentTitle(String appoinmentTitle) {
		this.appoinmentTitle = appoinmentTitle;
	}

	public String getAppointmentTitle() {
		return this.appoinmentTitle;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getStaringTime() {
		return staringTime;
	}

	public void setStaringTime(double staringTime) {
		this.staringTime = staringTime;
	}

	public double getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(double endingTime) {
		this.endingTime = endingTime;
	}

	@Override
	public String toString() {

		if (!contactsRelatedToThisEvent.isEmpty()) {
			this.contactsRelatedToThisEvent.findFirst();

			while (!this.contactsRelatedToThisEvent.isLast()) {

				System.out.println(this.contactsRelatedToThisEvent.Retrive().getContactName());

				this.contactsRelatedToThisEvent.findNext();
			}

			System.out.println(this.contactsRelatedToThisEvent.Retrive().getContactName());
		}
		System.out.println("this conacts shear event:");
		return "Event [  eventTitle=" + eventTitle + ", date=" + date + ", staringTime=" + staringTime + ", endingTime="

				+ endingTime + ", location=" + location + "]";

	}

}
