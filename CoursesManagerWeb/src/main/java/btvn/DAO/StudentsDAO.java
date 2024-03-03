package btvn.DAO;

import btvn.model.DatabaseConnection;
import btvn.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tritranmn2
 */
public class StudentsDAO implements CRUD<Student> {

    public StudentsDAO() {
    }

    @Override
    public ArrayList<Student> select() {
        ArrayList<Student> students = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM STUDENTS;";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String address = rs.getString("address");
                String grade = rs.getString("grade");
                String note = rs.getString("note");
                Student student = new Student(id, name, grade, birthday, address, note);
                students.add(student);
            }
            
        } catch (Exception e) {
            System.out.println("SelectStudent:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return students;
    }

    @Override
    public void insert(Student st) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "insert into students(id,name,grade,birthday,address,note) values(?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, st.id);
            stm.setString(2, st.name);
            stm.setString(3, st.grade);
            stm.setString(4, st.birthday);
            stm.setString(5, st.address);
            stm.setString(6, st.note);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("InsertStudents:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }



    @Override
    public void update(Student st) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "UPDATE STUDENTS SET name=?,grade=?,birthday=?,address=?,note=? WHERE id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, st.name);
            stm.setString(2, st.grade);
            stm.setString(3, st.birthday);
            stm.setString(4, st.address);
            stm.setString(5, st.note);
            stm.setString(6, st.id);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UpdateStudent:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    @Override
    public void delete(Student st) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "DELETE FROM STUDENTS WHERE id = ?;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, st.id);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DeleteStudent:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    @Override
    public ArrayList<Student> sort(String mode) {
        ArrayList<Student> students = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM STUDENTS ORDER BY " +mode ;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String address = rs.getString("address");
                String grade = rs.getString("grade");
                String note = rs.getString("note");
                Student student = new Student(id, name, grade, birthday, address, note);
                students.add(student);
            }
            
        } catch (Exception e) {
            System.out.println("SortStudent:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return students;
    }

    @Override
    public ArrayList<Student> searchId(String id) {
        ArrayList<Student> students = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM STUDENTS WHERE id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String address = rs.getString("address");
                String grade = rs.getString("grade");
                String note = rs.getString("note");
                Student student = new Student(id, name, grade, birthday, address, note);
                students.add(student);
            }
            
        } catch (Exception e) {
            System.out.println("SearchIdStudent:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return students;
    }

    @Override
    public ArrayList<Student> searchName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sqlName = "'%"+name+"%'";
            Statement stm =con.createStatement();
            String sql = "SELECT * FROM STUDENTS WHERE LOWER(name) like "+sqlName + "OR UPPER(name) like "+sqlName  ;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String nameReal = rs.getString("name");
                String birthday = rs.getString("birthday");
                String address = rs.getString("address");
                String grade = rs.getString("grade");
                String note = rs.getString("note");
                Student student = new Student(id, nameReal, grade, birthday, address, note);
                students.add(student);
            }
            
        } catch (Exception e) {
            System.out.println("SearchNameStudent:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return students;
    }

    
}
