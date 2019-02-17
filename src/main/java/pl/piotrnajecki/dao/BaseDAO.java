package pl.piotrnajecki.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import javax.sql.DataSource;


//NOTE: do not use @Repository or @Service or @Component annotation
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource ds) {
        super.setDataSource(ds);
    }

}
