package jwtauth.service;

import io.micronaut.transaction.annotation.ReadOnly;
import jwtauth.model.Login;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Singleton
public class LoginInterfaceImp implements LoginInterface {

    private final EntityManager entityManager;

    public LoginInterfaceImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public String save(String username, String password) {
        Login login =entityManager.find(Login.class ,username);
        Login lg = new Login(username,password);
        entityManager.persist(lg);
        return "added succesfully" ;
    }


    @Override
    @ReadOnly
    public Login getLogin(String username) {
        return entityManager.find(Login.class ,username);
    }

}
