package com.grupo15.easyflete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "fleteros_solicitudes_clientes")
@XmlRootElement
public class FleteroSolicitudCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "solicitud_id")
    private Integer solicitudId;
    @Column(name = "valoracion")
    private Integer valoracion;
    @Size(max = 300)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "fletero_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Fletero fleteroEmail;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Solicitud solicitud;

    public FleteroSolicitudCliente() {
    }

    public FleteroSolicitudCliente(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Fletero getFleteroEmail() {
        return fleteroEmail;
    }

    public void setFleteroEmail(Fletero fleteroEmail) {
        this.fleteroEmail = fleteroEmail;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
}
