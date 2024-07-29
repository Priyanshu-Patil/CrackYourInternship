class Main {
	static int ceilSearch(int[] arr, int start, int end, int x) {
	    if (x == 0) return -1;
	    
	    while (start <= end) {
	        int mid = start + (end - start) / 2;
	        
	        if (x == arr[mid]) {
	            return mid;
	        } else if (x < arr[mid]) {
	            end = mid - 1;
	        } else {
	            start = mid + 1;
	        }
	    }
	    
	    return start;
	}
	
	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = arr.length;
		int x = 8;
		int index = ceilSearch(arr, 0, n - 1, x);
		if (index == -1)
			System.out.println("Ceiling of " + x
							+ " doesn't exist in array");
		else
			System.out.println("ceiling of " + x + " is "
							+ arr[index]);
	}
}