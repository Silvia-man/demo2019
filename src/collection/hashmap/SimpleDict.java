package collection.hashmap;

import java.util.*;

//循环里不要删除和添加
public class SimpleDict {
    public static void main(String[] args) {
        Map<String, List<String>> dict = generateDictBook();

        loopDictBook(dict);
    }

    private static void loopDictBook(Map<String, List<String>> dict) {
        Iterator<Map.Entry<String ,List< String>>> iDict = dict.entrySet().iterator();

        //StringBuilder strDict = new StringBuilder();
        String strDict = "";
        while(iDict.hasNext()){
            Map.Entry<String, List<String >> entryDict = iDict.next();
            String key = entryDict.getKey();
            List<String> valueList = entryDict.getValue();

            /*
            strDict = strDict + "{" + key + ": [";
            for (String word : valueList){
                strDict = strDict + word + " ";
            }
            strDict = strDict  + "]}   ";
            */

            strDict = strDict + "{" + key + ": " + valueList.toString() + "}   ";

        }
        System.out.println(strDict.toString());
    }

    private static Map<String, List<String>> generateDictBook() {
        Map<String , List<String>> dict = new HashMap<>();

        List<String> listA = new ArrayList<>();
        listA.add("apple");
        listA.add("add");
        listA.add("about");
        listA.add("all");
        dict.put("A", listA);

        List<String> listB = new ArrayList<>();
        listB.add("banana");
        listB.add("bat");
        listB.add("bite");
        listB.add("bike");
        dict.put("B", listB);

        List<String> listC = new ArrayList<>();
        listC.add("cat");
        listC.add("circle");
        listC.add("car");
        listC.add("choclete");
        dict.put("C", listC);


        return dict;
    }

}
