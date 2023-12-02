package phoneBookApplication;

//CSC212 Data structures - Project phase I I
//Fall 2023
//EDIT DATE:
//02/12/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)
public class NodeC {

	private Contact data;
	private NodeC next;

	public NodeC(Contact data) {
		super();
		this.data = data;
		this.next = null;
	}

	public Contact getData() {
		return data;
	}

	public void setData(Contact data) {
		this.data = data;
	}

	public NodeC getNext() {
		return next;
	}

	public void setNext(NodeC nextt) {
		this.next = nextt;
	}

}
