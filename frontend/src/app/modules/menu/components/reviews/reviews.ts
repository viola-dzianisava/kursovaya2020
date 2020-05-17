export class Reviews{
  idReviews: string;
  name: string;
  review: string;



  static cloneBase(reviews: Reviews): Reviews {
    const clonedReviews: Reviews = new Reviews();
    clonedReviews.idReviews = reviews.idReviews;
    clonedReviews.name = reviews.name;
    clonedReviews.review = reviews.review;
    return clonedReviews;
  }
}


