package com.proj.code.io.object_externalizable;

import com.proj.code.constant.CodeConstants;
import org.junit.Test;

import java.io.*;

public class ObjectExternalizableTest {

    @Test
    public void read() throws IOException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CodeConstants.FILE_ROOT_PATH + "data.bat"));
        Object object = null;
        try {
            object = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(object);

    }

    @Test
    public void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CodeConstants.FILE_ROOT_PATH + "data.bat"));
        Student student = new Student(1, "张三", 18);
        student.setSchool("社会");
        oos.writeObject(student);
    }
}

