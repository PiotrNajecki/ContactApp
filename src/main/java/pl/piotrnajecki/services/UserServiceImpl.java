package pl.piotrnajecki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.piotrnajecki.dao.BaseDAO;
import pl.piotrnajecki.dao.UserDAO;
import pl.piotrnajecki.domain.User;
import pl.piotrnajecki.exception.UserBlockedException;
import pl.piotrnajecki.rm.UserRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void register(User u) {
        userDAO.save(u);
    }

    public User login(String loginName, String password) throws UserBlockedException {
        String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName"+
                " FROM user WHERE loginName=:ln AND password=:pw";
        Map m = new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);
        try {
        User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
        if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
            throw new UserBlockedException("Your account has been blocked. Contact Admin in this case.");
        }
        return u;
        } catch (EmptyResultDataAccessException ex0) {
            return null;
        }

    }

    public List<User> getUserList() {
        return null;
    }

    public void changeLoginStatus(Integer userId, Integer loginStatus) {

    }
}
