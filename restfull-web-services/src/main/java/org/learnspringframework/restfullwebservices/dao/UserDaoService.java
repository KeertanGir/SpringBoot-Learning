//package org.learnspringframework.restfullwebservices.dao;
//
//import org.learnspringframework.restfullwebservices.data.UserJpa;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//
//// This is not now Work able We change the Inmemory to DB
////@Component  
//public class UserDaoService {
//
////    JPA/Hibernate > Database
////    we now Use Static List
//
//    private static List<UserJpa> users = new ArrayList<>();
//
//    private static Long countId = 0l;
//
//    static {
//        users.add(new UserJpa(++countId,"Eve", LocalDate.now().minusYears(18)));
//        users.add(new UserJpa(++countId,"Ali", LocalDate.now().minusYears(30)));
//        users.add(new UserJpa(++countId,"Rag", LocalDate.now().minusYears(13)));
//        users.add(new UserJpa(++countId,"John", LocalDate.now().minusYears(25)));
//    }
//
//
////    public list<users> findAll()
//    public List<UserJpa> findAll(){
//        return users;
//    }
//
////    public saveUser(User user)
//
////    public User findOne(int id)
//    public UserJpa findOne(int id){
//
////        My try
////        for(User u : users){
////            if(u.getId() == id){
////                return u;
////            }
////        }
////        return new User(0, "Not Found", LocalDate.MIN);
//
//        Predicate<? super UserJpa> predicate = user -> user.getId() == id;
//        return users.stream().filter(predicate).findFirst().orElse(null);
//    }
//
//    public UserJpa save(UserJpa user){
//        user.setId(++countId);
//        users.add(user);
//        return user;
//    }
//
//
//    public void deleteUser(int id) {
//        users.removeIf(user -> user.getId().equals(id));
//    }
//}
