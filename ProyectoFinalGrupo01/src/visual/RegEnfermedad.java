package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Enfermedad;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class RegEnfermedad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox<Object> comboBox;
	private JSpinner spinner;
	private JTextPane textPane;
	private Random rand = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEnfermedad dialog = new RegEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEnfermedad() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegEnfermedad.class.getResource("/img/cruz-roja.png")));
		setTitle("Registro de Enfermedad");
		setBounds(100, 100, 653, 534);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(458, 11, 59, 50);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(521, 26, 96, 21);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("EF-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 92, 59, 14);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(10, 117, 199, 21);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Tipo:");
			lblNewLabel_2.setBounds(10, 159, 59, 14);
			panel.add(lblNewLabel_2);
			
			comboBox = new JComboBox<Object>();
			comboBox.setBounds(10, 184, 199, 21);
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>", "Virus", "Bacteriana", "Hongos", "Nutricional", "Traumatica", "Genetica", "Congenita", "Mental", "Degenerativa", "Autoinmune", "Cardiovascular", "Alergica"}));
			panel.add(comboBox);
			
			JLabel lblNewLabel_3 = new JLabel("Descubierta en:");
			lblNewLabel_3.setBounds(10, 228, 91, 14);
			panel.add(lblNewLabel_3);
			
			spinner = new JSpinner();
			spinner.setModel(new SpinnerDateModel(new Date(1648935236284L), null, null, Calendar.YEAR));
			spinner.setValue(new Date());
			spinner.setEditor(new JSpinner.DateEditor(spinner,"dd/MM/yyyy"));
			spinner.setBounds(10, 261, 199, 21);
			panel.add(spinner);
			
			JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n:");
			lblNewLabel_4.setBounds(10, 317, 71, 14);
			panel.add(lblNewLabel_4);
			
			textPane = new JTextPane();
			textPane.setBounds(10, 342, 607, 97);
			panel.add(textPane);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(RegEnfermedad.class.getResource("/img/traje-de-seguridad (4).png")));
			lblNewLabel_5.setBounds(400, 117, 140, 165);
			panel.add(lblNewLabel_5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//////////////////////////////////////----------------------->>>>>>>>>
						Enfermedad nuevaEnfermedad = null;
						nuevaEnfermedad = new Enfermedad(txtCodigo.getText(), txtNombre.getText(), comboBox.getSelectedItem().toString(), textPane.getText(), (Date) spinner.getValue());
						Clinica.getInstance().insertarEnfermedad(nuevaEnfermedad);
						JOptionPane.showMessageDialog(null, "Operaci�n exitosa", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clean() {
		txtNombre.setText("");
		textPane.setText("");
		comboBox.setSelectedIndex(0);
		spinner.setValue(new Date());
		txtCodigo.setText("EF-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);
		
	}
}
