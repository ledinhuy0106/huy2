package main;


import java.util.Scanner;


import model.Student;
import model.Teacher;
import service.Impl.TeacherServiceImpl;
import service.Service;
import service.Impl.StudentServiceImpl;

public class MainStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service<Student> studentService = new StudentServiceImpl();
        Service<Teacher> teacherService = new TeacherServiceImpl();
        Student student1 = new Student();
        Teacher teacher2 = new Teacher();

        boolean running = true;
        while (running) {
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Xem chi tiết một sinh viên");
            System.out.println("6. Thêm giáo viên");
            System.out.println("7. Sửa thông tin giáo viên");
            System.out.println("8. Xóa giáo viên");
            System.out.println("9. Hiển thị danh sách giáo viên");
            System.out.println("10.Xem chi tiết một giáo viên");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    int id1 = student1.getId();
                    student1.setId(id1);
                    System.out.println("Nhập giới tính học sinh");
                    String genDer = scanner.nextLine();
                    if (genDer.equalsIgnoreCase("nu")
                            || genDer.equalsIgnoreCase("Nữ")) genDer = Student.Gender.FEMALE.getValue();
                    else if (genDer.equalsIgnoreCase("nam")
                            || genDer.equalsIgnoreCase("Nam")) genDer = Student.Gender.MALE.getValue();
                    else genDer = Student.Gender.OTHER.getValue();

                    Student student = new Student(id1, name, address, phoneNumber, age, genDer);
                    studentService.add(student);
                    System.out.println("Thêm sinh viên thành công");
                    break;
                case 2:
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
                    System.out.println("Nhập giới tính học sinh");
                    String genDer1 = scanner.nextLine();
                    if (genDer1.equalsIgnoreCase("nu")
                            || genDer1.equalsIgnoreCase("Nữ")) genDer1 = Student.Gender.FEMALE.getValue();
                    else if (genDer1.equalsIgnoreCase("nam")
                            || genDer1.equalsIgnoreCase("Nam")) genDer1 = Student.Gender.MALE.getValue();
                    else genDer1 = Student.Gender.OTHER.getValue();
                    Student newStudent = new Student(id, newName, newAddress, numberPhone, newAge, genDer1);
                    studentService.update(newStudent);
                    System.out.println("Sửa thông tin sinh viên thành công");
                    break;
                case 3:
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    int deleteId = scanner.nextInt();
                    studentService.delete(deleteId);
                    System.out.println("Xóa sinh viên thành công");
                    break;
                case 4:
                    System.out.println("Danh sách sinh viên:");
                    for (Student s : studentService.getAll()) {
                        System.out.println(s);
                    }
                    break;
                case 5:
                    System.out.print("Nhập ID sinh viên cần tìm: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Student result = studentService.getOne(searchId);
                    if (result == null) {
                        System.out.println("Không tìm thấy sinh viên");
                    } else {
                        System.out.println(result);
                    }
                    break;
                case 6:
                    teacherService.add(teacher2);
                    break;

                case 7:
                    break;
                case 8:
                case 9:
                    System.out.println("Danh sách sinh viên:");
                    for (Teacher teacher : teacherService.getAll()) {
                        System.out.println(teacher);
                    }
                    break;

                case 10:
                case 0:
                    running = false;
                    System.out.println("Kết thúc chương trình");
                    break;
            }
        }
        scanner.close();
    }
}
