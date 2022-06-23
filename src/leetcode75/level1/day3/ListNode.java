package leetcode75.level1.day3;

/*Below class definition is from LeetCode*/
public class ListNode {
    public int val;
    public ListNode next;

    public int pos;

    public ListNode(){

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
