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
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RegEnfermedad extends JDialog {


	private Image img_logo = new ImageIcon(RegEnfermedad.class.getResource("/img/TablaEnfermedades.jpg")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox<Object> comboBox;
	private JSpinner spinner;
	private JTextPane textPane;
	private Random rand = new Random();
	private JSlider sliderPorcentaje;
	private JLabel TxtValor;
	private JLabel advertencia2;
	private JLabel advertencia1;
	private JLabel advertencia3;
	private JLabel MensajeAdvertencia;
	private JLabel advertencia4;

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
		setBounds(100, 100, 681, 616);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("Código:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 32, 59, 50);
			panel.add(lblNewLabel);

			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(73, 47, 96, 21);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("EF-"+ rand.nextInt(10) + 1+rand.nextInt(10) + 1+rand.nextInt(10) + 1);

			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(20, 94, 59, 14);
			panel.add(lblNewLabel_1);

			txtNombre = new JTextField();
			txtNombre.setBounds(20, 117, 238, 21);
			panel.add(txtNombre);
			txtNombre.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Tipo:");
			lblNewLabel_2.setBounds(20, 161, 59, 14);
			panel.add(lblNewLabel_2);

			comboBox = new JComboBox<Object>();
			comboBox.setBounds(20, 184, 238, 21);
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>", "Virus", "Bacteriana", "Hongos", "Nutricional", "Traumatica", "Genética", "Congenita", "Mental", "Degenerativa", "Autoinmune", "Cardiovascular", "Alérgica"}));
			panel.add(comboBox);

			JLabel lblNewLabel_3 = new JLabel("Descubierta en:");
			lblNewLabel_3.setBounds(20, 236, 91, 14);
			panel.add(lblNewLabel_3);

			spinner = new JSpinner();
			spinner.setModel(new SpinnerDateModel(new Date(1648935236284L), null, null, Calendar.YEAR));
			spinner.setValue(new Date());
			spinner.setEditor(new JSpinner.DateEditor(spinner,"dd/MM/yyyy"));
			spinner.setBounds(20, 261, 238, 21);
			panel.add(spinner);

			JLabel lblNewLabel_4 = new JLabel("Descripción:");
			lblNewLabel_4.setBounds(20, 319, 71, 14);
			panel.add(lblNewLabel_4);

			textPane = new JTextPane();
			textPane.setBounds(10, 344, 325, 148);
			panel.add(textPane);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Tasa de Transmisibilidad:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(391, 244, 250, 248);
			panel.add(panel_1);

			TxtValor = new JLabel("");
			TxtValor.setBounds(430, 501, 173, 22);
			panel.add(TxtValor);


			sliderPorcentaje = new JSlider();
			sliderPorcentaje.setSnapToTicks(true);

			sliderPorcentaje.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent evt) {
					//int valor = sliderPorcentaje.getValue();
					TxtValor.setText("Tasa de transmisibilidad: " + String.valueOf(sliderPorcentaje.getValue()));
					//System.out.println("El valor del deslizador es: " + sliderPorcentaje.getValue());
				}
			});
			panel_1.add(sliderPorcentaje);
			sliderPorcentaje.setPaintTicks(true);
			sliderPorcentaje.setPaintLabels(true);
			sliderPorcentaje.setValue(0);
			sliderPorcentaje.setOrientation(SwingConstants.VERTICAL);
			sliderPorcentaje.setToolTipText("");
			sliderPorcentaje.setMajorTickSpacing (20);
			sliderPorcentaje.setMinorTickSpacing(20);
			JLabel LblLogo = new JLabel("");
			LblLogo.setBounds(414, 31, 205, 200);
			panel.add(LblLogo);
			LblLogo.setIcon(new ImageIcon(img_logo));

			advertencia1 = new JLabel("");
			advertencia1.setIcon(new ImageIcon(RegEnfermedad.class.getResource("/img/signo-advertencia.png")));
			advertencia1.setBounds(5, 94, 16, 14);
			advertencia1.setVisible(false);
			panel.add(advertencia1);

			advertencia2 = new JLabel("");
			advertencia2.setIcon(new ImageIcon(RegEnfermedad.class.getResource("/img/signo-advertencia.png")));
			advertencia2.setBounds(5, 161, 16, 14);
			advertencia2.setVisible(false);
			panel.add(advertencia2);

			advertencia3 = new JLabel("");
			advertencia3.setIcon(new ImageIcon(RegEnfermedad.class.getResource("/img/signo-advertencia.png")));
			advertencia3.setBounds(5, 319, 16, 14);
			advertencia3.setVisible(false);
			panel.add(advertencia3);

			MensajeAdvertencia = new JLabel("Los Campos con     son Obligatorios");
			MensajeAdvertencia.setFont(new Font("Tahoma", Font.BOLD, 14));
			MensajeAdvertencia.setBounds(41, 503, 263, 22);
			MensajeAdvertencia.setVisible(false);
			panel.add(MensajeAdvertencia);

			advertencia4 = new JLabel("");
			advertencia4.setIcon(new ImageIcon(RegEnfermedad.class.getResource("/img/signo-advertencia.png")));
			advertencia4.setBounds(159, 509, 16, 14);
			advertencia4.setVisible(false);
			panel.add(advertencia4);



		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if (txtNombre.getText().equals("") || comboBox.getSelectedItem().equals("<Seleccione>") || textPane.getText().equals(""))
						{
							advertecnia();
							
						}else {

							Enfermedad nuevaEnfermedad = null;
							nuevaEnfermedad = new Enfermedad(txtCodigo.getText(), txtNombre.getText(), comboBox.getSelectedItem().toString(), textPane.getText(),
									(Date) spinner.getValue(),sliderPorcentaje.getValue());
							Clinica.getInstance().insertarEnfermedad(nuevaEnfermedad);
							JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
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
					public void actionPerformed(ActionEvent arg0) {
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea cancelar?", "Confirmación",JOptionPane.YES_NO_OPTION);
						if(respuesta==JOptionPane.YES_OPTION) {
							dispose();
						}
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

	private void advertecnia() {
		Toolkit tk = Toolkit.getDefaultToolkit ();
		advertencia1.setVisible(true);
		advertencia2.setVisible(true);
		advertencia3.setVisible(true);
		advertencia4.setVisible(true);
		MensajeAdvertencia.setVisible(true);
		tk.beep();
	}

}
