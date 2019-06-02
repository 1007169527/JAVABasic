
public class TreeTest {
	public static void main(String[] args) {
		Tree tree = new Tree();
		int value;
		System.out.println("Insert the following values: ");
		for (int i = 1; i <= 10; i++) {
			value = (int) (Math.random() * 100);
			System.out.print(value + " ");
			tree.insertNode(value);
		}
		System.out.println("\n\nPreorder traversal");
		tree.preorderTraversal();
		System.out.println("\n\nInorder traversal");
		tree.inorderTraversal();
		System.out.println("\n\nPostorder traversal");
		tree.postorderTraversal();
	}
}
