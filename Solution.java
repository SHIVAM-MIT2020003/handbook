/*
// Definition for a RandomListNode.
class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int label) {
        this.label = label;
        this.next = null;
        this.random = null;
    }
}
*/


class Solution {
    public RandomListNode copyRandomList(RandomListNode f) {
        if(f == null) return null;
        RandomListNode head = new RandomListNode(-1);
        head.next = f;
        insert(head);
        fillRandom(head);
        split(head);
        return head.next;
    }

    public void split(RandomListNode head){
        RandomListNode itr1 = head.next;
        RandomListNode itr2 = head.next.next;
        while(itr1 != null && itr2 != null){
            head.next = itr2;
            itr1.next = itr2.next;
            head = head.next;
            itr1 = itr1.next;
            if(itr1 == null) break;
            itr2 = itr1.next;
        }
    }

    public void fillRandom(RandomListNode head){
        RandomListNode itr = head.next;
        while(itr != null){
            if(itr.random != null)
                itr.next.random = itr.random.next;
            if(itr.next == null) break;
            itr = itr.next.next;
        }
    }

    public void insert(RandomListNode head){
        RandomListNode old = head.next;
        while(old != null){
            RandomListNode newNode = new RandomListNode(old.label);
            RandomListNode temp = old.next;
            old.next = newNode;
            newNode.next = temp;
            old = temp;
        }
    }

    public void print1(RandomListNode head){
        while(head != null){
            System.out.print(head.label + " ");
            head = head.next;
        }
        System.out.println();
    }

    public void print2(RandomListNode head){
        while(head != null){
            System.out.print(head.hashCode() + " ");
            head = head.next;
        }
        System.out.println();
    }

}