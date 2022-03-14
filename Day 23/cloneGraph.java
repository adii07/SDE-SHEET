/**Clone Graph
Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
class Node {
    public int val;
    public List<Node> neighbors;
}
*/

/**Solution */
class Solution {
            public Node cloneGraph(Node node) {
                HashMap<Integer, Node> map = new HashMap<>();
                return clone(node,map);
            }

            public Node clone(Node node,HashMap<Integer, Node> map) {
                if (node == null) return null;

                if (map.containsKey(node.val)) 
                    return map.get(node.val);

                Node newNode = new Node(node.val, new ArrayList<Node>());
                map.put(newNode.val, newNode);
                for (Node neighbor : node.neighbors) 
                    newNode.neighbors.add(clone(neighbor,map));
                return newNode;
            }
        
    
}
