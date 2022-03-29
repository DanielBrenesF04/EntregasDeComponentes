package com.cenfotec.lab5.lab5.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private Date created;
    private String direccion;
    private Date FNacimiento;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Persona(String Nombre, String Apellido1, String Apellido2, String direccion, String date, String Fnacimiento) throws ParseException {
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.direccion = direccion;
        this.created = format.parse(date);
        this.FNacimiento = format.parse(Fnacimiento);
    }

    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String title) {
        this.Nombre = title;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String summary) {
        this.direccion = summary;
    }

    public Date getFNacimiento() {
        return FNacimiento;
    }

    public void setFNacimiento(Date FNacimiento) {
        this.FNacimiento = FNacimiento;
    }

    public String getCreatedAsShort() {
        return format.format(created);
    }

    public String getNacimientoAsShort(){
        return  format.format(FNacimiento);
    }

    public String toString() {
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Nombre: ");
        value.append(Nombre);
        value.append(",Primer Apellido:");
        value.append(Apellido1);
        value.append(",Segunda Apellido:");
        value.append(Apellido2);
        value.append(",Direccion: ");
        value.append(direccion);
        value.append(",Direccion: ");
        value.append(FNacimiento);
        value.append(getFNacimiento());
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }

}