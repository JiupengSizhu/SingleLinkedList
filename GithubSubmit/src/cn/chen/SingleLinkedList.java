package cn.chen;

import java.util.Stack;

/**
 * 该类就是一个链表类，用来管理节点的
 * */
public class SingleLinkedList<T> {

    // 先初始化一个头节点，头节点不动，不保存任何数据
    private HeroNode head=new HeroNode("",211240,0,0,0,0,0);
    //表头元素
    private String[] titles={"姓名","学号","数据结构成绩","外语成绩","数学建模成绩","体育成绩","总成绩"};
    // 添加节点到链表表尾
    // 思路：当不考虑编号的顺序的时候，
    // 1、找到当前链表的最后一个节点，
    // 2、将最后节点的next指向插入的节点。
    public void addNode(HeroNode node){

        // 因为head节点不能动，所以我们需要一个辅助指针
        HeroNode temp=head;
        // 遍历链表找到最后
        while (true){

            // 当某个节点的next==null，这就是链表的最后
            if(temp.next==null){
                // temp就是最后一个节点了
                break;  // 跳出循环
            }
            // 将temp往后移动一个指针
            temp=temp.next;
        }
        // 将新节点添加到最后
        temp.next=node;
    }
    // 按照英雄顺序插入到链表中,从小到大排序
    public void insertNode(HeroNode node){

        HeroNode temp=head;
        while (true){

            // 判断是否是表尾：用temp.next是否为空来判断。
            // 1、不是表尾，判断temp，和temp.next两者，
            // 2、是表尾，那么直接就跳出循环，直接插入到temp之后就可（因为前面已经判断了temp与node之间的大小关系）
            // 这里使用的是三元表达式，
            if(temp.next==null?true:node.sno < temp.next.sno)
                break;
            temp = temp.next; // 将指针后移

        }

        // 将插入的元素的指针指向temp指向的元素，然后将temp指向插入的元素
        node.next=temp.next;
        temp.next=node;
    }

    //显示链表
    public void show(){

        // 判断链表是否为空
        if(isEmpty()){
            System.out.println("链表中没有元素");
            return;
        }
        HeroNode temp=head.next;
        for(int title=0;title<titles.length;title++){
            System.out.print(titles[title]+"\t");
        }
        System.out.println("\n");
        while (temp!=null){// 根据节点是否为空判断是否是表尾

            // 输出节点的信息
            System.out.println(temp.toString());
            temp=temp.next; // 将指针后移
        }

    }
    // 修改节点数据
    public void updateNode(HeroNode node){

        if(isEmpty()){

            System.out.println("链表为空，不能修改");
            return;
        }
        HeroNode temp=head;
        while (true){

            // 到达了链表尾，还是没有这个元素
            if(temp==null){

                System.out.printf("没有%d这个元素，不能修改",node.name);
                break;
            }
            // 元素编号相同，进行修改
            if(temp.sno==node.sno){

                temp.name=node.name;
                temp.sno=node.sno;
                temp.data=node.data;
                temp.math=node.math;
                temp.english=node.english;
                temp.sport=node.sport;
                temp.sum=node.sum;
                break;
            }
            // 指针后移
            temp=temp.next;
        }
    }
    // 删除节点
    public HeroNode removeNode(int sno){

        HeroNode temp=head;
        HeroNode remove=null;

        if(isEmpty()){

            throw new RuntimeException("链表为空，没有元素可以删除");
        }
        while (true){

            if(temp.next==null){

                System.out.println("没有找到该元素");
                break;
            }
            if(temp.next.sno==sno){

                // 将要删除的节点赋值给remove
                remove=temp.next;
                // 将当前节点指向要删除节点的下一个节点
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return remove;
    }
    // 判断链表是否为空
    public boolean isEmpty(){

        return head.next==null;
    }
    // 获取链表的有效节点的个数
    public int length(){

        if(isEmpty())   // 链表为空，返回0
            return 0;
        int length=0;   // 定义计数器
        HeroNode temp=head;
        while(temp.next!=null){ // 节点的下一个节点为null就不进去循环

            length++;
            temp=temp.next;
        }
        return length;
    }
    // 求倒数第k个节点
    public HeroNode getNode(int k){

        if(isEmpty()||length()<k)
            return null;
        HeroNode temp=head.next;

        // 遍历链表，遍历length-k+1次，就可以得到倒数第k个节点
        for(int index=1;index<(length()-k+1);index++){
            temp=temp.next;
        }
        return temp;
    }
    // 将链表进行反转,返回反转后的头指针
    public HeroNode reverse(){

        // 当链表为空或者只有一个节点，直接返回，不需要反转
        if (isEmpty()||head.next.next==null)
            return head;

        HeroNode reverse=new HeroNode("",211240,0,0,0,0,0);

        HeroNode temp=head.next;
        HeroNode next=null; // 指向当前节点temp的下一个节点
        while(temp!=null){

            next=temp.next; //先保存当前节点的下一个节点
            temp.next=reverse.next;// 将temp的下一个节点指向新的链表的最前端。
            reverse.next=temp;// 让reverse指向新的链表的头结点
            temp=next;  //让temp后移
        }

        head.next=reverse.next;
        return head;
    }
    // 从尾到头输出链表
    public void lastShow(){

        if(isEmpty())
            return;
        HeroNode temp=head.next;
        for(int title=0;title<titles.length;title++){
            System.out.print(titles[title]+"\t");
        }
        System.out.println("\n");
        Stack<HeroNode> stack=new Stack<>();
        while (temp!=null){

            stack.push(temp);   // 将节点压入栈中
            temp=temp.next; // 节点后移
        }

        // 出栈
        while (stack.size()>0){

            System.out.println(stack.pop());
        }
    }
}

