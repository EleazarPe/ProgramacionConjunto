package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CrearCita extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCita frame = new CrearCita();
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
	public CrearCita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 463);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 710, 393);
		panel.setBorder(new TitledBorder(null, "Datos del Paciente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setBounds(22, 163, 70, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setBounds(367, 163, 70, 25);
		panel.add(lblNewLabel_1);
		
		JButton button = new JButton("Buscar    ");
		button.setIcon(new ImageIcon(CrearCita.class.getResource("/img/lupa.png")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBounds(510, 32, 132, 34);
		panel.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("Menor de Edad:");
		lblNewLabel_2.setBounds(12, 201, 104, 25);
		panel.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("SI");
		rdbtnNewRadioButton.setBounds(124, 201, 48, 25);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setSelected(true);
		rdbtnNo.setBounds(176, 201, 48, 25);
		panel.add(rdbtnNo);
		
		textField = new JTextField();
		textField.setBounds(94, 163, 258, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(440, 163, 258, 25);
		panel.add(textField_1);
		
		JLabel lblDocIdentidad = new JLabel("Doc. Identidad:");
		lblDocIdentidad.setBounds(23, 54, 93, 25);
		panel.add(lblDocIdentidad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cedula", "Pasaporte", "Licencia"}));
		comboBox.setBounds(117, 54, 147, 25);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("NO.");
		lblNewLabel_3.setBounds(276, 54, 34, 25);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(307, 55, 130, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_4.setBounds(12, 125, 130, 25);
		panel.add(lblNewLabel_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 30, 1));
		spinner.setBounds(145, 126, 58, 22);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		spinner_1.setBounds(221, 126, 58, 22);
		panel.add(spinner_1);
		
		JLabel lblNewLabel_5 = new JLabel("Dia:");
		lblNewLabel_5.setBounds(147, 105, 56, 25);
		panel.add(lblNewLabel_5);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(223, 105, 56, 25);
		panel.add(lblMes);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(22, 239, 104, 25);
		panel.add(lblCelular);
		
		JLabel lblTelefonoOpcional = new JLabel("Telf. Opcional:");
		lblTelefonoOpcional.setBounds(240, 240, 104, 25);
		panel.add(lblTelefonoOpcional);
		
		textField_3 = new JTextField();
		textField_3.setBounds(89, 241, 135, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(330, 241, 132, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblC = new JLabel("Correo Electronico:");
		lblC.setBounds(22, 279, 118, 25);
		panel.add(lblC);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(134, 279, 155, 22);
		panel.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(CrearCita.class.getResource("/img/5097348 (2).png")));
		lblNewLabel_6.setBounds(12, 54, 16, 25);
		panel.add(lblNewLabel_6);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CrearCita.class.getResource("/img/5097348 (2).png")));
		label.setBounds(355, 163, 16, 25);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CrearCita.class.getResource("/img/5097348 (2).png")));
		label_1.setBounds(12, 163, 16, 25);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CrearCita.class.getResource("/img/5097348 (2).png")));
		label_2.setBounds(12, 239, 16, 25);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(CrearCita.class.getResource("/img/5097348 (2).png")));
		label_3.setBounds(12, 279, 16, 25);
		panel.add(label_3);
	}
}
