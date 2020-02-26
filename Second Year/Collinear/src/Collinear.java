
// -------------------------------------------------------------------------
/**
 * This class contains only two static methods that search for points on the
 * same line in three arrays of integers.
 *
 * @author
 * @version 18/09/18 12:21:09
 */
class Collinear {

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in
	 * arrays a1, a2, a3. This method is static, thus it can be called as
	 * Collinear.countCollinear(a1,a2,a3)
	 * 
	 * @param a1:
	 *            An UNSORTED array of integers. Each integer a1[i] represents the
	 *            point (a1[i], 1) on the plain.
	 * @param a2:
	 *            An UNSORTED array of integers. Each integer a2[i] represents the
	 *            point (a2[i], 2) on the plain.
	 * @param a3:
	 *            An UNSORTED array of integers. Each integer a3[i] represents the
	 *            point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a
	 *         horizontal line.
	 *
	 *         Array a1, a2 and a3 contain points on the horizontal line y=1, y=2
	 *         and y=3, respectively. A non-horizontal line will have to cross all
	 *         three of these lines. Thus we are looking for 3 points, each in a1,
	 *         a2, a3 which lie on the same line.
	 *
	 *         Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they
	 *         are on the same line) if
	 * 
	 *         x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0
	 *
	 *         In our case y1=1, y2=2, y3=3.
	 *
	 *         You should implement this using a BRUTE FORCE approach (check all
	 *         possible combinations of numbers from a1, a2, a3)
	 *
	 *         ----------------------------------------------------------
	 *
	 * 
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of growth:Θ(N^3)
	 *
	 *         Explanation: Each for loop has an order of growth of N. As there is three for loops nested we multiply NxNxN and we get N^3 TODO
	 */
	static int countCollinear(int[] a1, int[] a2, int[] a3) {
		int count = 0;

		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				for (int k = 0; k < a3.length; k++) {
					if ((a1[i] * (-1)) + (a2[j] * (2)) + (a3[k] * (-1)) == 0) {
						count++;
					}
				}
			}
		}
		// TODO: implement this method
		return count;

	}

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in
	 * arrays a1, a2, a3. This method is static, thus it can be called as
	 * Collinear.countCollinearFast(a1,a2,a3)
	 * 
	 * @param a1:
	 *            An UNSORTED array of integers. Each integer a1[i] represents the
	 *            point (a1[i], 1) on the plain.
	 * @param a2:
	 *            An UNSORTED array of integers. Each integer a2[i] represents the
	 *            point (a2[i], 2) on the plain.
	 * @param a3:
	 *            An UNSORTED array of integers. Each integer a3[i] represents the
	 *            point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a
	 *         horizontal line.
	 *
	 *         In this implementation you should make non-trivial use of
	 *         InsertionSort and Binary Search. The performance of this method
	 *         should be much better than that of the above method.
	 *
	 *
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of Growth:Θ( N^2lgN)
	 *
	 *         Explanation: A nested for loop means an order of growth of N^2 and we multiply that by the order of growth for binary search which is lgN. insertion sort has an order of growth of N^2 but according to the properties of addition in asymptotic notation we discount it.
	 *
	 *
	 */
	static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
		int count = 0;
		sort(a3);
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				int key = (2 * a2[j]) - a1[i]; // x3=2x2-x1
				boolean result = binarySearch(a3, key);
				if (result)
					count++;
			}
		}
		return count;
	}

	// ----------------------------------------------------------
	/**
	 * Sorts an array of integers according to InsertionSort. This method is static,
	 * thus it can be called as Collinear.sort(a)
	 * 
	 * @param a:
	 *            An UNSORTED array of integers.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 *
	 *         ----------------------------------------------------------
	 *
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of Growth: N^2
	 *
	 *         Explanation: Two linear for-loops.
	 *
	 */
	static void sort(int[] a) {
		for (int j = 1; j < a.length; j++) {
			int i = j - 1;
			while (i >= 0 && a[i] > a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				i--;
			}
		}
	}

	// ----------------------------------------------------------
	/**
	 * Searches for an integer inside an array of integers. This method is static,
	 * thus it can be called as Collinear.binarySearch(a,x)
	 * 
	 * @param a:
	 *            A array of integers SORTED in ascending order.
	 * @param x:
	 *            An integer.
	 * @return true if 'x' is contained in 'a'; false otherwise.
	 *
	 *         ----------------------------------------------------------
	 *
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of Growth: Θ(lgN)
	 *
	 *         Explanation: Each time the loop iterates we divide the search space in 2 resulting in a logN order of growth
	 *
	 */
	static boolean binarySearch(int[] a, int x) {
		int key = x;
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key < a[mid])
				high = mid - 1;
			else if (key > a[mid])
				low = mid + 1;
			else
				return true;
		}
		// TODO: implement this method
		return false;
	}

}
