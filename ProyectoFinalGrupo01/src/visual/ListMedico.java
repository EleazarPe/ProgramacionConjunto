package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Medico;
import logico.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class ListMedico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;	
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnEliminar;
	private JButton btnmodificar;
	private Object row[];
	private Medico medicoselect = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListMedico dialog = new ListMedico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListMedico() {
		setTitle("Listado Personal Médico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListMedico.class.getResource("/img/cruz-roja.png")));
		setBounds(100, 100, 863, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					String headers[] = {"Cédula","ID","Nombre","Apellido","Especialidad","Consultorio","Dirección","Teléfono"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int row = 0;
							row = table.getSelectedRow();
							if(row > -1) {
								btnEliminar.setEnabled(true);
								btnmodificar.setEnabled(true);
								medicoselect = (Medico) Clinica.getInstance().buscarUsuarioByCedula(table.getValueAt(row, 0).toString());
								
							}
						}
					});
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(medicoselect !=null) {
								int option = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el médico: "+ medicoselect.getID(), "Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								if(option == JOptionPane.YES_OPTION){
									Clinica.getInstance().eliminarUsuario(medicoselect);
									loadTable();
								}
							}
						}
					});
					btnmodificar = new JButton("Modificar");
					btnmodificar.setEnabled(false);
					btnmodificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
							RegMedico reg = new RegMedico(medicoselect);
							reg.setModal(true);
							reg.setVisible(true);
						}
					});
					btnmodificar.setActionCommand("");
					buttonPane.add(btnmodificar);
					btnEliminar.setEnabled(false);
					buttonPane.add(btnEliminar);
				}
			}
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnAceptar.setActionCommand("");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
		}
		loadTable();
	}
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (Usuario object : Clinica.getInstance().getUsuarios()) {
			if(object instanceof Medico) {
				if(!object.getID().equalsIgnoreCase("01")) {
					row[0] = object.getID();
					row[1] = object.getCodigo();
					row[2] =object.getNombre();
					row[3] = object.getApellido();
					row[4] = ((Medico) object).getEspecialidad();
					row[5] = ((Medico) object).getConsultorioString();
					row[6] =object.getDireccion();
					row[7] = object.getTelefono();
					model.addRow(row);	
				}
			}
		}
	}

}
