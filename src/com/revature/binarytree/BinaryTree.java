package com.revature.binarytree;

//** This class generates a binary tree composed of Node class nodes with int for
// the datatype. It is ordered but not self-balancing. Several utility methods are 
// available including structure comparison between binary trees, finding max depth, 
// finding min and max values, as well as a separate print utility class which prints 
// a horizontal representation of the binary tree (see PrintUtil). Methods are primarily
// recursive in nature.
//* 
public class BinaryTree {
	
	private Node root;
	
	//** public access lookup() checks for the presence of an int value in the tree
	// returns true if the integer is present and false if the int is not present.
	// @params Node node = the root node of the binary tree in which we are searching
	// @params int target = the integer for which we are searching in the binary tree
	// @returns boolean, true if target was found in the tree, false if the target was 
	// not found in the tree or the tree value was null.
	//* 	
	public boolean lookup(Node node, int target) {
			// Case 1, the node is empty, return false for target found
			if (node == null) {
				return false;
			// Case 2, node contains target data, return true for target found
			} else if(target == node.getData()) {
				return true;
			// Case 3, target is less than current node, proceed down left branch
			} else if(target < node.getData()) {
				return lookup(node.getLeftNode(), target);
			// Case 4, target is greater than current node, proceed down right branch
			} else return lookup(node.getRightNode(), target);
	}

	//** public access insert() puts a value into the binary tree at the correct location 
	// to maintain Binary Search Tree status.
	// @params Node node = the root node of the binary tree in which we are inserting
	// @params int data = the value which we are inserting into the binary tree
	// @returns Node representing the root of the binary tree which has been modified
	//* 
	public Node insert(Node node, int data) {
		// Case 1, the target node is empty, create and return new node
		if(node == null) {
			node = new Node(data);
		// Case 2, data is less than current target, left branch
		} else if(data <= node.getData()) {
			node.setLeftNode(insert(node.getLeftNode(), data));
		// Case 3, data is greater than current target, right branch
		} else {
			node.setRightNode(insert(node.getRightNode(), data));
		}
		return node;
	}
	
	
	//** public access getSize() returns size of binary tree via count of nodes
	// @params Node node = the root node of the binary tree for which size is desired
	// @returns int representing the number of non-null nodes in the binary tree
	//* 
	public int getSize(Node node) {
		if(node == null) {
			return 0;
		} else return (getSize(node.getLeftNode()) + 1 + getSize(node.getRightNode()));
	}
	
	//** public access getMaxDepth() returns max depth of the binary tree (number of layers)
	// @params Node node = the root node of the binary tree for which depth is desired
	// @returns int representing the max depth of the binary tree including the root
	//* 
	public int getMaxDepth(Node node) {
		if(node == null) {
			return 0;
		} else {
			int lmax = getMaxDepth(node.getLeftNode());
			int rmax = getMaxDepth(node.getRightNode());
			if(lmax > rmax) {
				return lmax+1;
			} else return rmax+1;
		}
	}
	
	//** public access getMinValue() returns minimum value found in the array.
	// It works by traversing the left-most branches to the last leaf.
	// @params Node node = the root node of the binary tree for which min value is desired
	// @returns int representing the minimum value found in the binary tree
	//* 
	@SuppressWarnings("null")
	public int getMinValue(Node node) {
		Node holderNode = node;
		while(holderNode != null) {
			if(holderNode.getLeftNode()==null) {
				return holderNode.getData();
			} holderNode = holderNode.getLeftNode();
		} return holderNode.getData();
	} 
	
	//** public access getMaxValue() returns maximum value found in the array.
	// It works by traversing the right-most branches to the last leaf.
	// @params Node node = the root node of the binary tree for which max value is desired
	// @returns int representing the maximum value found in the binary tree
	//* 
	@SuppressWarnings("null")
	public int getMaxValue(Node node) {
		Node holderNode = node;
		while(holderNode != null) {
			if(holderNode.getRightNode()==null) {
				return holderNode.getData();
			} holderNode = holderNode.getRightNode();
		} return holderNode.getData();
	} 
	
	//** public access isSameStructure() checks if two trees have the same structure
	// It does not check for identical values within the tree but simply the same nodes
	// in the same locations.
	// @params Node tree1 = the first binary tree root node which is being checked
	// @params Node tree2 = the second binary tree root node which is being checked
	// @returns boolean true if the structures are the same, false if the structures are not
	//* 
	public boolean isSameStructure(Node tree1, Node tree2) {	
		// Check if both trees are null
		if (tree1 == null & tree2 == null) {
			return true;
		}
		// Check condition of trees
		else if(tree1 != null && tree2 != null) {
			return (isSameStructure(tree1.getLeftNode(), tree2.getLeftNode()) &&
				isSameStructure(tree1.getRightNode(), tree2.getRightNode()));
		}
		// If one is empty and one isn't
		else return false;
	}
	
	public BinaryTree(Node root) {
		super();
		this.root = root;
	}

	public BinaryTree() {
		super();
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
