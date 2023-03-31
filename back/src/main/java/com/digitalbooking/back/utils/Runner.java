package com.digitalbooking.back.utils;

import com.digitalbooking.back.management.authority.Authority;
import com.digitalbooking.back.management.authority.AuthorityRepository;
import com.digitalbooking.back.management.users.User;
import com.digitalbooking.back.management.users.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
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
                    new Authority(AuthorityName.ROLE_ADMIN),
                    new Authority(AuthorityName.ROLE_USER),
                    new Authority(AuthorityName.ROLE_HOST)
            ));
            log.info("Authorities created");
        }

        log.info("Users count: {}", this.userRepository.count());
        if (this.userRepository.count() == 0) {
            //Spring Security 6.0 añade el administrador de contraseñas para codificar las contraseñas de distintos tipos
            var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            log.info("Users not found");
            this.userRepository.saveAll(List.of(
                        new User("Florencia", "Lecha", "flecha", "flecha@gmail.com", encoders.encode("contrasenia1"), List.of(this.authorityRepository.findByName(AuthorityName.ROLE_ADMIN).get())),
                        new User("Ciro", "Rojas", "ciro", "ciro@gmail.com", encoders.encode("contrasenia1"), List.of(this.authorityRepository.findByName(AuthorityName.ROLE_HOST).get())),
                        new User("Manuel", "Godoy", "manu", "manu@gmail.com", encoders.encode("contrasenia1"), List.of(this.authorityRepository.findByName(AuthorityName.ROLE_HOST).get())),
                        new User("Rocky", "xxxx", "dami", "dami@gmail.com", encoders.encode("contrasenia1"), List.of(this.authorityRepository.findByName(AuthorityName.ROLE_USER).get())),
                        new User("Damián", "xxxx", "rocky", "rocky@gmail.com", encoders.encode("contrasenia1"), List.of(this.authorityRepository.findByName(AuthorityName.ROLE_USER).get()))
                    )
            );
            log.info("Users created");
        }
    }
}
