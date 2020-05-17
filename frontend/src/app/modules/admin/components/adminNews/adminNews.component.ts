import {Component, OnInit, TemplateRef} from "@angular/core";

import {Subscription} from "rxjs";
import {NewsService} from "../../../../services/news.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {News} from "../../../menu/components/news/news";


@Component({
  selector: "app-adminNews",
  templateUrl: "./adminNews.component.html",
  styleUrls: ['./adminNews.component.css']
})
export class AdminNewsComponent implements OnInit {
  public newsis: News[];
  private subscriptions: Subscription[] = [];
  public editMode = false;
  public editableBa: News = new News();
  public modalRef: BsModalRef;

  ngOnInit() {
    this.loadNews();
  }

  constructor(private newsService: NewsService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {
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
  public _addNews(): void {
    this.loadingService.show();
    this.subscriptions.push(this.newsService.saveNews(this.editableBa).subscribe(() => {
      this._updateNews();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, news: News): void {

    if (news) {
      this.editMode = true;
      this.editableBa = News.cloneBase(news);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  private refreshBa(): void {
    this.editableBa = new News();
  }
}
