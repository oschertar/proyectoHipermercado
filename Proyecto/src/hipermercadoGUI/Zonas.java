package hipermercadoGUI;

import hipermercado.ListaProductos;
import hipermercado.Producto;
import hipermercado.Zona;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Zonas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel alimentacion;
	private JLabel ropa;
	private JLabel videojuegos;
	private JLabel tecnologia;
	private JLabel fruteria;
	Producto producto;
	private Zona zona;
	
	void setZona(Zona zona){
		this.zona=zona;
	}
	
	
	/**
	 * Create the dialog.
	 */
	public Zonas() {
		setTitle("Zonas");
		setModal(true);
		setBounds(100, 100, 714, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		fruteria = new JLabel("");
		fruteria.setEnabled(false);
		fruteria.setIcon(new ImageIcon(Zonas.class.getResource("/img/zonas/fruteria.PNG")));
		fruteria.setBounds(29, 53, 173, 155);
		contentPanel.add(fruteria);
		
		alimentacion = new JLabel("");
		alimentacion.setEnabled(false);
		alimentacion.setIcon(new ImageIcon(Zonas.class.getResource("/img/zonas/alimentacion.PNG")));
		alimentacion.setBounds(212, 53, 469, 157);
		contentPanel.add(alimentacion);
		
		ropa = new JLabel("");
		ropa.setEnabled(false);
		ropa.setIcon(new ImageIcon(Zonas.class.getResource("/img/zonas/ropa.PNG")));
		ropa.setBounds(28, 215, 197, 170);
		contentPanel.add(ropa);
		
		videojuegos = new JLabel("");
		videojuegos.setEnabled(false);
		videojuegos.setIcon(new ImageIcon(Zonas.class.getResource("/img/zonas/videojuegos.PNG")));
		videojuegos.setBounds(230, 215, 168, 169);
		contentPanel.add(videojuegos);
		
		tecnologia = new JLabel("");
		tecnologia.setEnabled(false);
		tecnologia.setIcon(new ImageIcon(Zonas.class.getResource("/img/zonas/tecnologia.PNG")));
		tecnologia.setBounds(403, 215, 285, 170);
		contentPanel.add(tecnologia);
		
		JLabel lblZonasDelHipermercado = new JLabel("Zonas del hipermercado");
		lblZonasDelHipermercado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZonasDelHipermercado.setBounds(242, 24, 181, 19);
		contentPanel.add(lblZonasDelHipermercado);
		
		
	}
	
	
protected void getZona(Zona zona) {
	
		switch(zona){
		case TECNOLOGIA:
			tecnologia.setEnabled(true);
			alimentacion.setEnabled(false);
			fruteria.setEnabled(false);
			ropa.setEnabled(false);
			videojuegos.setEnabled(false);
		
			break;
		case ALIMENTACION:
			tecnologia.setEnabled(false);
			alimentacion.setEnabled(true);
			fruteria.setEnabled(false);
			ropa.setEnabled(false);
			videojuegos.setEnabled(false);
			break;
		case FRUTERIA:
			tecnologia.setEnabled(false);
			alimentacion.setEnabled(false);
			fruteria.setEnabled(true);
			ropa.setEnabled(false);
			videojuegos.setEnabled(false);
			break;
		case ROPA:
			tecnologia.setEnabled(false);
			alimentacion.setEnabled(false);
			fruteria.setEnabled(false);
			ropa.setEnabled(true);
			videojuegos.setEnabled(false);
			break;
		case VIDEOJUEGOS:
			tecnologia.setEnabled(false);
			alimentacion.setEnabled(false);
			fruteria.setEnabled(false);
			ropa.setEnabled(false);
			videojuegos.setEnabled(true);
			break;
		}
		
		
		
		

	
	
}



}
	
			/*break;
		case TECNOLOGIA:
			tecnologia.setEnabled(true);
			break;
		case FRUTERIA:
			fruteria.setEnabled(true);
			break;
		case ROPA:
			ropa.setEnabled(true);
			break;
		case VIDEOJUEGOS:
			videojuegos.setEnabled(true);
			break;

		default:
			break;
		}*/
		
			
		
	


