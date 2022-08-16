import java.util.Arrays;

public class Solution_sprint3_k {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        final int[] a = new int[arr.length];

        int lptr = left;
        int rptr = mid;

        for (int i = 0; i < a.length; i++) {
            if (lptr >= mid) {
                a[i] = arr[rptr];
                rptr++;
                continue;
            }

            if (rptr >= right) {
                a[i] = arr[lptr];
                lptr++;
                continue;
            }

            final int leftElement = arr[lptr];
            final int rightElement = arr[rptr];

            if (leftElement <= rightElement) {
                a[i] = leftElement;
                lptr++;
            } else {
                a[i] = rightElement;
                rptr++;
            }
        }

        return a;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if ((right - left) == 2) {
            final int leftEl = arr[left];
            final int rightEl = arr[right - 1];
            if (leftEl > rightEl) {
                swap(arr, left, right - 1);
            }
        }

        if ((right - left) > 2) {
            final int mid = (left + right) / 2 + 1;

            merge_sort(arr, left, mid);
            merge_sort(arr, mid, right);

            final int[] newArray = merge(arr, left, mid, right);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = newArray[i];
            }
        }
    }

    private static void swap(final int[] arr, final int left, final int right) {
        final int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}
