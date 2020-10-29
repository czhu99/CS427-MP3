package Utils;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TreeNode)) {
            return false;
        }
        TreeNode q = (TreeNode) o;
        TreeNode p = this;

        return isSameTree(p,q);
    }

    public int hashCode(){
        int h = val;
        if(left!= null) h = h * 31 + left.hashCode();
        if(right!=null) h = h * 31 + right.hashCode();
        return h;
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.right,q.right) && isSameTree(p.left,q.left);

    }
}