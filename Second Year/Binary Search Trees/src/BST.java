
/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author TODO
 *
 *************************************************************************/

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root; // root of BST

	/**
	 * Private node class.
	 */
	private class Node {
		private Key key; // sorted by key
		private Value val; // associated data
		private Node left, right; // left and right subtrees
		private int N; // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	// return number of key-value pairs in BST
	public int size() {
		return size(root);
	}

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	/**
	 * Search BST for given key. Does there exist a key-value pair with given key?
	 *
	 * @param key
	 *            the search key
	 * @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/**
	 * Search BST for given key. What is the value associated with given key?
	 *
	 * @param key
	 *            the search key
	 * @return value associated with the given key if found, or null if no such key
	 *         exists.
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/**
	 * Insert key-value pair into BST. If key already exists, update with new value.
	 *
	 * @param key
	 *            the key to insert
	 * @param val
	 *            the value associated with key
	 */
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * Tree height.
	 *
	 * Asymptotic worst-case running time using Theta notation: Theta(N) because the
	 * fucntion itself has only assignemnts and therefore will have a constant run
	 * time but the recursive call can be called N times with N bing the number of
	 * keys.TODO
	 *
	 * @return the number of links from the root to the deepest leaf.
	 *
	 *         Example 1: for an empty tree this should return -1. Example 2: for a
	 *         tree with only one node it should return 0. Example 3: for the
	 *         following tree it should return 2. B / \ A C \ D
	 */
	public int height() {

		int treeHeight = findHeightRecursive(root);
		return treeHeight;

	}

	public int findHeightRecursive(Node root) {
		if (root == null) {

			return -1;
		}

		else {
			int leftHeight = findHeightRecursive(root.left);
			int rightHeight = findHeightRecursive(root.right);

			if (leftHeight > rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;

		}

	}

	/**
	 * Median key. If the tree has N keys k1 < k2 < k3 < ... < kN, then their median
	 * key is the element at position (N+1)/2 (where "/" here is integer division)
	 *
	 * @return the median key, or null if the tree is empty.
	 */
	public Key median() {

		int pos = (this.size() - 1) / 2;
		Node tempReturnNode = medianRecursive(root, pos);
		if (tempReturnNode != null)
			return tempReturnNode.key;
		else
			return null;

	}

	public Node medianRecursive(Node root, int pos) {
		if (root == null)
			return null;
		int size = size(root.left);
		if (size > pos)
			return medianRecursive(root.left, pos);//
		else if (size < pos)
			return medianRecursive(root.right, pos - size - 1);
		else
			return root;
	}

	/**
	 * Print all keys of the tree in a sequence, in-order. That is, for each node,
	 * the keys in the left subtree should appear before the key in the node. Also,
	 * for each node, the keys in the right subtree should appear before the key in
	 * the node. For each subtree, its keys should appear within a parenthesis.
	 *
	 * Example 1: Empty tree -- output: "()" Example 2: Tree containing only "A" --
	 * output: "(()A())" Example 3: Tree: B / \ A C \ D
	 *
	 * output: "((()A())B(()C(()D())))"
	 *
	 * output of example in the assignment:
	 * (((()A(()C()))E((()H(()M()))R()))S(()X()))
	 *
	 * @return a String with all keys in the tree, in order, parenthesized.
	 */
	public String printKeysInOrder() {
		if (isEmpty()) {

			return "()";
		}
		String returnStr = "(";

		return printKeysInOrder(root, returnStr) + ")";

	}

	private String printKeysInOrder(Node x, String printStr) {

		printStr += "(";
		if (x.left != null)
			printStr = printKeysInOrder(x.left, printStr);
		printStr += ")" + x.key + "(";
		if (x.right != null)
			printStr = printKeysInOrder(x.right, printStr);
		printStr += ")";

		return printStr;

	}

	/**
	 * Pretty Printing the tree. Each node is on one line -- see assignment for
	 * details.
	 *
	 * @return a multi-line string with the pretty ascii picture of the tree.
	 */
	public String prettyPrintKeys() {

		if (isEmpty()) {
			return "-null";
		}

		String prefix = "";
		String printStr = "";// prettyPrintKeysRecursive(root, printStr, prefix);

		return prettyPrintKeysRecursive(root, printStr, prefix);

	}

	public String prettyPrintKeysRecursive(Node x, String printStr, String prefix) {
		if (x == null) {
			return prefix + "-null\n";
		}
		printStr += prefix + "-" + x.key + "\n" +

				prettyPrintKeysRecursive(x.left, printStr, prefix + " |") +

				prettyPrintKeysRecursive(x.right, printStr, prefix + "  ");

		return printStr;

	}

	/**
	 * Deteles a key from a tree (if the key is in the tree). Note that this method
	 * works symmetrically from the Hibbard deletion: If the node to be deleted has
	 * two child nodes, then it needs to be replaced with its predecessor (not its
	 * successor) node.
	 *
	 * @param key
	 *            the key to delete
	 */
	public void delete(Key key) {

		root = delete(root, key);

	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;// code coverage
			Node t = x;
			x = max(t.left);
			x.left = deleteMax(t.left);
			x.right = t.right;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Node max(Node root) {
		if (root == null)
			return null;
		if (root.right != null)
			return max(root.right);
		else
			return root;

	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

}
