package com.digitalbooking.back.utils;

import com.digitalbooking.back.management.authority.Authority;
import com.digitalbooking.back.management.authority.AuthorityRepository;
import com.digitalbooking.back.management.users.User;
import com.digitalbooking.back.management.users.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class Runner implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    public Runner(AuthorityRepository authorityRepository, UserRepository userRepository) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
    }

    //Si no hay datos en mi base de datos, se ejecuta este método para poblar la base
    @Override
    public void run(String... args) throws Exception {
        log.info("Runner starts");
        log.info("Authorities count: {}", this.authorityRepository.count());
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
            log.info("Authorities created");
        }

        log.info("Users count: {}", this.userRepository.count());
        if (this.userRepository.count() == 0) {
            log.info("Users not found");
            this.userRepository.saveAll(List.of(
                    new User("Florencia", "Lecha", "flecha", "flecha@gmail.com", "1234", List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("Ciro", "Rojas", "ciro", "ciro@gmail.com", "abcde", List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("Manuel", "Godoy", "manumafisto", "manu@gmail.com", "password", List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("Rocky", "xxxx", "dami", "dami@gmail.com", "1234", List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                    new User("Damián", "xxxx", "rocky", "rocky@gmail.com", "1234", List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
                    )
            );
            log.info("Users created");
        }
    }
}
