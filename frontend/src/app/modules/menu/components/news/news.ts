export class News{
  idNews: string;
  date: string;
  title: string;
  text: string;
  img: string;


  static cloneBase(news: News): News {
    const clonedNews: News = new News();
    clonedNews.idNews = news.idNews;
    clonedNews.date = news.date;
    clonedNews.title = news.title;
    clonedNews.text = news.text;
    clonedNews.img = news.img;
    return clonedNews;
  }
}


