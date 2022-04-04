package visual;

import java.awt.BorderLayout;
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
		setBounds(100, 100, 600, 450);
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
			panel_1.setBounds(10, 11, 570, 418);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel LblSalir = new JLabel("X");
			LblSalir.setForeground(new Color(255, 255, 255));
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
			LblSalir.setBounds(535, 11, 25, 14);
			panel_1.add(LblSalir);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(175, 116, 200, 40);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(0, 0, 150, 40);
			panel_2.add(txtUsuario);
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
			txtUsuario.setColumns(10);
			
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBounds(175, 185, 200, 40);
			panel_1.add(panel_3);
			
			pwdContrasea = new JPasswordField();
			pwdContrasea.setBounds(0, 0, 150, 40);
			panel_3.add(pwdContrasea);
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
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(196, 252, 159, 31);
			panel_1.add(panel_4);
			
			JLabel lblNewLabel = new JLabel("Iniciar Sesion");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panel_4.add(lblNewLabel);
			pwdContrasea.addMouseListener(new MouseAdapter() {
				

			});
		}
	}
}
