package com.pmli.amex.model.subappaform;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Productdetails {

    @XmlElement(name = "classoflives")
    private String classoflives;

    @XmlElement(name = "productcode")
    private String productcode;

    @XmlElement(name = "productoption")
    private String productoption;

    @XmlElement(name = "benefitoption")
    private String benefitoption;

    @XmlElement(name = "faceamount")
    private String faceamount;

    @XmlElement(name = "policyterm")
    private String policyterm;

    @XmlElement(name = "premiumpayterm")
    private String premiumpayterm;

    @XmlElement(name = "premiumpayfreq")
    private String premiumpayfreq;

    @XmlElement(name = "monthlyincome")
    private String monthlyincome;


    public String getClassoflives() {
        return classoflives;
    }

    public void setClassoflives(String classoflives) {
        this.classoflives = classoflives;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductoption() {
        return productoption;
    }

    public void setProductoption(String productoption) {
        this.productoption = productoption;
    }

    public String getBenefitoption() {
        return benefitoption;
    }

    public void setBenefitoption(String benefitoption) {
        this.benefitoption = benefitoption;
    }

    public String getFaceamount() {
        return faceamount;
    }

    public void setFaceamount(String faceamount) {
        this.faceamount = faceamount;
    }

    public String getPolicyterm() {
        return policyterm;
    }

    public void setPolicyterm(String policyterm) {
        this.policyterm = policyterm;
    }

    public String getPremiumpayterm() {
        return premiumpayterm;
    }

    public void setPremiumpayterm(String premiumpayterm) {
        this.premiumpayterm = premiumpayterm;
    }

    public String getPremiumpayfreq() {
        return premiumpayfreq;
    }

    public void setPremiumpayfreq(String premiumpayfreq) {
        this.premiumpayfreq = premiumpayfreq;
    }

    public String getMonthlyincome() {
        return monthlyincome;
    }

    public void setMonthlyincome(String monthlyincome) {
        this.monthlyincome = monthlyincome;
    }

    @Override
    public String toString() {
        return "Productdetails{" +
                "classoflives='" + classoflives + '\'' +
                ", productcode='" + productcode + '\'' +
                ", productoption='" + productoption + '\'' +
                ", benefitoption='" + benefitoption + '\'' +
                ", faceamount='" + faceamount + '\'' +
                ", policyterm='" + policyterm + '\'' +
                ", premiumpayterm='" + premiumpayterm + '\'' +
                ", premiumpayfreq='" + premiumpayfreq + '\'' +
                ", monthlyincome='" + monthlyincome + '\'' +
                '}';
    }
}
