import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//TIMINGS
/*
 	       insertion selection  quick    mergerecursive merge iterative
numbers10: 0.004908  0.006419   0.013216 0.010949       0.040779



numbers100:  0.154053    0.186525  0.061546   0.115917  0.095151


numbers1000:  29.643889 7.305438   0.573168   1.057227  0.770643


numbers1000  8.895432   3.413332   0.575056   0.926206  0.547115
Duplicates:


numbersNearly  16.672092 5.999007  1.099139   1.191645   0.822372
Ordered1000: 


numbersReverse1000: 18.894156 5.373733 6.519314 0.926962 0.801605


numbersSorted1000:8.58355  4.498878  6.596718 0.880896   0.409676



a. Which of the sorting algorithms does the order of input have an impact on? Why?
 Insertion is
 best when the array is nearly sorted or enitirely sorted as ithas a minimum number of swaps to do.
  
b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
insertion when nearly sorted has minimum swaps to do and more to do when its less sorted. 
The worst case for insertion sort is when the array is inn reverse order
c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
insertion has the worst scalability
insertion sort performed worst 
d. Did you observe any difference between iterative and recursive implementations of merge
sort?merge iterative is slightly quicker
e. Which algorithm is the fastest for each of the 7 input files? merge iterative

 */
//-------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author
 * @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
	}

	@Test
	public void testInsertionSort() {

		// test on empty array
		double a[] = {};
		assertEquals("Testing insertion on empty", null, SortComparison.insertionSort(a));

		// test normal array
		double b[] = { 3, 6, 1, 4, 2, 7 };
		double r[]= {1,2,3,4,6,7};
		Assert.assertThat("testing insertion on non empty array ",SortComparison.insertionSort(b), IsEqual.equalTo(r) );
	}

	@Test
	public void testSelectionSort() {

		// test on empty array
		double a[] = {};
		assertEquals("Testing selection on empty", null, SortComparison.selectionSort(a));

		// test normal array
		double b[] = { 3, 6, 1, 4, 2, 7 };
		double r[]= {1,2,3,4,6,7};
		Assert.assertThat("testing selection on non empty array ",SortComparison.selectionSort(b), IsEqual.equalTo(r) );
	}

	@Test
	public void testQuickSort() {
		// test on empty array
		double a[] = {};
		assertEquals("Testing quick on empty", null, SortComparison.quickSort(a));

		// test normal array
		double b[] = { 3, 6, 1, 4, 2, 7 };
		double r[]= {1,2,3,4,6,7};
		Assert.assertThat("testing quick on non empty array ",SortComparison.quickSort(b), IsEqual.equalTo(r) );

	}

	@Test
	public void testMergeSortRecursive() {
		// test on empty array
		double a[] = {};
		assertEquals("Testing merge recursive on empty", null, SortComparison.mergeSortRecursive(a));

		// test normal array
		double b[] = { 3, 6, 1, 4, 2, 7 };
		double r[]= {1,2,3,4,6,7};
		Assert.assertThat("testing merge recursive on non empty array ",SortComparison.mergeSortRecursive(b), IsEqual.equalTo(r) );
	}

	@Test
	public void testMergeSortIterative() {
		// test on empty array
		double a[] = {};
		assertEquals("Testing merge iterative on empty", null, SortComparison.mergeSortIterative(a));

		// test normal array
		double b[] = { 3, 6, 1, 4, 2, 7 };
		double r[]= {1,2,3,4,6,7};
		Assert.assertThat("testing merge iterative on non empty array ",SortComparison.mergeSortIterative(b), IsEqual.equalTo(r) );
	}

	/**
	 * Main Method. Use this main method to create the experiments needed to answer
	 * the experimental performance questions of this assignment.
	 *
	 */
	public static void main(String[] args) {
		
		  
	}

}
