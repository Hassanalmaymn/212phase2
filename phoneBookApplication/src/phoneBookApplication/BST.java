package phoneBookApplication;

public class BST {
	private NodeBST root, current;

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

	public boolean find(Relative rel) {
		switch (rel) {
		case root:
			current = this.root;
			break;
		case leftChild:
			if (current.left == null)
				return false;
			current = current.left;
			break;
		case rightChild:
			if (current.right == null)
				return false;
			current = current.right;
			break;
		case parent:
			if (current == root)
				return false;
			current = this.findParent(current, root);
			break;
		default:
			return false;

		}
		return true;
	}

	private NodeBST findParent(NodeBST p, NodeBST rt) {
		if (rt == null)
			return null;
		if (rt.left == null && rt.right == null)
			return null;
		else if (rt.right == p || rt.left == p)
			return rt;
		else {
			NodeBST q = this.findParent(p, rt.left);
			if (q != null)
				return q;
			else
				return this.findParent(p, rt.right);

		}

	}

	public void deleteSub() {
		if (current == root)
			current = root = null;
		else {
			NodeBST p = current;
			if (p != null)
				this.find(Relative.parent);
			if (current.left == p)
				current.left = null;
			else
				current.right = null;
			current = root;

		}
	}

	public boolean searchBtInOrderTraverse(NodeBST p,Contact contact) {

		
		}

}