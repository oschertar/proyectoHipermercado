package hipermercadoGUI;

import hipermercado.Alimentacion;
import hipermercado.Hipermercado;
import hipermercado.ListaProductos;
import hipermercado.Marca;
import hipermercado.Producto;
import hipermercado.ProductoYaExistenteException;
import hipermercado.Ropa;

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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VerAlimentacion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static final long serialVersionUID = 1L;
	
	private JTextField txtBarras;
	private JTextField txtPrecio;
	private final ButtonGroup buttonGroupAlimentacion = new ButtonGroup();
	
	private JTextField txtFechaCaducidad;
	
	
	private Hipermercado hipermercadoAlimentacion;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private int indice = 0;
	private JRadioButton rdbtnCarne;
	private JRadioButton rdbtnPescado;
	private JRadioButton rdbtnPan;
	private JTextField txtKilos;
	

	/**
	 * Create the dialog.
	 */
	public VerAlimentacion() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
			}
		});
		setTitle("Buscar por Alimentacion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerAlimentacion.class.getResource("/img/alimentacion.png")));
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

		rdbtnCarne = new JRadioButton("Carne");
		rdbtnCarne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.CARNE);
					if (hipermercadoAlimentacion.get(0) != null) {
						mostrarProducto(hipermercadoAlimentacion.get(indice));
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
		buttonGroupAlimentacion.add(rdbtnCarne);
		rdbtnCarne.setBounds(6, 16, 109, 23);
		panelTipo.add(rdbtnCarne);

		rdbtnPescado = new JRadioButton("Pescado");
		rdbtnPescado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.PESCADO);
					if (hipermercadoAlimentacion.get(0) != null) {
						mostrarProducto(hipermercadoAlimentacion.get(indice));
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
		buttonGroupAlimentacion.add(rdbtnPescado);
		rdbtnPescado.setBounds(6, 42, 109, 23);
		panelTipo.add(rdbtnPescado);

		rdbtnPan = new JRadioButton("Pan");
		rdbtnPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					generarHipermercado(hipermercado.ListaProductos.PAN);
					if (hipermercadoAlimentacion.get(0) != null) {
						mostrarProducto(hipermercadoAlimentacion.get(indice));
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
		buttonGroupAlimentacion.add(rdbtnPan);
		rdbtnPan.setBounds(6, 68, 109, 23);
		panelTipo.add(rdbtnPan);

		txtFechaCaducidad = new JTextField();
		txtFechaCaducidad.setBackground(Color.DARK_GRAY);
		txtFechaCaducidad.setEnabled(false);
		txtFechaCaducidad.setEditable(false);
		txtFechaCaducidad.setBounds(306, 142, 86, 20);
		contentPanel.add(txtFechaCaducidad);
		txtFechaCaducidad.setColumns(10);

		JLabel lblFechaCaducidad = new JLabel("Fecha de Caducidad");
		lblFechaCaducidad.setBounds(174, 145, 104, 14);
		contentPanel.add(lblFechaCaducidad);

		JLabel lblKilos = new JLabel("Kilos");
		lblKilos.setBounds(174, 191, 86, 14);
		contentPanel.add(lblKilos);

		txtKilos = new JTextField();
		txtKilos.setBackground(Color.DARK_GRAY);
		txtKilos.setEnabled(false);
		txtKilos.setEditable(false);
		txtKilos.setBounds(306, 188, 86, 20);
		contentPanel.add(txtKilos);
		txtKilos.setColumns(10);
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
		txtFechaCaducidad.setText("");
		txtPrecio.setText("");
		txtKilos.setText("");
		botonAnterior.setVisible(false);
		botonSiguiente.setVisible(false);
		

	}

	private void mostrarSiguiente() {
		mostrarProducto(hipermercadoAlimentacion.get(++indice));
		comprobarTamaño();
	}

	private void mostrarAnterior() {
		mostrarProducto(hipermercadoAlimentacion.get(--indice));
		comprobarTamaño();

	}

	private void mostrarProducto(Producto producto) {
		txtBarras.setText(producto.getCodigoBarras());
		txtFechaCaducidad.setText(((Alimentacion) producto).getFechaCaducidad()
				.toString());
		txtPrecio.setText(Float.toString(producto.getPrecio()));
		txtKilos.setText(Integer.toString(producto.getExistencias()));

		
	}

	private void generarHipermercado(ListaProductos producto)
			throws ProductoYaExistenteException {
		hipermercadoAlimentacion = new Hipermercado();
		for (Producto productoAux : General.hipermercado.hipermercado) {
			if ((productoAux).getNombre().equals(producto))
				hipermercadoAlimentacion.annadir(productoAux, productoAux.getCodigoBarras());
		}
	}

	private void comprobarTamaño() {
		if (hipermercadoAlimentacion.get(indice + 1) != null)
			botonSiguiente.setEnabled(true);
		else
			botonSiguiente.setEnabled(false);

		if (hipermercadoAlimentacion.get(indice - 1) != null)
			botonAnterior.setEnabled(true);
		else
			botonAnterior.setEnabled(false);
	}
}
