package hipermercadoGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setResizable(false);
		setTitle("Ayuda");

		setBounds(100, 100, 589, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 573, 330);
		contentPanel.add(scrollPane);

		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		scrollPane.setViewportView(editor);
		editor.setContentType("text/html");
		editor.setText("<style type=\"text/css\">\r\n\tol.indice {\r\n\t\tfont-size: 17px;\r\n\t}\r\n\tol.ayuda {\r\n\t\tcolor: #000099;\r\n\t\tfont-weight: bold;\r\n\t\tfont-style: italic;\r\n\t}\r\n\tol.ayuda > li {\r\n\t\tmargin-bottom: 16px;\r\n\t}\r\n\tol.ayuda p {\r\n\t\tcolor: #000000;\r\n\t\tfont-weight: normal;\r\n\t\tfont-style: normal;\r\n\t}\r\n\tol.ayuda > li > ul {\r\n\t\tcolor: #000000;\r\n\t\tfont-weight: normal;\r\n\t\tfont-style: normal;\r\n\t}\r\n\tol.ayuda > li > ul > li > ul {\r\n\t\tmargin-bottom: 8px;\r\n\t}\r\n</style>\r\n<h1>Ayuda sobre Hipermercados</h1><br>\r\n<ol class=\"indice\">\r\n\t<li><a href=\"#1\">Hist\u00F3rico de versiones</a></li>\r\n\t<li><a href=\"#2\">Men\u00FA Inicio</a></li>\r\n\t<li><a href=\"#3\">Men\u00FA Comercio</a></li>\r\n\t<li><a href=\"#4\">Men\u00FA B\u00FAsqueda</a></li>\r\n</ol>\r\n<hr noshade=\"noshade\" />\r\n<ol class=\"ayuda\">\r\n\t<li>\r\n\t\t<a name=\"1\">Hist\u00F3rico de versiones</a>\r\n\t\t<p>v1.0. Programa funcional</p>\r\n\t</li>\r\n\t<li>\r\n\t\t<a name=\"2\">Men\u00FA Inicio</a>\r\n\t\t<ul>\r\n\t\t\t<li><b>Nuevo:</b> <i>(Atajo del teclado: Alt+N).</i> Se crea un hipermercado vac\u00EDo. Nos pregunta si queremos guardar el hipermercado que tenemos abierto en ese momento.</li>\r\n\t\t\t<li><b>Abrir:</b> <i>(Atajo del teclado: Alt+A).</i> Abrimos un hipermercado que anteriormente hayamos guardado en nuestro sistema.</li>\r\n\t\t\t<li><b>Guardar:</b> <i>(Atajo del teclado: Alt+S).</i> Guarda el concesionario que tengamos abierto.</li>\r\n\t\t\t<li><b>Guardar como:</b> <i>(Atajo del teclado: Alt+G).</i> Guarda el concesionario que tengamos abierto con un nombre distinto.</li>\r\n\t\t\t<li><b>Salir:</b> <i>(Atajo del teclado: Ctrl+ENTER).</i> Se cierra la aplicaci\u00F3n.</li>\r\n\t\t</ul>\r\n\t</li>\r\n\t<li>\r\n\t\t<a name=\"3\">Men\u00FA Comercio</a>\r\n\t\t<ul>\r\n\t\t\t<li><b>Comprar productos:</b> <i>(Atajo del teclado: Ctrl+C).</i> A\u00F1adir productos al hipermercado\r\n\t\t\t\t<ul>\r\n\t\t\t\t\t<li><b>Zona:</b> Blabla</li>\r\n\t\t\t\t\t<li><b>Precio:</b> Blabla</li>\r\n\t\t\t\t\t<li><b>Producto:</b> Blabla</li>\r\n\t\t\t\t\t<li><b>Fabricante:</b> Blabla</li>\r\n\t\t\t\t\t<li><b>C\u00F3digo de barras:</b> Blabla</li>\r\n\t\t\t\t\t<li><b>Art\u00EDculos a a\u00F1adir:</b> Blabla</li>\r\n\t\t\t\t\t<li><b>Unidades m\u00EDnimas:</b> Blabla</li>\r\n\t\t\t\t\t<li><b>Vista previa:</b> Blabla</li>\r\n\t\t\t\t</ul>\r\n\t\t\t</li>\r\n\t\t\t<li><b>Vender productos:</b> <i>(Atajo del teclado: Ctrl+V).</i> Blabla\r\n\t\t\t\t<ul>\r\n\t\t\t\t\t<li><b>C\u00F3digo de barras:</b> Blabla</li>\r\n\t\t\t\t</ul>\r\n\t\t\t</li>\r\n\t\t</ul>\r\n\t</li>\r\n\t<li>\r\n\t\t<a name=\"4\">Men\u00FA B\u00FAsqueda</a>\r\n\t\t<ul>\r\n\t\t\t<li><b>Mostrar hipermercado:</b> <i>(Atajo del teclado: Ctrl+M).</i> Blabla</li>\r\n\t\t\t<li><b>Por zona:</b> Podemos buscar los productos por varios criterios:\r\n\t\t\t\t<ul>\r\n\t\t\t\t\t<li><b>Alimentaci\u00F3n:</b> <i>(Atajo del teclado: Ctrl+A). </i>Blabla</li>\r\n\t\t\t\t\t<li><b>Fruter\u00EDa:</b> <i>(Atajo del teclado: Ctrl+F). </i>Blabla</li>\r\n\t\t\t\t\t<li><b>Ropa:</b> <i>(Atajo del teclado: Ctrl+R). </i>Blabla</li>\r\n\t\t\t\t\t<li><b>Tecnolog\u00EDa:</b> <i>(Atajo del teclado: Ctrl+T). </i>Blabla</li>\r\n\t\t\t\t\t<li><b>Videojuegos:</b> <i>(Atajo del teclado: Ctrl+J). </i>Blabla</li>\r\n\t\t\t\t</ul>\r\n\t\t\t</li>\r\n\t\t\t<li><b>Por c\u00F3digo de barras:</b> <i>(Atajo del teclado: Ctrl+B).</i> Blabla</li>\r\n\t\t</ul>\r\n\t</li>\r\n</ol>");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
