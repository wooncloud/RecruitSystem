package com.sng.gdrs.dto;

import java.io.Serializable;

public class CodeDto implements Serializable {

	private static final long serialVersionUID = -6235087408947601337L;

	private int seq;
	private String codeid;
	private String codetype;
	private String codename;
	private String delflag;

	public CodeDto() {
	}

	public CodeDto(int seq, String codeid, String codetype, String codename, String delflag) {
		this.seq = seq;
		this.codeid = codeid;
		this.codetype = codetype;
		this.codename = codename;
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "CodeDto [seq=" + seq + ", codeid=" + codeid + ", codetype=" + codetype + ", codename=" + codename
				+ ", delflag=" + delflag + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCodeid() {
		return codeid;
	}

	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}

	public String getCodetype() {
		return codetype;
	}

	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}
