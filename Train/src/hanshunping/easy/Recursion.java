package hanshunping.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * create by: 蔡博
 * description: TODO
 * create time: 2021/12/6 17:42
 * 递归练习
  * @Param: null
 * @return
 */
public class Recursion {
    public static void main(String[] args){

    }
}

class FeiBoNaQi {
/**
 * create by: 蔡博
 * description: TODO
 * create time: 2021/12/6 18:01
 * 递归解决波那契数列
  * @Param: null
 * @return
 */
    public static void main(String[] args){
        System.out.println("输入你想要的斐波那契数列位数");
        Scanner mysc = new Scanner(System.in);
        int number = mysc.nextInt();
        int resArray[] = new int[number];
        res(number, resArray);
        for(int i = 0; i < resArray.length; i++){
            System.out.print(resArray[i]+"  ");
        }
    }
    public static int res(int n, int resArray[]){
        if(n == 1 || n == 2){
            resArray[n-1] = 1;
            return 1;
        }
        resArray[n-1] = res(n - 1, resArray) + res(n - 2, resArray);
        return resArray[n-1];
    }
}


class HanNuoTa {
    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/12/7 0:20
     * 递归解决汉诺塔问题
      * @Param: null
     * @return
     */
    static int i = 0;
    public static void main(String[] args){
        System.out.println("输入汉诺塔层数");
        Scanner mysc = new Scanner(System.in);
        int num = mysc.nextInt();
        move(num, 'A', 'B', 'C');
        System.out.println("共移动了" + i + "次");
    }
    public static void move(int num, char a, char b, char c){
        if(num == 1){
            System.out.println(a + "移到" + c);
            i++;
        }
        else{
            move(num - 1, a, c, b);
            System.out.println(a + "移到" + c);
            i++;
            move(num - 1, b, a, c);
        }
    }
}

class BaHuangHou {
    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/12/7 10:22
     * 递归解决八皇后问题(未实现，递归思路不正确）
      * @Param: null
     * @return
     */
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args){
        int qiPan[][] = new int[8][8];
        can(qiPan, 0, 0);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(qiPan[i][j]+" ");
            }
            System.out.print("\n");
        }

    }


    public static boolean can(int qiPan[][], int i, int j){
    if(res.size() == 8){
        return true;
    }
    else{
        if(i < 8 && j < 8 && i >= 0 && j >= 0) {

        boolean check = true;
        for(int tryN = 0; tryN < 8; tryN++){
            if( (qiPan[tryN][j] == 1 && tryN != i) || (qiPan[i][tryN] == 1 && tryN != j) )
                check = false;
        }
        for(int tryI = 0; tryI < 8; tryI++){
            for(int tryJ = 0; tryJ < 8; tryJ++){
                if((tryI - tryJ) == (i - j) && (tryI != i && tryJ != j) )
                    if(qiPan[tryI][tryJ] == 1)
                        check = false;
            }
        }
        if(qiPan[i][j] == 0 ){
            qiPan[i][j] = 1;
            res.add(j);
            if (!check) {
                qiPan[i][j] = 0;
                res.remove(res.size() - 1);
            }
            if (can(qiPan, i, j + 1)) {
                return true;
            } else if (can(qiPan, i + 1, 0)) {
                return true;
            }else {
                qiPan[i][j] = 0;
                return false;
            }
        }else {
                return false;
            }
        }else{
            return false;
        }
    }
    }
}


class BaHuangHouFinal {
    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/12/9 16:17
     * 解决八皇后问题  想明白递归的原理，问题，状态，行为三者的关系
      * @Param: null
     * @return
     */
    static int count = 0;
    public static void main(String[] args) {
        int qiPan[][] = new int[8][8];
        can(qiPan, 0, 0);
    }

    public static boolean can(int qiPan[][], int i, int j){
        boolean check = true;
        for(int tryN = 0; tryN < 8; tryN++){
            if(i < 8 && j < 8 && i >= 0 && j >= 0){
            if( (qiPan[tryN][j] == 1 && tryN != i) || (qiPan[i][tryN] == 1 && tryN != j) )
                check = false;}
            else
                check = false;
        }
        for(int tryI = 0; tryI < 8; tryI++){
            for(int tryJ = 0; tryJ < 8; tryJ++){
                if(i < 8 && j < 8 && i >= 0 && j >= 0){
                if(((tryI - tryJ) == (i - j)) || ((tryI + tryJ) ==(i + j)) && (tryI != i && tryJ != j) )
                    if(qiPan[tryI][tryJ] == 1)
                        check = false;}
                else check =false;
            }
        }

        boolean stop = false;
        for(int q=0;q<8;q++){
            if(qiPan[7][q]==1)
                stop = true;
        }
        if(stop){
            count++;
            System.out.println("第"+count+"种解法");
            for(int resultI = 0; resultI < 8; resultI++){
                for(int resultJ = 0; resultJ < 8; resultJ++){
                    System.out.print(qiPan[resultI][resultJ]+" ");
                }
                System.out.print("\n");
            }
            System.out.println("--------------------");
            return false;
        }else{
            if(check && i < 8 && j < 8 && i >= 0 && j >= 0){
                qiPan[i][j]=1;
                if(can(qiPan,i+1,0)){
                    return true;
                }else{
                    qiPan[i][j]=0;
                    if(can(qiPan,i,j+1)){  //用到回溯
                        return true;
                    }
                    return false;
                }
            }else if(i < 8 && j < 8 && i >= 0 && j >= 0){
                if(can(qiPan,i,j+1)){
                    return true;
                }
                else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}

