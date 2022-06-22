package leetcode75.level1.day3;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 */

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        ListNode l3 = new ListNode();
        l3.val = 4;
        ListNode l4 = new ListNode();
        l4.val = 1;
        ListNode l5 = new ListNode();
        l5.val = 3;
        ListNode l6 = new ListNode();
        l6.val = 4;

        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        obj.mergeTwoLists(l1,l4);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
}

/*Below class definition is from LeetCode*/
class ListNode {
    int val;
    ListNode next;

    ListNode(){

    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val+"->"+next;
    }
}

