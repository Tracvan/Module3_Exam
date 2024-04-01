package controller;

import dao.StudentDAO;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/homepage")
public class StudentServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                try {
                    removeStudent(request,response);
                    showAll(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "edit":
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                StudentDAO studentDAO = new StudentDAO();
                try {
                    Student student = studentDAO.selectStudent(studentId);
                    request.setAttribute("student", student);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
                    dispatcher.forward(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                showEditForm(request,
                        response);
                break;
            default:
                try {
                    showAll(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                try {
                    editStudent(request,response);
                    showAll(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    showAll(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    public void showAll(HttpServletRequest request,
                        HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Student>studentList = studentDAO.selectAll(request, response);
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(request, response);
    }
    public void removeStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        studentDAO.deleteStudent(Integer.parseInt(request.getParameter("studentId")));
    }
    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("edit.jsp");
    }
    public void editStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String newName = request.getParameter("name");
        LocalDate newBirth = LocalDate.parse( request.getParameter("birth") );
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String className =request.getParameter("className") ;
        Student newStudent = new Student(studentId,
                newName,
                newBirth,
                address,
                phoneNumber,
                className);

        StudentDAO studentDAO1 = new StudentDAO();
        studentDAO1.updateStudent(newStudent);
    }
}
