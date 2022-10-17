package dencka.kim.hard.linked_lists;

class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList input = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5)))));
        printAll(reverseLinkedList(input));
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        LinkedList curr = head;
        LinkedList next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printAll(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
        System.out.println();
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }
}
