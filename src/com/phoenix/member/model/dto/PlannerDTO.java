package com.phoenix.member.model.dto;

import java.sql.Date;

public class PlannerDTO {
	
	private java.sql.Date date;
	private String studentNo;
	private String studyTime;
	private String performance;
	private String classCode;
	
	public PlannerDTO() {}

	public PlannerDTO(Date date, String studentNo, String studyTime, String performance, String classCode) {
		super();
		this.date = date;
		this.studentNo = studentNo;
		this.studyTime = studyTime;
		this.performance = performance;
		this.classCode = classCode;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	@Override
	public String toString() {
		return "PlannerDTO [date=" + date + ", studentNo=" + studentNo + ", studyTime=" + studyTime + ", performance="
				+ performance + ", classCode=" + classCode + "]";
	}
}