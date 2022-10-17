package dencka.kim.medium.linked_lists;

class SumOfLinkedLists {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList sumNode = new LinkedList(0);
        LinkedList curr = sumNode;
        int mem = 0;
        while ((linkedListOne != null) || (linkedListTwo != null) || mem != 0) {
            int val1 = linkedListOne == null ? 0 : linkedListOne.value;
            int val2 = linkedListTwo == null ? 0 : linkedListTwo.value;
            int sum = val1 + val2 + mem;
            LinkedList newNode = new LinkedList(sum % 10);
            curr.next = newNode;
            curr = newNode;
            linkedListOne = (linkedListOne != null) ? linkedListOne.next : null;
            linkedListTwo = (linkedListTwo != null) ? linkedListTwo.next : null;
            mem = sum / 10;
        }
        return sumNode.next;
    }
}
