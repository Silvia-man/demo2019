package generics;

import java.util.HashMap;

public class WordCount {
    public static void main(String[] args) {
        String sentence = "Hi hello Hi Hello Hi sync extream agile hello sync";
        String[] words = sentence.split(" ");

       // HashMap<String, Integer> mapStr = wordCount(words);
        //System.out.println(mapStr);

        wordPrint(words);
        Integer nums[] = {1,2,3,6,2,5,3,1};
        wordPrint(nums);

    }

    private static <T> void wordPrint(T array[]) {

        HashMap<T, Integer> map = wordCount(array);
        System.out.println(map);
    }

    public static <T> HashMap<T, Integer> wordCount(T group[]) {
        HashMap<T, Integer> map = new HashMap<>();

        for(T member : group){
            if(map.get(member) == null){
                map.put(member, 1);
            } else {
                map.put(member, map.get(member) + 1);
            }

        }
        return map;

    }
}
