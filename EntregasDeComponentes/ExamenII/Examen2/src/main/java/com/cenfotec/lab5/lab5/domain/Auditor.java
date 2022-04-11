package com.cenfotec.lab5.lab5.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private int numero;
    private String email;
    private String DViaje;
    private String Especialidad;
    private String direccion;
    private Date FNacimiento;
    private String estado;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");



    public Auditor(String Nombre, String Apellido1, String Apellido2, String direccion, String Fnacimiento
    , int Numero, String email, String Dviaje, String Especialidad, String estado) throws ParseException {
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.direccion = direccion;
        this.numero = Numero;
        this.email = email;
        this.DViaje = Dviaje;
        this.Especialidad = Especialidad;
        this.FNacimiento = format.parse(Fnacimiento);
        this.estado = estado;
    }

    public Auditor() {
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDViaje() {
        return DViaje;
    }

    public void setDViaje(String DViaje) {
        this.DViaje = DViaje;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
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



    public String getNacimientoAsShort(){
        return  format.format(FNacimiento);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        value.append(",Numero Telefonico: ");
        value.append(numero);
        value.append(",Correo electronico: ");
        value.append(email);
        value.append(",Disponibilidad de viaje: ");
        value.append(DViaje);
        value.append(",Especialidad: ");
        value.append(Especialidad);
        value.append(",dirrecion: ");
        value.append(direccion);
        value.append(",Fecha de nacimiento: ");
        value.append(FNacimiento);
        value.append(",Estado: ");
        value.append(estado);
        value.append(getFNacimiento());
        value.append(")");
        return value.toString();
    }

}