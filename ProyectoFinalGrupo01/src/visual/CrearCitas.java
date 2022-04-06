package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cita;
import logico.Clinica;
import logico.Paciente;
import logico.Usuario;


public class CrearCitas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCelular;
	private JTextField txtTelefonoOpc;
	private JTextField txtNid;
	private JSpinner spnFechaNacimiento;
	private Random rand = new Random();
	private JComboBox<Object> cbxTipoDocumento;
	private JTextField txtIDPaciente;
	private JTextPane TextNotas;
	private Paciente paciente = null;
	private JTextField txtDireccion;
	private JComboBox<Object> cbxTipoBlood;
	private JComboBox<Object> cbxOcupacion;
	private JComboBox<Object> cbxRh;
	private JComboBox<Object> cbxDoctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCitas dialog = new CrearCitas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCitas() {
		setModal(true);		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearCitas.class.getResource("/img/cruz-roja.png")));
		setTitle("Registro De Citas");
		setBounds(100, 100, 666, 730);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 630, 370);
		panel.setBorder(new TitledBorder(null, "Datos del Paciente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(31, 191, 70, 25);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(31, 227, 70, 25);
		panel.add(lblApellido);
		
		JButton button = new JButton("Buscar    ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				paciente = Clinica.getInstance().buscarPacienteById(txtNid.getText());
				
				
				
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
		button.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/lupa.png")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBounds(488, 112, 132, 34);
		panel.add(button);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {                                    
			    int key = evt.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))
			    {
			        evt.consume();
			    }
			}     
		});
		txtNombre.setEditable(false);
		txtNombre.setBounds(98, 191, 155, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {                                    
			    int key = evt.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))
			    {
			        evt.consume();
			    }
			}     
		});
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(98, 227, 155, 25);
		panel.add(txtApellido);
		
		JLabel lblDocIdentidad = new JLabel(" Documento Identidad:");
		lblDocIdentidad.setBounds(31, 117, 130, 25);
		panel.add(lblDocIdentidad);
		
		cbxTipoDocumento = new JComboBox<Object>();
		cbxTipoDocumento.setModel(new DefaultComboBoxModel<Object>(new String[] {"Cedula", "Pasaporte", "Licencia"}));
		cbxTipoDocumento.setBounds(165, 117, 110, 25);
		panel.add(cbxTipoDocumento);
		
		JLabel lblNoIdenticacion = new JLabel("NO.");
		lblNoIdenticacion.setBounds(303, 117, 34, 25);
		panel.add(lblNoIdenticacion);
		
		txtNid = new JTextField();
		txtNid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				int key = evt.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			        evt.consume();
			    }

			    if (txtNid.getText().trim().length() == 10) {
			        evt.consume();
			    }
			}
		});
		txtNid.setBounds(340, 117, 110, 25);
		panel.add(txtNid);
		txtNid.setColumns(10);
		
		JLabel LblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		LblFechaNacimiento.setBounds(31, 153, 130, 25);
		panel.add(LblFechaNacimiento);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(291, 190, 46, 25);
		panel.add(lblCelular);
		
		JLabel lblTelefonoOpcional = new JLabel("Telefono:");
		lblTelefonoOpcional.setBounds(284, 227, 53, 25);
		panel.add(lblTelefonoOpcional);
		
		txtCelular = new JTextField();
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				int key = evt.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			        evt.consume();
			    }

			    if (txtCelular.getText().trim().length() == 10) {
			        evt.consume();
			    }
			}
		});
		txtCelular.setEditable(false);
		txtCelular.setBounds(347, 191, 110, 25);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtTelefonoOpc = new JTextField();
		txtTelefonoOpc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				int key = evt.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			        evt.consume();
			    }

			    if (txtNid.getText().trim().length() == 10) {
			        evt.consume();
			    }
			}
		});
		txtTelefonoOpc.setEditable(false);
		txtTelefonoOpc.setBounds(347, 228, 110, 25);
		panel.add(txtTelefonoOpc);
		txtTelefonoOpc.setColumns(10);
		
		JLabel signoAviso = new JLabel("");
		signoAviso.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAviso.setBounds(10, 117, 16, 25);
		panel.add(signoAviso);
		
		JLabel signoAviso1 = new JLabel("");
		signoAviso1.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAviso1.setBounds(271, 190, 16, 25);
		panel.add(signoAviso1);
		
		JLabel signoAviso2 = new JLabel("");
		signoAviso2.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAviso2.setBounds(10, 191, 16, 25);
		panel.add(signoAviso2);
		
		JLabel signoAviso3 = new JLabel("");
		signoAviso3.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAviso3.setBounds(10, 227, 16, 25);
		panel.add(signoAviso3);
		
		JLabel signoAviso4 = new JLabel("");
		signoAviso4.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAviso4.setBounds(271, 227, 16, 25);
		panel.add(signoAviso4);
		
		spnFechaNacimiento = new JSpinner();
		spnFechaNacimiento.setEnabled(false);
		spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(1648008000000L), new Date(1648008000000L), null, Calendar.DAY_OF_YEAR));
		spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento,"dd/MM/yyyy"));
		spnFechaNacimiento.setValue(new Date());
		spnFechaNacimiento.setBounds(165, 155, 110, 25);
		panel.add(spnFechaNacimiento);
		
		JLabel signoAviso5 = new JLabel("");
		signoAviso5.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAviso5.setBounds(10, 153, 16, 25);
		panel.add(signoAviso5);
		
		JLabel signoAviso6 = new JLabel("");
		signoAviso6.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/prescripcion-medica.png")));
		signoAviso6.setBounds(27, 23, 86, 72);
		panel.add(signoAviso6);
		
		JLabel lblIdPaciente = new JLabel("ID:");
		lblIdPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdPaciente.setBounds(488, 30, 23, 25);
		panel.add(lblIdPaciente);
		
		txtIDPaciente = new JTextField();
		txtIDPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIDPaciente.setEditable(false);
		txtIDPaciente.setColumns(10);
		txtIDPaciente.setText("Pac-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
		txtIDPaciente.setBounds(510, 30, 93, 25);
		panel.add(txtIDPaciente);
		
		JLabel lblOcupacion = new JLabel("Ocupacion:");
		lblOcupacion.setBounds(31, 263, 70, 25);
		panel.add(lblOcupacion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		label.setBounds(10, 263, 16, 25);
		panel.add(label);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(347, 262, 110, 25);
		panel.add(txtDireccion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(284, 263, 70, 25);
		panel.add(lblDireccion);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		label_1.setBounds(271, 263, 16, 25);
		panel.add(label_1);
		
		cbxOcupacion = new JComboBox<Object>();
		cbxOcupacion.setEnabled(false);
		cbxOcupacion.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccionar>", "Profesor", "Abogado", "Ingeniero", "Medico", "Empleado Privado", "Empleado Publico", "Independiente"}));
		cbxOcupacion.setBounds(98, 263, 155, 25);
		panel.add(cbxOcupacion);
		
		JLabel label_2 = new JLabel("Tipo de Sangre:");
		label_2.setBounds(93, 310, 94, 25);
		panel.add(label_2);
		
		cbxTipoBlood = new JComboBox<Object>();
		cbxTipoBlood.setEnabled(false);
		cbxTipoBlood.setModel(new DefaultComboBoxModel<Object>(new String[] {"A", "B", "AB", "O"}));
		cbxTipoBlood.setBounds(198, 310, 55, 25);
		panel.add(cbxTipoBlood);
		
		JLabel label_3 = new JLabel("RH:");
		label_3.setBounds(284, 310, 33, 25);
		panel.add(label_3);
		
		cbxRh = new JComboBox<Object>();
		cbxRh.setEnabled(false);
		cbxRh.setModel(new DefaultComboBoxModel<Object>(new String[] {"Positivo", "Negativo", "Nulo"}));
		cbxRh.setBounds(347, 310, 77, 25);
		panel.add(cbxRh);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		label_4.setBounds(271, 310, 16, 25);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		label_5.setBounds(76, 310, 16, 25);
		panel.add(label_5);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(paciente == null) {
							Paciente auxPaciente = null;
							Cita auxCita = null;
							auxPaciente = new Paciente(txtNombre.getText(), txtApellido.getText(), txtNid.getText(), (Date)spnFechaNacimiento.getValue(), cbxOcupacion.getSelectedItem().toString(), txtCelular.getText(), txtDireccion.getText(), txtIDPaciente.getText(), cbxTipoBlood.getSelectedItem().toString(), txtTelefonoOpc.getText());
							auxCita = new Cita((Date)spnFechaNacimiento.getValue(), txtIDPaciente.getText(), TextNotas.getText()," ", " ");
							Clinica.getInstance().insertarUsuario(auxPaciente);
							auxPaciente.insertarCita(auxCita);
						}else {
							Cita auxCita = null;
							auxCita = new Cita((Date)spnFechaNacimiento.getValue(), txtIDPaciente.getText(), TextNotas.getText()," ", " ");
							paciente.insertarCita(auxCita);
						}
					}
				});
				btnRegistrar.setActionCommand("Cancel");
				buttonPane.add(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
		}
		

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de la Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 458, 630, 184);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Especialista:");
		lblNewLabel_5.setBounds(10, 42, 84, 25);
		panel_2.add(lblNewLabel_5);
		
		JComboBox<Object> cbxEspecialidad = new JComboBox<Object>();
		cbxEspecialidad.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccionar>", "Cirug\u00EDa", "Pediatr\u00EDa", "M\u00E9dicina Interna", "Psiquiatr\u00EDa", "Oftalmolog\u00EDa", "Cardiolog\u00EDa", "Neumolog\u00EDa", "Dermatolog\u00EDa", "Nefrolog\u00EDa", "Neurolog\u00EDa", "Radiolog\u00EDa", "Anestesiolog\u00EDa", "Urolog\u00EDa", "Gastroenterolog\u00EDa", "Gineco obstetricia"}));
		cbxEspecialidad.setBounds(90, 42, 147, 25);
		panel_2.add(cbxEspecialidad);
		
		JSpinner spnFechaCita = new JSpinner();
		spnFechaCita.setModel(new SpinnerDateModel(new Date(1648267200000L), new Date(1648267200000L), null, Calendar.DAY_OF_YEAR));
		spnFechaCita.setEditor(new JSpinner.DateEditor(spnFechaCita,"dd/MM/yyyy"));
		spnFechaCita.setValue(new Date());
		spnFechaCita.setBounds(90, 118, 110, 25);
		panel_2.add(spnFechaCita);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha Cita:");
		lblNewLabel_7.setBounds(10, 118, 84, 25);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Notas:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(324, 18, 70, 25);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor:");
		lblNewLabel_2.setBounds(10, 78, 46, 25);
		panel_2.add(lblNewLabel_2);
		
		cbxDoctor = new JComboBox<Object>();
		listarmedicosByEspecialidad(cbxEspecialidad.getSelectedItem().toString());
		cbxDoctor.setEnabled(false);
		cbxDoctor.setBounds(90, 78, 147, 25);
		panel_2.add(cbxDoctor);
		
		TextNotas = new JTextPane();
		TextNotas.setBounds(324, 42, 283, 108);
		panel_2.add(TextNotas);
		
		JLabel lblNewLabel_9 = new JLabel("AVISO: LOS CAMPOS MARCADOS      SON NECESARIOS PARA PROCESAR CORRETACTAMENTE SU SOLICITUD");
		lblNewLabel_9.setBounds(32, 422, 598, 25);
		contentPanel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel signoAviso7 = new JLabel("");
		signoAviso7.setBounds(216, 422, 16, 25);
		contentPanel.add(signoAviso7);
		signoAviso7.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
	}
	
	private void listarmedicosByEspecialidad(String strespecialidad) {
		cbxDoctor.setEnabled(true);
		for (Usuario medico : Clinica.getInstance().buscarmedicosByEspecialiad(strespecialidad)) {
			cbxDoctor.addItem(medico.getNombre());
		}
		
	}

	public void ActivationKey(boolean value) {
		txtNombre.setEditable(true);
		txtApellido.setEditable(true);
		spnFechaNacimiento.setEnabled(true);
		txtCelular.setEditable(true);
		txtTelefonoOpc.setEditable(true);
		txtDireccion.setEditable(true);
		cbxOcupacion.setEnabled(true);
		cbxTipoBlood.setEnabled(true);
		cbxRh.setEnabled(true);
	}
	}

