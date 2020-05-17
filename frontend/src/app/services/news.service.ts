import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {News} from "../modules/menu/components/news/news";


@Injectable()

export class NewsService { //todo create interface

  constructor(private http: HttpClient) {
  }


  getNews(): Observable<News[]> {
    return this.http.get<News[]>('/api/news');
  }

  saveNews(news: News): Observable<News> {
    return this.http.post<News>('/api/news', news);
  }

  deleteNews(newsId: string): Observable<void> {
    return this.http.delete<void>('/api/news/' + newsId);
  }

  getNewsById(newsId: string): Observable<News> {
    return this.http.get<News>('/api/news/' + newsId);
  }
}
