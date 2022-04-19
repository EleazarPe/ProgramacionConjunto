package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Paciente;
import logico.Usuario;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlGraficoBarra extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel vacunalbl;
	private JLabel enfermoslbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ControlGraficoBarra dialog = new ControlGraficoBarra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ControlGraficoBarra() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ControlGraficoBarra.class.getResource("/img/cruz-roja.png")));
		setTitle("Grafico del Control");
		setBounds(100, 100, 341, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				vacunalbl = new JLabel("100");
				panel.add(vacunalbl);
			}
			{
				enfermoslbl = new JLabel("100");
				panel.add(enfermoslbl);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		repaint();
	}
	
	public int buscaCantidadDeVacunas() {
		int cantidad = 0;
		for (Usuario paciente : Clinica.getInstance().getUsuarios()) {
			if(paciente instanceof Paciente) {
				cantidad += ((Paciente) paciente).getMisDosis().size();
			}
		}
		return cantidad;
	}
	
	
    public void paint(Graphics g) {
    	super.paint(g);
    	int alto1 = 13*10;//buscaCantidadDeVacunas()
    	int alto2 = 4*10;
    	int tama = 200;
    	
    	g.setColor(new Color(255,0,0));
    	g.fill3DRect(100,tama-alto1, 50, alto1, true);
		vacunalbl.setBounds(100, (tama-alto1)-60 , 50, 20);
    	g.drawString("Vacuna", 100, 225);
    	
    	g.setColor(new Color(32,178,170));
    	g.fill3DRect(180,tama-alto2, 50, alto2, true);
		enfermoslbl.setBounds(180, (tama-alto2)-60 , 50, 20);
    	g.drawString("Enfermos", 180, 225);
    	
    	//(32,178,170)
    }

}
