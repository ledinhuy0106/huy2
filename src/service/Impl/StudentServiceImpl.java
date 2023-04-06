package service.Impl;

import model.Student;
import service.Service;

import java.util.ArrayList;
import java.util.List;

import static service.Impl.TeacherServiceImpl.scanner;

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

    public static void update2() {
        StudentServiceImpl service = new StudentServiceImpl();
        System.out.print("Nhập ID sinh viên cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập tuổi mới: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập số điện thoại mới: ");
        String numberPhone = scanner.nextLine();
        System.out.print("Nhập địa chỉ mới: ");
        String newAddress = scanner.nextLine();
        System.out.println("Nhập giới tính học sinh: ");
        String genDer1 = scanner.nextLine();
        if (genDer1.equalsIgnoreCase("nu")
                || genDer1.equalsIgnoreCase("Nữ")) {
            genDer1 = Student.Gender.FEMALE.getValue();
        } else if (genDer1.equalsIgnoreCase("nam")) {
            genDer1 = Student.Gender.MALE.getValue();
        } else genDer1 = Student.Gender.OTHER.getValue();
        Student newStudent = new Student(id, newName, newAddress, numberPhone, newAge, genDer1);
        service.update(newStudent);
        System.out.println("Sửa thông tin sinh viên thành công");
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

