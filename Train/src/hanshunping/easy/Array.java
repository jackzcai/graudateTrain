package hanshunping.easy;

import java.util.Scanner;

/**
 * create by: 蔡博
 * description: TODO
 * create time: 2021/12/1 18:13
 * 数组 排序 查找
  * @Param: null
 * @return
 */
public class Array {
    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/12/1 18:31
     * 数组缩减
      * @Param: null
     * @return
     */
    public static void main(String[] args){
        int array[] = {1,2,5,6,9,7};
        Scanner mysc = new Scanner(System.in);
        do{
            System.out.println("是否继续删除？ y/n");
            if(mysc.next().charAt(0)=='n'){
                break;
            }
            int arrayNew[] = new int[array.length-1];
            for(int i = 0;i < arrayNew.length;i++){
                arrayNew[i] = array[i];
            }
            array = arrayNew;
            for(int i = 0;i < array.length;i++){
                System.out.print(array[i]+" ");
            }
        }while(array.length != 1);
    }
}

class MaoPao{
    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/12/1 23:18
     * 冒泡排序
      * @Param: null
     * @return
     */
    public static void main(String[] args){
        int array[] = {8,4,3,6,5,7,9};
        for(int i = 0; i < array.length-1; i++){
            for(int k = 0; k < array.length-i-1; k++){
                if(array[k] > array[k+1]){
                    int temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                }
            }
        }
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}

class YangHui{
    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/12/1 23:17
     * 输出杨辉三角
      * @Param: null
     * @return
     */
    public static void main(String[] args){
        System.out.println("你想要的杨辉三角层数");
        Scanner mysc = new Scanner(System.in);
        int count = mysc.nextInt();
        int[][] array = new int[count][];
        for(int i = 0; i < count; i++){
            array[i] = new int[i+1];
            array[i][0] = array[i][i]=1;
            if(i > 1)
            for (int j = 1; j < i; j++) {
                array[i][j] = array[i - 1][j-1] + array[i - 1][j];
            }
        }
        for(int i = 0;i < array.length;i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}