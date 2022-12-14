package task08102;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Ticket {
    Priority priority() default Priority.MEDIUM;
    String[] tags() default {};
    String createdBy() default "Amigo";

    enum Priority{
        LOW,
        MEDIUM,
        HIGH
    }
}

