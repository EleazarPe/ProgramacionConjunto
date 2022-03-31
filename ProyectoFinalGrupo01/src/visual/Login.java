package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Login extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/cruz-roja.png")));
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 139));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 0)));
			panel_1.setBackground(new Color(30, 144, 255));
			panel_1.setBounds(89, 49, 244, 270);
			panel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Bienvenido/a\r\n");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setBounds(50, 13, 144, 34);
				panel_1.add(lblNewLabel);
			}
			
			JTextField txtUsuario = new JTextField();
			txtUsuario.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtUsuario.setText("");
				}
			});
			txtUsuario.setText("Usuario");
			txtUsuario.setBounds(50, 79, 144, 34);
			panel_1.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setToolTipText("Contrase\u00F1a");
			passwordField.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					passwordField.setText("");
				}
			});
			passwordField.setBounds(50, 129, 144, 34);
			panel_1.add(passwordField);
			
			JButton btnNewButton = new JButton("Login");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNewButton.setBounds(66, 176, 113, 51);
			panel_1.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
