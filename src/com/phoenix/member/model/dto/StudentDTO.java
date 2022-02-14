package com.phoenix.member.model.dto;

public class StudentDTO {
	
	private Object inputStudentNo;
	private String inputStudentName;
	private String inputPhone;
	
	public StudentDTO() {}

	public StudentDTO(Object inputStudentNo, String name, String phone) {
		super();
		this.inputStudentNo = inputStudentNo;
		this.inputStudentName = name;
		this.inputPhone = phone;
	}

	public Object getInputStudentNo() {
		return inputStudentNo;
	}

	public void setInputStudentNo(Object inputStudentNo) {
		this.inputStudentNo = inputStudentNo;
	}

	public String getName() {
		return inputStudentName;
	}

	public void setName(String name) {
		this.inputStudentName = name;
	}

	public String getPhone() {
		return inputPhone;
	}

	public void setPhone(String phone) {
		this.inputPhone = phone;
	}

	@Override
	public String toString() {
		return "StudentDTO [inputStudentNo=" + inputStudentNo + ", name=" + inputStudentName + ", phone=" + inputPhone + "]";
	}

}