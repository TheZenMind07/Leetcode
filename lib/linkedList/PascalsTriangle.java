import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1)); 
        for(int i = 1; i < n ; i++) {
            ArrayList<Integer> temp = new ArrayList<>(i+1);
            for(int j = 0; j <= i; j++) {
                System.out.println("Printing j and i values : " + j + " " + i);
                temp.add(getValue(res.get(res.size() -1), j));
            }
                
            res.add(temp);
        }

        System.out.println(res);

    }

    public static int getValue(List<Integer> al, int index) {
        if(index == 0 || index == al.size()) { 
            return 1;
        }

        return al.get(index) + al.get(index -1 );
    }

}
