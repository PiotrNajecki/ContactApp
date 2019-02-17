package pl.piotrnajecki.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.piotrnajecki.domain.User;
import pl.piotrnajecki.rm.UserRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {
    public void save(User u) {
        String sql="INSERT INTO user(name, phone, email, address, loginName, password)"+
                " VALUES(:name, :phone, :email, :address, :loginName, :password)";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("loginName", u.getLoginName());
        m.put("password", u.getPassword());
        m.put("loginStatus", u.getLoginStatus());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);  // from where values for theres paremeteres whiil be taken
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserId(userId);
    }

    public void update(User u) {
        String sql = "UPDATE user SET name=:name, phone=:phone, email:=email, address=:address, role=:role, loginStatus=:loginStatus"+
                "WHERE userId=:userId";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("role", u.getRole());
        m.put("password", u.getPassword());
        m.put("loginStatus", u.getLoginStatus());
        m.put("userId", u.getUserId());
        getNamedParameterJdbcTemplate().update(sql, m);

    }

    public void delete(Integer userId) {
        String sql="DELETE FROM user WHERE userId=?";
        getJdbcTemplate().update(sql, userId);

    }

   public void delete(User u) {
        this.delete(u.getUserId());
   }

    public User findById(Integer userId) {
        String sql = "SELECT userid, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE userId=?";
        User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper());
        return u;

    }

    public List<User> findAll() {
        return null;
    }

    public List<User> findByProperty(String propName, Object propValue) {
        return null;
    }
}
