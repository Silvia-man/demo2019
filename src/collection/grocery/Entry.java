package collection.grocery;

public class Entry {
    public static Grocery grocery = new Grocery();

    public static void main(String[] args){
        grocery.addItem("huawei p30");
        grocery.addItem("desk");
        grocery.addItem("pinapple");
        grocery.addItem("cherry");
        grocery.addItem("strawberry");
        grocery.addItem("bean");
        grocery.addItem("pen");

        System.out.println("Total number of " + grocery.total());
        System.out.println("Items are " + grocery.toString());

        grocery.delItemBypos(4);
        grocery.delItemByValue("bean");

        grocery.modifyItem(0, "huawei p30 pro");

        String pen = grocery.findItem("pen");
        System.out.println("find :" + pen);

        System.out.println("Total number of " + grocery.total());
        System.out.println("Items are " + grocery.toString());
    }

}
