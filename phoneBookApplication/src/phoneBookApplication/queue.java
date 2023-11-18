package phoneBookApplication;

public class queue {
private NodeC head,tail;
private int size;
public void enqueue(Contact contact) {
	if(tail==null)
		head =tail=new NodeC(contact);
	else {
		tail.setNext(new NodeC(contact));
		tail=tail.getNext();
	}
	this.size++;
}
public Contact serve() {
	Contact c=head.getData();
	head=head.getNext();
	size--;
	if(size==0)
		tail=null;
	return c;
}
public boolean full() {
	return false;
}
public boolean empty() {
	return tail==null;
}
public int length() {
	return this.size;
}
}
