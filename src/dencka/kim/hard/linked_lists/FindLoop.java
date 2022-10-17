package dencka.kim.hard.linked_lists;

import java.util.*;

class FindLoop {
    // time: O(n), space: O(1)
    public static LinkedList findLoop(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // time: O(n), space: O(n)
//    public static LinkedList findLoop(LinkedList head) {
//       Set<LinkedList> seen = new HashSet<>();
//       LinkedList iterator = head;
//          while (iterator != null) {
//            if (seen.contains(iterator)) break;
//           seen.add(iterator);
//           iterator = iterator.next;
//      }
//      return iterator;
//    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
