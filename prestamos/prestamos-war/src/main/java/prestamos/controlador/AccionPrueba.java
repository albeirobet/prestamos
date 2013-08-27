package prestamos.controlador;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import prestamos.bo.PruebaBO;

@Named
@ApplicationScoped
public class AccionPrueba implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6219350501926337414L;
	private int num1;
	private int num2;
	private int total;
	private Date date;
	
	

	@Inject
	PruebaBO pruebaBO;
	
	public AccionPrueba (){
		num1=0;
		num2=0;
		total=0;
		date = new Date();
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void sumarNumeros(){
		total=num1+num2;
		System.out.println("El total es el siguiente-->"+total);
		pruebaBO.pruebaFuncion();
	}

}
