package com.lingrui.question.T3;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        //定义三种物品以及最大堆叠量
        Item stone = new Item("石头",64);
        Item wood = new Item("木板",64);
        Item diamondSword = new Item("钻石剑",1);

        List<ItemStack> orginItems = new ArrayList<>();
        Inventory inv = new Inventory(36,orginItems);
        System.out.println("1.创建一个容量为 36 的背包：");
        inv.display();
        System.out.println();

        ItemStack stack2 = new ItemStack(30,stone);
        System.out.println("2.向背包中添加 30 个石头：");
        inv.addItem(stack2);
        inv.display();
        System.out.println();

        ItemStack stack3 = new ItemStack(40,stone);
        System.out.println("3.再次向背包中添加 40 个石头：");
        inv.addItem(stack3);
        inv.display();
        System.out.println();

        ItemStack stack4 = new ItemStack(1,diamondSword);
        System.out.println("4.向背包中添加 1 把钻石剑：");
        inv.addItem(stack4);
        inv.display();
        System.out.println();

        ItemStack stack5 = new ItemStack(35 * 64,wood);
        System.out.println("5.尝试向背包中添加 35 个木板堆，每个堆包含 64 个木板：");
        inv.addItem(stack5);
        inv.display();
        System.out.println();

        System.out.println("6.从背包中移除 10 个石头：");
        inv.removeItem("石头",10);
        inv.display();
        System.out.println();

    }
}
