package btvn.controller;

import btvn.DAO.RegisterDAO;
import btvn.DAO.StudentsDAO;
import btvn.model.CoursesPoint;
import btvn.model.Register;
import btvn.model.Student;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "coursesPoint", urlPatterns = {"/coursesPoint", "/coursesPoint/"})
public class CoursesPointServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String isDelete = request.getParameter("isDelete");
        String idhs = request.getParameter("idhs");
        String year = request.getParameter("year");
        StudentsDAO stDAO = new StudentsDAO();
        RegisterDAO regDAO = new RegisterDAO();

        ArrayList<Student> students = stDAO.searchId(idhs);
        request.setAttribute("student", students.get(0));
        if ( (isDelete==null || !isDelete.equals("true"))&& year != null && !year.equals("")) {
            ArrayList<CoursesPoint> coursesPoints = regDAO.searchCoursesPoint(idhs, year);
            request.setAttribute("year", year);
            request.setAttribute("coursesPoints", coursesPoints);
        } else {
            ArrayList<CoursesPoint> coursesPoints = regDAO.searchCoursesPoint(idhs);
            request.setAttribute("coursesPoints", coursesPoints);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/coursesPoint.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println("coursesPointsSevlet Dispatcher:" + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String isSearch = request.getParameter("isSearch");
        String isDelete = request.getParameter("isDelete");

        if (isSearch != null && isSearch.equals("true")) {
            doGet(request, response);
        } else if (isDelete != null && isDelete.equals("true")) {
            doDelete(request, response);
        } else {
            String idCourse = request.getParameter("idCourse");
            String year = request.getParameter("year");
            String idhs = request.getParameter("idhs");
            String point = request.getParameter("point");
            Register r = new Register(idhs, idCourse, year, point);
            RegisterDAO regDAO = new RegisterDAO();
            regDAO.insert(r);

            doGet(request, response);
//        }

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
        request.setAttribute("isDelete", "true");
        doGet(request, response);
    }
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
}
