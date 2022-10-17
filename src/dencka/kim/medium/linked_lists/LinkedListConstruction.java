package dencka.kim.medium.linked_lists;

class LinkedListConstruction {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        public void setTail(Node node) {
            if (tail == null) {
                setHead(node);
            }
            insertAfter(tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.next = node;
            nodeToInsert.prev = node.prev;
            if (node.prev == null) head = nodeToInsert;
            else node.prev.next = nodeToInsert;
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) tail = nodeToInsert;
            else node.next.prev = nodeToInsert;
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node curr = head;
            int curPos = 1;
            while (curr != null && position != curPos) {
                curr = curr.next;
                curPos++;
            }
            if (curr != null) insertBefore(curr, nodeToInsert);
            else setTail(nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            Node curr = head;
            while (curr != null) {
                Node temp = curr;
                curr = curr.next;
                if (temp.value == value) remove(temp);
            }
        }

        public void remove(Node node) {
            if (head == node) head = head.next;
            if (tail == node) tail = tail.prev;
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node curr = head;
            while (curr != null) {
                if (curr.value == value) return true;
                curr = curr.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
