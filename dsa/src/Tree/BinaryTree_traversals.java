package Tree;

public class BinaryTree_traversals {
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
    BinaryTree_traversals(int data)
    {
        root=new Node(data);
    }

   public void Inorder(Node node){
        if(node==null)
            return;
        Inorder(node.left);
        System.out.print(node.data+" ");
        Inorder(node.right);

    }

    public void preOrder(Node node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node){
        if(node==null)
            return;
        Inorder(node.left);
        Inorder(node.right);
        System.out.print(node.data);
    }

    //------------level order

   int count=0;
    void counter(Node node){
        if(node==null)
            return ;
         counter(node.left);
         counter(node.right);
       count++;
    }


    int min_node=Integer.MAX_VALUE;
    int max_node=Integer.MIN_VALUE;
    int sum=0;
    void minAndMax(Node node){
        if(node==null)
            return;
        minAndMax(node.left);
        minAndMax(node.right);
        if(node.data<min_node)
            min_node=node.data;
        if(node.data>max_node)
            max_node=node.data;
        sum=sum+node.data;
    }


    int max_depth(Node node){
        if(node==null)
            return -1;
        {
        int ldepth=max_depth(node.left);
        int rdepth=max_depth(node.right);
       if(ldepth>rdepth)
        return ldepth+1;
        else
        return rdepth+1;
        }
    }






    public static void main(String[] args) {
        BinaryTree_traversals tree=new BinaryTree_traversals(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
//        tree.root.left.right.left=new Node(0);
//        tree.root.right.right=new Node(7);
        tree.Inorder(tree.root);
//        System.out.println();
//        tree.preOrder(tree.root);
//        System.out.println();
//        tree.postOrder(tree.root);
//        System.out.println();
        //  tree.counter(tree.root);
       // System.out.println(tree.count);
//        tree.minAndMax(tree.root);
//        System.out.println(tree.min_node+" "+ tree.max_node);
//        System.out.println(tree.sum);
//        tree.height(tree.root);
//        System.out.println(tree.height);
       // System.out.println(tree.max_depth(tree.root));
    }
}
