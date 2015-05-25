package hipermercadoGUI;

import hipermercado.Fichero;
import hipermercado.Hipermercado;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;


import javax.swing.filechooser.FileNameExtensionFilter;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PrincipalGUI {

	private JFrame frmHipermercadoGuadalquivir;
	private JFrame frmConcesionario;
	
	private Ayuda ayuda = new Ayuda();
	//private AcercaDe acercade = new AcercaDe();
	private JFrame nuevo = new JFrame();
	
	private JFileChooser filechooser = new JFileChooser();
	@SuppressWarnings("unused")
	private JMenuItem mntmNmeroTotalDe;
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter(
			"Archivos .obj", "obj");
	protected File archivoNuevo;
	protected File file;
	private File rutaFichero;
	private final JPanel contentPanel = new JPanel();
	private ComprarProductos comprarproductos = new ComprarProductos();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI window = new PrincipalGUI();
					window.frmHipermercadoGuadalquivir.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHipermercadoGuadalquivir = new JFrame();
		frmHipermercadoGuadalquivir.setResizable(false);
		
		frmHipermercadoGuadalquivir.setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalGUI.class.getResource("/img/icono.png")));
		frmHipermercadoGuadalquivir.getContentPane().setBackground(Color.WHITE);
		frmHipermercadoGuadalquivir.setTitle("Hipermercado Guadalquivir");
		frmHipermercadoGuadalquivir.setBounds(100, 100, 457, 319);
		frmHipermercadoGuadalquivir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmHipermercadoGuadalquivir.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/nuevo.png")));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		mnInicio.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/abrir.png")));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mnInicio.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/guardar.png")));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mnInicio.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como");
		mntmGuardarComo.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/guardarcomo.jpg")));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnInicio.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnInicio.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/salir.jpg")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnInicio.add(mntmSalir);
		
		JMenu mnComercio = new JMenu("Comercio");
		menuBar.add(mnComercio);
		
		JMenuItem mntmAadirProducto = new JMenuItem("Comprar productos");
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprarproductos.setVisible(true);
			}
		});
		mntmAadirProducto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmAadirProducto.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/comprar.png")));
		mnComercio.add(mntmAadirProducto);
		
		JMenuItem mntmVenderProductos = new JMenuItem("Vender productos");
		mntmVenderProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmVenderProductos.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/vender.png")));
		mnComercio.add(mntmVenderProductos);
		
		JMenu mnVisor = new JMenu("B\u00FAsqueda");
		menuBar.add(mnVisor);
		
		JMenuItem mntmMostrarHipermercado = new JMenuItem("Mostrar Hipermercado");
		mntmMostrarHipermercado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmMostrarHipermercado.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/mostrar.png")));
		mnVisor.add(mntmMostrarHipermercado);
		
		JMenu mnPorZona = new JMenu("Por Zona");
		mnPorZona.setMnemonic('Z');
		mnPorZona.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/zonas.png")));
		mnVisor.add(mnPorZona);
		
		JMenuItem mntmDeportes = new JMenuItem("Ropa");
		mntmDeportes.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/ropa.gif")));
		mnPorZona.add(mntmDeportes);
		
		JMenuItem mntmTecnologa = new JMenuItem("Tecnolog\u00EDa");
		mntmTecnologa.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/tecnologia.gif")));
		mnPorZona.add(mntmTecnologa);
		
		JMenuItem mntmAlimentacin = new JMenuItem("Alimentaci\u00F3n");
		mntmAlimentacin.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/alimentacion.png")));
		mnPorZona.add(mntmAlimentacin);
		
		JMenuItem mntmFrutera = new JMenuItem("Fruter\u00EDa");
		mntmFrutera.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/fruteria.png")));
		mnPorZona.add(mntmFrutera);
		
		JMenuItem mntmVideojuegos = new JMenuItem("Videojuegos");
		mntmVideojuegos.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/videojuegos.png")));
		mnPorZona.add(mntmVideojuegos);
		
		JMenuItem mntmPorCdigoDe = new JMenuItem("Por c\u00F3digo de barras");
		mntmPorCdigoDe.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/codigobarras.jpg")));
		mnVisor.add(mntmPorCdigoDe);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVerLaAyuda = new JMenuItem("Ver la ayuda");
		mntmVerLaAyuda.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/ayuda.jpeg")));
		mntmVerLaAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmVerLaAyuda);
		frmHipermercadoGuadalquivir.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmHipermercadoGuadalquivir.getContentPane().add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel.setLayout(fl_panel);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		button_1.setToolTipText("Nuevo");
		button_1.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/nuevo.png")));
		panel.add(button_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		btnNewButton.setToolTipText("Abrir");
		btnNewButton.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/abrir.png")));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnNewButton_1.setToolTipText("Guardar");
		btnNewButton_1.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/guardar.png")));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		btnNewButton_2.setToolTipText("Guardar Como");
		btnNewButton_2.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/guardarcomo.jpg")));
		panel.add(btnNewButton_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		button.setToolTipText("Salir");
		button.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/salir.jpg")));
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frmHipermercadoGuadalquivir.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/img/logo.png")));
		label.setBounds(58, 11, 431, 260);
		panel_1.add(label);
	}
	private boolean guardar() {
		if (rutaFichero != null)
			return almacenar();
		else
			return guardarComo();
	}

	private boolean almacenar() {
		try {
			File archivo=filechooser.getSelectedFile();
			Fichero.guardar(archivo,
					General.hipermercado);
			General.hipermercado.setModificado(false);
			filechooser.setFileFilter(filtro);
			rutaFichero = archivo;
			frmConcesionario.setTitle(rutaFichero.getName() + " - Concesionario");
			
			return true;
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "No se ha podido guardar",
					"Error", JOptionPane.ERROR_MESSAGE);
			
			
		}
		return false;
	}

	private boolean guardarComo() {
		filechooser.setFileFilter(filtro);
		int opcion = filechooser.showSaveDialog(frmConcesionario);
		if (opcion == JFileChooser.APPROVE_OPTION)
			if (sobreescribir(filechooser.getSelectedFile()))
				return almacenar();
		return false;
	}

	protected boolean sobreescribir(File fileAux) {

		int opcion;
		if (fileAux.exists()) {
			opcion = JOptionPane.showConfirmDialog(frmConcesionario,
					"¿Sobreescribir?", "Guardar",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				return true;

			default:
				return false;
			}
		}
		return true;

	}

	private void nuevo() {
		
		if (General.hipermercado.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo,
					"¿Deseas guardar el concesionario?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(frmConcesionario);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(file, General.hipermercado);
					} catch (IOException e) {

						JOptionPane.showMessageDialog(null, "No se ha podido guardar",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				General.hipermercado = new Hipermercado();
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else
				General.hipermercado = new Hipermercado();
		} else
			General.hipermercado = new Hipermercado();
		
		frmHipermercadoGuadalquivir.setTitle("Sin_titulo.obj");
	}

	private void abrir() {
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(filtro);
		int opcion = abrir.showOpenDialog(frmConcesionario);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			
		try {
			General.hipermercado = (hipermercado.Hipermercado) Fichero
					.abrir(abrir.getSelectedFile());
			rutaFichero = abrir.getSelectedFile();
			frmConcesionario.setTitle(rutaFichero.getAbsolutePath() + " - Concesionario");
		} catch (ClassNotFoundException | IOException e1) {
			JOptionPane.showMessageDialog(null, "No se ha podido abrir",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

		}
		
	}

	private void salir() {
		int opcion = JOptionPane.showConfirmDialog(frmConcesionario, "¿Quieres guardar antes de salir");
		if(opcion ==JOptionPane.CANCEL_OPTION){
			return;
			
		}else if(opcion == JOptionPane.YES_OPTION){
			guardar();
		}else
			System.exit(0);
	}
}
