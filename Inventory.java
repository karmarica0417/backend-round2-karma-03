package com.lingrui.question.T3;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int capacity;
    private List<ItemStack> items;

    public Inventory(int capacity, List<ItemStack> items) {
        this.capacity = capacity;
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }
    }

    public Inventory() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public void setItems(List<ItemStack> items) {
        this.items = items;
    }




    public int addItem(ItemStack itemStackToAdd){
        String itemName = itemStackToAdd.getItem().getName();
        int itemToAddMaxStackSize = itemStackToAdd.getItem().getMaxStackSize();
        int remainSize = itemStackToAdd.getQuantity();


        for (ItemStack itemStack : items){
            if(itemName.equals(itemStack.getItem().getName())){
                int canAdd = itemToAddMaxStackSize - itemStack.getQuantity();
                if (canAdd > 0){


                    int addQuantity = Math.min(canAdd, remainSize);

                    remainSize = remainSize - addQuantity;
                    itemStack.setQuantity(itemStack.getQuantity() + addQuantity);

                }
            }
            if(remainSize <= 0){
                break;
            }
        }

        while (remainSize > 0 && items.size() < capacity){
            int addQuantity = Math.min(itemToAddMaxStackSize , remainSize);
            ItemStack newStack = new ItemStack(addQuantity , itemStackToAdd.getItem());
            items.add(newStack);

            remainSize = remainSize - addQuantity;
        }

        System.out.println("有" + remainSize + "个" + itemName + "添加失败");
        return remainSize;

    }


    public void removeItem(String itemName, int amountToRemove){


        for (int i = 0; i < items.size();){
            ItemStack itemStack = items.get(i);

            int canRemove = itemStack.getQuantity();
            int removeQuantity = Math.min(amountToRemove , canRemove);
            if(itemName.equals(itemStack.getItem().getName())){
                amountToRemove = amountToRemove - removeQuantity;
                if (amountToRemove > 0){
                    items.remove(i);
                } else {
                    amountToRemove = 0;
                    itemStack.setQuantity(canRemove - removeQuantity);
                    break;
                }
            } else {
                i++;
            }
        }

    }


    public int getItemCount(String itemName){
        int itemCount = 0;
        for (ItemStack itemStack : items){
            if(itemName.equals(itemStack.getItem().getName())){
                itemCount = itemCount + itemStack.getQuantity();
            }
        }
        return itemCount;
    }


    public void display(){
        for (ItemStack itemStack : items){
            System.out.print(itemStack.getItem().getName() + itemStack.getQuantity() + "个; ");
        }
        System.out.println("背包占用" + items.size() + "/" + capacity);
    }

}
