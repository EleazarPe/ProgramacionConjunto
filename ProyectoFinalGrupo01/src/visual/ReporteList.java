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

import logico.Clinica;
import logico.Consulta;
import logico.Dosis;
import logico.Enfermedad;
import logico.Paciente;
import logico.Usuario;
import logico.Vacuna;

public class ReporteList extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private int totalInfectados =0;
	private int totalVacunados =0;

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
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		pnlEnfermedades = new JPanel();
		pnlEnfermedades.setBounds(5, 5, 574, 488);
		contentPanel.add(pnlEnfermedades);
		pnlEnfermedades.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 559, 488);
		pnlEnfermedades.add(scrollPane);
		{
			String headers[] = {"Codigo","Nombre","Informacion","infectados"};
			model2 = new DefaultTableModel();
			model2.setColumnIdentifiers(headers);
			table = new JTable();
		}
		table.setModel(model2);
		scrollPane.setViewportView(table);
		{
			pnlVacunas = new JPanel();
			pnlVacunas.setBounds(5, 5, 574, 488);
			contentPanel.add(pnlVacunas);
			pnlVacunas.setLayout(null);
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(5, 5, 559, 488);
				pnlVacunas.add(scrollPane_1);
				{
					String headers[] = {"Codigo","Nombre","Laboratorio","Vacunados"};
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
			pnlGrafico.setBounds(5, 5, 569, 488);
			contentPanel.add(pnlGrafico);
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
						loadTableEnfermedad();
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
						loadTableVacuna();
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
						loadValores();
					}
				});
				menuBar.add(tglbtnGrafico);
			}
		}
	}
	
    public void paint(Graphics g) {
    	super.paint(g);
    	int alto1 = totalVacunados*20;//buscaCantidadDeVacunas()
    	int alto2 = totalInfectados*20;
    	int tama = 400;
    	if(control !=false) {
	    	g.setColor(new Color(255,0,0));
	    	g.fill3DRect(250,tama-alto1, 50, alto1, true);
	    	vacunalbl.setText(""+totalVacunados);
			vacunalbl.setBounds(250, (tama-alto1)-90 , 50, 20);
	    	g.drawString("Vacuna", 250, 425);
	    	
	    	g.setColor(new Color(32,178,170));
	    	g.fill3DRect(325,tama-alto2, 50, alto2, true);
	    	enfermoslbl.setText(""+totalInfectados);
			enfermoslbl.setBounds(325, (tama-alto2)-90 , 50, 20);
	    	g.drawString("Enfermdad", 325, 425);
	    	//reporte de listas 
    	}
    	totalInfectados=0;
    	totalVacunados=0;
    }
    
    private int retornaCantEnfermedad(String nombre) {
    	int contador =0;
    	for (Consulta cons : Clinica.getInstance().getConsultas()) {
			for (Enfermedad ef : cons.getMisEnfermedads()) {
				if(ef.getNombreString().equalsIgnoreCase(nombre)) {
					contador+=1;
				}
			}	
		}
    	totalInfectados += contador;
    	return contador;
    }
    private void loadValores() {
    	totalInfectados=0;
    	totalVacunados=0;
    	for (Enfermedad ef : Clinica.getInstance().getenfermedadS()) {
    		retornaCantEnfermedad(ef.getNombreString());
    	}
    	for (Vacuna vc : Clinica.getInstance().getVacunas()) {
    		retornaCantidadVacunas(vc.getNombreString());
    	}
    	
    }
    
    private void loadTableEnfermedad(){
		model2.setRowCount(0);
		row1 = new Object[model2.getColumnCount()];
		for (Enfermedad ef : Clinica.getInstance().getenfermedadS()) {
			row1[0] = ef.getCodigoString();
			row1[1] = ef.getNombreString();
			row1[2] = ef.getInformacionString();
			row1[3] = retornaCantEnfermedad(ef.getNombreString());
			model2.addRow(row1);	
		}
    }
    
    private int retornaCantidadVacunas(String vacuna) {
    	int contador = 0;
    	for (Usuario us : Clinica.getInstance().getUsuarios()) {
			if(us instanceof Paciente) {
				for (Dosis ds : ((Paciente) us).getMisDosis()) {
					if(ds.getVacinneVacuna().getNombreString().equalsIgnoreCase(vacuna)) {
						contador +=1;
					}
				}
			}
		}
    	totalVacunados += contador;
    	return contador;
    }
    
    private void loadTableVacuna() {
    	model1.setRowCount(0);
		row2 = new Object[model1.getColumnCount()];
		for (Vacuna vc : Clinica.getInstance().getVacunas()) {
			row2[0] = vc.getCodigo();
			row2[1] = vc.getNombreString();
			row2[2] = vc.getLaboratorioString();
			row2[3]= retornaCantidadVacunas(vc.getNombreString());
			model1.addRow(row2);
		}
    }
    
}