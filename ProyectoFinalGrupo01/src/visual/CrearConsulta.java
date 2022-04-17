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
import logico.Paciente;

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
	private DefaultTableModel model2;
	private JPanel buttonPane;
	private JToggleButton tglbtntCitas;
	private JTable table;
	private JTable table1;
	private JPanel panelHistorialC;
	private JPanel panelHistorialM;
	private JPanel panelVacuna;
	private JButton okButton;
	private DateFormat formatter;
	private Object row[];
	private JToggleButton tglbtntConsulta;
	private JToggleButton tglbtntHistorialConsultas;
	private JToggleButton tglbtntHistorialMedico;
	private JToggleButton tglbtntVacuna;
	private Paciente pacienteS = null;
	private JSpinner spnFechaNacimiento;

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
					String headers[] = {"Prueba","Prueba1","Prieba","probando"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
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
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
				}
				scrollPane.setViewportView(table);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			
			panelVacuna = new JPanel();
			panelVacuna.setBounds(-2, 0, 784, 646);
			PanelListadoPaciente.add(panelVacuna);
			panelVacuna.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(6, 0, 771, 633);
			panelVacuna.add(panel_3);
			panel_3.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 771, 304);
				panel_3.add(scrollPane);
				{
					String headers[] = {"Vacuna","Fecha de Vacunacion","Doctor"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
				}
				scrollPane.setViewportView(table);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			

			
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
		loadTable();
	}
	private void loadTable() {
		
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
}
