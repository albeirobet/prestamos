package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_cliente database table.
 * 
 */
@Entity
@Table(name="tbl_cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario tblUsuario;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(Usuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

}