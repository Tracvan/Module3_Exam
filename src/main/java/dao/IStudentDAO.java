package dao;

import model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student student);

    public void updateStudent(Student student) throws SQLException;

    public List<Student> selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException;

    public void deleteStudent(int id) throws SQLException;
    public Student selectStudent(int id) throws SQLException;
}
