package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_usuario database table.
 * 
 */
@Entity
@Table(name="tbl_usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String clave;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tblUsuario")
	private List<Cliente> tblClientes;

	//bi-directional many-to-one association to Socio
	@OneToMany(mappedBy="tblUsuario")
	private List<Socio> tblSocios;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona tblPersona;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tblTipoUsuario;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Cliente> getTblClientes() {
		return this.tblClientes;
	}

	public void setTblClientes(List<Cliente> tblClientes) {
		this.tblClientes = tblClientes;
	}

	public Cliente addTblCliente(Cliente tblCliente) {
		getTblClientes().add(tblCliente);
		tblCliente.setTblUsuario(this);

		return tblCliente;
	}

	public Cliente removeTblCliente(Cliente tblCliente) {
		getTblClientes().remove(tblCliente);
		tblCliente.setTblUsuario(null);

		return tblCliente;
	}

	public List<Socio> getTblSocios() {
		return this.tblSocios;
	}

	public void setTblSocios(List<Socio> tblSocios) {
		this.tblSocios = tblSocios;
	}

	public Socio addTblSocio(Socio tblSocio) {
		getTblSocios().add(tblSocio);
		tblSocio.setTblUsuario(this);

		return tblSocio;
	}

	public Socio removeTblSocio(Socio tblSocio) {
		getTblSocios().remove(tblSocio);
		tblSocio.setTblUsuario(null);

		return tblSocio;
	}

	public Persona getTblPersona() {
		return this.tblPersona;
	}

	public void setTblPersona(Persona tblPersona) {
		this.tblPersona = tblPersona;
	}

	public TipoUsuario getTblTipoUsuario() {
		return this.tblTipoUsuario;
	}

	public void setTblTipoUsuario(TipoUsuario tblTipoUsuario) {
		this.tblTipoUsuario = tblTipoUsuario;
	}

}