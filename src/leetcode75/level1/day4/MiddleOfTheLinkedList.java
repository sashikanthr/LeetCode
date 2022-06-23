package leetcode75.level1.day4;

import leetcode75.level1.day3.ListNode;
import leetcode75.level1.day3.ReverseLinkedList;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
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
        ListNode l6 = new ListNode();
        l6.val = 6;

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        //l5.next = l6;
        System.out.println(obj.middleNode(l1));
    }

    public ListNode middleNode(ListNode head) {
        int counter = 0;
        ListNode current = head;
        while(current!=null) {
            counter++;
            current = current.next;
        }
        counter = counter/2 + 1;
        while(counter!=1) {
            head = head.next;
            counter--;
        }
        return head;
    }
}
