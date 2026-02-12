// TC: O(n * k^2)
// SC: O(1)

// 1: We merge 2 linked lists at a time, until we have merged k linked lists
// 2: Since the linked lists are sorted, we compare the heads of each LL to determine which node comes next in the merged LL
// 3: Once we have processed all k LLs, we return a single merged LL
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for (ListNode node : lists) {
            if (node != null) {
                merged = mergeLL(merged, node);
            }
        }
        return merged.next;
    }

    private ListNode mergeLL(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p1 = node1;
        ListNode p2 = node2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        while (p1 != null) {
            curr.next = p1;
            p1 = p1.next;
            curr = curr.next;
        }
        while (p2 != null) {
            curr.next = p2;
            p2 = p2.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}