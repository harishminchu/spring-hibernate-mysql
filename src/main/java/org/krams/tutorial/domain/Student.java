package org.krams.tutorial.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "USNNUMBER")
	private String usnNumber;

	@Column(name = "NAME")
	private String NAME;

	@Column(name = "CONTACT")
	private String contact;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "SEMISTER")
	private String semister;

	@Column(name = "INTERNAL")
	private String internal;

	@Column(name = "MARK1")
	private String mark1;

	@Column(name = "MARK2")
	private String mark2;

	@Column(name = "MARK3")
	private String mark3;

	@Column(name = "MARK4")
	private String mark4;

	@Column(name = "MARK5")
	private String mark5;

	@Column(name = "MARK6")
	private String mark6;

	@Column(name = "MARK7")
	private String mark7;

	@Column(name = "MARK8")
	private String mark8;

	@Column(name = "SUBJECT1")
	private String subject1;

	@Column(name = "SUBJECT2")
	private String subject2;

	@Column(name = "SUBJECT3")
	private String subject3;

	@Column(name = "SUBJECT4")
	private String subject4;

	@Column(name = "SUBJECT5")
	private String subject5;

	@Column(name = "SUBJECT6")
	private String subject6;

	@Column(name = "SUBJECT7")
	private String subject7;

	@Column(name = "SUBJECT8")
	private String subject8;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT1")
	private String percentageoaattendanceforsubject1;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT2")
	private String percentageoaattendanceforsubject2;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT3")
	private String percentageoaattendanceforsubject3;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT4")
	private String percentageoaattendanceforsubject4;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT5")
	private String percentageoaattendanceforsubject5;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT6")
	private String percentageoaattendanceforsubject6;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT7")
	private String percentageoaattendanceforsubject7;

	@Column(name = "PERCENTAGEOAATTENDANCEFORSUBJECT8")
	private String percentageoaattendanceforsubject8;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsnNumber() {
		return usnNumber;
	}

	public void setUsnNumber(String usnNumber) {
		this.usnNumber = usnNumber;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSemister() {
		return semister;
	}

	public void setSemister(String semister) {
		this.semister = semister;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getSubject4() {
		return subject4;
	}

	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}

	public String getSubject5() {
		return subject5;
	}

	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}

	public String getSubject6() {
		return subject6;
	}

	public void setSubject6(String subject6) {
		this.subject6 = subject6;
	}

	public String getSubject7() {
		return subject7;
	}

	public void setSubject7(String subject7) {
		this.subject7 = subject7;
	}

	public String getSubject8() {
		return subject8;
	}

	public void setSubject8(String subject8) {
		this.subject8 = subject8;
	}

	public String getPercentageoaattendanceforsubject1() {
		return percentageoaattendanceforsubject1;
	}

	public void setPercentageoaattendanceforsubject1(
			String percentageoaattendanceforsubject1) {
		this.percentageoaattendanceforsubject1 = percentageoaattendanceforsubject1;
	}

	public String getPercentageoaattendanceforsubject2() {
		return percentageoaattendanceforsubject2;
	}

	public void setPercentageoaattendanceforsubject2(
			String percentageoaattendanceforsubject2) {
		this.percentageoaattendanceforsubject2 = percentageoaattendanceforsubject2;
	}

	public String getPercentageoaattendanceforsubject3() {
		return percentageoaattendanceforsubject3;
	}

	public void setPercentageoaattendanceforsubject3(
			String percentageoaattendanceforsubject3) {
		this.percentageoaattendanceforsubject3 = percentageoaattendanceforsubject3;
	}

	public String getPercentageoaattendanceforsubject4() {
		return percentageoaattendanceforsubject4;
	}

	public void setPercentageoaattendanceforsubject4(
			String percentageoaattendanceforsubject4) {
		this.percentageoaattendanceforsubject4 = percentageoaattendanceforsubject4;
	}

	public String getPercentageoaattendanceforsubject5() {
		return percentageoaattendanceforsubject5;
	}

	public void setPercentageoaattendanceforsubject5(
			String percentageoaattendanceforsubject5) {
		this.percentageoaattendanceforsubject5 = percentageoaattendanceforsubject5;
	}

	public String getPercentageoaattendanceforsubject6() {
		return percentageoaattendanceforsubject6;
	}

	public void setPercentageoaattendanceforsubject6(
			String percentageoaattendanceforsubject6) {
		this.percentageoaattendanceforsubject6 = percentageoaattendanceforsubject6;
	}

	public String getPercentageoaattendanceforsubject7() {
		return percentageoaattendanceforsubject7;
	}

	public void setPercentageoaattendanceforsubject7(
			String percentageoaattendanceforsubject7) {
		this.percentageoaattendanceforsubject7 = percentageoaattendanceforsubject7;
	}

	public String getPercentageoaattendanceforsubject8() {
		return percentageoaattendanceforsubject8;
	}

	public void setPercentageoaattendanceforsubject8(
			String percentageoaattendanceforsubject8) {
		this.percentageoaattendanceforsubject8 = percentageoaattendanceforsubject8;
	}

	public String getInternal() {
		return internal;
	}

	public void setInternal(String internal) {
		this.internal = internal;
	}

	public String getMark1() {
		return mark1;
	}

	public void setMark1(String mark1) {
		this.mark1 = mark1;
	}

	public String getMark2() {
		return mark2;
	}

	public void setMark2(String mark2) {
		this.mark2 = mark2;
	}

	public String getMark3() {
		return mark3;
	}

	public void setMark3(String mark3) {
		this.mark3 = mark3;
	}

	public String getMark4() {
		return mark4;
	}

	public void setMark4(String mark4) {
		this.mark4 = mark4;
	}

	public String getMark5() {
		return mark5;
	}

	public void setMark5(String mark5) {
		this.mark5 = mark5;
	}

	public String getMark6() {
		return mark6;
	}

	public void setMark6(String mark6) {
		this.mark6 = mark6;
	}

	public String getMark7() {
		return mark7;
	}

	public void setMark7(String mark7) {
		this.mark7 = mark7;
	}

	public String getMark8() {
		return mark8;
	}

	public void setMark8(String mark8) {
		this.mark8 = mark8;
	}

	
	
}
