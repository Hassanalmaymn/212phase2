package phoneBookApplication;

public class NodeBST {
	public int key;
	public Contact data;
	public NodeBST leftChild, rightChild;

	public NodeBST(int key, Contact data) {

		this.key = key;
		this.data = data;
	}

	public NodeBST(int key, Contact data, NodeBST leftChild, NodeBST rightChild) {
		super();
		this.key = key;
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

}
