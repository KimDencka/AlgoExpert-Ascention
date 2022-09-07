package dencka.kim.easy.collection;

public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(1);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(4);
        list.next.next.next.next = new LinkedList(4);
        list.next.next.next.next.next = new LinkedList(4);
        list.next.next.next.next.next.next = new LinkedList(5);
        list.next.next.next.next.next.next.next = new LinkedList(6);
        list.next.next.next.next.next.next.next.next = new LinkedList(6);

        show(removeDuplicatesFromLinkedList(list));
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList list = linkedList;
        while (list.next != null) {
            if (list.value == list.next.value) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        return linkedList;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void show(LinkedList ll) {
        while (ll != null) {
            System.out.println(ll.value);
            ll = ll.next;
        }
    }
}
