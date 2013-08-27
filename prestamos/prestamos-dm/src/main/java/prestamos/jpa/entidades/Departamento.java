package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_departamento database table.
 * 
 */
@Entity
@Table(name="tbl_departamento")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="tblDepartamento")
	private List<Municipio> tblMunicipios;

	public Departamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Municipio> getTblMunicipios() {
		return this.tblMunicipios;
	}

	public void setTblMunicipios(List<Municipio> tblMunicipios) {
		this.tblMunicipios = tblMunicipios;
	}

	public Municipio addTblMunicipio(Municipio tblMunicipio) {
		getTblMunicipios().add(tblMunicipio);
		tblMunicipio.setTblDepartamento(this);

		return tblMunicipio;
	}

	public Municipio removeTblMunicipio(Municipio tblMunicipio) {
		getTblMunicipios().remove(tblMunicipio);
		tblMunicipio.setTblDepartamento(null);

		return tblMunicipio;
	}

}