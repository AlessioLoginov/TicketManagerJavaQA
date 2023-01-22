package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketsManagerTest {

    Tickets ticket1 = new Tickets(1, 1000, "Moscow", "Milan", 180);
    Tickets ticket2 = new Tickets(2, 1600, "Moscow", "Milan", 180);
    Tickets ticket3 = new Tickets(3, 2500, "Moscow", "Milan", 180);
    Tickets ticket4 = new Tickets(4, 3000, "Moscow", "Milan", 180);
    Tickets ticket5 = new Tickets(5, 370, "Moscow", "Milan", 180);
    Tickets ticket6 = new Tickets(6, 4000, "Milan", "Moscow", 180);
    Tickets ticket7 = new Tickets(7, 4500, "Milan", "Moscow", 180);
    Tickets ticket8 = new Tickets(8, 2000, "Milan", "Moscow", 180);

    @Test
    public void findAllTest() {
        TicketsRepository repository = new TicketsRepository();
        TicketsManager manager = new TicketsManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Tickets[] expected = {ticket5, ticket1, ticket2, ticket3, ticket4};
        Tickets[] actual = manager.findAll("Moscow", "Milan");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        TicketsRepository repository = new TicketsRepository();
        TicketsManager manager = new TicketsManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.removeAll();
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.removeById(4);

        Tickets[] actual = manager.findAll("Moscow", "Milan");
        Tickets[] expected = { ticket5, ticket3 };

        assertArrayEquals(expected, actual);
    }

    @Test
    public void nullTest() {
        TicketsRepository repository = new TicketsRepository();
        TicketsManager manager = new TicketsManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Tickets[] actual = manager.findAll("Paris", "Kazan");
        Tickets[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findTest() {
        TicketsRepository repository = new TicketsRepository();
        TicketsManager manager = new TicketsManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.findById(8);

        Tickets[] actual = manager.findAll("Milan", "Moscow");
        Tickets[] expected = { ticket8 };

        assertArrayEquals(expected, actual);
    }

}
