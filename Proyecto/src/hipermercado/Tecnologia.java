package hipermercado;

import java.io.Serializable;



public  class Tecnologia extends Producto implements IVA, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 113275241594690556L;
	private Fabricante fabricante;
	
	public Tecnologia(ListaProductos nombre, String codigoBarras, float precio, Zona zona, int articulos, int minimo,Fabricante fabricante) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, articulos, minimo);
		setFabricante(fabricante);
	}
	@Override
	public float calcularIVA(float precio){
		precio=(float) (precio*IVA._1_21); //21% IVA aplicado en Tecnologia
		return precio;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	
	
	
}