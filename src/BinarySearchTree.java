// Import Statements
import java.util.Scanner;

public class BinarySearchTree<E extends Comparable> {
	private TreeNode<E> root;
	private int numberOfNodes = 0;

	private class TreeNode<E> {
		public E data;
		public TreeNode<E> left;
		public TreeNode<E> right;

		public TreeNode(E data) {
			this.data = data;
		}
	}

	boolean insert(E value) {
		TreeNode<E> node = new TreeNode<>(value);
		TreeNode<E> nodeParent = null;
		TreeNode<E> currentNode = root;
		if (root == null) {
			root = node;
			numberOfNodes++;
			return true;
		}
		while (currentNode != null) {
			nodeParent = currentNode;
			// compare values
			if (value.compareTo(currentNode.data) > 0) {
				currentNode = currentNode.right;
			}
			else if (value.compareTo(currentNode.data) < 0) {
				currentNode = currentNode.left;
			}
			else {
				return false;
			}
		}
		if (value.compareTo(nodeParent.data) < 0) {
			nodeParent.left = node;
		}
		else {
			nodeParent.right = node;
		}
		numberOfNodes ++;
		return true;
	}

	boolean remove(E value) {
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		// navigate to the node to remove or return false if it not in the tree
		boolean finished = false;
		while (current != null) {
			if (value.compareTo(current.data) < 0) { // smaller
				parent = current;
				current = current.left;
			}
			else if (value.compareTo(current.data) > 0) { // bigger
				parent = current;
				current = current.right;
			}
			else { // equal
				break;
			}
		}
		if (current == null) { // if the value is not int the tree
			return false;
		}
		// if the current node doesn't have a left child
		if (current.left == null) {
			// check if root node
			if (parent == null) {
				root = current.right;
			}
			else {
				if (value.compareTo(parent.data) < 0) {
					parent.left = current.right;
				}
				else {
					parent.right = current.right;
				}
			}
		}
		// if the current node has a left child
		else {
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			// navigate to the rightMost value in the subtree
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			// reconnect nodes
			current.data = rightMost.data;
			if (parentOfRightMost.right == rightMost) {
				parentOfRightMost.right = rightMost.left;
			}
			else {
				parentOfRightMost.left = rightMost.left;
			}
		}
		numberOfNodes--;
		return true;
	}

	boolean search(E value) {
		TreeNode<E> currentNode = root;
		while (currentNode != null) {
			if (value.compareTo(currentNode.data) == 0) {
				return true;
			}
			else if (value.compareTo(currentNode.data) < 0) {
				currentNode = currentNode.left;
			}
			else {
				currentNode = currentNode.right;
			}
		}
		return false;
	}

	void display(String message) { // in order traversal
	/*
	With inorder traversal, the left subtree of the current node is visited first recursively,
	then the current node, and finally the right subtree of the current node recursively.
	The inorder traversal displays all the nodes in a BST in increasing order.
	 */



	}

	int numberNodes() {
		return numberOfNodes;
	}

	int numberLeafNodes() {
		return 0;
	}

	int height() {
		return 0;
	}

}
