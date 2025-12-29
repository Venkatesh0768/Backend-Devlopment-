package Capgemini;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Main {


    static void reverseTheWord(String str) {
        String[] arr = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            StringBuilder rev = new StringBuilder(s.toString());
            rev.reverse();
            res.append(rev + " ");
        }
        System.out.println(res);
    }

    static boolean isAnagram(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);

        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);

        String res1 = new String(arr1);
        String res2 = new String(arr2);

        return (res1.equals(res2));

    }

    static void countVCDS(String s) {
        int vowel = 0, constants = 0, digits = 0, space = 0;
        for (char ch : s.toCharArray()) {
            ch = Character.toLowerCase(ch);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (ch == ' ') {
                space++;
            } else if (ch >= 'a' && ch <= 'z') {
                constants++;
            }
        }
        System.out.println(vowel + " " + constants + "  " + digits + "  " + space);
    }

    static int secondLargest(int[] arr) {
        if (arr.length == 0) return 0;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second && x != first) {
                second = x;
            }
        }

        return second;
    }

    static void fibonacci(int n) {
        int a = 0, b = 1;
        if (n >= 1) System.out.print(a + " ");
        if (n >= 2) System.out.print(b + " ");
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    static long fiboFormula(int n){
        return (long) (Math.pow(((1 + Math.sqrt(5))/2), n) / Math.sqrt(5));
    }

    static int maxPositiveSubsqeuence(int[] arr) {
        int maxSum = 0;
        int currentSum = 0;

        for (int ele : arr) {
            if (ele > 0) {
                currentSum += ele;
            } else {
                maxSum = Math.max(maxSum, currentSum);
                currentSum = 0;
            }
        }


        return maxSum;
    }

    static int longestSubstring(String s) {
        int left = 0, maxLen = 0;
        HashSet<Character> st = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            if (st.contains(s.charAt((right)))) {
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    static void reverse(int[] arr, int l, int r) {
        while (l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }


    static int aggresiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int l = 1;
        int r = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canPlace(stalls, cows, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canPlace(int[] stalls, int cows, int mid) {
        int last = stalls[0];
        int count = 1;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= mid) {
                count++;
                last = stalls[i];
            }
            if (cows == count) return true;
        }
        return false;
    }

    static boolean isAmstrong(int n) {
        int digit = Integer.toString(n).length();
        int ans = n;
        int sum = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            sum += (int) Math.pow(lastDigit, digit);
            n = n / 10;
        }

        if (ans == sum) {
            return true;
        }

        return false;
    }

    static int kandensalgorithm(int[] arr) {
        int n = arr.length;
        int maxEle = arr[0], curr = arr[0];

        for (int i = 1; i < n; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            maxEle = Math.max(maxEle, curr);
        }

        return maxEle;

    }

    static void firstCharNonRepeating(String s) {
        int n = s.length();
        int[] freq = new int[256];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        for (char ch : s.toCharArray()) {
            if (freq[ch] == 1) {
                System.out.println(ch);
                return;
            }
        }

        System.out.println("None");

    }


    static void stringComparsion(String s){
        StringBuilder stringBuilder = new StringBuilder();
        int count =1;

        for (int i = 1; i <s.length(); i++) {
            if (s.charAt(i) ==  s.charAt(i-1)){
                count++;
            }else{
                stringBuilder.append(s.charAt(i-1)).append(count);
                count=1;
            }
        }
        System.out.println(stringBuilder);
    }



    static int[] nextGreater(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res ,-1);

        Stack<Integer> st = new Stack<>();
        for (int i =0; i<n; i++){
            while (!st.empty() && arr[i] > arr[st.peek()]){
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }

        return res;
    }


    static int subArraySum(int[]  arr){
        int curr =0 , maxSum =0;
        for(int ele : arr){
            curr = Math.max(ele , curr +ele);
            maxSum = Math.max(maxSum , curr);
        }
        return maxSum;
    }

    static int longestSubarraySumK(int[] arr, int k) {
        int left =0; int maxLen =0; int sum =0;
        for (int right =0; right<arr.length; right++){
            sum += arr[right];

            while (sum > k){
                sum -= arr[left++];
            }

            if (sum == k){
                maxLen = Math.max(maxLen , right - left +1);
            }
        }
        return maxLen;
    }

    static void moveHashes(String s){
        String str1 = new String("");
        String str2 = new String("");

        for (char ele : s.toCharArray()){
            if (ele == '#'){
                str1 += ele;
            }else {
                str2+=ele;
            }
        }

        String res = "";
        res = str1.concat(str2);
        System.out.println(res);
    }

    static void p2(String s ){
        StringBuilder res = new StringBuilder();
        int count = 1;

        for (int i =1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else {
                res.append(s.charAt(i-1)).append(count);
                count =1;
            }
        }
        res.append(s.charAt(s.length()-1)).append(count);
        System.out.println(res);
    }

    static void numberTimesOccur(int[] arr){
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int ele : arr){
            if(map.containsKey(ele)){
                map.put(ele , map.get(ele) +1);
            }else {
                map.put(ele , 1);
            }
        }
        map.forEach((key, value)-> System.out.println(key +" "+ value));
    }





    public static void main(String[] args) {
        moveHashes("Move#Hash#to#Front");
        p2("abbccccc");

        int[] num = {1, 2, 3, 3, 4, 1, 4, 5 ,1, 2};
        numberTimesOccur(num);


//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(subArraySum(arr));

//        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
//
//        rotateArray(arr1, k);
//        System.out.println(Arrays.toString(arr1));

//        int[] arr = {-2 ,1 ,-3 ,4 ,-1, 2, 1, -5, 4};
//        System.out.println(kandensalgorithm(arr));
//        int cows = 3;
//        System.out.println(aggresiveCows(arr, cows));
//
//        System.out.println(isAmstrong(1634));

//
//        HashMap<String, Integer> checking = new HashMap<>();
//        checking.put("Venky", 1);
//        checking.put("Lohit", 1);
//        checking.put("pratham", 1);
//        checking.put("hermba", 1);
//        checking.put("hjk", 1);
//
//        checking.forEach((key, value) -> System.out.println(key + " " + value));




    }

}
