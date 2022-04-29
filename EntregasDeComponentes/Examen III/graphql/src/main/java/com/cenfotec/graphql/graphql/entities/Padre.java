package com.cenfotec.graphql.graphql.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Padre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String Tprimario;

    private String Tsecundario;

    private transient String formattedDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCedula() {return cedula;}

    public void setCedula(String cedula) {this.cedula = cedula;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getTprimario() {return Tprimario;}

    public void setTprimario(String tprimario) {Tprimario = tprimario;}

    public String getTsecundario() {return Tsecundario;}

    public void setTsecundario(String tsecundario) {Tsecundario = tsecundario;}


    public String getFormattedDate() {return formattedDate;}

    public void setFormattedDate(String formattedDate) {this.formattedDate = formattedDate;}




    public Padre(int id, String nombre, String cedula, String direccion, String tprimario, String tsecundario, String formattedDate) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        Tprimario = tprimario;
        Tsecundario = tsecundario;
        this.formattedDate = formattedDate;
    }

    public Padre() {
    }
}
