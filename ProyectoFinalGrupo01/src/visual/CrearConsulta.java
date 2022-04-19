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
import logico.Dosis;
import logico.Enfermedad;
import logico.Historial;
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
import javax.swing.DefaultListModel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;

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
	private JTextPane textSintomas;
	private JRadioButton rdbtSi;
	private JRadioButton rdbtnNo;
	private JPanel panelConsulta;
	private JPanel panelCita;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private  DefaultTableModel model3;
	private JPanel buttonPane;
	private JToggleButton tglbtntCitas;
	private JTable table;
	private JTable table1;
	private JTable table2;
	private JPanel panelHistorialM;
	private JPanel panelVacuna;
	private JButton okButton;
	private DateFormat formatter;
	private Object row[];
	private JToggleButton tglbtntConsulta;
	private JToggleButton tglbtntHistorialMedico;
	private JToggleButton tglbtntVacuna;
	private Paciente pacienteS = null;
	private Cita citaS = null;
	private JSpinner spnFechaNacimiento;
	private JButton cancelButton;
	private JTextField txtFechaV;
	private JTextField txtNombreV;
	private JTextField TxtApellidoV;
	private JTextField TxtCedulaV;
	private JTextField txtDoctorV;
	private JList<String> list;
	private DefaultListModel<String> lista1;
	private JList<String> list_1;
	private DefaultListModel<String> lista2;

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
			TetxObservaciones.setBounds(10, 22, 270, 97);
			PnlObservaciones.add(TetxObservaciones);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(327, 22, 170, 97);
			PnlObservaciones.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_1.add(scrollPane_1, BorderLayout.CENTER);
			lista1 = new DefaultListModel<>(); 
			list = new JList<>(lista1);
			scrollPane_1.setViewportView(list);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(583, 22, 170, 97);
			PnlObservaciones.add(panel_4);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_2 = new JScrollPane();
			panel_4.add(scrollPane_2, BorderLayout.CENTER);
			lista2 = new DefaultListModel<>(); 
			list_1 = new JList<>(lista2);
			scrollPane_2.setViewportView(list_1);
			
			JButton button = new JButton("<");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					////////////<<<-------------------------
					if(list_1.getSelectedIndex() > -1) {
						lista1.addElement(list_1.getSelectedValue());
						lista2.remove(list_1.getSelectedIndex());
					}
				}
			});
			button.setBounds(509, 79, 60, 23);
			PnlObservaciones.add(button);
			
			JButton button_1 = new JButton(">");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					////////////////////-------------->>>>
					if(list.getSelectedIndex() > -1) {
						lista2.addElement(list.getSelectedValue());
						lista1.remove(list.getSelectedIndex());
					}
				}
			});
			button_1.setBounds(510, 44, 59, 23);
			PnlObservaciones.add(button_1);
			
			JPanel pnlDiagnstico = new JPanel();
			pnlDiagnstico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sintomas:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlDiagnstico.setBounds(539, 11, 234, 171);
			panelConsulta.add(pnlDiagnstico);
			pnlDiagnstico.setLayout(null);
			
			textSintomas = new JTextPane();
			textSintomas.setEditable(false);
			textSintomas.setBounds(10, 21, 214, 139);
			pnlDiagnstico.add(textSintomas);
			
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
			
			panelHistorialM = new JPanel();
			panelHistorialM.setBounds(-2, 0, 784, 646);
			PanelListadoPaciente.add(panelHistorialM);
			panelHistorialM.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(6, 0, 771, 633);
			panelHistorialM.add(panel_2);
			panel_2.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 771, 633);
				panel_2.add(scrollPane);
				{
					String headers4[] = {"Carlos","Ivan","Albert","Poo"};
					model3 = new DefaultTableModel();
					model3.setColumnIdentifiers(headers4);
					table2 = new JTable();
				}
				scrollPane.setViewportView(table2);
				table2.setModel(model3);
				scrollPane.setViewportView(table2);
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
			
			JLabel lblNewLabel_3 = new JLabel("Nombres:");
			lblNewLabel_3.setBounds(10, 500, 70, 14);
			panel_3.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Apellidos:");
			lblNewLabel_4.setBounds(10, 416, 70, 14);
			panel_3.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("ID NO.");
			lblNewLabel_5.setBounds(10, 450, 70, 14);
			panel_3.add(lblNewLabel_5);
			
			txtFechaV = new JTextField();
			txtFechaV.setVisible(false);
			txtFechaV.setEditable(false);
			txtFechaV.setBounds(100, 400, 155, 25);
			panel_3.add(txtFechaV);
			txtFechaV.setColumns(10);
			
			txtNombreV = new JTextField();
			txtNombreV.setVisible(false);
			txtNombreV.setEditable(false);
			txtNombreV.setBounds(100, 450, 155, 25);
			panel_3.add(txtNombreV);
			txtNombreV.setColumns(10);
			
			TxtApellidoV = new JTextField();
			TxtApellidoV.setVisible(false);
			TxtApellidoV.setEditable(false);
			TxtApellidoV.setBounds(100, 500, 155, 25);
			panel_3.add(TxtApellidoV);
			TxtApellidoV.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Fecha actual:");
			lblNewLabel_6.setBounds(0, 0, 46, 14);
			panel_3.add(lblNewLabel_6);
			
			TxtCedulaV = new JTextField();
			TxtCedulaV.setVisible(false);
			TxtCedulaV.setEditable(false);
			TxtCedulaV.setBounds(100, 550, 155, 25);
			panel_3.add(TxtCedulaV);
			TxtCedulaV.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Doctor:");
			lblNewLabel_7.setBounds(0, 0, 46, 14);
			panel_3.add(lblNewLabel_7);
			
			txtDoctorV = new JTextField();
			txtDoctorV.setVisible(false);
			txtDoctorV.setBounds(100, 600, 155, 25);
			panel_3.add(txtDoctorV);
			txtDoctorV.setColumns(10);
			

			
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
								textSintomas.setText(citaS.getNotas());
								JOptionPane.showMessageDialog(null, "Paciente procesado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							}
							if(okButton.getText().equals("Aplicar")) {
								////////////////////////////////////////////////----------------------->>>>>>>>>>>>>>>>>
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
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
				tglbtntHistorialMedico.setSelected(false);
				tglbtntVacuna.setSelected(false);
				panelConsulta.setVisible(false);
				panelCita.setVisible(true);
				okButton.setText("Consultar");
				okButton.setVisible(true);
				loadTable();
				
			}
		});
		menuBar.add(tglbtntCitas);
		
		tglbtntConsulta = new JToggleButton("Consulta");
		tglbtntConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				tglbtntHistorialMedico.setSelected(false);
				tglbtntVacuna.setSelected(false);
				tglbtntCitas.setSelected(false);
				panelCita.setVisible(false);
				panelConsulta.setVisible(true);
				okButton.setText("Guardar");
				okButton.setVisible(true);
				
			}
		});
		menuBar.add(tglbtntConsulta);
		
		tglbtntHistorialMedico = new JToggleButton("Historial Médico");
		tglbtntHistorialMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtntVacuna.setSelected(false);
				tglbtntCitas.setSelected(false);
				tglbtntConsulta.setSelected(false);
				panelCita.setVisible(false);
				panelConsulta.setVisible(false);
				panelVacuna.setVisible(false);
				panelHistorialM.setVisible(true);
				okButton.setVisible(false);
				loadTbleHistorial();

			}
		});
		menuBar.add(tglbtntHistorialMedico);
		
		tglbtntVacuna = new JToggleButton("Vacuna");
		tglbtntVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtntCitas.setSelected(false);
				tglbtntConsulta.setSelected(false);
				tglbtntHistorialMedico.setSelected(false);
				panelCita.setVisible(false);
				panelConsulta.setVisible(false);
				panelHistorialM.setVisible(false);
				panelVacuna.setVisible(true);
				okButton.setText("Aplicar");
				okButton.setVisible(true);
				txtDoctorV.setVisible(true);
				txtFechaV.setVisible(true);
				TxtCedulaV.setVisible(true);
				txtNombreV.setVisible(true);
				TxtApellidoV.setVisible(true);
				loadTableVacuna();
				
				
			}
		});
		menuBar.add(tglbtntVacuna);
		System.out.println("TA ENTRANDO");
		generarList();

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
	
	private void loadTableVacuna() {
		if(pacienteS !=null) {
			model.setRowCount(0);
			row = new Object[model.getColumnCount()];
			for ( Dosis object :pacienteS.getMisDosis()) {
				row[0] = object.getVacinneVacuna().getNombreString();
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				row[1] = formatter.format(object.getFecha()).toString();
				row[2] = object.getDoctor();
				model.addRow(row);
			}
		}
		
	}
	
	
	private void loadTbleHistorial() {
		model3.setRowCount(0);
		row = new Object[model3.getColumnCount()];
		for (Historial hi : Clinica.getInstance().getHistoriales()) {
			row[0] = "";
			row[1]= "";
			row[2] = "";
			row[3] = "";
			row[4] = "";
			model3.addRow(row);
		}
	}
	
	private void generarList() {
		for (Enfermedad ef : Clinica.getInstance().getenfermedadS()) {
			lista1.addElement(ef.getCodigoString()+"-"+ef.getNombreString());
			System.out.println("Funcionando: "+ef);
		}
	}
}




