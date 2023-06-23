package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	
@RequestMapping(path="/demo") 
public class MainController {
	@Autowired 
	private UserRepository userRepository;

	@PostMapping(path="/user")
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@DeleteMapping(path="/user")
	public @ResponseBody String deleteUser (@RequestParam Integer id) {
		User n = new User();
		n.setId(id);
		userRepository.delete(n);
		return "deleted";
	}

	@PutMapping(path="/user")
	public @ResponseBody String updateUser (@RequestParam Integer id, @RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setId(id);
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "updated";
	}
}
