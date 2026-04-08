
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        dfs(root, targetSum, path, result);
        return result;
    }
    
    private void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;
        
        path.add(root.val);
        
        // Check leaf node
        if (root.left == null && root.right == null && target == root.val) {
            result.add(new ArrayList<>(path)); // store copy
        }
        
        dfs(root.left, target - root.val, path, result);
        dfs(root.right, target - root.val, path, result);
        
        // Backtracking step
        path.remove(path.size() - 1);
    }
}