package test;

class A {
    private int a;

    public A(int a) {
        this.a = a;
    }
    public int getA(){
        return this.a;
    }
    public void finalize() throws Throwable{
        System.out.println("对象被释放"+this.getA());
        return;
    }
};

public class Text {
    public static void main(String args[]) throws InterruptedException {
        A aa = null;
        for (int i = 1; i <= 10; i++) {
            aa = new A(i);

        }
System.out.println(aa.getA());
        System.gc();
    }
}
