package ru.job4j.tracker.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class
                .getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSuccessfulReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item newItem = new Item("ITEM");
        tracker.add(item);
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName(), is(newItem.getName()));
    }

    @Test
    public void whenFailedReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item newItem = new Item("ITEM");
        tracker.add(item);
        tracker.replace(item.getId() + 1, newItem);
        assertThat(tracker.findById(item.getId()).getName(), is(item.getName()));
    }

    @Test
    public void whenSuccessfulDeletion() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFailedDeletion() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(-1);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindAListOfAllTheItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("A");
        Item itemB = new Item("B");
        Item itemC = new Item("C");
        tracker.add(itemA);
        tracker.add(itemB);
        tracker.add(itemC);
        assertThat(tracker.findAll(), is(Arrays.asList(itemA, itemB, itemC)));
    }

    @Test
    public void whenFindAListOfAllTheItemsButNoItems() {
        SqlTracker tracker = new SqlTracker(connection);
        assertThat(tracker.findAll(), is(Collections.emptyList()));
    }

    @Test
    public void whenFindItemsByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("ABC");
        Item itemB = new Item("DEF");
        Item itemC = new Item("QAZ");
        tracker.add(itemA);
        tracker.add(itemB);
        tracker.add(itemC);
        assertThat(tracker.findByName("A"), is(Arrays.asList(itemA, itemC)));
    }

    @Test
    public void whenFindItemsByNameButNoItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("ABC");
        Item itemB = new Item("DEF");
        Item itemC = new Item("QAZ");
        tracker.add(itemA);
        tracker.add(itemB);
        tracker.add(itemC);
        assertThat(tracker.findByName("T"), is(Collections.emptyList()));
    }

    @Test
    public void whenFindItemsById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("ABC");
        Item itemB = new Item("DEF");
        Item itemC = new Item("QAZ");
        tracker.add(itemA);
        tracker.add(itemB);
        tracker.add(itemC);
        assertThat(tracker.findById(itemB.getId()), is(itemB));
    }

    @Test
    public void whenFindItemsByIdButNoItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("ABC");
        Item itemB = new Item("DEF");
        Item itemC = new Item("QAZ");
        tracker.add(itemA);
        tracker.add(itemB);
        tracker.add(itemC);
        assertThat(tracker.findById(-1), is(nullValue()));
    }
}
