package com.skillUp.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillUp.beans.Posts;
import com.skillUp.beans.PostsRepository;
import com.skillUp.exceptions.UserNotFoundException;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostsRepository postsRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/users")
	@Transactional(readOnly = true)
	public List<User> getAllUsers(){
		/*
		 * CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		 * CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		 * //Root<Posts> studentRoot = criteriaQuery.from(Posts.class);
		 * //criteriaQuery.orderBy(criteriaBuilder.desc(studentRoot.get("name")));
		 * List<User> users= entityManager.createQuery(criteriaQuery).getResultList();
		 */
		userRepository.findAll().stream().forEach(user->System.out.println(user.getPosts()));
        return userRepository.findAll(); 
		
	}
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable int id) throws UserNotFoundException{
		Optional<User> user=userRepository.findById(id);
		if(user.isEmpty()) {
		 throw new  UserNotFoundException("USER NOT FOUND FOR ID ="+id);
		}
		return user;
	}
	@PostMapping("/users/save")
	public User saveUser(@RequestBody User user){
		return userRepository.save(user);
	}
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) throws UserNotFoundException{
		if(!userRepository.findById(id).isEmpty()) {
		userRepository.deleteById(id);
		return "Record (ID: "+id+") deleted successfully";
		}else {
			throw new UserNotFoundException("USER NOT FOUND FOR ID = "+id);
		}
	}
	@Transactional(readOnly = true) //each fetch of lazy entity will open an session : Spring.jpa
	@GetMapping("/users/{id}/getPosts")
	public List<Posts> getPosts(@PathVariable int id) throws UserNotFoundException{
		User user=userRepository.getById(id);
		if(!user.getPosts().isEmpty())
		return user.getPosts();
		else
			throw new UserNotFoundException("USER NOT FOUND FOR ID = "+id);
	}
}
