package com.gbedido.gbedido.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbedido.gbedido.domain.User;
import com.gbedido.gbedido.repository.UserRepository;


@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody final User user)
	{
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return ResponseEntity.ok().body(userRepository.save(user));
	}
	
	@GetMapping
	public ResponseEntity<Page<User>> findAllUsers(@PageableDefault(size=10)Pageable pageable)
	{
		return ResponseEntity.ok().body(userRepository.findAll(pageable));
	}
	
	@GetMapping("/search-by-firstname")
	public ResponseEntity <Page<User>>searchUser(String nom, @PageableDefault(size=10)Pageable pageable)
	{
		Page<User> page=userRepository.findByNomContaining(nom, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id)
	{
		return userRepository.findById(id).get();
	}
	
	@PostMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody final User user)
	{
		user.setId(id);
		return userRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable Long id)
	{
		userRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}
}
