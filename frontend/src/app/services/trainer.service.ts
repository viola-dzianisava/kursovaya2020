import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Trainer} from "../modules/menu/components/trainer/trainer";


@Injectable()

export class TrainerService { //todo create interface

  constructor(private http: HttpClient) {
  }


  getTrainer(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>('/api/trainer');
  }

  saveTrainer(trainer: Trainer): Observable<Trainer> {
    return this.http.post<Trainer>('/api/trainer', trainer);
  }

  deleteTrainer(trainerId: string): Observable<void> {
    return this.http.delete<void>('/api/trainer/' + trainerId);
  }

  getTrainerById(trainerId: string): Observable<Trainer> {
    return this.http.get<Trainer>('/api/trainer/' + trainerId);
  }
}
