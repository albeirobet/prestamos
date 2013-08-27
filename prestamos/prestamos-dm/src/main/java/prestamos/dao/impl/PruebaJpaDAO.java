package prestamos.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import prestamos.dao.PruebaDAO;
import prestamos.jpa.entidades.Departamento;;

public class PruebaJpaDAO  implements PruebaDAO{

	@PersistenceContext(unitName = "prestamos-dm")
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Override
	public void pruebaFuncion() {
		System.out.println("Llegue al pruebaFuncion del PruebaJpaDAO");	
		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		try{
			String jpql = "SELECT dep FROM " + Departamento.class.getSimpleName() + " dep ";
			Query query = em.createQuery(jpql);
			listaDepartamentos = query.getResultList();
			System.out.println("El tamaño de la lista Departamentos es:  "	+ listaDepartamentos.size());
			}catch(Exception e){
				System.out.println("Se presentro un error al realizar la consulta de Departamentos:  "	+ e);	
		}
	}

}
