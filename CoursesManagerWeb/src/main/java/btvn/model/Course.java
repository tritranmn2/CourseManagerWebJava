package btvn.model;

import java.util.Objects;

/**
 *
 * @author tritranmn2
 */
public class Course {
    public String id;
    public String name;
    public String lecture;
    public String year;
    public String note;

    public Course(String id) {
        this.id = id;
        this.name = "";
        this.lecture = "";
        this.year = "";
        this.note = "";
    }
    public Course(String id, String name, String lecture, String year, String note) {
        this.id = id;
        this.name = name;
        this.lecture = lecture;
        this.year = year;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLecture() {
        return lecture;
    }

    public String getYear() {
        return year;
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

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.lecture);
        hash = 79 * hash + Objects.hashCode(this.year);
        hash = 79 * hash + Objects.hashCode(this.note);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lecture, other.lecture)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        return Objects.equals(this.note, other.note);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", lecture=" + lecture + ", year=" + year + ", note=" + note + '}';
    }
    
}
