package br.com.sky.dp.factory;

/***
 * Classe que implementa a lógica do Factory
 */
public class ShapeFactory {

    enum ShapeType {
        CIRCLE,
        RECTANGLE,
        SQUARE
    }

    public Shape getShape(ShapeType shapeType) {
        if (shapeType == null) return null;
        return switch (shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
        };
    }
}
