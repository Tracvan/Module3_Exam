package dao;

import model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    public static final String SELECT_ALL = "select * from student;";
    public static final String DELETE_STUDENT= "delete  from student where id= ?";
    public static final String UPDATE_STUDENT ="update student set name = ?, birth= ?, address =?, phoneNumber=?, className=?"
            + " where id = ?;";
    public static final String SELECT_STUDENT = "select * from student where id = ?;";

    public StudentDAO() {
    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/studentClass?useSSL=false";
            String jdbcUsername = "root";
            String jdbcPassword = "123456";

            connection = DriverManager.getConnection(jdbcURL,
                    jdbcUsername,
                    jdbcPassword);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void insertStudent(Student student) {
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);
        statement.setString(1,student.getName());
        statement.setDate(2, Date.valueOf( student.getBirth()));
        statement.setString(3,student.getAddress());
        statement.setString(4,student.getPhoneNumber());
        statement.setString(5,student.getClassName());
        statement.setString(6,student.getClassName());
        statement.executeUpdate();
    }

    @Override
    public List<Student> selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalDate birth = rs.getDate("birth").toLocalDate();
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String className = rs.getString("className");
                studentList.add(new Student(id, name, birth, address, phoneNumber, className));
            }
        }
        return studentList;
    }


    @Override
    public void deleteStudent(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public Student selectStudent(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Student student = null;
        while (rs.next()){
            String name = rs.getString("name");
            LocalDate birth = rs.getDate("birth").toLocalDate();
            String address = rs.getString("address");
            String phoneNumber = rs.getString("phoneNumber");
            String className = rs.getString("className");
             student = new Student(id,name,birth,address,phoneNumber,className);

        }
        return student;
    }

}

