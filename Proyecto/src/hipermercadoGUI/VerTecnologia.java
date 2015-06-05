package hipermercadoGUI;

import hipermercado.Alimentacion;
import hipermercado.Hipermercado;
import hipermercado.ListaProductos;
import hipermercado.Producto;
import hipermercado.ProductoYaExistenteException;
import hipermercado.Tecnologia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

public class VerTecnologia extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static final long serialVersionUID = 1L;
	
	private JTextField txtBarras;
	private JTextField txtPrecio;
	private final ButtonGroup buttonGroupTecnologia = new ButtonGroup();
	
	
	
	private Hipermercado hipermercadoTecnologia;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private int indice = 0;
	private JRadioButton rdbtnPortatil;
	private JRadioButton rdbtnSobremesa;
	private JRadioButton rdbtnTV;
	private JTextField txtExistencias;
	private Alimentacion carne;
	private Alimentacion pan;
	private Alimentacion pescado;
	private JLabel lblFabricante;
	private JTextField txtFabricante;

	/**
	 * Create the dialog.
	 */
	public VerTecnologia() {
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

		rdbtnPortatil = new JRadioButton("Port\u00E1til");
		rdbtnPortatil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.PORTÁTIL);
					if (hipermercadoTecnologia.get(0) != null) {
						mostrarProducto(hipermercadoTecnologia.get(indice));
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
		buttonGroupTecnologia.add(rdbtnPortatil);
		rdbtnPortatil.setBounds(6, 16, 109, 23);
		panelTipo.add(rdbtnPortatil);

		rdbtnSobremesa = new JRadioButton("Sobremesa");
		rdbtnSobremesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.SOBREMESA);
					if (hipermercadoTecnologia.get(0) != null) {
						mostrarProducto(hipermercadoTecnologia.get(indice));
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
		buttonGroupTecnologia.add(rdbtnSobremesa);
		rdbtnSobremesa.setBounds(6, 42, 109, 23);
		panelTipo.add(rdbtnSobremesa);

		rdbtnTV = new JRadioButton("TV");
		rdbtnTV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.TV);
					if (hipermercadoTecnologia.get(0) != null) {
						mostrarProducto(hipermercadoTecnologia.get(indice));
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
		buttonGroupTecnologia.add(rdbtnTV);
		rdbtnTV.setBounds(6, 68, 109, 23);
		panelTipo.add(rdbtnTV);

		JLabel lblExistencias = new JLabel("Existencias");
		lblExistencias.setBounds(174, 138, 86, 14);
		contentPanel.add(lblExistencias);

		txtExistencias = new JTextField();
		txtExistencias.setBackground(Color.DARK_GRAY);
		txtExistencias.setEnabled(false);
		txtExistencias.setEditable(false);
		txtExistencias.setBounds(306, 135, 86, 20);
		contentPanel.add(txtExistencias);
		txtExistencias.setColumns(10);
		
		lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(174, 189, 86, 14);
		contentPanel.add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setBackground(Color.DARK_GRAY);
		txtFabricante.setEnabled(false);
		txtFabricante.setEditable(false);
		txtFabricante.setBounds(306, 186, 86, 20);
		contentPanel.add(txtFabricante);
		txtFabricante.setColumns(10);
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
		txtFabricante.setText("");
		

	}

	private void mostrarSiguiente() {
		mostrarProducto(hipermercadoTecnologia.get(++indice));
		comprobarTamaño();
	}

	private void mostrarAnterior() {
		mostrarProducto(hipermercadoTecnologia.get(--indice));
		comprobarTamaño();

	}

	private void mostrarProducto(Producto producto) {
		txtBarras.setText(producto.getCodigoBarras());
		txtPrecio.setText(Float.toString(producto.getPrecio()));
		txtExistencias.setText(Integer.toString(producto.getExistencias()));
		txtFabricante.setText(((Tecnologia) producto).getFabricante().toString());

		
	}

	private void generarHipermercado(ListaProductos producto)
			throws ProductoYaExistenteException {
		hipermercadoTecnologia = new Hipermercado();
		for (Producto productoAux : General.hipermercado.hipermercado) {
			if ((productoAux).getNombre().equals(producto))
				hipermercadoTecnologia.annadir(productoAux, productoAux.getCodigoBarras());
		}
	}

	private void comprobarTamaño() {
		if (hipermercadoTecnologia.get(indice + 1) != null)
			botonSiguiente.setEnabled(true);
		else
			botonSiguiente.setEnabled(false);

		if (hipermercadoTecnologia.get(indice - 1) != null)
			botonAnterior.setEnabled(true);
		else
			botonAnterior.setEnabled(false);
	}
}
