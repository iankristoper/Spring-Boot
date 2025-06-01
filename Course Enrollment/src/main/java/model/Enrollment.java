
package model;

/**
 *
 * @noob
 */

import java.time.LocalDate;

public class Enrollment {
    
    private String studentId;
    private String courseId;
    private LocalDate dateEnrolled;
    
    
    public Enrollment() {
        
    }
    
    public Enrollment(String studentId, String courseId, LocalDate dateEnrolled) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.dateEnrolled = dateEnrolled;
    }
    
    //getters and setters 
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public String getCourseId() {
        return courseId;
    }
    
    public void setLocalDate(LocalDate dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }
    
    public LocalDate getLocalDate() {
        return dateEnrolled;
    }
}
