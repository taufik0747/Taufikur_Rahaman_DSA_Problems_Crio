import java.io.*;
import java.util.*;
import crio.ds.List.ListNode;

class Solution {
    public ListNode mergeKSortedLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // Initialize dummy node and current pointer
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Add the first node of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            // Poll the smallest element from the queue and move to its next
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return dummy.next;
    }
}
