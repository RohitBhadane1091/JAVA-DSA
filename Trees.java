import java.util.LinkedList;
import java.util.Queue;

public class Trees {
    public static void main(String[] args) {
        int []nodes={1,2,3,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTrees t=new BinaryTrees();
        Node root=t.formTree(nodes);
        t.preOrder(root);
        System.out.println();
        t.inOrder(root);
        System.out.println();
        t.postOrder(root);
        System.out.println();
        t.levelOrder(root);

    }
}
class Node{
   int data;
   Node right;
   Node left;
   Node(int data){
       this.data=data;
       this.left=null;
       this.right= null;
    }
}
class BinaryTrees{
    static int index=-1;
    public Node formTree(int[]nodeInfo){
       index++;
       if (nodeInfo[index]==-1){
           return null;
       }
       Node newNode=new Node(nodeInfo[index]);
       newNode.left=formTree(nodeInfo);
       newNode.right=formTree(nodeInfo);
       return newNode;
    }
    public void preOrder(Node root){
        if (root==null){
            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root){
        if (root==null){
            System.out.print(-1+" ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public void postOrder(Node root){
        if (root==null){
            System.out.print(-1+ " ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }
    public void levelOrder(Node root){
       if (root==null){
           return;
       }
       Queue <Node>q=new LinkedList<>();
       q.add(root);
       q.add(null);
       while (!q.isEmpty()){
           Node rem=q.remove();
           if (rem==null){
               System.out.println();
               if (q.isEmpty()){
                   break;
               }
               else{
                   q.add(null);
               }
           }
           else{
               System.out.print(rem.data+" ");
               if (rem.left!=null){
                   q.add(rem.left);
               }
               if (rem.right!=null){
                   q.add(rem.right);
               }
           }
       }
    }
    public int sumOfTree(Node root){
        if (root==null){
            return 0;
        }
        int l=sumOfTree(root.left);
        int r=sumOfTree(root.right);
        return l+r+root.data;


    }
    public int heightOfTree(Node root){
        if (root==null){
            return 0;
        }
        int l=heightOfTree(root.left);
        int r=heightOfTree(root.right);
        return Math.max(l,r)+1;
    }

    }
