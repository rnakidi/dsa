INPROGRESS
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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (null == preorder || 0 == preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            util(root, preorder[i]);
        }
        return root;
    }

    private void util(TreeNode  root, int val) {
        if (null == root) {
            return;
        }

        if (val < root.val) { // left
            if (null != root.left) {
                util(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else {
            if (null != root.right) {
                util(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }
}

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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (null == preorder || 0 == preorder.length) {
            return null;
        }

        return util(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    private TreeNode util(int[] preorder, int min, int max, int index) {
        if (index == preorder.length) {
            return null;
        }

        int val = preorder[index];        
        if (val < min || val > max) {
            return null;
        }
        index++;

        TreeNode root = new TreeNode(val);
        root.left =  util(preorder, min, val, index);
        root.right = util(preorder, val, max, index);
        return root;
    }
}
