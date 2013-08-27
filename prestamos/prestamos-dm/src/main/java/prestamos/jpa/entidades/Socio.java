package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_socio database table.
 * 
 */
@Entity
@Table(name="tbl_socio")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Inversiones
	@OneToMany(mappedBy="tblSocio")
	private List<Inversiones> tblInversiones;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario tblUsuario;

	public Socio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Inversiones> getTblInversiones() {
		return this.tblInversiones;
	}

	public void setTblInversiones(List<Inversiones> tblInversiones) {
		this.tblInversiones = tblInversiones;
	}

	public Inversiones addTblInversione(Inversiones tblInversione) {
		getTblInversiones().add(tblInversione);
		tblInversione.setTblSocio(this);

		return tblInversione;
	}

	public Inversiones removeTblInversione(Inversiones tblInversione) {
		getTblInversiones().remove(tblInversione);
		tblInversione.setTblSocio(null);

		return tblInversione;
	}

	public Usuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(Usuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

}