package collection.grocery;

import java.util.ArrayList;
import java.util.List;

public class Grocery {

    Integer[] total;
    List<String> grocery = new ArrayList<>();

    public void listAll(){
        System.out.println("You have " + grocery.size() + " items currently");

        for(String item : grocery) {
            System.out.println(item);
        }
    }

    public void addItem(String item){
        grocery.add(item);
        System.out.println(item + " added");


    }

    public void delItemBypos(int position){
        System.out.println(grocery.get(position) + " removed");
        grocery.remove(position);
    }

    public void delItemByValue(String item){
        grocery.remove(item);
        System.out.println(item + " removed");
    }

    public void modifyItem(int position, String item){
        System.out.println(grocery.get(position) + " modified to " + item);
        grocery.set(position, item);
    }

    public String findItem(String item){
        if(grocery.contains(item)){
            int position = grocery.indexOf(item);
        //    System.out.println(i);
            return item + " found";
        }
        System.out.println(item + " not found");
        return null;
    }

    public int total(){
        return grocery.size();
    }

    public String toString(){
        return grocery.toString();
    }
}
