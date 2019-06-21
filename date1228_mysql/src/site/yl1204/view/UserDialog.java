package site.yl1204.view;

import java.awt.BorderLayout;
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

public class UserDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	AdminDao ad = new AdminDao ();
	
	private JTextField textField;
	private JTextField tfname;
	private JTextField tfpsd;
	private JTextField classname;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			UserDialog dialog = new UserDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UserDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserDialog.class.getResource("/images/111.jpg")));
		setTitle("\u7528\u6237\u7BA1\u7406");
		setResizable(false);
		setBounds(100, 100, 471, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u7528\u6237\u7BA1\u7406");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.BOLD, 21));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(label)
					.addContainerGap(346, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u5E8F\u53F7:");
		
		JLabel label_2 = new JLabel("\u7528\u6237\u540D:");
		
		JLabel label_3 = new JLabel("\u5BC6\u7801:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		tfname = new JTextField();
		tfname.setColumns(10);
		
		tfpsd = new JTextField();
		tfpsd.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if(row==-1){
					JOptionPane.showMessageDialog(null, "请先选中要修改的行");
					return;
				}
				int tf = Integer.parseInt(textField.getText());
				String name = tfname.getText();
				String psd = tfpsd.getText();
				String claan = classname.getText();
				User upuser = new User(tf,name,psd,claan);
				int n = ad.updatePsd(upuser);
				if(n>0){
					JOptionPane.showMessageDialog(null, "更新成功");
				}else{
					JOptionPane.showMessageDialog(null, "更新失败");
				}
			}
		});
		
		JButton button_1 = new JButton("\u5220\u9664\u7528\u6237");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除用户
				deleteByIdActionPerform(e);
			}
		});
		
		JButton button_2 = new JButton("\u5237\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<User> listUser= ad.findAll();//获取list集合
				Object[][] objArray=new Object[listUser.size()][4];
				//将listUser集合中的每个对象赋值给二维数组的每一行
				for(int i=0;i<listUser.size();i++){
					User user =listUser.get(i);
					objArray[i][0] = user.getId();
					objArray[i][1] = user.getUname();
					objArray[i][2] = user.getUpassword();
					objArray[i][3] = user.getSclass();
				}
				
				//将数据填充到表格去
				table.setModel(new DefaultTableModel(
						objArray,
					new String[] {
						"序号", "用户名", "密码","班级"
					}
				));
				JOptionPane.showMessageDialog(null, "刷新成功");
			}
		});
		
		JLabel label_4 = new JLabel("\u73ED\u7EA7:");
		
		classname = new JTextField();
		classname.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(label_3)
						.addComponent(label_2)
						.addComponent(label_4))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfpsd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(classname, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(46)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(button)
										.addComponent(button_1)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(55)
									.addComponent(button_2))))
						.addComponent(tfname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addGap(21)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(tfpsd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(41)
							.addComponent(button_1)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(classname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(button_2))
					.addContainerGap(55, Short.MAX_VALUE))
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
				tfpsd.setText((String)table.getValueAt(row, 2));
				classname.setText((String)table.getValueAt(row, 3));
			}
		});
		
		List<User> listUser= ad.findAll();//获取list集合
		Object[][] objArray=new Object[listUser.size()][4];
		//将listUser集合中的每个对象赋值给二维数组的每一行
		for(int i=0;i<listUser.size();i++){
			User user =listUser.get(i);
			objArray[i][0] = user.getId();
			objArray[i][1] = user.getUname();
			objArray[i][2] = user.getUpassword();
			objArray[i][3] = user.getSclass();
		}
		
		//将数据填充到表格去
		table.setModel(new DefaultTableModel(
				objArray,
			new String[] {
				"序号", "用户名", "密码","班级"
			}
		));
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
		this.setLocationRelativeTo(null);
	}

	private void deleteByIdActionPerform(ActionEvent e) {
		int row = table.getSelectedRow();
		if(row==-1){
			JOptionPane.showMessageDialog(null, "请先选中要删除的行");
			return;
		}
		int id  = Integer.parseInt(textField.getText());
		String name = tfname.getText();
		String psd = tfpsd.getText();
		String claan = classname.getText();
		User deluser = new User(id,name,psd,claan);
		int n = JOptionPane.showConfirmDialog(null, "确定要删除吗");
		if(n==0){
			ad.deleteByName(deluser); 
			JOptionPane.showMessageDialog(null, "删除成功");
			textField.setText("");
			tfname.setText("");
			tfpsd.setText("");
			classname.setText("");
		}else{
			return ;
		}
		
	}
}
