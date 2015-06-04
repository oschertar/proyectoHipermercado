package hipermercado;

import java.io.Serializable;
import java.util.regex.Pattern;

public abstract class Producto implements IVA, Serializable,
		Comparable<Producto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393956186083517403L;
	protected ListaProductos nombre;
	protected String codigoBarras; // 5 dígitos + (RO, TE, AL, FR, VI)
	protected Float precio;
	protected Zona zona;
	protected int existencias;
	protected int minimo;

	public static final Pattern patternCodigoBarras = Pattern
			.compile("^(\\d){5}(RO|TE|AL|FR|VI)$");
	public static final Pattern patternCodigoBarrasAlimentacion = Pattern
			.compile("^(\\d){5}(AL)$");
	public static final Pattern patternCodigoBarrasRopa = Pattern
			.compile("^(\\d){5}(RO)$");
	public static final Pattern patternCodigoBarrasTecnologia = Pattern
			.compile("^(\\d){5}(TE)$");
	public static final Pattern patternCodigoBarrasFruteria = Pattern
			.compile("^(\\d){5}(FR)$");
	public static final Pattern patternCodigoBarrasVideojuegos = Pattern
			.compile("^(\\d){5}(VI)$");

	/**
	 * @param listaProductos
	 * @param codigoBarras
	 * @param precio
	 * @param zona
	 * @param existencias
	 * @param minimo
	 * @throws ExistenciasInvalidasException
	 * 
	 */
	Producto(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int existencias, int minimo)
			throws ExistenciasInvalidasException {
		super();
		setNombre(nombre);
		setCodigoBarras(codigoBarras);
		setPrecio((float) calcularIVA(precio));
		setZona(zona);
		setMinimo(minimo);
		setExistencias(existencias);
	}

	public Producto(String barras) {
		this.codigoBarras = barras;
	}

	public Producto() {

	}

	public ListaProductos getNombre() {
		return nombre;
	}

	private void setNombre(ListaProductos nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(float d) {
		this.precio = d;
	}

	public Zona getZona() {
		return zona;
	}

	private void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias)
			throws ExistenciasInvalidasException {

		if (existencias <= getMinimo()) {
			throw new ExistenciasInvalidasException(
					"Las existencias no pueden ser menores que la cantidad mínima");
		}

		this.existencias = existencias;
	}

	public static boolean esValido(String codigoBarras, Zona zona) {
		switch (zona) {
		case ALIMENTACION:
			return patternCodigoBarrasAlimentacion.matcher(codigoBarras)
					.matches();
		case TECNOLOGIA:
			return patternCodigoBarrasTecnologia.matcher(codigoBarras)
					.matches();
		case FRUTERIA:
			return patternCodigoBarrasFruteria.matcher(codigoBarras).matches();
		case VIDEOJUEGOS:
			return patternCodigoBarrasVideojuegos.matcher(codigoBarras)
					.matches();
		case ROPA:
			return patternCodigoBarrasRopa.matcher(codigoBarras).matches();
		default:
			return false;
		}

	}

	private void setCodigoBarras(String codigoBarras, Zona zona)
			throws CodigoBarrasNoValidoException {
		if (esValido(codigoBarras, zona))
			this.codigoBarras = codigoBarras;
		else
			throw new CodigoBarrasNoValidoException("");

	}

	/**
	 * @return the minimo
	 */
	public int getMinimo() {
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

	public boolean bajoMinimos() {
		if (getExistencias() < getMinimo())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigoBarras=" + codigoBarras
				+ ", precio=" + precio + ", zona=" + zona + ", existencias="
				+ existencias + ", minimo=" + minimo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		Producto other = (Producto) obj;
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
			return false;
		return true;
	}

	public float calcularIVA(float precio) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	@Override
	public int compareTo(Producto producto) {

		int res;
		if (this.precio < producto.precio) {
			res = -1;
		}else if (this.precio > producto.precio) {
			res = 1;
		}else {
			res = 0;
		}
		return res;

	}

}
