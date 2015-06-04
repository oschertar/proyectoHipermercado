package hipermercadoGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import hipermercado.Alimentacion;
import hipermercado.Camiseta;
import hipermercado.Carne;
import hipermercado.CodigoBarrasNoValidoException;
import hipermercado.ExistenciasInvalidasException;
import hipermercado.FechaCaducidadInvalidaException;
import hipermercado.Fruteria;
import hipermercado.Hipermercado;
import hipermercado.Manzanas;
import hipermercado.Melocotones;
import hipermercado.Naranjas;
import hipermercado.PS4;
import hipermercado.Pan;
import hipermercado.Pantalon;
import hipermercado.Pescado;
import hipermercado.Portatil;
import hipermercado.Producto;
import hipermercado.ProductoYaExistenteException;
import hipermercado.Ropa;
import hipermercado.Sobremesa;
import hipermercado.TV;
import hipermercado.Talla;
import hipermercado.Tecnologia;
import hipermercado.Videojuegos;
import hipermercado.Wii;
import hipermercado.Xbox;
import hipermercado.Zapatillas;
import hipermercado.Zona;
import hipermercado.ListaProductos;

import javax.swing.JCheckBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import sun.audio.*;

import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JSlider;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import hipermercado.Marca;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import hipermercado.Fabricante;
import hipermercado.Origen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComprarProductos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBarras;
	private JComboBox<Producto> comboBoxProducto;
	private JComboBox<Zona> comboBoxZona;
	private JTextField txtFechadeCaducidad;
	private JCheckBox chckbxPerecedero;
	private JLabel lblFechaDeCaducidad;
	private JButton botonAnnadir;
	private JTextField txtPrecio;
	private JSlider sliderExistencias;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblArticulosAAadir;
	private JTextField txtExistencias;
	private JSlider sliderMinimos;
	private JLabel lblUnidadesMnimas;
	private JTextField txtMinimos;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel lblTalla;
	private JComboBox comboBoxTallas;
	private JLabel lblMarca;
	private JComboBox<Marca> comboBoxMarca;
	private JLabel tick;
	private JLabel error;
	private JLabel camisetas;
	private Image Imgcamiseta;
	private JLabel pantalones;
	protected Image Imgpantalon;
	private JLabel zapatillas;
	protected Image Imgzapatilla;
	private JLabel portatil;
	private JLabel tv;
	private JLabel sobremesa;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel carne;
	private JLabel pescado;
	private JLabel pan;
	private JLabel manzanas;
	private JLabel melocotones;
	private JLabel naranjas;
	private JLabel wii;
	private JLabel xbox;
	private JLabel ps4;
	private JLabel label_8;

	private JComboBox<Fabricante> comboBoxFabricante;
	private JLabel lblFabricante;
	private JLabel lblOrigen;
	private JComboBox<Origen> comboBoxOrigen;
	
	private JComboBox<Talla> comboBoxTallaEnum;

	/**
	 * Create the dialog.
	 */
	public ComprarProductos() {
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				limpiar();
			}
		});
		setResizable(false);
		setTitle("Comprar Productos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ComprarProductos.class.getResource("/img/comprar.png")));
		setBounds(100, 100, 633, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("C\u00F3digo de Barras");
			lblNewLabel.setBounds(39, 109, 98, 43);
			contentPanel.add(lblNewLabel);
		}

		txtBarras = new JTextField();
		txtBarras.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtBarras.setForeground(Color.BLACK);
				tick.setVisible(false);
				error.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!hipermercado.Producto.esValido(txtBarras.getText(),
						(Zona) comboBoxZona.getSelectedItem())) {
					txtBarras.setForeground(Color.RED);
					error.setVisible(true);
					tick.setVisible(false);

				} else {
					txtBarras.setForeground(new Color(0, 128, 0));
					tick.setVisible(true);
					error.setVisible(false);

				}
			}

		});
		txtBarras.setBounds(202, 120, 128, 20);
		contentPanel.add(txtBarras);
		txtBarras.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				botonAnnadir = new JButton("A\u00F1adir Producto");
				botonAnnadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						try {
							annadirProducto((Zona) comboBoxZona
									.getSelectedItem(), General.hipermercado,
									(ListaProductos) comboBoxProducto
											.getSelectedItem(), txtBarras
											.getText());
							

						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (HeadlessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ProductoYaExistenteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NullPointerException e) {
							JOptionPane.showMessageDialog(contentPanel,
									"Hay casillas sin rellenar", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (ExistenciasInvalidasException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (CodigoBarrasNoValidoException e) {
							JOptionPane
									.showMessageDialog(
											contentPanel,
											"Código de barras inválido. Formato inadecuado",
											"Error", JOptionPane.ERROR_MESSAGE);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				});
				botonAnnadir.setActionCommand("OK");
				buttonPane.add(botonAnnadir);
				getRootPane().setDefaultButton(botonAnnadir);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						limpiar();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		comboBoxProducto = new JComboBox<Producto>();
		comboBoxProducto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cambiarImagen(true);
			}
		});

		comboBoxProducto.setModel(new DefaultComboBoxModel(ListaProductos
				.values()));

		comboBoxProducto.setBounds(162, 73, 168, 20);
		contentPanel.add(comboBoxProducto);

		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(39, 68, 98, 30);
		contentPanel.add(lblProducto);

		JLabel lblZona = new JLabel("Zona");
		lblZona.setBounds(39, 22, 50, 30);
		contentPanel.add(lblZona);

		comboBoxZona = new JComboBox<Zona>();
		comboBoxZona.setSelectedIndex(-1);
		comboBoxTallaEnum = new JComboBox<Talla>();
		comboBoxTallaEnum.setModel(new DefaultComboBoxModel(Talla.values()));

		comboBoxTallaEnum.setBounds(470, 73, 56, 20);
		comboBoxTallaEnum.setVisible(false);
		contentPanel.add(comboBoxTallaEnum);
		comboBoxZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxZona.getSelectedItem() == Zona.ALIMENTACION
						|| comboBoxZona.getSelectedItem() == Zona.FRUTERIA) {
					chckbxPerecedero.setVisible(true);
					chckbxPerecedero.setSelected(true);
					lblArticulosAAadir.setText("Kilos a a\u00F1adir");
					lblUnidadesMnimas.setText("Kilos M\u00EDnimos");
				} else if (comboBoxZona.getSelectedItem() != Zona.ALIMENTACION
						|| comboBoxZona.getSelectedItem() != Zona.FRUTERIA) {
					chckbxPerecedero.setSelected(false);
					chckbxPerecedero.setVisible(false);
					lblArticulosAAadir.setText("Articulos a a\u00F1adir");
					lblUnidadesMnimas.setText("Unidades M\u00EDnimas");
				}
				if (comboBoxZona.getSelectedItem() == Zona.FRUTERIA) {
					lblOrigen.setVisible(true);
					comboBoxOrigen.setVisible(true);
				} else if (comboBoxZona.getSelectedItem() != Zona.FRUTERIA) {
					lblOrigen.setVisible(false);
					comboBoxOrigen.setVisible(false);

				}
				if (comboBoxZona.getSelectedItem() == Zona.ROPA) {

					lblMarca.setVisible(true);
					comboBoxMarca.setVisible(true);
					lblTalla.setVisible(true);
					cambiarImagen(true);
					

				}else if (comboBoxZona.getSelectedItem() != Zona.ROPA) {
					comboBoxTallas.setVisible(false);
					comboBoxTallaEnum.setVisible(false);
					lblTalla.setVisible(false);
					lblMarca.setVisible(false);
					comboBoxMarca.setVisible(false);
					cambiarImagen(true);

				}

				if (comboBoxZona.getSelectedItem() == Zona.TECNOLOGIA) {
					comboBoxFabricante.setVisible(true);
					lblFabricante.setVisible(true);
				} else if (comboBoxZona.getSelectedItem() != Zona.TECNOLOGIA) {
					comboBoxFabricante.setVisible(false);
					lblFabricante.setVisible(false);
				}
			}
		});
		comboBoxZona.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxProducto.setModel(new DefaultComboBoxModel(
						getProducto(comboBoxZona)));

			}
		});
		comboBoxZona.setModel(new DefaultComboBoxModel(Zona.values()));
		comboBoxZona.setBounds(162, 27, 168, 20);
		contentPanel.add(comboBoxZona);

		chckbxPerecedero = new JCheckBox("Perecedero");
		chckbxPerecedero.setVisible(false);
		chckbxPerecedero.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxPerecedero.isSelected()) {
					txtFechadeCaducidad.setVisible(true);
					lblFechaDeCaducidad.setVisible(true);

				} else if (!chckbxPerecedero.isSelected()) {
					txtFechadeCaducidad.setVisible(false);
					lblFechaDeCaducidad.setVisible(false);
				}
			}
		});

		chckbxPerecedero.setBounds(367, 72, 97, 23);
		contentPanel.add(chckbxPerecedero);

		txtFechadeCaducidad = new JTextField();
		txtFechadeCaducidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!hipermercado.Alimentacion.esValido(txtFechadeCaducidad
						.getText())) {
					txtFechadeCaducidad.setForeground(Color.RED);

				} else {
					txtFechadeCaducidad.setForeground(new Color(0, 128, 0));

				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtFechadeCaducidad.setForeground(Color.BLACK);
			}
		});
		txtFechadeCaducidad.setBounds(470, 73, 129, 20);
		contentPanel.add(txtFechadeCaducidad);
		txtFechadeCaducidad.setColumns(10);

		txtFechadeCaducidad.setVisible(false);
		lblFechaDeCaducidad = new JLabel("Fecha de caducidad");
		lblFechaDeCaducidad.setBounds(492, 91, 135, 20);
		lblFechaDeCaducidad.setVisible(false);
		contentPanel.add(lblFechaDeCaducidad);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(367, 22, 56, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(407, 20, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblsinIva = new JLabel("\u20AC   (Sin IVA)");
		lblsinIva.setBounds(503, 22, 96, 14);
		contentPanel.add(lblsinIva);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/codigobarras.jpg")));
		label_1.setBounds(154, 120, 24, 20);
		contentPanel.add(label_1);

		sliderExistencias = new JSlider();
		sliderExistencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				txtExistencias.setText(Integer.toString(sliderExistencias
						.getValue()));
			}
		});

		sliderExistencias
				.setToolTipText("Elige un valor entre los posibles y haz click sobre el cuadro blanco de la derecha");

		sliderExistencias.setPaintLabels(true);
		sliderExistencias.setValue(0);
		sliderExistencias.setMaximum(20);
		sliderExistencias.setBounds(39, 180, 200, 23);
		contentPanel.add(sliderExistencias);

		label_2 = new JLabel("10");
		label_2.setBounds(132, 203, 46, 14);
		contentPanel.add(label_2);

		label_3 = new JLabel("20");
		label_3.setBounds(215, 203, 24, 14);
		contentPanel.add(label_3);

		label_4 = new JLabel("0");
		label_4.setBounds(39, 203, 46, 14);
		contentPanel.add(label_4);

		lblArticulosAAadir = new JLabel("Articulos a a\u00F1adir");
		lblArticulosAAadir.setBounds(94, 155, 196, 14);
		contentPanel.add(lblArticulosAAadir);

		txtExistencias = new JTextField();
		txtExistencias.setEditable(false);
		txtExistencias.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();

				if (Character.isLetter(c)) {
					getToolkit().beep();
					arg0.consume();
					JOptionPane.showMessageDialog(contentPanel,
							"Solo se admiten números.", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		txtExistencias.getDocument().addDocumentListener(
				new DocumentListener() {

					@Override
					public void removeUpdate(DocumentEvent e) {

						actualizarNumero(txtExistencias, sliderExistencias);

					}

					@Override
					public void insertUpdate(DocumentEvent e) {

						actualizarNumero(txtExistencias, sliderExistencias);
					}

					@Override
					public void changedUpdate(DocumentEvent e) {

						actualizarNumero(txtExistencias, sliderExistencias);
					}
				});

		txtExistencias.setBounds(244, 180, 86, 20);
		contentPanel.add(txtExistencias);
		txtExistencias.setColumns(10);

		sliderMinimos = new JSlider();
		sliderMinimos.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				txtMinimos.setText(Integer.toString(sliderMinimos.getValue()));
			}
		});

		sliderMinimos
				.setToolTipText("Elige un valor entre los posibles y haz click sobre el cuadro blanco de la derecha");
		sliderMinimos.setPaintLabels(true);
		sliderMinimos.setValue(10);
		sliderMinimos.setMaximum(20);
		sliderMinimos.setBounds(39, 263, 200, 23);
		contentPanel.add(sliderMinimos);

		lblUnidadesMnimas = new JLabel("Unidades M\u00EDnimas");
		lblUnidadesMnimas.setBounds(94, 238, 111, 14);
		contentPanel.add(lblUnidadesMnimas);

		txtMinimos = new JTextField();
		txtMinimos.setEditable(false);
		txtMinimos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (Character.isLetter(c)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(contentPanel,
							"Solo se admiten números.", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		txtMinimos.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				actualizarNumero(txtMinimos, sliderMinimos);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				actualizarNumero(txtMinimos, sliderMinimos);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				actualizarNumero(txtMinimos, sliderMinimos);
			}
		});

		txtMinimos.setBounds(244, 263, 86, 20);
		contentPanel.add(txtMinimos);
		txtMinimos.setColumns(10);

		label_5 = new JLabel("0");
		label_5.setBounds(39, 286, 46, 14);
		contentPanel.add(label_5);

		label_6 = new JLabel("10");
		label_6.setBounds(132, 286, 46, 14);
		contentPanel.add(label_6);

		label_7 = new JLabel("20");
		label_7.setBounds(215, 286, 24, 14);
		contentPanel.add(label_7);

		lblTalla = new JLabel("Talla");
		lblTalla.setVisible(false);
		lblTalla.setBounds(391, 76, 46, 14);
		contentPanel.add(lblTalla);

		comboBoxTallas = new JComboBox();
		comboBoxTallas.setVisible(false);
		comboBoxTallas.setModel(new DefaultComboBoxModel(new String[] { "35",
				"36", "37", "38", "39", "40", "41", "42", "43" }));
		comboBoxTallas.setBounds(469, 73, 80, 20);
		contentPanel.add(comboBoxTallas);

		lblMarca = new JLabel("Marca");
		lblMarca.setVisible(false);
		lblMarca.setBounds(391, 123, 46, 14);
		contentPanel.add(lblMarca);

		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cambiarImagen(true);

			}

		});
		comboBoxMarca.setVisible(false);
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxMarca.setBounds(470, 120, 80, 20);
		contentPanel.add(comboBoxMarca);

		JLabel lblVistaPrevia = new JLabel("Vista Previa");
		lblVistaPrevia.setBounds(391, 169, 86, 14);
		contentPanel.add(lblVistaPrevia);

		tick = new JLabel("");
		tick.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/tick.png")));
		tick.setBounds(335, 115, 46, 31);
		contentPanel.add(tick);

		error = new JLabel("");
		error.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/error.png")));
		error.setBounds(335, 115, 46, 31);
		contentPanel.add(error);

		camisetas = new JLabel("");
		camisetas.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/camisetadidas.jpg")));
		camisetas.setBounds(386, 194, 182, 142);
		contentPanel.add(camisetas);

		pantalones = new JLabel("");
		pantalones.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/pantalonadidas.jpg")));
		pantalones.setBounds(386, 194, 182, 142);
		contentPanel.add(pantalones);

		zapatillas = new JLabel("");
		zapatillas.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/zapatillasadidas.jpg")));
		zapatillas.setBounds(386, 194, 182, 142);
		contentPanel.add(zapatillas);

		portatil = new JLabel("");
		portatil.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/portatil.jpg")));
		portatil.setBounds(386, 194, 182, 142);
		contentPanel.add(portatil);

		tv = new JLabel("");
		tv.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/tv.jpg")));
		tv.setBounds(386, 194, 182, 142);
		contentPanel.add(tv);

		sobremesa = new JLabel("");
		sobremesa.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/sobremesa.jpg")));
		sobremesa.setBounds(386, 194, 182, 142);
		contentPanel.add(sobremesa);
		tick.setVisible(false);
		error.setVisible(false);
		camisetas.setVisible(false);
		pantalones.setVisible(false);
		zapatillas.setVisible(false);
		portatil.setVisible(false);
		sobremesa.setVisible(true);
		tv.setVisible(false);
		comboBoxProducto.setModel(new DefaultComboBoxModel(
				getProducto(comboBoxZona)));

		carne = new JLabel("");
		formato.setLenient(true);
		carne.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/carne.jpg")));
		carne.setBounds(386, 194, 182, 142);
		contentPanel.add(carne);

		pescado = new JLabel("");
		pescado.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/pescado.jpg")));
		pescado.setBounds(386, 194, 182, 142);
		contentPanel.add(pescado);

		pan = new JLabel("");
		pan.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/pan.jpg")));
		pan.setBounds(386, 194, 182, 142);
		contentPanel.add(pan);

		manzanas = new JLabel("");
		manzanas.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/manzanas.jpg")));
		manzanas.setBounds(386, 194, 182, 142);
		contentPanel.add(manzanas);

		melocotones = new JLabel("");
		melocotones.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/melocotones.jpg")));
		melocotones.setBounds(386, 194, 182, 142);
		contentPanel.add(melocotones);

		naranjas = new JLabel("");
		naranjas.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/naranjas.jpg")));
		naranjas.setBounds(386, 194, 182, 142);
		contentPanel.add(naranjas);

		wii = new JLabel("");
		wii.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/wii.jpg")));
		wii.setBounds(386, 194, 182, 142);
		contentPanel.add(wii);

		xbox = new JLabel("");
		xbox.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/xboxone.jpg")));
		xbox.setBounds(386, 194, 182, 142);
		contentPanel.add(xbox);

		ps4 = new JLabel("");
		ps4.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/productos/ps4.jpg")));
		ps4.setBounds(386, 194, 182, 142);
		contentPanel.add(ps4);

		label_8 = new JLabel("");
		label_8.setToolTipText("El c\u00F3digo de barras admitido tiene un formato de 5 n\u00FAmeros y 2 letras( Zonas: Ropa [RO], Alimentaci\u00F3n: [AL], Fruter\u00EDa: [FR], Tecnolog\u00EDa[TE], Videojuegos[VI]).\r\n\r\n\r\n\r\n\r\n");
		label_8.setIcon(new ImageIcon(ComprarProductos.class
				.getResource("/img/ayuda.jpeg")));
		label_8.setBounds(181, 120, 24, 20);
		contentPanel.add(label_8);

		lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(367, 76, 97, 14);
		contentPanel.add(lblFabricante);

		comboBoxFabricante = new JComboBox<Fabricante>();
		comboBoxFabricante.setModel(new DefaultComboBoxModel(Fabricante
				.values()));
		comboBoxFabricante.setBounds(470, 73, 111, 20);

		contentPanel.add(comboBoxFabricante);

		lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(377, 123, 46, 14);
		contentPanel.add(lblOrigen);

		comboBoxOrigen = new JComboBox<Origen>();
		comboBoxOrigen.setModel(new DefaultComboBoxModel(Origen.values()));
		comboBoxOrigen.setBounds(470, 120, 79, 20);
		contentPanel.add(comboBoxOrigen);

		comboBoxOrigen.setVisible(false);
		lblOrigen.setVisible(false);
		carne.setVisible(false);
		pescado.setVisible(false);
		pan.setVisible(false);
		ps4.setVisible(false);
		wii.setVisible(false);
		xbox.setVisible(false);
		naranjas.setVisible(false);
		manzanas.setVisible(false);
		melocotones.setVisible(false);

	}

	protected void limpiar() {

		txtBarras.setText("");
		txtExistencias.setText("0");
		txtPrecio.setText("");
		txtMinimos.setText("10");
		comboBoxProducto.setSelectedIndex(-1);
		comboBoxZona.setSelectedIndex(0);
		sliderExistencias.setValue(0);
		sliderMinimos.setValue(10);
		txtExistencias.setText("0");
		txtMinimos.setText("10");
		txtFechadeCaducidad.setText("");
		error.setVisible(false);
		tick.setVisible(false);
		cambiarImagen(false);
	}

	private Object[] getProducto(JComboBox<Zona> comboBoxZona) {
		Zona zona = (Zona) comboBoxZona.getSelectedItem();
		ArrayList<ListaProductos> productos = new ArrayList<ListaProductos>();
		for (ListaProductos p : ListaProductos.values()) {
			if (p.getZona() == zona)
				productos.add(p);
		}
		return productos.toArray();
	}

	private void cambiarImagen(boolean opcion) {
		if (!opcion) {
			colocarImagenTecnologia(false);
			colocarImagenRopa(false);
			colocarImagenAlimentacion(false);
			colocarImagenVideojuegos(false);
			colocarImagenFrutas(false);
			return;
		}
		switch ((Zona) comboBoxZona.getSelectedItem()) {
		case ROPA:
			actualizarImagenes(false, true, false, false, false);
			if((ListaProductos) comboBoxProducto.getSelectedItem()==ListaProductos.ZAPATILLAS){
				comboBoxTallas.setVisible(true);
				comboBoxTallaEnum.setVisible(false);
			}else if((ListaProductos) comboBoxProducto.getSelectedItem()==ListaProductos.CAMISETA |(ListaProductos) comboBoxProducto.getSelectedItem()==ListaProductos.PANTALÓN){
				comboBoxTallas.setVisible(false);
				comboBoxTallaEnum.setVisible(true);
			}
			break;

		case TECNOLOGIA:
			actualizarImagenes(true, false, false, false, false);
			break;

		case ALIMENTACION:
			actualizarImagenes(false, false, true, false, false);
			break;

		case FRUTERIA:
			actualizarImagenes(false, false, false, false, true);
			break;
		case VIDEOJUEGOS:
			actualizarImagenes(false, false, false, true, false);
			break;

		}

	}

	private void actualizarImagenes(boolean tecnologia, boolean ropa,
			boolean alimentacion, boolean videojuegos, boolean frutas) {
		colocarImagenTecnologia(tecnologia);
		colocarImagenRopa(ropa);
		colocarImagenAlimentacion(alimentacion);
		colocarImagenVideojuegos(videojuegos);
		colocarImagenFrutas(frutas);
	}

	private void colocarImagenRopa(boolean opcion) {

		if (comboBoxProducto.getSelectedItem() == ListaProductos.CAMISETA) {
			camisetas.setVisible(true);
			pantalones.setVisible(false);
			zapatillas.setVisible(false);
			if (comboBoxMarca.getSelectedItem() == Marca.ADIDAS) {
				Imgcamiseta = new ImageIcon(this.getClass().getResource(
						"/img/productos/camisetadidas.jpg")).getImage();
				camisetas.setIcon(new ImageIcon(Imgcamiseta));
			} else if (comboBoxMarca.getSelectedItem() == Marca.NIKE) {
				Imgcamiseta = new ImageIcon(this.getClass().getResource(
						"/img/productos/camisetanike.jpg")).getImage();
				camisetas.setIcon(new ImageIcon(Imgcamiseta));
			} else if (comboBoxMarca.getSelectedItem() == Marca.REEBOK) {
				Imgcamiseta = new ImageIcon(this.getClass().getResource(
						"/img/productos/camisetareebok.jpg")).getImage();
				camisetas.setIcon(new ImageIcon(Imgcamiseta));
			}
		}

		if (comboBoxProducto.getSelectedItem() == ListaProductos.PANTALÓN) {
			camisetas.setVisible(false);
			pantalones.setVisible(true);
			zapatillas.setVisible(false);
			if (comboBoxMarca.getSelectedItem() == Marca.ADIDAS) {
				Imgpantalon = new ImageIcon(this.getClass().getResource(
						"/img/productos/pantalonadidas.jpg")).getImage();
				pantalones.setIcon(new ImageIcon(Imgpantalon));
			} else if (comboBoxMarca.getSelectedItem() == Marca.NIKE) {
				Imgpantalon = new ImageIcon(this.getClass().getResource(
						"/img/productos/pantalonnike.jpg")).getImage();
				pantalones.setIcon(new ImageIcon(Imgpantalon));
			} else if (comboBoxMarca.getSelectedItem() == Marca.REEBOK) {
				Imgpantalon = new ImageIcon(this.getClass().getResource(
						"/img/productos/pantalonreebok.jpg")).getImage();
				pantalones.setIcon(new ImageIcon(Imgpantalon));
			}
		}

		if (comboBoxProducto.getSelectedItem() == ListaProductos.ZAPATILLAS) {
			camisetas.setVisible(false);
			pantalones.setVisible(false);
			zapatillas.setVisible(true);
			if (comboBoxMarca.getSelectedItem() == Marca.ADIDAS) {
				Imgzapatilla = new ImageIcon(this.getClass().getResource(
						"/img/productos/zapatillasadidas.jpg")).getImage();
				zapatillas.setIcon(new ImageIcon(Imgzapatilla));
			} else if (comboBoxMarca.getSelectedItem() == Marca.NIKE) {
				Imgzapatilla = new ImageIcon(this.getClass().getResource(
						"/img/productos/zapatillasnike.jpg")).getImage();
				zapatillas.setIcon(new ImageIcon(Imgzapatilla));
			} else if (comboBoxMarca.getSelectedItem() == Marca.REEBOK) {
				Imgzapatilla = new ImageIcon(this.getClass().getResource(
						"/img/productos/zapatillasreebok.jpg")).getImage();
				zapatillas.setIcon(new ImageIcon(Imgzapatilla));
			}
		}

		if (opcion == false) {
			camisetas.setVisible(false);
			pantalones.setVisible(false);
			zapatillas.setVisible(false);
		}

	}

	private void colocarImagenTecnologia(boolean opcion) {
		if (comboBoxProducto.getSelectedItem() == ListaProductos.SOBREMESA) {
			sobremesa.setVisible(true);
			tv.setVisible(false);
			portatil.setVisible(false);

		}

		else if (comboBoxProducto.getSelectedItem() == ListaProductos.PORTÁTIL) {
			sobremesa.setVisible(false);
			tv.setVisible(false);
			portatil.setVisible(true);

		} else if (comboBoxProducto.getSelectedItem() == ListaProductos.TV) {
			sobremesa.setVisible(false);
			tv.setVisible(true);
			portatil.setVisible(false);

		}

		if (opcion == false) {
			sobremesa.setVisible(false);
			tv.setVisible(false);
			portatil.setVisible(false);
		}

	}

	private void colocarImagenAlimentacion(boolean opcion) {
		if (comboBoxProducto.getSelectedItem() == ListaProductos.CARNE) {
			carne.setVisible(true);
			pescado.setVisible(false);
			pan.setVisible(false);

		}

		else if (comboBoxProducto.getSelectedItem() == ListaProductos.PESCADO) {
			carne.setVisible(false);
			pan.setVisible(false);
			pescado.setVisible(true);

		} else if (comboBoxProducto.getSelectedItem() == ListaProductos.PAN) {
			carne.setVisible(false);
			pan.setVisible(true);
			pescado.setVisible(false);

		}

		if (opcion == false) {
			pescado.setVisible(false);
			pan.setVisible(false);
			carne.setVisible(false);
		}

	}

	private void colocarImagenFrutas(boolean opcion) {
		if (comboBoxProducto.getSelectedItem() == ListaProductos.MANZANAS) {
			manzanas.setVisible(true);
			melocotones.setVisible(false);
			naranjas.setVisible(false);

		}

		else if (comboBoxProducto.getSelectedItem() == ListaProductos.MELOCOTONES) {
			naranjas.setVisible(false);
			manzanas.setVisible(false);
			melocotones.setVisible(true);

		} else if (comboBoxProducto.getSelectedItem() == ListaProductos.NARANJAS) {
			melocotones.setVisible(false);
			naranjas.setVisible(true);
			manzanas.setVisible(false);

		}

		if (opcion == false) {
			manzanas.setVisible(false);
			melocotones.setVisible(false);
			naranjas.setVisible(false);
		}

	}

	private void colocarImagenVideojuegos(boolean opcion) {
		if (comboBoxProducto.getSelectedItem() == ListaProductos.WII) {
			wii.setVisible(true);
			xbox.setVisible(false);
			ps4.setVisible(false);

		}

		else if (comboBoxProducto.getSelectedItem() == ListaProductos.XBOXONE) {
			wii.setVisible(false);
			ps4.setVisible(false);
			xbox.setVisible(true);

		} else if (comboBoxProducto.getSelectedItem() == ListaProductos.PS4) {
			xbox.setVisible(false);
			ps4.setVisible(true);
			wii.setVisible(false);

		}

		if (opcion == false) {
			ps4.setVisible(false);
			xbox.setVisible(false);
			wii.setVisible(false);
		}

	}

	private void annadirProducto(Zona zona, Hipermercado hipermercado,
			ListaProductos producto, String barras)
			throws NumberFormatException, ProductoYaExistenteException,
			ExistenciasInvalidasException, CodigoBarrasNoValidoException,
			ParseException, HeadlessException {
		if (Producto.esValido(barras, zona))
			switch (zona) {
			case ROPA:
				elegirRopa(hipermercado, producto);

				break;
			case TECNOLOGIA:
				elegirTecnologia(hipermercado, producto);
				break;
			case ALIMENTACION:
				elegirAlimentacion(hipermercado, producto);
				break;
			case FRUTERIA:
				elegirFruteria(hipermercado, producto);
				break;
			case VIDEOJUEGOS:
				elegirVideojuegos(hipermercado, producto);
				break;
			default:
				break;
			}
		else
			throw new CodigoBarrasNoValidoException("");

	}

	private void elegirAlimentacion(Hipermercado hipermercado,
			ListaProductos producto) throws ProductoYaExistenteException,
			ExistenciasInvalidasException {

		switch (producto) {
		case CARNE:
			Alimentacion carne;

			try {
				carne = new Carne(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						formato.parse(txtFechadeCaducidad.getText()));
				if (hipermercado.annadir(carne, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Carne añadida con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Formato de fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (FechaCaducidadInvalidaException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;
		case PESCADO:
			Alimentacion pescado;
			try {
				pescado = new Pescado(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						formato.parse(txtFechadeCaducidad.getText()));

				if (hipermercado.annadir(pescado, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Pescado añadido con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Formato de fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (FechaCaducidadInvalidaException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;

		case PAN:
			Alimentacion pan;
			try {
				pan = new Pan(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						formato.parse(txtFechadeCaducidad.getText()));

				if (hipermercado.annadir(pan, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Pan añadido con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Formato de fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (FechaCaducidadInvalidaException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;
		default:
			break;
		}

	}

	private void elegirTecnologia(Hipermercado hipermercado,
			ListaProductos producto) throws ProductoYaExistenteException,
			NumberFormatException, ExistenciasInvalidasException {
		switch (producto) {
		case TV:
			try {
				Tecnologia tv = new TV(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Fabricante) comboBoxFabricante.getSelectedItem());
				if (hipermercado.annadir(tv, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"TV añadida con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case PORTÁTIL:
			try {
				Tecnologia portatil = new Portatil(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Fabricante) comboBoxFabricante.getSelectedItem());
				if (hipermercado.annadir(portatil, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Portátil añadido con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case SOBREMESA:
			try {
				Tecnologia sobremesa = new Sobremesa(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Fabricante) comboBoxFabricante.getSelectedItem());
				if (hipermercado.annadir(sobremesa, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Sobremesa añadido con éxito.");

					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		default:
			break;
		}
	}

	private void elegirRopa(Hipermercado hipermercado, ListaProductos producto)
			throws NumberFormatException, ExistenciasInvalidasException {
		switch (producto) {
		case CAMISETA:
			try {
				Ropa camiseta = new Camiseta(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Marca) comboBoxMarca.getSelectedItem(),
						(Talla) comboBoxTallaEnum.getSelectedItem());

				if (hipermercado.annadir(camiseta, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Camiseta añadida con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case PANTALÓN:
			try {
				Ropa pantalon = new Pantalon(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Marca) comboBoxMarca.getSelectedItem(),
						(Talla) comboBoxTallaEnum.getSelectedItem());
				if (hipermercado.annadir(pantalon, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Pantalón añadido con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case ZAPATILLAS:
			try {
				Ropa zapatillas = new Zapatillas(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						Integer.parseInt((String) comboBoxTallas
								.getSelectedItem()),
						(Marca) comboBoxMarca.getSelectedItem());
				if (hipermercado.annadir(zapatillas, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Zapatillas añadidas con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		default:
			break;
		}
	}

	private void elegirFruteria(Hipermercado hipermercado,
			ListaProductos producto) throws ProductoYaExistenteException,
			ExistenciasInvalidasException {
		switch (producto) {
		case MANZANAS:

			try {
				Fruteria manzanas = new Manzanas(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Origen) comboBoxOrigen.getSelectedItem(),
						formato.parse(txtFechadeCaducidad.getText()));

				if (hipermercado.annadir(manzanas, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Manzanas añadidas con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Formato de fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (FechaCaducidadInvalidaException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;
		case NARANJAS:

			try {
				Fruteria naranjas = new Naranjas(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Origen) comboBoxOrigen.getSelectedItem(),
						formato.parse(txtFechadeCaducidad.getText()));

				if (hipermercado.annadir(naranjas, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Naranjas añadidas con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Formato de fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (FechaCaducidadInvalidaException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;

		case MELOCOTONES:

			try {
				Fruteria melocotones = new Melocotones(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()),
						(Origen) comboBoxOrigen.getSelectedItem(),
						formato.parse(txtFechadeCaducidad.getText()));

				if (hipermercado.annadir(melocotones, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Melocotones añadidos con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Formato de fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (FechaCaducidadInvalidaException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Fecha de caducidad inválida", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;
		default:
			break;
		}

	}

	private void elegirVideojuegos(Hipermercado hipermercado,
			ListaProductos producto) {
		switch (producto) {
		case PS4:
			try {
				Videojuegos ps4 = new PS4(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()));

				if (hipermercado.annadir(ps4, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"PS4 añadida con éxito.");
					limpiar();
				}

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case XBOXONE:
			try {
				Videojuegos xbox = new Xbox(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()));
				if (hipermercado.annadir(xbox, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Xbox añadida con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case WII:
			try {
				Videojuegos wii = new Wii(
						(ListaProductos) comboBoxProducto.getSelectedItem(),
						txtBarras.getText(), Float.parseFloat(txtPrecio
								.getText()),
						(Zona) comboBoxZona.getSelectedItem(),
						Integer.parseInt(txtExistencias.getText()),
						Integer.parseInt(txtMinimos.getText()));
				if (hipermercado.annadir(wii, txtBarras.getText())) {
					JOptionPane.showMessageDialog(contentPanel,
							"Zapatillas añadidas con éxito.");
					limpiar();
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Rellena todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ProductoYaExistenteException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Producto ya existente.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (ExistenciasInvalidasException e1) {
				JOptionPane
						.showMessageDialog(
								contentPanel,
								"Las existencias no pueden ser menores que la cantidad mínima.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		default:
			break;
		}
	}

	private void actualizarNumero(JTextField texto, JSlider slider) {

		if (texto.getDocument().getLength() > 0) {
			try {
				slider.setValue(Integer.valueOf(texto.getText()));
			} catch (NumberFormatException e) {
				texto.setForeground(Color.RED);
			} catch (IllegalStateException e) {
				texto.setForeground(Color.RED);
			}

		}
	}
}
