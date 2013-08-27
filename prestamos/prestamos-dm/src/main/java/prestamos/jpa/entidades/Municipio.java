package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_municipio database table.
 * 
 */
@Entity
@Table(name="tbl_municipio")
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento tblDepartamento;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="tblMunicipio")
	private List<Persona> tblPersonas;

	public Municipio() {
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

	public Departamento getTblDepartamento() {
		return this.tblDepartamento;
	}

	public void setTblDepartamento(Departamento tblDepartamento) {
		this.tblDepartamento = tblDepartamento;
	}

	public List<Persona> getTblPersonas() {
		return this.tblPersonas;
	}

	public void setTblPersonas(List<Persona> tblPersonas) {
		this.tblPersonas = tblPersonas;
	}

	public Persona addTblPersona(Persona tblPersona) {
		getTblPersonas().add(tblPersona);
		tblPersona.setTblMunicipio(this);

		return tblPersona;
	}

	public Persona removeTblPersona(Persona tblPersona) {
		getTblPersonas().remove(tblPersona);
		tblPersona.setTblMunicipio(null);

		return tblPersona;
	}

}