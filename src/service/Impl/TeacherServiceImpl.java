package service.Impl;

import model.Teacher;
import service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherServiceImpl implements Service<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    @Override
    public void add(Teacher obj) {
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
//            check hàm getall nếu rộng thì chạy trong if
            if (getAll().isEmpty()) {
                if (position.trim().equalsIgnoreCase("Hiệu trưởng".trim()) || position.trim().equalsIgnoreCase("Hieu truong")) {
                    //                so sánh từ vừa nhập vào có trùng từ hiệu trưởng thì set cái vừa nhập thành "PRINCIPAL=Hiệu trưởng"

                    position = Teacher.Position.PRINCIPAL.getValue();
//                    cái này thành true để tý while nó dẽ thấy điều kiện đúng và không lặp lại nữa
                    hasPrincipal = true;

                } else if (position.trim().equalsIgnoreCase("Hiệu phó") || position.trim().equalsIgnoreCase("hieu pho")) {
//                     tương tự như trên
                    position = Teacher.Position.VICE_PRINCIPAL.getValue();
                    hasPrincipal = true;
                } else {
//                    tương tự
                    position = Teacher.Position.TEACHER.getValue();
                    hasPrincipal = true;
                }
            }
//          còn nếu getAll có phần tử thì set trường hợp đã ai có chức hiệu trưởng chưa )
            if (!getAll().isEmpty()) {
//                check như trên
                if (position.trim().equalsIgnoreCase("Hiệu trưởng".trim()) || position.trim().equalsIgnoreCase("Hieu truong")) {
                    boolean foundPrincipal = false;
                    String positionStr = Teacher.Position.PRINCIPAL.getValue().trim();

//                    lặp mảng và chéch xem đã có hiệu trưởng chưa
                    for (Teacher teacher : getAll()) {
                        if (teacher.getPosition().contains(positionStr)) {
                            System.out.println("Mỗi trường học chỉ có 1 hiệu trưởng");
//                         nếu có rồi thì set thành true và sẽ bỏ qua if dưới
                            foundPrincipal = true;
                            break;
                        }
                    }
//                    nếu đoạn trên là false thì là chưa có hiệu truỏng và sẽ lấy khác false là true sẽ vào điều kieenj
                    if (!foundPrincipal) {
//                        set từ nãy nhập vào thành hiệu trưởng PRINCIPAL=Hiệu trưởng
                        position = Teacher.Position.PRINCIPAL.getValue();
                        hasPrincipal = true;
                    }

                } else if (position.trim().equalsIgnoreCase("Hiệu phó".trim()) || position.trim().equalsIgnoreCase("hieu pho")) {
                    position = Teacher.Position.TEACHER.getValue();
                    hasPrincipal = true;
                }
                else {
//                    tương tự
                    position = Teacher.Position.TEACHER.getValue();
                    hasPrincipal = true;
                }
            }
//            vì đây là 2 scope khác nhau nên cái !hasPrincipal vẫn = true nên vòng lặp sẽ chạy tiếp, còn nếu hợp dk if dòng 66 thì vòng lặp mới kết thúc và break.
        } while (!hasPrincipal || position.isEmpty() || nameTeacher.isEmpty() || ageTeacher == -1 || phoneNumber2.isEmpty());
        int id2 = getAll().size() + 1;
        Teacher teacher0 = new Teacher(id2, nameTeacher, ageTeacher, position, phoneNumber2);
        teachers.add(teacher0);
        System.out.println("Thêm giáo viên thành công");
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

    public static void update1() {
        TeacherServiceImpl teacher1 = new TeacherServiceImpl();
        System.out.print("Nhập ID sinh viên cần sửa: ");
        int idgv = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên mới: ");
        String newNamegv = scanner.nextLine();
        System.out.print("Nhập tuổi mới: ");
        int newAgegv = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập số điện thoại mới: ");
        String phoneNumber23 = scanner.nextLine();
        String position;
        boolean hasPrincipal = false;
        do {
            System.out.print("Nhập chức vụ: ");
            position = scanner.nextLine();
            if (position.trim().equalsIgnoreCase("Hiệu trưởng".trim()) || position.trim().equalsIgnoreCase("Hieu truong".trim())) {
                boolean foundPrincipal = false;
                String positionStr = Teacher.Position.PRINCIPAL.getValue().trim();

                for (Teacher teacher : teacher1.getAll()) {
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
            else {
//                    tương tự
                position = Teacher.Position.TEACHER.getValue();
                hasPrincipal = true;
            }
        } while (!hasPrincipal || position.isEmpty() || newNamegv.isEmpty() || newAgegv == -1 || phoneNumber23.isEmpty());
        Teacher teacher0 = new Teacher(idgv, newNamegv, newAgegv, position, phoneNumber23);
        teacher1.update(teacher0);
        System.out.println("Sửa thông tin sinh viên thành công");
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