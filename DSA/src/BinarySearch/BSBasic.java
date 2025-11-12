package BinarySearch;

public class BSBasic {
    static boolean binarySearch(int[] arr , int target){
        int start =0;
        int end = arr.length -1;

        while (start<=end){
            int mid  = start + (end - start)/2;
            if(arr[mid] ==  target){
                return true;
            }else if(arr[mid] > target){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return false;
    }
    static int binarySearch2(int[] arr , int target){
        int start =0;
        int end = arr.length -1;

        while (start<=end){
            int mid  = start + (end - start)/2;
            if(arr[mid] > target){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return  start;
    }
    static int firstOccurecnce(int[] arr , int target){
        int start =0;
        int end = arr.length -1;
        int ans = -1;

        while (start<=end){
            int mid  = start + (end - start)/2;
            if(arr[mid] ==  target){
                ans = mid;
                end = mid -1;
            }else if(arr[mid] > target){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return ans;
    }
    static int LastOccurecnce(int[] arr , int target){
        int start =0;
        int end = arr.length -1;
        int ans = -1;

        while (start<=end){
            int mid  = start + (end - start)/2;
            if(arr[mid] ==  target){
                ans = mid;
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,2,2,6,7,8,9,10};
        int target = 2;

        System.out.println(LastOccurecnce(arr , target));


    }
}
