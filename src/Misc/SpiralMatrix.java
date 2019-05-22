package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SpiralMatrix {


    public static void main(String[] args) {


        //Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.


    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int nr = matrix.length;
        if(nr == 0)
            return res;
        int nc = matrix[0].length;

        int rl = 0, rh = nr - 1, cl = 0, ch = nc - 1;
        int count = 0;
        while(rl <= rh && cl <= ch){
            System.out.println(count);
            fillValues(res, matrix, rl, rh, cl, ch);
            rl++;
            rh--;
            cl++;
            ch--;
        }

        return res;
    }

    public void fillValues(List<Integer> list, int[][] matrix,
                           int lr, int hr, int lc, int hc){
        for(int i = lc; i <= hc; i++)
            list.add(matrix[lr][i]);
        for(int i = lr + 1; i <= hr; i++)
            list.add(matrix[i][hc]);
        if(lr != hr){
            for(int i = hc - 1; i >= lc; i--)
                list.add(matrix[hr][i]);
        }
        if(lc != hc){
            for(int i = hr - 1; i > lr; i--)
                list.add(matrix[i][lc]);
        }

    }
}
