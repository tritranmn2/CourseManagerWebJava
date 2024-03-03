package btvn.model;

import java.util.Objects;

/**
 *
 * @author tritranmn2
 */
public class Register {
    public String idhs;
    public String idcourse;
    public String year;
    public String score;

    public Register(String idhs, String idcourse, String year, String score) {
        this.idhs = idhs;
        this.idcourse = idcourse;
        this.year = year;
        this.score = score;
    }

    public String getIdhs() {
        return idhs;
    }

    public String getIdcourse() {
        return idcourse;
    }

    public String getYear() {
        return year;
    }

    public String getScore() {
        return score;
    }

    public void setIdhs(String idhs) {
        this.idhs = idhs;
    }

    public void setIdcourse(String idcourse) {
        this.idcourse = idcourse;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idhs);
        hash = 79 * hash + Objects.hashCode(this.idcourse);
        hash = 79 * hash + Objects.hashCode(this.year);
        hash = 79 * hash + Objects.hashCode(this.score);
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
        final Register other = (Register) obj;
        if (!Objects.equals(this.idhs, other.idhs)) {
            return false;
        }
        if (!Objects.equals(this.idcourse, other.idcourse)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        return Objects.equals(this.score, other.score);
    }

    @Override
    public String toString() {
        return "Register{" + "idhs=" + idhs + ", idcourse=" + idcourse + ", year=" + year + ", score=" + score + '}';
    }
    
    
    
}
