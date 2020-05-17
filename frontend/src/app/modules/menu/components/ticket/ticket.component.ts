import {Component, OnInit, TemplateRef} from "@angular/core";

import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {Ticket} from "./ticket";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {TicketService} from "../../../../services/ticket.service";
import {Purchase} from "../../../admin/components/adminPurchase/purchase";
import {PurchaseService} from "../../../../services/purchase.service";

@Component({
  selector: "app-ticket",
  templateUrl: "./ticket.component.html",
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {


  public tickets: Ticket[];
  public purchases: Purchase[];
  private subscriptions: Subscription[] = [];
  public editMode = false;
  public editableBa: Ticket = new Ticket();
  public editableBa1: Purchase = new Purchase();
  public modalRef: BsModalRef;

  ngOnInit() {
    this.loadTicket();
    this.loadPurchase();
  }

  constructor(private ticketService: TicketService,
              private purchaseService: PurchaseService,
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
  public _addTicket(): void {
    this.loadingService.show();
    this.subscriptions.push(this.ticketService.saveTicket(this.editableBa).subscribe(() => {
      this._updateTicket();
      this.refreshBa();
      this._closeModal();
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
  private loadPurchase(): void {
    this.loadingService.show();
    this.subscriptions.push(this.purchaseService.getPurchase().subscribe(purchases => {
      this.purchases = purchases as Purchase[];
      console.log(this.purchases);
      this.loadingService.hide();
    }));
  }


  public _updatePurchase(): void {
    this.loadPurchase();
  }

  public _addPurchase(): void {
    this.loadingService.show();
    this.subscriptions.push(this.purchaseService.savePurchase(this.editableBa1).subscribe(() => {
      this._updatePurchase();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }
}
