package ru.netology;

import java.util.Arrays;

public class TicketsManager {

    private TicketsRepository repository;

    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public void add(Tickets ticket) {
        repository.save(ticket);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public Tickets[] findAll(String fromAirport, String toAirport) {
        Tickets[] ans = new Tickets[0];
        for (Tickets ticket : repository.tickets) {
            if (ticket.getArrAirport().equals(toAirport) && ticket.getDepAirport().equals(fromAirport))  {
                Tickets[] tmp = new Tickets[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
