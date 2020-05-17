import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "../modules/menu/components/ticket/ticket";


@Injectable()

export class TicketService { //todo create interface

  constructor(private http: HttpClient) {
  }


  getTicket(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>('/api/ticket');
  }

  saveTicket(ticket: Ticket): Observable<Ticket> {
    return this.http.post<Ticket>('/api/ticket', ticket);
  }

  deleteTicket(ticketId: string): Observable<void> {
    return this.http.delete<void>('/api/ticket/' + ticketId);
  }

  getTicketById(ticketId: string): Observable<Ticket> {
    return this.http.get<Ticket>('/api/ticket/' + ticketId);
  }
}
