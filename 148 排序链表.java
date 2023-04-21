// 归并排序
//快慢指针找中心节点，之后合并链表
class Solution {
    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }

    private ListNode mergesort(ListNode head)
    {
        if(head==null||head.next==null) return head;
        ListNode slow=head,fast = head.next.next;
        while (fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode r = mergesort(slow.next);
        slow.next=null;
        ListNode l = mergesort(head);
        return merge(l,r);

    }
    private ListNode merge(ListNode l,ListNode r)
    {

        ListNode phead = new ListNode(-1);
        ListNode p = phead;
        while (l!=null&&r!=null)
        {
            if(l.val<= r.val)
            {
                p.next=l;
                l=l.next;

            }
            else
            {
                p.next=r;
                r=r.next;

            }
            p=p.next;
        }
        if(l==null)
        {
            p.next=r;
        }
        if(r==null)
        {
            p.next=l;
        }
        return phead.next;
    }
}