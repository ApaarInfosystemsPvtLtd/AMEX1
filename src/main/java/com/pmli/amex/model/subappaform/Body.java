package com.pmli.amex.model.subappaform;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body {

    @XmlElement(name = "pidetails")
    private Pidetails pidetails;

    @XmlElement(name = "podetails")
    private Podetails podetails;

    @XmlElement(name = "productdetails")
    private Productdetails productdetails;

    public Pidetails getPidetails() {
        return pidetails;
    }

    public void setPidetails(Pidetails pidetails) {
        this.pidetails = pidetails;
    }

    public Podetails getPodetails() {
        return podetails;
    }

    public void setPodetails(Podetails podetails) {
        this.podetails = podetails;
    }

    public Productdetails getProductdetails() {
        return productdetails;
    }

    public void setProductdetails(Productdetails productdetails) {
        this.productdetails = productdetails;
    }

    @Override
    public String toString() {
        return "Body{" +
                "pidetails=" + pidetails +
                ", podetails=" + podetails +
                ", productdetails=" + productdetails +
                '}';
    }
}
