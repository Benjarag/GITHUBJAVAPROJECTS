package Vika3;

public class BitonicArrayFinder {

    // Function to find the peak index in a bitonic array
    public static int findPeak(int[] arr, int left, int right) {
        if (left > right) {
            return -1;  // Invalid range
        }

        int mid = left + (right - left) / 2;  // Calculate the middle index

        // Handle cases where mid is at the boundaries
        if (mid == 0) {
            return (arr[mid] > arr[mid + 1]) ? mid : -1;
        }
        if (mid == arr.length - 1) {
            return (arr[mid] > arr[mid - 1]) ? mid : -1;
        }

        // Check if mid is the peak element
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        }

        // Handle duplicates
        if (arr[mid] == arr[mid - 1] && arr[mid] == arr[mid + 1]) {
            int leftPeak = findPeak(arr, left, mid - 1);
            if (leftPeak != -1) {
                return leftPeak;
            }
            return findPeak(arr, mid + 1, right);
        }

        // Go to the right subarray if the middle point is part of the increasing subsequence
        if (arr[mid] < arr[mid + 1]) {
            return findPeak(arr, mid + 1, right);
        }

        // Otherwise, go to the left subarray
        return findPeak(arr, left, mid - 1);
    }

    // Function to perform binary search
    public static boolean binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // Function to check if an element exists in the bitonic array
    public static boolean findIfElementExists(int[] arr, int x) {
        int n = arr.length;
        int peak = findPeak(arr, 0, n - 1);

        if (peak == -1) {
            return false;  // Peak not found, invalid array
        }

        // Search in the increasing part
        if (binarySearch(arr, 0, peak, x)) {
            return true;
        }

        // Search in the decreasing part
        return binarySearch(arr, peak + 1, n - 1, x);
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};  // Example bitonic array
        int x = 4;  // Example value to search

        boolean found = findIfElementExists(arr, x);
        if (found) {
            System.out.println("Element " + x + " found in the array.");
        } else {
            System.out.println("Element " + x + " not found in the array.");
        }
    }
}


// function findPeak(arr, left, right):
//     if left > right:
//         return -1  // Invalid range

//     mid = left + (right - left) / 2  // Calculate the middle index

//     // Handle cases where mid is at the boundaries
//     if mid == 0:
//         return mid if arr[mid] > arr[mid + 1] else -1
//     if mid == length(arr) - 1:
//         return mid if arr[mid] > arr[mid - 1] else -1

//     // Check if mid is the peak element
//     if arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1]:
//         return mid

//     // Handle duplicates
//     if arr[mid] == arr[mid - 1] and arr[mid] == arr[mid + 1]:
//         leftPeak = findPeak(arr, left, mid - 1)
//         if leftPeak != -1:
//             return leftPeak
//         return findPeak(arr, mid + 1, right)

//     // Go to the right subarray if the middle point is part of the increasing subsequence
//     if arr[mid] < arr[mid + 1]:
//         return findPeak(arr, mid + 1, right)
    
//     // Otherwise, go to the left subarray
//     return findPeak(arr, left, mid - 1)

// function binarySearch(arr, left, right, target):
//     while left <= right:
//         mid = left + (right - left) / 2
//         if arr[mid] == target:
//             return true
//         else if arr[mid] < target:
//             left = mid + 1
//         else:
//             right = mid - 1
//     return false

// function findIfElementExists(arr, x):
//     n = length(arr)
//     peak = findPeak(arr, 0, n - 1)

//     if peak == -1:
//         return false

//     // Search in the increasing part
//     if binarySearch(arr, 0, peak, x):
//         return true
    
//     // Search in the decreasing part
//     if binarySearch(arr, peak + 1, n - 1, x):
//         return true

//     return false
