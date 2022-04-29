package com.cenfotec.graphql.graphql.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String estado;

    private String autor;

    private String descripcion;

    private LocalDate launchDate;


    private transient String formattedDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public Libro(int id, String nombre, String estado, String autor, String descripcion, LocalDate launchDate, String formattedDate) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.autor = autor;
        this.descripcion = descripcion;
        this.launchDate = launchDate;
        this.formattedDate = formattedDate;
    }

    public Libro() {
    }
}
