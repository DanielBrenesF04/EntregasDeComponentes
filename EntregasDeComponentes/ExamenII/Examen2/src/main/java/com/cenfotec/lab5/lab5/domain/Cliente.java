package com.cenfotec.lab5.lab5.domain;

import java.util.List;
import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Razon;
    private String CJuridica;
    private String Direccion;
    private String telefono;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Pcontact_ID", referencedColumnName = "ID")
    private List<Pcontacto> pcontactos;


    public Cliente(Long id, String razon, String CJuridica, String dirreccion, String telefono) {
        this.id = id;
        Razon = razon;
        this.CJuridica = CJuridica;
        Direccion = dirreccion;
        this.telefono = telefono;
    }

    public Cliente(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazon() {
        return Razon;
    }

    public void setRazon(String razon) {
        Razon = razon;
    }

    public String getCJuridica() {
        return CJuridica;
    }

    public void setCJuridica(String CJuridica) {
        this.CJuridica = CJuridica;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Pcontacto> getPcontactos() {
        return pcontactos;
    }

    public void setPcontactos(List<Pcontacto> pcontactos) {
        this.pcontactos = pcontactos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", Razon='" + Razon + '\'' +
                ", CJuridica='" + CJuridica + '\'' +
                ", Dirreccion='" + Direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pcontactos=" + pcontactos +
                '}';
    }
}
