import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Reviews} from "../modules/menu/components/reviews/reviews";


@Injectable()

export class ReviewsService { //todo create interface

  constructor(private http: HttpClient) {
  }


  getReviews(): Observable<Reviews[]> {
    return this.http.get<Reviews[]>('/api/reviews');
  }

  saveReviews(reviews: Reviews): Observable<Reviews> {
    return this.http.post<Reviews>('/api/reviews', reviews);
  }

  deleteReviews(reviewsId: string): Observable<void> {
    return this.http.delete<void>('/api/reviews/' + reviewsId);
  }

  getReviewsById(reviewsId: string): Observable<Reviews> {
    return this.http.get<Reviews>('/api/reviews/' + reviewsId);
  }
}
