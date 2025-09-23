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
@Table(name="artista")
public class ArtistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(50)", name = "nombre")
    private String nombreArtista;

    @Column(nullable = false, columnDefinition = "varchar(150)", name = "apellidos")
    private String apellidosArtista;

    private int anhoNac;

    private int anhoDef;

    @Column(columnDefinition = "TEXT")
    private String biografia;

    @Column(columnDefinition = "varchar(250)", name = "imagen")
    private String imagenArtista;

    @Column(columnDefinition = "varchar(50)")
    private String pais;

    @Column(columnDefinition = "varchar(10)")
    private String siglo;

    @Column(nullable = false)
    private boolean visible = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "fechaCreacion")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ObraEntity> obras = new ArrayList<>();

    public void Artista() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getApellidosArtista() {
        return apellidosArtista;
    }

    public void setApellidosArtista(String apellidosArtista) {
        this.apellidosArtista = apellidosArtista;
    }

    public int getAnhoNac() {
        return anhoNac;
    }

    public void setAnhoNac(int anhoNac) {
        this.anhoNac = anhoNac;
    }

    public int getAnhoDef() {
        return anhoDef;
    }

    public void setAnhoDef(int anhoDef) {
        this.anhoDef = anhoDef;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getImagenArtista() {
        return imagenArtista;
    }

    public void setImagenArtista(String imagenArtista) {
        this.imagenArtista = imagenArtista;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSiglo() {
        return siglo;
    }

    public void setSiglo(String siglo) {
        this.siglo = siglo;
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

    public List<ObraEntity> getObras() {
        return obras;
    }

    public void setObras(List<ObraEntity> obras) {
        this.obras = obras;
    }
}
