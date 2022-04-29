package com.cenfotec.graphql.graphql.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tUsaurio;

    @Column(nullable = false)
    private String alergias;

    @Column(nullable = false)
    private int idPadre;

    private String liborsLeidos;

    @Column(nullable = false)
    private int cLeidos;

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

    public String gettUsaurio() {
        return tUsaurio;
    }

    public void settUsaurio(String tUsaurio) {
        this.tUsaurio = tUsaurio;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public String getLiborsLeidos() {
        return liborsLeidos;
    }

    public void setLiborsLeidos(String liborsLeidos) {
        this.liborsLeidos = liborsLeidos;
    }

    public int getcLeidos() {
        return cLeidos;
    }

    public void setcLeidos(int cLeidos) {
        this.cLeidos = cLeidos;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public Hijo(int id, String nombre, String tUsaurio, String alergias, int idPadre, String liborsLeidos, int cLeidos) {
        this.id = id;
        this.nombre = nombre;
        this.tUsaurio = tUsaurio;
        this.alergias = alergias;
        this.idPadre = idPadre;
        this.liborsLeidos = liborsLeidos;
        this.cLeidos = cLeidos;
    }

    public Hijo() {
    }
}
