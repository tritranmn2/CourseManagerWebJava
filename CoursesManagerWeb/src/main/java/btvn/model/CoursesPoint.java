package btvn.model;

import java.util.Objects;

/**
 *
 * @author tritranmn2
 */
public class CoursesPoint {
    public String id;
    public String name;
    public String year;
    public String point;

    public CoursesPoint(String id, String name, String year, String point) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.point = point;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getPoint() {
        return point;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.year);
        hash = 79 * hash + Objects.hashCode(this.point);
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
        final CoursesPoint other = (CoursesPoint) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        return Objects.equals(this.point, other.point);
    }

    @Override
    public String toString() {
        return "CoursesPoint{" + "id=" + id + ", name=" + name + ", year=" + year + ", point=" + point + '}';
    }
    
    
}
