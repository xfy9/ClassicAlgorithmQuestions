/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void Print(ListNode L)
    {
        while(L!=null)
        {
            L = L.next;
            if(L!=null)
            System.out.println(L.val);
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode re_st = null;
        ListNode tail = head;
        int flag=0;
        while(l1!=null&&l2!=null)
        {
            int val = (l1.val+l2.val+flag)%10;
            flag = (l1.val+l2.val+flag)/10;
            tail.next = new ListNode(val);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null)
        {
            int val = (l1.val+flag)%10;
            flag = (l1.val+flag)/10;
            tail.next = new ListNode(val);
            tail = tail.next;
            l1 = l1.next;
        }
        while(l2!=null)
        {
            int val = (l2.val+flag)%10;
            flag = (l2.val+flag)/10;
            tail.next = new ListNode(val);
            tail = tail.next;
            l2 = l2.next;
        }
        //Print(head);
        if(flag!=0)
        {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}