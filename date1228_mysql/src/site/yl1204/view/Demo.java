package site.yl1204.view;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import javax.swing.JTextField;  
import javax.swing.Timer;  
import javax.swing.JFrame;  
  
public class Demo extends JFrame{
	public Demo() {
	}  
      
    //��� ��ʾʱ���JTextField  
    public void addComponent(){  
        JTextField time = new JTextField();  
        this.getContentPane().add(time);  
        this.setTimer(time);  
    }  
    //��ʾ����  
   public void showTime(){  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //this.pack();//�Զ���Ӧ���ڴ�С  
        this.setSize(160, 80);  
        this.setVisible(true);  
    }  
  
    //����Timer 1000msʵ��һ�ζ��� ʵ����һ���߳�  
    public void setTimer(JTextField time){  
        final JTextField varTime = time;  
        Timer timeAction = new Timer(1000, new ActionListener() {         
  
            public void actionPerformed(ActionEvent e) {      
                long timemillis = System.currentTimeMillis();  
                //ת��������ʾ��ʽ  
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                varTime.setText(df.format(new Date(timemillis)));  
            }     
        });           
        timeAction.start();       
    }  
  
    public static void main(String[] args) {  
    	Demo timeFrame = new Demo();  
        timeFrame.addComponent();  
        timeFrame.showTime();  
    }  
  
}  

