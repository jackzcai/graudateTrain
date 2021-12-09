package hanshunping.easy;

import java.util.Scanner;

/**
 * create by: 蔡博
 * description: TODO
 * create time: 2021/11/30 18:17
 * 控制结构练习题
  * @Param: null
 * @return
 */
public class Circle {
    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/11/30 18:02
     * 某人有十万
      * @Param: null
     * @return
     */
    public static void main(String[] args){
        int money = 100000;
        int times = 0;
        while(money > 0){
            if(money > 50000){
                money = money - money / 20;
                times++;
            }
            else{
                if((money - 1000) < 0)
                    break;
                money = money - 1000;
                times++;
            }
        }
        System.out.println("此人能够交" + times +"次过路费");
    }
}

/**
 * create by: 蔡博
 * description: TODO
 * create time: 2021/11/30 18:17
 * 判断是否为闰年
  * @Param: null
 * @return
 */
class RunNian{
    public static void main(String[] args){
        System.out.println("请输入年份");
        Scanner mysc = new Scanner(System.in);
        int year = mysc.nextInt();
        switch(year % 4){
            case 0:
                if(year % 100 != 0)
                    System.out.println(year + "是闰年");
                else
                    System.out.println(year + "不是闰年");
                break;
            case 1:
            case 2:
            case 3:
                System.out.println(year + "不是闰年");
        }
    }
}
