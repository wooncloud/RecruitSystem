package com.sng.gdrs.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectExpDto implements Serializable{

	private static final long serialVersionUID = 3472445364703149316L;
	
	private int seq;
	private int ap_seq;
	private String title;
	private Date startdate;
	private Date enddate;
	private String corpname;
	private String job;
	private String content;
	
	public ProjectExpDto() {
	}

	public ProjectExpDto(int seq, int ap_seq, String title, Date startdate, Date enddate, String corpname, String job,
			String content) {
		super();
		this.seq = seq;
		this.ap_seq = ap_seq;
		this.title = title;
		this.startdate = startdate;
		this.enddate = enddate;
		this.corpname = corpname;
		this.job = job;
		this.content = content;
	}

	@Override
	public String toString() {
		return "ProjectExpDto [seq=" + seq + ", ap_seq=" + ap_seq + ", title=" + title + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", corpname=" + corpname + ", job=" + job + ", content=" + content + "]";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
