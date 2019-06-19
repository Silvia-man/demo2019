package collection.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Set;

public class MapBasic {
    public static void main(String[] args) {

        Map<String, String> data = new HashMap<>();
        data.put("A", "A1");    //  Map自动排序，   List不能
        data.put(null, "E1");
        data.put("C", "C1");
        data.put("D", "D1");
        data.put("F", "D1");
        data.put("B", "B1");

        System.out.println("data = " + data);

        String b = data.get("X");
        System.out.println(b);

        String d = data.getOrDefault("X", "no exist");
        System.out.println(d);

        boolean isXExist = data.containsKey("X");
        System.out.println(isXExist);

        Set<Map.Entry<String, String>> entrySet = data.entrySet();
        //Set<Entry<String, String>> entrySet = data.entrySet();
        System.out.println(entrySet);
        System.out.println(entrySet.size());

        Map<String, String> back = new HashMap<>(data);
        //back.putAll(data);
        System.out.println(back);

        String nullValue = data.remove(null);   //把删掉的对应的value返回，以便其他操作
        System.out.println(data);
        System.out.println(nullValue);

        Set<String> keySet = data.keySet();     //key是唯一的，set可保证唯一性
        System.out.println(keySet);

        Collection<String> valueSet = data.values();    //value可重复， 用collection
        System.out.println(valueSet);



    }
}
