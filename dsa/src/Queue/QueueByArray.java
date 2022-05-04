package Queue;

public class QueueByArray {
    int rear,front;
    int capacity;
    int array[];
    QueueByArray(int capacity){
        rear=-1;
        front=-1;
        this.capacity=capacity;
        array=new int[capacity];
    }
    void enque(int value){
        if(rear==capacity-1)
            System.out.println("Queue overflow");
        else {
            if(front==-1&&rear==-1)
        {
                front++;
                rear++;
        }
            else
                rear++;
            array[rear]=value;
        }
}
    int deque(){
        if(front==-1||front>rear){
            System.out.println("Queue underflow");
            return Integer.MIN_VALUE;
        }
        else {
            return array[front++];
        }
    }

    int peek(){
        return array[front];
    }

    void printQueue(){
        if(front==-1||front>rear)
            System.out.println("queue is empty");
        else{
            for (int i = front; i <=rear ; i++) {
                System.out.print(array[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        QueueByArray obj=new QueueByArray(6);
        obj.enque(0);
        obj.enque(1);
        obj.enque(2);
        obj.enque(3);
        obj.enque(4);
        obj.enque(5);
        obj.deque();
        obj.deque();
        obj.deque();
        obj.deque();
        obj.deque();
        obj.deque();
        obj.printQueue();
    }
}
