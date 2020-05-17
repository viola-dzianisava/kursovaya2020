import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Purchase} from "../modules/admin/components/adminPurchase/purchase";

@Injectable()

export class PurchaseService { //todo create interface

  constructor(private http: HttpClient) {
  }


  getPurchase(): Observable<Purchase[]> {
    return this.http.get<Purchase[]>('/api/purchase');
  }

  savePurchase(news: Purchase): Observable<Purchase> {
    return this.http.post<Purchase>('/api/purchase', news);
  }

  deletePurchase(purchaseId: string): Observable<void> {
    return this.http.delete<void>('/api/purchase/' + purchaseId);
  }

  getPurchaseById(purchaseId: string): Observable<Purchase> {
    return this.http.get<Purchase>('/api/purchase/' + purchaseId);
  }
}
