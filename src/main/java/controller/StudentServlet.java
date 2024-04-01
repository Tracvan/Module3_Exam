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
import java.util.ArrayList;
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
            case "deleteServlet":
                removeStudent(request,response);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void showAll(HttpServletRequest request,
                        HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Student>studentList = studentDAO.selectAll(request, response);
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(request, response);
    }
    public void removeStudent(HttpServletRequest request, HttpServletResponse){
        List<Student> studentList = studentDAO.deleteStudent(id);
        request.setAttribute("studentList",studentList);
    }
}
