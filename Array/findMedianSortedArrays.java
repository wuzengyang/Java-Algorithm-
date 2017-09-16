package array;

public class findMedianSortedArrays {
	
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 8};
		int[] b = {2, 4, 6};
		System.out.println(findMedianSortedArrays2(a, b));
	}
	
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // assume nums2 and nums2 both are not null
        // two different case: even total nums amout or odd amount
        // use two pointer
        
    	int length = nums1.length + nums2.length;
    	int cur = 0;
    	int pre = 0;
    	int i = 0, j = 0;
    	int count = 0;
    	while ( i < nums1.length && j < nums2.length) {
    		pre = cur;
    		if (nums1[i] < nums2[j]) {
    			cur = nums1[i];
    			i++;
    			
    		} else {
    			cur = nums2[j];
    			j++;
    			
    		}
    		if (count < length / 2) {
    			count++;
    		} else break;
    	}
    	
    	while (count <= length / 2) {
    		pre = cur;
    		if (i < nums1.length) {
    			cur = nums1[i++];
    		} else {
    			cur = nums2[j++];
    		}
    		count++;
    	}
        System.out.println(cur + ", " + pre);
        System.out.println(((double) cur + (double) pre) / 2.0);
        System.out.println((double) Math.min(cur, pre));
        return length % 2 == 0? ((double) cur + (double) pre) / 2.0 : (double) cur;
    }
    
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // assume nums2 and nums2 both are not null
        // two different case: even total nums amout or odd amount
        // use two pointer
        
    	int length = nums1.length + nums2.length;
    	int[] result = new int[length];
    	int i = 0;
    	int j = 0;
    	 int k = 0;
    	while (i < nums1.length && j < nums2.length) {
    		if (nums1[i] < nums2[j]) {
    			result[k++] = nums1[i++];
    		} else {
    			result[k++] = nums2[j++];
    		}
    	}
    	
    	while (i < nums1.length || j < nums2.length) {
    		if (i < nums1.length) {
    			result[k++] = nums1[i++];
    		} else {
    			result[k++] = nums2[j++];
    		}
    	}
    	for (int temp : result) {
    		System.out.print(temp + ", ");
    	}
    	
    	System.out.println();
    	return length % 2 == 0? ((double) result[length / 2 - 1] + ((double) result[length / 2 ])) / 2.0 : (double) result[length / 2];
    }
	
	
	

}
