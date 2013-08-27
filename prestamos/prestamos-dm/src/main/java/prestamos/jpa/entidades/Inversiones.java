package prestamos.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_inversiones database table.
 * 
 */
@Entity
@Table(name="tbl_inversiones")
@NamedQuery(name="Inversiones.findAll", query="SELECT i FROM Inversiones i")
public class Inversiones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inversion")
	private Date fechaInversion;

	@Column(name="monto_invertido")
	private int montoInvertido;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio tblSocio;

	public Inversiones() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaInversion() {
		return this.fechaInversion;
	}

	public void setFechaInversion(Date fechaInversion) {
		this.fechaInversion = fechaInversion;
	}

	public int getMontoInvertido() {
		return this.montoInvertido;
	}

	public void setMontoInvertido(int montoInvertido) {
		this.montoInvertido = montoInvertido;
	}

	public Socio getTblSocio() {
		return this.tblSocio;
	}

	public void setTblSocio(Socio tblSocio) {
		this.tblSocio = tblSocio;
	}

}