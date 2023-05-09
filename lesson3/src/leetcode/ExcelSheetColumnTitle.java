package leetcode;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        int current = columnNumber;
        String s = "";
        while (current > 0) {
            int d = current % 26;
            if(d == 0){
                s = ((char) ('A' + 25)) + s;
            }else {
                s = (char) ('A' + d) + s;
            }
            current = current / 26;
        }
        return s;
    }

    public static String convertToTitle2(int columnNumber) {
        int current = columnNumber;
        StringBuilder s = new StringBuilder();
        while (current / 26 >= 26) {
//            --current;
//            int d = current % 26;
            current = current / 26;
            s.append('Z');
//            s.append((char) ('A' +d) );
        }
        if(current > 26){
            s.append((char) ('A' + current - 1));
        }

        int d = current % 26;
        if(d > 0){
            s.append((char) ('A' + d - 1));
        }

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
