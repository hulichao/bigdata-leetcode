package com.hoult.link;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leetcode86 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;
        partition(a, 3);
    }

    public static ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) return head;
        //开一个新头，最后与旧链表连接起来
        ListNode dump1 = new ListNode(-1);
        ListNode dump2 = new ListNode(-1);


        ListNode du1 = null,du2 = null;

        while (head != null) {
            if (head.val < x && du1 == null) {
                du1 = head;
                dump1.next = du1;
            }
            else if (head.val < x && du1 != null) {
                du1.next = head;
                du1 = du1.next;
            }

            if (head.val >= x && du2 == null) {
                du2 = head;
                dump2.next = du2;
            }

            else if (head.val >= x && du2 != null) {
                du2.next = head;
                du2 = du2.next;
            }

            head = head.next;
        }

        if (du1 != null) {
            du1.next = dump2.next;
            return dump1.next;
        } else
            return dump2.next;


    }}
