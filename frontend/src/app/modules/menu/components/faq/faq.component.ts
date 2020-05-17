import {Component, OnInit} from "@angular/core";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Faq} from "./faq";
import {FaqService} from "../../../../services/faq.service";

@Component({
  selector: "app-faq",
  templateUrl: "./faq.component.html",
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {

  public faqs: Faq[];
  private subscriptions: Subscription[] = [];

  ngOnInit() {
    this.loadFaq();
  }

  constructor(private faqService: FaqService,
              private loadingService: Ng4LoadingSpinnerService) {
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
}
