package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Override
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
}
