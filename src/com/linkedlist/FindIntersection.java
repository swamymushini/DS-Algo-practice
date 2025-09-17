package com.linkedlist;
public class FindIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int l = 0;
        int m = 0;

        while(curr!=null){
            curr = curr.next;
            l++;
        }

        curr = headB;
        while(curr!=null){
            curr = curr.next;
            m++;
        }
        
        ListNode curr1 =null;
        ListNode curr2 =null;
        
        int diff = Math.abs(l-m);

        if(l<m){
            curr1 = headB;
            curr2 = headA;    
        }else{
            curr1 = headA;
            curr2 = headB;
        }

        while(diff>0){
            curr1 = curr1.next;
            diff--;
        }

        while(curr1!=null&&curr2!=null){

            if(curr1.equals(curr2))
                return curr1;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }



        return null;
    }
}