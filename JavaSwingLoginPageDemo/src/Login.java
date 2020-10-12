import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Component;

public class Login {

	private JFrame LoginPage;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.LoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	// Call the connection
	Connection connection = null;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();

		connection = sqliteConnection.dbConnector();

	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		//User Name
		LoginPage = new JFrame();
		LoginPage.setTitle("Login Page");
		LoginPage.setBackground(Color.WHITE);
		LoginPage.setFont(new Font("Dialog", Font.BOLD, 14));
		LoginPage.setBounds(100, 100, 450, 300);
		LoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginPage.getContentPane().setLayout(null);
				
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(163, 51, 77, 31);
		LoginPage.getContentPane().add(lblNewLabel);
		
		userNameField = new JTextField();
		userNameField.setBounds(233, 52, 138, 31);
		LoginPage.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		
		
		//Password
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(163, 86, 60, 23);
		LoginPage.getContentPane().add(lblNewLabel_1);
		
		//Add Login button image
		JButton btnLogin = new JButton("Login");
		Image img1=new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img1));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				try {
					
					// Query to select username and password 
					String query="select * from Employees where UserName=? and Password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,userNameField.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs=pst.executeQuery(); //create a ResultSet Object for the database
					
					
					int count = 0;
					while (rs.next()) { // While loop,loops through the database
						count++;

					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "UserName and Password is correct");
						
					}else if (count>1) {
						JOptionPane.showMessageDialog(null, " Username and Password already exist"); // This is to prevent duplicate username and password
						
											
					}else {
						JOptionPane.showMessageDialog(null, "Username and Password is NOT correct");
						
					}
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				
								
			}
				// Set Title of Login Page
				LoginPage.setTitle("Login Page");
			}
			
				
		});
		
		//Add Login Button
		btnLogin.setBounds(233, 118, 138, 31);
		LoginPage.getContentPane().add(btnLogin);
		
		//Create Password Field
		passwordField = new JPasswordField();
		passwordField.setBounds(233, 87, 138, 20);
		LoginPage.getContentPane().add(passwordField);
		
		//Add Login image
		JLabel lblNewLabel_2 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(10, 20, 143, 161);
		LoginPage.getContentPane().add(lblNewLabel_2);
	}
}
