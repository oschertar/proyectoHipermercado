package hipermercado;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;



public abstract class Alimentacion extends Producto implements IVA, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8063856270800645279L;
	private Date fechaCaducidad;
	private DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
	
	
	private static final Pattern patternFecha = Pattern
			.compile("^((0[1-9])|([1-2][0-9])|(3[0-1]))\\/((0[1-9])|(1[0-2]))\\/([1-9][0-9][0-9][0-9])$");
	public Alimentacion(ListaProductos nombre, String codigoBarras,
			float precio, Zona zona, int existencias, int minimo, Date fechaCaducidad) throws ExistenciasInvalidasException, FechaCaducidadInvalidaException {
		super(nombre, codigoBarras, precio, zona, existencias, minimo);
		setFechaCaducidad(fechaCaducidad);
		// TODO Auto-generated constructor stub
	}
	
	
	public static boolean esValido(String fecha) {
		return patternFecha.matcher(fecha).matches();
	}

	public String getFechaCaducidad() {
		
		return formato.format(fechaCaducidad);
	}

	private void setFechaCaducidad(Date fechaCaducidad) throws FechaCaducidadInvalidaException{
		Calendar hoy = Calendar.getInstance();
		long fechaActual = hoy.getTimeInMillis()/(1000*60*60*24);
		
		long fecha= (fechaCaducidad.getTime())/(1000*60*60*24);
		if(fecha<fechaActual)
			throw new FechaCaducidadInvalidaException("La fecha de caducidad que has introducido es inválida");
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public float calcularIVA(float precio){
		precio=(float) (precio*IVA._1_1); //10% IVA aplicado en Alimentación
		return precio;
	}
	
	public static float implementarOferta(float precio){
		precio=(float) (precio*0.50);
		return precio;
	}
	
	
}
