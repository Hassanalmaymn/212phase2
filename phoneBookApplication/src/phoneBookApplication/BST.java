package phoneBookApplication;

public class BST {
	NodeBST root, current;

	public BST() {
		this.root = this.current = null;
	}

	public void insert() {

	}

	public boolean remove(String key) {
		return false;
	}

	public boolean update(String key, Contact contact) {
		return false;
	}

	public boolean findKey(String key) {

		return false;
	}

	public boolean isFull() {
		return false;
	}

	public boolean empty() {
		return false;
	}

	public Contact retrieve() {
		return current.data;
	}

	public void deleteSub() {
		if (current == root)
			current = root = null;
		else {
			NodeBST p = current;

		}
	}

	public void traverse(Order ord) {

	}

}