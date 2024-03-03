package btvn.DAO;

import btvn.model.Course;
import btvn.model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tritranmn2
 */
public class CoursesDAO implements CRUD<Course> {

    public CoursesDAO() {
    }

    @Override
    public ArrayList<Course> select() {
        ArrayList<Course> courses = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM COURSES;";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String lecture = rs.getString("lecture");
                String year = rs.getString("year");
                String note = rs.getString("note");
                Course course = new Course(id, name, lecture, year, note);
                courses.add(course);
            }
            
        } catch (Exception e) {
            System.out.println("SelectCourse:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return courses;
    }

    @Override
    public void insert(Course c) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "insert into COURSES(id,name,lecture, year, note) values(?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, c.id);
            stm.setString(2, c.name);
            stm.setString(3, c.lecture);
            stm.setString(4, c.year);
            stm.setString(5, c.note);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("InsertCourses:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }



    @Override
    public void update(Course c) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "UPDATE COURSES SET name=?,lecture=?,year=?,note=? WHERE id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, c.name);
            stm.setString(2, c.lecture);
            stm.setString(3, c.year);
            stm.setString(4, c.note);
            stm.setString(5, c.id);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UpdateCourses:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    @Override
    public void delete(Course c) {
        System.out.println("c:"+c);
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "DELETE FROM COURSES WHERE id = ?;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, c.id);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DeleteCourse:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    @Override
    public ArrayList<Course> sort(String mode) {
        ArrayList<Course> courses = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM COURSES ORDER BY " +mode ;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String lecture = rs.getString("lecture");
                String year = rs.getString("year");
                String note = rs.getString("note");
                Course course = new Course(id, name, lecture, year, note);
                courses.add(course);
            }
            
        } catch (Exception e) {
            System.out.println("SortStudent:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return courses;
    }

    @Override
    public ArrayList<Course> searchId(String id) {
        ArrayList<Course> courses = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM COURSES WHERE id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String lecture = rs.getString("lecture");
                String year = rs.getString("year");
                String note = rs.getString("note");
                Course course = new Course(id, name, lecture, year, note);
                courses.add(course);
            }
            
        } catch (Exception e) {
            System.out.println("SearchIdCourse:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return courses;
    }

  @Override
    public ArrayList<Course> searchName(String name) {
        ArrayList<Course> courses = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sqlName = "'%"+name+"%'";
            Statement stm =con.createStatement();
            String sql = "SELECT * FROM COURSES WHERE LOWER(name) like "+sqlName + "OR UPPER(name) like "+sqlName  ;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String nameReal = rs.getString("name");
                String lecture = rs.getString("lecture");
                String year = rs.getString("year");
                String note = rs.getString("note");
                Course course = new Course(id, nameReal, lecture, year, note);
                courses.add(course);
            }
            System.out.println(courses);
        } catch (Exception e) {
            System.out.println("SearchNameStudent:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return courses;
    }

    
}
