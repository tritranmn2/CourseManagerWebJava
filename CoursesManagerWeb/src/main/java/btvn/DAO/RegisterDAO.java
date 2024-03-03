package btvn.DAO;

import btvn.model.CoursesPoint;
import btvn.model.DatabaseConnection;
import btvn.model.Register;
import btvn.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tritranmn2
 */
public class RegisterDAO implements CRUD<Register> {

    public RegisterDAO() {
    }

    @Override
    public ArrayList<Register> select() {
        ArrayList<Register> registers = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM REGISTER;";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String idhs = rs.getString("idhs");
                String idcourse = rs.getString("idcourse");
                String year = rs.getString("year");
                String score = rs.getString("score");
                Register register = new Register(idhs, idcourse, year,score);
                registers.add(register);
            }
            
        } catch (Exception e) {
            System.out.println("SelectRegister:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return registers;
    }

    @Override
    public void insert(Register re) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "insert into register(idhs,idcourse,year,score) values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, re.idhs);
            stm.setString(2, re.idcourse);
            stm.setString(3, re.year);
            stm.setString(4, re.score);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("InsertRegisters:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }



    @Override
    public void update(Register re) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "UPDATE REGISTER SET score=? WHERE idhs = ? and idcourse=? and year =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, re.score);
            stm.setString(2, re.idhs);
            stm.setString(3, re.idcourse);
            stm.setString(4, re.year);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UpdateRegister:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    @Override
    public void delete(Register re) {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "DELETE FROM REGISTER WHERE idhs = ? and idcourse =? and year =?;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, re.idhs);
            stm.setString(2, re.idcourse);
            stm.setString(3, re.year);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DeleteRegister:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    @Override
    public ArrayList<Register> sort(String mode) {
        ArrayList<Register> registers = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM REGISTER ORDER BY " +mode ;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String idhs = rs.getString("idhs");
                String idcourse = rs.getString("idcourse");
                String year = rs.getString("year");
                String score = rs.getString("score");
                
                
                Register register = new Register(idhs, idcourse, year, score);
                registers.add(register);
            }
            
        } catch (Exception e) {
            System.out.println("SortRegister:"+e.getMessage());

        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return registers;
    }

    public ArrayList<CoursesPoint> searchCoursesPoint(String idhs) {
        ArrayList<CoursesPoint> coursesPoints = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "select idcourse,name,r.year, score from REGISTER r join COURSES c on r.idcourse=c.id and r.year = c.year where idhs=?;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idhs);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String idcourse = rs.getString("idcourse");
                String nameCourse = rs.getString("name");
                String year = rs.getString("year");
                String score = rs.getString("score");
                
                CoursesPoint cp = new CoursesPoint(idcourse,nameCourse,year,score);
                coursesPoints.add(cp);
            }
            
        } catch (Exception e) {
            System.out.println("searchCoursesPoint Register:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return coursesPoints;
    }

    public ArrayList<CoursesPoint> searchCoursesPoint(String idStudent, String year) {
        ArrayList<CoursesPoint> coursesPoints = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "select idcourse,name, score from REGISTER r join COURSES c on r.idcourse=c.id and r.year=c.year where idhs=? and r.year=?;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idStudent);
            stm.setString(2, year);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String idcourse = rs.getString("idcourse");
                String nameCourse = rs.getString("name");
                String score = rs.getString("score");
                
                CoursesPoint cp = new CoursesPoint(idcourse,nameCourse,year,score);
                coursesPoints.add(cp);
            }
            
        } catch (Exception e) {
            System.out.println("searchCoursesPoint Register:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return coursesPoints;
    }
    
    @Override
    public ArrayList<Register> searchId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Register> searchName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Student> selectStudents(String idCourse, String year) {
        ArrayList<Student> students = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "select idhs,name from REGISTER r join STUDENTS st on r.idhs=st.id where idcourse =? and year=?;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idCourse);
            stm.setString(2, year);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String idhs = rs.getString("idhs");
                String name = rs.getString("name");
                Student st = new Student(idhs,name,"","","","");
                students.add(st);
            }
            
        } catch (Exception e) {
            System.out.println("selectStudentsRegister:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return students;
        
    }

    
    
}