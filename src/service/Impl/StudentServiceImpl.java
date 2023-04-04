package service.Impl;

import model.Student;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements Service<Student> {
    private List<Student> students = new ArrayList<>();

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Student getOne(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

