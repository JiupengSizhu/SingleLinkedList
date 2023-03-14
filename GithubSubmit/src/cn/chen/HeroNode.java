package cn.chen;

/**
 * 该类就是一个节点类：
 *
 * */
public class HeroNode {

    // 这三个就是数据域，用来保存节点的数据的。
    public String name;
    public int sno;
    public int data;
    public int english;
    public int math;
    public int sport;
    public int sum;


    public HeroNode next;   // 这个就相当于指针，指向链表的下一个节点

    public HeroNode(String name, int sno,int data,int english,int math,int sport,int sum) {
        this.name = name;
        this.sno=sno;
        this.data=data;
        this.english=english;
        this.math=math;
        this.sport=sport;
        this.sum=sum;
    }

    @Override
    public String toString() {
        return  name+'\t'+sno+'\t'+
                data+'\t'+english+'\t'+
                math+'\t'+sport+'\t'+
                sum
                ;
    }
}
