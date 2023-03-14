package cn.chen;

/**
 * 该类是用来测试单链表=
 */

public class SingleLinkedListTest {

    public static void main(String[] args){
        // 创建链表
        SingleLinkedList list=new SingleLinkedList();
        // 往链表中添加元素
        list.addNode(new HeroNode("张三",211240,80,90,76,80,360));
        list.addNode(new HeroNode("李四",211241,80,90,76,80,360));
        list.addNode(new HeroNode("王五",211242,80,90,76,80,360));
        list.addNode(new HeroNode("张强",211243,80,90,76,80,360));
        list.insertNode(new HeroNode("麻子",211244,80,90,76,80,360));

        list.show();
        list.updateNode(new HeroNode("高启盛",211243,80,90,90,90,400));
        System.out.println("修改之后");

        list.show();

        list.removeNode(211243);
        System.out.println("删除之后");
        // 显示链表

        list.show();

        System.out.println("获取链表的有效节点的个数");
        System.out.println(list.length());
        System.out.println("查询倒数第3个节点");

        System.out.println(list.getNode(3));

        System.out.println("==============");

        System.out.println("反向遍历");

        list.reverse();
        list.show();

        System.out.println("==============");
        System.out.println("从尾到头输出链表");
        list.lastShow();
    }
}
