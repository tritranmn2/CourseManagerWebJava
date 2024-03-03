package btvn.controller;

import btvn.DAO.CoursesDAO;
import btvn.DAO.RegisterDAO;
import btvn.model.Course;
import btvn.model.Register;
import btvn.model.Student;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "courses", urlPatterns = {"/courses", "/courses/" })
public class CoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        CoursesDAO cDAO = new CoursesDAO();
        
        String idReq = req.getParameter("idChoose");
        String nameSort = req.getParameter("nameSort");
        String searchName = req.getParameter("searchName");
        if(nameSort!=null){
            if(nameSort.equals("1")){
                ArrayList<Course> courses = cDAO.sort("name asc");
                req.setAttribute("courses", courses);
            }else{
                ArrayList<Course> courses = cDAO.sort("name desc");
                req.setAttribute("courses", courses);
            }
        }else if(searchName!=null){
            ArrayList<Course> courses = cDAO.searchName(searchName);
            req.setAttribute("courses", courses);
        }
        else{
            ArrayList<Course> courses = cDAO.select();
            req.setAttribute("courses", courses);
        }
        if (idReq != null && idReq != "") {
            ArrayList<Course> courses = cDAO.searchId(idReq);
            req.setAttribute("course", courses.get(0));


        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/courses.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (Exception e) {
            System.out.println("CoursesSevlet Dispatcher:" + e.getMessage());
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
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String lecture = request.getParameter("lecture");
            String year = request.getParameter("year");
            String note = request.getParameter("note");
            Course c = new Course(id, name, lecture, year, note);
            CoursesDAO cDAO = new CoursesDAO();
            cDAO.insert(c);
            request.setAttribute("course", c);
            doGet(request, response);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        CoursesDAO cDAO = new CoursesDAO();
        cDAO.delete(new Course(id));
        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String lecture = request.getParameter("lecture");
        String year = request.getParameter("year");
        String note = request.getParameter("note");
        Course c = new Course(id, name, lecture, year, note);
        CoursesDAO cDAO = new CoursesDAO();
        cDAO.update(c);
        request.setAttribute("course", c);
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
