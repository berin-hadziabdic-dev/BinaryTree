package com.revature.binarytree;

//** This Node class is provided for use with the BinaryTree class associated.
//* 
public class Node {
	
	private int data;
	private Node leftNode;
	private Node rightNode;
	
	public Node(int data, Node leftNode, Node rightNode) {
		super();
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public Node(int data) {
		super();
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	public Node() {
		super();
	}
	
//	public boolean lookup(Node node, int target) {
//		// Case 1, the node is empty, return false for target found
//		if (node == null) {
//			return false;
//		// Case 2, node contains target data, return true for target found
//		} else if(target == node.data) {
//			return true;
//		// Case 3, target is less than current node, proceed down left branch
//		} else if(target < node.data) {
//			return lookup(node.leftNode, target);
//		// Case 4, target is greater than current node, proceed down right branch
//		} else return lookup(node.rightNode, target);
//	}
//	
//	public Node insert(Node node, int data) {
//		// Case 1, the target node is empty, create and return new node
//		if(node == null) {
//			node = new Node(data);
//			return node;
//		// Case 2, data is less than current target, left branch
//		} else if(data <= node.data) {
//			node.setLeftNode(new Node(data));
//		// Case 3, data is greater than current target, right branch
//		} else {
//			node.setRightNode(new Node(data));
//		} return node;
//		
//	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((leftNode == null) ? 0 : leftNode.hashCode());
		result = prime * result + ((rightNode == null) ? 0 : rightNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		if (leftNode == null) {
			if (other.leftNode != null)
				return false;
		} else if (!leftNode.equals(other.leftNode))
			return false;
		if (rightNode == null) {
			if (other.rightNode != null)
				return false;
		} else if (!rightNode.equals(other.rightNode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
	}
}
