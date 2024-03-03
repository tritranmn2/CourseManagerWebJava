package btvn.controller;

import btvn.DAO.StudentsDAO;
import btvn.model.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "students", urlPatterns = {"/students", "/students/", "/"})
public class StudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        StudentsDAO stsDAO = new StudentsDAO();
        
        String idReq = req.getParameter("idChoose");
        String nameSort = req.getParameter("nameSort");
        String gradeSort = req.getParameter("gradeSort");
        String searchName = req.getParameter("searchName");
        if(nameSort!=null){
            if(nameSort.equals("1")){
                ArrayList<Student> students = stsDAO.sort("name asc");
                req.setAttribute("students", students);
            }else{
                ArrayList<Student> students = stsDAO.sort("name desc");
                req.setAttribute("students", students);
            }
        }else if(gradeSort!=null){
            if(gradeSort.equals("1")){
                ArrayList<Student> students = stsDAO.sort("grade asc");
                req.setAttribute("students", students);
            }else{
                ArrayList<Student> students = stsDAO.sort("grade desc");
                req.setAttribute("students", students);
            }
        }else if(searchName!=null){
            ArrayList<Student> students = stsDAO.searchName(searchName);
            req.setAttribute("students", students);
        }
        else{
            ArrayList<Student> students = stsDAO.select();
            req.setAttribute("students", students);
        }
        if (idReq != null && idReq != "") {
            ArrayList<Student> students = stsDAO.searchId(idReq);
            req.setAttribute("student", students.get(0));
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/students.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (Exception e) {
            System.out.println("StudentsSevlet Dispatcher:" + e.getMessage());
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
            String grade = request.getParameter("grade");
            String birthday = request.getParameter("birthday");
            String address = request.getParameter("address");
            String note = request.getParameter("note");
            Student st = new Student(id, name, grade, birthday, address, note);
            StudentsDAO stsDAO = new StudentsDAO();
            stsDAO.insert(st);
            request.setAttribute("student", st);
            doGet(request, response);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        StudentsDAO stsDAO = new StudentsDAO();
        stsDAO.delete(new Student(id));
        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        Student st = new Student(id, name, grade, birthday, address, note);
        StudentsDAO stsDAO = new StudentsDAO();
        stsDAO.update(st);
        request.setAttribute("student", st);
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
