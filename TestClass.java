import java.util.*;
import java.io.*;


class TestClass {
    public static void main(String[] args) {
        TestClass temp1 = new TestClass();
        TestClass temp2 = temp1;
        System.out.println(temp1.hashCode() + " " + temp2.hashCode());
    }
}
