package com.artwomen.springboot.ArtWomen.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="enlace")
public class EnlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(250)", name = "nombre")
    private String nombreEnlace;

    @Column(nullable = false, columnDefinition = "varchar(250)", name = "link")
    private String linkEnlace;

    @Column(nullable = false, columnDefinition = "varchar(2000)", name = "decripcion")
    private String descripcionEnlace;

    @Column(nullable = false)
    private boolean visible = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "fechaCreacion")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    public void EnlaceEntity() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreEnlace() {
        return nombreEnlace;
    }

    public void setNombreEnlace(String nombreEnlace) {
        this.nombreEnlace = nombreEnlace;
    }

    public String getLinkEnlace() {
        return linkEnlace;
    }

    public void setLinkEnlace(String linkEnlace) {
        this.linkEnlace = linkEnlace;
    }

    public String getDescripcionEnlace() {
        return descripcionEnlace;
    }

    public void setDescripcionEnlace(String descripcionEnlace) {
        this.descripcionEnlace = descripcionEnlace;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

}
