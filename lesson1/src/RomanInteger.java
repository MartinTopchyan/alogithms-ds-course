import java.util.HashMap;
import java.util.Map;

public class RomanInteger {

    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int prev = 0;
//        for(int i = 0; i < chars.length; i++){
//            int curr = map.get(chars[i]);
//            if(curr > prev){
//                sum-= prev;
//                sum += curr - prev;
//            }else {
//                sum += curr;
//            }
//            prev = curr;
//        }

//        int prev2 = 0;
        for(int i = chars.length -1; i >= 0; i--){
            int curr = map.get(chars[i]);
            if(curr < prev){
                sum-= prev;
                sum += prev-curr;
            }else {
                sum += curr;
            }
            prev = curr;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new RomanInteger().romanToInt("MCMXCIV"));
    }
}
