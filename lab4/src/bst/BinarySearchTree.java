package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTVisualizer v = new BSTVisualizer("Fönster", 500, 500);
		tree.add(10);
		tree.add(25);
		tree.add(-26);
		tree.add(5);
		tree.add(-6);
		tree.add(22);
		tree.add(15);
		tree.add(-10);
		tree.add(-5);
		tree.add(8);
		tree.add(-25);
		tree.rebuild();
		v.drawTree(tree);
	}
	
	BinaryNode<E> root;
	private int size;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		size = 0;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E item) {
		if (root == null) {
			root = new BinaryNode<E>(item);
			size++;
			return true;
		} else
			return add(root,item);
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return getHeight(root);
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return getSize(root);
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print(root);
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		if(this.size == 0) return;
		@SuppressWarnings("unchecked")
		E[] a = (E[]) new Comparable[this.size];
		toArray(root, a, 0);
		root = buildTree(a, 0, a.length - 1);
	}
	
	private void print(BinaryNode<E> n) {
		if(n != null) {
			print(n.left);
			System.out.println(n.element);
			print(n.right);
		}
	}
	
	private int getSize(BinaryNode<E> n) {
		return size;
	}
	
	private boolean add(BinaryNode<E> n, E item) {
		int compResult = item.compareTo(n.element);
		if (compResult == 0) return false;
		if (compResult < 0) {
			if (n.left == null) {
				n.left = new BinaryNode<E>(item);
				size++;
				return true;
			} else return add(n.left,item);
		} else {
			if (n.right == null) {
				n.right = new BinaryNode<E>(item);
				size++;
				return true;
				} else return add(n.right,item);
		}
	}
	
	private int getHeight(BinaryNode<E> n) {
		if(n == null) return 0;
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}
	
	/**
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if(n == null) return index;
		int temp1 = toArray(n.left, a, index);
		a[temp1++] = n.element;
		int temp2 = toArray(n.right, a, temp1);
		return temp2;
	}
	
	/**
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		BinaryNode<E> subRoot = null;
		if(first > last) return null;
		int mid = (first + last)/2;
		subRoot = new BinaryNode<E>(a[mid]);
		subRoot.left = buildTree(a, first, mid-1);
		subRoot.right = buildTree(a, mid+1, last);
		return subRoot;
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
