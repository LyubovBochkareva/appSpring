package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.UserDao;
import spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


    @Override
    public User updateUser(User user) {
    return userDao.updateUser(user);
    }


    @Transactional
    @Override
    public void deleteUser(Long id) {
    userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
