package template.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateUserNameById(int userId, String userName) {
        String sql = "update user set user_name=? where user_id=?";
        jdbcTemplate.update(sql, userName, userId);
    }

    public void updateUserEmailById(int userId, String email) {
        String sql = "update user set email=? where user_id=?";
        jdbcTemplate.update(sql, email, userId);
    }

    public String selectUserNameById(int userId) {
        String sql = "select user_name from user where user_id=?";
        return jdbcTemplate.queryForObject(sql, String.class, userId);
    }
}
