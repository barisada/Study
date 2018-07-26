package interviewPrep.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        List<Integer> zeroCol = new ArrayList<>();

        for(int i = 0; i < a.size(); i++){
            ArrayList<Integer> row = a.get(i);
            if(row.contains(0)){
                for(int j = 0; j < row.size(); j++){
                    if(0 == row.get(j) && !zeroCol.contains(j)){
                        zeroCol.add(j);
                    }
                    row.set(j,0);
                }
            }
        }

        for(int i = 0; i < zeroCol.size(); i++){
            int col = zeroCol.get(i);
            for(int j = 0; j < a.size(); j++){
                a.get(j).set(col, 0);
            }

        }
    }

}
