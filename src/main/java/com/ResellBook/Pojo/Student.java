package main.java.Pojo;

public class Student {
    public String studentName;
    public String studentNum;
    public String studentPasswd;
    public String college;
    public String grade;
    public String clazz;
    public String tel;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentPasswd() {
        return studentPasswd;
    }

    public void setStudentPasswd(String studentPasswd) {
        this.studentPasswd = studentPasswd;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Student(String studentName, String studentNum, String studentPasswd, String college, String grade, String clazz, String tel) {
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.studentPasswd = studentPasswd;
        this.college = college;
        this.grade = grade;
        this.clazz = clazz;
        this.tel = tel;
    }
}
