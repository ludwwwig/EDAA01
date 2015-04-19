package bst;

import bst.BinarySearchTree.BinaryNode;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			return true;
		} else {
			return add(root, x);
		}
	}
	
	private boolean add(BinaryNode<E> node, E x) {
		int compResult = x.compareTo(node.element);
		if (compResult == 0) return false;
		if (compResult < 0) {
			if (node.left == null) {
				node.left = new BinaryNode<E>(x);
				return true;
			} else {
				return add(node.left, x);
			}
		} else {
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				return true;
			} else {
				return add(node.right, x);
			}
		}
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return findHeight(root);
	}
	private int findHeight(BinaryNode<E> node) {
		if (node == null)
	        return 0;
	    else {
	    	int r = findHeight(node.right);
	    	int l = findHeight(node.left);
	        return 1 + r > l ? r : l;
	    }
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return nodeCount(root);
	}
	private int nodeCount(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		}
		else {
			return 1 + nodeCount(node.right) + nodeCount(node.left);
		}
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}
	private void printTree(BinaryNode<E> node) {
		if (node != null) {
			printTree(node.left);
			System.out.println(node.element);
			printTree(node.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		@SuppressWarnings("unchecked")
		E[] a = (E[]) new Comparable[this.size()];
		toArray(root, a, 0); // nu är array:en filled
		for (E element : a)
			System.out.println(element);
		root = null;
		buildTree(a, 0, a.length-1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n == null) return index;
		int l = toArray(n.left, a, index);
		a[l++] = n.element;
		int r = toArray(n.right, a, l);
		return r;
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		int middle = (first + last)/2;
		if (last - first <= 0) {
			this.add(a[first]);
			return null;
		} else if (last-first == 1){
			this.add(a[first]);
			this.add(a[last]);
			return null;
		} else {
			this.add(a[middle]);
			buildTree(a, first, middle-1);
			buildTree(a, middle+1, last);
		}
		return this.root;
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
