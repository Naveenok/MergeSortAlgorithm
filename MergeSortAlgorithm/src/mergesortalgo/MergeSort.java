/**
 * 
 */
package mergesortalgo;

public class MergeSort {
	public int[] mergeSort(int[] array) {
		int n = array.length;
		if (n < 2) {
			return array;
		}
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int i = mid; i < n; i++) {
			right[i - mid] = array[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(array, left, right);
		return array;
	
	}

	public int[] merge(int[] array, int[] left, int[] right) {
		int nA = array.length;
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nL && j < nR) {
			if(left[i]<right[j]){
				array[k]=left[i];
				k=k+1;
				i=i+1;
			}
			else{
				array[k]=right[j];
				k=k+1;
				j=j+1;
			}
		}
		while (i<nL) {
			array[k]=left[i];
			k=k+1;
			i=i+1;
		}
		while (j<nR) {
			array[k]=right[j];
			k=k+1;
			j=j+1;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 12, 3, 5, 6, 2, 4, 20,10 };
		MergeSort m = new MergeSort();
		m.mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
