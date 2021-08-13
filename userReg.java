import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class userReg extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JTextField idField, nameField,emailField,countryField,passwordField;
    private JButton btnNewButton;

    public static void main(String[] args) {
        userReg frame = new userReg();
        frame.setVisible(true);
    }

    public userReg() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("ID");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idField.setBounds(214, 151, 228, 50);
        contentPane.add(idField);
        idField.setColumns(10);

        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameField.setBounds(214, 235, 228, 50);
        contentPane.add(nameField);
        nameField.setColumns(10);

        emailField = new JTextField();

        emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailField.setBounds(214, 320, 228, 50);
        contentPane.add(emailField);
        emailField.setColumns(10);

        countryField = new JTextField();
        countryField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        countryField.setBounds(707, 151, 228, 50);
        contentPane.add(countryField);
        countryField.setColumns(10);

        JLabel lblUsername = new JLabel("Country");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id =Integer.parseInt(idField.getText()) ;
                String name = nameField.getText();
                String email = emailField.getText();
                String country = countryField.getText();
                String password = passwordField.getText();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?characterEncoding=latin1","root","Password123");
                    String str = "insert into users values(?,?,?,?,?)";
                    PreparedStatement ptst  =con.prepareStatement(str);

                    ptst.setInt(1,id );
                    ptst.setString(2,name);
                    ptst.setString(3,email);
                    ptst.setString(4,country);
                    ptst.setString(5,password);

                    int rows = ptst.executeUpdate();

                    if (rows == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Welcome,   "  +name +  " \n Your account is sucessfully created");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
