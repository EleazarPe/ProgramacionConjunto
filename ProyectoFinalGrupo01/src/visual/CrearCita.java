package visual;

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
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Toolkit;

public class CrearCita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCelular;
	private JTextField txtTelefonoOpc;
	private JTextField TxtCorreo;
	private JTextField txtNid;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnNewRadioButton;
	private JTextField textField;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearCita.class.getResource("/img/cruz-roja.png")));
		setTitle("Registro De Citas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 675);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 707, 354);
		panel.setBorder(new TitledBorder(null, "Datos del Paciente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setBounds(31, 191, 70, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setBounds(376, 191, 70, 25);
		panel.add(lblNewLabel_1);
		
		JButton button = new JButton("Buscar    ");
		button.setIcon(new ImageIcon(CrearCita.class.getResource("/img/lupa.png")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBounds(508, 84, 132, 34);
		panel.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("Menor de Edad:");
		lblNewLabel_2.setBounds(31, 227, 104, 25);
		panel.add(lblNewLabel_2);
		
		rdbtnNewRadioButton = new JRadioButton("SI");
		rdbtnNewRadioButton.setBounds(136, 227, 48, 25);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setSelected(true);
		rdbtnNo.setBounds(185, 227, 48, 25);
		panel.add(rdbtnNo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 191, 258, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(438, 191, 258, 25);
		panel.add(txtApellido);
		
		JLabel lblDocIdentidad = new JLabel("Doc. Identidad:");
		lblDocIdentidad.setBounds(31, 117, 93, 25);
		panel.add(lblDocIdentidad);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Cedula", "Pasaporte", "Licencia"}));
		comboBox.setBounds(120, 116, 147, 25);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("NO.");
		lblNewLabel_3.setBounds(279, 116, 34, 25);
		panel.add(lblNewLabel_3);
		
		txtNid = new JTextField();
		txtNid.setBounds(310, 117, 130, 25);
		panel.add(txtNid);
		txtNid.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_4.setBounds(31, 153, 130, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(31, 268, 104, 25);
		panel.add(lblCelular);
		
		JLabel lblTelefonoOpcional = new JLabel("Telf. Opcional:");
		lblTelefonoOpcional.setBounds(238, 268, 104, 25);
		panel.add(lblTelefonoOpcional);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(87, 269, 135, 22);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtTelefonoOpc = new JTextField();
		txtTelefonoOpc.setBounds(328, 269, 132, 22);
		panel.add(txtTelefonoOpc);
		txtTelefonoOpc.setColumns(10);
		
		JLabel lblC = new JLabel("Correo Electronico:");
		lblC.setBounds(31, 306, 104, 25);
		panel.add(lblC);
		
		TxtCorreo = new JTextField();
		TxtCorreo.setColumns(10);
		TxtCorreo.setBounds(153, 307, 155, 22);
		panel.add(TxtCorreo);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		lblNewLabel_6.setBounds(10, 117, 16, 25);
		panel.add(lblNewLabel_6);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		label.setBounds(353, 191, 16, 25);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		label_1.setBounds(10, 191, 16, 25);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		label_2.setBounds(10, 267, 16, 25);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		label_3.setBounds(10, 307, 16, 25);
		panel.add(label_3);
		
		JSpinner spnFechaNacimiento = new JSpinner();
		spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(1648008000000L), new Date(1648008000000L), null, Calendar.DAY_OF_YEAR));
		spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento,"dd/MM/yyyy"));
		spnFechaNacimiento.setBounds(165, 155, 137, 25);
		panel.add(spnFechaNacimiento);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		label_4.setBounds(10, 153, 16, 25);
		panel.add(label_4);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(CrearCita.class.getResource("/img/prescripcion-medica.png")));
		label_6.setBounds(27, 23, 86, 72);
		panel.add(label_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 598, 729, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(527, 7, 85, 23);
		button_1.setActionCommand("Cancel");
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Registrar");
		button_2.setBounds(622, 7, 96, 23);
		button_2.setActionCommand("OK");
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de la Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 403, 707, 184);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Especialidad:");
		lblNewLabel_5.setBounds(10, 54, 70, 25);
		panel_2.add(lblNewLabel_5);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"<<SELECCIONE>>", "Ginecologo", "Cardiologo", "Gastroenterologo", "Oculista"}));
		comboBox_1.setBounds(90, 54, 147, 25);
		panel_2.add(comboBox_1);
		
		JSpinner spnFechaCita = new JSpinner();
		spnFechaCita.setModel(new SpinnerDateModel(new Date(1648267200000L), new Date(1648267200000L), null, Calendar.DAY_OF_YEAR));
		spnFechaCita.setEditor(new JSpinner.DateEditor(spnFechaCita,"dd/MM/yyyy"));
		spnFechaCita.setBounds(104, 118, 137, 25);
		panel_2.add(spnFechaCita);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha Deseada:");
		lblNewLabel_7.setBounds(10, 118, 84, 25);
		panel_2.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(363, 54, 283, 108);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Notas:");
		lblNewLabel_8.setBounds(363, 23, 70, 25);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("IMPORTANTE: LOS CAMPOS MARCADOS      SON NECESARIOS PARA PROCESAR CORRETACTAMENTE SU SOLICITUD");
		lblNewLabel_9.setBounds(51, 377, 630, 25);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(271, 377, 16, 25);
		contentPane.add(label_5);
		label_5.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
	}
}
