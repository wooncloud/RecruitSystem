package com.sng.gdrs.dto;

import java.io.Serializable;
import java.util.Date;

public class AppConfirmDto implements Serializable {

	private static final long serialVersionUID = -4042441261449234881L;
	
	private int seq;
	private int ap_seq;
	private String step;
	private String result;
	private String etc;
	private Date submitdate;
	
	public AppConfirmDto() {
	}

	public AppConfirmDto(int seq, int ap_seq, String step, String result, String etc, Date submitdate) {
		super();
		this.seq = seq;
		this.ap_seq = ap_seq;
		this.step = step;
		this.result = result;
		this.etc = etc;
		this.submitdate = submitdate;
	}

	@Override
	public String toString() {
		return "AppConfirmDto [seq=" + seq + ", ap_seq=" + ap_seq + ", step=" + step + ", result=" + result + ", etc="
				+ etc + ", submitdate=" + submitdate + "]";
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

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public Date getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(Date submitdate) {
		this.submitdate = submitdate;
	}
	
	
	
}
