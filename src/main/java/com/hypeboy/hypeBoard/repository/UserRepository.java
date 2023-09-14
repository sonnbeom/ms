package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public class UserRepository implements UserRepositorySecond{

    @Autowired
    private UserRepositorySecond userRepositorySecond;

    private EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public User save(User user) {
        User userSaved = userRepositorySecond.save(user);
        return user;
    }
    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepositorySecond.findById(id);
    }


    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }



    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<User> findByPwd(String pwd) {
        return userRepositorySecond.findByPwd(pwd);
    }
    //아이디를 뱉는 메소드
//    @Override
//    public Optional<String> findId(String name, String email){
//        TypedQuery<String>query =entityManager.createQuery("select u from Users u where u.email = :email And u.name = :name", String.class);
//        query.setParameter("name",name); query.setParameter("email", email);
//        List<String> usersId = query.getResultList();
//        if (!usersId.isEmpty()){
//            return Optional.of(usersId.get(0));
//        }else {
//            return Optional.empty();
//        }
//    }
    //user를 뱉는 메소드
//    @Override
//    public Optional<User> findByEmail(String email) {
//        TypedQuery<User> query = entityManager.createQuery("select u from Users u where u.email = :email", User.class)
//                .setParameter("email",email);
//        query.setParameter("email",email);
//        List<User> users = query.getResultList();
//        if (!users.isEmpty()){
//            return Optional.of(users.get(0));
//        } else {
//            return Optional.empty();
//        }
//    }
//    //유저를 뱉는 메소드
//    @Override
//    public Optional<User> findPwd(String id, String phone) {
//        TypedQuery<User> query = entityManager.createQuery("select u from Users u where u.id = :id AND u.phone = :phone", User.class);
//        query.setParameter("id",id);
//        query.setParameter("phone",phone);
//        List<User>users = query.getResultList();
//        if (!users.isEmpty()){
//            return Optional.of(users.get(0));
//        }else {
//            return Optional.empty();
//        }
//    }
//    @Override
//    public Optional<String> findUserPwd(String id, String phone) {
//        TypedQuery<String> query = entityManager.createQuery("select u from Users u where u.id = :id AND u.phone = :phone",String.class);
//        query.setParameter("id",id);
//        query.setParameter("phone",phone);
//        List<String> userPwds = query.getResultList();
//        if (!userPwds.isEmpty()){
//            return Optional.of(userPwds.get(0));
//        }else {
//            return Optional.empty();
//        }
//    }
    //    @Override
//    public Optional<User> findByID(String id) {
//        //  User user = entityManager.find(User.class, id);
//      //  return Optional.ofNullable(user);
//        Optional<User> check = userRepositiory.findByID(id);
//        return check;
//    }
//
//    @Override
//    public Optional<User> findByEmail(String email) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<User> findPwd(String id, String phone) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<String> findId(String name, String email) {
//        return Optional.empty();
//    }

//    @Override
//    public Optional<String> findUserPwd(String id, String phone) {
//        return Optional.empty();
//    }

}