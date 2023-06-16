package com.student.register.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { Dob.Validator.class })
public @interface Dob {

    String message() default "Invalid date of birth"; 

	// Class<?>[] groups() default {};

	// Class<? extends Payload>[] payload() default {};

	// String propName();

	// String[] values();

	class Validator implements ConstraintValidator<Dob, String> {
		
		// private String message;
		// private List<String> allowable;

		@Override
		public void initialize(Dob requiredIfChecked) {
			// this.propName = requiredIfChecked.propName();
			// this.message = requiredIfChecked.message();
			// this.allowable = Arrays.asList(requiredIfChecked.values());
		}
		
		public boolean isValid(String value, ConstraintValidatorContext context) {

			boolean valid;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			try {
				LocalDate dt = LocalDate.parse(value,dtf);
				valid=Boolean.TRUE;
			} catch (Exception e) {
				valid= Boolean.FALSE;
			}

			return valid;
		}
	}
    
}
