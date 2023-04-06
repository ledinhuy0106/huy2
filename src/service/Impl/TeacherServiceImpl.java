package service.Impl;

import model.Teacher;
import service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TeacherServiceImpl implements Service<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public void add(Teacher obj) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên giáo viên: ");
        String nameTeacher = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int ageTeacher = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber2 = scanner.nextLine();
        boolean hasPrincipal = false;
        String position;
        do {
            System.out.print("Nhập chức vụ: ");
            position = scanner.nextLine();
            if (getAll().isEmpty()) {
                System.out.println("hi1");
                if (position.trim().equalsIgnoreCase("Hiệu trưởng".trim()) || position.trim().equalsIgnoreCase("Hieu truong")) {
                    position = Teacher.Position.PRINCIPAL.getValue();
                    hasPrincipal = true;

                } else if (position.trim().equalsIgnoreCase("Hiệu phó") || position.trim().equalsIgnoreCase("hieu pho")) {
                    position = Teacher.Position.VICE_PRINCIPAL.getValue();
                    hasPrincipal = true;
                } else {
                    position = Teacher.Position.TEACHER.getValue();
                    hasPrincipal = true;
                }
            }
            if (!getAll().isEmpty()) {
                System.out.println("hi2");
                if (position.trim().equalsIgnoreCase("Hiệu trưởng".trim()) || position.trim().equalsIgnoreCase("Hieu truong")) {
                    boolean foundPrincipal = false;
                    String positionStr = Teacher.Position.PRINCIPAL.getValue().trim();
                    for (Teacher teacher : getAll()) {
                        if (teacher.getPosition().contains(positionStr)) {
                            System.out.println("Mỗi trường học chỉ có 1 hiệu trưởng");
                            foundPrincipal = true;
                            break;
                        }
                    }
                    if (!foundPrincipal) {
                        position = Teacher.Position.PRINCIPAL.getValue();
                        hasPrincipal = true;
                    }
                } else if (position.trim().equalsIgnoreCase("Hiệu phó".trim()) || position.trim().equalsIgnoreCase("hieu pho")) {
                    position = Teacher.Position.TEACHER.getValue();
                    hasPrincipal = true;
                }
            }
        } while (!hasPrincipal || position.isEmpty() || nameTeacher.isEmpty() || ageTeacher == -1 || phoneNumber2.isEmpty());
        int id2 = getAll().size() + 1;
        Teacher teacher0 = new Teacher(id2, nameTeacher, ageTeacher, position, phoneNumber2);
        System.out.println("Thêm giáo viên thành công");
        teachers.add(teacher0);
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