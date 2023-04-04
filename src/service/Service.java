package service;

import java.util.List;

public interface Service<T> {
    void add(T obj); //Thêm sinh viên
    void update(T obj); //Sửa sinh viên
    void delete(int id); //Xóa sinh viên theo ID
    List<T> getAll(); //Hiển thị tất cả sinh viên
    T getOne(int id);
}
