package site.yl1204.view;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  




import javax.swing.JTextField;  
import javax.swing.Timer;  
import javax.swing.JFrame; 

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import site.yl1204.Dao.AdminDao;
import site.yl1204.domain.User;

import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UserDialogOther extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	AdminDao ad = new AdminDao ();
	private JTextField textField;
	private JTextField tfname;
	private JTextField sclass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserDialogOther dialog = new UserDialogOther();
			dialog.setVisible(true); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserDialogOther() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserDialogOther.class.getResource("/images/111.jpg")));
		setTitle("\u7528\u6237\u7BA1\u7406");
		setResizable(false);
		setBounds(100, 100, 450, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u7528\u6237\u67E5\u770B");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.BOLD, 21));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(label)
					.addContainerGap(346, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		
		JLabel label_1 = new JLabel("\u5E8F\u53F7");
		
		JLabel label_2 = new JLabel("\u7528\u6237\u540D");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		tfname = new JTextField();
		tfname.setColumns(10);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		sclass = new JTextField();
		sclass.setColumns(10);
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7\uFF1A");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(label_3)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(sclass, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_2)
							.addGap(78))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(284))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(tfname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_2)
								.addComponent(sclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(label_3)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//选中表格的某一行(没选中的表格任一行 ,row=-1)
				int row = table.getSelectedRow();
				//获取某行某列的数值： getvalueAt(row,conlums);
				textField.setText((table.getValueAt(row, 0).toString()));
				tfname.setText((String)table.getValueAt(row, 1));
				sclass.setText((String)table.getValueAt(row, 2));
			}
		});
		
		List<User> listUser= ad.findAll();//获取list集合
		Object[][] objArray=new Object[listUser.size()][3];
		//将listUser集合中的每个对象赋值给二维数组的每一行
		for(int i=0;i<listUser.size();i++){
			User user =listUser.get(i);
			objArray[i][0] = user.getId();
			objArray[i][1] = user.getUname();
			objArray[i][2] = user.getSclass();
		}
		
		//将数据填充到表格去
		table.setModel(new DefaultTableModel(
				objArray,
			new String[] {
				"序号", "用户名","班级"
			}
		));
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
		this.setLocationRelativeTo(null);
		
	}
}
