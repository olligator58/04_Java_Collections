package task08101;

public @interface Revision {
    int revision();
    Date date();
    Author[] authors() default {};
    String comment() default "";
}
