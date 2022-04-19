package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ReporteList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JLabel vacunalbl;
	private JLabel enfermoslbl;
	private JPanel pnlVacunas;
	private JPanel pnlGrafico;
	private JPanel pnlEnfermedades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteList dialog = new ReporteList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteList() {
		setTitle("Listas de Reporte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReporteList.class.getResource("/img/cruz-roja.png")));
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		pnlEnfermedades = new JPanel();
		contentPanel.add(pnlEnfermedades, BorderLayout.CENTER);
		pnlEnfermedades.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlEnfermedades.add(scrollPane, BorderLayout.CENTER);
		{
			table = new JTable();
			scrollPane.setViewportView(table);
		}
		{
			pnlVacunas = new JPanel();
			contentPanel.add(pnlVacunas, BorderLayout.CENTER);
			pnlVacunas.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				pnlVacunas.add(scrollPane_1, BorderLayout.CENTER);
				{
					table_1 = new JTable();
					scrollPane_1.setViewportView(table_1);
				}
			}
		}
		{
			pnlGrafico = new JPanel();
			contentPanel.add(pnlGrafico, BorderLayout.CENTER);
			{
				vacunalbl = new JLabel("");
				pnlGrafico.add(vacunalbl);
			}
			{
				enfermoslbl = new JLabel("");
				pnlGrafico.add(enfermoslbl);
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
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JToggleButton tglbtnNewToggleButton = new JToggleButton("Enfermedades");
				tglbtnNewToggleButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//----------------------------------->>>>>>>>
						pnlVacunas.setVisible(false);
						pnlGrafico.setVisible(false);
						pnlEnfermedades.setVisible(true);
					}
				});
				menuBar.add(tglbtnNewToggleButton);
			}
			{
				JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Vacunas");
				tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//----------------------------------->>>>>>>>
						pnlVacunas.setVisible(true);
						pnlGrafico.setVisible(false);
						pnlEnfermedades.setVisible(false);
					}
				});
				menuBar.add(tglbtnNewToggleButton_1);
			}
			{
				JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Grafico de Barra");
				tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						pnlVacunas.setVisible(false);
						pnlGrafico.setVisible(true);
						pnlEnfermedades.setVisible(false);
						repaint();
					}
				});
				menuBar.add(tglbtnNewToggleButton_2);
			}
		}
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
    	//hola
    }
}
