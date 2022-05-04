package Linked_List;

/*  A node of doubly LL consist of three parts
    -> data
    ->prev pointer--the add. of the immediate predecessor
    ->next pointer--the add. pf the immediate successor

    pros
    it can be traversed in both direction.
    The delete operation in DLL is more efficient if pointer to the node to be deleted is given.
     We can quickly insert a new node before a given node while in sigly we have to tarversed for the prev
     node

     cons
     It allocates more space as compared to singly LL
      All operations require an extra pointer previous to be maintained.
* */

public class DoublyLL {
    Node head;
   Node tail;
    static class Node{                      //static node class with two ref variable
        int data;                           // one pointing the previous node
        Node next;                           // sec pointing next node
        Node prev;
        Node(int data){
            this.data=data;
        }
    }
    void traversing(){
        Node n=head;
        while(n!=null){                                  //from first node to  null at last
            System.out.println(n.data+" ");
            n=n.next;
    }
    }
    void reverseTraversing(){
        Node n=tail;                                     //from last to null before head
        while(n!= null){
            System.out.println(n.data);
            n=n.prev;
        }

    }
    void insertionBegHead(int value){                    //same as singly only changing two pointers prev and next
        Node n1=new Node(value);
        n1.next=head;
        head.prev=n1;
        head=n1;
    }
    void insertionLastHead(int value){                    //same as singly only changing two pointers prev and next
        Node n1=new Node(value);
        Node n=head;
        while(n.next!=null){
            n=n.next;
        }
        n1.prev=n;
        n.next=n1;
        tail=n1;
    }
    void insertionAtAnyPositionHead(int value,int position){
        Node n1=new Node(value);                        //same as singly only changing two pointers prev and next
        Node n=head;

        for(int i=2;i<position;i++)
        {
            n=n.next;
        }                                                 //n is position-1 node
        n1.prev=n;
        n1.next=n.next;
        n.next.prev=n1;
        n.next=n1;
    }
    void insertionLastTail(int value){               //if u have tail variable thn only it work nrmlly u dnt hve
        Node n1=new Node(value);
        tail.next=n1;
        n1.prev=tail;
        tail=n1;
    }
    int deletionFromBeg(){                             //same as singly bt changing two pointer
        int p= head.data;
        head.next.prev=null;
        head=head.next;
        return p;
    }
    int deletionFromLast(){                           //same as singly only changing two pointers prev and next
        Node n=head;
        while(n.next.next!=null){
            n=n.next;
        }
        int p=n.next.data;
        n.next.prev=null;
        n.next=null;
        tail=n;
        return p;
    }
    int deletionFromAnyPosition(int position){    //same as singly only changing two pointers prev and next

        Node n=head;
        for (int i=2;i<position;i++){
            n=n.next;
        }                                                    //n is position-1 node
        int p=n.next.data;
        n.next=n.next.next;
        n.next.prev=n;
        return p;
    }
    void updation(int value ,int position){
       Node n=head;
        for(int i=2; i<position;i++){
            n=n.next;
        }
        n.next.data=value;
    }
    public static void main(String[] args) {
        DoublyLL obj=new DoublyLL();
        obj.head=new Node(1);
        Node second= new Node(2);
        Node third= new Node(3);
        obj.tail=new Node(4);
        obj.head.next=second;
        second.next=third;
        third.next= obj.tail;
        second.prev=obj.head;
        third.prev=second;
        obj.tail.prev=third;
        obj.traversing();
        System.out.println("---------");
//        System.out.println(obj.deletionFromAnyPosition(2));
//        System.out.println("---------");
//        obj.traversing();
//        System.out.println("---------");
        obj.reverseTraversing();
    }
}
