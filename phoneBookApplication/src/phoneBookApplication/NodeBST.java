package phoneBookApplication;

//CSC212 Data structures - Project phase I I
//Fall 2023
//EDIT DATE:
//02/12/2023
//TEAM:
//team-name or number name:JVMasters
//AUTHORS:
//authors-names , (443101853)(hassan almaymn),(mohammed aldarwish)(443100859),(abdulmalik almoghysib)(443101435)
public class NodeBST {
	public NodeBST left, right;
	public Contact data;
	public String key;

	public NodeBST(Contact data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.key = data.getContactName();
	}

	public NodeBST(Contact data, NodeBST left, NodeBST right) {
		this.data = data;
		this.key = data.getContactName();
		this.left = left;
		this.right = right;
	}

}
