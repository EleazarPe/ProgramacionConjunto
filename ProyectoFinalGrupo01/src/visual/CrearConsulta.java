package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class CrearConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtTipoSangre;
	private JButton btnBuscarCedula;
	private JTextField txtNombre;
	private JButton btnCrearPaciente;
	private JTextField txtCodigoConsulta;
	private JTextField txtPeso;
	private JTextField txtPresion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearConsulta dialog = new CrearConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearConsulta() {
		setModal(true);
		setResizable(false);
		setTitle("Consulta\r\n");
		setBounds(100, 100, 565, 633);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel InformacionCliente = new JPanel();
			InformacionCliente.setBorder(new TitledBorder(null, "Informacion del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			InformacionCliente.setBounds(12, 13, 517, 190);
			panel.add(InformacionCliente);
			InformacionCliente.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula o pasaporte:");
			lblNewLabel.setBounds(11, 29, 123, 16);
			InformacionCliente.add(lblNewLabel);
			
			JTextField txtCedulaBuscar = new JTextField();
			txtCedulaBuscar.setBounds(145, 26, 116, 22);
			InformacionCliente.add(txtCedulaBuscar);
			txtCedulaBuscar.setColumns(10);
			
			btnBuscarCedula = new JButton("Buscar\r\n");
			btnBuscarCedula.setBounds(272, 25, 97, 25);
			InformacionCliente.add(btnBuscarCedula);
			
			JLabel lblNombre = new JLabel("Nombre:\r\n");
			lblNombre.setBounds(30, 78, 50, 16);
			InformacionCliente.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setEnabled(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(110, 75, 116, 22);
			InformacionCliente.add(txtNombre);
			
			JLabel lblApellido = new JLabel("Apellido:\r\n");
			lblApellido.setBounds(30, 110, 50, 16);
			InformacionCliente.add(lblApellido);
			
			txtApellido = new JTextField();
			txtApellido.setEnabled(false);
			txtApellido.setEditable(false);
			txtApellido.setColumns(10);
			txtApellido.setBounds(110, 107, 116, 22);
			InformacionCliente.add(txtApellido);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(30, 142, 50, 16);
			InformacionCliente.add(lblEdad);
			
			txtEdad = new JTextField();
			txtEdad.setEnabled(false);
			txtEdad.setEditable(false);
			txtEdad.setColumns(10);
			txtEdad.setBounds(110, 142, 116, 22);
			InformacionCliente.add(txtEdad);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(256, 78, 63, 16);
			InformacionCliente.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setEnabled(false);
			txtDireccion.setEditable(false);
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(349, 75, 137, 22);
			InformacionCliente.add(txtDireccion);
			
			btnCrearPaciente = new JButton("Crear Paciente");
			btnCrearPaciente.setBounds(380, 25, 123, 25);
			InformacionCliente.add(btnCrearPaciente);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(256, 110, 63, 16);
			InformacionCliente.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setEnabled(false);
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(349, 107, 137, 22);
			InformacionCliente.add(txtTelefono);
			
			JLabel lblTipoDeSangre = new JLabel("Tipo de sangre:");
			lblTipoDeSangre.setBounds(256, 142, 97, 16);
			InformacionCliente.add(lblTipoDeSangre);
			
			txtTipoSangre = new JTextField();
			txtTipoSangre.setEnabled(false);
			txtTipoSangre.setEditable(false);
			txtTipoSangre.setColumns(10);
			txtTipoSangre.setBounds(371, 139, 116, 22);
			InformacionCliente.add(txtTipoSangre);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.control);
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 216, 517, 324);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo Consulta:");
			lblNewLabel_1.setBounds(12, 13, 102, 16);
			panel_1.add(lblNewLabel_1);
			
			txtCodigoConsulta = new JTextField();
			txtCodigoConsulta.setEnabled(false);
			txtCodigoConsulta.setEditable(false);
			txtCodigoConsulta.setColumns(10);
			txtCodigoConsulta.setBounds(113, 10, 70, 22);
			panel_1.add(txtCodigoConsulta);
			
			JTextArea txtaDiagnostico = new JTextArea();
			txtaDiagnostico.setBounds(269, 114, 225, 83);
			panel_1.add(txtaDiagnostico);
			
			JTextArea txtaTratamiento = new JTextArea();
			txtaTratamiento.setBounds(269, 228, 225, 83);
			panel_1.add(txtaTratamiento);
			
			JLabel lblNewLabel_2 = new JLabel("Diagnostico");
			lblNewLabel_2.setBounds(269, 96, 70, 16);
			panel_1.add(lblNewLabel_2);
			
			JLabel lblTratamiento = new JLabel("Tratamiento");
			lblTratamiento.setBounds(269, 210, 70, 16);
			panel_1.add(lblTratamiento);
			
			JTextArea txtaExploracion = new JTextArea();
			txtaExploracion.setBounds(12, 228, 225, 83);
			panel_1.add(txtaExploracion);
			
			JLabel label = new JLabel("Exploracion");
			label.setBounds(12, 210, 70, 16);
			panel_1.add(label);
			
			JLabel lblNewLabel_3 = new JLabel("Peso:");
			lblNewLabel_3.setBounds(12, 60, 37, 16);
			panel_1.add(lblNewLabel_3);
			
			txtPeso = new JTextField();
			txtPeso.setBounds(52, 57, 61, 22);
			panel_1.add(txtPeso);
			txtPeso.setColumns(10);
			
			JLabel lblPresion = new JLabel("Presion:");
			lblPresion.setBounds(12, 93, 52, 16);
			panel_1.add(lblPresion);
			
			txtPresion = new JTextField();
			txtPresion.setColumns(10);
			txtPresion.setBounds(62, 90, 61, 22);
			panel_1.add(txtPresion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
