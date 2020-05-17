import {Component, OnInit, TemplateRef} from "@angular/core";

import {Subscription} from "rxjs";
import {NewsService} from "../../../../services/news.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {News} from "../../../menu/components/news/news";
import {Faq} from "../../../menu/components/faq/faq";
import {FaqService} from "../../../../services/faq.service";


@Component({
  selector: "app-adminFaq",
  templateUrl: "./adminFaq.component.html",
  styleUrls: ['./adminFaq.component.css']
})
export class AdminFaqComponent implements OnInit {
  public faqs: Faq[];
  private subscriptions: Subscription[] = [];
  public editMode = false;
  public editableBa: Faq = new Faq();
  public modalRef: BsModalRef;

  ngOnInit() {
    this.loadFaq();
  }

  constructor(private faqService: FaqService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {
  }

  private loadFaq(): void {
    this.loadingService.show();
    this.subscriptions.push(this.faqService.getFaq().subscribe(faqs => {
      this.faqs = faqs as Faq[];
      console.log(this.faqs);
      this.loadingService.hide();
    }));
  }


  public _updateFaq(): void {
    this.loadFaq();
  }

  public _deleteFaq(id_faq: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.faqService.deleteFaq(id_faq).subscribe(() => {
      this._updateFaq();
    }));
  }
  public _addFaq(): void {
    this.loadingService.show();
    this.subscriptions.push(this.faqService.saveFaq(this.editableBa).subscribe(() => {
      this._updateFaq();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, faq: Faq): void {

    if (faq) {
      this.editMode = true;
      this.editableBa = Faq.cloneBase(faq);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  private refreshBa(): void {
    this.editableBa = new Faq();
  }
}
