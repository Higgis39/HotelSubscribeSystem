package presentation.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class mainView{
	public mainView(){
		JFrame loginFrame = new JFrame("互联网酒店预订系统");
		loginFrame.setLayout(null);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(900, 600);
		loginFrame.setLocation(250, 80);
		loginFrame.setVisible(true);
		
		JLabel welcome = new JLabel("互联网酒店预订系统",JLabel.CENTER);
		welcome.setSize(400, 150);
		welcome.setLocation(250, 0);
		welcome.setFont(new Font("Serif",Font.BOLD,40));
		loginFrame.getContentPane().add(welcome);
		
		JLabel login = new JLabel("登录",JLabel.CENTER);
		login.setSize(100,50);
		login.setLocation(500, 150);
		login.setFont(new Font("Serif",Font.BOLD,20));
		loginFrame.getContentPane().add(login);
		
		JLabel userType = new JLabel("用户类型:",JLabel.CENTER);
		userType.setSize(100,50);
		userType.setLocation(450,230);
		userType.setFont(new Font("Serif",Font.BOLD,14));
		loginFrame.getContentPane().add(userType);
		
		JLabel id = new JLabel("账号:",JLabel.CENTER);
		id.setSize(100,50);
		id.setLocation(450, 300);
		id.setFont(new Font("Serif",Font.BOLD,14));
		loginFrame.getContentPane().add(id);
		
		JLabel password = new JLabel("密码:",JLabel.CENTER);
		password.setSize(100,50);
		password.setLocation(450,370);
		password.setFont(new Font("Serif",Font.BOLD,14));
		loginFrame.getContentPane().add(password);
		
		String[] user = {"普通客户","酒店工作人员","网站营销人员","网站管理人员"};
		JComboBox type = new JComboBox(user);
		type.setSelectedItem(0);
		type.setSize(200,30);
		type.setLocation(550,240);
		loginFrame.getContentPane().add(type);
		
		JTextArea enterid = new JTextArea();
		enterid.setSize(200, 30);
		enterid.setLocation(550,310);
		loginFrame.getContentPane().add(enterid);
		
		JPasswordField enterpass = new JPasswordField();
		enterpass.setSize(200,30);
		enterpass.setLocation(550, 380);
		loginFrame.getContentPane().add(enterpass);
		
		JButton confirm = new JButton("确定");
		confirm.setSize(100, 30);
		confirm.setLocation(600, 450);
		confirm.setFont(new Font("Serif",Font.BOLD,12));
		loginFrame.getContentPane().add(confirm);
	}
}
