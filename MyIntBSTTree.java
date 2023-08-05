package LabProgram1214;

/**
*
*
* MyIntBSTTree.txt: the template file of MyIntBSTTree.java
* Student tasks: implement tasks #1 and #2 as specified in this file
*/

import java.util.*;

public class MyIntBSTTree {
	private Node root;

	public MyIntBSTTree() {
		root = null;
	}

	public int height() {
		// *** Student task ***
		/*
		 * Requirements: The height of a binary tree is the largest number of edges in a
		 * path from the root node to a leaf node. Essentially, it is the height of the
		 * root node. Note that if a tree has only one node, then that node is at the
		 * same time the root node and the only leaf node, so the height of the tree is
		 * 0, similary, the height of a tree with only two nodes is 1. Implement this
		 * method to return height of the tree
		 *** 
		 * Enter your code below ***
		 */

		return heightHelper(root);
	}

	private int heightHelper(Node node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(heightHelper(node.getLeft()), heightHelper(node.getRight()));
	}

	public int comparisons(Node node) {
		// *** Student task ***
		/*
		 * Requirements: Count and return how many comparisons performed to search for
		 * the argument node
		 *** 
		 * Enter your code below ***
		 */
		return comparisonsHelper(node, root);
	}

	private int comparisonsHelper(Node node, Node current) {
		if (current == null) {
			return 0;
		}
		if (current == node) {
			return 0;
		}
		if (node.getData() <= current.getData()) {
			return 1 + comparisonsHelper(node, current.getLeft());
		}
		return 1 + comparisonsHelper(node, current.getRight());
	}

	public int comparisons(int val) {

		// *** Student task ***
		/*
		 * Requirements: Overloaded method - Count and return how many comparisons
		 * performed to search for the node whose data equals the argument val.
		 *** 
		 * Enter your code below ***
		 */
		return comparisonsHelper(new Node(val), root);
	}

	public MyIntBSTTree buildBalancedTree() {

		// *** Student task ***
		/*
		 * Requirements: This method builds a balanced tree with values from the int arr
		 * and returns the new tree. The original tree remains unchanged after calling
		 * this method. Enter your code below ***
		 */
		List<Integer> sortedList = new ArrayList<Integer>();
		inOrderTraversal(root, sortedList);
		return buildBalancedTreeHelper(sortedList, 0, sortedList.size() - 1);
	}

	private MyIntBSTTree buildBalancedTreeHelper(List<Integer> sortedList, int start, int end) {
		if (start > end) {
			return new MyIntBSTTree();
		}
		int mid = start + (end - start) / 2;
		MyIntBSTTree newTree = new MyIntBSTTree();
		newTree.add(sortedList.get(mid));
		newTree.root.setLeft(buildBalancedTreeHelper(sortedList, start, mid - 1).root);
		newTree.root.setRight(buildBalancedTreeHelper(sortedList, mid + 1, end).root);
		return newTree;
	}

	public MyIntBSTTree buildWorstTree() {

		// *** Student task ***
		/*
		 * Requirements: Build and return a tree whose height is arr.length - 1 The
		 * original tree remains unchanged after calling this method. Enter your code
		 * below ***
		 */
		MyIntBSTTree tree = new MyIntBSTTree();

		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		inOrderTraversal(root, sortedList);
		buildBalancedTreeHelper(sortedList, 0, sortedList.size() - 1);

		buildWorstTreeHelper(tree, sortedList, 0, sortedList.size() - 1);
		return tree;
	}

	private void buildWorstTreeHelper(MyIntBSTTree tree, ArrayList<Integer> sortedList, int start, int end) {
		if (start > end) {
			return;
		}
		int mid = (start + end) / 2;
		Integer[] array = sortedList.toArray(new Integer[sortedList.size()]);
		tree.add(array[mid]);
		buildWorstTreeHelper(tree, sortedList, start, mid - 1);
		buildWorstTreeHelper(tree, sortedList, mid + 1, end);
	}

	/*
	 * tree.root = new Node(0);
	 * 
	 * // Add new nodes to the tree until the desired height is reached int height =
	 * height(); int heights = sortedList.size(); while (height < heights) {
	 * List<Node> leaves = (List<Node>) tree.getRoot(); for (Node leaf : leaves) {
	 * leaf.setLeft(new Node(0)); leaf.setRight(new Node(0)); } height++; }
	 * 
	 * return tree; }
	 */
	private void inOrderTraversal(Node node, List<Integer> sortedList) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeft(), sortedList);
		sortedList.add(node.getData());
		inOrderTraversal(node.getRight(), sortedList);
	}

	// **** DO NOT MODIFY CODE BEYOND THIS POINT ***
	public Node getRoot() {
		return root;
	}

	public void add(int data) {
		root = addHelper(root, data);
	}

	private Node addHelper(Node node, int data) {// add node helper
		if (node == null) {
			node = new Node(data);
		} else if (data <= node.getData()) {
			node.setLeft(addHelper(node.getLeft(), data));
		} else {
			node.setRight(addHelper(node.getRight(), data));// System.out.println(data);
		}
		return node;
	}

}
