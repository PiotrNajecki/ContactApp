package pl.piotrnajecki.rm;

import org.springframework.jdbc.core.RowMapper;
import pl.piotrnajecki.domain.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper {
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact c = new Contact();
        c.setContactId(resultSet.getInt("contactId"));
        c.setUserId(resultSet.getInt("userId"));
        c.setName(resultSet.getString("name"));
        c.setEmail(resultSet.getString("email"));
        c.setAddress(resultSet.getString("address"));
        c.setRemark(resultSet.getString("remark"));
        c.setPhone(resultSet.getString("phone"));
        return c;
    }
}


