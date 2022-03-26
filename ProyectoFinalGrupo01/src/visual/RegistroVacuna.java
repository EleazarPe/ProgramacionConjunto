package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Dosis;
import logico.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroVacuna extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtPerosnal;
	private JTextField txtFecha;
	private JSpinner spinner;
	private JComboBox<Object> cbxOcupacion;
	private JComboBox<Object> cbxVacuna;
	private Vacuna auxiliarVacuna;
	private Date date;
	private DateFormat formatter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroVacuna dialog = new RegistroVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroVacuna() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroVacuna.class.getResource("/img/cruz-roja.png")));
		setTitle("Registro de vacunacion");
		setBounds(100, 100, 864, 656);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(0, 0, 838, 233);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);

			table = new JTable();
			scrollPane.setViewportView(table);

			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(0, 430, 838, 133);
			panel.add(panel_2);
			panel_2.setLayout(null);

			JLabel lblNewLabel_6 = new JLabel("Vacuna:");
			lblNewLabel_6.setBounds(10, 11, 46, 14);
			panel_2.add(lblNewLabel_6);

			cbxVacuna = new JComboBox<Object>();
			cbxVacuna.setBounds(10, 25, 219, 20);
			panel_2.add(cbxVacuna);

			JLabel lblNewLabel_7 = new JLabel("Personal de la Salud:");
			lblNewLabel_7.setBounds(10, 56, 141, 14);
			panel_2.add(lblNewLabel_7);

			txtPerosnal = new JTextField();
			txtPerosnal.setBounds(10, 71, 219, 20);
			panel_2.add(txtPerosnal);
			txtPerosnal.setColumns(10);

			JLabel lblNewLabel_8 = new JLabel("Fecha Actual:");
			lblNewLabel_8.setBounds(289, 11, 92, 14);
			panel_2.add(lblNewLabel_8);

			txtFecha = new JTextField();
			txtFecha.setEditable(false);
			txtFecha.setBounds(289, 25, 78, 20);
			panel_2.add(txtFecha);
			txtFecha.setColumns(10);
			date = Calendar.getInstance().getTime();
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			txtFecha.setText(formatter.format(date).toString());

			JLabel lblNewLabel = new JLabel("Cedula: ");
			lblNewLabel.setBounds(10, 244, 67, 14);
			panel.add(lblNewLabel);

			txtCedula = new JTextField();
			txtCedula.setBounds(10, 258, 217, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);

			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					////////////////////////////////////////////////////////------------------------------>>>>>>>>>>>>>>
					auxiliarVacuna = Clinica.getInstance().buscarVacunabyCedula(txtCedula.getText());
					if(auxiliarVacuna == null) {
						txtNombre.setEditable(true);
						txtDireccion.setEditable(true);
						txtTelefono.setEditable(true);
						spinner.setEnabled(true);
						cbxOcupacion.setEnabled(true);
						cargarVacunas(false);

					}else {
						cargarVacunas(true);
					}
				}
			});
			btnNewButton.setIcon(new ImageIcon(RegistroVacuna.class.getResource("/img/lupa.png")));
			btnNewButton.setBounds(278, 247, 119, 31);
			panel.add(btnNewButton);

			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 289, 67, 14);
			panel.add(lblNewLabel_1);

			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(10, 303, 217, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento:");
			lblNewLabel_2.setBounds(10, 337, 143, 14);
			panel.add(lblNewLabel_2);

			spinner = new JSpinner();
			spinner.setEnabled(false);
			spinner.setModel(new SpinnerDateModel(new Date(1648180800000L), null, null, Calendar.YEAR));
			spinner.setEditor(new JSpinner.DateEditor(spinner,"dd/MM/yyyy"));
			spinner.setBounds(125, 334, 102, 20);
			panel.add(spinner);

			JLabel lblNewLabel_3 = new JLabel("Ocupacion:");
			lblNewLabel_3.setBounds(10, 374, 67, 14);
			panel.add(lblNewLabel_3);

			cbxOcupacion = new JComboBox<Object>();
			cbxOcupacion.setEnabled(false);
			cbxOcupacion.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccionar>", "Profesor", "Abogado", "Ingeniero", "Medico", "Empleado ", "Independiente", "Otro..."}));
			cbxOcupacion.setBounds(10, 399, 217, 20);
			panel.add(cbxOcupacion);

			JLabel lblNewLabel_4 = new JLabel("Direccion:");
			lblNewLabel_4.setBounds(288, 289, 67, 14);
			panel.add(lblNewLabel_4);

			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setBounds(282, 303, 217, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);

			JLabel lblNewLabel_5 = new JLabel("Telefono:");
			lblNewLabel_5.setBounds(288, 337, 67, 14);
			panel.add(lblNewLabel_5);

			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setBounds(282, 351, 217, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
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
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Vacuna auxVacuna = null;
						auxVacuna = new Vacuna(txtCedula.getText(), txtNombre.getText(), cbxOcupacion.getSelectedItem().toString(), txtDireccion.getText(), (Date) spinner.getValue());
						Dosis auxDosis = null;
						auxDosis = new Dosis(cbxVacuna.getSelectedItem().toString(), txtPerosnal.getText(),true);
						auxVacuna.insertarDosis(auxDosis);
						Clinica.getInstance().insertarVacuna(auxVacuna);
						JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}


	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		cbxOcupacion.setSelectedIndex(0);
		cbxVacuna.removeAllItems();
		spinner.setValue(new Date());
		txtNombre.setEditable(false);
		txtDireccion.setEditable(false);
		txtTelefono.setEditable(false);
		spinner.setEnabled(false);
		cbxOcupacion.setEnabled(false);
	}

	public void cargarVacunas(boolean control) {
		String[] vacunaStrings = {"<seleccionar>","Tetano","Sarampion","HepatitisA","HepapitisB","Tuberculosis","Rabia","Colera","Fiebre tifoidea","Grie"};
		if(control == false) {
			for (String string : vacunaStrings) {
				cbxVacuna.addItem(string);
			}
		}else {
			for (String string : vacunaStrings) {
				if(auxiliarVacuna.encontrarDosis(string)==false ) {
					cbxVacuna.addItem(string);
				}
			}
		}

	}
}
