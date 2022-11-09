package com.example.jdbcCrudApp.service;

import com.example.jdbcCrudApp.dao.PersonDAO;
import com.example.jdbcCrudApp.dao.PersonDAOImpl;

public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO;

    public PersonServiceImpl() {
        personDAO = PersonDAOImpl.getSharedInstance();
    }

    public void insertPerson(int id, String name, String surname, int age) {
        personDAO.insertPerson(id, name, surname, age);
    }

    public void deletePersonBy(int id) {
        personDAO.deletePersonBy(id);
    }

    public void updatePersonName(int id, String name) {
        personDAO.updatePersonName(id, name);
    }

    public void retrieveAll() {
        personDAO.retrieveAll();
    }

    public void retrievePersonById(int id) {
        personDAO.retrievePersonById(id);
    }
}
