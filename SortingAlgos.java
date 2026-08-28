import java.util.*;
class Solution{
    public static String sortArray(int[] nums){

	// There are 10 Sorting Algos I should Master

        // 1. Select Sort
	// Find the smallest element in the unsorted portion, swap it into place, then skip the sorted portion.
	// Sorted portion grows from left to right, and we never need to examine it again.
 
        for(int i = 0; i < nums.length-1;i++){
            int minIndex = i;
            for(int j = i; j < nums.length;j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        //2. Bubble sort | Optimized Bubble sort using the swapped boolean to return immediately after one loop if the array is sorted

	// Bubble Sort repeatedly swaps adjacent elements that are out of order, pushing the largest element to the end,
	// then reduces the unsorted portion from the right so the sorted portion isn't checked again.

        for(int i = 0; i < nums.length-1; i++){
            boolean swapped = false;
            for(int j = 0; j < nums.length-1-i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }

            if(swapped != true) return Arrays.toString(nums);


        }



        //3. Insertion sort

	// Insertion Sort saves the current element (key), shifts larger elements in the sorted portion one position to the right,
	// then inserts the key into the space created.

        for(int i = 1; i < nums.length; i++){

            int key = nums[i];

            int j = i-1;

            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = key;
        }        

        //4. Merge sort
        divide(nums,0,nums.length-1);

        //5. Quick sort
        quicksort(nums,0,nums.length-1);

        //6. Heap sort
        heapsort(nums);

        //7. Counting sort

        int max = nums[0];

        for(int num: nums){
            max = Math.max(max,num);
        }

        int[] count = new int[max+1];

        for(int num: nums){
            count[num]++;
        }

        int index = 0;
        for(int i = 0; i < count.length; i++){
            
            while(count[i] > 0){
                nums[index++] = i;
                count[i]--;
            }
        }



        //8. Bucket Sort

        int max = 0;
        int min = 0;

        for(int num: nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        int range = max-min;

        int bucketRangeSize = 10;
        int bucketCount = range/bucketRangeSize+1;

        List<Integer>[] buckets = new List[bucketCount];

        for(int i = 0; i < bucketCount; i++){
            buckets[i] = new ArrayList<>();
        }

        for(int num: nums){
            int index = num/bucketRangeSize;
            buckets[index].add(num);
        }

        int k = 0;
        for(List<Integer> bucket: buckets){
            Collections.sort(bucket);

            for(int n: bucket){
                nums[k++] = n;
            }
        }


        //9. Radix Sort - ask what exp stands for
        // exp stands for exponent, but in Radix Sort it is more useful to think of it as the place-value multiplier.
        // exp = 1     → ones digit
        // exp = 10    → tens digit
        // exp = 100   → hundreds digit
        // exp = 1000  → stop

        int max = nums[0];

        for(int num: nums){
            max = Math.max(num,max);
        }
        
        for(int exp = 1; max/exp > 0; exp *=10){
            radixsort(nums,exp);
        }

        //10. Shell Sort

        shellsort(nums);
        
        //....................................

         return Arrays.toString(nums);

    }

    // Merge Sort

    public static void divide(int[] nums,int left,int right){
        

        if(left >= right) return;

        int mid = left + (right-left)/2;

        divide(nums,left,mid);
        divide(nums,mid+1,right);
        conquer(nums,left,mid,right);
        
    }

    public static void conquer(int[] nums, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[right-left+1];

        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= right){
            temp[k++] = nums[j++];
        }

        for(int x = 0; x < temp.length; x++){
            nums[x+left] = temp[x];
        }
    }


    // Quick Sort

    public static void quicksort(int[] nums,int left, int right){
        if(left >= right) return;

        int pivotIndex = partition(nums,left,right);
        quicksort(nums,left,pivotIndex-1);
        quicksort(nums,pivotIndex+1,right);
    }

    public static int partition(int[] nums, int left, int right){
        int i = left-1;

        int pivot = nums[right];

        for(int j = left; j < right; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i+1,right);
        return i+1;

    }

    // Heap Sort

    public static void heapsort(int[] nums){

        int n = nums.length;

        //Closecheck why the n/2-1?
        // The 3 formulas to remember
        
        // | Relationship | Formula       |
        // | ------------ | ------------- |
        // | Parent       | (i - 1) / 2 |
        // | Left child   | 2i + 1      |
        // | Right child  | 2i + 2      |

        // Heap sort entire array
        for(int i = n/2-1; i >= 0; i--){
            heapify(nums,n,i);
        }
        // Heap sort the shrinking array
        for(int i = n-1; i > 0; i--){
            swap(nums,i,0);
            heapify(nums,i,0);
        }
    }

    public static void heapify(int[] nums,int n, int i){
        int largest = i;

        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && nums[left] > nums[largest]){
            largest = left; 
        }
        if(right < n && nums[right] > nums[largest]){
            largest = right;
        }

        if(largest != i){
            swap(nums,i,largest);
            heapify(nums,n,largest);
        }
    }

    // Quick sort and Heap sort share the same swap

    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void radixsort(int[] nums, int exp){
        int n = nums.length;
        int[] count = new int[10];
        int[] output = new int[n];

        for(int num: nums){
            int digit = (num/exp)%10;
            count[digit]++;
        }

        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = nums.length-1; i >= 0; i--){
            int digit = (nums[i]/exp) % 10;
            output[count[digit]-1] = nums[i];
            count[digit]--;
        }

        System.arraycopy(output,0,nums,0,n);
    }



    // Shell sort

    public static void shellsort(int[] nums){

        int n = nums.length;

        for(int gap = n/2; gap > 0; gap /=2){

            for(int i = gap; i < nums.length; i++){

                int temp = nums[i];

                int j = i;

                while(j >= gap && nums[j-gap] > temp){
                    nums[j] = nums[j-gap];
                    j -= gap;
                }

                nums[j] = temp;

            }
        }

    }



    //................................................

    public static void main(String[] args){
        int[] nums = {3,5,73,5,12,1};

        // int[] nums = {1, 3, 5, 5, 12, 73};

        System.out.println(sortArray(nums));
    }
}



// | Algorithm          |        Best TC |     Average TC |              Worst TC |                          Space |  Stable | In-place | Best Used When                                                           |
// | ------------------ | -------------: | -------------: | --------------------: | -----------------------------: | :-----: | :------: | ------------------------------------------------------------------------ |
// | Selection Sort |        `O(n²)` |        `O(n²)` |               `O(n²)` |                         `O(1)` |    ❌    |     ✅    | Memory is extremely limited and swaps are expensive. Rarely used.        |
// | Bubble Sort    |        `O(n)`* |        `O(n²)` |               `O(n²)` |                         `O(1)` |    ✅    |     ✅    | Nearly sorted arrays (with early-exit optimization). Mostly educational. |
// | Insertion Sort |         `O(n)` |        `O(n²)` |               `O(n²)` |                         `O(1)` |    ✅    |     ✅    | Small or nearly sorted arrays. Used inside other sorting algorithms.     |
// | Shell Sort     | Depends on gap | Depends on gap | `O(n²)` (simple gaps) |                         `O(1)` |    ❌    |     ✅    | Faster than Insertion Sort in practice, but rarely used today.           |
// | Merge Sort     |   `O(n log n)` |   `O(n log n)` |          `O(n log n)` |                         `O(n)` |    ✅    |     ❌    | When you need guaranteed performance and stability.                      |
// | Quick Sort     |   `O(n log n)` |   `O(n log n)` |               `O(n²)` | `O(log n)` average (recursion) |    ❌    |     ✅    | General-purpose sorting. Often the fastest in practice on average.       |
// | Heap Sort      |   `O(n log n)` |   `O(n log n)` |          `O(n log n)` |                         `O(1)` |    ❌    |     ✅    | Guaranteed `O(n log n)` with constant extra space.                       |
// | Counting Sort  |     `O(n + k)` |     `O(n + k)` |            `O(n + k)` |                         `O(k)` |    ✅*   |     ❌    | Small range of integer values (grades, ages, IDs).                       |
// | Bucket Sort    |         `O(n)` |         `O(n)` |          `O(n log n)` |                         `O(n)` | Depends |     ❌    | Uniformly distributed data.                                              |
// | Radix Sort     |       `O(d·n)` |       `O(d·n)` |              `O(d·n)` |                         `O(n)` |    ✅    |     ❌    | Fixed-length integers or strings.                                        |




// Memory Trick

// I remember them like this:

// Quadratic Sorts

// | Algorithm | TC                                      | Stable |
// | --------- | --------------------------------------- | :----: |
// | Selection | `O(n²)`                                 |    ❌   |
// | Bubble    | `O(n²)` (`O(n)` best)                   |    ✅   |
// | Insertion | `O(n²)` (`O(n)` best)                   |    ✅   |
// | Shell     | Better than Insertion (depends on gaps) |    ❌   |


// Efficient Comparison Sorts
// | Algorithm | TC                   | Stable |
// | --------- | -------------------- | :----: |
// | Merge     | `O(n log n)`         |    ✅   |
// | Quick     | `O(n log n)` average |    ❌   |
// | Heap      | `O(n log n)`         |    ❌   |


// Linear / Non-comparison Sorts
// | Algorithm | TC             |  Stable |
// | --------- | -------------- | :-----: |
// | Counting  | `O(n+k)`       |    ✅*   |
// | Bucket    | `O(n)` average | Depends |
// | Radix     | `O(d·n)`       |    ✅    |

