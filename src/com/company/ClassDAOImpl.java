package com.company;

import java.util.ArrayList;

public class ClassDAOImpl implements ClassDAO {

    private ArrayList<Class> classList;

    public ClassDAOImpl(){

        classList = new ArrayList<Class>();

    }

    @Override
    public void insert(Class cc) {

        classList.add(cc);

    }

    @Override
    public boolean delete(int id) {
        boolean hasDelete = false;
        for (Class cc : classList) {
            if (cc.getId() == id) {
                classList.remove(cc);
                hasDelete = true;
                break;
            }
        }
        return hasDelete;
    }

    @Override
    public Class getById(int id) {
        for (Class cc : classList) {
            if (cc.getId() == id) {
                return cc;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Class> getAll() {
        return classList;
    }

    @Override
    public ArrayList<Class> search(String param) {
        ArrayList<Class> classes = new ArrayList<>();
        for (Class cc : classList) {
            String name = cc.getName().toLowerCase();
            String desc = cc.getDescription().toLowerCase();
            param = param.toLowerCase();
            if (name.contains(param) || (desc.contains(param))) {
                classes.add(cc);
            }
        }
        return classes;
    }

    @Override
    public int count() {
        return classList.size();

    }
}

