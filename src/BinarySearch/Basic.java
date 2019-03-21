package BinarySearch;

public class Basic {


    public static void main(String[] args) {



        Basic ob = new Basic();
        int arr[] = { 2, 3, 7, 10, 14, 16};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearchRec(arr, 0, n - 1, x);
        result = ob.binarySearchItr(arr, 10);
        //result = ob.sorted_search(arr, 10);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);


    }

    int sorted_search(int[] elements, int target){
        if(elements == null || elements.length <= 0)
            return -1;
        int left = 0;
        int right = elements.length - 1;
        while(left < right){
            int middle = (left + right + 1) / 2;
            if(elements[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        if(elements[right] == target){
            return right;
        }
        return -1;

    }

    int binarySearchItr(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        int m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return Math.max(m, l);
    }

    int binarySearchRec(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchRec(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearchRec(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
