export class Ticket{
  idTicket: string;
  name: string;
  cost: string;
  visits: string;
  duration: string;

  static cloneBase(ticket: Ticket): Ticket {
    const clonedTicket: Ticket = new Ticket();
    clonedTicket.idTicket = ticket.idTicket;
    clonedTicket.name = ticket.name;
    clonedTicket.cost = ticket.cost;
    clonedTicket.visits = ticket.visits;
    clonedTicket.duration = ticket.duration;
    return clonedTicket;
  }
}


