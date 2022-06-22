package leetcode75.level1.day3;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Input: head = [1,2]
Output: [2,1]
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        ListNode l3 = new ListNode();
        l3.val = 3;
        ListNode l4 = new ListNode();
        l4.val = 4;
        ListNode l5 = new ListNode();
        l5.val = 5;

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(obj.reverseList(l1));
    }

    public ListNode reverseList(ListNode head) {

        ListNode previousNode = null;

        while(head!=null) {
            ListNode nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
        return previousNode;
    }
}


