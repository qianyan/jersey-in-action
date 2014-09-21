package com.thoughtworks.repository;

import com.thoughtworks.domain.Person;

import java.sql.*;
import java.util.ArrayList;

public class AbstractRepository {
    private static Connection connection;
    static {
        try {
            String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
            String username = "sa";
            connection = DriverManager.getConnection(url, username, "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AbstractRepository() throws SQLException {
        connection.setAutoCommit(false);
        final Statement statement = connection.createStatement();
        final String createSchema = "create table person (id int primary key, name varchar(15));" +
                "insert into person values(1, 'carl');" +
                "insert into person values(2, 'kyle');";
        statement.addBatch(createSchema);
        statement.executeBatch();
        connection.commit();
    }

    public Person query(int id) {
        try {
            final PreparedStatement ps = connection.prepareStatement("select * from person where id = ?");
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            final ArrayList<Person> people = new ArrayList<>();
            while (rs.next()) {
                final Person person = new Person(rs.getString("name"));
                people.add(person);
            }
            rs.close();
            ps.close();
            return people.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
