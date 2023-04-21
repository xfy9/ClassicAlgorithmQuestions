// 链表
// 206 反转链表

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode s = head, f = head.next;
        ListNode ans = null;
        while(f!=null)
        {
            ListNode t = f.next;
            ans=f;
            f.next=s;
            s=f;
            f=t;

        }
        head.next=null;
        return ans;

    }
}

// 876 链表的中间结点
// 1. 偶数长度找中间结点，要求返回第二个结点，s=head.next,f=head.next.next
// 2. 偶数长度找中间结点，要求返回第一个结点，s=head,f=head.next
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode s=head.next,f=head.next.next;
        while (f!=null&&f.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
}

// 160 相交链表
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a!=b)
        {
            if(a.next==null) a=headB;
            else a=a.next;
            if(b.next==null) b=headA;
            else b=b.next;
        }
        return a;
    }
}

// 141 环形链表
// 快慢指针

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode s = head.next,f=head.next.next;
        while (s!=f)
        {
            if(f.next==null||f.next.next==null) return false;
            s=s.next;
            f=f.next.next;
        }
        return true;
    }
}

// 328 奇偶链表
// 快慢指针
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow = head, fast = head.next;
        ListNode odd_fin = null,even_st=head.next;
        while (slow!=null&&fast!=null)
        {
            ListNode tslow = null,tfast = null;
            if(fast.next!=null)
            {
                tslow=fast.next;
                tfast=fast.next.next;
            }
            slow.next=tslow;
            fast.next=tfast;
            odd_fin=slow;
            slow=tslow;
            fast=tfast;

        }
        if(odd_fin.next!=null) odd_fin=odd_fin.next;
        odd_fin.next=even_st;
        return head;

    }
}

