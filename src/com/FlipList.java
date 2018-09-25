package com;

public class FlipList {
    /**
     * 翻转一个链表
     * @Author poo
     * @param  head: n
     * @return: The new head of reversed linked list.
     * @return ListNode 返回反转后的list
     */
    public static ListNode reverse1(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return head;
        }
        ListNode reHead = null;
        while(head!=null) {
            ListNode temp=head.next;
            head.next=reHead;
            reHead=head;
            head=temp;
        }
        return reHead;
    }
    public static ListNode reverse2(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return head;
        }
        ListNode rehead=reverse2(head.next);
        head.next.next = head;// 将头节点置于末端
        head.next = null;// 防止链表循环
        return rehead;
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        /**
         * @param  ListNode: def 在头结点之前引入一个结点，因为头结点可能被翻转，这样可以使得头结点的翻转和普通结点一样
         *示例过程:
            如：2->3->4
            2是当前结点(reHead )
            3是当前结点的下一个结点(next)
            4是当前结点的下个结点的下个结点(next.next)
            temp=next.next; temp=4 记录next.next
            next.next=reHead; 3->2 改变链表指向的方向
            reHead=next;  reHead=3;
            next=temp;  next=4
         * 将mNode放在next后面next(rehead)为mNode的下一个计作m1；next：m1，m，m1...
         * 此时temp为m2
         * 下一步next：m2，m1，m，m1，m2...
         * 此时temp为m3
         * 以此类推当反转完之后next：n。m m1，m2
         * emp则是n1...
         * 此时mNode.next用next=temp替换
         * mqNode.next=rehead替换，最终合并成一个完整的list
         * @return: def.next def前引入了一个结点故返回此结点的下一个结点
         */
        if(head==null||head.next==null){
            return head;
        }
        ListNode def=new ListNode(0);
        def.next=head;
        head=def;

        for(int i=1;i<m;i++){
            if(head==null){return head;}
           head=head.next;
        }
        ListNode mNode=head.next;//当前结点，即m的点；
        ListNode reHead =mNode;//当前结点，后续会对其进行移动
        ListNode next=mNode.next;//m的下一个点；
        ListNode mqNode=head;//m前面的点；
            for (int i = m; i<n ; i++) {
                if(next==null){return  null;}
                ListNode temp = next.next;
                next.next = reHead;
                reHead = next;
                next = temp;
            }

            mqNode.next=reHead;
            mNode.next=next;

        return def.next;

    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        // Node rehead = reverseList(n1);
        ListNode rehead = reverseBetween(n1,2,4);

    }
}
