package com.student.register.common.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { Dob.Validator.class })
public @interface Dob {

    String message() default "Invalid date of birth"; 

	// Class<?>[] groups() default {};

	// Class<? extends Payload>[] payload() default {};

	// String propName();

	// String[] values();

	class Validator implements ConstraintValidator<Dob, String> {
		
		private String message;
		private List<String> allowable;

		@Override
		public void initialize(Dob requiredIfChecked) {
			this.propName = requiredIfChecked.propName();
			this.message = requiredIfChecked.message();
			this.allowable = Arrays.asList(requiredIfChecked.values());
		}

		public boolean isValid(String value, ConstraintValidatorContext context) {
			Boolean valid = this.allowable.contains(value);

			if (!Boolean.TRUE.equals(valid)) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message.concat(this.allowable.toString()))
						.addPropertyNode(this.propName).addConstraintViolation();
			}
			return valid;
		}
	}
    
}
