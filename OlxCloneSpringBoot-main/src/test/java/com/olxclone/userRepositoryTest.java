package com.olxclone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.olxclone.entity.User;
import com.olxclone.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class userRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateuser() {
		User user=new User();
		user.setName("madhan");
		user.setEmail("madhan@gmail.com");
		user.setPassword("mad@2001");
		user.setCity("periyakalapet");
		user.setState("puducherry");
		
		User saveduser = userRepository.save(user);
		
		User existuser = entityManager.find(User.class, saveduser.getId());
		
		assertThat(existuser.getEmail()).isEqualTo(user.getEmail());
		
	}
}
