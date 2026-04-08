class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        
        dfs(root, "", result);
        return result;
    }
    
    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        
        // If leaf node
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }
        
        // Continue path
        dfs(root.left, path + root.val + "->", result);
        dfs(root.right, path + root.val + "->", result);
    }
}