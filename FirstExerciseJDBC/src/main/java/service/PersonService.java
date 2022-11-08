package service;

public interface PersonService {
    void insertPerson(int id, String name, String surname, int age);
    void deletePersonBy(int id);
    void updatePersonName(int id, String name);
    void retrieveAll();
    void retrievePersonById(int id);
}
