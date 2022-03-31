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
			lblNewLabel_1.setBounds(10, 162, 86, 14);
			panel.add(lblNewLabel_1);

			txtNombre = new JTextField();
			txtNombre.setBounds(10, 187, 193, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Apellido:");
			lblNewLabel_2.setBounds(10, 223, 94, 14);
			panel.add(lblNewLabel_2);

			txtApellido = new JTextField();
			txtApellido.setBounds(10, 248, 193, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Cedula:");
			lblNewLabel_3.setBounds(10, 106, 46, 14);
			panel.add(lblNewLabel_3);

			txtCedula = new JTextField();
			txtCedula.setBounds(10, 131, 193, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);

			JLabel lblNewLabel_5 = new JLabel("Telefono:");
			lblNewLabel_5.setBounds(286, 162, 57, 14);
			panel.add(lblNewLabel_5);

			txtTelefono = new JTextField();
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
			lblNewLabel_9.setBounds(10, 279, 94, 14);
			panel.add(lblNewLabel_9);

			JLabel lblNewLabel_10 = new JLabel("Consultorio:");
			lblNewLabel_10.setBounds(286, 106, 77, 14);
			panel.add(lblNewLabel_10);

			JLabel lblNewLabel_11 = new JLabel("Fecha de Nacimiento:");
			lblNewLabel_11.setBounds(10, 335, 136, 14);
			panel.add(lblNewLabel_11);

			spinner = new JSpinner();
			spinner.setBounds(10, 360, 193, 20);
			spinner.setModel(new SpinnerDateModel(new Date(1647921600000L), null, null, Calendar.YEAR));
			spinner.setEditor(new JSpinner.DateEditor(spinner,"dd/MM/yyyy"));
			panel.add(spinner);

			cmbConsultorio = new JComboBox<Object>();
			cmbConsultorio.setBounds(286, 131, 193, 20);
			cmbConsultorio.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>", "A1-101", "A2-102", "A3-103", "B1-201", "B2-202", "B3-203", "C1-301", "C2-302", "C3-303"}));
			panel.add(cmbConsultorio);

			JLabel lblImportanteTodosLos = new JLabel("IMPORTANTE: TODOS LOS CAMPOS  DEBEN ESTAR COMPLETOS ");
			lblImportanteTodosLos.setBounds(87, 457, 358, 25);
			lblImportanteTodosLos.setFont(new Font("Tahoma", Font.BOLD, 11));
			panel.add(lblImportanteTodosLos);

			JLabel lblNewLabel_12 = new JLabel("");
			lblNewLabel_12.setIcon(new ImageIcon(RegMedico.class.getResource("/img/medico.png")));
			lblNewLabel_12.setBounds(10, 23, 86, 72);
			panel.add(lblNewLabel_12);

			cmbEspecialidad = new JComboBox<Object>();
			cmbEspecialidad.setBounds(10, 304, 193, 20);
			cmbEspecialidad.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccionar>", "Cirug\u00EDa", "Pediatr\u00EDa", "M\u00E9dicina Interna", "Psiquiatr\u00EDa", "Oftalmolog\u00EDa", "Cardiolog\u00EDa", "Neumolog\u00EDa", "Dermatolog\u00EDa", "Nefrolog\u00EDa", "Neurolog\u00EDa", "Radiolog\u00EDa", "Anestesiolog\u00EDa", "Urolog\u00EDa", "Gastroenterolog\u00EDa", "Gineco obstetricia"}));
			panel.add(cmbEspecialidad);
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
							Usuario nuevoMedico = null;
							nuevoMedico = new Medico(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), (Date) spinner.getValue(), txtTelefono.getText(), txtDireccion.getText(), txtUser.getText(), txtpassword.getText(),cmbConsultorio.getSelectedItem().toString(),txtId.getText() , cmbEspecialidad.getSelectedItem().toString());
							Clinica.getInstance().insertarUsuario(nuevoMedico);
							JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------El resultado del spinner es: "+ Clinica.getInstance().buscarUsuarioByCedula(nuevoMedico.getID()).getFechaNaciento());
							clean();
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
							JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
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
		cmbConsultorio.setSelectedIndex(0);

	}
}
