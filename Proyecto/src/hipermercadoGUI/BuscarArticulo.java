package hipermercadoGUI;

import hipermercado.Alimentacion;
import hipermercado.Camiseta;
import hipermercado.CodigoBarrasNoValidoException;
import hipermercado.ExistenciasInvalidasException;
import hipermercado.Fruteria;
import hipermercado.ListaProductos;
import hipermercado.Origen;
import hipermercado.PrecioInvalidoException;
import hipermercado.Producto;
import hipermercado.ProductoNoExistenteException;
import hipermercado.ProductoYaExistenteException;
import hipermercado.Ropa;
import hipermercado.Tecnologia;
import hipermercado.Zapatillas;
import hipermercado.Zona;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import java.awt.Toolkit;
import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Component;

public class BuscarArticulo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtBarras;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int indice = 0;
	private JComboBox<Zona> comboBoxZona;

	private JButton btnMostrar;
	private Zona zona;
	private Zonas zonas = new Zonas();
	private JTextField txtNombre;
	private JTextField txtUnidades;

	private JSpinner spinnerIncremento;
	private JButton btnIncrementarUnidades;
	private JButton btnVerZona;
	private JLabel lblFabricante;
	private JTextField txtFabricante;
	private JTextField txtPrecio;
	private JTextField txtOrigen;
	private JLabel lblOrigen;
	private JTextField txtFecha;
	private JLabel lblFechaDeCaducidad;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
	private JTextField txtFechaActual;
	private Calendar FechaActual = GregorianCalendar.getInstance();
	private JTextField txtDiasRestantes;

	private JLabel lblQuedan;
	private JButton btnVender;
	private JTextField txtTalla;
	private JTextField txtMarca;
	private JLabel lblMarca;
	private JLabel lblTalla;

	/**
	 * Create the dialog.
	 */
	public BuscarArticulo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
				clear();
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BuscarArticulo.class.getResource("/img/codigobarras.jpg")));
		setTitle("Buscar Producto por C\u00F3digo de Barras");
		setBounds(100, 100, 666, 382);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBarras = new JLabel("C\u00F3digo de barras");
			lblBarras.setBounds(24, 28, 112, 14);
			contentPanel.add(lblBarras);
		}

		txtBarras = new JTextField();
		txtBarras.setBackground(SystemColor.scrollbar);
		txtBarras.setBounds(166, 25, 86, 20);
		contentPanel.add(txtBarras);
		txtBarras.setColumns(10);

		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(90, 155, -57, -63);
		contentPanel.add(list);

		btnVerZona = new JButton("Ver Zona");
		btnVerZona.setVisible(false);
		btnVerZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zonas.getZona((Zona) comboBoxZona.getSelectedItem());
				zonas.setVisible(true);
			}
		});
		btnVerZona.setBounds(511, 287, 89, 23);
		contentPanel.add(btnVerZona);

		comboBoxZona = new JComboBox<Zona>();
		comboBoxZona.setVisible(false);
		comboBoxZona.setEditable(true);
		comboBoxZona.setBounds(24, 244, 119, 36);
		contentPanel.add(comboBoxZona);

		JLabel lblNombreDelArtculo = new JLabel("Nombre del art\u00EDculo");
		lblNombreDelArtculo.setBounds(24, 53, 112, 14);
		contentPanel.add(lblNombreDelArtculo);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.DARK_GRAY);
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setBounds(166, 50, 86, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setBounds(392, 28, 66, 14);
		contentPanel.add(lblUnidades);

		txtUnidades = new JTextField();
		txtUnidades.setBackground(Color.DARK_GRAY);
		txtUnidades.setEnabled(false);
		txtUnidades.setEditable(false);
		txtUnidades.setBounds(514, 25, 86, 20);
		contentPanel.add(txtUnidades);
		txtUnidades.setColumns(10);

		btnIncrementarUnidades = new JButton("Incrementar unidades");
		btnIncrementarUnidades.setVisible(false);
		btnIncrementarUnidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					General.hipermercado.get(indice).setExistencias(
							Integer.parseInt(spinnerIncremento.getValue()
									.toString())
									+ General.hipermercado.get(indice)
											.getExistencias());
					JOptionPane.showMessageDialog(contentPanel,
							"Existencias incrementadas");
					txtUnidades.setText(Integer.toString(General.hipermercado
							.get(indice).getExistencias()));
					spinnerIncremento.setValue(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"No se han introducido números", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (ExistenciasInvalidasException e) {
					JOptionPane.showMessageDialog(null,
							"Existencias inválidas", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnIncrementarUnidades.setBounds(392, 49, 164, 23);
		contentPanel.add(btnIncrementarUnidades);

		spinnerIncremento = new JSpinner();
		spinnerIncremento.setEnabled(false);
		spinnerIncremento.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinnerIncremento.setBounds(566, 50, 34, 20);
		contentPanel.add(spinnerIncremento);

		lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(24, 115, 86, 14);
		contentPanel.add(lblFabricante);

		txtFabricante = new JTextField();
		txtFabricante.setBackground(Color.DARK_GRAY);
		txtFabricante.setEnabled(false);
		txtFabricante.setEditable(false);
		txtFabricante.setBounds(166, 112, 86, 20);
		contentPanel.add(txtFabricante);
		txtFabricante.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBackground(Color.DARK_GRAY);
		txtPrecio.setForeground(Color.DARK_GRAY);
		txtPrecio.setEnabled(false);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(166, 81, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblPrecioivaIncluido = new JLabel("Precio (IVA incl.)");
		lblPrecioivaIncluido.setBounds(24, 84, 112, 14);
		contentPanel.add(lblPrecioivaIncluido);

		JLabel label = new JLabel("\u20AC");
		label.setBounds(254, 84, 46, 14);
		contentPanel.add(label);

		lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(24, 115, 46, 14);
		contentPanel.add(lblOrigen);
		lblOrigen.setVisible(false);

		txtOrigen = new JTextField();
		txtOrigen.setEnabled(false);
		txtOrigen.setEditable(false);
		txtOrigen.setVisible(false);
		txtOrigen.setBackground(Color.DARK_GRAY);
		txtOrigen.setBounds(166, 112, 86, 20);
		contentPanel.add(txtOrigen);
		txtOrigen.setColumns(10);

		lblFechaDeCaducidad = new JLabel("Fecha de caducidad");
		lblFechaDeCaducidad.setBounds(307, 115, 151, 14);
		contentPanel.add(lblFechaDeCaducidad);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setEnabled(false);
		txtFecha.setBackground(Color.DARK_GRAY);
		txtFecha.setBounds(473, 112, 127, 20);
		contentPanel.add(txtFecha);
		txtFecha.setColumns(10);

		txtFechaActual = new JTextField();
		txtFechaActual.setEditable(false);
		txtFechaActual.setBounds(108, 288, 56, 20);
		contentPanel.add(txtFechaActual);
		txtFechaActual.setColumns(10);
		txtFecha.setVisible(false);
		lblFechaDeCaducidad.setVisible(false);
		lblFabricante.setVisible(false);
		txtFabricante.setVisible(false);

		txtFechaActual.setText(formato.format(FechaActual.getTime()));

		txtDiasRestantes = new JTextField();
		txtDiasRestantes.setEditable(false);
		txtDiasRestantes.setBounds(514, 143, 86, 20);
		contentPanel.add(txtDiasRestantes);
		txtDiasRestantes.setColumns(10);

		JLabel lblFechaActual = new JLabel("Fecha actual:");
		lblFechaActual.setBounds(24, 291, 86, 14);
		contentPanel.add(lblFechaActual);

		lblQuedan = new JLabel("Dias para que caduque el producto: ");
		lblQuedan.setBounds(307, 146, 221, 14);
		contentPanel.add(lblQuedan);

		btnVender = new JButton("\u00BFOferta?");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					General.hipermercado.get(indice).setPrecio(
							Alimentacion.implementarOferta(General.hipermercado
									.get(indice).getPrecio()));

					JOptionPane.showMessageDialog(contentPanel,
							"Oferta realizada con éxito");
					txtPrecio.setText(((General.hipermercado.get(indice)
							.getPrecio()).toString()));
					btnVender.setVisible(false);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"No se han introducido números", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnVender.setVisible(false);
		btnVender.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVender.setBounds(403, 183, 89, 23);
		contentPanel.add(btnVender);

		lblTalla = new JLabel("Talla");
		lblTalla.setBounds(24, 115, 46, 14);
		contentPanel.add(lblTalla);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(24, 146, 46, 14);
		contentPanel.add(lblMarca);

		txtTalla = new JTextField();
		txtTalla.setEnabled(false);
		txtTalla.setBackground(Color.DARK_GRAY);
		txtTalla.setEditable(false);
		txtTalla.setBounds(166, 112, 86, 20);
		contentPanel.add(txtTalla);
		txtTalla.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setBackground(Color.DARK_GRAY);
		txtMarca.setEditable(false);
		txtMarca.setBounds(166, 143, 86, 20);
		contentPanel.add(txtMarca);
		txtMarca.setColumns(10);
		txtDiasRestantes.setVisible(false);
		lblQuedan.setVisible(false);
		txtMarca.setVisible(false);
		txtTalla.setVisible(false);
		lblMarca.setVisible(false);
		lblTalla.setVisible(false);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						clear();
					}
				});

				btnMostrar = new JButton("Buscar");
				btnMostrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						mostrarProducto();

						btnIncrementarUnidades.setVisible(true);
						spinnerIncremento.setEnabled(true);
						btnVerZona.setVisible(true);

					}
				});
				buttonPane.add(btnMostrar);
				buttonPane.add(cancelButton);
			}
		}

	}

	private void mostrarProducto() {

		try {
			Producto producto = General.hipermercado.get(txtBarras.getText());
			txtNombre.setText(producto.getNombre().toString());
			comboBoxZona.addItem(producto.getZona());
			comboBoxZona.setSelectedItem(producto.getZona());
			txtUnidades.setText(Integer.toString(producto.getExistencias()));
			colocarBotones((Zona) comboBoxZona.getSelectedItem(), producto);
			txtPrecio.setText(Float.toString(producto.getPrecio()));
		} catch (CodigoBarrasNoValidoException e) {
			JOptionPane.showMessageDialog(null,
					"Código de barras inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (ProductoNoExistenteException e) {
			JOptionPane.showMessageDialog(null,
					"El producto no existe", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void colocarBotones(Zona zona, Producto producto) {
		switch (zona) {
		case TECNOLOGIA:
			colocarComboBox(true, true, false, false, false, false, false,
					false, false, false, false, false, false);
			txtFabricante.setText(((Tecnologia) producto).getFabricante()
					.toString());

			break;
		case ALIMENTACION:
			colocarComboBox(false, false, false, false, true, true, true, true,
					false, false, false, false, true);
			txtFecha.setText(((Alimentacion) producto).getFechaCaducidad()
					.toString());
			try {
				int diferencia = 0;
				Calendar fechaCaducidad = Calendar.getInstance();
				Calendar actual = Calendar.getInstance();
				fechaCaducidad.setTime(formato.parse(txtFecha.getText()));
				actual.setTime(formato.parse(txtFechaActual.getText()));
				if (fechaCaducidad.get(Calendar.YEAR) > actual
						.get(Calendar.YEAR)) {
					diferencia = (fechaCaducidad.get(Calendar.DAY_OF_YEAR) - actual
							.get(Calendar.DAY_OF_YEAR)) + 365;
				} else {
					diferencia = fechaCaducidad.get(Calendar.DAY_OF_YEAR)
							- actual.get(Calendar.DAY_OF_YEAR);
				}

				txtDiasRestantes.setText(Integer.toString(diferencia));
				if (Integer.parseInt(txtDiasRestantes.getText()) <= 10) {
					btnVender.setVisible(true);
				} else {
					btnVender.setVisible(false);
				}
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,
						"Error al intercambiar datos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			break;
		case FRUTERIA:
			colocarComboBox(false, false, true, true, true, true, true, true,
					false, false, false, false, true);
			txtOrigen.setText(((Fruteria) producto).getPais().toString());
			txtFecha.setText(((Fruteria) producto).getFechaCaducidad()
					.toString());

			try {
				int diferencia = 0;

				Calendar fechaCaducidad = Calendar.getInstance();
				Calendar actual = Calendar.getInstance();
				fechaCaducidad.setTime(formato.parse(txtFecha.getText()));
				actual.setTime(formato.parse(txtFechaActual.getText()));

				if (fechaCaducidad.get(Calendar.YEAR) > actual
						.get(Calendar.YEAR)) {

					diferencia = (fechaCaducidad.get(Calendar.DAY_OF_YEAR) - actual
							.get(Calendar.DAY_OF_YEAR)) + (365);
				} else {
					diferencia = fechaCaducidad.get(Calendar.DAY_OF_YEAR)
							- actual.get(Calendar.DAY_OF_YEAR);
				}

				txtDiasRestantes.setText(Integer.toString(diferencia));
				if (Integer.parseInt(txtDiasRestantes.getText()) <= 10) {
					btnVender.setVisible(true);
				} else {
					btnVender.setVisible(false);
				}
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,
						"Error al intercambiar datos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			break;
		case ROPA:
			colocarComboBox(false, false, false, false, false, false, false,
					false, true, true, true, true, false);
			txtMarca.setText(((Ropa) producto).getMarca().toString());
			if (producto.getNombre().toString() == ListaProductos.ZAPATILLAS
					.toString()) {
				txtTalla.setText(Integer.toString(((Zapatillas) producto)
						.getTalla()));
			} else if (producto.getNombre().toString() == ListaProductos.CAMISETA
					.toString()
					| producto.getNombre().toString() == ListaProductos.PANTALÓN
							.toString()) {
				txtTalla.setText(((Camiseta) producto).getTalla().toString());
			}

			break;
		case VIDEOJUEGOS:
			colocarComboBox(false, false, false, false, false, false, false,
					false, false, false, false, false, false);
			break;
		}

	}

	private void colocarComboBox(boolean lFabricante, boolean tFabricante,
			boolean lOrigen, boolean tOrigen, boolean lFechaDeCaducidad,
			boolean tFecha, boolean lQuedan, boolean tQuedan, boolean tTalla,
			boolean lTalla, boolean tMarca, boolean lMarca, boolean bVender) {
		lblFabricante.setVisible(lFabricante);
		txtFabricante.setVisible(tFabricante);
		lblOrigen.setVisible(lOrigen);
		txtOrigen.setVisible(tOrigen);
		lblFechaDeCaducidad.setVisible(lFechaDeCaducidad);
		txtFecha.setVisible(tFecha);
		lblQuedan.setVisible(lQuedan);
		txtDiasRestantes.setVisible(tQuedan);
		txtTalla.setVisible(tTalla);
		lblTalla.setVisible(lTalla);
		txtMarca.setVisible(tMarca);
		lblMarca.setVisible(lMarca);
		btnVender.setVisible(bVender);
	}

	private void clear() {
		txtBarras.setText("");
		txtNombre.setText("");
		txtUnidades.setText("");
		spinnerIncremento.setValue(0);

		btnMostrar.setVisible(true);
		btnIncrementarUnidades.setVisible(false);
		spinnerIncremento.setEnabled(false);
		btnVerZona.setVisible(false);
		txtFabricante.setText("");
		txtFabricante.setVisible(false);
		txtOrigen.setText("");
		txtOrigen.setVisible(false);
		lblOrigen.setVisible(false);
		txtFecha.setVisible(false);
		txtFecha.setText("");
		txtPrecio.setText("");
		lblFabricante.setVisible(false);
		lblQuedan.setVisible(false);
		txtDiasRestantes.setVisible(false);
		lblFechaDeCaducidad.setVisible(false);
		txtDiasRestantes.setText("");
		btnVender.setVisible(false);
	}

}