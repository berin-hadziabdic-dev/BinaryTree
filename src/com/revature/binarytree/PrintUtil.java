package com.revature.binarytree;

//** This PrintUtil class is intended to print a binary tree with the root node on the right
// and proceeding with the right and left node as "top and bottom" node moving to the right on 
// on the console. 
// The method is recursive in nature and utilzies an adjustable spacing based on the value of
// the constant COUNT.
//* 
public class PrintUtil {
	
	private static final int COUNT = 2; // values > 0 will make a readable printout.
	
	public void printUtil(Node root, int space) {
		
		// empty node case
		if (root == null) {
			return;
		}
		
		// increase space between lines
		space += COUNT;
		
		// print right node
		printUtil(root.getRightNode(), space);
		
		// current node after spaces
		for(int i = COUNT; i<space; i++) {
			System.out.print("  ");
		} System.out.println(root.getData() + "\n");
		
		// print left child
		printUtil(root.getLeftNode(), space);	
	}

}
