package dencka.kim.hard.linked_lists;

class ShiftLinkedList {
    public static void main(String[] args) {
        LinkedList input = new LinkedList(0, new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5))))));
        printAll(shiftLinkedList(input, 2));
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int size = 1;
        LinkedList tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k = k % size;
        int newTailIdx = k > 0 ? size - k : Math.abs(k);

        LinkedList newTail = head;
        if (k == 0) return head;
        for (int i = 1; i < newTailIdx; i++) newTail = newTail.next;

        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void printAll(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
        System.out.println();
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }

        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }
}
