/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author usuario
 */
public class Empleado extends Persona {
    private static double pagoPorHoraExtra; //atributo de clase
    private String nif;
    private double sueldoBase;
    private int horasExtras;
    private double tipoIRPF;
    private char casado;
    private int numeroHijos;

    public static double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public static void setPagoPorHoraExtra(double aPagoPorHoraExtra) {
        pagoPorHoraExtra = aPagoPorHoraExtra;
    }
    
    public Empleado() {
        
    }

    public Empleado(Empleado e) {
        //Persona(String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, int edad, String direccion)
        super(e.getNombre(),e.getApellidoPaterno(),e.getApellidoMaterno(),e.getSexo(),e.getEdad(),e.getDireccion());
        //asignación de atributos miembro a través del constructor de la clase padre
        this.nif=e.nif;
        this.sueldoBase=e.sueldoBase;
        this.horasExtras=e.horasExtras;
        this.tipoIRPF=e.tipoIRPF;
        this.casado=e.casado;
        this.numeroHijos=e.numeroHijos;
    }
    public Empleado(String nif, double sueldoBase, int horasExtras, double tipoIRPF, char casado, int numeroHijos, String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, int edad, String direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, sexo, edad, direccion);
        this.nif = nif;
        this.sueldoBase = sueldoBase;
        this.horasExtras = horasExtras;
        this.tipoIRPF = tipoIRPF;
        this.casado = casado;
        this.numeroHijos = numeroHijos;
    }
    public Empleado(Persona p,String nif, double sueldoBase, int horasExtras, double tipoIRPF, char casado, int numeroHijos) {
        super(p);
        this.nif=nif;
        this.sueldoBase=sueldoBase;
        this.horasExtras=horasExtras;
        this.tipoIRPF=tipoIRPF;
        this.casado=casado;
        this.numeroHijos=numeroHijos;
        
    }
    public Empleado(String nif, double sueldoBase, int horasExtras, double tipoIRPF, char casado, int numeroHijos) {
        this.nif = nif;
        this.sueldoBase = sueldoBase;
        this.horasExtras = horasExtras;
        this.tipoIRPF = tipoIRPF;
        this.casado = casado;
        this.numeroHijos = numeroHijos;
    }
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getTipoIRPF() {
        return tipoIRPF;
    }

    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    public char getCasado() {
        return casado;
    }

    public void setCasado(char casado) {
        this.casado = casado;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }
    
    //Métodos propios o de instancia
    public double calcularImporteHorasExtra() {
        return getPagoPorHoraExtra()*this.horasExtras;
    }
    public double calcularSueldoBruto() {
        return this.getSueldoBase()+this.calcularImporteHorasExtra();
    }
    
    public double calcularRetencionIRPF() {
        double tipo=this.getTipoIRPF();
        if (this.casado == 's' || this.casado == 'S') {
            tipo-=2; //2 menos por estar casado
        }
        tipo-=this.getNumeroHijos();
        tipo = tipo<0 ? 0 : tipo;
        return this.calcularSueldoBruto()*tipo/100;
    }
    public double calcularSueldoNeto() {
        return this.calcularSueldoBruto()-this.calcularRetencionIRPF();
    }

    @Override
    public String toString() {
        return super.toString() + " Empleado{" + "nif=" + nif + ", sueldoBase=" + sueldoBase + ", horasExtras=" + horasExtras + ", tipoIRPF=" + tipoIRPF + ", casado=" + casado + ", numeroHijos=" + numeroHijos + '}';
    }
    
}
