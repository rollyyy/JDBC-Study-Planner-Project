package com.phoenix.member.view;

import java.util.List;

import com.phoenix.member.model.dto.ClassDTO;
import com.phoenix.member.model.dto.PlannerDTO;
import com.phoenix.member.model.dto.StudentDTO;

public class PlannerResultView {

	public void displayResult(String result) {
		/* 성공 실패여부 회원 확인 창 */
		switch(result) {
		case "insertSuccess" : System.out.println("학생정보 등록에 성공하였습니다 :) 공부 화이팅! "); break;
		case "insertFailed" : System.out.println("학생정보 등록에 실패하였습니다ㅠㅠ"); break;
		case "selectFailed" : System.out.println("조회에 실패하였습니다."); break;
		case "classSuccess" : System.out.println(" 과목 등록에 성공하였습니다. "); break;
		case "classFailed" : System.out.println(" 과목 등록에 실패하였습니다. "); break;
		case "classSelectFailed" : System.out.println(" 과목 조회에 실패하였습니다. "); break;
		case "plannerSuccess" : System.out.println("스터디 플래너 등록에 성공하였습니다! 수고하셨습니다."); break;
		case "plannerFailed" : System.out.println("스터디 플래너 등록에 실패하였습니다. "); break;
		case "updateSeccess" : System.out.println("정상적으로 변경되었습니다. "); break;
		case "updateFailed" : System.out.println("변경에 실패하였습니다."); break;
		case "deleteSuccess" : System.out.println(" 회원정보 삭제 완료 ㅂ2ㅂ2 ㅠㅠ"); break;
		case "deleteFailed" : System.out.println(" 회원정보 삭제 실패 ! 함께해요 ^^ "); break;
		default : System.out.println("알 수 없는 에러 발생 !"); break;
		}
		
	}

	
	/* studentDTO List에 담아 출력 */
	public void studentResult(List<StudentDTO> studentList) {
		
		for(StudentDTO s : studentList) {
			System.out.println(s);
		}
	}
	
	public void studentResult(StudentDTO s) {
		System.out.println(s);
	}
	
	
	/* classDTO List에 담아 출력 */
	public void classResult(List<ClassDTO> classList) {

		for(ClassDTO c : classList) {
			System.out.println(c);
		}
	}
	
	public void classResult(ClassDTO c) {
		System.out.println(c);
	}
	
	/* plannerDTO List에 답아 출력 */
	public void plannerResult(List<PlannerDTO> plannerList) {
		
		for(PlannerDTO p : plannerList) {
			System.out.println(p);
		}
	}
	
	public void plannerResult(PlannerDTO p) {
		System.out.println(p);
	}

}