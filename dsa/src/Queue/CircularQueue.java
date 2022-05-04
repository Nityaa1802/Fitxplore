package Queue;



public class CircularQueue {
    int front,rear,capacity;
    int array[];

   CircularQueue(int capacity){
       rear=-1;
       front=-1;
       this.capacity=capacity;
       array=new int[capacity];

   }

   void enque(int value){
       if((front==0 && rear==capacity-1)||(front==rear+1)){
           System.out.println("Queue overflow");
       }
       else{
           if(front!=0 && rear==capacity-1){
               rear=0;
           }
           else if(front==-1 && rear==-1){
               rear=front=0;
           }
           else
           { rear=rear+1;
           }
           array[rear]=value;
       }
   }
   int deque(){
       int p;
       if(front==-1&&rear==-1){
           System.out.println("queue underflow");
           return Integer.MIN_VALUE;
       }
       else{
           p=array[front];
           if(front==rear)
               front=rear=-1;
           else if(front==capacity-1&&rear!=capacity-1)
               front=0;
           else
               front=front+1;
           return p;
           }
       }

       void peek()
       {
           System.out.println(array[front]);
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
        CircularQueue obj=new CircularQueue(5);
        obj.enque(1);
        obj.enque(2);
        obj.enque(3);
        obj.enque(4);
        obj.enque(5);
        obj.deque();
        obj.deque();
        obj.enque(22);
        obj.deque();
        obj.deque();
      obj.deque();
        obj.printQueue();
    }
   }

