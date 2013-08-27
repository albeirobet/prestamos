package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_persona database table.
 * 
 */
@Entity
@Table(name="tbl_persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cedula;

	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	@Column(name="telefono_fijo")
	private String telefonoFijo;

	@Column(name="telefono_movil")
	private String telefonoMovil;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio tblMunicipio;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tblPersona")
	private List<Usuario> tblUsuarios;

	public Persona() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return this.telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public Municipio getTblMunicipio() {
		return this.tblMunicipio;
	}

	public void setTblMunicipio(Municipio tblMunicipio) {
		this.tblMunicipio = tblMunicipio;
	}

	public List<Usuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(List<Usuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	public Usuario addTblUsuario(Usuario tblUsuario) {
		getTblUsuarios().add(tblUsuario);
		tblUsuario.setTblPersona(this);

		return tblUsuario;
	}

	public Usuario removeTblUsuario(Usuario tblUsuario) {
		getTblUsuarios().remove(tblUsuario);
		tblUsuario.setTblPersona(null);

		return tblUsuario;
	}

}