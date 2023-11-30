package phoneBookApplication;

public class BST {
	private NodeBST root, current;

	
	public NodeBST getRoot() {
		return root;
	}

	public void setRoot(NodeBST root) {
		this.root = root;
	}
	
	
	
	
	
	public BST() {
		this.root = this.current = null;
	}

	//------- add a new Contact to the BST -------------
	
	public boolean insert( Contact newContact ) {

		
		NodeBST p =root ;
		NodeBST q =root ;
		
		// chick if the contact is already exist in the BST 
		if( findkey(newContact.getContactName()) || SerachByNumber( root, newContact.getContactPhonenumber()) ) {
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
		boolean removed=false;
		NodeBST p;
		p=remove_helpper(key,this.root,removed);
		current=root=p;
		return removed;
}
	
	private NodeBST remove_helpper(String key, NodeBST p, boolean flag) {
		NodeBST q,child=null;
		if(p==null)return null;
		if (p.key.compareTo(key)<0)p.left=this.remove_helpper(key, p.left, flag);
		else if(p.key.compareTo(key)>0)p.right=this.remove_helpper(key, p.right, flag);
		else {
			flag=true;
			if(p.left!=null&&p.right!=null) {
				q=find_min(p.right);
				p.key=q.key;
				p.data=q.data;
				p.right=this.remove_helpper(q.key, p.right, flag);
				
			}else {
				if (p.right==null)child=p.left;
				else if(p.left==null)child=p.right;
				return child;
			}
				
		}
		return p;
				
		
	}

	private NodeBST find_min(NodeBST p) {
		while(p!=null && p.left!=null) {
			p=p.left;
		}
		return p;
	}

	public boolean update(Contact newContact) {
		
		remove(current.key); // delete the contact that u want to update it 
	
		return insert(newContact) ; // then add a new one 
		
	}

	public boolean findkey(String keytofind) {
        NodeBST tmp =root,previos=root;
//
        if (root ==null)return false;//empty


    while(tmp!=null) {
        previos=tmp;
        if(tmp.key.equalsIgnoreCase(keytofind)) {
            current=tmp;
        return true;
        }
      if(tmp.key.compareTo(keytofind)<=-1) {
          tmp=tmp.right;

      }
      else {
          tmp=tmp.left;
      }


    } 
    current=previos;
    return false;
}
	public Contact Search(String keytofind) {
        NodeBST tmp =root,previos=root;
//
        if (root ==null)return null;//empty


    while(tmp!=null) {
        previos=tmp;
        if(tmp.key.equalsIgnoreCase(keytofind)) {
            current=tmp;
        return current.data;
        }
      if(tmp.key.compareTo(keytofind)<=-1) {
          tmp=tmp.right;

      }
      else {
          tmp=tmp.left;
      }


    } 
    current=previos;
    return null;
}
	

	public boolean isFull() {
		
		return false;
	}

	public boolean empty() {
		return root==null;
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
	
//----------------------------------  Searching Methods  ------------------------------------------------------

	// we use it in {insert method} to ensure we can't add contact have same phone number 
    public boolean SerachByNumber( NodeBST node , String PhoneNumber) {
    	
    	if(node == null) {
    		return false;
    	}
    	
    	
    	boolean Left = SerachByNumber(node.left, PhoneNumber);
    	
    	if (node.data.getContactPhonenumber().equalsIgnoreCase(PhoneNumber)) {
	        
	        return true;
	    }
    	
    	boolean Right = SerachByNumber(node.right, PhoneNumber);
    	
    	
    	return Left || Right;
    }
	
    
    
   //============Name=======================
     public boolean SerachByName(NodeBST node, String name) {
    	
    	 
    	boolean found = false;
    	
    	if(node == null) {
    		return found ;
    	}
    	
    	
    	boolean Left = SerachByName(node.left, name);
    	
    	if (node.data.getContactName().equalsIgnoreCase(name)) {
    		System.out.println("Contact found!");
	        System.out.println(node.data.toString());
	        found = true;
    		
	    }
    	
    	boolean Right = SerachByName(node.right, name);
    	
    	
    	return found;
    }
	
     //============Phone Number ====================
     public boolean SerachByPnumber(NodeBST node, String Pnumber) {
    	
    	 
    	boolean found = false;
    	
    	if(node == null) {
    		return found ;
    	}
    	
    	
    	boolean Left = SerachByPnumber(node.left, Pnumber);
    	
    	if (node.data.getContactPhonenumber().equalsIgnoreCase(Pnumber)) {
    		System.out.println("Contact found!");
	        System.out.println(node.data.toString());
	        found = true;
    		
	    }
    	
    	boolean Right = SerachByPnumber(node.right, Pnumber);
    	
    	
    	return found;
    }
	
     //============Email=====================
     public boolean SerachByEmail(NodeBST node, String Email) {
    	
    	 
    	boolean found = false;
    	
    	if(node == null) {
    		return found ;
    	}
    	
    	
    	boolean Left = SerachByEmail(node.left, Email);
    	
    	if (node.data.getContactEmailAddress().equalsIgnoreCase(Email)) {
    		System.out.println("Contact found!");
	        System.out.println(node.data.toString());
	        found = true;
    		
	    }
    	
    	boolean Right = SerachByEmail(node.right, Email);
    	
    	
    	return found;
    }
	
     //============Address=======================
     public boolean SerachByAddress(NodeBST node, String Address) {
    	
    	 
    	boolean found = false;
    	
    	if(node == null) {
    		return found ;
    	}
    	
    	
    	boolean Left = SerachByAddress(node.left, Address);
    	
    	if (node.data.getContactAddress().equalsIgnoreCase(Address)) {
    		System.out.println("Contact found!");
	        System.out.println(node.data.toString());
	        found = true;
    		
	    }
    	
    	boolean Right = SerachByAddress(node.right, Address);
    	
    	
    	return found;
    }
	
   //============Birthday=====================
     public boolean SerachByBirthday(NodeBST node, String Bday) {
    	
    	 
    	boolean found = false;
    	
    	if(node == null) {
    		return found ;
    	}
    	
    	
    	boolean Left = SerachByBirthday(node.left, Bday);
    	
    	if (node.data.getContactBirthday().equalsIgnoreCase(Bday)) {
    		System.out.println("Contact found!");
	        System.out.println(node.data.toString());
	        found = true;
    		
	    }
    	
    	boolean Right = SerachByBirthday(node.right, Bday);
    	
    	
    	return found;
    }
     
   // for Case 6   
   //============First Name=====================
     public boolean SerachByFirstName(NodeBST node, String Fname) {
    	
    	 
    	boolean found = false;
    	
    	if(node == null) {
    		return found ;
    	}
    	
    	
    	boolean Left = SerachByFirstName(node.left, Fname);
    	
    	if (node.data.getFirstName().equalsIgnoreCase(Fname)) {
    		System.out.println("Contact found!");
	        System.out.println(node.data.toString());
	        found = true;
    		
	    }
    	
    	boolean Right = SerachByFirstName(node.right, Fname);
    	
    	
    	return found;
    } 
     
     
     
     
     
     
     
     
     
     

}