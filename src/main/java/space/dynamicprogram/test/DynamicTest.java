package space.dynamicprogram.test;

import space.dynamicprogram.dynamic.Solution;

import java.util.ArrayList;

public class DynamicTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> vList = new ArrayList();
        ArrayList<Integer> wList = new ArrayList();
        vList.add(3);
        vList.add(4);
        vList.add(5);
        vList.add(8);
        vList.add(10);
        wList.add(2);
        wList.add(3);
        wList.add(4);
        wList.add(5);
        wList.add(9);
        solution.setVl(vList);
        solution.setWl(wList);
        System.out.println(knapsack(solution,21));
    }


    public static int knapsack(Solution solution,int Cap){
        ArrayList<Integer> vList = solution.getVl();
        ArrayList<Integer> wList = solution.getWl();
        vList.add(0,0);
        wList.add(0,0);
        Integer[] v = vList.toArray(new Integer[vList.size()]);
        Integer[] w = wList.toArray(new Integer[wList.size()]);
        Integer[][] result = new Integer[v.length][Cap];
        for (int i = 0; i < v.length; i++){
            result[i][0] = 0;
        }
        for (int i = 0; i < Cap; i++){
            result[0][i] = 0;
        }
        for (int i = 1;i < v.length; i++){
            for (int j = 1;j < Cap; j++){
                System.out.println("j < w[i]?:" + (j < w[i]) + "            i:" + i + "          j:" + j + "      w[i]:"+w[i]);
                if (j < w[i]){
                    result[i][j] = result[i -1][j];
                }else {
                    System.out.println("result[i - 1][j] > result[i - 1][j - w[j]] + v[i]?"
                            + (result[i - 1][j] > result[i - 1][j - w[i]] + v[i]));
                    if(result[i - 1][j] > result[i - 1][j - w[i]] + v[i]){
                        result[i][j] = result[i -1][j];
                    }else {
                        result[i][j] = result[i - 1][j - w[i]] + v[i];
                    }
                }
                System.out.println("i:" +i+ "      j:" +j+"     result[i][j]:" + result[i][j] + "--------------" );
            }
        }
        return result[v.length - 1][Cap - 1];
    }
}
