package function;

import java.util.Scanner;

public class Bit {

    /**
     * create by: 蔡博
     * description: TODO
     * create time: 2021/11/26 15:52
     * 实现二进制的转换和基础位运算
      * @Param: null
     * @return
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opNumber = scanner.nextInt();


    }




    public String turnBit(int turnNumber){
        String numberString = turnNumber + "";
        int length = numberString.length();
        return "";
    }
    public String reverse() {
        boolean hasSurrogates = false;
        int n = count - 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) ||
                    Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            reverseAllValidSurrogatePairs();
        }
        return this;
    }
}
