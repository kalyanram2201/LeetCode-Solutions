class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        helper(root);
        return root;
    }

    private void helper(Node node) {
        if (node == null)
            return;

        Node next = getNext(node.next);
        if (node.left != null) {
            if (node.right != null) {
                node.left.next = node.right;
            } else {
                node.left.next = next;
            }
        }

        if (node.right != null) {
            node.right.next = next;
        }

        helper(node.right);
        helper(node.left);
    }

    private Node getNext(Node node) {
        while (node != null) {
            if (node.left != null)
                return node.left;
            if (node.right != null)
                return node.right;
            node = node.next;
        }
        return null;
    }
}
