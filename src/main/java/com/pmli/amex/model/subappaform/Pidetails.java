package com.pmli.amex.model.subappaform;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pidetails {

    @XmlElement(name = "firstname")
    private String firstname;

    @XmlElement(name = "midname")
    private String midname;

    @XmlElement(name = "lastname")
    private String lastname;

    @XmlElement(name = "gender")
    private String gender;

    @XmlElement(name = "dob")
    private String dob;

    @XmlElement(name = "ispiposame")
    private String ispiposame;

    @XmlElement(name = "annualincome")
    private String annualincome;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIspiposame() {
        return ispiposame;
    }

    public void setIspiposame(String ispiposame) {
        this.ispiposame = ispiposame;
    }

    public String getAnnualincome() {
        return annualincome;
    }

    public void setAnnualincome(String annualincome) {
        this.annualincome = annualincome;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    @Override
    public String toString() {
        return "Pidetails{" +
                "firstname='" + firstname + '\'' +
                ", midname='" + midname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", ispiposame='" + ispiposame + '\'' +
                ", annualincome='" + annualincome + '\'' +
                '}';
    }
}
