package cheatsheet;


class ListNode{
    int val;
    ListNode next;
}

public class LinkedList {
    public ListNode reverseLinkedList(ListNode head){
        // 1 -> 2 -> 3 -> NULL
        // 1 <- 2 <- 3      NULL
        //          p,q     r
        if(head == null) return head;

        ListNode p = null, q = null, r = head;
        while(r != null){
            q = r;
            r = r.next;
            q.next = p;
            p = q;
        }
        return p;
    }

    public void findMid(ListNode head){
        //slow pointer position, after loop
        //1 2 3 4
        //  ^

        //1 2 3 4 5
        //    ^

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
//                    OR

//        1 2 3 4
//            ^
//        1 2 3 4 5
//            ^
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

    }

    //cycle detection
    public boolean hasCycle(ListNode head) {
    //      null == null -> True
    //       All "null" are considered to be same block
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }


}
