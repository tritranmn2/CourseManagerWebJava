package btvn.DAO;

import java.util.ArrayList;

/**
 *
 * @author tritranmn2
 */
public interface CRUD<T> {
    public ArrayList<T> select();
    public ArrayList<T> searchId(String id);
    public ArrayList<T> searchName(String name);
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public  ArrayList<T> sort(String mode);
}
