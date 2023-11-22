package phoneBookApplication;

public class BST {
	private NodeBST root, current;

	public BST() {
		this.root = this.current = null;
	}

	//------- add a new Contact to the BST -------------
	
	public boolean insert( Contact newContact ) {

		
		NodeBST p =root ;
		NodeBST q =root ;
		
		// chick if the contact is already exist in the BST
		if( findKey(newContact.getContactName())) {
			current = p;
			return false;
		}
		
		p = new NodeBST (newContact);
		
		// if the BST is empty let the new contact be the root 
		if(empty()) {
			
			root = current = p;
			return true;
		}
		else {
			
			// if the new contact name has name big than the current it will be in the right
						// example (current name = hassan , newContact name = ahmed)
			
			if(current.data.compareTo(newContact)>0) {
				
				current.left = p ;
			}
			// if the new contact name has name less than the current it will be in the left
			else {
				
				current.right = p ;
			}
			
			return true;
			
			
		}
		
		
		
		
	}
	
	//-----------------------------------------------------------------

	public boolean remove(String key) {
		return false;
	}

	public boolean update(Contact newContact) {
		
		remove(current.key); // delete the contact that u want to update it 
	
		return insert(newContact) ; // then add a new one 
		
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
		if(p==null) 
			return false;
			//base case if the node p is null it will return to  calls 
		
		this.searchBtInOrderTraverse(p.left, contact);// go to left child until find null
		if(p.data.equals(contact))return true;//check if contact is  or not  
		this.searchBtInOrderTraverse(p.right, contact);// go to right child if any
		
		return false;// finishing all calls without find any matching data so its unique 
		
		}

}