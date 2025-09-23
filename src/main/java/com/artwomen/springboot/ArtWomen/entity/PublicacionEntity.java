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
@Table(name="publicacion")
public class PublicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(50)", name = "nombreAutor")
    private String nombreAutorPublicacion;

    @Column(nullable = false, columnDefinition = "varchar(200)", name = "apellidoAutor")
    private String apellidoAutorPublicacion;

    @Column(nullable = false, columnDefinition = "varchar(500)", name = "titulo")
    private String tituloPublicacion;

    private int anhoPublicacion;

    @Column(nullable = false, columnDefinition = "varchar(150)", name = "editorial")
    private String editorialPublicacion;

    @Column(nullable = false)
    private boolean visible = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "fechaCreacion")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    public void Publicacion() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreAutorPublicacion() {
        return nombreAutorPublicacion;
    }

    public void setNombreAutorPublicacion(String nombreAutorPublicacion) {
        this.nombreAutorPublicacion = nombreAutorPublicacion;
    }

    public String getApellidoAutorPublicacion() {
        return apellidoAutorPublicacion;
    }

    public void setApellidoAutorPublicacion(String apellidoAutorPublicacion) {
        this.apellidoAutorPublicacion = apellidoAutorPublicacion;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    public int getAnhoPublicacion() {
        return anhoPublicacion;
    }

    public void setAnhoPublicacion(int anhoPublicacion) {
        this.anhoPublicacion = anhoPublicacion;
    }

    public String getEditorialPublicacion() {
        return editorialPublicacion;
    }

    public void setEditorialPublicacion(String editorialPublicacion) {
        this.editorialPublicacion = editorialPublicacion;
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
