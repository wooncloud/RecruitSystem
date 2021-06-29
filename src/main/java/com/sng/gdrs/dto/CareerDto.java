package com.sng.gdrs.dto;

import java.io.Serializable;
import java.util.Date;

public class CareerDto implements Serializable{

	private static final long serialVersionUID = -2414767660279580695L;
	
	private int seq;
	private int ap_seq;
	private String corpname;
	private Date hiredate;
	private Date firedate;
	private String employ;
	private String position;
	private String work;
	
	public CareerDto() {
	}

	public CareerDto(int seq, int ap_seq, String corpname, Date hiredate, Date firedate, String employ, String position,
			String work) {
		super();
		this.seq = seq;
		this.ap_seq = ap_seq;
		this.corpname = corpname;
		this.hiredate = hiredate;
		this.firedate = firedate;
		this.employ = employ;
		this.position = position;
		this.work = work;
	}

	@Override
	public String toString() {
		return "CareerDto [seq=" + seq + ", ap_seq=" + ap_seq + ", corpname=" + corpname + ", hiredate=" + hiredate
				+ ", firedate=" + firedate + ", employ=" + employ + ", position=" + position + ", work=" + work + "]";
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

	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Date getFiredate() {
		return firedate;
	}

	public void setFiredate(Date firedate) {
		this.firedate = firedate;
	}

	public String getEmploy() {
		return employ;
	}

	public void setEmploy(String employ) {
		this.employ = employ;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
	
	
}
