package com.bubo.knowledge.cases;

/**
 * @author: Hongjj
 * @date: 2022/5/6 09:59
 * @desc:  稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个二维数组 11*11   0：没有棋子， 1：黑棋， 2：白棋
        int [][] a = new int[11][11];
        a[1][2] = 1;
        a[2][3] = 2;
        System.out.println("原数组为：");

        for (int[] x : a) {
            for (int i : x) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        System.out.println("=============================");

        //转化为稀疏数组
        //先获取有效值的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (a[i][j] != 0){
                    sum ++;
                }
            }
        }
        System.out.println("有效值的个数为：" + sum);

        //创建稀疏数组
        int[][] b = new int[sum+1][3];
        b[0][0] = 11;
        b[0][1] = 11;
        b[0][2] = sum;

        //遍历二维数组，将非0的值存放到稀疏数组
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0){
                    count++;
                    b[count][0] = i;
                    b[count][1] = j;
                    b[count][2] = a[i][j];
                }
            }
        }
        System.out.println("稀疏数组为：");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i][0] + "\t" + b[i][1] + "\t" + b[i][2] + "\t");
        }

        System.out.println("=============================");
        System.out.println("还原数组:");

        //读取稀疏数组
        int[][] c = new int[b[0][0]][b[0][1]];

        //还原数组的值
        for (int i = 1; i <b.length ; i++) {
            c[b[i][0]][b[i][1]] = b[i][2];
        }
        System.out.println("还原数组为：");
        for (int[] i: c) {
            for (int j:i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }

    }
}
