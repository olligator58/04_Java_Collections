package task08101;

public @interface Author {
    String value();
    Position position() default Position.OTHER;
}
