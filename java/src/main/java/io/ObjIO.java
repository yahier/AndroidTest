package io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/**
 * test Object IO
 */
public class ObjIO {
    People p;
    public final static String filePath = "/Users/yahier/test";

    public static void main(String[] args) {
        ObjIO o = new ObjIO();
        o.save();
        o.get();
    }


    //测试完成。起码在编译时，是可以相互的做对方的构造参数的
    void gogo() {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
            DataOutputStream dataOut = new DataOutputStream(obj);
            ObjectOutputStream obj2 = new ObjectOutputStream(dataOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void save() {
        p = new People(12);
        try {
            ObjectOutputStream obj = new ObjectOutputStream(
                    new FileOutputStream(new File(filePath)));
            obj.writeObject(p);//
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("NO FILE");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    void get() {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(
                    new File(filePath)));
            try {
                People p = (People) oi.readObject();
                System.out.println(p.age);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static class People implements Serializable {
        int age;

        public People(int age) {
            this.age = age;

        }


    }

}
