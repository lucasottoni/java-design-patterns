package br.com.sky.dp.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeFactoryTest {

    private final ShapeFactory shapeFactory = new ShapeFactory();

    @Test
    public void testCircle() {
        Shape shape = shapeFactory.getShape(ShapeFactory.ShapeType.CIRCLE);

        assertInstanceOf(Circle.class, shape);
        assertEquals("Drawing a circle", shape.draw());
    }

    @Test
    public void testSquare() {
        Shape shape = shapeFactory.getShape(ShapeFactory.ShapeType.SQUARE);

        assertInstanceOf(Square.class, shape);
        assertEquals("Drawing a square", shape.draw());
    }

    @Test
    public void testRectangle() {
        Shape shape = shapeFactory.getShape(ShapeFactory.ShapeType.RECTANGLE);

        assertInstanceOf(Rectangle.class, shape);
        assertEquals("Drawing a rectangle", shape.draw());
    }
}
