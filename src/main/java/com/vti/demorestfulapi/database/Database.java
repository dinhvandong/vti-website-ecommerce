package com.vti.demorestfulapi.database;


import com.vti.demorestfulapi.model.ERole;
import com.vti.demorestfulapi.model.Role;
import com.vti.demorestfulapi.model.User;
import com.vti.demorestfulapi.repository.RoleRepository;
import com.vti.demorestfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class Database {
    @Autowired
    PasswordEncoder encoder;



    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepository, UserRepository userRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                if(roleRepository.findAll().size()==0){
                    Role role1 = new Role();
                    role1.setId(1);
                    role1.setName(ERole.ROLE_ADMIN);
                    roleRepository.save(role1);

                    Role role2 = new Role();
                    role2.setId(2);
                    role2.setName(ERole.ROLE_MANAGER);
                    roleRepository.save(role2);

                    Role role3 = new Role();
                    role3.setId(3);
                    role3.setName(ERole.ROLE_SALE);
                    roleRepository.save(role3);

                    Role role4 = new Role();
                    role4.setId(4);
                    role4.setName(ERole.ROLE_STAFF);
                    roleRepository.save(role4);

                }
                if(userRepository.findAll().size()==0){
                    User admin = new User();
                    admin.setId(1l);
                    admin.setEmail("super_admin@fpt.edu.vn");
                    admin.setUsername("super_admin");
                    Set<Role> roles = new HashSet<>();
                    admin.setPassword(encoder.encode("Abcd1234@#"));
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                    admin.setRoles(roles);
                    userRepository.save(admin);
                }
            }
        };
    }
}
