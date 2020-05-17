import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {BsDropdownModule} from "ngx-bootstrap/dropdown";
import {TooltipModule} from "ngx-bootstrap/tooltip";
import {ModalModule} from "ngx-bootstrap/modal";
import {FormsModule} from "@angular/forms";

import {AppComponent} from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {RouterModule, Routes} from "@angular/router";

import {MainComponent} from "./modules/menu/components/main/main.component";
import {HeaderComponent} from "./modules/header/header.component";
import {FooterComponent} from "./modules/footer/footer.component";
import {FaqComponent} from "./modules/menu/components/faq/faq.component";
import {NewsService} from "./services/news.service";
import {ErrorComponent} from "./modules/layout/404/error.component";
import {ContactsComponent} from "./modules/menu/components/contacts/contacts.component";
import {AdminNewsComponent} from "./modules/admin/components/adminNews/adminNews.component";
import {NewsComponent} from "./modules/menu/components/news/news.component";
import {FaqService} from "./services/faq.service";
import {AdminFaqComponent} from "./modules/admin/components/adminFaq/adminFaq.component";
import {ReviewsService} from "./services/reviews.service";
import {ReviewsComponent} from "./modules/menu/components/reviews/reviews.component";
import {GalleryComponent} from "./modules/menu/components/gallery/gallery.component";
import {TicketService} from "./services/ticket.service";
import {TicketComponent} from "./modules/menu/components/ticket/ticket.component";
import {AdminTicketComponent} from "./modules/admin/components/adminTicket/adminTicket.component";
import {TrainerComponent} from "./modules/menu/components/trainer/trainer.component";
import {TrainerService} from "./services/trainer.service";
import {AdminTrainerComponent} from "./modules/admin/components/adminTrainer/adminTrainer.component";
import {AdminPurchaseComponent} from "./modules/admin/components/adminPurchase/adminPurchase.component";
import {PurchaseService} from "./services/purchase.service";
import {AdminMenuComponent} from "./modules/admin/components/adminMenu/adminMenu.component";



const appRoutes: Routes = [
  {path: 'admin-news', component: AdminNewsComponent},
  {path: 'admin-faq', component: AdminFaqComponent},
  {path: 'admin-ticket', component: AdminTicketComponent},
  {path: 'admin-trainer', component: AdminTrainerComponent},
  {path: 'admin-purchase', component: AdminPurchaseComponent},
  {path: 'adminMenu4815162342', component: AdminMenuComponent},




  {path: 'news', component: NewsComponent},
  {path: '', component: MainComponent},
  {path: 'contacts', component: ContactsComponent},
  {path: 'answers', component: FaqComponent},
  {path: 'reviews', component: ReviewsComponent},
  {path: 'gallery', component: GalleryComponent},
  {path: 'cost', component: TicketComponent},
  {path: 'trainer', component: TrainerComponent},


  {path: '**', component: ErrorComponent},

];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    FooterComponent,
    FaqComponent,
    ErrorComponent,
    ContactsComponent,
    NewsComponent,
    ReviewsComponent,
    GalleryComponent,
    TicketComponent,
    TrainerComponent,



    AdminFaqComponent ,
    AdminNewsComponent,
    AdminTicketComponent,
    AdminTrainerComponent,
    AdminPurchaseComponent,
    AdminMenuComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [NewsService, FaqService, ReviewsService, TicketService, TrainerService, PurchaseService,],
  bootstrap: [AppComponent],
  exports: []
})
export class AppModule {
}
