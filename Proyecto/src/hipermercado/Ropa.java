package hipermercado;

import java.io.Serializable;



public  class Ropa extends Producto implements IVA, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4538504182860008907L;
	protected Marca marca;
	public Ropa(ListaProductos listaProductos, String codigoBarras, float precio, Zona zona, int articulos, int minimo, Marca marca) throws ExistenciasInvalidasException {
		super(listaProductos, codigoBarras, precio, zona, articulos, minimo);
		
		this.marca=marca;
	}
	
	
	@Override
	public float calcularIVA(float precio){
		precio= (float) (precio*IVA._1_21); //21% IVA aplicado en Ropa
		return precio;
	}

	
	public Marca getMarca() {
		return marca;
	}

	private void setMarca(Marca marca) {
		this.marca = marca;
	}



	
	
	
}
