package Queue;


public class QueueByLL {

    static class Node{          //a static node class to access it directly by name
        int data;               //contains data
       Node next;
        Node(int data){          // constructor
            this.data=data;
            next=null;
        }
    }
    Node front,rear;

    void enque(int value){
        Node newnode=new Node(value);
        if(front==null&&rear==null){
            front=rear=newnode;
        }
        else
        {
            rear.next=newnode;
            rear=newnode;
        }
    }

    int deque(){
        int p;
        if(front==null){
            System.out.println("queue underflow");
            return Integer.MIN_VALUE;
        }
        else{
            p=front.data;
            if(front==rear){
                front=rear=null;
               return p;
            }
            else {
                front=front.next;
                return p;
            }
        }
    }

    int peek(){
        return front.data;
    }

    void printQueue(){
        if(front==null){
            System.out.println("queue is empty");
        }
        else{
            while(front!=null){
                System.out.print(front.data+" ");
                front=front.next;
            }
        }
    }

    public static void main(String[] args) {
        QueueByLL obj=new QueueByLL();
        obj.enque(0);
        obj.enque(1);
        obj.enque(2);
        obj.enque(3);
        obj.enque(4);
        obj.deque();
        obj.deque();
        obj.deque();
        obj.deque();
        obj.deque();
        obj.printQueue();
    }
}
