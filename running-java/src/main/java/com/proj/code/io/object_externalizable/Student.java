package com.proj.code.io.object_externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {
    private static final long serialVersionUID = -4639325464969796087L;
    private static String school = "shehui";
    private int id;
    private String name;
    private transient int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Student.school = school;
    }

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

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + ", age=" + age + ",school=" + school;
    }

    /**
     * @param out
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeUTF(school);
        out.writeInt(id);
        out.writeInt(age);
        out.writeUTF(name);

    }

    /**
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        school =in.readUTF();
        id = in.readInt();
        age = in.readInt();
        name = in.readUTF();

    }
}
