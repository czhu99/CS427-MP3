package WhiteBox;

import Utils.TreeNode;

public interface BinaryTreeSerializer {
    String serialize(TreeNode root);
    TreeNode deserialize(String data);
}
