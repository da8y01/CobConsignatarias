/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cobconsignatarias;

/**
 *
 * @author Admin
 */
public class Fecha {

    private String Fecha;
    private int Entregados;
    private int Adicionales;
    private int Restantes;
    private int Devueltos;
    private int Faltantes;
    private int Sobrantes;
    private int ValorUnitario;
    private int Valor;
    private int Visitado;
    private int Cobrado;
    private int Entrego;


    public Fecha() {

    }


    public String GetFecha() {
        return this.Fecha;
    }

    public void SetFecha(String fecha) {
        this.Fecha = fecha;
    }


    public int GetEntregados() {
        return this.Entregados;
    }

    public void SetEntregados(int entregados) {
        this.Entregados = entregados;
    }


    public int GetAdicionales() {
        return this.Adicionales;
    }

    public void SetAdicionales(int adicionales) {
        this.Adicionales = adicionales;
    }


    public int GetRestantes() {
        return this.Restantes;
    }

    public void SetRestantes(int restantes) {
        this.Restantes = restantes;
    }


    public int GetDevueltos() {
        return this.Devueltos;
    }

    public void SetDevueltos(int devueltos) {
        this.Devueltos = devueltos;
    }


    public int GetFaltantes() {
        return this.Faltantes;
    }

    public void SetFaltantes(int faltantes) {
        this.Faltantes = faltantes;
    }


    public int GetSobrantes() {
        return this.Sobrantes;
    }

    public void SetSobrantes(int sobrantes) {
        this.Sobrantes = sobrantes;
    }


    public int GetValorUnitario() {
        return this.ValorUnitario;
    }

    public void SetValorUnitario(int valorunitario) {
        this.ValorUnitario = valorunitario;
    }


    public int GetValor() {
        return this.Valor;
    }

    public void SetValor(int valor) {
        this.Valor = valor;
    }


    public int GetVisitado() {
        return this.Visitado;
    }

    public void SetVisitado(int visitado) {
        this.Visitado = visitado;
    }


    public int GetCobrado() {
        return this.Cobrado;
    }

    public void SetCobrado(int cobrado) {
        this.Cobrado = cobrado;
    }


    public int GetEntrego() {
        return this.Entrego;
    }

    public void SetEntrego(int entrego) {
        this.Entrego = entrego;
    }

}
