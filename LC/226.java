import data_structure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution226 {
  public TreeNode invertTree(TreeNode root) {
      if (root == null) return root;

      TreeNode tempNode = root.left;
      root.left = root.right;
      root.right = tempNode;

      root.left = invertTree(root.left);
      root.right = invertTree(root.right);

      return root;
  }
}