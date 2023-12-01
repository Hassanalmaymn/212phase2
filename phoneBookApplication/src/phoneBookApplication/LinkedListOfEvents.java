package phoneBookApplication;

//CSC212 Data structures - Project phase I I
//Fall 2023
//EDIT DATE:
//17/10/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)
public class LinkedListOfEvents {
	private Node head;
	private int size;

	private Node current;

	public int getSize() {
		return size;
	}

	public LinkedListOfEvents() {
		current = head = null;
		size = 0;
	}

	public boolean isempty() {
		return head == null;
	}

	public boolean isFull() {
		return false;

	}

	public void findFirst() {
		this.current = this.head;
	}

	public void findNext() {

		current = current.next;

	}

	public boolean isLast() {
		return current.next == null;
	}

	public Event retrieve() {
		if(current!=null)
		return current.data;
		
		else return null;
	}

	// insert events ((((ordered)))) alphabetically
	public void insert(Event newEvent) {
		Node tmp;
		if (isempty()) {
			current = head = new Node(newEvent);
		} else {
			tmp = current.next;
			current.next = new Node(newEvent);
			current = current.next;
			current.next = tmp;
		}
		size++;
		this.sortEventLinkedList();
	}

// this method has O(n) performance 
	public void remove() {

		if (current == head) {
			head = head.next;
			current=head;
		} else {
			Node tmp = head;
			while (tmp.next != current) {
				tmp = tmp.next;

			}
			tmp = current.next;
			size--;
			if (current.next == null) {
				findFirst();
			} else
				current = current.next;
		}
	}

	// if we want change some data in nodes like sorting
	public void update(Event replaced) {
		current.data = replaced;
	}

	public Event search(String titleOrConactName){
		if (head == null)
			return null;
		findFirst();
		Node p=current;
		while (p!=null) {
			if (p.data.getEventTitle().equalsIgnoreCase(titleOrConactName))
				return p.data;

			p = p.next;
		}
		if (current.data.contactsRelatedToThisEvent.Search(titleOrConactName) != null)
			return current.data;
		p=current;
		while (p!=null) {
			if (p.data.contactsRelatedToThisEvent.Search(titleOrConactName) != null)
				return p.data;

			p = p.next;
		}
		
		return null;

	}

	public void searhbytitle(String title) {
		if (head == null) {
			System.out.println("no Events exist");

			return;
		}

		findFirst();
		while (current.next != null) {
			if (current.data.getEventTitle().equalsIgnoreCase(title)) {
				System.out.println(current.data.toString());
				/* return true; */
			}
			current = current.next;
		}
		if (current.data.getEventTitle().equalsIgnoreCase(title)) {
			System.out.println(current.data.toString());
			// @@@

		}

//***********************		

	}

	// to check if time is possible to initiate new event in class event so it will
	// not have any conflicts
	public boolean serchByTime(Event event) {
		if (head == null)
			return false;
		this.findFirst();
		while (current != null) {
			if (current.data.getDate().equalsIgnoreCase(event.getDate())
					&& ((event.getStaringTime() == current.data.getStaringTime())
							|| (current.data.getEndingTime() >= event.getStaringTime()
									&& event.getStaringTime() >= current.data.getStaringTime())
							|| (event.getEndingTime() == current.data.getEndingTime())
							|| (event.getStaringTime() < current.data.getStaringTime()
									&& event.getEndingTime() >= current.data.getStaringTime())
							|| (event.getEndingTime() < event.getStaringTime())

					))

				return true;
			current = current.next;
		}
		current = this.head;
		// change current to tmp
		return false;
	}

	// to sort the linked list alphabetically by using bubble sort method
	public void sortEventLinkedList() {
		findFirst();

		for (int i = 0; i < this.size - 1; i++) {

			findFirst();

			for (int j = 0; j < this.size - 1; j++) {
				if (current.data.getEventTitle()
						.compareToIgnoreCase(current.next.data.getEventTitle()) > current.next.data.getEventTitle()
								.compareToIgnoreCase(current.data.getEventTitle())) {
					Event tmp = current.data;
					current.data = current.next.data;
					current.next.data = tmp;
				}
				current = current.next;

			}

		}

	}

	// print all the events alphabetically
	public void printAllEvents() {
		findFirst();
		while (current != null) {
			System.out.println(current.data.toString());
			findNext();
		}
	}

	public void printAllContctsShareAnEvent(String title) {
		this.search(title).contactsRelatedToThisEvent.findFirst();

		while (this.search(title).contactsRelatedToThisEvent.Retrive() != null) {

			System.out.print(this.search(title).contactsRelatedToThisEvent.Retrive().toString() + " ");

			this.search(title).contactsRelatedToThisEvent.findNext();
		}
	}

//to make remove from main easier
	public void removeSpecific(Event event) {
		this.findFirst();
		Node p=current;
		while (p!=null) {
			if (p.data.equals(event)) {
				this.remove();
				return;
			}
			p=p.next;

		}
	}

	public void removeAll() {
		head = null;
		current = null;
		size = 0;
	}

}
