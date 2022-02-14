package com.phoenix.member.model.dao;
import static com.phoenix.common.JDBCTemplate.close;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.phoenix.member.model.dto.ClassDTO;
import com.phoenix.member.model.dto.PlannerDTO;
import com.phoenix.member.model.dto.StudentDTO;
public class StudentDAO {
    
    private Properties prop = new Properties();
    
    public StudentDAO() {
        try {
            prop.loadFromXML(new FileInputStream("mapper/planner-query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* 1. 학생 등록 */
    public int insertStudent(Connection con, StudentDTO student) {
        
        PreparedStatement pstmt = null;
        int result = 0;
        
        String qurey = prop.getProperty("insertStudent");
        
        try {
            pstmt = con.prepareStatement(qurey);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    
    /* 2. 모든 학생 조회*/
    public List<StudentDTO> selectAllStudent(Connection con) {
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        List<StudentDTO> studentList = null;
        
        String query = prop.getProperty("selectAllStudent");
        
        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();
            
            studentList = new ArrayList<>();
            
            while(rset.next()) {
                StudentDTO student = new StudentDTO();
                student.setInputStudentNo(rset.getString("STUDENT_NO"));              
                student.setName(rset.getString("STUDENT_NAME"));
                student.setPhone(rset.getString("PHONE"));
                
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return studentList;
    }
    /*3. 과목 등록 */
    public int insertClass(Connection con, ClassDTO classes) {
        
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertClass");
        
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, classes.getClassName());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    /* 4. 모든 과목 조회 */
    public List<ClassDTO> selectAllClass(Connection con) {
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        List<ClassDTO> classList = null;
        
        String query = prop.getProperty("selectAllClass");
        
        try {
            pstmt = con.prepareStatement(query);
            
            rset = pstmt.executeQuery();
            
            classList = new ArrayList<>();
            
            while(rset.next()) {
                ClassDTO classes = new ClassDTO();
                
                classes.setClassCode(rset.getString("CLASS_CODE"));
                classes.setClassName(rset.getString("CLASS_NAME"));
                
                classList.add(classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return classList;
    }
    /* 5. 스터디 기록 등록 */
public int insertDailyStudy(Connection con, PlannerDTO plannerDTO) {
        
        PreparedStatement pstmt = null;
        
        int result = 0;
        
        String query = prop.getProperty("insertDailyStudy");
        
        try {
//          StudentDTO studentDTO = new StudentDTO();
//          ClassDTO classDTO = new ClassDTO();
            
            pstmt = con.prepareStatement(query);
            pstmt.setObject(1, plannerDTO.getStudentNo());
            pstmt.setObject(2, plannerDTO.getStudyTime());
            pstmt.setString(3, plannerDTO.getPerformance());
            pstmt.setObject(4, plannerDTO.getClassCode());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    
    /* 6. 모든 스터디 기록 조회 */
    public List<PlannerDTO> selectAllPlanner(Connection con){
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        List<PlannerDTO> plannerList = null;
        
        String query = prop.getProperty("selectAllPlanner");
        
        try {
            pstmt = con.prepareStatement(query);
                        
            rset = pstmt.executeQuery();
            
            plannerList = new ArrayList<>();
            
            while(rset.next()) {
                PlannerDTO planner = new PlannerDTO();
                planner.setDate(rset.getDate("PLAN_DATE"));
                planner.setStudentNo(rset.getString("STUDENT_NO"));
                planner.setStudyTime(rset.getString("STUDY_TIME")); //String에 담아온 studyTime 값을 Integer로 형변환
                planner.setPerformance(rset.getString("STUDY_PERFORMANCE"));
                planner.setClassCode(rset.getString("CLASS_CODE"));
                
                plannerList.add(planner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return plannerList;
    }
    /* 6-2. 날짜별 스터디 기록 조회 */
    public List<PlannerDTO> selectPlannerByDate(Connection con, String date) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        List<PlannerDTO> plannerList = null;
        
        String query = prop.getProperty("selectAllClass");
        
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, date);
                        
            rset = pstmt.executeQuery();
            
            plannerList = new ArrayList<>();
            
            while(rset.next()) {
                PlannerDTO planner = new PlannerDTO();
                planner.setDate(Date.valueOf(date));
                planner.setStudyTime("STUDY_TIME");
                //Integer.parseInt("STUDY_TIME")); //String에 담아온 studyTime 값을 Integer로 형변환
                planner.setPerformance("STUDY_PERFORMANCE");
                planner.setClassCode("CLASS_CODE");
                plannerList.add(planner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return plannerList;
    }
    
    /* 7. 학생 정보 변경 */
    public int updateStudentByNo(Connection con, String inputStudentNo, String inputPhone) {
        
        PreparedStatement pstmt = null;
        int result = 0;
        
        String query = prop.getProperty("updateStudentByNo");
        
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, inputPhone);
            pstmt.setString(2, inputStudentNo);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    /* 8. 학생 정보 삭제 */
    public int deleteStudentByNo(Connection con, String string) {
        
        PreparedStatement pstmt = null;
        int result = 0;
        
        String query = prop.getProperty("deleteStudentByNo");
        
        try {
            pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, string);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
}