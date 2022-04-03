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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextPane textPane;
	private JTextPane textPane_1;

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
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(72, 183, 155, 25);
			pnlDatosPaciente.add(textField_1);
			
			JLabel label_2 = new JLabel("Nombres:");
			label_2.setBounds(10, 147, 70, 25);
			pnlDatosPaciente.add(label_2);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(72, 146, 155, 25);
			pnlDatosPaciente.add(textField_2);
			
			JLabel label_3 = new JLabel("Fecha de Nacimiento:");
			label_3.setBounds(10, 109, 130, 25);
			pnlDatosPaciente.add(label_3);
			
			JLabel label_4 = new JLabel(" Documento Identidad:");
			label_4.setBounds(10, 73, 130, 25);
			pnlDatosPaciente.add(label_4);
			
			JComboBox<Object> comboBox = new JComboBox<Object>();
			comboBox.setEnabled(false);
			comboBox.setEditable(true);
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Cedula", "Pasaporte", "Licencia"}));
			comboBox.setBounds(144, 73, 110, 25);
			pnlDatosPaciente.add(comboBox);
			
			JSpinner spnFechaNacimiento = new JSpinner();
			spnFechaNacimiento.setEnabled(false);
			spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(1648699200000L), null, null, Calendar.DAY_OF_YEAR));
			spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento,"dd/MM/yyyy"));
			spnFechaNacimiento.setBounds(144, 111, 110, 25);
			pnlDatosPaciente.add(spnFechaNacimiento);
			
			JLabel label_5 = new JLabel("NO.");
			label_5.setBounds(282, 73, 34, 25);
			pnlDatosPaciente.add(label_5);
			
			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setBounds(319, 73, 110, 25);
			pnlDatosPaciente.add(textField_3);
			
			JPanel pnlDatosClinicos = new JPanel();
			pnlDatosClinicos.setBorder(new TitledBorder(null, "Datos Clinicos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosClinicos.setBounds(10, 255, 517, 171);
			PanelPacienteActual.add(pnlDatosClinicos);
			pnlDatosClinicos.setLayout(null);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(108, 41, 55, 25);
			pnlDatosClinicos.add(spinner);
			
			JLabel lblNewLabel = new JLabel("Estatura:");
			lblNewLabel.setBounds(10, 39, 55, 25);
			pnlDatosClinicos.add(lblNewLabel);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner_1.setBounds(240, 41, 55, 25);
			pnlDatosClinicos.add(spinner_1);
			
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(185, 41, 55, 25);
			pnlDatosClinicos.add(lblPeso);
			
			JLabel lblNewLabel_1 = new JLabel("Tipo de Sangre:");
			lblNewLabel_1.setBounds(10, 91, 94, 25);
			pnlDatosClinicos.add(lblNewLabel_1);
			
			JComboBox<Object> comboBox_1 = new JComboBox<Object>();
			comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"A", "B", "AB", "O"}));
			comboBox_1.setBounds(108, 91, 55, 25);
			pnlDatosClinicos.add(comboBox_1);
			
			JLabel lblRh = new JLabel("RH:");
			lblRh.setBounds(185, 96, 33, 25);
			pnlDatosClinicos.add(lblRh);
			
			JComboBox<Object> comboBox_2 = new JComboBox<Object>();
			comboBox_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"Positivo", "Negativo"}));
			comboBox_2.setBounds(240, 93, 77, 25);
			pnlDatosClinicos.add(comboBox_2);
			
			JPanel PnlObservaciones = new JPanel();
			PnlObservaciones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obsevaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PnlObservaciones.setBounds(10, 437, 760, 130);
			PanelPacienteActual.add(PnlObservaciones);
			PnlObservaciones.setLayout(null);
			
			JTextPane textPane_2 = new JTextPane();
			textPane_2.setBounds(10, 22, 740, 97);
			PnlObservaciones.add(textPane_2);
			
			JPanel pnlRecetas = new JPanel();
			pnlRecetas.setBorder(new TitledBorder(null, "Receta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRecetas.setBounds(537, 11, 233, 233);
			PanelPacienteActual.add(pnlRecetas);
			pnlRecetas.setLayout(null);
			
			textPane = new JTextPane();
			textPane.setBounds(10, 21, 213, 190);
			pnlRecetas.add(textPane);
			
			JPanel pnlDiagnstico = new JPanel();
			pnlDiagnstico.setBorder(new TitledBorder(null, "Dignostico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDiagnstico.setBounds(537, 255, 234, 171);
			PanelPacienteActual.add(pnlDiagnstico);
			pnlDiagnstico.setLayout(null);
			
			textPane_1 = new JTextPane();
			textPane_1.setBounds(10, 21, 214, 139);
			pnlDiagnstico.add(textPane_1);
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
