package site.yl1204.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import site.yl1204.Dao.AdminDao;
import site.yl1204.domain.User;
import site.yl1204.utils.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddFrm extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JPasswordField passwordTxt2;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrm frame = new AddFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AddFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddFrm.class.getResource("/images/QQ\u622A\u56FE20181227200307.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel label_1 = new JLabel("\u6CE8 \u518C \u65B0 \u7528 \u6237");
		label_1.setFont(new Font("华文楷体", Font.BOLD, 26));
		
		JLabel label_2 = new JLabel("\u5BC6    \u7801\uFF1A");
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton button = new JButton("\u786E \u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//注册
				addActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u53D6 \u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消，退出
				//System.exit(0);
				dispose();
			}
		});
		
		JLabel label_3 = new JLabel("\u91CD\u590D\u5BC6\u7801\uFF1A");
		
		passwordTxt2 = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(136)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(button)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_1)
								.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordTxt2)
									.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(168)
							.addComponent(label_1)))
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(label_1)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(passwordTxt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
/**
 * 注册事件
 * @param e
 */
	private void addActionPerformed(ActionEvent evt) {
		AdminDao ad = new AdminDao();
		User user = new User();
		String name = usernameTxt.getText();
		String psd = new String(passwordTxt.getPassword());
		String psd2 = new String(passwordTxt2.getPassword());
		
		if("".equals(name.trim())||"".equals(psd.trim())||"".equals(psd2.trim())){
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
			return;
		}
		if(psd.equals(psd2)){
			user.setUname(name);
			user.setUpassword(psd);
			int n=ad.addUser(user);
			if(n>0){
				JOptionPane.showMessageDialog(null, "注册成功");				
			}
		}else{
			JOptionPane.showMessageDialog(null, "两次密码不一致");
			return;
		}
	}

}
