package at.alwinschuster;

import java.util.Arrays;
import java.util.List;

public class MyObject2 {
    private String something;
    private List<String> myList;

    public MyObject2() {
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    @Override
    public String toString() {
        return "MyObject2{" +
                "something='" + something + '\'' +
                ", myList=" + myList +
                '}';
    }
}
