package Vika3;

class BitonicPeakFinder 
{ 
    // Function to find bitonic point 
    // using binary search 
    static int binarySearch(int arr[], int left, int right) 
    { 
        // Base case to handle invalid ranges
        if (left > right) {
            return -1; 
        }

        int mid = left + (right - left) / 2; 

        // If the mid element is equal to its neighbors, handle it by choosing one side
        if (arr[mid] == arr[mid - 1] && arr[mid] == arr[mid + 1]) {
            // Choose to search both sides if they are equal
            int leftPeak = binarySearch(arr, left, mid - 1);
            if (leftPeak != -1) {
                return leftPeak;
            }
            return binarySearch(arr, mid + 1, right);
        }

        // Check if mid is the peak element
        if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
            return mid; 
        }

        // Go to right subarray if middle point is part of increasing subsequence
        if (arr[mid] < arr[mid + 1]) {
            return binarySearch(arr, mid + 1, right); 
        } 
        
        // Go to left subarray otherwise
        return binarySearch(arr, left, mid - 1); 
    } 
    
    // Driver program 
    public static void main (String[] args) 
    { 
        int arr[] = {1, 3, 8, 8, 16, 16, 4, 2}; 
        int n = arr.length; 
        int index = binarySearch(arr, 0, n - 1); 
        if (index != -1) {
            System.out.println("The peak element is: " + arr[index]); 
        } else {
            System.out.println("No peak element found"); 
        }
    } 
}
