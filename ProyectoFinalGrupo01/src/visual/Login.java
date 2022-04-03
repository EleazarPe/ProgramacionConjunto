package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField pwdContrasea;
	private JTextField txtUsuario;

	
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
		setUndecorated(true);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 139));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 0)));
			panel_1.setBackground(new Color(30, 144, 255));
			panel_1.setBounds(10, 11, 420, 418);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtUsuario = new JTextField();
			txtUsuario.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtUsuario.getText().equals("Usuario")) {
						txtUsuario.setText("");
					}
					else {
						txtUsuario.selectAll();
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtUsuario.getText().equals(""))
						txtUsuario.setText("Usuario");
				}
			});
			txtUsuario.setText("Usuario");
			
			txtUsuario.setToolTipText("");
			txtUsuario.addMouseListener(new MouseAdapter() {
			

			});
			txtUsuario.setBounds(121, 133, 150, 34);
			panel_1.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			pwdContrasea = new JPasswordField();
			pwdContrasea.addFocusListener(new FocusAdapter() {
				@SuppressWarnings("deprecation")
				@Override
				public void focusGained(FocusEvent e) {
					if(pwdContrasea.getText().equals("contraseña")) {
						pwdContrasea.setEchoChar('●');
						pwdContrasea.setText("");	
					}
					else {
						pwdContrasea.selectAll();
					}
				}
				@SuppressWarnings("deprecation")
				@Override
				public void focusLost(FocusEvent e) {
					if(pwdContrasea.getText().equals(""))
						pwdContrasea.setText("Contraseña");
						pwdContrasea.setEchoChar((char)0);
				}
			});
			pwdContrasea.setText("Contrase\u00F1a");
			pwdContrasea.setToolTipText("");
			pwdContrasea.setEchoChar((char)0);
			pwdContrasea.addMouseListener(new MouseAdapter() {
				

			});
			pwdContrasea.setBounds(121, 181, 150, 34);
			panel_1.add(pwdContrasea);
			
			JButton btnNewButton = new JButton("Login");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNewButton.setBounds(142, 236, 113, 34);
			panel_1.add(btnNewButton);
			
			JLabel LblSalir = new JLabel("X");
			LblSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea cerrar el programa?", "Confirmacion",
							JOptionPane.YES_NO_OPTION)== 0);{
						Login.this.dispose();
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					LblSalir.setForeground(Color.red);
				}
				public void mouseExited(MouseEvent e) {
					LblSalir.setForeground(Color.white);
				}
			});
			LblSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
			LblSalir.setBounds(395, 11, 25, 14);
			panel_1.add(LblSalir);
		}
	}
}
