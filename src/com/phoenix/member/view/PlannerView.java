package com.phoenix.member.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.phoenix.member.controller.PlannerController;
import com.phoenix.member.model.dto.StudentDTO;

public class PlannerView {

	Scanner sc = new Scanner(System.in);
	
	
	

	public void displayMenu() {
		
		PlannerController plannerController = new PlannerController();
		
		do {
			System.out.println("***** Study Planner *****");
			System.out.println("1. 새 학생 등록 ");
			System.out.println("2. 전체 학생 조회");
			System.out.println("3. 새 과목 등록");
			System.out.println("4. 전체 과목 조회");
			System.out.println("5. 스터디 기록 등록");
			System.out.println("6. 스터디 기록 조회");
			System.out.println("7. 학생 정보 변경");
			System.out.println("8. 학생 삭제");
			System.out.println("0. 다시 실행");
			System.out.println("**************************");
			System.out.print("메뉴 번호를 선택해 주세요 : ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1: plannerController.registNewStudent(inputStudent()); break;
			case 2: plannerController.selectAllStudent(); break;
			case 3: plannerController.registNewClass(inputClass()); break;
			case 4: plannerController.selectAllClass(); break;
			case 5: plannerController.insertDailyStudy(insertDailyStudy()); break;
			case 6: plannerController.selectAllPlanner(); break;
			case 7: plannerController.updateStudentByNo(inputStudentNo(), inputPhone());break;
			case 8: plannerController.deleteStudentByNo(inputStudentNo()); break;
			default: System.out.println("1~8번 번호만 입력 가능합니다 다시 입력해주세요.");
			}
		} while (true);
	}
	
	
	public Map<String, String> inputStudent() {
		Map<String, String> map = new HashMap<>();
		System.out.print("학생 이름 : ");
		sc.nextLine();
		map.put("studentName", sc.nextLine());
		System.out.print("학생 연락처 : ");
		map.put("phone", sc.nextLine());
		
		return map;
	}
	
	public Map<String, String> inputClass() {
		Map<String, String> map = new HashMap<>();
		
		System.out.print("추가할 과목 이름 : ");
		sc.nextLine();
		map.put("className", sc.nextLine());
		
		return map;
	}
	
	public Map<String, String> insertDailyStudy() {
		Map<String, String> map = new HashMap<>();
		
		System.out.print("학생 번호 : ");
		sc.nextLine();
		map.put("studentNo", sc.nextLine());
		System.out.print("학습 과목 번호 : ");
		map.put("classNo", sc.nextLine());
		System.out.print("학습 시간(분) : ");
		map.put("studyTime", sc.nextLine());
		System.out.print("성취도 평가(1~5) : ");
		map.put("performance", sc.nextLine());
		
		return map;
	}
	
	
	public String inputClassName() {
		System.out.print("조회할 과목 입력 : "); //이 클래스 안에서 출력 문구 통일 필요
		return sc.nextLine();
	}
	
	public String inputStudentNo() {
		System.out.print("학생 번호 입력 : ");
		sc.nextLine(); //7번 문항
		return sc.nextLine();
	}

	
	public String inputDate() {
		System.out.print("조회할 날짜 입력 : ");
		return sc.nextLine();
	}
	
	public String inputClassCode() {
		System.out.print("과목 코드 입력 : ");
		return sc.nextLine();
	}
	
	public double inputStudyTime() {
		System.out.print("학습 시간 입력 : ");
		return sc.nextDouble();
	}
	
	public String performance() {
		System.out.print("일일 성취도 평가(1~5) : ");
		return sc.nextLine();
	}
	
	public String inputStudentName() {
		sc.nextLine();
		System.out.println("변경된 학생명 입력 (변경사항 없을시 기존 정보 입력) : ");
		return sc.nextLine();
	}
	
	public String inputPhone() {
		System.out.print("변경된 연락처 입력 (변경사항 없을시 기존 정보 입력) : ");
		return sc.nextLine();
	}
	
}