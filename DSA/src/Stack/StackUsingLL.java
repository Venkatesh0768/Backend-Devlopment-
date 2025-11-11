package Stack;

class  Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}


class StackLL{
    private Node top;

    void add(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    int pop(){
        if (top == null) throw  new RuntimeException("UnderFlow");
        int val = top.data;
        top = top.next;
        return val;
    }

    int peek(){
        if(top ==  null) throw new RuntimeException("Empty Stack");
        return top.data;
    }

    boolean isEmpty(){
        return top ==null;
    }


}
public class StackUsingLL {
    public static void main(String[] args) {
        StackLL st = new StackLL();

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
