package com.artwomen.springboot.ArtWomen.entity;

import java.io.Serializable;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "usuario")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column (nullable = false, columnDefinition = "varchar(100)", name = "nombreUsu")
    private String nombreUsuario;

    @Column(nullable = false, columnDefinition = "varchar(200)", name = "apellidosUsu")
    private String apellidoUsuario;

    @Column(nullable = false, columnDefinition = "varchar(150)", name = "usuario")
    private String nickUsuario;

    @Column(nullable = false, name = "contrasenha")
    private String contrasenhaUsuario;

    @Column (unique = true, nullable = false, columnDefinition = "varchar(100)", name = "correo")
    private String correoUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "fechaCreacion")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")  // este debe ser el nombre de la columna FK en tabla usuario
    private RolEntity rol;


    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, targetEntity = ArtistaEntity.class, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ArtistaEntity> artista = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, targetEntity = ObraEntity.class, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ObraEntity> obras = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, targetEntity = EnlaceEntity.class, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ObraEntity> enlaces = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, targetEntity = PublicacionEntity.class, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ObraEntity> publicaciones = new ArrayList<>();

    public UserEntity() {

    }

    public UserEntity(String nombreUsuario, String apellidoUsuario, String nickUsuario, String contrasenhaUsuario, String correoUsuario, Date fechaCreacion) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.nickUsuario = nickUsuario;
        this.contrasenhaUsuario = contrasenhaUsuario;
        this.correoUsuario = correoUsuario;
        this.fechaCreacion = fechaCreacion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public String getContrasenhaUsuario() {
        return contrasenhaUsuario;
    }

    public void setContrasenhaUsuario(String contrasenhaUsuario) {
        this.contrasenhaUsuario = contrasenhaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public List<ArtistaEntity> getArtista() {
        return artista;
    }

    public void setArtista(List<ArtistaEntity> artista) {
        this.artista = artista;
    }

    public List<ObraEntity> getObras() {
        return obras;
    }

    public void setObras(List<ObraEntity> obras) {
        this.obras = obras;
    }

    public List<ObraEntity> getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(List<ObraEntity> enlaces) {
        this.enlaces = enlaces;
    }

    public List<ObraEntity> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<ObraEntity> publicaciones) {
        this.publicaciones = publicaciones;
    }

}
