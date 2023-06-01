package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= min && i < list2.length; i++){
            List<String> tmpRes = new ArrayList<>();
            if(map.containsKey(list2[i])){
                if(min > (i + map.get(list2[i]))){
                    min = i + map.get(list2[i]);
                    tmpRes.add(list2[i]);
                    res = tmpRes;
                } else if(min == (i + map.get(list2[i]))){
                    min = i + map.get(list2[i]);
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);

    }

    public static void main(String[] args) {
        System.out.println(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"}));
        System.out.println(findRestaurant(new String[]{"happy","sad","good"}, new String[]{"sad","happy","good"}));

    }
}
