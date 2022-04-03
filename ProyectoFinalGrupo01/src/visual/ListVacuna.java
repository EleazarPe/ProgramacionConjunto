package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ListVacuna extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListVacuna dialog = new ListVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListVacuna() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListVacuna.class.getResource("/img/cruz-roja.png")));
		setTitle("Lista de Vacunas");
		setBounds(100, 100, 668, 300);
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
					String headers[] = {"Codigo","Nombre","Laboratorio","Administracion","Enfermedades"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					scrollPane.setViewportView(table);
				}
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Eliminar");
				cancelButton.setEnabled(false);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		//System.out.println("La enfermedad: "+Clinica.getInstance().getVacunas().get(0).getEnfermedades().get(0).getNombreString());
		loadTable();
	}
	private String retornaString(Vacuna object) {
		String listaefString = " ";
		System.out.println("----------------<<<<<");
		for (int i = 0; i<object.getEnfermedades().size(); i++) {
			System.out.println("---------------->>>>");
			if(i== 0) {
				listaefString = listaefString.concat(object.getEnfermedades().get(i).getNombreString());
			}else {
				listaefString = listaefString.concat(", "+object.getEnfermedades().get(i).getNombreString());	
			}
			//System.out.println(object.getEnfermedades().get(i).getNombreString());
		}
		return listaefString;
	}
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (Vacuna object : Clinica.getInstance().getVacunas()) {
			row[0] = object.getCodigo();
			row[1] = object.getNombreString();
			row[2] = object.getLaboratorioString();
			row[3] = object.getAdministracionString();
			row[4] = retornaString(object);
			model.addRow(row);	
		}
	}
}
