import {Component, OnInit, TemplateRef} from "@angular/core";

import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Purchase} from "./purchase";
import {PurchaseService} from "../../../../services/purchase.service";
import {TicketService} from "../../../../services/ticket.service";
import {Ticket} from "../../../menu/components/ticket/ticket";


@Component({
  selector: "app-adminPurchase",
  templateUrl: "./adminPurchase.component.html",
  styleUrls: ['./adminPurchase.component.css']
})
export class AdminPurchaseComponent implements OnInit {
  public purchases: Purchase[];
  public tickets: Ticket[];
  private subscriptions: Subscription[] = [];
  public editMode = false;
  public editableBa: Purchase = new Purchase();
  public modalRef: BsModalRef;

  ngOnInit() {
    this.loadPurchase();
    this.loadTicket();

  }

  constructor(private purchaseService: PurchaseService,
              private ticketService: TicketService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {
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

  public _deletePurchase(id_purchase: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.purchaseService.deletePurchase(id_purchase).subscribe(() => {
      this._updatePurchase();
    }));
  }

  public _addPurchase(): void {
    this.loadingService.show();
    this.subscriptions.push(this.purchaseService.savePurchase(this.editableBa).subscribe(() => {
      this._updatePurchase();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }


  public _openModal(template: TemplateRef<any>, purchase: Purchase): void {

    if (purchase) {
      this.editMode = true;
      this.editableBa = Purchase.cloneBase(purchase);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  private refreshBa(): void {
    this.editableBa = new Purchase();
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

  public _closeModal(): void {
    this.modalRef.hide();
  }

}
