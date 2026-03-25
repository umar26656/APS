class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) return null;

        ListNode p1 = a, p2 = b;

        while (p1 != p2) {
            p1 = (p1 == null) ? b : p1.next;
            p2 = (p2 == null) ? a : p2.next;
        }
        return p1;
    }
}