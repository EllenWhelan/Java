import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Doubly Linked List
 *
 * @version 3.1 09/11/15 11:32:15
 *
 * @author TODO
 */

@RunWith(JUnit4.class)
public class BSTTest {

	// TODO write more tests here.
	@Test
	public void testHeight() {
		// test empty list height
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking height of empty tree-expect -1", -1, bst.height());

		// test non empty list
		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5
		assertEquals("Checking height of tree", 4, bst.height());

	}

	@Test
	public void testMedian() {
		// test empty list median
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking median of empty tree-expect null", null, bst.median());

		// test non empty list
		bst.put(1, 1); // 6
		bst.put(3, 3); // / \
		bst.put(4, 4); // 3 8
		bst.put(6, 6);// / \ / \
		bst.put(7, 7);// 1 4 7 9
		bst.put(8, 8);
		bst.put(9, 9);//

		assertEquals("Checking median of tree-should return 6", bst.get(6), bst.median());
		
		//test where median is in left subtree
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		bst2.put(8, 8);
		bst2.put(6, 6);
		bst2.put(9, 9);
		bst2.put(2,2);
		bst2.put(4, 4);
		assertEquals("Checking median where median is in left tree and is 6", bst2.get(6), bst2.median());
	}

	@Test
	public void testPrintSimple() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		// System.out.println(bst.printKeysInOrder());
		assertEquals("Checking median of empty tree-expect empty brackets", "()", bst.printKeysInOrder());

		// test non empty list
		bst.put(6, 6);
		bst.put(3, 3);
		bst.put(8, 8);
		bst.put(1, 1);
		bst.put(4, 4);
		bst.put(7, 7);
		bst.put(9, 9);
		

		// System.out.println(bst.printKeysInOrder());
		assertEquals("Checking print of tree-should return 1,3,4,6,7,8,9", "(((()1())3(()4()))6((()7())8(()9())))",
		bst.printKeysInOrder());

	}

	/*
	 * @Test public void testPrettyPrint() { BST<Integer, Integer> bst = new
	 * BST<Integer, Integer>(); System.out.println(bst.prettyPrintKeys());
	 * //assertEquals("Checking median of empty tree-expect -null\n", "-null\n",
	 * bst.prettyPrintKeys()); // test non empty list bst.put(6, 6); bst.put(3, 3);
	 * bst.put(8, 8); bst.put(1, 1); bst.put(4, 4); bst.put(7, 7); bst.put(9, 9);
	 * System.out.println(bst.prettyPrintKeys()); }
	 */

	@Test
	public void testPrettyPrint() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree", "-null", bst.prettyPrintKeys());

		// -7
		// |-3
		// | |-1
		// | | |-null
		bst.put(7, 7); // | | -2
		bst.put(8, 8); // | | |-null
		bst.put(3, 3); // | | -null
		bst.put(1, 1); // | -6
		bst.put(2, 2); // | |-4
		bst.put(6, 6); // | | |-null
		bst.put(4, 4); // | | -5
		bst.put(5, 5); // | | |-null
						// | | -null
						// | -null
						// -8
						// |-null
						// -null

		String result = "-7\n" + " |-3\n" + " | |-1\n" + " | | |-null\n" + " | |  -2\n" + " | |   |-null\n"
				+ " | |    -null\n" + " |  -6\n" + " |   |-4\n" + " |   | |-null\n" + " |   |  -5\n"
				+ " |   |   |-null\n" + " |   |    -null\n" + " |    -null\n" + "  -8\n" + "   |-null\n"
				+ "    -null\n";

		assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
	}

	@Test
	public void testMax() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("testing empty tree", null, bst.max(null));
		bst.put(6, 6);
		bst.put(3, 3);
		bst.put(8, 8);
		bst.put(1, 1);
		bst.put(4, 4);
		bst.put(7, 7);
		bst.put(9, 9);
		// assertEquals("testing max-should return 9", 9,(int) bst.max(bst.root).val);
	}

	@Test
	public void testDeleteMax() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(6, 6);
		bst.put(3, 3);
		bst.put(8, 8);
		 bst.deleteMax();
		assertEquals("Testing delete root max","((()3())6())" ,bst.printKeysInOrder());
	}

	/*
	 * <p>
	 * Test {@link BST#delete(Comparable)}.
	 * </p>
	 */
	@Test
	public void testDelete() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.delete(1);
		assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5

		assertEquals("Checking order of constructed tree", "(((()1(()2()))3((()4(()5()))6()))7(()8()))",
				bst.printKeysInOrder());

		bst.delete(9);
		assertEquals("Deleting non-existent key", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete(6);
		assertEquals("Deleting node with single child", "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete(3);
		assertEquals("Deleting node with two children", "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
		
		//test where left branch is null
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		bst2.put(6,6);
		bst2.put(3,3);
		bst2.put(8, 8);
		bst2.put(9,9);
		bst2.delete(8);
		assertEquals("Deleting key 3 where left branch is null","((()3())6(()9()))", bst2.printKeysInOrder());
		
		
	}

	@Test
	public void testContains() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		// test empty list
		assertEquals("Testing contains on empty list ", false, bst.contains(4));
		// test non empty list false
		bst.put(6, 6);
		bst.put(3, 3);
		bst.put(8, 8);
		bst.put(1, 1);
		bst.put(4, 4);
		bst.put(7, 7);
		bst.put(9, 9);
		assertEquals("Testing contains on empty list ", false, bst.contains(2));
		// test non empty list true
		assertEquals("Testing contains on empty list ", true, bst.contains(4));
	}

	@Test
	public void testPut() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		// test null value
		bst.put(6, 6);
		bst.put(3, 3);
		bst.put(8, 8);
		bst.put(1, 1);
		bst.put(4, 4);
		bst.put(7, 7);
		bst.put(9, 9);
		
		bst.put(9,10);
		assertEquals("Testing put ",10,(int)bst.get(9));
		
		bst.put(4, null);
		assertEquals("Testing put with null value ","(((()1())3())6((()7())8(()9())))", bst.printKeysInOrder());
		
		
	}

}
