import java.util.Arrays;

public class ReverseSubarrayToSort {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 4, 3};
        int[] arr2 = {1, 2, 4, 5, 3};
        
        System.out.println(canBeSortedByReversingSubarray(arr1)); // Output: Yes
        System.out.println(canBeSortedByReversingSubarray(arr2)); // Output: No
    }

    public static String canBeSortedByReversingSubarray(int[] arr) {
        int n = arr.length;

        // Check if array is already sorted
        if (isSorted(arr)) {
            return "Yes";
        }

        // Find the leftmost and rightmost positions where the array is not sorted
        int left = 0, right = n - 1;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // Reverse the subarray from left to right
        reverse(arr, left, right);

        // Check if the array is sorted after reversing the subarray
        if (isSorted(arr)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    // Helper method to check if the array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Helper method to reverse a subarray
    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
