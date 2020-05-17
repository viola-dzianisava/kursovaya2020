import {Component, OnInit} from "@angular/core";

import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {NewsService} from "../../../../services/news.service";
import {News} from "./news";

@Component({
  selector: "app-news",
  templateUrl: "./news.component.html",
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {


  public newsis: News[];
  private subscriptions: Subscription[] = [];
  ngOnInit() {
    this.loadNews();
  }
  constructor(private newsService: NewsService,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  private loadNews(): void {
    this.loadingService.show();
    this.subscriptions.push(this.newsService.getNews().subscribe(newsis => {
      this.newsis = newsis as News[];
      console.log(this.newsis);
      this.loadingService.hide();
    }));
  }


  public _updateNews(): void {
    this.loadNews();
  }

  public _deleteNews(id_news: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.newsService.deleteNews(id_news).subscribe(() => {
      this._updateNews();
    }));
  }

}
