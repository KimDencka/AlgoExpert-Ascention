package dencka.kim.medium.collection;

import java.util.*;

class BreadthFirstSearch {
    static class Node {
        String name;

        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            Node curr;
            while (!queue.isEmpty()) {
                curr = queue.poll();
                array.add(curr.name);
                queue.addAll(curr.children);
            }
            return array;
        }


        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
