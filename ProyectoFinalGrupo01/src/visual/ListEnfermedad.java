package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Enfermedad;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ListEnfermedad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private Object row[];
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListEnfermedad dialog = new ListEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListEnfermedad() {
		setTitle("Listado de Enfermedades");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListEnfermedad.class.getResource("/img/senal-de-peligro-biologico (1).png")));
		setBounds(100, 100, 759, 300);
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
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Código","Nombre","Tipo","Informacion","Fecha de Aparición"};
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
				JButton btnMod = new JButton("Modificar");
				btnMod.setEnabled(false);
				buttonPane.add(btnMod);
			}
			{
				JButton btnDelete = new JButton("Eliminar");
				btnDelete.setEnabled(false);
				btnDelete.setActionCommand("Cancel");
				buttonPane.add(btnDelete);
			}
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
				model.addRow(row);	
		}
	}
}
