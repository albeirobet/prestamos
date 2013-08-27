package prestamos.bo.impl;



import javax.ejb.Stateless;
import javax.inject.Inject;

import prestamos.bo.PruebaBO;
import prestamos.dao.PruebaDAO;



@Stateless
public class PruebaBOImpl implements PruebaBO{

	@Inject
	PruebaDAO pruebaDAO;
	@Override
	public void pruebaFuncion() {
		System.out.println("Llegue hasta el pruebaFuncion de BOImpl");
		pruebaDAO.pruebaFuncion();
		
	}

}
