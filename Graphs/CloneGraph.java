133. Clone Graph - https://leetcode.com/problems/clone-graph/description/ - MEDIUM

class Solution {
    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (Node ng : current.neighbors) {
                if (!map.containsKey(ng)) {
                    q.add(ng);
                    map.put(ng, new Node(ng.val));
                }
                map.get(current).neighbors.add(map.get(ng));
            }
        }

        return map.get(node);
    }
}
