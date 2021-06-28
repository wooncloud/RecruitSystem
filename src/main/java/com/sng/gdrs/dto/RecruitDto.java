package com.sng.gdrs.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecruitDto implements Serializable {

	private static final long serialVersionUID = -2664867638778323347L;
	
	private int seq;
	private String title;
	private String content;
	private String writer;
	private Date startterm;
	private Date endterm;
	private String employ;
	private String status;
	private String delflag;

	public RecruitDto() {
	}

	public RecruitDto(int seq, String title, String content, String writer, Date startterm, Date endterm, String employ,
			String status, String delflag) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.startterm = startterm;
		this.endterm = endterm;
		this.employ = employ;
		this.status = status;
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "RecruitDto [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", startterm=" + startterm + ", endterm=" + endterm + ", employ=" + employ + ", status=" + status
				+ ", delflag=" + delflag + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getStartterm() {
		return startterm;
	}

	public void setStartterm(Date startterm) {
		this.startterm = startterm;
	}

	public Date getEndterm() {
		return endterm;
	}

	public void setEndterm(Date endterm) {
		this.endterm = endterm;
	}

	public String getEmploy() {
		return employ;
	}

	public void setEmploy(String employ) {
		this.employ = employ;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}
