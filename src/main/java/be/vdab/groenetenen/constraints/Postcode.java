package be.vdab.groenetenen.constraints;

import org.hibernate.validator.constraints.Range;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PostCodeValidator.class)
public @interface Postcode {
    @OverridesAttribute(constraint = Range.class, name = "message")
    String message() default  "{be.vdab.groenetenen.constraints.Postcode.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
