import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author
 * @version HT 2019
 */

class SortComparison {

	// INSERTION SORT
	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		if (a.length > 0) {
			double tempVal;
			for (int i = 1; i < a.length; i++) {
				for (int j = i; j > 0; j--) {
					if (a[j] < a[j - 1]) {
						tempVal = a[j];
						a[j] = a[j - 1];
						a[j - 1] = tempVal;

					}
				}
			}
			return a;
		}
		return null;

	}// end insertion sort

	// QUICK SORT
	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {
		if (a.length > 0) {
			quickSort(a, 0, a.length - 1);
			return a;
		}
		return null;
	}// end quick sort

	private static void quickSort(double arr[], int low, int high) {

		if (low < high) {

			// pi is partitioning index
			int pi = partition(arr, low, high);
			// Recursively sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	static int partition(double arr[], int low, int high) {
		double pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				double temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		double temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	// MERGE SORTS

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {
		 if (a.length>0) {
	            int low = 0;
	            int high = a.length - 1;

	            double[] temp = Arrays.copyOf(a, a.length);

	            for (int m = 1; m <= high - low; m = 2 * m) {
	                for (int bottom = low; bottom < high; bottom += 2 * m) {
	                    int mid = bottom + m - 1;
	                    int top = bottom + 2 * m - 1;

	                    merge(a, temp, bottom, mid, (top < high) ? top : high);
	                }
	            }
	            return a;
	        } else {
	            return null;
	        }
		
	}// end mergesortIterative

	
	 private static void merge(double[] a, double[] temp, int bottom, int mid, int top) {
	        int k = bottom, i = bottom, j = mid + 1;

	        while (i <= mid && j <= top) {
	            if (a[i] < a[j]) {
	                temp[k++] = a[i++];
	            } else {
	                temp[k++] = a[j++];
	            }
	        }

	        while (i <= mid && i < a.length) {
	            temp[k++] = a[i++];
	        }

	        for (i = bottom; i <= top; i++) {
	            a[i] = temp[i];
	        }
	    }
		

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) {
		int length = a.length;
		if (length < 2) {
			return null;
		}
		int mid = length / 2;
		double[] l = new double[mid];
		double[] r = new double[length - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < length; i++) {
			r[i - mid] = a[i];
		}
		mergeSortRecursive(l);
		mergeSortRecursive(r);

		mergeRecursive(a, l, r, mid, length - mid);

		return a;
	}// end mergeSortRecursive

	private static void mergeRecursive(double[] a, double[] l, double[] r, int leftSize, int rightSize) {
		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < leftSize) {
			a[k++] = l[i++];
		}
		while (j < rightSize) {
			a[k++] = r[j++];
		}
	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {
		if (a.length > 0) {
			int smallest_index;
			double temp;

			for (int i = 0; i < a.length - 1; i++) {
				// find smallest in unsorted array
				smallest_index = i;
				for (int j = i + 1; j < a.length; j++)
					if (a[j] < a[smallest_index])
						smallest_index = j;

				// Swap
				temp = a[smallest_index];
				a[smallest_index] = a[i];
				a[i] = temp;
			}

			return a;
		}
		return null;

	}// end selectionsort

	public static void main(String[] args) {
		// getting numbers into file
		/*File file = new File(
				"C:\\Users\\ellen\\OneDrive\\Documents\\Programming\\College\\Java Projects\\Second Year\\SortComparison\\src\\numbersSorted1000.txt");
		double a[] = new double[1000];
		int i = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				// System.out.println(st);
				a[i] = Double.parseDouble(st);
				i++;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// sort and get time
		// INSERTION
		double b[]=a.clone();
		double startTime = System.nanoTime();
		insertionSort(b);
		
		double endTime = System.nanoTime();
		double duration = (endTime - startTime) / 1000000;
		System.out.print(" "+ duration);

		// SELECTION
		double c[]=a.clone();
		startTime = System.nanoTime();
		selectionSort(c);
		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.print(" "+ duration);

		// QUICK
		double d[]=a.clone();
		startTime = System.nanoTime();
		quickSort(d);
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.print(" "+ duration);

		// MERGE REC
		double e[]=a.clone();
		startTime = System.nanoTime();
		mergeSortRecursive(e);
		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.print(" "+ duration);
		
		//MERGE ITERATIVE
		double f[]=a.clone();
		startTime = System.nanoTime();
		mergeSortIterative(f);
		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.print(" "+ duration);*/

	}

}// end class
