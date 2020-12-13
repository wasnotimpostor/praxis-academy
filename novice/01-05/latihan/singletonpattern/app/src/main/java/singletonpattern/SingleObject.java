package singletonpattern;

public class SingleObject {
    // create object of SingleObject
    private static SingleObject instance = new SingleObject();

    // bikin constructor private biar gak bisa instantiated
    private SingleObject(){}

    // get the only object available
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World");
    }
}
