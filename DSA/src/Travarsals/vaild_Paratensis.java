package Travarsals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class vaild_Paratensis {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // base index
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();   // try to match

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        String[] arr = {"(()" , ")()())", ""};
        List<Integer> res = new ArrayList<>();

        //longest valid paranthesis

        for(String s : arr){
            System.out.println(longestValidParentheses(s));
        }

        System.out.println(res);
    }
}
