package leetcode;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        int word1Left = 0;
        int word2Left = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (word1Left < word1Chars.length && word2Left < word2Chars.length){
            stringBuilder.append(word1Chars[word1Left++]);
            stringBuilder.append(word1Chars[word2Left++]);
        }

        while (word1Left < word1Chars.length){
            stringBuilder.append(word1Chars[word1Left++]);
        }

        while (word2Left < word2Chars.length){
            stringBuilder.append(word2Chars[word2Left++]);
        }
        return stringBuilder.toString();
    }
}
