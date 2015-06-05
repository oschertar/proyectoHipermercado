package hipermercadoGUI;

import hipermercado.Alimentacion;
import hipermercado.Hipermercado;
import hipermercado.ListaProductos;
import hipermercado.Producto;
import hipermercado.ProductoYaExistenteException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VerVideojuegos extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static final long serialVersionUID = 1L;
	
	private JTextField txtBarras;
	private JTextField txtPrecio;
	private final ButtonGroup buttonGroupMarcas = new ButtonGroup();
	
	
	
	private Hipermercado hipermercadoVideojuegos;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private int indice = 0;
	private JRadioButton rdbtnPS4;
	private JRadioButton rdbtnXBOX;
	private JRadioButton rdbtnWii;
	private JTextField txtExistencias;
	private Alimentacion carne;
	private Alimentacion pan;
	private Alimentacion pescado;

	/**
	 * Create the dialog.
	 */
	public VerVideojuegos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				limpiar();
			}
		});
		setTitle("Buscar por Videojuegos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerVideojuegos.class.getResource("/img/videojuegos.png")));
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de barras");
		lblCdigoDeBarras.setBounds(174, 20, 122, 14);
		contentPanel.add(lblCdigoDeBarras);

		txtBarras = new JTextField();
		txtBarras.setBackground(Color.DARK_GRAY);
		txtBarras.setEnabled(false);
		txtBarras.setEditable(false);
		txtBarras.setBounds(306, 20, 86, 20);
		contentPanel.add(txtBarras);
		txtBarras.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(174, 83, 46, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBackground(Color.DARK_GRAY);
		txtPrecio.setEnabled(false);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(306, 80, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		JPanel panelTipo = new JPanel();
		panelTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Elige", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipo.setBounds(21, 20, 121, 98);
		contentPanel.add(panelTipo);
		panelTipo.setLayout(null);

		rdbtnPS4 = new JRadioButton("PS4");
		rdbtnPS4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.PS4);
					if (hipermercadoVideojuegos.get(0) != null) {
						mostrarProducto(hipermercadoVideojuegos.get(indice));
						comprobarTamaño();
						botonSiguiente.setVisible(true);
						botonAnterior.setVisible(true);
					} else {
						limpiar();
					}
				} catch (ProductoYaExistenteException e2) {
					JOptionPane.showMessageDialog(contentPanel,
							"Producto ya existente", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		buttonGroupMarcas.add(rdbtnPS4);
		rdbtnPS4.setBounds(6, 16, 109, 23);
		panelTipo.add(rdbtnPS4);

		rdbtnXBOX = new JRadioButton("Xbox ONE");
		rdbtnXBOX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.XBOXONE);
					if (hipermercadoVideojuegos.get(0) != null) {
						mostrarProducto(hipermercadoVideojuegos.get(indice));
						comprobarTamaño();
						botonSiguiente.setVisible(true);
						botonAnterior.setVisible(true);
					} else {
						limpiar();
					}
				} catch (ProductoYaExistenteException e4) {
					JOptionPane.showMessageDialog(contentPanel,
							"Producto ya existente", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonGroupMarcas.add(rdbtnXBOX);
		rdbtnXBOX.setBounds(6, 42, 109, 23);
		panelTipo.add(rdbtnXBOX);

		rdbtnWii = new JRadioButton("Wii");
		rdbtnWii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.WII);
					if (hipermercadoVideojuegos.get(0) != null) {
						mostrarProducto(hipermercadoVideojuegos.get(indice));
						comprobarTamaño();
						botonSiguiente.setVisible(true);
						botonAnterior.setVisible(true);
					} else {
						limpiar();
					}
				} catch (ProductoYaExistenteException e3) {
					JOptionPane.showMessageDialog(contentPanel,
							"Producto ya existente", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonGroupMarcas.add(rdbtnWii);
		rdbtnWii.setBounds(6, 68, 109, 23);
		panelTipo.add(rdbtnWii);

		JLabel lblExistencias = new JLabel("Existencias");
		lblExistencias.setBounds(174, 152, 86, 14);
		contentPanel.add(lblExistencias);

		txtExistencias = new JTextField();
		txtExistencias.setBackground(Color.DARK_GRAY);
		txtExistencias.setEnabled(false);
		txtExistencias.setEditable(false);
		txtExistencias.setBounds(306, 149, 86, 20);
		contentPanel.add(txtExistencias);
		txtExistencias.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						limpiar();
					}
				});

				botonAnterior = new JButton("<");
				botonAnterior.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mostrarAnterior();
					}
				});
				buttonPane.add(botonAnterior);

				botonSiguiente = new JButton(">");
				botonSiguiente.setVisible(false);
				botonAnterior.setVisible(false);
				botonSiguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mostrarSiguiente();
					}
				});
				buttonPane.add(botonSiguiente);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void limpiar() {
		txtBarras.setText("");
		txtPrecio.setText("");
		txtExistencias.setText("");
		botonAnterior.setVisible(false);
		botonSiguiente.setVisible(false);
		

	}

	private void mostrarSiguiente() {
		mostrarProducto(hipermercadoVideojuegos.get(++indice));
		comprobarTamaño();
	}

	private void mostrarAnterior() {
		mostrarProducto(hipermercadoVideojuegos.get(--indice));
		comprobarTamaño();

	}

	private void mostrarProducto(Producto producto) {
		txtBarras.setText(producto.getCodigoBarras());
		
		txtPrecio.setText(Float.toString(producto.getPrecio()));
		txtExistencias.setText(Integer.toString(producto.getExistencias()));

		
	}

	private void generarHipermercado(ListaProductos producto)
			throws ProductoYaExistenteException {
		hipermercadoVideojuegos = new Hipermercado();
		for (Producto productoAux : General.hipermercado.hipermercado) {
			if ((productoAux).getNombre().equals(producto))
				hipermercadoVideojuegos.annadir(productoAux, productoAux.getCodigoBarras());
		}
	}

	private void comprobarTamaño() {
		if (hipermercadoVideojuegos.get(indice + 1) != null)
			botonSiguiente.setEnabled(true);
		else
			botonSiguiente.setEnabled(false);

		if (hipermercadoVideojuegos.get(indice - 1) != null)
			botonAnterior.setEnabled(true);
		else
			botonAnterior.setEnabled(false);
	}
}