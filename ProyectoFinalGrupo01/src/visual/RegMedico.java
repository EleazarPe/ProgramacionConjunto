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
	private JTextField txtOcupacion;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtUser;
	private JTextField txtpassword;
	private JTextField txtEspecialidad;
	private Random rand = new Random();
	private JComboBox<Object> cmbConsultorio;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegMedico dialog = new RegMedico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegMedico() {
		setTitle("Registro de Medico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegMedico.class.getResource("/img/cruz-roja.png")));
		setBounds(100, 100, 556, 474);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(281, 324, 46, 14);
			panel.add(lblNewLabel);
			
			txtId = new JTextField();
			txtId.setEditable(false);
			txtId.setBounds(281, 340, 193, 20);
			panel.add(txtId);
			txtId.setColumns(10);
			txtId.setText("Dr-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 39, 86, 14);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(10, 64, 193, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Apellido:");
			lblNewLabel_2.setBounds(10, 95, 94, 14);
			panel.add(lblNewLabel_2);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(10, 120, 193, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Cedula:");
			lblNewLabel_3.setBounds(10, 156, 46, 14);
			panel.add(lblNewLabel_3);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(10, 181, 193, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Ocupacion:");
			lblNewLabel_4.setBounds(10, 212, 69, 14);
			panel.add(lblNewLabel_4);
			
			txtOcupacion = new JTextField();
			txtOcupacion.setBounds(10, 237, 193, 20);
			panel.add(txtOcupacion);
			txtOcupacion.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Telefono:");
			lblNewLabel_5.setBounds(281, 95, 57, 14);
			panel.add(lblNewLabel_5);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(281, 120, 193, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Direccion:");
			lblNewLabel_6.setBounds(281, 156, 57, 14);
			panel.add(lblNewLabel_6);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(281, 181, 193, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Nombre de Usuario:");
			lblNewLabel_7.setBounds(281, 212, 128, 14);
			panel.add(lblNewLabel_7);
			
			txtUser = new JTextField();
			txtUser.setBounds(281, 237, 193, 20);
			panel.add(txtUser);
			txtUser.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_8.setBounds(281, 268, 94, 14);
			panel.add(lblNewLabel_8);
			
			txtpassword = new JTextField();
			txtpassword.setBounds(281, 293, 193, 20);
			panel.add(txtpassword);
			txtpassword.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("Especialidad:");
			lblNewLabel_9.setBounds(10, 268, 94, 14);
			panel.add(lblNewLabel_9);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.setBounds(10, 293, 193, 20);
			panel.add(txtEspecialidad);
			txtEspecialidad.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("Consultorio:");
			lblNewLabel_10.setBounds(281, 39, 77, 14);
			panel.add(lblNewLabel_10);
			
			JLabel lblNewLabel_11 = new JLabel("Fecha de Nacimiento:");
			lblNewLabel_11.setBounds(10, 324, 136, 14);
			panel.add(lblNewLabel_11);
			
			spinner = new JSpinner();
			spinner.setModel(new SpinnerDateModel(new Date(1647921600000L), null, null, Calendar.YEAR));
			spinner.setEditor(new JSpinner.DateEditor(spinner,"dd/MM/yyyy"));
			spinner.setBounds(10, 340, 162, 20);
			panel.add(spinner);
			
			cmbConsultorio = new JComboBox<Object>();
			cmbConsultorio.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>", "A1-101", "A2-102", "A3-103", "B1-201", "B2-202", "B3-203", "C1-301", "C2-302", "C3-303"}));
			cmbConsultorio.setBounds(281, 64, 193, 20);
			panel.add(cmbConsultorio);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Usuario nuevoMedico = null;
						
						nuevoMedico = new Medico(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), (Date) spinner.getValue(), txtOcupacion.getText(), txtTelefono.getText(), txtDireccion.getText(), txtUser.getText(), txtpassword.getText(),cmbConsultorio.getSelectedItem().toString() , txtEspecialidad.getText());
						Clinica.getInstance().insertarUsuario(nuevoMedico);
						JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	private void clean() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtEspecialidad.setText("");
		txtOcupacion.setText("");
		txtpassword.setText("");
		txtUser.setText("");
		txtTelefono.setText("");
		txtId.setText("Dr-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
		spinner.setValue(new Date());
		cmbConsultorio.setSelectedIndex(0);
		
	}
}
