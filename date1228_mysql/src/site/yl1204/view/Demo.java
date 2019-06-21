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
      
    //添加 显示时间的JTextField  
    public void addComponent(){  
        JTextField time = new JTextField();  
        this.getContentPane().add(time);  
        this.setTimer(time);  
    }  
    //显示窗口  
   public void showTime(){  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //this.pack();//自动适应窗口大小  
        this.setSize(160, 80);  
        this.setVisible(true);  
    }  
  
    //设置Timer 1000ms实现一次动作 实际是一个线程  
    public void setTimer(JTextField time){  
        final JTextField varTime = time;  
        Timer timeAction = new Timer(1000, new ActionListener() {         
  
            public void actionPerformed(ActionEvent e) {      
                long timemillis = System.currentTimeMillis();  
                //转换日期显示格式  
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

