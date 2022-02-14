package com.phoenix.member.model.dto;

public class ClassDTO {
	
	private String classCode;
	private String className;
	
	public ClassDTO() {}

	public ClassDTO(String classCode, String className) {
		super();
		this.classCode = classCode;
		this.className = className;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "ClassDTO [classCode=" + classCode + ", className=" + className + "]";
	}

	
}