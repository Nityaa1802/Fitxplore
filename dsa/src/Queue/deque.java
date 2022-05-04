package Queue;

public class deque {
    int front,rear,capacity;
    int array[];
    deque(int capacity){
        front=-1;
        rear=-1;
        this.capacity=capacity;
        array=new int[capacity];
    }

    void enqueRear(int value){
        if((front==rear+1)||(front==0&&rear==capacity-1)){
            System.out.println("Queue overflows");
        }
        else{
            if(front==-1&&rear==-1)
                front=rear=0;
            else if(rear==capacity-1)
                rear=0;
            else
                rear++;
            array[rear]=value;
        }
    }

    void enqueFront(int value){
        if((front==rear+1)||(front==0&&rear==capacity-1)){
            System.out.println("Queue overflows");
        }
        else{
            if(front==-1&&rear==-1)
                front=rear=0;
            else if(front==0)
                front=capacity-1;
            else
                front--;
            array[front]=value;
        }
    }

    int dequeRear(){
        if(front==-1 && rear==-1){
            System.out.println("Queue underflow");
            return  Integer.MIN_VALUE;
        }
        else{
            int p=array[rear];
            if(front==rear)
                front=rear=-1;
            else if(rear==0)
                rear=capacity-1;
            else
                rear--;
            return p;
        }
    }

    int dequeFront(){
        if(front==-1 && rear==-1){
            System.out.println("Queue underflow");
            return  Integer.MIN_VALUE;
        }
        else{
            int p=array[front];
            if(front==rear)
                front=rear=-1;
            else if(front==capacity-1)
                front=0;
            else
                front++;
            return p;
        }
    }
    int peekRear()
    {
        if(rear<0)
        { System.out.println("queue underflow");
            return Integer.MIN_VALUE;
        }
        else
            return array[rear];
    }

    int peekFront()
    {
        if(front<0)
        { System.out.println("queue underflow");
            return Integer.MIN_VALUE;
        }
        else
            return array[front];
    }

    void printQueue(){
        if(front==-1&&rear==-1)
            System.out.println("queue is empty");
        else{
            if(front<=rear){
                for (int i = front; i <=rear ; i++) {
                    System.out.print(array[i]+" ");
                }
            }
            else{
                for (int i = front; i <capacity ; i++) {
                    System.out.print(array[i]+" ");
                }
                for (int i = 0; i <=rear; i++) {
                    System.out.print(array[i]+" ");
                }
            }
        }
    }


    public static void main(String[] args) {
        deque obj=new deque(5);
        obj.enqueRear(1);
        obj.enqueRear(2);
        obj.enqueFront(5);
        obj.enqueFront(4);
        obj.enqueRear(3);
       obj.dequeFront();
       obj.dequeRear();
        obj.dequeRear();
        obj.dequeRear();
        obj.dequeRear();
        obj.printQueue();
    }
}
