package tree;

public class MaxPathSum {
    int pathSum;
    public int maxPathSum(TreeNode root) {
        pathSum = -5000;
        maxPathSumUtil(root);
        return pathSum;
    }

    private int maxPathSumUtil(TreeNode root) {
                if(root == null)    return -5000;

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        // including both childern
        // including single childern of max value
        // including only node
        int maxChild = Math.max(left, right);
        int max = Math.max(root.val, Math.max(maxChild + root.val, root.val + left + right));
        pathSum = Math.max(pathSum, max);
        return Math.max(root.val, root.val + maxChild);
    }

    public static void main(String[] args) {
        MaxPathSum s = new MaxPathSum();

        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(1);

        System.out.println(s.maxPathSum(root));
    }
}
