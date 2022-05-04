package Linked_List;

/*  In a singly linked list, for accessing any node of the linked list,
we start traversing from the first node. If we are at any node in the
 middle of the list, then it is not possible to access nodes that precede
 the given node.


  in this the last pointer of a singly LL points to the first node(head).
     Node class is same as singly Linked list .we cam traverse only in one direction
     there is no null pointer.

     Circular linked list are mostly used in task maintenance in operating systems.
      There are many examples where circular linked list are being used in computer
      science including browser surfing where a record of pages visited in the past
      by the user, is maintained in the form of circular linked lists and can be
      accessed again on clicking the previous button.
* */
public class CircularSinglyLL {      //same as sinle the only diff is the pointer of last node point toward first node
    Node head;                        // i.e head

    static class Node{          //same class as singlyLL
        int data;
       Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    void taversing(){                   //traversing till we find the hed node again
       Node n=head;                      // used do while becoz it  run than also whwn codition is false once
       do{
            System.out.println(n.data+" ");
            n=n.next;
        } while(n!=head);
    }
    void insertionAtBeg(int value) {

        Node n1 = new Node(value);
        Node n=head;
        do{
            n=n.next;
        } while(n.next!=head);                       //n value is the last node
        n1.next = head;
        head = n1;
        n.next=n1;
    }
     void insertionAtLast(int value){
         Node n1 = new Node(value);
         Node lastnode=head;
         do{
             lastnode=lastnode.next;
         } while(lastnode.next!=head);
         lastnode.next=n1;
         n1.next=head;
     }
    void insertionAtAnyPosition(int value,int position){       //same as singly
       Node n1=new Node(value);
        Node n=head;

        for(int i=2;i<position;i++)
        {
            n=n.next;
        }                                                         //n is position-1 node
        n1.next=n.next;
        n.next=n1;
    }

    int deletionFromBeg(){
        int p= head.data;
        Node lastnode=head;
        do{
            lastnode=lastnode.next;
        } while(lastnode.next!=head);
        lastnode.next=head.next;
        head=head.next;
        return p;
    }
    int deletionFromLast(){
        Node n=head;
        while(n.next.next!=head){
            n=n.next;
        }                                       //n is second last node here
        int p=n.next.data;
        n.next=head;
        return p;
    }

    int deletionFromAnyPosition(int position){     //sam as singly

        Node n=head;
        for (int i=2;i<position;i++){
            n=n.next;                               //n is position-1 node
        }
        int p=n.next.data;
        n.next=n.next.next;
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
        CircularSinglyLL obj=new CircularSinglyLL();
        obj.head=new Node(1);
       Node second=new Node(2);
        Node third=new Node(3);
        obj.head.next=second;
        second.next=third;
        third.next= obj.head;
//        Node n=obj.head;
//        do{
//            n=n.next;
//        } while(n.next!=obj.head);
//        obj.tail=n;
        obj.deletionFromAnyPosition(3);
        obj.taversing();
    }
}
