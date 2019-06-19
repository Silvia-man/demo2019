package generics;
//未看！！！！！
public class GenericInheritan {

    public static void main(String[] args) {
        String str = "abc";
        Object obj;
        obj = str;
        System.out.println(obj);

        MyClass<String> myClass1 = new MyClass<>();
        MyClass<Object> myClass2 = new MyClass<>();
        //myClass2=myClass1; // compilation error since MyClass<String> is not a MyClass<Object>
        obj = myClass1;
        System.out.println(obj);
        System.out.println(myClass1);

    }

    public static class MyClass<T> {

    }

}
