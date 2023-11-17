package phoneBookApplication;

public class NodeBST {
	NodeBST left, right;
	Contact data;
	String key;

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
