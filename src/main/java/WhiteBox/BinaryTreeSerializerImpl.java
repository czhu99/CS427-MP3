package WhiteBox;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSerializerImpl implements BinaryTreeSerializer {
    public String serialize(TreeNode root) {
        if (root == null) return "[null]";
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        String s = serializeLevel(level);
        //cut last ','
        s = s.substring(0, s.length() - 1);
        return "[" + s + "]";
    }

    private String serializeLevel(List<TreeNode> level) {
        //to check if the next level exists
        boolean anyNode = false;
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : level) {
            if (node != null) {
                anyNode = true;
                sb.append("" + node.val + ",");
            } else sb.append("null,");
        }
        if (!anyNode) return sb.toString();
        //if next level exists -> process
        List<TreeNode> levelNext = new ArrayList<TreeNode>();
        for (TreeNode node : level)
            if (node != null) {
                levelNext.add(node.left);
                levelNext.add(node.right);
            }
        sb.append(serializeLevel(levelNext));
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        //check if data is valid
        if (data.length() < 3) return null;
        //remove "[" and "]"
        data = data.substring(1, data.length() - 1);
        //separate to parts
        String[] parts = data.split(",");
        List<TreeNode> level = new ArrayList<TreeNode>();
        TreeNode node = getNode(parts[0]);
        if (node != null) {
            level.add(node);
            deserializeRec(parts, 1, level);
        }
        return node;
    }

    private void deserializeRec(String[] parts, int i, List<TreeNode> level) {
        if (i >= parts.length) return;
        if (level.size() == 0) return;
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        for (TreeNode n : level) {
            n.left = getNode(parts[i++]);
            n.right = getNode(parts[i++]);
            if (n.left != null) nextLevel.add(n.left);
            if (n.right != null) nextLevel.add(n.right);
        }
        deserializeRec(parts, i, nextLevel);
    }

    private TreeNode getNode(String s) {
        if (s.charAt(0) == 'n') return null;
        return new TreeNode(Integer.parseInt(s));
    }
}

