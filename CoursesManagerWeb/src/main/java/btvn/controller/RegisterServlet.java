package btvn.controller;

import btvn.DAO.CoursesDAO;
import btvn.DAO.RegisterDAO;
import btvn.DAO.StudentsDAO;
import btvn.model.Course;
import btvn.model.Register;
import btvn.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "register", urlPatterns = {"/register", "/register/"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String idCourse = request.getParameter("idCourse");
        String year = request.getParameter("year");
        CoursesDAO cDAO = new CoursesDAO();
        RegisterDAO regDAO = new RegisterDAO();
        ArrayList<Course> courses = cDAO.searchId(idCourse);
        request.setAttribute("course", courses.get(0));
        ArrayList<Student> students = regDAO.selectStudents(idCourse, year);
        request.setAttribute("students", students);

//        PrintWriter pt;
//        try {
//            pt = res.getWriter();
//            pt.println(idReq);
//            pt.println(year);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        if (idReq != null && idReq != "") {
//            ArrayList<Student> students = stsDAO.searchId(idReq);
//            req.setAttribute("student", students.get(0));
//        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println("RegisterSevlet Dispatcher:" + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String isDelete = request.getParameter("isDelete");
        String isUpdate = request.getParameter("isUpdate");

        if (isDelete != null && isDelete.equals("true")) {
            doDelete(request, response);
        } else if (isUpdate != null && isUpdate.equals("true")) {
            doPut(request, response);
        } else {
            String idCourse = request.getParameter("idCourse");
            String year = request.getParameter("year");
            String idhs = request.getParameter("idhs");
            String nameStudent = request.getParameter("nameStudent");
            RegisterDAO regDAO = new RegisterDAO();
            Register r = new Register(idhs, idCourse, year, "");
            regDAO.insert(r);
            doGet(request, response);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String idCourse = request.getParameter("idCourse");
        String year = request.getParameter("year");
        String idhs = request.getParameter("idhs");
        RegisterDAO regDAO = new RegisterDAO();
        Register r = new Register(idhs, idCourse, year, "");
        regDAO.delete(r);
        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        String grade = request.getParameter("grade");
//        String birthday = request.getParameter("birthday");
//        String address = request.getParameter("address");
//        String note = request.getParameter("note");
//        Student st = new Student(id, name, grade, birthday, address, note);
//        StudentsDAO stsDAO = new StudentsDAO();
//        stsDAO.update(st);
//        request.setAttribute("student", st);
//        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
