import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while(Math.abs(x) > 9){
            int currentReminder = x %10;
            list.add(currentReminder);
            x = x/10;
        }
        list.add(x);

        for(int i =0, j = list.size() -1; i < j ; i++, j--){
            if(list.get(i) != list.get(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(-121));
    }
}
