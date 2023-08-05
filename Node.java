package LabProgram1214;

/**
 *
 * Node.java: Node class
 */

public class Node implements NodeInterface<Integer> {

	private Integer data;
	private Node left;
	private Node right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}

	public Integer getData() {
		return data;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setLeft(Node node) {
		this.left = node;
	}

	public void setRight(Node node) {
		this.right = node;
	}

	public String toString() {
		return "" + data;
	}
}
