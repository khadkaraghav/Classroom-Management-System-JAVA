package com.company;

import java.util.ArrayList;

public interface ClassDAO {

    void insert(Class cc);

    boolean delete(int id);

    Class getById(int id);

    ArrayList<Class> getAll();

    ArrayList<Class> search(String param);

    int count();
}