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
    public void updateStudent(int id) {

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
                int classRoom = rs.getInt("classId");
                studentList.add(new Student(id, name, birth, address, phoneNumber, classRoom));
            }
        }
        return studentList;
    }

    @Override
    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void deleteStudent(int id) {
    }
}

