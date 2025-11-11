package Stack;

import java.util.Stack;

public class MonotonicStack {

    static int minOperations(int nums[]){
        Stack<Integer> st = new Stack<>();
        int operations =0;

        for(int num : nums){
            while (!st.isEmpty() && st.peek() >  num){
                st.pop();
            }

            if (st.isEmpty() && st.peek() <  num){
                if (num> 0){
                    operations++;
                    st.push(num);
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) {

    }
}
