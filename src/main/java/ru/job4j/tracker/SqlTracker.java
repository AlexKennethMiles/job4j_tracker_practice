package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items(name, created) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name=?, created=? where id=?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id=?")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (Statement statement =
                     cn.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from items");
            while (rs.next()) {
                rsl.add(getItemFromResultSet(rs));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where name=?")) {
            statement.setString(1, key);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    rsl.add(getItemFromResultSet(rs));
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where id=?")) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    item = getItemFromResultSet(rs);
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return item;
    }

    public Item getItemFromResultSet(ResultSet rs) {
        Item item = null;
        try {
            item = new Item(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getTimestamp("created").toLocalDateTime()
            );
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return item;
    }
}