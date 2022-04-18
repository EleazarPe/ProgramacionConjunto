package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cita;
import logico.Clinica;
import logico.Consulta;
import logico.Historial;
import logico.Paciente;
import logico.Usuario;
import logico.Vacuna;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
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
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JRadioButton rdbtSi;
	private JRadioButton rdbtnNo;
	private JPanel panelConsulta;
	private JPanel panelCita;
	private DefaultTableModel model;
	private DefaultTableModel model3;
	private DefaultTableModel model2;
	private DefaultTableModel model4;
	private JPanel buttonPane;
	private JToggleButton tglbtntCitas;
	private JTable table;
	private JTable table4;
	private JTable table2;
	private JTable table1;
	private JPanel panelHistorialC;
	private JPanel panelHistorialM;
	private JPanel panelVacuna;
	private JButton okButton;
	private DateFormat formatter;
	private Object row[], row2[];
	private JToggleButton tglbtntConsulta;
	private JToggleButton tglbtntHistorialConsultas;
	private JToggleButton tglbtntHistorialMedico;
	private JToggleButton tglbtntVacuna;
	private Paciente pacienteS = null;
	private JSpinner spnFechaNacimiento;
	private JSpinner spnFechaInicial;
	private JComboBox cbxLaboratorios;
	private JSpinner spnFechaFinal;
	private JComboBox cbxEnfermedades;
	private JComboBox cbxDoctorVacuno;
	private JComboBox cbxViaVacuna;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearConsulta.class.getResource("/img/cruz-roja.png")));
		setModal(true);
		setResizable(false);
		setTitle("Control de Consulta\r\ns");
		setBounds(100, 100, 836, 791);
		getContentPane().setLayout(null);
		contentPanel.setBounds(8, 0, 801, 649);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel PanelListadoPaciente = new JPanel();
			PanelListadoPaciente.setBounds(11, 9, 779, 640);
			contentPanel.add(PanelListadoPaciente);
			PanelListadoPaciente.setLayout(null);
			
			panelConsulta = new JPanel();
			panelConsulta.setLayout(null);
			panelConsulta.setBounds(-2, 0, 784, 646);
			PanelListadoPaciente.add(panelConsulta);
			
			panelCita = new JPanel();
			panelCita.setBounds(-2, 0, 784, 646);
			PanelListadoPaciente.add(panelCita);
			panelCita.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(6, 0, 771, 633);
			panelCita.add(panel);
			panel.setLayout(null);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"ID","Cédula","Nombre","Teléfono","Síntomas","fecha"};
					model2 = new DefaultTableModel();
					model2.setColumnIdentifiers(headers);
					table1 = new JTable();
					table1.setModel(model2);
					table1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int select = 0;
							select = table1.getSelectedRow();
							System.out.println("======>"+select);
							if(select > -1) {
								System.out.println("--------->"+table1.getValueAt(select, 1).toString());
								pacienteS =  Clinica.getInstance().buscarPacienteById(table1.getValueAt(select, 1).toString());
							}
							//---------------------------------------------------------->>>>
						}
					});
				}
				scrollPane.setViewportView(table1);
				table1.setModel(model2);
				scrollPane.setViewportView(table1);
			}
			
			
			JPanel pnlDatosPaciente = new JPanel();
			pnlDatosPaciente.setBorder(new TitledBorder(null, "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosPaciente.setBounds(10, 11, 517, 233);
			panelConsulta.add(pnlDatosPaciente);
			pnlDatosPaciente.setLayout(null);
			
			JLabel label_1 = new JLabel("Apellidos:");
			label_1.setBounds(10, 183, 70, 25);
			pnlDatosPaciente.add(label_1);
			
			TxtApellido = new JTextField();
			TxtApellido.setEditable(false);
			TxtApellido.setColumns(10);
			TxtApellido.setBounds(99, 183, 155, 25);
			pnlDatosPaciente.add(TxtApellido);
			
			JLabel label_2 = new JLabel("Nombres:");
			label_2.setBounds(10, 147, 70, 25);
			pnlDatosPaciente.add(label_2);
			
			TxtNombres = new JTextField();
			TxtNombres.setEditable(false);
			TxtNombres.setColumns(10);
			TxtNombres.setBounds(99, 146, 155, 25);
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
			cbxId.setModel(new DefaultComboBoxModel<Object>(new String[] {"Cédula", "Pasaporte", "Licencia"}));
			cbxId.setBounds(144, 73, 110, 25);
			pnlDatosPaciente.add(cbxId);
			
			spnFechaNacimiento = new JSpinner();
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
			panelConsulta.add(pnlDatosClinicos);
			pnlDatosClinicos.setLayout(null);
			
			JSpinner spnEstatura = new JSpinner();
			spnEstatura.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnEstatura.setBounds(108, 39, 55, 25);
			pnlDatosClinicos.add(spnEstatura);
			
			JLabel lblNewLabel = new JLabel("Estatura:");
			lblNewLabel.setBounds(10, 39, 55, 25);
			pnlDatosClinicos.add(lblNewLabel);
			
			JSpinner spnPeso = new JSpinner();
			spnPeso.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnPeso.setBounds(240, 39, 55, 25);
			pnlDatosClinicos.add(spnPeso);
			
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(185, 39, 55, 25);
			pnlDatosClinicos.add(lblPeso);
			
			JLabel lblNewLabel_1 = new JLabel("Tipo de Sangre:");
			lblNewLabel_1.setBounds(10, 91, 94, 25);
			pnlDatosClinicos.add(lblNewLabel_1);
			
			JComboBox<Object> cbxTipoSangre = new JComboBox<Object>();
			cbxTipoSangre.setModel(new DefaultComboBoxModel<Object>(new String[] {"A", "B", "AB", "O"}));
			cbxTipoSangre.setBounds(108, 91, 55, 25);
			pnlDatosClinicos.add(cbxTipoSangre);
			
			JLabel lblRh = new JLabel("RH:");
			lblRh.setBounds(185, 91, 33, 25);
			pnlDatosClinicos.add(lblRh);
			
			JComboBox<Object> cbxRhSangre = new JComboBox<Object>();
			cbxRhSangre.setModel(new DefaultComboBoxModel<Object>(new String[] {"Positivo", "Negativo", "Nulo"}));
			cbxRhSangre.setBounds(240, 91, 77, 25);
			pnlDatosClinicos.add(cbxRhSangre);
			
			JPanel PnlObservaciones = new JPanel();
			PnlObservaciones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obsevaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PnlObservaciones.setBounds(10, 437, 763, 130);
			panelConsulta.add(PnlObservaciones);
			PnlObservaciones.setLayout(null);
			
			JTextPane TetxObservaciones = new JTextPane();
			TetxObservaciones.setBounds(10, 22, 740, 97);
			PnlObservaciones.add(TetxObservaciones);
			
			JPanel pnlDiagnstico = new JPanel();
			pnlDiagnstico.setBorder(new TitledBorder(null, "Dignostico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDiagnstico.setBounds(539, 11, 234, 171);
			panelConsulta.add(pnlDiagnstico);
			pnlDiagnstico.setLayout(null);
			
			textDiagnostico = new JTextPane();
			textDiagnostico.setBounds(10, 21, 214, 139);
			pnlDiagnstico.add(textDiagnostico);
			
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtSi.setSelected(false);
				}
			});
			rdbtnNo.setBounds(115, 606, 45, 23);
			panelConsulta.add(rdbtnNo);
			rdbtnNo.setSelected(true);
			rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			rdbtSi = new JRadioButton("Si");
			rdbtSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnNo.setSelected(false);
				}
			});
			rdbtSi.setBounds(42, 606, 45, 23);
			panelConsulta.add(rdbtSi);
			rdbtSi.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JLabel lblNewLabel_2 = new JLabel("\u00BFAgregar a Historial Medico?");
			lblNewLabel_2.setBounds(20, 574, 177, 25);
			panelConsulta.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JPanel pnlRecetas = new JPanel();
			pnlRecetas.setBounds(540, 193, 233, 233);
			panelConsulta.add(pnlRecetas);
			pnlRecetas.setBorder(new TitledBorder(null, "Receta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRecetas.setLayout(null);
			
			TextReceta = new JTextPane();
			TextReceta.setBounds(10, 21, 213, 190);
			pnlRecetas.add(TextReceta);
			
			panelHistorialC = new JPanel();
			panelHistorialC.setBounds(-2, 0, 784, 646);
			PanelListadoPaciente.add(panelHistorialC);
			panelHistorialC.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(6, 0, 771, 633);
			panelHistorialC.add(panel_1);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(new Rectangle(0, 0, 771, 633));
				panel_1.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Nombre","Apellido","cedula","ocupacion","telefono","direccion","Fecha"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.setModel(model);
				}
				scrollPane.setViewportView(table);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			
			panelHistorialM = new JPanel();
			panelHistorialM.setBounds(-2, 0, 784, 646);
			PanelListadoPaciente.add(panelHistorialM);
			panelHistorialM.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(6, 0, 771, 633);
			panelHistorialM.add(panel_2);
			{
				JScrollPane scrollPane = new JScrollPane();
				panel_2.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Carlos","Ivan","Albert","Poo"};
					model4 = new DefaultTableModel();
					model4.setColumnIdentifiers(headers);
					table4 = new JTable();
				}
				scrollPane.setViewportView(table4);
				table4.setModel(model4);
				scrollPane.setViewportView(table4);
			}
			
			panelVacuna = new JPanel();
			panelVacuna.setBounds(-2, 0, 784, 646);
			PanelListadoPaciente.add(panelVacuna);
			panelVacuna.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(6, 0, 771, 633);
			panelVacuna.add(panel_3);
			panel_3.setLayout(null);
			{
				JLabel lblReporteVacunas = new JLabel("REPORTE VACUNAS");
				lblReporteVacunas.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblReporteVacunas.setBounds(12, 179, 149, 22);
				panel_3.add(lblReporteVacunas);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 201, 771, 432);
				panel_3.add(scrollPane);
				{
					String headers[] = {"Fecha de Vacunacion","Via de Administracion","Laboratorio","Enfermedad cubierta","Doctor"};
					model3 = new DefaultTableModel();
					model3.setColumnIdentifiers(headers);
					table2 = new JTable();
				}
				scrollPane.setViewportView(table2);
				table2.setModel(model3);
				scrollPane.setViewportView(table2);
			}
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(0, 0, 771, 182);
			panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.add(panel_4);
			panel_4.setLayout(null);
			
			JLabel lblVacuna_1 = new JLabel("Laboratorio vacuna:\r\n");
			lblVacuna_1.setBounds(308, 127, 116, 16);
			panel_4.add(lblVacuna_1);
			
			JLabel lblViaDeAdministracion = new JLabel("Via de administración:\r\n");
			lblViaDeAdministracion.setBounds(308, 72, 129, 16);
			panel_4.add(lblViaDeAdministracion);
			
			cbxViaVacuna = new JComboBox();
			cbxViaVacuna.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Intravenosa", "Intramuscular", "Subcutanea"}));
			cbxViaVacuna.setBounds(308, 92, 144, 22);
			panel_4.add(cbxViaVacuna);
			
			JLabel lblVacuna_2 = new JLabel("Filtrar resultados:");
			lblVacuna_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVacuna_2.setBounds(12, 13, 129, 22);
			panel_4.add(lblVacuna_2);
			
			JLabel lblVacuna_3 = new JLabel("Si desea filtrar la informacion, complete los campos requeridos.");
			lblVacuna_3.setBounds(12, 36, 375, 16);
			panel_4.add(lblVacuna_3);
			
			spnFechaInicial = new JSpinner();
			spnFechaInicial.setModel(new SpinnerDateModel(new Date(1650168000000L), null, null, Calendar.DAY_OF_YEAR));
			spnFechaInicial.setEditor(new JSpinner.DateEditor(spnFechaInicial,"dd/MM/yyyy"));
			spnFechaInicial.setValue(new Date());
			spnFechaInicial.setBounds(86, 92, 136, 22);
			panel_4.add(spnFechaInicial);
			
			spnFechaFinal = new JSpinner();
			spnFechaFinal.setModel(new SpinnerDateModel(new Date(1650168000000L), null, null, Calendar.DAY_OF_YEAR));
			spnFechaFinal.setEditor(new JSpinner.DateEditor(spnFechaFinal,"dd/MM/yyyy"));
			spnFechaFinal.setValue(new Date());
			spnFechaFinal.setBounds(86, 144, 136, 22);
			panel_4.add(spnFechaFinal);
			
			JLabel lblVacuna_4 = new JLabel("Fecha inicial:");
			lblVacuna_4.setBounds(86, 72, 75, 16);
			panel_4.add(lblVacuna_4);
			
			JLabel lblVacuna_5 = new JLabel("Fecha Final:");
			lblVacuna_5.setBounds(86, 126, 75, 16);
			panel_4.add(lblVacuna_5);
			
			cbxLaboratorios = new JComboBox();
			cbxLaboratorios .setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Johnson & johnson", "Roche", "AbbVie", "Bayer", "Pfizer", "Bristol-Myers Squibb", "Merck & Co", "Novartis", "Sanofi"}));
			cbxLaboratorios .setBounds(308, 144, 144, 22);
			panel_4.add(cbxLaboratorios);
			
			JLabel lblEnfermedadesCubiertas = new JLabel("Enfermedades:");
			lblEnfermedadesCubiertas.setBounds(538, 72, 87, 16);
			panel_4.add(lblEnfermedadesCubiertas);
			
			cbxEnfermedades = new JComboBox();
			cbxEnfermedades.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			cbxEnfermedades.setBounds(538, 92, 144, 22);
			panel_4.add(cbxEnfermedades);
			
			JLabel lblDoctor = new JLabel("Doctor");
			lblDoctor.setBounds(538, 127, 87, 16);
			panel_4.add(lblDoctor);
			
			cbxDoctorVacuno = new JComboBox();
			cbxDoctorVacuno.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			cbxDoctorVacuno.setBounds(538, 147, 144, 22);
			panel_4.add(cbxDoctorVacuno);			
			
			JPanel PanelEnfermedad = new JPanel();
			PanelEnfermedad.setBounds(0, 0, 784, 646);
			PanelListadoPaciente.add(PanelEnfermedad);
			PanelEnfermedad.setLayout(new BorderLayout(0, 0));
		}
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(21, 662, 774, 52);
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("Guardar");
				/*if (panelCita.isEnabled()) {      La idea es que cuando se abra la ventana de citas cambie el boton guardar y asi se haria con cada ventana.
					okButton.setText("Consultar");
				}
				*/
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(pacienteS != null) {
							if(okButton.getText().equals("Consultar")) {
								TxtNombres.setText(pacienteS.getNombre());
								TxtApellido.setText(pacienteS.getApellido());
								txtNoId.setText(pacienteS.getID());
								spnFechaNacimiento.setValue((Date)pacienteS.getFechaNaciento());
								JOptionPane.showMessageDialog(null, "Paciente procesado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						//s
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		tglbtntCitas = new JToggleButton("Citas");
		tglbtntCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tglbtntConsulta.setSelected(false);
				tglbtntHistorialConsultas.setSelected(false);
				tglbtntHistorialMedico.setSelected(false);
				tglbtntVacuna.setSelected(false);
				panelConsulta.setVisible(false);
				panelCita.setVisible(true);
				okButton.setText("Consultar");
				
			}
		});
		menuBar.add(tglbtntCitas);
		
		tglbtntConsulta = new JToggleButton("Consulta");
		tglbtntConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				tglbtntHistorialConsultas.setSelected(false);
				tglbtntHistorialMedico.setSelected(false);
				tglbtntVacuna.setSelected(false);
				tglbtntCitas.setSelected(false);
				panelCita.setVisible(false);
				panelConsulta.setVisible(true);
				okButton.setText("Guardar");
				
			}
		});
		menuBar.add(tglbtntConsulta);
		
		tglbtntHistorialConsultas = new JToggleButton("Historial De Consultas");
		tglbtntHistorialConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtntHistorialMedico.setSelected(false);
				tglbtntVacuna.setSelected(false);
				tglbtntCitas.setSelected(false);
				tglbtntConsulta.setSelected(false);
				panelCita.setVisible(false);
				panelConsulta.setVisible(false);
				panelHistorialM.setVisible(false);
				panelVacuna.setVisible(false);
				panelHistorialC.setVisible(true);
			}
		});
		menuBar.add(tglbtntHistorialConsultas);
		
		tglbtntHistorialMedico = new JToggleButton("Historial Médico");
		tglbtntHistorialMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtntVacuna.setSelected(false);
				tglbtntCitas.setSelected(false);
				tglbtntConsulta.setSelected(false);
				tglbtntHistorialConsultas.setSelected(false);
				panelCita.setVisible(false);
				panelConsulta.setVisible(false);
				panelVacuna.setVisible(false);
				panelHistorialC.setVisible(false);
				panelHistorialM.setVisible(true);

			}
		});
		menuBar.add(tglbtntHistorialMedico);
		
		tglbtntVacuna = new JToggleButton("Vacuna");
		tglbtntVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtntCitas.setSelected(false);
				tglbtntConsulta.setSelected(false);
				tglbtntHistorialConsultas.setSelected(false);
				tglbtntHistorialMedico.setSelected(false);
				panelCita.setVisible(false);
				panelConsulta.setVisible(false);
				panelHistorialM.setVisible(false);
				panelHistorialC.setVisible(false);
				panelVacuna.setVisible(true);
			}
		});
		menuBar.add(tglbtntVacuna);
		Date fecha = new Date();
		Usuario usuario = new Usuario("Darvy", "Bsfg","sdfsdf",fecha, "234234234", "dasfsdfsd", "fsfdfd");
		Cita cit = new Cita(fecha, "1234", "sdfsdfsdfsdf", "Abogado", "Pediatra", usuario);
		Clinica.getInstance().insertarUsuario(usuario);
		Clinica.getInstance().insertarCita(cit);
		Consulta consulta = new Consulta("Alerr", "asdad", "123213", "Abogado", "123123", "asdasd", fecha);
		Clinica.getInstance().insertarConsulta(consulta);
		loadTableCitas();
		loadTableHC();
	}
	private void loadTableCitas() {
		
		model2.setRowCount(0);
		row = new Object[model2.getColumnCount()];
		for (Cita ct : Clinica.getInstance().getMisCitas()) {
			row[0] = ct.getCodigo();
			row[1] = ct.getUserUsuario().getID();
			row[2] = ct.getUserUsuario().getNombre() + ct.getUserUsuario().getApellido();
			row[3] = ct.getUserUsuario().getTelefono();
			row[4] = ct.getNotas();
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			row[5] = formatter.format(ct.getFecha()).toString();
			model2.addRow(row);	
		}
		System.out.println("Hola");

	}
	
private void loadTableHC() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];	
		for (Consulta consultaHC : Clinica.getInstance().getConsultas()) {
			row[0] = consultaHC.getNombre();
			row[1] = consultaHC.getApellido();
			row[2] = consultaHC.getCedula();
			row[3] = consultaHC.getOcupacion();
			row[4] = consultaHC.getTelefono();
			row[5] = consultaHC.getDireccion();
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(formatter.format(consultaHC.getFecha()).toString());
			row[6] = formatter.format(consultaHC.getFecha()).toString();
			model.addRow(row);	
		}
	}

private void loadTableHM() {
	
	model2.setRowCount(0);
	row = new Object[model2.getColumnCount()];
	for (Cita ct : Clinica.getInstance().compararCitaYDoctor()) {
		row[0] = ct.getCodigo();
		row[1] = ct.getUserUsuario().getID();
		row[2] = ct.getUserUsuario().getNombre() + ct.getUserUsuario().getApellido();
		row[3] = ct.getUserUsuario().getTelefono();
		row[4] = ct.getNotas();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		row[5] = formatter.format(ct.getFecha()).toString();
		model2.addRow(row);	
	}

}

/*private void loadTableVacunas() {
	
	model4.setRowCount(0);
	row = new Object[model4.getColumnCount()];
	for (Paciente paciente : Clinica.getInstance().get()) {
		if(Integer.parseInt(vacuna.ge))
	}

}*/
}



