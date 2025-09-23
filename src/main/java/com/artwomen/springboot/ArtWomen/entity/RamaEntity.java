package com.artwomen.springboot.ArtWomen.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rama")
public class RamaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(100)", name = "nombre")
    private String nombreRama;

    @OneToMany(mappedBy = "rama", fetch = FetchType.EAGER, targetEntity = ObraEntity.class, cascade = CascadeType.ALL)
    private List<ObraEntity> obras = new ArrayList<>();

    public RamaEntity() {
    }

    public RamaEntity(String nombreRama) {
        this.nombreRama = nombreRama;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreRama() {
        return nombreRama;
    }

    public void setNombreRama(String nombreRama) {
        this.nombreRama = nombreRama;
    }

    public List<ObraEntity> getObras() {
        return obras;
    }

    public void setObras(List<ObraEntity> obras) {
        this.obras = obras;
    }

}
