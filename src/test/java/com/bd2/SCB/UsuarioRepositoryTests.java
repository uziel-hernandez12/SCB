/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB;

import com.bd2.SCB.domain.Usuario;
import com.bd2.SCB.repository.UsuarioRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository repo;
/*
    // test methods go below
    @Test
    public void testCreateUser() {
        Usuario user = new Usuario();
        user.setLogin("root");
        user.setPassword("ravi2020");
        user.setEmail("ravikumar@gmail.com");
        user.setNombre("Ravi");
        user.setApellido("Kumar");

        Usuario savedUser = repo.save(user);

        Usuario existUser = entityManager.find(Usuario.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }*/
}
