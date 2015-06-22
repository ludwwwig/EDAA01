package bst;

public class Test {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		System.out.println(tree.add(10));
		tree.add(5);
		tree.add(7);
		tree.add(10000);
		tree.add(1111000);
		tree.add(900);
		tree.add(55);
		tree.add(45);
		tree.add(67);
		tree.add(66);
		tree.add(93);
		tree.add(-585);
		
		tree.printTree();
		tree.rebuild();
		
		System.out.println(tree.size());
		BSTVisualizer abc = new BSTVisualizer("tree", 300,300);
		abc.drawTree(tree);
		
	}

}
