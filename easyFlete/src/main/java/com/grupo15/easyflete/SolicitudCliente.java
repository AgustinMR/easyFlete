package com.grupo15.easyflete;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "solicitudes_clientes")
public class SolicitudCliente implements Serializable {

    @Size(max = 10)
    @Column(name = "hora")
    private String hora;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "solicitud_id")
    private Integer solicitudId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Solicitud solicitud;
    @JoinColumn(name = "cliente_email", referencedColumnName = "username")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente clienteEmail;

    public SolicitudCliente() {
    }

    public SolicitudCliente(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public SolicitudCliente(Integer solicitudId, Date fecha) {
        this.solicitudId = solicitudId;
        this.fecha = fecha;
    }
    
    public SolicitudCliente(Date fecha, Solicitud solicitud, Cliente clienteEmail) {
        this.fecha = fecha;
        this.solicitud = solicitud;
        this.clienteEmail = clienteEmail;
    }

    public SolicitudCliente(Integer solicitudId, Date fecha, Cliente clienteEmail, String hora) {
        this.solicitudId = solicitudId;
        this.fecha = fecha;
        this.clienteEmail = clienteEmail;
        this.hora = hora;
    }

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Cliente getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(Cliente clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
