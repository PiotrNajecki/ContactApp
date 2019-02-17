package pl.piotrnajecki.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.piotrnajecki.config.SpringRootConfig;

import javax.sql.DataSource;

public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES('Piotr','9999666','piotr.najecki@gmail.com','Najecki','fee','v123')";
//        String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?, ?, ?, ?, ?, ?)";
//        Object[] param = new Object[]{"Piotr", "9999666", "piotr.najecki@gmail.com", "Najecki", "fee", "v123"};
//        jt.update(sql, param);
        jt.update(sql);
        System.out.println("------------SQL executed------------");

    }



}
