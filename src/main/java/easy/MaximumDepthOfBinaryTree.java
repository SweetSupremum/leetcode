package easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 104.
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * @author SweetSupremum
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                3,
                new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println("maxDepth(treeNode) = " + maxDepth(treeNode));
    }

/*    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }*/

    public static int maxDepth(TreeNode root) {
        int level = 0;
        Queue<LevelTreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(new LevelTreeNode(root, level));
        while (!treeNodes.isEmpty()) {
            LevelTreeNode poll = treeNodes.poll();
            level = poll.level;
            int temp = poll.level + 1;
            TreeNode right = poll.treeNode.right;
            TreeNode left = poll.treeNode.left;
            if (right != null) {
                treeNodes.add(new LevelTreeNode(right, temp));
            }
            if (left != null) {
                treeNodes.add(new LevelTreeNode(left, temp));
            }
        }
        return level + 1;
    }

    public static class LevelTreeNode {
        public LevelTreeNode(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

        TreeNode treeNode;
        int level;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
