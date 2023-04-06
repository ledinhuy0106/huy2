package model;

public class Teacher {
    private int id=1;
    private String name;
    private int age;
    private String position;
    private String phoneNumber;


    public Teacher() {
    }

    public Teacher(int id, String name, int age, String position, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.phoneNumber = phoneNumber;
    }
    // Getter và setter cho các thuộc tính

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Định nghĩa enum Position

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public enum Position {
        PRINCIPAL("Hiệu trưởng"),
        VICE_PRINCIPAL("Hiệu phó"),
        TEACHER("Giáo viên");

        private String value;

        Position(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

