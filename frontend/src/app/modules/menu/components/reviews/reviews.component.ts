import {Component, OnInit, TemplateRef} from "@angular/core";

import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {Reviews} from "./reviews";
import {ReviewsService} from "../../../../services/reviews.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: "app-reviews",
  templateUrl: "./reviews.component.html",
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {


  public reviewsis: Reviews[];
  private subscriptions: Subscription[] = [];
  public editMode = false;
  public editableBa: Reviews = new Reviews();
  public modalRef: BsModalRef;

  ngOnInit() {
    this.loadReviews();
  }

  constructor(private reviewsService: ReviewsService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {
  }

  private loadReviews(): void {
    this.loadingService.show();
    this.subscriptions.push(this.reviewsService.getReviews().subscribe(reviewsis => {
      this.reviewsis = reviewsis as Reviews[];
      console.log(this.reviewsis);
      this.loadingService.hide();
    }));
  }
  public _addReviews(): void {
    this.loadingService.show();
    this.subscriptions.push(this.reviewsService.saveReviews(this.editableBa).subscribe(() => {
      this._updateReviews();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateReviews(): void {
    this.loadReviews();
  }

  public _deleteReviews(id_reviews: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.reviewsService.deleteReviews(id_reviews).subscribe(() => {
      this._updateReviews();
    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, reviews: Reviews): void {

    if (reviews) {
      this.editMode = true;
      this.editableBa = Reviews.cloneBase(reviews);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  private refreshBa(): void {
    this.editableBa = new Reviews();
  }
}
