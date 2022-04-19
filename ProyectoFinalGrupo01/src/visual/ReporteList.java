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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ReporteList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table1;
	private JLabel vacunalbl;
	private JLabel enfermoslbl;
	private JPanel pnlVacunas;
	private JPanel pnlGrafico;
	private JPanel pnlEnfermedades;
	private DefaultTableModel model1;
	private Object row1[];
	private DefaultTableModel model2;
	private Object row2[];
	private boolean control = false;
	private JToggleButton tglbtnEnfermedades;
	private JToggleButton tglbtnVacuna;
	private JToggleButton tglbtnGrafico;

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
			String headers[] = {"Matricula","Eslora","Fabricacion"};
			model2 = new DefaultTableModel();
			model2.setColumnIdentifiers(headers);
			table = new JTable();
		}
		table.setModel(model2);
		scrollPane.setViewportView(table);
		{
			//probando
			pnlVacunas = new JPanel();
			contentPanel.add(pnlVacunas, BorderLayout.CENTER);
			pnlVacunas.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				pnlVacunas.add(scrollPane_1, BorderLayout.CENTER);
				{
					String headers[] = {"Matricula","Eslora","Fabricacion"};
					model1 = new DefaultTableModel();
					model1.setColumnIdentifiers(headers);
					table1 = new JTable();
					table1.setModel(model1);
					scrollPane_1.setViewportView(table1);
				}
			}
		}
		{
			pnlGrafico = new JPanel();
			contentPanel.add(pnlGrafico, BorderLayout.CENTER);
			pnlGrafico.setLayout(null);
			{
				vacunalbl = new JLabel("10");
				vacunalbl.setVisible(false);
				//vacunalbl.setBounds(158, 102, 12, 14);
				pnlGrafico.add(vacunalbl);
			}
			{
				enfermoslbl = new JLabel("10");
				enfermoslbl.setVisible(false);
				//enfermoslbl.setBounds(461, 102, 12, 14);
				pnlGrafico.add(enfermoslbl);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
				tglbtnEnfermedades = new JToggleButton("Enfermedades");
				tglbtnEnfermedades.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//----------------------------------->>>>>>>>
						tglbtnGrafico.setSelected(false);
						tglbtnVacuna.setSelected(false);
						pnlVacunas.setVisible(false);
						pnlGrafico.setVisible(false);
						pnlEnfermedades.setVisible(true);
						control = false;
					}
				});
				menuBar.add(tglbtnEnfermedades);
			}
			{
				tglbtnVacuna = new JToggleButton("Vacunas");
				tglbtnVacuna.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//----------------------------------->>>>>>>>
						tglbtnEnfermedades.setSelected(false);
						tglbtnGrafico.setSelected(false);
						pnlVacunas.setVisible(true);
						pnlGrafico.setVisible(false);
						pnlEnfermedades.setVisible(false);
						control = false;
					}
				});
				menuBar.add(tglbtnVacuna);
			}
			{
				tglbtnGrafico = new JToggleButton("Grafico de Barra");
				tglbtnGrafico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tglbtnEnfermedades.setSelected(false);
						tglbtnVacuna.setSelected(false);
						pnlVacunas.setVisible(false);
						pnlGrafico.setVisible(true);
						pnlEnfermedades.setVisible(false);
						control = true;
						vacunalbl.setVisible(true);
						enfermoslbl.setVisible(true);
						repaint();
					}
				});
				menuBar.add(tglbtnGrafico);
			}
		}
	}
	
    public void paint(Graphics g) {
    	super.paint(g);
    	int alto1 = 4*20;//buscaCantidadDeVacunas()
    	int alto2 = 10*20;
    	int tama = 400;
    	if(control !=false) {
	    	g.setColor(new Color(255,0,0));
	    	g.fill3DRect(250,tama-alto1, 50, alto1, true);
	    	//vacunalbl.setText("100");
			vacunalbl.setBounds(250, (tama-alto1)-90 , 50, 20);
	    	g.drawString("Vacuna", 250, 425);
	    	
	    	g.setColor(new Color(32,178,170));
	    	g.fill3DRect(325,tama-alto2, 50, alto2, true);
			enfermoslbl.setBounds(325, (tama-alto2)-90 , 50, 20);
	    	g.drawString("Enfermdad", 325, 425);
    	}
    	//(32,178,170)
    }
    
}
