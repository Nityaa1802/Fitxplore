package Linked_List;


/*   A node in singly LLconsist of two parts
     (i)data
     (ii) the address of the immediate successor
     it can traverse only in one direction i.e forward direction
     the next reference of the last node of singly LL refer to null

*/

//NOTE -->  in any list the condition for checking emply list is not mention
//          we can make a boolean method and then check whether the list is emply or nt

public class SinglyLL {
    Node head;                  //a head pointer points to the next node
    static class Node{          //a static node class to access it directly by name
        int data;               //contains data
        Node next;
        Node(int data){          // constructor
            this.data=data;
            next=null;
        }
    }


    void taversing(){                          //printing the whole list
        Node n=head;
        while(n!=null){                       //from first node to last node
            System.out.println(n.data+" ");
            n=n.next;                         //moving toward next address(Node)
        }                                     //value of n will be null
    }


    void insertionAtBeg(int value){            //taking value as parameter
        Node n1=new Node(value);              //making a object of node with value as data
        n1.next=head;                          //pointer of new node will point to the head
        head=n1;                               //making new node as head
    }

    void insertionAtLast(int value){
        Node n1=new Node(value);
        Node n=head;
        while(n.next!=null){                        //from first node to last node
            n=n.next;
        }                                           //value of n will be last node
        n.next=n1;                                  //last node points to new node

    }
    void insertionAtAnyPosition(int value,int position){
        Node n1=new Node(value);
        Node n=head;

        for(int i=2;i<position;i++)                     //from first node to position-1 node
        {
            n=n.next;
        }                                               // value of n is position -1
        n1.next=n.next;
        n.next=n1;                                      //adding new node
    }
    int deletionFromBeg(){
        int p= head.data;                             //changing head pointer
        head=head.next;                               //changing head
        return p;
    }
    int deletionFromLast(){
        Node n=head;
        while(n.next.next!=null){                     //from node 1 to second last
            n=n.next;
        }                                             //n value is second last node
        int p=n.next.data;
        n.next=null;                                   //changing second last node pointe to null
        return p;
    }
    int deletionFromAnyPosition(int position){

        Node n=head;
        for (int i=2;i<position;i++){                    // from second node to position-1
            n=n.next;
        }                                                //n value is position-1 node
        int p=n.next.data;
        n.next=n.next.next;                              //changing n pointer
        return p;

    }
    void updation(int value ,int position){                //update the value of the node at the specified position
        Node n=head;                                        //same for all type of linked list
        for(int i=2; i<position;i++){
            n=n.next;
        }
        n.next.data=value;
    }
    public static void main(String[] args) {
        SinglyLL obj=new SinglyLL();
        obj.head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        obj.head.next=second;
        second.next=third;
        obj.insertionAtLast(4);
        obj.insertionAtBeg(0);
//        obj.insertionAtAnyPosition(3,4);
        obj.taversing();
        System.out.println("-----------------");
     //   System.out.println(obj.deletionFromLast());
        System.out.println(obj.deletionFromBeg());
        //System.out.println(obj.deletionFromAnyPosition(4));
//
        System.out.println("-----------------");
//        obj.updation(5,3);
        obj.taversing();

    }
}
