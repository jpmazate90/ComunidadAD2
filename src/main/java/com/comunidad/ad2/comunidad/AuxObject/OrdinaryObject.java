/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

/**
 *
 * @author fabricio
 */
public class OrdinaryObject {
    
    private int numberParam;
    private String stringParam;
    private double decimalParam;
    private String timeParam;

    public OrdinaryObject(int numberParam, String stringParam, double decimalParam, String timeParam) {
        this.numberParam = numberParam;
        this.stringParam = stringParam;
        this.decimalParam = decimalParam;
        this.timeParam = timeParam;
    }

    public OrdinaryObject() {
    }

    public int getNumberParam() {
        return numberParam;
    }

    public void setNumberParam(int numberParam) {
        this.numberParam = numberParam;
    }

    public String getStringParam() {
        return stringParam;
    }

    public void setStringParam(String stringParam) {
        this.stringParam = stringParam;
    }

    public double getDecimalParam() {
        return decimalParam;
    }

    public void setDecimalParam(double decimalParam) {
        this.decimalParam = decimalParam;
    }

    public String getTimeParam() {
        return timeParam;
    }

    public void setTimeParam(String timeParam) {
        this.timeParam = timeParam;
    }
    
}
