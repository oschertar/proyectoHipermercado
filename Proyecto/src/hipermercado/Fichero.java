package hipermercado;

import hipermercadoGUI.PrincipalGUI;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Fichero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static File fichero = new File("sin_titulo.gua");
	private static JFileChooser fileChooser = new JFileChooser();
	private static FileNameExtensionFilter filtro = new FileNameExtensionFilter(
			"objeto.gua", "gua");
	private static JFrame frame = new JFrame();

	public static void guardar(File file, Hipermercado hipermercado)
			throws IOException {
		file = annadirExtension(file);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file, false)))) {
			objectOutputStream.writeObject(hipermercado);

		}
	}

	public static Hipermercado abrir(Hipermercado hipermercado)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			fichero = fileChooser.getSelectedFile();
			PrincipalGUI.frmHipermercadoGuadalquivir
					.setTitle(fichero.getName());
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				fichero))) {
			hipermercado = (Hipermercado) in.readObject();
		}

		return hipermercado;
	}

	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(".gua"))
			return new File(archivo + ".gua");
		return archivo;
	}

	public static boolean confirmarSiExiste(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}

	public static File getFile() {
		return fichero;
	}

	public static void nuevo() {
		new File("sin_titulo.gua");
	}

	public static void guardar(Hipermercado hipermercado) throws IOException {
		if (fichero.getName() == "sin_titulo.gua")
			guardarComo(hipermercado);
		else {
			try (ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fichero + ".gua"))) {
				out.writeObject(hipermercado);
			}
		}
	}

	public static void guardarComo(Hipermercado hipermercado)
			throws FileNotFoundException, IOException {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			fichero = fileChooser.getSelectedFile();
			try (ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(Fichero.fichero + ".gua"))) {
				out.writeObject(hipermercado);
			}
		}
	}

}
