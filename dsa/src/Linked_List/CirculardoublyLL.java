package Linked_List;

/*   Circular Doubly Linked List has properties of both doubly linked list
 and circular linked list in which two consecutive elements are linked or
 connected by previous and next pointer and the last node points to first
 node by next pointer and also the first node points to last node by the previous pointer.*/



public class CirculardoublyLL {         //cicular with two pointer variables
   Node head;

    static class Node{                 //same as doubly
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    void traversing(){              //same as singlyCircular
        Node n=head;
        do{
            System.out.println(n.data+" ");
            n=n.next;
        } while(n!=head);
    }
    void reverseTraversing(){
        Node n=head;
        do{
            n=n.next;
        } while(n.next!=head);          //n is last node here

    Node n1=n;
        do {
            System.out.println(n1.data);
            n1=n1.prev;
        }   while(n1!=n);               //traversing till we find last node again
    }

    void insertionAtBeg(int value) {             //same as singlyCircular bt we ar changing two pointer prev and next

       Node newnode = new Node(value);
        Node lastnode=head;
        do{
            lastnode=lastnode.next;
        } while(lastnode.next!=head);                  //lastnode is last node
        newnode.next = head;
        head.prev=newnode;

        head = newnode;
        lastnode.next=newnode;
        head.prev=lastnode;
    }
    void insertionAtLast(int value){
       Node newnode = new Node(value);
       Node lastnode=head;
        do{
            lastnode=lastnode.next;
        } while(lastnode.next!=head);
        lastnode.next=newnode;
        newnode.next=head;
        head.prev=newnode;
        newnode.prev=lastnode;
    }
    void insertionAtAnyPositionHead(int value,int position){ //same as double
        Node newnode=new Node(value);
        Node n=head;

        for(int i=2;i<position;i++)
        {
            n=n.next;
        }                                  //n is position-1 node
        newnode.prev=n;
        newnode.next=n.next;
        n.next.prev=newnode;
        n.next=newnode;
    }

    int deletionFromBeg(){                    //same as singlyCircular bt we ar changing two pointer prev and next
        int p= head.data;
       Node lastnode=head;
        do{
            lastnode=lastnode.next;
        } while(lastnode.next!=head);
        lastnode.next=head.next;
        head=head.next;
        head.prev=lastnode;
        return p;
    }

    int deletionFromLast(){                       //same as singlyCircular bt we ar changing two pointer prev and next
       Node n=head;
        while(n.next.next!=head){
            n=n.next;
        }                                         //n is second last node
        int p=n.next.data;
        n.next=head;
        head.prev=n;
        return p;
    }
    int deletionFromAnyPosition(int position){       //same as doubly


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
        CirculardoublyLL obj=new CirculardoublyLL();
        obj.head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(4);
        obj.head.next=second;
        obj.head.prev=fourth;
        second.next=third;
        second.prev= obj.head;
        third.next=fourth;
        third.prev=second;
        fourth.prev=third;
        fourth.next=obj.head;
        obj.deletionFromLast();
        obj.traversing();
        System.out.println("------------");
        obj.reverseTraversing();
    }
}
