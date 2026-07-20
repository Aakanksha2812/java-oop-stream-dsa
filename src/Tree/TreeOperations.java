package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    void levelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode peek = q.poll();
            System.out.print(peek.val+" ");
            if (peek.left != null) {
                q.add(peek.left);
            }
            if (peek.right != null) {
                q.add(peek.right);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(9);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = node1;
        leftNode.right = node2;
        rightNode.left = node3;
        rightNode.right = node4;
        node1.left = node5;
        node1.right = node6;
        TreeOperations tree = new TreeOperations();
        System.out.println("preOrder Travesal ");
        tree.preOrder(root);
        System.out.println();
        System.out.println("inOrder Travesal ");
        tree.inOrder(root);
        System.out.println();
        System.out.println("postOrder Travesal ");
        tree.postOrder(root);
        System.out.println();
        System.out.println("level order Travesal ");
        tree.levelOrder(root);
    }
}
