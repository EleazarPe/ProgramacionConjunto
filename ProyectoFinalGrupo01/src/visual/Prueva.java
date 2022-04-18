package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Enfermedad;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Prueva extends JDialog {

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
			Prueva dialog = new Prueva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Prueva() {
		setBounds(100, 100, 845, 734);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 784, 646);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Código","Nombre","Tipo","Informacion","Fecha de Aparición","Tasa de Transmisibilidad","Seleccion"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable();
	}

	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (Enfermedad object : Clinica.getInstance().getenfermedadS()) {
			row[0] = object.getCodigoString();
			row[1] = object.getNombreString();
			row[2] = object.getTipoString();
			row[3] = object.getInformacionString();
			row[4] = new SimpleDateFormat("dd/MM/yyyy").format(object.getDescubierta());
			row[5] = object.getTransmisibilidad();
			row[6] = "holas";
			model.addRow(row);	
		}
	}
}
