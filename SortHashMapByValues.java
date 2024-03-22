import java.util.*;

public class SortHashMapByValues {
    public static void main(String[] args) {
        Map<String, Integer> hmp=new HashMap<>();
        hmp.put("Madhu", 1);
        hmp.put("sid", 0);
        hmp.put("Abhi", -1);
        hmp.put("Vamshi", 3);

        System.out.println("Before Sorting by Value:\n" +hmp);

        //Taking a list since hashmap does not guarantee any order and dumping the values of hashmap to it

        List<Map.Entry<String, Integer>> temp=new ArrayList<>(hmp.entrySet());

        //entrySet() basically gives all the values in the HashMap


        //Sort the list using lambda function. (Since temp is already of type Map.Entry<String, Integer> we need worry about types while using lambda function)
        Collections.sort(temp, (obj1, obj2) -> {
            return obj2.getValue().compareTo(obj1.getValue());

            //This will result in decreasing order (highest value first);
            //If we want increasing order we can write return obj1.getValue().compareTo(obj2.getValue());
        });

        System.out.println(temp);

        //If we want HashMap as a result, we can convert this list into LinkedHashMap (becuase HashMap does not preserve order)


        Map<String, Integer> lhmp=new LinkedHashMap<>();
        for(Map.Entry<String, Integer> m: temp) {
            lhmp.put(m.getKey(), m.getValue());
        }
        System.out.println(lhmp);

        }

}
