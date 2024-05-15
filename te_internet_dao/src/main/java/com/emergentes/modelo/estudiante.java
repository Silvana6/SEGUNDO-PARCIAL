package com.emergentes.modelo;

public class estudiante {

    private int id;
    private String nombres;
    private String apellidos;
    private String seminarios;
    private String confirmado;
    private String fecha_ins;

    public estudiante() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.seminarios = "";
        this.confirmado = "";
        this.fecha_ins = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(String seminarios) {
        this.seminarios = seminarios;
    }

    public String getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    public String getFecha_ins() {
        return fecha_ins;
    }

    public void setFecha_ins(String fecha_ins) {
        this.fecha_ins = fecha_ins;
    }

    @Override
    public String toString() {
        return "estudiante{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", seminarios=" + seminarios + ", confirmado=" + confirmado + ", fecha_ins=" + fecha_ins + '}';
    }

}
