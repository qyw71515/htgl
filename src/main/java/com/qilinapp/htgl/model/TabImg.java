/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.model;

/**
 * @author：QYW
 * @since：2019年4月4日上午11:23:19
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
public class TabImg {
	private String uuid;
	private String createtime;
	private String qyid;
	private String yhid;
	private String sclx;
	private String wjm;
	private String filepath;
	private String smallfilepath;
	private String by1;
	private String by2;
	private String by3;
	private String by4;
	private String by5;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getQyid() {
		return qyid;
	}

	public void setQyid(String qyid) {
		this.qyid = qyid;
	}

	public String getYhid() {
		return yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

	public String getSclx() {
		return sclx;
	}

	public void setSclx(String sclx) {
		this.sclx = sclx;
	}

	public String getWjm() {
		return wjm;
	}

	public void setWjm(String wjm) {
		this.wjm = wjm;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getSmallfilepath() {
		return smallfilepath;
	}

	public void setSmallfilepath(String smallfilepath) {
		this.smallfilepath = smallfilepath;
	}

	public String getBy1() {
		return by1;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}

	public String getBy2() {
		return by2;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}

	public String getBy3() {
		return by3;
	}

	public void setBy3(String by3) {
		this.by3 = by3;
	}

	public String getBy4() {
		return by4;
	}

	public void setBy4(String by4) {
		this.by4 = by4;
	}

	public String getBy5() {
		return by5;
	}

	public void setBy5(String by5) {
		this.by5 = by5;
	}

	@Override
	public String toString() {
		return "TabImg [uuid=" + uuid + ", createtime=" + createtime + ", qyid=" + qyid + ", yhid=" + yhid + ", sclx="
				+ sclx + ", wjm=" + wjm + ", filepath=" + filepath + ", smallfilepath=" + smallfilepath + ", by1=" + by1
				+ ", by2=" + by2 + ", by3=" + by3 + ", by4=" + by4 + ", by5=" + by5 + "]";
	}

}
