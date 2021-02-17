package com.revature.binarytree;

//** This driver class for the BinaryTree shows some of the features of the 
// associated BinaryTree class.
//* 
public class BinaryTreeDriver {

	public static void main(String args[]) {

		PrintUtil printer = new PrintUtil();
		Node root = new Node(15);
		BinaryTree btree = new BinaryTree(root);

		btree.insert(root, 12);
		btree.insert(root, 18);
		btree.insert(root, 14);
		btree.insert(root, 16);
		btree.insert(root, 5);
		btree.insert(root, 21);
		btree.insert(root, 3);
		
		printer.printUtil(btree.getRoot(), 0);
		System.out.println("size of root: " + btree.getSize(root));
		System.out.println("root contains 5: " + btree.lookup(root, 5));
		System.out.println("root contains 25: " + btree.lookup(root, 25));
		System.out.println("Max depth is: " + btree.getMaxDepth(root));
		System.out.println("Min value is: "+ btree.getMinValue(root));
		System.out.println("Max value is: "+ btree.getMaxValue(root));	
	}


}
