package task0782;

import task0782.decorators.RedShapeDecorator;
import task0782.shapes.Circle;
import task0782.shapes.Rectangle;
import task0782.shapes.Shape;

/* 
Decorator
*/

public class Solution {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}
