import java.util.*;

class Node {
    int pos, health, idx;
    char dir;

    Node(int pos, int health, char dir, int idx) {
        this.pos = pos;
        this.health = health;
        this.dir = dir;
        this.idx = idx;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(arr, (a, b) -> a.pos - b.pos);

        Stack<Node> stack = new Stack<>();

        for (Node curr : arr) {
            if (curr.dir == 'R') {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek().dir == 'R') {
                    Node top = stack.peek();

                    if (top.health < curr.health) {
                        stack.pop();
                        curr.health--;
                    } else if (top.health > curr.health) {
                        top.health--;
                        curr = null;
                        break;
                    } else {
                        stack.pop();
                        curr = null;
                        break;
                    }
                }

                if (curr != null) {
                    stack.push(curr);
                }
            }
        }

        List<Node> survivors = new ArrayList<>(stack);

        Collections.sort(survivors, (a, b) -> a.idx - b.idx);

        List<Integer> res = new ArrayList<>();
        for (Node node : survivors) {
            res.add(node.health);
        }

        return res;
    }
}