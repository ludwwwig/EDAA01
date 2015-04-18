package bst;

public class Test {

	public static void main(String[] args) {
		BinarySearchTree<Integer> a = new BinarySearchTree<Integer>();
		Integer b = new Integer(10);
		System.out.println(a.add(1));
		System.out.println(a.add(2));
		System.out.println(a.add(3));
		System.out.println(a.add(4));
		System.out.println(a.add(5));
		System.out.println(a.add(0));
		System.out.println(a.add(0));
		a.add(100000);
		a.add(200);
		a.add(999);

		System.out.println(a.size());
		BSTVisualizer abc = new BSTVisualizer("tree", 300,300);
		abc.drawTree(a);
	}

}
