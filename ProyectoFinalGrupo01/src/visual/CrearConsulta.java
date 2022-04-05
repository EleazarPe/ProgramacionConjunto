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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextPane;

public class CrearConsulta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField TxtApellido;
	private JTextField TxtNombres;
	private JTextField txtNoId;
	private JTextPane TextReceta;
	private JTextPane textDiagnostico;

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
		setTitle("Control de Consulta\r\ns");
		setBounds(100, 100, 807, 694);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		{
			JPanel PanelListadoPaciente = new JPanel();
			contentPanel.add(PanelListadoPaciente, BorderLayout.CENTER);
			PanelListadoPaciente.setLayout(null);
			
			JPanel PanelPacienteActual = new JPanel();
			PanelPacienteActual.setLayout(null);
			PanelPacienteActual.setBounds(0, 0, 780, 597);
			PanelListadoPaciente.add(PanelPacienteActual);
			
			JPanel pnlDatosPaciente = new JPanel();
			pnlDatosPaciente.setBorder(new TitledBorder(null, "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosPaciente.setBounds(10, 11, 517, 233);
			PanelPacienteActual.add(pnlDatosPaciente);
			pnlDatosPaciente.setLayout(null);
			
			JLabel label_1 = new JLabel("Apellidos:");
			label_1.setBounds(10, 183, 70, 25);
			pnlDatosPaciente.add(label_1);
			
			TxtApellido = new JTextField();
			TxtApellido.setEditable(false);
			TxtApellido.setColumns(10);
			TxtApellido.setBounds(72, 183, 155, 25);
			pnlDatosPaciente.add(TxtApellido);
			
			JLabel label_2 = new JLabel("Nombres:");
			label_2.setBounds(10, 147, 70, 25);
			pnlDatosPaciente.add(label_2);
			
			TxtNombres = new JTextField();
			TxtNombres.setEditable(false);
			TxtNombres.setColumns(10);
			TxtNombres.setBounds(72, 146, 155, 25);
			pnlDatosPaciente.add(TxtNombres);
			
			JLabel label_3 = new JLabel("Fecha de Nacimiento:");
			label_3.setBounds(10, 109, 130, 25);
			pnlDatosPaciente.add(label_3);
			
			JLabel label_4 = new JLabel(" Documento Identidad:");
			label_4.setBounds(10, 73, 130, 25);
			pnlDatosPaciente.add(label_4);
			
			JComboBox<Object> cbxId = new JComboBox<Object>();
			cbxId.setEnabled(false);
			cbxId.setEditable(true);
			cbxId.setModel(new DefaultComboBoxModel<Object>(new String[] {"Cedula", "Pasaporte", "Licencia"}));
			cbxId.setBounds(144, 73, 110, 25);
			pnlDatosPaciente.add(cbxId);
			
			JSpinner spnFechaNacimiento = new JSpinner();
			spnFechaNacimiento.setEnabled(false);
			spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(1648699200000L), null, null, Calendar.DAY_OF_YEAR));
			spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento,"dd/MM/yyyy"));
			spnFechaNacimiento.setBounds(144, 111, 110, 25);
			pnlDatosPaciente.add(spnFechaNacimiento);
			
			JLabel label_5 = new JLabel("NO.");
			label_5.setBounds(282, 73, 34, 25);
			pnlDatosPaciente.add(label_5);
			
			txtNoId = new JTextField();
			txtNoId.setEditable(false);
			txtNoId.setColumns(10);
			txtNoId.setBounds(319, 73, 110, 25);
			pnlDatosPaciente.add(txtNoId);
			
			JPanel pnlDatosClinicos = new JPanel();
			pnlDatosClinicos.setBorder(new TitledBorder(null, "Datos Clinicos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosClinicos.setBounds(10, 255, 517, 171);
			PanelPacienteActual.add(pnlDatosClinicos);
			pnlDatosClinicos.setLayout(null);
			
			JSpinner spnEstatura = new JSpinner();
			spnEstatura.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnEstatura.setBounds(108, 41, 55, 25);
			pnlDatosClinicos.add(spnEstatura);
			
			JLabel lblNewLabel = new JLabel("Estatura:");
			lblNewLabel.setBounds(10, 39, 55, 25);
			pnlDatosClinicos.add(lblNewLabel);
			
			JSpinner spnPeso = new JSpinner();
			spnPeso.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnPeso.setBounds(240, 41, 55, 25);
			pnlDatosClinicos.add(spnPeso);
			
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(185, 41, 55, 25);
			pnlDatosClinicos.add(lblPeso);
			
			JLabel lblNewLabel_1 = new JLabel("Tipo de Sangre:");
			lblNewLabel_1.setBounds(10, 91, 94, 25);
			pnlDatosClinicos.add(lblNewLabel_1);
			
			JComboBox<Object> cbxTipoSangre = new JComboBox<Object>();
			cbxTipoSangre.setModel(new DefaultComboBoxModel<Object>(new String[] {"A", "B", "AB", "O"}));
			cbxTipoSangre.setBounds(108, 91, 55, 25);
			pnlDatosClinicos.add(cbxTipoSangre);
			
			JLabel lblRh = new JLabel("RH:");
			lblRh.setBounds(185, 96, 33, 25);
			pnlDatosClinicos.add(lblRh);
			
			JComboBox<Object> cbxRhSangre = new JComboBox<Object>();
			cbxRhSangre.setModel(new DefaultComboBoxModel<Object>(new String[] {"Positivo", "Negativo"}));
			cbxRhSangre.setBounds(240, 93, 77, 25);
			pnlDatosClinicos.add(cbxRhSangre);
			
			JPanel PnlObservaciones = new JPanel();
			PnlObservaciones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obsevaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PnlObservaciones.setBounds(10, 437, 760, 130);
			PanelPacienteActual.add(PnlObservaciones);
			PnlObservaciones.setLayout(null);
			
			JTextPane TetxObservaciones = new JTextPane();
			TetxObservaciones.setBounds(10, 22, 740, 97);
			PnlObservaciones.add(TetxObservaciones);
			
			JPanel pnlRecetas = new JPanel();
			pnlRecetas.setBorder(new TitledBorder(null, "Receta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRecetas.setBounds(537, 11, 233, 233);
			PanelPacienteActual.add(pnlRecetas);
			pnlRecetas.setLayout(null);
			
			TextReceta = new JTextPane();
			TextReceta.setBounds(10, 21, 213, 190);
			pnlRecetas.add(TextReceta);
			
			JPanel pnlDiagnstico = new JPanel();
			pnlDiagnstico.setBorder(new TitledBorder(null, "Dignostico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDiagnstico.setBounds(537, 255, 234, 171);
			PanelPacienteActual.add(pnlDiagnstico);
			pnlDiagnstico.setLayout(null);
			
			textDiagnostico = new JTextPane();
			textDiagnostico.setBounds(10, 21, 214, 139);
			pnlDiagnstico.add(textDiagnostico);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
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
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Consulta");
		menuBar.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Historial De Consultas");
		menuBar.add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Historial Medico");
		menuBar.add(tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Vacuna");
		menuBar.add(tglbtnNewToggleButton_2);
	}
}
