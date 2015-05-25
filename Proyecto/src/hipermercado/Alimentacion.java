package hipermercado;

import java.util.Date;

public class Alimentacion extends Producto {
	private Date fechaCaducidad;
	public Alimentacion(ListaProductos nombre, String codigoBarras,
			float precio, Zona zona, int existencias, int minimo, Date fechaCaducidad) {
		super(nombre, codigoBarras, precio, zona, existencias, minimo);
		this.fechaCaducidad=fechaCaducidad;
		// TODO Auto-generated constructor stub
	}

}
