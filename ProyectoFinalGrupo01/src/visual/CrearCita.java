package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField txtNotas;
	private JSpinner spnFechaNacimiento;
	private Random rand = new Random();
	private JComboBox<Object> cbxTipoDocumento;
	private JTextField txtID;

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
		setBounds(100, 100, 666, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 630, 301);
		panel.setBorder(new TitledBorder(null, "Datos del Paciente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setBounds(31, 191, 70, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setBounds(31, 227, 70, 25);
		panel.add(lblNewLabel_1);
		
		JButton button = new JButton("Buscar    ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario paciente;
				paciente = Clinica.getInstance().buscarUsuarioByCedula(txtNid.getText());
				
				if(paciente == null) {
					JOptionPane.showMessageDialog(null, "No Existen Pacientes Registrados Con Esta Identificacion",
							"PACIENTE NO ENCONTRADO",JOptionPane.ERROR_MESSAGE);
				
					ActivationKey(true);
				}else {
					txtNid.setText(paciente.getID());
					txtNombre.setText(paciente.getNombre());
					txtCelular.setText(paciente.getTelefono());
					txtTelefonoOpc.setText(paciente.getDireccion());
				}
			}
		});
		button.setIcon(new ImageIcon(CrearCita.class.getResource("/img/lupa.png")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBounds(471, 45, 132, 34);
		panel.add(button);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(93, 190, 155, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(93, 227, 155, 25);
		panel.add(txtApellido);
		
		JLabel lblDocIdentidad = new JLabel(" Documento Identidad:");
		lblDocIdentidad.setBounds(31, 117, 130, 25);
		panel.add(lblDocIdentidad);
		
		cbxTipoDocumento = new JComboBox<Object>();
		cbxTipoDocumento.setModel(new DefaultComboBoxModel<Object>(new String[] {"Cedula", "Pasaporte", "Licencia"}));
		cbxTipoDocumento.setBounds(165, 117, 110, 25);
		panel.add(cbxTipoDocumento);
		
		JLabel lblNewLabel_3 = new JLabel("NO.");
		lblNewLabel_3.setBounds(303, 117, 34, 25);
		panel.add(lblNewLabel_3);
		
		txtNid = new JTextField();
		txtNid.setBounds(340, 117, 110, 25);
		panel.add(txtNid);
		txtNid.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_4.setBounds(31, 153, 130, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(291, 190, 46, 25);
		panel.add(lblCelular);
		
		JLabel lblTelefonoOpcional = new JLabel("Telefono:");
		lblTelefonoOpcional.setBounds(284, 227, 53, 25);
		panel.add(lblTelefonoOpcional);
		
		txtCelular = new JTextField();
		txtCelular.setEditable(false);
		txtCelular.setBounds(340, 191, 110, 25);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtTelefonoOpc = new JTextField();
		txtTelefonoOpc.setEditable(false);
		txtTelefonoOpc.setBounds(340, 228, 110, 25);
		panel.add(txtTelefonoOpc);
		txtTelefonoOpc.setColumns(10);
		
		JLabel lblC = new JLabel("E-mail:");
		lblC.setBounds(31, 264, 70, 25);
		panel.add(lblC);
		
		TxtCorreo = new JTextField();
		TxtCorreo.setEditable(false);
		TxtCorreo.setColumns(10);
		TxtCorreo.setBounds(93, 265, 155, 22);
		panel.add(TxtCorreo);
		
		JLabel signoAviso = new JLabel("");
		signoAviso.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		signoAviso.setBounds(10, 117, 16, 25);
		panel.add(signoAviso);
		
		JLabel signoAviso1 = new JLabel("");
		signoAviso1.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		signoAviso1.setBounds(271, 190, 16, 25);
		panel.add(signoAviso1);
		
		JLabel signoAviso2 = new JLabel("");
		signoAviso2.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		signoAviso2.setBounds(10, 191, 16, 25);
		panel.add(signoAviso2);
		
		JLabel signoAviso3 = new JLabel("");
		signoAviso3.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		signoAviso3.setBounds(10, 227, 16, 25);
		panel.add(signoAviso3);
		
		JLabel signoAviso4 = new JLabel("");
		signoAviso4.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		signoAviso4.setBounds(10, 265, 16, 25);
		panel.add(signoAviso4);
		
		spnFechaNacimiento = new JSpinner();
		spnFechaNacimiento.setEnabled(false);
		spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(1648008000000L), new Date(1648008000000L), null, Calendar.DAY_OF_YEAR));
		spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento,"dd/MM/yyyy"));
		spnFechaNacimiento.setBounds(165, 155, 110, 25);
		panel.add(spnFechaNacimiento);
		
		JLabel signoAviso5 = new JLabel("");
		signoAviso5.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
		signoAviso5.setBounds(10, 153, 16, 25);
		panel.add(signoAviso5);
		
		JLabel signoAviso6 = new JLabel("");
		signoAviso6.setIcon(new ImageIcon(CrearCita.class.getResource("/img/prescripcion-medica.png")));
		signoAviso6.setBounds(27, 23, 86, 72);
		panel.add(signoAviso6);
		
		JLabel lblNewLabel_6 = new JLabel("ID:");
		lblNewLabel_6.setBounds(303, 263, 34, 25);
		panel.add(lblNewLabel_6);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setText("Pac-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
		txtID.setBounds(340, 266, 110, 25);
		panel.add(txtID);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 573, 650, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(442, 7, 85, 23);
		button_1.setActionCommand("Cancel");
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Registrar");
		button_2.setBounds(537, 7, 96, 23);
		button_2.setActionCommand("OK");
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de la Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 375, 630, 184);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Especialidad:");
		lblNewLabel_5.setBounds(10, 42, 84, 25);
		panel_2.add(lblNewLabel_5);
		
		JComboBox<Object> cbxEspecialidad = new JComboBox<Object>();
		cbxEspecialidad.setModel(new DefaultComboBoxModel<Object>(new String[] {"<<SELECCIONE>>", "Ginecologo", "Cardiologo", "Gastroenterologo", "Oculista"}));
		cbxEspecialidad.setBounds(90, 42, 147, 25);
		panel_2.add(cbxEspecialidad);
		
		JSpinner spnFechaCita = new JSpinner();
		spnFechaCita.setModel(new SpinnerDateModel(new Date(1648267200000L), new Date(1648267200000L), null, Calendar.DAY_OF_YEAR));
		spnFechaCita.setEditor(new JSpinner.DateEditor(spnFechaCita,"dd/MM/yyyy"));
		spnFechaCita.setBounds(90, 118, 110, 25);
		panel_2.add(spnFechaCita);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha Cita:");
		lblNewLabel_7.setBounds(10, 118, 84, 25);
		panel_2.add(lblNewLabel_7);
		
		txtNotas = new JTextField();
		txtNotas.setBounds(324, 54, 283, 108);
		panel_2.add(txtNotas);
		txtNotas.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Notas:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(324, 18, 70, 25);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor:");
		lblNewLabel_2.setBounds(10, 78, 46, 25);
		panel_2.add(lblNewLabel_2);
		
		JComboBox<Object> cbxDoctor = new JComboBox<Object>();
		cbxDoctor.setEnabled(false);
		cbxDoctor.setBounds(90, 78, 147, 25);
		panel_2.add(cbxDoctor);
		
		JLabel lblNewLabel_9 = new JLabel("AVISO: LOS CAMPOS MARCADOS      SON NECESARIOS PARA PROCESAR CORRETACTAMENTE SU SOLICITUD");
		lblNewLabel_9.setBounds(30, 339, 598, 25);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel signoAviso7 = new JLabel("");
		signoAviso7.setBounds(214, 339, 16, 25);
		contentPane.add(signoAviso7);
		signoAviso7.setIcon(new ImageIcon(CrearCita.class.getResource("/img/signo-advertencia.png")));
	}
	
	public void ActivationKey(boolean value) {
		txtNombre.setEditable(true);
		txtApellido.setEditable(true);
		spnFechaNacimiento.setEnabled(true);
		txtCelular.setEditable(true);
		txtTelefonoOpc.setEditable(true);
		TxtCorreo.setEditable(true);
	}
	
	private void clean() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtNid.setText("");
		txtCelular.setText("");
		cbxTipoDocumento.setSelectedIndex(0);
		txtTelefonoOpc.setText("");
		spnFechaNacimiento.setValue(new Date());
		TxtCorreo.setText("");
		txtNotas.setText("");
		txtID.setText("Pac-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
		

	}
}
