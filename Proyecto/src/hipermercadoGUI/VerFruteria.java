package hipermercadoGUI;

import hipermercado.Alimentacion;
import hipermercado.Fruteria;
import hipermercado.Hipermercado;
import hipermercado.ListaProductos;
import hipermercado.Producto;
import hipermercado.ProductoYaExistenteException;
import hipermercado.Ropa;

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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VerFruteria extends JDialog {

	

		private final JPanel contentPanel = new JPanel();

		private static final long serialVersionUID = 1L;
		
		private JTextField txtBarras;
		private JTextField txtPrecio;
		private final ButtonGroup buttonGroupFruteria = new ButtonGroup();
		
		private JTextField txtFechaCaducidad;
		
		
		private Hipermercado hipermercadoFruteria;
		private JButton botonAnterior;
		private JButton botonSiguiente;
		private int indice = 0;
		private JRadioButton rdbtnManzana;
		private JRadioButton rdbtnNaranja;
		private JRadioButton rdbtnMelocoton;
		private JTextField txtKilos;

		private JRadioButton rdbtnEspaa;

		private JRadioButton rdbtnMarruecos;

		private JRadioButton rdbtnChina;

		private JRadioButton rdbtnItalia;

		private JRadioButton rdbtnUsa;
		private final ButtonGroup buttonGroup = new ButtonGroup();
		

		/**
		 * Create the dialog.
		 */
		public VerFruteria() {
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					limpiar();
				}
			});
			setTitle("Buscar por Fruteria");
			setIconImage(Toolkit.getDefaultToolkit().getImage(VerFruteria.class.getResource("/img/fruteria.png")));
			setResizable(false);
			setBounds(100, 100, 414, 368);
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
			panelTipo.setBounds(21, 11, 121, 98);
			contentPanel.add(panelTipo);
			panelTipo.setLayout(null);

			rdbtnManzana = new JRadioButton("Manzana");
			rdbtnManzana.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						generarHipermercado(hipermercado.ListaProductos.MANZANAS);
						if (hipermercadoFruteria.get(0) != null) {
							mostrarProducto(hipermercadoFruteria.get(indice));
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
			buttonGroupFruteria.add(rdbtnManzana);
			rdbtnManzana.setBounds(6, 16, 109, 23);
			panelTipo.add(rdbtnManzana);

			rdbtnNaranja = new JRadioButton("Naranja");
			rdbtnNaranja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						generarHipermercado(hipermercado.ListaProductos.NARANJAS);
						if (hipermercadoFruteria.get(0) != null) {
							mostrarProducto(hipermercadoFruteria.get(indice));
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
			buttonGroupFruteria.add(rdbtnNaranja);
			rdbtnNaranja.setBounds(6, 42, 109, 23);
			panelTipo.add(rdbtnNaranja);

			rdbtnMelocoton = new JRadioButton("Melocot\u00F3n");
			rdbtnMelocoton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						generarHipermercado(hipermercado.ListaProductos.MELOCOTONES);
						if (hipermercadoFruteria.get(0) != null) {
							mostrarProducto(hipermercadoFruteria.get(indice));
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
			buttonGroupFruteria.add(rdbtnMelocoton);
			rdbtnMelocoton.setBounds(6, 68, 109, 23);
			panelTipo.add(rdbtnMelocoton);

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
			
			JPanel panelOrigen = new JPanel();
			panelOrigen.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Origen", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelOrigen.setBounds(21, 125, 121, 151);
			contentPanel.add(panelOrigen);
			panelOrigen.setLayout(null);
			
			rdbtnEspaa = new JRadioButton("Espa\u00F1a");
			buttonGroup.add(rdbtnEspaa);
			rdbtnEspaa.setEnabled(false);
			rdbtnEspaa.setBounds(6, 16, 109, 23);
			panelOrigen.add(rdbtnEspaa);
			
			rdbtnMarruecos = new JRadioButton("Marruecos");
			buttonGroup.add(rdbtnMarruecos);
			rdbtnMarruecos.setEnabled(false);
			rdbtnMarruecos.setBounds(6, 42, 109, 23);
			panelOrigen.add(rdbtnMarruecos);
			
			rdbtnChina = new JRadioButton("China");
			buttonGroup.add(rdbtnChina);
			rdbtnChina.setEnabled(false);
			rdbtnChina.setBounds(6, 68, 109, 23);
			panelOrigen.add(rdbtnChina);
			
			rdbtnItalia = new JRadioButton("Italia");
			buttonGroup.add(rdbtnItalia);
			rdbtnItalia.setEnabled(false);
			rdbtnItalia.setBounds(6, 95, 109, 23);
			panelOrigen.add(rdbtnItalia);
			
			rdbtnUsa = new JRadioButton("USA");
			buttonGroup.add(rdbtnUsa);
			rdbtnUsa.setEnabled(false);
			rdbtnUsa.setBounds(6, 121, 109, 23);
			panelOrigen.add(rdbtnUsa);
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
			mostrarProducto(hipermercadoFruteria.get(++indice));
			comprobarTamaño();
		}

		private void mostrarAnterior() {
			mostrarProducto(hipermercadoFruteria.get(--indice));
			comprobarTamaño();

		}

		private void mostrarProducto(Producto producto) {
			txtBarras.setText(producto.getCodigoBarras());
			txtFechaCaducidad.setText(((Fruteria) producto).getFechaCaducidad()
					.toString());
			txtPrecio.setText(Float.toString(producto.getPrecio()));
			txtKilos.setText(Integer.toString(producto.getExistencias()));
			if (((Fruteria) producto).getPais().toString().equals("ESPAÑA"))
				rdbtnEspaa.setSelected(true);
			else if (((Fruteria) producto).getPais().toString().equals("USA"))
				rdbtnUsa.setSelected(true);
			else if (((Fruteria) producto).getPais().toString().equals("MARRUECOS"))
				rdbtnMarruecos.setSelected(true);
			else if (((Fruteria) producto).getPais().toString().equals("ITALIA"))
				rdbtnItalia.setSelected(true);
			else if (((Fruteria) producto).getPais().toString().equals("CHINA"))
				rdbtnChina.setSelected(true);

			
		}

		private void generarHipermercado(ListaProductos producto)
				throws ProductoYaExistenteException {
			hipermercadoFruteria = new Hipermercado();
			for (Producto productoAux : General.hipermercado.hipermercado) {
				if ((productoAux).getNombre().equals(producto))
					hipermercadoFruteria.annadir(productoAux, productoAux.getCodigoBarras());
			}
		}

		private void comprobarTamaño() {
			if (hipermercadoFruteria.get(indice + 1) != null)
				botonSiguiente.setEnabled(true);
			else
				botonSiguiente.setEnabled(false);

			if (hipermercadoFruteria.get(indice - 1) != null)
				botonAnterior.setEnabled(true);
			else
				botonAnterior.setEnabled(false);
		}
	}


