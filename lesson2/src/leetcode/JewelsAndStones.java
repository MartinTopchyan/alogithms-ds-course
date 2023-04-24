package leetcode;

import java.util.Arrays;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int jewelsCount = 0;
        for (char ch: stones.toCharArray()){
            if(jewels.indexOf(ch) > -1){
                jewelsCount++;
            }
        }
        return jewelsCount;
    }
}
