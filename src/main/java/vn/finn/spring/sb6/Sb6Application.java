package vn.finn.spring.sb6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sb6Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Sb6Application.class, args);
//        // Lấy ra bean SimpleBean trong Context
//        SimpleBean simpleBean = context.getBean(SimpleBean.class);
//        // In ra màn hình
//        System.out.println("Simple Bean Example: " + simpleBean.toString());

//        DB
        DatabaseConnector mysql = (DatabaseConnector) context.getBean("mySqlConnector");
        mysql.connect();

        DatabaseConnector mongodb = (DatabaseConnector) context.getBean("mongodbConnector");
        mongodb.connect();

        DatabaseConnector postgresql = (DatabaseConnector) context.getBean("postgresqlConnector");
        postgresql.connect();
    }

}
