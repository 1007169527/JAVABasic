//P782
class TreeNode {
	TreeNode leftNode;
	int data;
	TreeNode rightNode;

	public TreeNode(int nodeData) {
		data = nodeData;
		leftNode = rightNode = null;
	}

	public synchronized void insert(int insertData) {
		if (insertData < data) {
			if (leftNode == null)
				leftNode = new TreeNode(insertData);
			else
				leftNode.insert(insertData);
		} else if (insertData > data) {
			if (rightNode == null)
				rightNode = new TreeNode(insertData);
			else
				rightNode.insert(insertData);
		}
	}
}

public class Tree {
	private TreeNode root;

	public Tree() {
		root = null;
	}

	public synchronized void insertNode(int insertData) {
		if (root == null)
			root = new TreeNode(insertData);
		else
			root.insert(insertData);
	}

	public synchronized void preorderTraversal() {
		preorderHelper(root);
	}

	private void preorderHelper(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorderHelper(node.leftNode);
		preorderHelper(node.rightNode);
	}

	public synchronized void inorderTraversal() {
		inorderHelper(root);
	}

	private void inorderHelper(TreeNode node) {
		if (node == null)
			return;
		inorderHelper(node.leftNode);
		System.out.print(node.data + " ");
		inorderHelper(node.rightNode);
	}

	public synchronized void postorderTraversal() {
		postorderHelper(root);
	}

	private void postorderHelper(TreeNode node) {
		if (node == null)
			return;
		postorderHelper(node.leftNode);
		postorderHelper(node.rightNode);
		System.out.print(node.data + " ");
	}
}
