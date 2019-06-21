package site.yl1204.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import site.yl1204.Dao.AdminDao;
import site.yl1204.domain.Admin;
import site.yl1204.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		setTitle("\u767B  \u5F55");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrm.class.getResource("/images/0007020103237155_b.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel label_1 = new JLabel("\u5BC6    \u7801\uFF1A");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
/*		passwordTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//ÊµÏÖenter¼üµÇÂ¼
				int code = e.getKeyCode();
				if(passwordTxt.toString()!=""){
					if (code==13){
						
						LoginActionFrom(e);
					}
				}	
			}
		});*/
		
		JButton button = new JButton("\u767B \u5F55");
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();				
					if (code==13){
						
					}
				
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//µÇÂ¼
				LoginActionFrom(e);
				
			}
		});
		
		JButton button_1 = new JButton("\u6CE8 \u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//×¢²á
				new AddFrm().setVisible(true);
			}
		});
		
		JLabel label_3 = new JLabel("\u6CA1\u6709\u8D26\u53F7\uFF1F\u70B9\u51FB\u6CE8\u518C");
		label_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/12.gif")));
		label_3.setBackground(Color.LIGHT_GRAY);
		label_3.setFont(new Font("ËÎÌå", Font.PLAIN, 12));
		label_3.setForeground(Color.RED);
		
		JLabel label_4 = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/1234.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(426, Short.MAX_VALUE)
					.addComponent(label_4)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(userNameTxt, 122, 122, 122))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1)
							.addGap(18)
							.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(163)
					.addComponent(lblNewLabel_1)
					.addContainerGap(273, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(138, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(44)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_3)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(35, Short.MAX_VALUE)
							.addComponent(label_4)
							.addGap(59))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(25)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_1)
							.addComponent(label_3))
						.addComponent(button))
					.addGap(48))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
	


/*private void LoginActionFrom(KeyEvent e) {
		
	AdminDao ad = new AdminDao();
	User user = new User();
	String name = userNameTxt.getText();
	String password = new String(passwordTxt.getPassword());
	user.setUname(name);
	user.setUpassword(password);
	User currentuser = ad.login(user);
	if(currentuser!=null){
		JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦");
		dispose();
		new UserDialog().setVisible(true);
	}else{
		JOptionPane.showMessageDialog(null, "ÕËºÅ»òÃÜÂëÓÐÎó");
	}
}*/

/**
 * µÇÂ¼ÊÂ¼þ
 * @param evt
 */
	private void LoginActionFrom(ActionEvent evt) {			
		String name = userNameTxt.getText();
		String password = new String(passwordTxt.getPassword());
		AdminDao ad = new AdminDao();
		if(!name.equals("admin") && !password.equals("root")){
			User user = new User();
			user.setUname(name);
			user.setUpassword(password);
			User currentuser = ad.login(user);
		
			if(currentuser!=null){
				JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦");
				dispose();
				new UserDialogOther().setVisible(true );
			}else{
				JOptionPane.showMessageDialog(null, "ÕËºÅ»òÃÜÂëÓÐÎó");
			}
		}else{
			Admin admin = new Admin();
			admin.setAdminname(name);
			admin.setAdminpassword(password);
			Admin currentuser = ad.checkUser(admin);
			if(currentuser!=null){
				JOptionPane.showMessageDialog(null, "µÇÂ½³É¹¦£¬»¶Ó­¹ÜÀíÔ±");
				dispose();
				new UserDialog().setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Ç×£¬ÕËºÅ»òÃÜÂëÓÐÎóÅ¶");
			}
		}
			
		
		
	}
}
