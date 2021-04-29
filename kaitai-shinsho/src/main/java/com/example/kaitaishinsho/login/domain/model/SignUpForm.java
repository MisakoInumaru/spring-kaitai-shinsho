package com.example.kaitaishinsho.login.domain.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignUpForm {

	@NotBlank
	@Email
	private String userId;

	@NotNull
	@Length(min = 4, max = 100)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;

	@NotBlank
	private String userName;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;

	@Min(20)
	@Max(100)
	private int age;

	@AssertFalse
	private boolean marriage;

}
