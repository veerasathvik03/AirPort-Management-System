package com.Veera_Sathvik.AMS.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Veera_Sathvik.AMS.dtos.LoginDTO;
import com.Veera_Sathvik.AMS.dtos.SignUpDTO;
import com.Veera_Sathvik.AMS.entities.Admin;
import com.Veera_Sathvik.AMS.entities.Manager;
import com.Veera_Sathvik.AMS.repositories.AdminRepository;
import com.Veera_Sathvik.AMS.repositories.ManagerRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@SecurityRequirement(name="Authorization")
@Validated
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	//Signing in using Authentication Manager
	@PutMapping("/signin")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDto, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserId(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		SecurityContextRepository securityContextRepository=new HttpSessionSecurityContextRepository();
		securityContextRepository.saveContext(SecurityContextHolder.getContext(), httpServletRequest, httpServletResponse);
		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	}

	//Registering as Admin
	@PostMapping("/signup/admin")
	public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignUpDTO signUpDto, BindingResult br){
		if(br.hasErrors())
			return ResponseEntity.badRequest().body("Validation error: " + br.getFieldError().getDefaultMessage());
		System.out.print(br.hasErrors());

		// add check for username exists in a DB
		if(adminRepository.existsById(signUpDto.getSignUpId())||managerRepository.existsById(signUpDto.getSignUpId())){
			return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		// create Admin object
		Admin admin = new Admin();
		admin.setAge(signUpDto.getAge());
		admin.setContactNumber(signUpDto.getContactNumber());
		admin.setFirstName(signUpDto.getFirstName());
		admin.setLastName(signUpDto.getLastName());
		admin.setGender(signUpDto.getGender());
		admin.setVendorId(signUpDto.getSignUpId());
		admin.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

		Set<String> roles = new HashSet<>();
		roles.add("ROLE_ADMIN");
		admin.setRoles(roles);
		adminRepository.save(admin);

		return new ResponseEntity<>("Admin registered successfully", HttpStatus.OK);

	}

	//Registering as Manager
	@PostMapping("/signup/manager")
	public ResponseEntity<?> registerManager(@Valid @RequestBody SignUpDTO signUpDto, BindingResult br){
		if(br.hasErrors())
			return ResponseEntity.badRequest().body("Validation error: " + br.getFieldError().getDefaultMessage());
		System.out.print(br.hasErrors());

		// add check for username exists in a DB
		if(managerRepository.existsById(signUpDto.getSignUpId())||adminRepository.existsById(signUpDto.getSignUpId())){
			return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		// create Manager object
		Manager manager = new Manager();
		manager.setAge(signUpDto.getAge());
		manager.setContactNumber(signUpDto.getContactNumber());
		manager.setFirstName(signUpDto.getFirstName());
		manager.setLastName(signUpDto.getLastName());
		manager.setGender(signUpDto.getGender());
		manager.setManagerId(signUpDto.getSignUpId());
		manager.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

		Set<String> roles = new HashSet<>();
		roles.add("ROLE_MANAGER");
		manager.setRoles(roles);
		manager.setStatus("Not_Approved");
		managerRepository.save(manager);
		return new ResponseEntity<>("Manager registered successfully", HttpStatus.OK);

	}

	//signing out
	@GetMapping("/signout")
	public ResponseEntity<String> signOutUser(HttpSession session){                            
		SecurityContextHolder.clearContext();                 
		if(session != null)
			session.invalidate();
		return new ResponseEntity<>("User Signed Out successfully!.", HttpStatus.OK);
	}

}


