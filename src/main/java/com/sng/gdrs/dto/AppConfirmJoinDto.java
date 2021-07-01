package com.sng.gdrs.dto;

import java.util.Date;
import java.util.List;

public class AppConfirmJoinDto {

	private int seq;
	private int ap_seq;
	private String step;
	private String result;
	private String etc;
	private Date submitdate;
	
	private List<UserInfoDto> udto;
	private List<RecruitDto> rdto; 
	private List<ApplicationDto> adto; 
	
	public AppConfirmJoinDto() {
	}

	public AppConfirmJoinDto(int seq, int ap_seq, String step, String result, String etc, Date submitdate,
			List<UserInfoDto> udto, List<RecruitDto> rdto, List<ApplicationDto> adto) {
		super();
		this.seq = seq;
		this.ap_seq = ap_seq;
		this.step = step;
		this.result = result;
		this.etc = etc;
		this.submitdate = submitdate;
		this.udto = udto;
		this.rdto = rdto;
		this.adto = adto;
	}

	@Override
	public String toString() {
		return "AppConfirmJoinDto [seq=" + seq + ", ap_seq=" + ap_seq + ", step=" + step + ", result=" + result
				+ ", etc=" + etc + ", submitdate=" + submitdate + ", udto=" + udto + ", rdto=" + rdto + ", adto=" + adto
				+ "]";
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

	public List<UserInfoDto> getUdto() {
		return udto;
	}

	public void setUdto(List<UserInfoDto> udto) {
		this.udto = udto;
	}

	public List<RecruitDto> getRdto() {
		return rdto;
	}

	public void setRdto(List<RecruitDto> rdto) {
		this.rdto = rdto;
	}

	public List<ApplicationDto> getAdto() {
		return adto;
	}

	public void setAdto(List<ApplicationDto> adto) {
		this.adto = adto;
	}

	
	
}
