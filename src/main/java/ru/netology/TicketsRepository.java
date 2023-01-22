package ru.netology;

public class TicketsRepository {
    public Tickets[] tickets = new Tickets[0];

    public void save(Tickets ticket) {
        Tickets[] tmp = new Tickets[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        Tickets[] tmp = new Tickets[tickets.length - 1];
        int index = 0;
        for (Tickets ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public void removeAll() {
        Tickets[] tmp = new Tickets[0];
        tickets = tmp;
    }

    public Tickets[] findById(int id) {
        Tickets[] tmp = new Tickets[1];
        for (Tickets ticket : tickets) {
            if (ticket.getId() == id) {
                tmp[0] = ticket;
            }
        }
        tickets = tmp;
        return tmp;
    }
}
