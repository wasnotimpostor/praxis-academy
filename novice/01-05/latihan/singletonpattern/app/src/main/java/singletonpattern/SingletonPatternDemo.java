package singletonpattern;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        // illegal construct
        // compile time error : the constructor SingleObject() is not visible
        // SingleObject object = new SingleObject();

        // get the only object available
        SingleObject object = SingleObject.getInstance();

        // show message
        object.showMessage();
    }
}