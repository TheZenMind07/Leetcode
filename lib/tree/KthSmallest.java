package tree;

public class KthSmallest {
    int itr = 1, res = -1;
    public int kthSmallest(TreeNode root, int k) {
        // need to know how many elements on left
        // if(k-1) retrun root
        // if < k-1 call left recrusive way
        // if > k   call right with k - element on left
        res = -1;
        kthSmallestUtil(root, k);
        return res;
    }

    public void kthSmallestUtil(TreeNode root, int k) {
        if(root == null) return;
        kthSmallestUtil(root.left, k);
        itr++;
        if(itr == k)    res = root.val;
        kthSmallestUtil(root.right, k);
    }

    public static void main(String[] args) {
        KthSmallest s = new KthSmallest();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        // root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        System.out.println(s.kthSmallest(root, 1));
    }

    
}
