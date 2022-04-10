package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;
import javax.swing.border.TitledBorder;
import logico.Clinica;
import logico.Medico;
import logico.Usuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;

public class RegMedico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtUser;
	private JTextField txtpassword;
	private Random rand = new Random();
	private JComboBox<Object> cmbConsultorio;
	private JSpinner spinner;
	private Medico mimedico = null;
	private JComboBox<Object> cmbEspecialidad;
	private JLabel advertenciaCedula;
	private JLabel advertenciaNombre;
	private JLabel advertenciaApellido;
	private JLabel advertenciaTel;
	private JLabel advertenciaUser;
	private JLabel advertenciaContraseña;
	private JLabel lblImportante;
	private JLabel advertenciaConsultorio;
	private JLabel AdvertenciaDireccion;
	private JLabel advertenciaEspecialidad;


	public static void main(String[] args) {
		try {
			RegMedico dialog = new RegMedico(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegMedico(Medico us) {
		mimedico = us;
		if(us == null) {
			setTitle("Registro del Personal Medico");
		}else {
			setTitle("Modificar Registro del Personal Medico");
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegMedico.class.getResource("/img/cruz-roja.png")));
		setBounds(100, 100, 556, 580);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del Doctor:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(286, 391, 46, 14);
			panel.add(lblNewLabel);

			txtId = new JTextField();
			txtId.setBounds(286, 407, 193, 20);
			txtId.setEditable(false);
			panel.add(txtId);
			txtId.setColumns(10);
			txtId.setText("Dr-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(31, 164, 86, 14);
			panel.add(lblNewLabel_1);

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
			txtNombre.setBounds(31, 189, 193, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Apellido:");
			lblNewLabel_2.setBounds(31, 225, 94, 14);
			panel.add(lblNewLabel_2);

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
			txtApellido.setBounds(31, 250, 193, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Cedula:");
			lblNewLabel_3.setBounds(31, 106, 46, 14);
			panel.add(lblNewLabel_3);

			txtCedula = new JTextField();
			txtCedula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent evt) {                                    
					int key = evt.getKeyChar();

					boolean numeros = key >= 48 && key <= 57;

					if (!numeros)
					{
						evt.consume();
					}

					if (txtCedula.getText().trim().length() == 10) {
						evt.consume();
					}
				}     
			});
			txtCedula.setBounds(31, 133, 193, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);

			JLabel lblNewLabel_5 = new JLabel("Telefono:");
			lblNewLabel_5.setBounds(286, 162, 57, 14);
			panel.add(lblNewLabel_5);

			txtTelefono = new JTextField();
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent evt) {                                    
					int key = evt.getKeyChar();

					boolean numeros = key >= 48 && key <= 57;

					if (!numeros)
					{
						evt.consume();
					}

					if (txtTelefono.getText().trim().length() == 10) {
						evt.consume();
					}
				}     
			});
			txtTelefono.setBounds(286, 187, 193, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);

			JLabel lblNewLabel_6 = new JLabel("Direccion:");
			lblNewLabel_6.setBounds(286, 223, 57, 14);
			panel.add(lblNewLabel_6);

			txtDireccion = new JTextField();
			txtDireccion.setBounds(286, 248, 193, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);

			JLabel lblNewLabel_7 = new JLabel("Nombre de Usuario:");
			lblNewLabel_7.setBounds(286, 279, 128, 14);
			panel.add(lblNewLabel_7);

			txtUser = new JTextField();
			txtUser.setBounds(286, 304, 193, 20);
			panel.add(txtUser);
			txtUser.setColumns(10);

			JLabel lblNewLabel_8 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_8.setBounds(286, 335, 94, 14);
			panel.add(lblNewLabel_8);

			txtpassword = new JTextField();
			txtpassword.setBounds(286, 360, 193, 20);
			panel.add(txtpassword);
			txtpassword.setColumns(10);

			JLabel lblNewLabel_9 = new JLabel("Especialidad:");
			lblNewLabel_9.setBounds(31, 281, 94, 14);
			panel.add(lblNewLabel_9);

			JLabel lblNewLabel_10 = new JLabel("Consultorio:");
			lblNewLabel_10.setBounds(286, 106, 77, 14);
			panel.add(lblNewLabel_10);

			JLabel lblNewLabel_11 = new JLabel("Fecha de Nacimiento:");
			lblNewLabel_11.setBounds(31, 337, 136, 14);
			panel.add(lblNewLabel_11);

			spinner = new JSpinner();
			spinner.setBounds(31, 362, 193, 20);
			spinner.setModel(new SpinnerDateModel(new Date(1647921600000L), null, null, Calendar.YEAR));
			spinner.setValue(new Date());
			spinner.setEditor(new JSpinner.DateEditor(spinner,"dd/MM/yyyy"));
			panel.add(spinner);

			cmbConsultorio = new JComboBox<Object>();
			cargarConsultorios(true);
			cmbConsultorio.setBounds(286, 131, 193, 20);
			panel.add(cmbConsultorio);

			lblImportante = new JLabel("IMPORTANTE: TODOS LOS CAMPOS  DEBEN ESTAR COMPLETOS ");
			lblImportante.setBounds(87, 457, 358, 25);
			lblImportante.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblImportante.setVisible(false);
			panel.add(lblImportante);

			JLabel lblNewLabel_12 = new JLabel("");
			lblNewLabel_12.setIcon(new ImageIcon(RegMedico.class.getResource("/img/medico.png")));
			lblNewLabel_12.setBounds(10, 23, 86, 72);
			panel.add(lblNewLabel_12);

			cmbEspecialidad = new JComboBox<Object>();
			cmbEspecialidad.setBounds(31, 306, 193, 20);
			cmbEspecialidad.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccionar>", "Cirugía", "Pediatría", "Médicina Interna", "Psiquiatría", "Oftalmología", "Cardiología", "Neumología", "Dermatología", "Nefrología", "Neurología", "Radiología", "Anestesiología", "Urología", "Gastroenterología", "Gineco obstetricia"}));
			panel.add(cmbEspecialidad);

			advertenciaCedula = new JLabel("");
			advertenciaCedula.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaCedula.setBounds(10, 133, 16, 25);
			advertenciaCedula.setVisible(false);
			panel.add(advertenciaCedula);


			advertenciaNombre = new JLabel("");
			advertenciaNombre.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaNombre.setBounds(10, 189, 16, 25);
			advertenciaNombre.setVisible(false);
			panel.add(advertenciaNombre);

			advertenciaApellido = new JLabel("");
			advertenciaApellido.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaApellido.setBounds(10, 252, 16, 25);
			advertenciaApellido.setVisible(false);
			panel.add(advertenciaApellido);

			advertenciaTel = new JLabel("");
			advertenciaTel.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaTel.setBounds(265, 187, 16, 25);
			advertenciaTel.setVisible(false);
			panel.add(advertenciaTel);

			advertenciaUser = new JLabel("");
			advertenciaUser.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaUser.setBounds(265, 306, 16, 25);
			advertenciaUser.setVisible(false);
			panel.add(advertenciaUser);

			advertenciaContraseña = new JLabel("");
			advertenciaContraseña.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaContraseña.setBounds(265, 362, 16, 25);
			advertenciaContraseña.setVisible(false);
			panel.add(advertenciaContraseña);

			advertenciaConsultorio = new JLabel("");
			advertenciaConsultorio.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaConsultorio.setBounds(265, 135, 16, 25);
			advertenciaConsultorio.setVisible(false);
			panel.add(advertenciaConsultorio);

			AdvertenciaDireccion = new JLabel("");
			AdvertenciaDireccion.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			AdvertenciaDireccion.setBounds(265, 245, 16, 25);
			AdvertenciaDireccion.setVisible(false);
			panel.add(AdvertenciaDireccion);

			advertenciaEspecialidad = new JLabel("");
			advertenciaEspecialidad.setIcon(new ImageIcon(RegMedico.class.getResource("/img/signo-advertencia.png")));
			advertenciaEspecialidad.setBounds(10, 306, 16, 25);
			advertenciaEspecialidad.setVisible(false);
			panel.add(advertenciaEspecialidad);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("");
				if(mimedico ==null) {
					okButton.setText("Registrar");
				}else {
					okButton.setText("Modificar");
				}
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(mimedico == null) {

							if(txtCedula.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtTelefono.getText().equals("") || txtDireccion.getText().equals("") || 
									txtUser.getText().equals("") || txtpassword.getText().equals("") || cmbConsultorio.getSelectedItem().equals("<Seleccione>") || cmbEspecialidad.getSelectedItem().equals("<Seleccionar>")) {
								Advertencia();

							}else {

								Usuario nuevoMedico = null;
								nuevoMedico = new Medico(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), (Date) spinner.getValue(), txtTelefono.getText(), txtDireccion.getText(), txtUser.getText(),
										txtpassword.getText(),cmbConsultorio.getSelectedItem().toString(),txtId.getText() , cmbEspecialidad.getSelectedItem().toString());
								Clinica.getInstance().insertarUsuario(nuevoMedico);
								JOptionPane.showMessageDialog(null, "Se a Registrado el doctor/a Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------El resultado del spinner es: "+ Clinica.getInstance().buscarUsuarioByCedula(nuevoMedico.getID()).getFechaNaciento());
								clean();
							}
						}else {
							mimedico.setNombre(txtNombre.getText());
							mimedico.setApellido(txtApellido.getText());
							mimedico.setID(txtCedula.getText());
							mimedico.setFechaNaciento( (Date) spinner.getValue());
							mimedico.setTelefono(txtTelefono.getText());
							mimedico.setDireccion( txtDireccion.getText());
							mimedico.setLoginString(txtUser.getText());
							mimedico.setPassowrdString(txtpassword.getText());
							mimedico.setConsultorioString(cmbConsultorio.getSelectedItem().toString());
							mimedico.setCodigo(txtId.getText());
							mimedico.setEspecialidad( cmbEspecialidad.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "Operacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		loadMedico(mimedico);
	}
	private void loadMedico(Medico us) {
		if(us != null) {
			txtNombre.setText(us.getNombre());
			txtApellido.setText(us.getApellido());
			txtCedula.setText(us.getID());
			txtDireccion.setText(us.getDireccion());
			txtTelefono.setText(us.getTelefono());
			cmbEspecialidad.setSelectedItem(us.getEspecialidad());
			txtUser.setText(us.getLoginString());
			txtpassword.setText(us.getPassowrdString());
			spinner.setValue((Date)us.getFechaNaciento());
			cmbConsultorio.setSelectedItem(us.getConsultorioString());
		}
	}
	private void clean() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		cmbEspecialidad.setSelectedIndex(0);
		txtpassword.setText("");
		txtUser.setText("");
		txtTelefono.setText("");
		txtId.setText("Dr-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
		spinner.setValue(new Date());
		/*cmbConsultorio.remove(cmbConsultorio.getSelectedIndex());
		cargarConsultorios(true);*/
		cmbConsultorio.setSelectedIndex(0);

	}

	private void Advertencia() {
		Toolkit tk = Toolkit.getDefaultToolkit ();
		advertenciaNombre.setVisible(true);
		advertenciaApellido.setVisible(true);
		advertenciaCedula.setVisible(true);
		advertenciaUser.setVisible(true);
		advertenciaContraseña.setVisible(true);
		advertenciaTel.setVisible(true);
		AdvertenciaDireccion.setVisible(true);
		advertenciaConsultorio.setVisible(true);
		advertenciaEspecialidad.setVisible(true);
		lblImportante.setVisible(true);
		tk.beep ();
	}

	public void cargarConsultorios(boolean control) {
		String[] consultorioString = {"<Seleccione>","A1-101","A2-102","A3-103","B1-201","B2-202","B3-203","C1-301","C2-302","C3-303"};
		if(control == true) {
			for (String string : consultorioString) {
				cmbConsultorio.addItem(string);
			}
		}
	}
}
