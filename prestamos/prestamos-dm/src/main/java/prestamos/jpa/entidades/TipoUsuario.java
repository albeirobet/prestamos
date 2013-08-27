package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_tipo_usuario database table.
 * 
 */
@Entity
@Table(name="tbl_tipo_usuario")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String tipo;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tblTipoUsuario")
	private List<Usuario> tblUsuarios;

	public TipoUsuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Usuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(List<Usuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	public Usuario addTblUsuario(Usuario tblUsuario) {
		getTblUsuarios().add(tblUsuario);
		tblUsuario.setTblTipoUsuario(this);

		return tblUsuario;
	}

	public Usuario removeTblUsuario(Usuario tblUsuario) {
		getTblUsuarios().remove(tblUsuario);
		tblUsuario.setTblTipoUsuario(null);

		return tblUsuario;
	}

}