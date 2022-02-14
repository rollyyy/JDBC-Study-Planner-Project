package com.phoenix.member.model.service;
import static com.phoenix.common.JDBCTemplate.close;
import static com.phoenix.common.JDBCTemplate.commit;
import static com.phoenix.common.JDBCTemplate.getConnection;
import static com.phoenix.common.JDBCTemplate.rollback;
import java.sql.Connection;
import java.util.List;
import com.phoenix.member.model.dao.StudentDAO;
import com.phoenix.member.model.dto.ClassDTO;
import com.phoenix.member.model.dto.PlannerDTO;
import com.phoenix.member.model.dto.StudentDTO;
public class PlannerService {
    
    private StudentDAO studentDAO = new StudentDAO();
    /* 1. 학생 등록 */
    public int insertStudent(StudentDTO student) {
        
        Connection con = getConnection();
        
        int result = 0;
        
        result = studentDAO.insertStudent(con, student);
        
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        
        return result;
    }
    /* 2. 모든 학생 조회 */
    public List<StudentDTO> selectAllStudent() {
        
        Connection con = getConnection();
        
        List<StudentDTO> studentList = studentDAO.selectAllStudent(con);
        
        close(con);
        
        return studentList;
    }
    
    /* 3. 과목 등록 */
    public int insertClass(ClassDTO classCode) {
        Connection con = getConnection();
        
        int result = 0;
        
        result = studentDAO.insertClass(con, classCode);
        
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        return result;
    }
    
    /* 4. 모든 과목 조회 */
    public List<ClassDTO> selectAllClass() {
        
        Connection con = getConnection();
        
        List<ClassDTO> classList = studentDAO.selectAllClass(con);
        
        close(con);
        
        return classList;
    }
    
    /* 5. 스터디 기록 등록 */
public int insertDailyStudy(PlannerDTO plannerDTO) {
        
        Connection con = getConnection();
        
        int result = 0;
        
        result = studentDAO.insertDailyStudy(con, plannerDTO);
        
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        
        close(con);
                
        return result;
    }
    
    /* 6. 모든 스터디 기록 조회 */
    public List<PlannerDTO> selectAllPlanner(){
        
        Connection con = getConnection();
        
        List<PlannerDTO> plannerList = studentDAO.selectAllPlanner(con);
        
        close(con);
        
        return plannerList;
    }
    
    /* 6-2. 날짜별 스터디 기록 조회 */
    public List<PlannerDTO> selectPlannerByDate(String date) {
        
        Connection con = getConnection();
            
        List<PlannerDTO> plannerList = studentDAO.selectPlannerByDate(con, date);
            
        close(con);
            
        return plannerList;
    }
    
    /* 7. 학생 정보 변경 */
    public int updateStudentByNo(String inputStudentNo, String inputPhone) {
        
        Connection con = getConnection();
        
        int result = 0;
        
        result = studentDAO.updateStudentByNo(con, inputStudentNo, inputPhone);
        
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        
        close(con);
                
        return result;
    }
    
    /* 8. 학생 정보 삭제용 */
    public int deleteStudentByNo(String string) {
        
        Connection con = getConnection();
        
        int result = 0;
        
        result = studentDAO.deleteStudentByNo(con, string);
        
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        
        close(con);
                
        return result;
    }
    
}