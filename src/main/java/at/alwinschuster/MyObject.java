package at.alwinschuster;

import java.util.Arrays;

public class MyObject {
    private String something;
    private String[] myArray;

    public MyObject() {
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public String[] getMyArray() {
        return myArray;
    }

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "something='" + something + '\'' +
                ", myArray=" + Arrays.toString(myArray) +
                '}';
    }
}
