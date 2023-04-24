package leetcode;

public class LargestMergeOfTwoStrings {

    public static String largestMergeRecursive(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0){
            return word1 + word2;
        }
        if(word1.compareTo(word2) > 0){
            return word1.charAt(0) + largestMergeRecursive(word1.substring(1), word2);
        }
        return word2.charAt(0) + largestMergeRecursive(word1, word2.substring(1));
    }

    public static String largestMergeIterative(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        while (word1.length() > 0 && word2.length() > 0){
            if(word1.compareTo(word2) > 0){
                res.append(word1.charAt(0));
                word1 = word1.substring(1);
            }else {
                res.append(word2.charAt(0));
                word2 = word2.substring(1);
            }
        }

        if (word1.length() > 0){
            res.append(word1);
        }
        if(word2.length() > 0){
            res.append(word2);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestMergeIterative("abcabc", "abdcaba"));
    }
}
