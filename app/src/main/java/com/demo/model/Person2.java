package com.demo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Intent传递对象，方式二，实现Parcelable接口
 * 实现原理是将一个完整的对象进行分解
 */
public class Person2 implements Parcelable {
    private String name;
    private int age;

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

    public static final Creator<Person2> CREATOR = new Creator<Person2>() {
        @Override
        public Person2 createFromParcel(Parcel parcel) {
            Person2 person2 = new Person2();
            person2.name = parcel.readString();
            person2.age = parcel.readInt();
            return person2;
        }

        @Override
        public Person2[] newArray(int size) {
            return new Person2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
