package com.artwomen.springboot.ArtWomen.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="obra")
public class ObraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(500)", name = "nombre")
    private String nombreObra;

    @Column(nullable = false, columnDefinition = "varchar(250)", name = "imagen")
    private String imagenObra;

    @Column(nullable = false, columnDefinition = "varchar(2000)", name = "descripcion")
    private String descripcionObra;

    @Column(nullable = false, columnDefinition = "varchar(250)", name = "movimiento")
    private String movimientoObra;

    @Column(nullable = false)
    private boolean visible = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "fechaCreacion")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rama_id")
    private RamaEntity rama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id")
    private ArtistaEntity artista;

    public ObraEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public String getImagenObra() {
        return imagenObra;
    }

    public void setImagenObra(String imagenObra) {
        this.imagenObra = imagenObra;
    }

    public String getDescripcionObra() {
        return descripcionObra;
    }

    public void setDescripcionObra(String descripcionObra) {
        this.descripcionObra = descripcionObra;
    }

    public String getMovimientoObra() {
        return movimientoObra;
    }

    public void setMovimientoObra(String movimientoObra) {
        this.movimientoObra = movimientoObra;
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

    public RamaEntity getRama() {
        return rama;
    }

    public void setRama(RamaEntity rama) {
        this.rama = rama;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public ArtistaEntity getArtista() {
        return artista;
    }

    public void setArtista(ArtistaEntity artista) {
        this.artista = artista;
    }
}
