package com.tiagomaniero.produtorest;

import com.tiagomaniero.produtorest.auth.model.Role;
import com.tiagomaniero.produtorest.auth.model.User;
import com.tiagomaniero.produtorest.auth.service.RoleService;
import com.tiagomaniero.produtorest.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class Initializer {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void criaUsuarioPermissoes(){
        Role roleAdmin = new Role();

        roleAdmin.setName("ADMIN");

        roleService.save(roleAdmin);

        User user = new User();
        user.setAtivo(true);
        user.setEmail("teste@teste.com");
        user.setNome("tiago");
        user.setSenha(new BCryptPasswordEncoder().encode("123456"));
        user.setUsername("tiago");
        user.setRoles(Arrays.asList(roleAdmin));

        userService.save(user);
    }
}
