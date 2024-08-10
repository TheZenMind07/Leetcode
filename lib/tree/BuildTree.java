package tree;

public class BuildTree {

    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length-1;
        return buildTreeUtil(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode buildTreeUtil(int[] inorder, int[] postorder, int low, int high) {
        if(index <0)   return null;
        TreeNode tn = new TreeNode(postorder[index--]);
        if(low == high) return tn;
        int val = tn.val;
        int pos = -1;
        for(int i = low ; i<= high ; i++) {
            if(inorder[i] == val){
                pos = i;
                break;
            }
        }
                tn.right = buildTreeUtil(inorder, postorder, pos+1, high);
        tn.left = buildTreeUtil(inorder, postorder, low, pos-1);


        return tn;
    }

    public static void main(String[] args) {

        BuildTree bt = new BuildTree();
        int[] inorder = {2,1};
        int[] postorder = {2,1};
        bt.buildTree(inorder, postorder);
    }
    
}