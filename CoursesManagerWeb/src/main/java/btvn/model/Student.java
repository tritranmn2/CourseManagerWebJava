package btvn.model;


import java.util.Objects;
import java.util.logging.Logger;


/**
 *
 * @author tritranmn2
 */
public class Student {
    public String id;
    public String name;
    public String grade;
    public String birthday;
    public String address;
    public String note;

    public Student(String id) {
        this.id = id;
        this.name = "";
        this.birthday = "";
        this.address = "";
        this.grade = "";
        this.note = "";
    }
    public Student(String id, String name,  String grade,String birthday, String address, String note) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.grade = grade;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getGrade() {
        return grade;
    }

    public String getNote() {
        return note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.birthday);
        hash = 23 * hash + Objects.hashCode(this.address);
        hash = 23 * hash + Objects.hashCode(this.grade);
        hash = 23 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.grade, other.grade)) {
            return false;
        }
        return Objects.equals(this.note, other.note);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + ", address=" + address + ", grade=" + grade + ", note=" + note + '}';
    }
    
}
