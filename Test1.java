/**
 * ClassName:SlignalList
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/10/30 15:57
 * @Author:DangWei
 */
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
public class SlignalList{
    public ListNode head;
    public SlignalList(){
        this.head=null;
    }
    //头插法
   public void addFirst(int data){
        ListNode node=new ListNode(data);
       if(head==null){
           this.head=node;
       }else{
           node.next=head;
           head=node;
       }
    }
    //尾插法
   public void addLast(int data){
       ListNode node=new ListNode(data);
       if(head==null){
           this.head=node;
       }else{
           ListNode cur=head;
           while(cur.next!=null){
               cur=cur.next;
           }
           cur.next=node;
       }
   }
    //任意位置插入,第一个数据节点为0号下标
    private ListNode findIndex(int index){
        int tmp=index-1;
        ListNode cur=head;
        while(tmp!=0){
            cur=cur.next;
            tmp--;
        }
        return cur;
    }
    public boolean addIndex(int index,int data){
        if(index<0||index>getLen()){
            return false;
        }
        if(index==0){
            addFirst(data);
            return true;
        }else{
            ListNode node=new ListNode(data);
            ListNode cur=findIndex(index);
            node.next=cur.next;
            cur.next=node;
        }
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(head==null){
            return false;
        }
        ListNode cur=head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    private ListNode searchPrev(int key) {
        ListNode pre=this.head;
        while(pre.next!=null){
            if(pre.next.data==key){
                return pre;
            }
            pre=pre.next;
        }
        return null;
    }
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //1、找到key的前驱  如果返回空
        ListNode pre = searchPrev(key);
          if(pre==null){
              return ;
          }
        //2、删除节点
        pre.next=pre.next.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(head==null){
            return ;
        }
        ListNode pre=this.head;
        ListNode cur=pre.next;
        while(cur!=null){
            if(pre.next.data==key){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        if(head.data==key){
            this.head=this.head.next;
        }

    }
    //得到单链表的长度
    public int getLen(){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
    //打印链表
    public void display(){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }


    //反转链表
    public ListNode reverse(){
        if(this.head==null){
            return null;
        }
        ListNode pre=null;
        ListNode newHead=null;
        ListNode cur=this.head;

        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;
    }
    public void display2(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //找中间节点
    public ListNode middleNode(){
        if(head==null){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //找到倒数第K个节点
    public ListNode findKNode(int k){
        if(head==null||k<=0){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1!=0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("没有这个节点");
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}


class Main{
    public static void main(String[] args) {
        SlignalList slignalList=new SlignalList();
        slignalList.addLast(7);
        slignalList.addFirst(5);
        slignalList.addFirst(4);
        slignalList.addFirst(3);
        slignalList.addLast(7);
        slignalList.addFirst(2);
        slignalList.addFirst(1);
        slignalList.addLast(7);
        slignalList.display();
        System.out.println(slignalList.getLen());
        slignalList.addLast(6);
        slignalList.addLast(7);
        slignalList.addLast(8);
        slignalList.display();
        System.out.println(slignalList.getLen());
        slignalList.addIndex(4,34);
        slignalList.addIndex(7,55);
        slignalList.display();
        System.out.println(slignalList.getLen());
        System.out.println(slignalList.contains(7));
        slignalList.remove(3);
        slignalList.display();
        slignalList.removeAllKey(7);
        slignalList.display();
        slignalList.display2( slignalList.reverse());

    }
}