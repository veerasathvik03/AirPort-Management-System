package com.Veera_Sathvik.AMS.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//SignUp Data Transfer Object
public class SignUpDTO {

	@NotBlank(message = "Username canot be null")
	private String signUpId;

	@NotBlank(message = "First name cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{2,}$", message = "Invalid first name format")
	private String firstName;

	@NotBlank(message = "Last name cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{2,}$", message = "Invalid last name format")
	private String lastName;

	@NotNull(message = "Age canot be null")
	@Min(value = 18, message = "Age must be above 18")
	@Max(value = 60, message = "Age must be below 60")
	private int age;

	@NotBlank(message = "Gender canot be null")
	@Pattern(regexp ="^(Male|Female|Other)$", message = "Invalid Gender")
	private String gender;

	@NotBlank(message = "Contact canot be null")
	@Pattern(regexp = "^[0-9]{10}$", message = "Contact must be 10 digits only")
	private String contactNumber;

	@NotBlank(message = "Password canot be null")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$", message = "Pattern of the password is invalid")
	private String password;

	public SignUpDTO(String signUpId, String firstName, String lastName, int age, String gender, String contactNumber,
			String password) {
		super();
		this.signUpId = signUpId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.password = password;
	}

	public String getSignUpId() {
		return signUpId;
	}

	public void setSignUpId(String signUpId) {
		this.signUpId = signUpId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUpDTO [signUpId=" + signUpId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}
}






