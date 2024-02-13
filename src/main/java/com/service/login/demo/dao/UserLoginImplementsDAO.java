package com.service.login.demo.dao;
import com.service.login.demo.entity.User;
import com.service.login.demo.service.CryptoInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserLoginImplementsDAO implements LoginDAO {

    private EntityManager entityManager;
    private CryptoInfo cryptoInfo;

    @Autowired
    public UserLoginImplementsDAO(EntityManager entityManager, CryptoInfo cryptoInfo) {
        this.entityManager = entityManager;
        this.cryptoInfo = cryptoInfo;
    }

    @Override
    @Transactional
    public void createLogin(User usuario) {
        usuario.setPassword(cryptoInfo.encryptPassword(usuario.getPassword()));
        entityManager.persist(usuario);
    }

    @Override
    public User logar(String userName, String password) {
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User where userName=:userName", User.class);
        theQuery.setParameter("userName", userName);
        System.out.println(userName+' '+password);
        try {
            User user = theQuery.getSingleResult();
            System.out.println(user);

            String encryptedPassword = cryptoInfo.encryptPassword(password);
            if (cryptoInfo.matchesPassword(password, user.getPassword())) {
                return user;
            } else {
                throw new BadCredentialsException("Senha incorreta");
            }
        } catch (NoResultException e) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }

    }




