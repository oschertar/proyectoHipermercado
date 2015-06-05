package hipermercadoGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class AcercaDe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setResizable(false);
		setModal(true);
		setTitle("Acerca de");
		setBounds(100, 100, 417, 207);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnAcercaDeHipermecado = new JTextPane();
		txtpnAcercaDeHipermecado.setEditable(false);
		txtpnAcercaDeHipermecado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtpnAcercaDeHipermecado.setBackground(SystemColor.menu);
		txtpnAcercaDeHipermecado.setText("Acerca de \"Hipermercado Guadalquivir\"\r\nv1.0\r\nDesarrollado por \u00D3scar Heredia Tartajo\r\nAlumno 1\u00BA DAW I.E.S. Gran Capit\u00E1n\r\n\u00A9Copyright. All rights reserved.\r\n");
		txtpnAcercaDeHipermecado.setBounds(10, 11, 376, 207);
		contentPanel.add(txtpnAcercaDeHipermecado);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Atr\u00E1s");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
