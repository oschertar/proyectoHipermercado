package hipermercado;

import java.util.regex.Pattern;


public class Producto implements IVA{

	protected ListaProductos nombre;
	protected String codigoBarras; //5 dígitos + (RO, TE, AL, FR, VI)
	protected Float precio;
	protected Zona zona;
	protected int existencias;
	protected int minimo;
	
	public static final Pattern patternCodigoBarras = Pattern
			.compile("^(\\d){5}[ -]?(RO|TE|AL|FR|VI)$");

	/**
	 * @param listaProductos
	 * @param codigoBarras
	 * @param precio
	 * @param zona
	 * @param existencias
	 * @param minimo
	 * 
	 */
	Producto(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int existencias, int minimo) {
		super();
		this.nombre = nombre;
		this.codigoBarras = codigoBarras;
		setPrecio((float) calcularIVA(precio));
		this.zona = zona;
		this.existencias=existencias;
		this.minimo=minimo;
	}
	
	private ListaProductos getNombre() {
		return nombre;
	}

	private void setNombre(ListaProductos nombre) {
		this.nombre = nombre;
	}

	private Float getPrecio() {
		return precio;
	}
	
	private void setPrecio(float d) {
		this.precio = d;
	}

	public Zona getZona() {
		return zona;
	}

	private void setZona(Zona zona) {
		this.zona = zona;
	}

	private String getCodigoBarras() {
		return codigoBarras;
	}


	
	

	int getExistencias() {
		return existencias;
	}

	/**
	 * @param existencias
	 *            the existencias to set
	 * @throws ExistenciasInvalidasException
	 *             Cuando el número de existencias es negativo
	 */
	private void setExistencias(int existencias)
			throws ExistenciasInvalidasException {
		if (existencias < 0)
			throw new ExistenciasInvalidasException(
					"Las existencias no pueden ser negativas");
		this.existencias = existencias;
	}





	public static boolean esValido(String codigoBarras) {
		return patternCodigoBarras.matcher(codigoBarras).matches();
	}
	
	private void setCodigoBarras(String codigoBarras)
			throws CodigoBarrasNoValidoException {
		if (esValido(codigoBarras))
			this.codigoBarras = codigoBarras;
		else
			throw new CodigoBarrasNoValidoException("");

	}
	
	/**
	 * @return the minimo
	 */
	int getMinimo() {
		return minimo;
	}

	/**
	 * @param minimo
	 *            the minimo to set
	 */
	void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	/**
	 * Muestra un artículo
	 */
	public void mostrar() {
		System.out.print(toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "\nArticulo ["
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ "\texistencias=" + getExistencias() + ", \tminimo=" + minimo
				+ "]";
	}

	public boolean bajoMinimos() {
		if (getExistencias() < getMinimo())
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/**
	 * Indica si otro artículo es similar a este. Se fija en el nombre del
	 * artículo, obviando el resto de atributos
	 * 
	 * @param obj
	 *            artículo con el que se compara
	 * @return true si el artículo this es similar al objeto obj. false en otro
	 *         caso
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	void incrementar(int incremento) throws IncrementoNegativoException {
		if (incremento < 0)
			throw new IncrementoNegativoException(
					"El incremento no puede ser negativo");
		try {
			setExistencias(getExistencias() + incremento);
		} catch (ExistenciasInvalidasException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Decrementa las existencias del artículo en una cantidad indicada
	 * 
	 * @param decremento
	 *            cantidad a decrementar
	 * @throws ExistenciasInvalidasException
	 *             Cuando el número de existencias es negativo
	 * @throws DecrementoInvalidoException
	 */
	void decrementar(int decremento) throws ExistenciasInvalidasException,
			DecrementoInvalidoException {
		if (decremento < 0)
			throw new DecrementoInvalidoException(
					"El decremento no puede ser negativo");
		setExistencias(getExistencias() - decremento);

	}

	
	public double calcularIVA(double precio) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
