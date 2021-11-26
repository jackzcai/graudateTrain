import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing{
    /**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);



        for(int i=0;i<5;i++){

int k=i;
            JFrame frame = new JFrame("HelloWorldSwing"){
                public void finalize() throws Throwable{
                    System.out.println("对象被释放"+k);
                }
            };
            frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);

            ActionListener listener = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.gc();
                }

            };

            JButton loginButton = new JButton("login");
            loginButton.setBounds(10, 80, 80, 25);
            loginButton.addActionListener(listener);
        frame.setSize(350, 200);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel(String.valueOf(i)+"\t\t\tjackcai\t\t\nhahaha");
        frame.getContentPane().add(label);
            frame.add(loginButton);
        // 显示窗口
        frame.pack();
        frame.setVisible(true);}
System.out.println("ceshi");

    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();

            }
        });
    }
}
