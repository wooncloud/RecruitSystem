package com.sng.gdrs.dto;

import java.io.Serializable;
import java.util.Date;

public class ApplicationDto implements Serializable {

	private static final long serialVersionUID = 5810930661978542519L;
	
	private int seq;
	private String email;
	private String title;
	private Date regdate;
	private int recruit_seq;
	private String introduce;
	private String portpolio_link;
	private String portpolio_file;
	private String rewarding;
	private String handicap;
	private String military;
	private String delflag;

	public ApplicationDto() {
	}

	public ApplicationDto(int seq, String email, String title, Date regdate, int recruit_seq, String introduce,
			String portpolio_link, String portpolio_file, String rewarding, String handicap, String military,
			String delflag) {
		this.seq = seq;
		this.email = email;
		this.title = title;
		this.regdate = regdate;
		this.recruit_seq = recruit_seq;
		this.introduce = introduce;
		this.portpolio_link = portpolio_link;
		this.portpolio_file = portpolio_file;
		this.rewarding = rewarding;
		this.handicap = handicap;
		this.military = military;
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "ApplicationDto [seq=" + seq + ", email=" + email + ", title=" + title + ", regdate=" + regdate
				+ ", recruit_seq=" + recruit_seq + ", introduce=" + introduce + ", portpolio_link=" + portpolio_link
				+ ", portpolio_file=" + portpolio_file + ", rewarding=" + rewarding + ", handicap=" + handicap
				+ ", military=" + military + ", delflag=" + delflag + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getRecruit_seq() {
		return recruit_seq;
	}

	public void setRecruit_seq(int recruit_seq) {
		this.recruit_seq = recruit_seq;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPortpolio_link() {
		return portpolio_link;
	}

	public void setPortpolio_link(String portpolio_link) {
		this.portpolio_link = portpolio_link;
	}

	public String getPortpolio_file() {
		return portpolio_file;
	}

	public void setPortpolio_file(String portpolio_file) {
		this.portpolio_file = portpolio_file;
	}

	public String getRewarding() {
		return rewarding;
	}

	public void setRewarding(String rewarding) {
		this.rewarding = rewarding;
	}

	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}
