import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prevList = new ArrayList<>();
        for(int i = 0; i <= numRows; i++){
            List<Integer> currentList = pascalTriangle(prevList, i);
            result.add(currentList);
            prevList = currentList;
        }
        return result.get(numRows);
    }

    public List<Integer> pascalTriangle(List<Integer> current, int n){
        List<Integer> list = new ArrayList<>();
        if(current.isEmpty()){
            list.add(1);
            return list;
        }
        list.add(1);
        for(int i =0; i< n -1; i++){
            list.add(current.get(i) + current.get(i+1));
        }
        list.add(1);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle2().generate(3));
    }
}
