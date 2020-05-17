import {Component, OnInit, TemplateRef} from "@angular/core";

import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ticket} from "../../../menu/components/ticket/ticket";
import {TicketService} from "../../../../services/ticket.service";


@Component({
  selector: "app-adminTicket",
  templateUrl: "./adminTicket.component.html",
  styleUrls: ['./adminTicket.component.css']
})
export class AdminTicketComponent implements OnInit {
  public tickets: Ticket[];
  private subscriptions: Subscription[] = [];
  public editMode = false;
  public editableBa: Ticket = new Ticket();
  public modalRef: BsModalRef;

  ngOnInit() {
    this.loadTicket();
  }

  constructor(private ticketService: TicketService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {
  }

  private loadTicket(): void {
    this.loadingService.show();
    this.subscriptions.push(this.ticketService.getTicket().subscribe(tickets => {
      this.tickets = tickets as Ticket[];
      console.log(this.tickets);
      this.loadingService.hide();
    }));
  }


  public _updateTicket(): void {
    this.loadTicket();
  }

  public _deleteTicket(id_ticket: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.ticketService.deleteTicket(id_ticket).subscribe(() => {
      this._updateTicket();
    }));
  }
  public _addTicket(): void {
    this.loadingService.show();
    this.subscriptions.push(this.ticketService.saveTicket(this.editableBa).subscribe(() => {
      this._updateTicket();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, ticket: Ticket): void {

    if (ticket) {
      this.editMode = true;
      this.editableBa = Ticket.cloneBase(ticket);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  private refreshBa(): void {
    this.editableBa = new Ticket();
  }
}
