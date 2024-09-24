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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // List to hold the node along with its row and column.
        List<int[]> nodes = new ArrayList<>();
        
        // Perform a BFS with additional row and column tracking
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); // Tuple(node, col, row)
        
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int col = tuple.col;
            int row = tuple.row;

            // Add the current node's value along with its position
            nodes.add(new int[] {col, row, node.val});

            // Traverse the left and right children
            if (node.left != null) {
                queue.offer(new Tuple(node.left, col - 1, row + 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, col + 1, row + 1));
            }
        }

        // Sort by column first, then by row, and finally by node value
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];       // Sort by column
            if (a[1] != b[1]) return a[1] - b[1];       // If same column, sort by row
            return a[2] - b[2];                         // If same row, sort by value
        });

        // Populate the result list based on sorted node positions
        Map<Integer, List<Integer>> columnMap = new TreeMap<>();
        for (int[] node : nodes) {
            int col = node[0], val = node[2];
            columnMap.putIfAbsent(col, new ArrayList<>());
            columnMap.get(col).add(val);
        }

        // Add the column-wise lists to the final result
        result.addAll(columnMap.values());

        return result;
    }

    // Helper class to store a TreeNode and its column and row values
    class Tuple {
        TreeNode node;
        int col;
        int row;

        Tuple(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
}

