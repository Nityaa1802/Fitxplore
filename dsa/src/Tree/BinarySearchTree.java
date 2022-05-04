package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    Node root;

    BinarySearchTree(int value){

        root=new Node(value);
    }

    void insert(Node newnode,Node node) {
        if (node == null)
            node = newnode;
        else {
            if (newnode.data < node.data)
            {
                if (node.left == null)
                    node.left = newnode;
                else
                    insert(newnode, node.left);
            }
            else
            {    if(node.right==null)
                    node.right=newnode;
                else
                    insert(newnode,node.right);

            }
        }
    }
    ArrayList arr=new ArrayList();
    void search(int value,Node node){

        if(node.data==value){
            System.out.println("value found");
            System.out.println(arr);
        }
        else{
            if(value<node.data)
            {   arr.add(node.data);
                search(value,node.left);}
            else { arr.add(node.data);
                search(value, node.right);
            }
        }
    }

//    Boolean checkBST(Node node){
//
//        if(node.right!=null){
//            if((node.right.data<node.data))
//                return checkBST(node.right);
//            else
//                return false;
//        }
//        else
//            return true;
//        if(node.left!=null){
//            if((node.left.data<node.data))
//                return checkBST(node.left);
//            else
//                return false;
//        }
//        else
//            return true;


  //
    //  }


    public void preOrder(Node node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree(45);
        tree.insert(new Node(15),tree.root);
        tree.insert(new Node(79),tree.root);
        tree.insert(new Node(90),tree.root);
        tree.insert(new Node(10),tree.root);
        tree.insert(new Node(55),tree.root);
        tree.insert(new Node(12),tree.root);
        tree.insert(new Node(20),tree.root);
        tree.insert(new Node(50),tree.root);
        tree.search(50, tree.root);
     //   tree.checkBST(tree.root);
        tree.preOrder(tree.root);
    }
}
//deletion checkBST height of the tree