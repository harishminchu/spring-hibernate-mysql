package org.krams.tutorial.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person
        implements Serializable
{
    private static final long serialVersionUID = -5527566248002296042L;
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
    @Column(name="NAME")
    private String name;
    @Column(name="PLACE")
    private String place;
    @Column(name="CONTACT")
    private String contact;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="WHOISHE")
    private String whoishe;
    @Column(name="JOINDATE")
    private Date joinDate;
    @Column(name="FINGER_NO")
    private Integer fingerno;
    @Column(name="SAMPLE")
    private Integer sample;
    @Column(name="TEMPLATE64")
    private String template64;
    @Column(name="PHOTO", unique=false, nullable=true, columnDefinition="longblob")
    private byte[] photo;

    public Date getJoinDate()
    {
        return this.joinDate;
    }

    public void setJoinDate(Date joinDate)
    {
        this.joinDate = joinDate;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPlace()
    {
        return this.place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getWhoishe()
    {
        return this.whoishe;
    }

    public void setWhoishe(String whoishe)
    {
        this.whoishe = whoishe;
    }

    public String getContact()
    {
        return this.contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getTemplate64()
    {
        return this.template64;
    }

    public void setTemplate64(String template64)
    {
        this.template64 = template64;
    }

    public Integer getFingerno()
    {
        return this.fingerno;
    }

    public void setFingerno(Integer fingerno)
    {
        this.fingerno = fingerno;
    }

    public Integer getSample()
    {
        return this.sample;
    }

    public void setSample(Integer sample)
    {
        this.sample = sample;
    }

    public byte[] getPhoto()
    {
        return this.photo;
    }

    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }
}
