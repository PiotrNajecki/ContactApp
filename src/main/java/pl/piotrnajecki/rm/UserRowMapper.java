package pl.piotrnajecki.rm;

import org.springframework.jdbc.core.RowMapper;
import pl.piotrnajecki.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User u = new User();
        u.setUserId(resultSet.getInt("userId"));
        u.setName(resultSet.getString("name"));
        u.setLoginName(resultSet.getString("login"));
        u.setEmail(resultSet.getString("email"));
        u.setPhone(resultSet.getString("phone"));
        u.setAddress(resultSet.getString("address"));
        u.setRole(resultSet.getInt("role"));
        u.setLoginStatus(resultSet.getInt("loginStatus"));
        return u;
    }
}
