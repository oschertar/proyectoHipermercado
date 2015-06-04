package hipermercado;

import java.io.Serializable;



public class Camiseta extends Ropa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6278492149329537829L;
	/**
	 * 
	 */
	private Talla talla;
	public Camiseta(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int articulos, int minimo, Marca marca, Talla talla) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, articulos, minimo, marca);
		this.talla=talla;
		
	}
	
	
	

	public Talla getTalla() {
		return talla;
	}
	private void setTalla(Talla talla) {
		this.talla = talla;
	}
}
