package Stack;

import java.util.Stack;

class StackDS{
    private int[]  arr;
    private int top;
    private int capcity;

    StackDS(int size){
        arr = new int[size];
        top = -1;
        capcity = size;
    }

    void add(int data){
        if(top == capcity -1) throw  new RuntimeException("Stack OverFlow");
        arr[++top] = data;
    }

    int pop(){
        if(top ==  -1) throw  new RuntimeException("Stack Underflow");
        return arr[top--];
    }

    int peek(){
        if(top ==  -1) throw  new RuntimeException("Empty Stack");
        return arr[top];
    }

    boolean isEmpty(){
//        if (top == -1) return true;
        return top == -1;
    }
}

public class StackP1 {
    public static void main(String[] args) {
        StackDS st = new StackDS(20);

        st.add(20);
        st.add(30);
        st.add(40);
        st.add(50);

        while (!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }

    }
}
