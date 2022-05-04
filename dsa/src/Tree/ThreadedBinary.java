package Tree;


import java.util.LinkedList;
import java.util.Queue;

                                                 // WITH QUEUE

public class ThreadedBinary
{
    static class Node
    {                      //created a node class
        int data;
        Node left;
        Node right;
        boolean isThreaded;      //a boolean variable to check whether this node is threaded or not( DIFF IN NODE CLASS)

        Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    ThreadedBinary(Node node)
    {
        this.root=node;
    }

    Queue<Node> qr = new LinkedList<Node>();        //created a queue

    //Inorder traversal--> left,root,right
    void populateQueue(Node node, Queue<Node> qr)         // a fuct. to store the in order traversal of the tree
    {
        if (node == null)     //if node is null stop the function
            return;

        if (node.left != null)
            populateQueue(node.left, qr);

        qr.add(node);         //add the node to the queue same sa the printing statement in inorder traversal

        if (node.right != null)
            populateQueue(node.right, qr);
    }

    void createThreaded(Node node, Queue<Node> qr) //func to make the binary tree threaded
    {
        if (node == null)                           // base condition-->if node is null stop the fuct
            return;
        if (node.left != null)
            createThreaded(node.left, qr);

        qr.remove();    //remove the node so that for every leaf node the next node in the queue is its inorder successor
        //and we can make thread from leaf to the successor node i.e(the first element of the queue)

        if (node.right != null)
            createThreaded(node.right, qr);
        else            //if right is null i.e the node is leaf node then
        {
            node.right = qr.peek();   // link the lead node from its inorder successor i.e the first element of the queue
            node.isThreaded = true;  // make the boolean value of the node as true as it is threaded node now
        }
    }

    //TRAVERSAL INORDER IN THREADED BINARY TREE

    Node leftMost(Node node)   // fuct. that return the left most node from the given node
    {
        if(node==null)
            return null ;
        while ( node.left != null)
            node = node.left;
        return node;
    }


    void traversal(Node node)//funt for traversal in threaded binary tree
    {

        if (node==null)
            return;
        Node cur = leftMost(node);//finding the left modt node of the three
        while (cur != null)
        {
            System.out.print(cur.data + " ");  //printing cur data
            if (cur.isThreaded)               //if thr cur node is threaded thn go to its right node ie inorder successor
                cur=cur.right;
            else                                // not a leaf node
                cur=leftMost(cur.right);        // find the left
        }
    }

    public static void main(String[] args) {
        ThreadedBinary tree=new ThreadedBinary(new Node(1));
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.populateQueue(tree.root, tree.qr);
        tree.createThreaded(tree.root, tree.qr);
        tree.traversal(tree.root);
        }




    }

