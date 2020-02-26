import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Ellen Whelan
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    
    @Test
    public void testIsEmpty() {//completed it mate
    	//test with empty list
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	assertEquals("Checking isEqual to an empty list - expecting a true return",true, testDLL.isEmpty());
    	
    	// test with non empty list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking isEqual to a non-empty list - expecting a false return",false, testDLL.isEmpty());
        
    }
    
    @Test
    public void testGet() { //completed it mate 
    	//test with empty list 
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();	
    	assertEquals("Checking get to a empty list - expecting a null return",null,testDLL.get(4));
    	
    	//test with non empty list with pos greater than list size
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking get to a non-empty list with pos greater than list size - expecting a null return",null,testDLL.get(7));
    	
    	//test with non empty list with pos less than zero
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking get to a non-empty list with pos less than zero - expecting a null return",null,testDLL.get(-2));
    	
    	//test with non empty list and viable pos
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertEquals("Checking get to a non-empty list with valid pos - expecting a 2 return",2,(int) testDLL.get(1));
    }
    
    @Test
    public void testDeleteAt() {
    	//test with empty list 
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	assertEquals("Checking deleteAt to a empty list - expecting a false return",false, testDLL.deleteAt(4));
    	
    	//test with non empty list and pos greater than list size
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking deleteAt to a non-empty list with pos greater than list size - expecting a false return",false, testDLL.deleteAt(7));
    	
    	//test with non empty list and pos less than zero
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking deleteAt to a non-empty list with pos less than zero  - expecting a false return",false, testDLL.deleteAt(-2));
    	
    	//test with non empty list and valid pos 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking deleteAt to a non-empty list with valid pos - expecting a true return",true, testDLL.deleteAt(1));
    	
    	//test with 2 element list delete at pos 0
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        assertEquals("Checking deleteAt to a 2 elem list at pos 0 - expecting a true return",true, testDLL.deleteAt(0));
        
    	//test with 2 element list delete at pos 1
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        assertEquals("Checking deleteAt to a 2 elem list at pos 1 - expecting a true return",true, testDLL.deleteAt(1));
        
    	//test with 1 element list delete
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals("Checking deleteAt to a 1 elem list at pos 0 - expecting a true return",true, testDLL.deleteAt(0));
    }
    
    @Test
    public void testReverse() {//completed it mate
    	//test with empty list 
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	testDLL.reverse();
    	assertEquals("Checking reverse to a empty list - expecting no change","", testDLL.toString());
    	
    	//test with non empty even list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.reverse();
    	assertEquals("Checking reverse to a even non-empty list - expecting","4,3,2,1", testDLL.toString());
    	
    	//test with odd list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.reverse();
    	assertEquals("Checking reverse to a odd non-empty list - expecting","3,2,1", testDLL.toString());
    }
    
    @Test
    public void testMakeUnique() {
    	//test with empty list 
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	testDLL.makeUnique();
    	assertEquals("Checking makeUnique to a empty list - expecting no change","", testDLL.toString());
    	
    	//test with non empty unique list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.makeUnique();
    	assertEquals("Checking makeUnique to a unique non-empty list - expecting","1,2,3,4", testDLL.toString());
    	
    	//test with non empty non unique list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,2);
        testDLL.makeUnique();
    	assertEquals("Checking makeUnique to a unique non-empty list - expecting","1,2,3", testDLL.toString());
    	
    }
    
    @Test
    public void testSizeOfList() {
    	//test empty list 
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	assertEquals("Checking sizeOfList to a empty list - expecting zero",0, testDLL.sizeOfList());
    	
    	//test one elem list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals("Checking sizeOfList to a one elem list - expecting",1, testDLL.sizeOfList());
        
    	//test normal list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking sizeOfList to a non-empty list - expecting",3, testDLL.sizeOfList());
    }
    
    @Test
    public void testPop() {
    	//test empty list
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	assertEquals("Checking pop to a empty list - expecting null",null,testDLL.pop());
    	
    	//test one element list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals("Checking pop to a one element list - expecting 1",1, (int)testDLL.pop());
        
    	//test non empty list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals("Checking pop to a non-empty list - expecting 1",1, (int)testDLL.pop());
    	
    	
    }
    
    @Test
    public void testPush() {
    	//test empty list
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(8);
    	assertEquals("Checking push to a empty list - expecting 8","8",testDLL.toString());
    	
    	//test non empty list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.push(17);
        assertEquals("Checking push to a non-empty list - expecting ","17,1,2,3",testDLL.toString());
    }
    
    @Test
    public void testEnqueue() {
    	//test empty list
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(8);
    	assertEquals("Checking enqueue to a empty list - expecting 8","8",testDLL.toString());
    	
    	//test non empty list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.enqueue(17);
        assertEquals("Checking enqueu to a non-empty list - expecting ","1,2,3,17",testDLL.toString());
    }
    
    @Test
    public void testDequeue() {
    	//test empty list
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	testDLL.dequeue();
    	assertEquals("Checking dequeue to a empty list - expecting null",null,testDLL.dequeue());
    	
    	//test one element list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals("Checking enqueu to a one elem list - expecting ",1,(int)testDLL.dequeue());
    	
    	//test non empty list 
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertEquals("Checking enqueu to a non-empty list - expecting ",1,(int)testDLL.dequeue());
    }
    
    @Test
    public void sampleTest() {
    	DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertBefore(0,2);
         testDLL.insertBefore(1,1);
         testDLL.insertBefore(2,2);
         testDLL.insertBefore(3,1);
         testDLL.insertBefore(4,1);
         testDLL.insertBefore(5,2);
         testDLL.insertBefore(6,1);
         testDLL.makeUnique();
     	assertEquals("Checking makeUnique  - expecting","2,1", testDLL.toString());
     	assertEquals("Checking get to a non-empty list with valid pos - expecting a null return",null,testDLL.get(2));
     
    }
    @Test
    public void sampleTest2() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        System.out.println(testDLL.toString());
        assertEquals("Checking deleteAt(0) on 2-element list deletes the head element from the list-expecting true",true, testDLL.deleteAt(0));
        System.out.println(testDLL.toString());
    }

}
