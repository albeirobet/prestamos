package prestamos.controlador;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AccionPersona implements Serializable {

	private static final long serialVersionUID = 4131668062123485276L;
	private String cedula;
	private String direccion;
	private Date   fechaNacimiento;
	private String primerApellido;
	private String primerNombre;
	private String segundoApellido;
	private String segundoNombre;
	private String telefonoFijo;
	private String telefonoMovil;
	private SelectItem comboDepartamentos;
	
	public AccionPersona(){
		cedula= "x";
		direccion="";
		fechaNacimiento = new Date();
		primerApellido="";
		primerNombre="";
		segundoApellido="";
		segundoNombre="";
		telefonoFijo="";
		telefonoMovil="";
		comboDepartamentos = new SelectItem();
		
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public String getTelefonoMovil() {
		return telefonoMovil;
	}
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	
	public void MostrarDatos(){
		System.out.println("Estos son los datos capturados:  "+cedula);
	}
	
}
