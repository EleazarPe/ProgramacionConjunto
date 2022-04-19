package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
/*import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;*/
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
/*import javax.swing.JFrame;
import javax.swing.WindowConstants;*/
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
	private JComboBox<Object> cbxEspecialidad;
	private JLabel LblAdvertencia;
	private JLabel signoAvisoDocId;
	private JLabel Mensaje;
	private JLabel signoAvisoTipoBlood;
	private JLabel signoAvisoOcupacion;
	private JLabel signoAvisoApellido;
	private JLabel signoAvisoNombre;
	private JLabel signoAvisoCelular;
	private JLabel signoAvisoTelefono;
	private JLabel SignoAvisoDirreccion;
	private JLabel SignoAvisoRH;
	private JLabel signoAviso7;
	private JSpinner spnFechaCita;

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
		setBounds(100, 100, 666, 719);
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
					txtApellido.setText(paciente.getApellido());
					txtCelular.setText(paciente.getTelefono());
					txtTelefonoOpc.setText(paciente.getTelefonoOpc());
					cbxOcupacion.setSelectedItem(paciente.getOcupacion());
					txtDireccion.setText(paciente.getDireccion());
					cbxTipoBlood.setSelectedItem(paciente.getTipoSangre());
					cbxRh.setSelectedItem(paciente.getRh());
					ActivationKey(true);
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

		JLabel lblTelefonoOpcional = new JLabel("Teléfono:");
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

		signoAvisoDocId = new JLabel("");
		signoAvisoDocId.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAvisoDocId.setBounds(10, 117, 16, 25);
		signoAvisoDocId.setVisible(false);
		panel.add(signoAvisoDocId);

		signoAvisoCelular = new JLabel("");
		signoAvisoCelular.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAvisoCelular.setBounds(271, 190, 16, 25);
		signoAvisoCelular.setVisible(false);
		panel.add(signoAvisoCelular);

		signoAvisoNombre = new JLabel("");
		signoAvisoNombre.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAvisoNombre.setBounds(10, 191, 16, 25);
		signoAvisoNombre.setVisible(false);
		panel.add(signoAvisoNombre);

		signoAvisoApellido = new JLabel("");
		signoAvisoApellido.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAvisoApellido.setBounds(10, 227, 16, 25);
		signoAvisoApellido.setVisible(false);
		panel.add(signoAvisoApellido);

		signoAvisoTelefono = new JLabel("");
		signoAvisoTelefono.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAvisoTelefono.setBounds(271, 227, 16, 25);
		signoAvisoTelefono.setVisible(false);
		panel.add(signoAvisoTelefono);

		spnFechaNacimiento = new JSpinner();
		spnFechaNacimiento.setEnabled(false);
		spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(1650181417873L), null, null, Calendar.YEAR));
		spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento,"dd/MM/yyyy"));
		spnFechaNacimiento.setValue(new Date());
		spnFechaNacimiento.setBounds(165, 155, 110, 25);
		panel.add(spnFechaNacimiento);

		JLabel signoAviso6 = new JLabel("");
		signoAviso6.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/prescripcion-medica.png")));
		signoAviso6.setBounds(27, 23, 86, 72);
		panel.add(signoAviso6);

		JLabel lblIdPaciente = new JLabel("ID:");
		lblIdPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdPaciente.setBounds(488, 30, 23, 25);
		panel.add(lblIdPaciente);

		txtIDPaciente = new JTextField();
		txtIDPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtIDPaciente.setEditable(false);
		txtIDPaciente.setColumns(10);
		txtIDPaciente.setText("Pac-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
		txtIDPaciente.setBounds(513, 30, 93, 25);
		panel.add(txtIDPaciente);

		JLabel lblOcupacion = new JLabel("Ocupación:");
		lblOcupacion.setBounds(31, 263, 70, 25);
		panel.add(lblOcupacion);

		signoAvisoOcupacion = new JLabel("");
		signoAvisoOcupacion.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAvisoOcupacion.setBounds(10, 263, 16, 25);
		signoAvisoOcupacion.setVisible(false);
		panel.add(signoAvisoOcupacion);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(347, 262, 110, 25);
		panel.add(txtDireccion);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(284, 263, 70, 25);
		panel.add(lblDireccion);

		SignoAvisoDirreccion = new JLabel("");
		SignoAvisoDirreccion.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		SignoAvisoDirreccion.setBounds(271, 263, 16, 25);
		SignoAvisoDirreccion.setVisible(false);
		panel.add(SignoAvisoDirreccion);

		cbxOcupacion = new JComboBox<Object>();
		cbxOcupacion.setEnabled(false);
		cbxOcupacion.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccionar>", "Profesor", "Abogado", "Ingeniero", "Medico", "Empleado Privado", "Empleado Publico", "Independiente"}));
		cbxOcupacion.setBounds(98, 263, 155, 25);
		panel.add(cbxOcupacion);

		JLabel label_2 = new JLabel("Tipo de Sangre:");
		label_2.setBounds(31, 310, 94, 25);
		panel.add(label_2);

		cbxTipoBlood = new JComboBox<Object>();
		cbxTipoBlood.setEnabled(false);
		cbxTipoBlood.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "A", "B", "AB", "O"}));
		cbxTipoBlood.setBounds(126, 310, 55, 25);
		panel.add(cbxTipoBlood);

		JLabel label_3 = new JLabel("RH:");
		label_3.setBounds(284, 310, 33, 25);
		panel.add(label_3);

		cbxRh = new JComboBox<Object>();
		cbxRh.setEnabled(false);
		cbxRh.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Positivo", "Negativo", "Nulo"}));
		cbxRh.setBounds(347, 310, 77, 25);
		panel.add(cbxRh);

		SignoAvisoRH = new JLabel("");
		SignoAvisoRH.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		SignoAvisoRH.setBounds(271, 310, 16, 25);
		SignoAvisoRH.setVisible(false);
		panel.add(SignoAvisoRH);

		signoAvisoTipoBlood = new JLabel("");
		signoAvisoTipoBlood.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));
		signoAvisoTipoBlood.setBounds(10, 310, 16, 25);
		signoAvisoTipoBlood.setVisible(false);
		panel.add(signoAvisoTipoBlood);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(paciente == null) {

							if(txtNid.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtTelefonoOpc.getText().equals("") || txtDireccion.getText().equals("") || 
									txtCelular.getText().equals("") || cbxOcupacion.getSelectedItem().equals("") || cbxTipoBlood.getSelectedItem().equals("") || cbxRh.getSelectedItem().equals("")
									|| cbxEspecialidad.getSelectedItem().equals("<Seleccionar>") || cbxDoctor.getSelectedItem().equals("")|| TextNotas.getText().equals("")) {
								Advertencia();
							}
							Paciente auxPaciente = null;
							Cita auxCita = null;
							auxPaciente = new Paciente(txtNombre.getText(), txtApellido.getText(), txtNid.getText(), (Date)spnFechaNacimiento.getValue(), cbxOcupacion.getSelectedItem().toString(), txtCelular.getText(), txtDireccion.getText(), txtIDPaciente.getText(), cbxTipoBlood.getSelectedItem().toString(),cbxRh.getSelectedItem().toString(), txtTelefonoOpc.getText());
							auxCita = new Cita((Date)spnFechaCita.getValue(), txtIDPaciente.getText(), TextNotas.getText(),cbxEspecialidad.getSelectedItem().toString(), cbxDoctor.getSelectedItem().toString(),auxPaciente);
							auxPaciente.insertarCita(auxCita);
							Clinica.getInstance().insertarCita(auxCita);
							Clinica.getInstance().insertarUsuario(auxPaciente);
							JOptionPane.showMessageDialog(null, "Operacion exitosa su Informacion a sido Procesada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							DesactivationKey(true);
							clean();
						}else {
							Cita auxCita = null;
							auxCita = new Cita((Date)spnFechaCita.getValue(), txtIDPaciente.getText(), TextNotas.getText(),cbxEspecialidad.getSelectedItem().toString(), cbxDoctor.getSelectedItem().toString(),paciente);
							paciente.insertarCita(auxCita);
							Clinica.getInstance().insertarCita(auxCita);
							JOptionPane.showMessageDialog(null, "Su Cita se a Agendado Correctamente..", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							DesactivationKey(true);
							clean();
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
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea cancelar?", "Confirmación",JOptionPane.YES_NO_OPTION);
						if(respuesta==JOptionPane.YES_OPTION) {
							dispose();
						}
					}
				});
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
		}


		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de la Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 395, 630, 184);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Especialista:");
		lblNewLabel_5.setBounds(10, 42, 84, 25);
		panel_2.add(lblNewLabel_5);

		cbxEspecialidad = new JComboBox<Object>();
		cbxEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbxEspecialidad.getSelectedIndex() > 0) {
					listarmedicosByEspecialidad(cbxEspecialidad.getSelectedItem().toString());
				}
			}
		});
		cbxEspecialidad.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccionar>", "Cirugía", "Pediatría", "Médicina Interna", "Psiquiatría", "Oftalmología", "Cardiología", "Neumología", "Dermatología", "Nefrología", "Neurología", "Radiología", "Anestesiología", "Urología", "Gastroenterología", "Gineco obstetricia"}));
		cbxEspecialidad.setBounds(90, 42, 147, 25);
		panel_2.add(cbxEspecialidad);


		spnFechaCita = new JSpinner();
		spnFechaCita.setModel(new SpinnerDateModel(new Date(1650181583304L), null, null, Calendar.DAY_OF_YEAR));
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
		cbxDoctor.setEnabled(false);
		cbxDoctor.setBounds(90, 78, 147, 25);
		panel_2.add(cbxDoctor);

		TextNotas = new JTextPane();
		TextNotas.setBounds(324, 42, 283, 108);
		panel_2.add(TextNotas);

		LblAdvertencia = new JLabel("No hay  Doctores Registrados ");
		LblAdvertencia.setForeground(Color.RED);
		LblAdvertencia.setBounds(90, 78, 172, 25);
		LblAdvertencia.setVisible(false);
		panel_2.add(LblAdvertencia);

		Mensaje = new JLabel("AVISO: LOS CAMPOS MARCADOS      SON NECESARIOS PARA PROCESAR CORRETACTAMENTE SU SOLICITUD");
		Mensaje.setBounds(22, 599, 598, 25);
		contentPanel.add(Mensaje);
		Mensaje.setVisible(false);
		Mensaje.setFont(new Font("Tahoma", Font.BOLD, 11));


		signoAviso7 = new JLabel("");
		signoAviso7.setBounds(204, 599, 16, 25);
		contentPanel.add(signoAviso7);
		signoAviso7.setVisible(false);
		signoAviso7.setIcon(new ImageIcon(CrearCitas.class.getResource("/img/signo-advertencia.png")));

	}

	private void listarmedicosByEspecialidad(String strespecialidad) {
		cbxDoctor.removeAllItems();
		cbxDoctor.setEnabled(true);
		cbxDoctor.addItem("<Seleccionar>");
		int doctores = 0;
		for (Usuario medico : Clinica.getInstance().buscarmedicosByEspecialiad(strespecialidad)) {
			cbxDoctor.addItem(medico.getNombre()+" "+medico.getApellido());
			doctores++;
		}
		if(doctores==0) {
			cbxDoctor.removeAllItems();
			cbxDoctor.setVisible(false);
			LblAdvertencia.setVisible(true);
		}else {
			LblAdvertencia.setVisible(false);
			cbxDoctor.setVisible(true);
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
	
	public void DesactivationKey(boolean value) {
		txtNombre.setEditable(false);
		txtApellido.setEditable(false);
		spnFechaNacimiento.setEnabled(false);
		txtCelular.setEditable(false);
		txtTelefonoOpc.setEditable(false);
		txtDireccion.setEditable(false);
		cbxOcupacion.setEnabled(false);
		cbxTipoBlood.setEnabled(false);
		cbxRh.setEnabled(false);
	}
	
	private void Advertencia() {
		Toolkit tk = Toolkit.getDefaultToolkit ();
		signoAvisoNombre.setVisible(true);
		signoAvisoApellido.setVisible(true);
		signoAvisoDocId.setVisible(true);
		signoAvisoOcupacion.setVisible(true);
		signoAvisoCelular.setVisible(true);
		signoAvisoTelefono.setVisible(true);
		SignoAvisoDirreccion.setVisible(true);
		signoAvisoTipoBlood.setVisible(true);
		SignoAvisoRH.setVisible(true);
		signoAviso7.setVisible(true);
		Mensaje.setVisible(true);
		tk.beep ();
	}
	
	private void clean() {
		txtNid.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtCelular.setText("");
		txtTelefonoOpc.setText("");
		txtCelular.setText("");
		txtDireccion.setText("");
		cbxOcupacion.setSelectedIndex(0);
		cbxTipoBlood.setSelectedIndex(0);
		cbxRh.setSelectedIndex(0);
		cbxEspecialidad.setSelectedIndex(0);
		cbxDoctor.setSelectedIndex(0);
		TextNotas.setText("");
	}


	/*public void cerrar ()
	{
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
			addWindowListener (new WindowAdapter() {
				public void windowsClosing(WindowEvent e) {
					confirmarSalida();
				}

			});
			this.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmarSalida () {
	  int valor = JOptionPane.showConfirmDialog (this, "Esta seguro de cerrar la aplicación?","Advertencia",JOptionPane.YES_NO_OPTION);
	  if (valor==JOptionPane.YES_OPTION) {
	      JOptionPane.showMessageDialog (null, "Gracias por au visita, Hasta Pronto", "Gracias",JOptionPane. INFORMATION_MESSAGE);
	      System.exit (0);
	  }
	}*/
}

