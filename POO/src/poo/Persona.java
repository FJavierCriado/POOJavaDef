package poo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Persona {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected char  sexo;
    protected int   edad;
    protected String direccion;

    public Persona() {
        this.nombre = null;
        this.apellidoPaterno = null;
        this.apellidoMaterno = null;
        this.sexo = 0;
        this.edad = 0;
        this.direccion = null;  
    }
    public Persona(Persona p) {
        this.nombre = p.getNombre();
        this.apellidoPaterno = p.getApellidoPaterno();
        this.apellidoMaterno = null;
        this.sexo = 0;
        this.edad = 0;
        this.direccion = null;  
    }   
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, int edad, String direccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public boolean mayorEdad() {
        return this.edad>=18;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", sexo=" + sexo + ", edad=" + edad + ", direccion=" + direccion + '}';
    }
    
    protected void finalize() throws Throwable {
        System.out.println("Terminando el objeto Persona: "+nombre);
        super.finalize();
        
    }
}
