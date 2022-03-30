package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;

public class RegVacuna extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Random rand = new Random();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegVacuna dialog = new RegVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public RegVacuna() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegVacuna.class.getResource("/img/cruz-roja.png")));
		setTitle("Registrar Vacuna");
		setBounds(100, 100, 427, 451);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 11, 62, 14);
			panel.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(10, 26, 157, 20);
			panel.add(textField);
			textField.setColumns(10);
			textField.setText("VC-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 57, 62, 14);
			panel.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(10, 71, 157, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Laboratorio:");
			lblNewLabel_2.setBounds(212, 11, 91, 14);
			panel.add(lblNewLabel_2);
			
			JComboBox<Object> comboBox = new JComboBox<Object>();
			comboBox.setBounds(210, 26, 157, 20);
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>", "Johnson & johnson", "Roche", "AbbVie", "Bayer", "Pfizer", "Bristol-Myers Squibb", "Merck & Co", "Novartis", "Sanofi"}));
			panel.add(comboBox);
			
			JLabel lblNewLabel_3 = new JLabel("Administracion:");
			lblNewLabel_3.setBounds(212, 57, 115, 14);
			panel.add(lblNewLabel_3);
			
			JComboBox<Object> comboBox_1 = new JComboBox<Object>();
			comboBox_1.setBounds(210, 71, 157, 20);
			comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>", "Intravenosa", "Intramuscular", "Subcutanea"}));
			panel.add(comboBox_1);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(0, 127, 401, 233);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 35, 157, 187);
			panel_3.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			JList<?> list = new JList<Object>();
			scrollPane.setViewportView(list);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(234, 35, 157, 187);
			panel_3.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_2.add(scrollPane_1, BorderLayout.CENTER);
			
			JList<?> list_1 = new JList<Object>();
			scrollPane_1.setViewportView(list_1);
			
			JLabel lblNewLabel_4 = new JLabel("Listado de enfermedades:");
			lblNewLabel_4.setBounds(10, 10, 157, 14);
			panel_3.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("La vacuna protege contra:");
			lblNewLabel_5.setBounds(234, 10, 157, 14);
			panel_3.add(lblNewLabel_5);
			
			JButton btnNewButton = new JButton(">");
			btnNewButton.setBounds(176, 51, 48, 23);
			panel_3.add(btnNewButton);
			
			JButton button = new JButton("<");
			button.setBounds(175, 86, 49, 23);
			panel_3.add(button);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
