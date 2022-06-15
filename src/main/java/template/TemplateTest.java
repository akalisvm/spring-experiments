package template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import template.dao.UserDao;
import template.entity.User;
import template.service.UserService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContextTemplate.xml"})
public class TemplateTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();

        System.out.println("connection = " + connection);
    }

    @Test
    public void testJdbcTemplateUpdate() {
        // 1.编写 SQL 语句。需要传参的地方写问号占位符
        String sql = "update user set email=? where user_name=?";

        // 2.调用 jdbcTemplate 的 update() 方法执行 update 语句
        int count = jdbcTemplate.update(sql, "ziqiao1@qq.com", "ziqiao");

        System.out.println("count = " + count);
    }

    @Test
    public void testJdbcTemplateQueryForSingleValue() {

        // 1.编写 SQL 语句
        String sql = "select email from user where user_id=?";

        // 2.调用 jdbcTemplate 的方法执行查询
        String email = jdbcTemplate.queryForObject(sql, String.class, 7);

        System.out.println("email = " + email);

    }

    @Test
    public void testJdbcTemplateQueryForEntity() {

        // 1.编写 SQL 语句
        String sql = "select user_id, user_name, user_pwd, email from user where user_id=?";

        // 2.准备 RowMapper 对象
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

        // 3.调用 jdbcTemplate 的方法执行查询
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 7);

        System.out.println("user = " + user);

    }

}
