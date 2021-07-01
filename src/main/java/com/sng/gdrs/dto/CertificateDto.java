package com.sng.gdrs.dto;

import java.io.Serializable;
import java.util.Date;

public class CertificateDto implements Serializable {

	private static final long serialVersionUID = -8396377969980099429L;

	private int seq;
	private int ap_seq;
	private String type;
	private String name;
	private String agency;
	private String grade;
	private Date regdate;

	public CertificateDto() {
	}

	public CertificateDto(int seq, int ap_seq, String type, String name, String agency, String grade, Date regdate) {
		super();
		this.seq = seq;
		this.ap_seq = ap_seq;
		this.type = type;
		this.name = name;
		this.agency = agency;
		this.grade = grade;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CertificateDto [seq=" + seq + ", ap_seq=" + ap_seq + ", type=" + type + ", name=" + name + ", agency="
				+ agency + ", grade=" + grade + ", regdate=" + regdate + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getAp_seq() {
		return ap_seq;
	}

	public void setAp_seq(int ap_seq) {
		this.ap_seq = ap_seq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
