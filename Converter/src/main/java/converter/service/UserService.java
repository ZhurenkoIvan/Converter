//package converter.service;
//
//import converter.dao.RoleRepository;
//import converter.dao.UserRepository;
//import converter.entity.Role;
//import converter.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.Collections;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return user;
//    }
//
////    public boolean saveUser(User user, Role role) {
////        User userFromDB = userRepository.findByUsername(user.getUsername());
////        if (userFromDB != null) {
////            return false;
////        }
////
////        user.setRoles(Collections.singleton(role));
////        user.setPassword("{bcrypt}"+user.getPassword());
////        userRepository.save(user);
////        return true;
////    }
//
//    public boolean saveUser(User user) {
//        User userFromDB = userRepository.findByUsername(user.getUsername());
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword("{bcrypt}"+user.getPassword());
//        userRepository.save(user);
//        return true;
//    }
//}
