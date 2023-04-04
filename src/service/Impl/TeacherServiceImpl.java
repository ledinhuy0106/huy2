package service.Impl;

import model.Teacher;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements Service<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public void add(Teacher obj) {
        teachers.add(obj);
    }

    @Override
    public void update(Teacher obj) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == obj.getId()) {
                teachers.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public Teacher getOne(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
}