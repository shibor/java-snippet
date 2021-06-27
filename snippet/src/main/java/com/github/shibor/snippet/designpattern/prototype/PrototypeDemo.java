package com.github.shibor.snippet.designpattern.prototype;

import java.io.*;

/**
 *
 *     原型模式
 *
 * 浅拷贝 Cloneable
 * 深拷贝 序列化 Serializable
 *
 * @author shibor
 */
public class PrototypeDemo {

    public static void main(String[] args) {
        User user = new User();
        user.setAddress(new Address());

        User user1 = null;
        try {
            user1 = (User) user.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(user == user1);
        System.out.println(user.getAddress() == user1.getAddress());


        User user2 = null;
        try {
            user2 = (User) user.deepclone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user == user2);
        System.out.println(user.getAddress() == user2.getAddress());

    }

}


class User implements Cloneable, Serializable {

    private Address address;
    private int age;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepclone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);
        ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bai);

        return ois.readObject();
    }
}


class Address implements Serializable {

}


