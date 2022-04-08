package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	private JTable table;
	private JPanel PanelConsulta;
	private JPanel panelCita;
	private DefaultTableModel model;
	private Object row[];
	private JPanel panel_1;

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
		//Comentario de un comentario comentado en la comentacion 
		setModal(true);
		setResizable(false);
		setTitle("Control de Consulta\r\ns");
		setBounds(100, 100, 807, 756);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 801, 664);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel PanelListadoPaciente = new JPanel();
			PanelListadoPaciente.setBounds(5, 15, 791, 644);
			contentPanel.add(PanelListadoPaciente);
			PanelListadoPaciente.setLayout(null);
			
			PanelConsulta = new JPanel();
			PanelConsulta.setLayout(null);
			PanelConsulta.setBounds(0, 0, 781, 685);
			PanelListadoPaciente.add(PanelConsulta);
			
			panelCita = new JPanel();
			panelCita.setBounds(0, 0, 781, 685);
			PanelListadoPaciente.add(panelCita);
			panelCita.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 791, 643);
			panelCita.add(panel);
			panel.setLayout(null);
			panel_1 = new JPanel();
			panel_1.setBounds(0, 0, 791, 593);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel_1.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Cedula","Nombre","Direccion","Telefono"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
				}
				scrollPane.setViewportView(table);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			
			JButton btnConsultar = new JButton("Consultar");
			btnConsultar.setBounds(625, 600, 89, 23);
			panel.add(btnConsultar);
			
			
			JPanel pnlDatosPaciente = new JPanel();
			pnlDatosPaciente.setBorder(new TitledBorder(null, "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosPaciente.setBounds(10, 11, 517, 233);
			PanelConsulta.add(pnlDatosPaciente);
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
			PanelConsulta.add(pnlDatosClinicos);
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
			PnlObservaciones.setBounds(10, 437, 760, 130);
			PanelConsulta.add(PnlObservaciones);
			PnlObservaciones.setLayout(null);
			
			JTextPane TetxObservaciones = new JTextPane();
			TetxObservaciones.setBounds(10, 22, 740, 97);
			PnlObservaciones.add(TetxObservaciones);
			
			JPanel pnlRecetas = new JPanel();
			pnlRecetas.setBorder(new TitledBorder(null, "Receta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRecetas.setBounds(537, 11, 233, 233);
			PanelConsulta.add(pnlRecetas);
			pnlRecetas.setLayout(null);
			
			TextReceta = new JTextPane();
			TextReceta.setBounds(10, 21, 213, 190);
			pnlRecetas.add(TextReceta);
			
			JPanel pnlDiagnstico = new JPanel();
			pnlDiagnstico.setBorder(new TitledBorder(null, "Dignostico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDiagnstico.setBounds(537, 255, 234, 171);
			PanelConsulta.add(pnlDiagnstico);
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
			PanelConsulta.add(rdbtnNo);
			rdbtnNo.setSelected(true);
			rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			rdbtSi = new JRadioButton("Si");
			rdbtSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnNo.setSelected(false);
				}
			});
			rdbtSi.setBounds(42, 606, 45, 23);
			PanelConsulta.add(rdbtSi);
			rdbtSi.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JLabel lblNewLabel_2 = new JLabel("\u00BFAgregar a Historial Medico?");
			lblNewLabel_2.setBounds(20, 574, 177, 25);
			PanelConsulta.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			

			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 664, 801, 38);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
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
		
		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("Citas");
		tglbtnNewToggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////////////////---------------------------------->
				PanelConsulta.setVisible(false);
				panelCita.setVisible(true);
				
			}
		});
		menuBar.add(tglbtnNewToggleButton_4);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Consulta");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCita.setVisible(false);
				PanelConsulta.setVisible(true);
			}
		});
		menuBar.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Historial De Consultas");
		menuBar.add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Historial Medico");
		menuBar.add(tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Vacuna");
		menuBar.add(tglbtnNewToggleButton_2);
	}
}
