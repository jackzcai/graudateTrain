package test;

public class Train3 {
    public static void main(String[] args){
    hh(5);
    }

    static void hh(int i){
      int j=i;
      if(i!=0)
      hh(i-1);
      j=j+1;
      if(i==5)
      System.out.println(j);
    }
}
