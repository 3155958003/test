package com.myssh.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tbStu")
public class TbStu {
	
	private int sno ;
	private String sname ;
	private int sage ;
	private String ssex ;
	private Date sintime ;
	
	//多个学生一个班级
	private TbCls tbcls ;
	
	public TbStu() {
		super();
	}
	public TbStu(int sno, String sname, int sage, String ssex, Date sintime) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.sintime = sintime;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getSintime() {
		return sintime;
	}
	public void setSintime(Date sintime) {
		this.sintime = sintime;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="scno")
	public TbCls getTbcls() {
		return tbcls;
	}
	public void setTbcls(TbCls tbcls) {
		this.tbcls = tbcls;
	}
}
