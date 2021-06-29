package com.sng.gdrs.dto;

import java.io.Serializable;
import java.util.Date;

public class EducationDto implements Serializable{

	private static final long serialVersionUID = 4871796439650947514L;
	
	private int seq;
	private int ap_seq;
	private String finaledu;
	private String name;
	private String major;
	private int score;
	private Date indate;
	private Date outdate;
	private String status;
	
	public EducationDto() {
	}

	public EducationDto(int seq, int ap_seq, String finaledu, String name, String major, int score, Date indate,
			Date outdate, String status) {
		super();
		this.seq = seq;
		this.ap_seq = ap_seq;
		this.finaledu = finaledu;
		this.name = name;
		this.major = major;
		this.score = score;
		this.indate = indate;
		this.outdate = outdate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "EducationDto [seq=" + seq + ", ap_seq=" + ap_seq + ", finaledu=" + finaledu + ", name=" + name
				+ ", major=" + major + ", score=" + score + ", indate=" + indate + ", outdate=" + outdate + ", status="
				+ status + "]";
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

	public String getFinaledu() {
		return finaledu;
	}

	public void setFinaledu(String finaledu) {
		this.finaledu = finaledu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
