package factorypattern;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

        // ngambil objek dari shape rectangle
        Shape shape1 = shapeFactory.getShape("RECTANGLE");

        // manggil draw method dari shape rectangle
        shape1.draw();

        // manggil objek dari shape square
        Shape shape2 = shapeFactory.getShape("SQUARE");

        // manggil draw method dari shape square
        shape2.draw();

        // get shape factory
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);

        // manggil objek dari rectangle
        Shape shape3 = shapeFactory1.getShape("RECTANGLE");

        // manggil draw method dari shape rectangle
        shape3.draw();

        // manggil objek dari square
        Shape shape4 = shapeFactory.getShape("SQUARE");

        // manggil draw method dari shape square
        shape4.draw();
    }
}
