package org.krams.tutorial.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UTTARA")
public class Uttara
        implements Serializable
{
    private static final long serialVersionUID = 5924361831551833717L;
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
    @Column(name="UTTARAVISHAYA")
    private String uttaraVishaya;
    @Column(name="UTTARADATE")
    private Date uttaraDate;
    @Column(name="IMPORTANT")
    private String important;
    @ManyToOne
    private Person person;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setUttaraVishaya(String uttaraVishaya)
    {
        this.uttaraVishaya = uttaraVishaya;
    }

    public void setUttaraDate(Date uttaraDate)
    {
        this.uttaraDate = uttaraDate;
    }

    public String getUttaraVishaya()
    {
        return this.uttaraVishaya;
    }

    public Date getUttaraDate()
    {
        return this.uttaraDate;
    }

    public String getImportant()
    {
        return this.important;
    }

    public void setImportant(String important)
    {
        this.important = important;
    }

    public Person getPerson()
    {
        return this.person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}
