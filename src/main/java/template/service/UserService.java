package template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.dao.UserDao;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    // 为了便于核对数据库操作结果，不要修改同一条记录
    public void updateTwice(int userIdForEditName, String newName, int userIdForEditEmail, String newEmail) {

        // 为了测试事务是否生效，执行两个数据库操作，看它们是否会在某一个失败时一起回滚


        userDao.updateUserEmailById(userIdForEditEmail, newEmail);

    }
}
