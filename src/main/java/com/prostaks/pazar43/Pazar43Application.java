package com.prostaks.pazar43;
import com.prostaks.pazar43.models.User;
import com.prostaks.pazar43.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Pazar43Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Pazar43Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.id = 1;
        user.email = "asd@gmail.com";
        user.userName = "Panda";
        user.password = passwordEncoder.encode("test12345");
        user.verified = true;
        userRepository.save(user);
    }
}
