package com.pmli.amex.model.subappaform;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "tma")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tma {

    @XmlElement(name = "body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Tma{" +
                "body=" + body +
                '}';
    }
}
