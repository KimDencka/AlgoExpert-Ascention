package dencka.kim.hard.linked_lists;

class MergeLinkedLists {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1, new LinkedList(4, new LinkedList(5)));
        LinkedList list2 = new LinkedList(2, new LinkedList(3));
        printAll(mergeLinkedLists(list1, list2));
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList l1 = headOne;
        LinkedList l2 = headTwo;
        LinkedList l1Prev = null;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                l1Prev = l1;
                l1 = l1.next;
            } else {
                if (l1Prev != null) l1Prev.next = l2;
                l1Prev = l2;
                l2 = l2.next;
                l1Prev.next = l1;
            }
        }
        if (l1 == null) l1Prev.next = l2;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static void printAll(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
        System.out.println();
    }
}
