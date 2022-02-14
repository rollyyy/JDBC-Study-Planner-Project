package com.phoenix.member.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.phoenix.member.model.dto.ClassDTO;
import com.phoenix.member.model.dto.PlannerDTO;
import com.phoenix.member.model.dto.StudentDTO;
import com.phoenix.member.model.service.PlannerService;
import com.phoenix.member.view.PlannerResultView;
public class PlannerController {
    
    private PlannerService plannerService = new PlannerService();
    private PlannerResultView plannerResultView = new PlannerResultView();
    
    
    /* 1. 학생 등록 */
    public void registNewStudent(Map<String, String> requestMap) {
        
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(requestMap.get("studentName"));
        studentDTO.setPhone(requestMap.get("phone"));
        
        int registResult = plannerService.insertStudent(studentDTO);
        
        if(registResult > 0) {
            plannerResultView.displayResult("insertSuccess");
        } else {
            plannerResultView.displayResult("insertFailed");
        }
    }
    
    /* 2. 모든 학생 조회 */
    public void selectAllStudent() {
        
        List<StudentDTO> studentList = plannerService.selectAllStudent();
        
        if(!studentList.isEmpty()) {
            plannerResultView.studentResult(studentList);
        } else {
            plannerResultView.displayResult("selectFailed");
        }
        
    }
    
    /* 3. 과목 등록 */
    public void registNewClass(Map<String, String> requestMap) {
        
        ClassDTO classDTO = new ClassDTO();
        classDTO.setClassName(requestMap.get("className"));
        
        int registResult = plannerService.insertClass(classDTO);
        
        if(registResult > 0) {
            plannerResultView.displayResult("classSuccess");
        } else {
            plannerResultView.displayResult("classFailed");
        }
    }
    
    /* 4. 모든 과목 조회 */
    public void selectAllClass() {
        
        List<ClassDTO> classList = plannerService.selectAllClass();
        
        if(!classList.isEmpty()) {
            plannerResultView.classResult(classList);
        } else {
            plannerResultView.displayResult("classSelectFailed");
        }
        
    }
    
    /* 5. 스터디 기록 등록 */
    public void insertDailyStudy(Map<String, String> requestMap) {
        PlannerDTO plannerDTO = new PlannerDTO();
        
        plannerDTO.setStudentNo(requestMap.get("studentNo"));
        plannerDTO.setStudyTime(requestMap.get("studyTime"));
        plannerDTO.setPerformance(requestMap.get("performance"));
        plannerDTO.setClassCode(requestMap.get("classNo"));
        
        int insertResult = plannerService.insertDailyStudy(plannerDTO);
        
        if(insertResult > 0) {
            plannerResultView.displayResult("plannerSuccess");
        } else {
            plannerResultView.displayResult("plannerFailed");
        }
        
    }
    
    /* 6. 모든 스터디 기록 조회 */
    public void selectAllPlanner() {
        
        List<PlannerDTO> plannerList = plannerService.selectAllPlanner();
        
        if(!plannerList.isEmpty()) {
            plannerResultView.plannerResult(plannerList);
        } else {
            plannerResultView.displayResult("selectFailed");
        }
    }
    
    /* 6-2. 날짜별 스터디 기록 조회 */
    public void selectPlannerByDate(String date, int studentNo) {
        
        List<PlannerDTO> plannerList = plannerService.selectPlannerByDate(date);
        
        if(!plannerList.isEmpty()) {
            plannerResultView.plannerResult(plannerList);
        } else {
            plannerResultView.displayResult("selectFailed");
        }
        
    }
    
    /* 7. 학생 정보 변경 */
    public void updateStudentByNo(String inputStudentNo, String inputPhone) {
        
        int insertResult = plannerService.updateStudentByNo(inputStudentNo, inputPhone);
        
        if(insertResult > 0) {
            plannerResultView.displayResult("updateSeccess");
        } else {
            plannerResultView.displayResult("updateFailed");
        } 
        
    }
    
    /* 8. 학생 정보 삭제 */
    public void deleteStudentByNo(String string) {
        
        int insertResult = plannerService.deleteStudentByNo(string);
        
        if(insertResult > 0) {
            plannerResultView.displayResult("deleteSuccess");
        } else {
            plannerResultView.displayResult("deleteFailed");
        }
        
    }
}