package org.example.proyectoformsfx.matematicas;

public class Ecuacion {
    private double A;
    private double B;
    private double C;
    private String error;
    private Double x1;
    private Double x2;

    public Ecuacion(double a, double b, double c) {
        A = a;
        B = b;
        C = c;
        error="";
        x1=null;
        x2=null;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    public String getError() {
        return error;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    public double getDiscriminante() {
        return ((B*B)  - (4*A*C));
    }

    public Double getResultadoX1() {
        if(this.A==0){
            this.error="Error división para cero";
            return null;
        }
        if(getDiscriminante()<0) {
            this.error="Soluciones imaginarias";
            return null;
        }
        return (-B + Math.sqrt(getDiscriminante())) / (2*A);

    }

    public void calcular() {
        x1=getResultadoX1();
        x2=getResultadoX2();
    }

    public Double getResultadoX2() {
        if(this.A==0){
            this.error="Error división para cero";
            return null;
        }
        if(getDiscriminante()<0) {
            this.error="Soluciones imaginarias";
            return null;
        }
        return (-B - Math.sqrt(getDiscriminante())) / (2*A);
    }
}
