package leetcode.algorithms.I.day5;


/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
 */

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        _4.next = _5;
        _3.next = _4;
        _2.next = _3;
        _1.next = _2;
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
       // removeNthNodeFromEndofList.removeNthFromEnd(_1,2);
        removeNthNodeFromEndofList.removeNthFromEnd(_5,1);
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter=1;
        ListNode currentNode = head;
        while(currentNode.next!=null) {
            counter++;
            currentNode = currentNode.next;
        }
        return removeNode(head,n,counter);
    }

    private ListNode removeNode(ListNode head, int n, int counter) {
        if(counter==n) return head.next;
        head.next = removeNode(head.next, n, --counter);
        return head;
    }
}

/*
Implementation of ListNode from LeetCode
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next) {this.val=val;this.next = next;}
}