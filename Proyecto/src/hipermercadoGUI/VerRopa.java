package hipermercadoGUI;

import hipermercado.Camiseta;
import hipermercado.Fruteria;
import hipermercado.Hipermercado;
import hipermercado.ListaProductos;
import hipermercado.Marca;
import hipermercado.Producto;
import hipermercado.ProductoYaExistenteException;
import hipermercado.Ropa;
import hipermercado.Zapatillas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VerRopa extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtBarras;
	private JTextField txtPrecio;
	private final ButtonGroup buttonGroupMarcas = new ButtonGroup();
	private final ButtonGroup buttonGroupTipoRopa = new ButtonGroup();
	private JTextField txtTalla;
	protected Ropa camiseta;
	protected Ropa pantalon;
	protected Ropa zapatillas;
	protected Marca nike;
	protected Marca adidas;
	protected Marca reebok;
	private JRadioButton rdbtnCamisetas;
	private JRadioButton rdbtnPantalones;
	private JRadioButton rdbtnZapatillas;
	private Hipermercado hipermercadoRopa;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private int indice = 0;
	private JRadioButton rdbtnAdidas;
	private JRadioButton rdbtnNike;
	private JRadioButton rdbtnReebok;
	private JTextField txtExistencias;

	/**
	 * Create the dialog.
	 */
	public VerRopa() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
			}
		});
		setTitle("Buscar por Ropa");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VerRopa.class.getResource("/img/ropa.gif")));
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Elige",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(16, 20, 121, 98);
		contentPanel.add(panel);
		panel.setLayout(null);

		rdbtnCamisetas = new JRadioButton("Camisetas");
		rdbtnCamisetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generarHipermercado(hipermercado.ListaProductos.CAMISETA);
					if (hipermercadoRopa.get(0) != null) {
						mostrarProducto(hipermercadoRopa.get(indice));
						comprobarTamaño();
						botonSiguiente.setVisible(true);
						botonAnterior.setVisible(true);
					} else {
						limpiar();
					}
				} catch (ProductoYaExistenteException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});

		buttonGroupTipoRopa.add(rdbtnCamisetas);
		rdbtnCamisetas.setBounds(6, 16, 109, 23);
		panel.add(rdbtnCamisetas);

		rdbtnPantalones = new JRadioButton("Pantalones");
		rdbtnPantalones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generarHipermercado(hipermercado.ListaProductos.PANTALÓN);
					if (hipermercadoRopa.get(0) != null) {
						mostrarProducto(hipermercadoRopa.get(indice));
						comprobarTamaño();
						botonSiguiente.setVisible(true);
						botonAnterior.setVisible(true);
					} else {
						limpiar();
					}
				} catch (ProductoYaExistenteException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				
			}
		});

		buttonGroupTipoRopa.add(rdbtnPantalones);
		rdbtnPantalones.setBounds(6, 42, 109, 23);
		panel.add(rdbtnPantalones);

		rdbtnZapatillas = new JRadioButton("Zapatillas");
		rdbtnZapatillas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generarHipermercado(hipermercado.ListaProductos.ZAPATILLAS);
					if (hipermercadoRopa.get(0) != null) {
						mostrarProducto(hipermercadoRopa.get(indice));
						comprobarTamaño();
						botonSiguiente.setVisible(true);
						botonAnterior.setVisible(true);
					} else {
						limpiar();
					}
				} catch (ProductoYaExistenteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
		});

		buttonGroupTipoRopa.add(rdbtnZapatillas);
		rdbtnZapatillas.setBounds(6, 68, 109, 23);
		panel.add(rdbtnZapatillas);

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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Marcas",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(16, 129, 121, 98);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		rdbtnAdidas = new JRadioButton("Adidas");
		rdbtnAdidas.setEnabled(false);
		
		buttonGroupMarcas.add(rdbtnAdidas);
		rdbtnAdidas.setBounds(6, 16, 109, 23);
		panel_1.add(rdbtnAdidas);

		rdbtnNike = new JRadioButton("Nike");
		rdbtnNike.setEnabled(false);
		
		buttonGroupMarcas.add(rdbtnNike);
		rdbtnNike.setBounds(6, 42, 109, 23);
		panel_1.add(rdbtnNike);

		rdbtnReebok = new JRadioButton("Reebok");
		rdbtnReebok.setEnabled(false);
		
		buttonGroupMarcas.add(rdbtnReebok);
		rdbtnReebok.setBounds(6, 68, 109, 23);
		panel_1.add(rdbtnReebok);

		txtTalla = new JTextField();
		txtTalla.setBackground(Color.DARK_GRAY);
		txtTalla.setEnabled(false);
		txtTalla.setEditable(false);
		txtTalla.setBounds(306, 142, 86, 20);
		contentPanel.add(txtTalla);
		txtTalla.setColumns(10);

		JLabel lblTalla = new JLabel("Talla");
		lblTalla.setBounds(174, 145, 46, 14);
		contentPanel.add(lblTalla);

		JLabel lblExistencias = new JLabel("Existencias");
		lblExistencias.setBounds(174, 191, 86, 14);
		contentPanel.add(lblExistencias);

		txtExistencias = new JTextField();
		txtExistencias.setBackground(Color.DARK_GRAY);
		txtExistencias.setEnabled(false);
		txtExistencias.setEditable(false);
		txtExistencias.setBounds(306, 188, 86, 20);
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
		txtTalla.setText("");
		txtPrecio.setText("");
		txtExistencias.setText("");
		rdbtnAdidas.setSelected(false);
		rdbtnNike.setSelected(false);
		rdbtnReebok.setSelected(false);
		botonAnterior.setVisible(false);
		botonSiguiente.setVisible(false);

	}

	private void mostrarSiguiente() {
		mostrarProducto(hipermercadoRopa.get(++indice));
		comprobarTamaño();
	}

	private void mostrarAnterior() {
		mostrarProducto(hipermercadoRopa.get(--indice));
		comprobarTamaño();

	}

	private void mostrarProducto(Producto producto) {
		txtBarras.setText(producto.getCodigoBarras());
		if(producto.getNombre().toString()== ListaProductos.ZAPATILLAS.toString()){
			txtTalla.setText(Integer.toString((((Zapatillas) producto).getTalla())));
		}else if(producto.getNombre().toString()== ListaProductos.CAMISETA.toString() | producto.getNombre().toString()== ListaProductos.PANTALÓN.toString()){
			txtTalla.setText(((Camiseta) producto).getTalla().toString());
		}
		
		txtPrecio.setText(Float.toString(producto.getPrecio()));
		txtExistencias.setText(Integer.toString(producto.getExistencias()));

		if (((Ropa) producto).getMarca().toString().equals("NIKE"))
			rdbtnNike.setSelected(true);
		else if (((Ropa) producto).getMarca().toString().equals("ADIDAS"))
			rdbtnAdidas.setSelected(true);
		else
			rdbtnReebok.setSelected(true);
	}

	private void generarHipermercado(hipermercado.ListaProductos producto)
			throws ProductoYaExistenteException {
		hipermercadoRopa = new Hipermercado();
		for (Producto productoAux : General.hipermercado.hipermercado) {
			if ((productoAux).getNombre().equals(producto))
				hipermercadoRopa.annadir(productoAux, productoAux.getCodigoBarras());
		}
	}

	private void comprobarTamaño() {
		if (hipermercadoRopa.get(indice + 1) != null)
			botonSiguiente.setEnabled(true);
		else
			botonSiguiente.setEnabled(false);

		if (hipermercadoRopa.get(indice - 1) != null)
			botonAnterior.setEnabled(true);
		else
			botonAnterior.setEnabled(false);
	}
}
