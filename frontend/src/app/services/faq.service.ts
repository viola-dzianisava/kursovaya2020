import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Faq} from "../modules/menu/components/faq/faq";


@Injectable()

export class FaqService { //todo create interface

  constructor(private http: HttpClient) {
  }


  getFaq(): Observable<Faq[]> {
    return this.http.get<Faq[]>('/api/faq');
  }

  saveFaq(faq: Faq): Observable<Faq> {
    return this.http.post<Faq>('/api/faq', faq);
  }

  deleteFaq(faqId: string): Observable<void> {
    return this.http.delete<void>('/api/faq/' + faqId);
  }

  getFaqById(faqId: string): Observable<Faq> {
    return this.http.get<Faq>('/api/faq/' + faqId);
  }
}
