import {Component, OnInit, TemplateRef} from "@angular/core";

import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {Trainer} from "./trainer";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {TrainerService} from "../../../../services/trainer.service";

@Component({
  selector: "app-trainer",
  templateUrl: "./trainer.component.html",
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {


  public trainers: Trainer[];
  private subscriptions: Subscription[] = [];
  public editMode = false;
  public editableBa: Trainer = new Trainer();
  public modalRef: BsModalRef;

  ngOnInit() {
    this.loadTrainer();
  }

  constructor(private trainerService: TrainerService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {
  }

  private loadTrainer(): void {
    this.loadingService.show();
    this.subscriptions.push(this.trainerService.getTrainer().subscribe(trainers => {
      this.trainers = trainers as Trainer[];
      console.log(this.trainers);
      this.loadingService.hide();
    }));
  }

  public _addTrainer(): void {
    this.loadingService.show();
    this.subscriptions.push(this.trainerService.saveTrainer(this.editableBa).subscribe(() => {
      this._updateTrainer();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateTrainer(): void {
    this.loadTrainer();
  }

  public _deleteTrainer(id_trainer: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.trainerService.deleteTrainer(id_trainer).subscribe(() => {
      this._updateTrainer();
    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, trainer: Trainer): void {

    if (trainer) {
      this.editMode = true;
      this.editableBa = Trainer.cloneBase(trainer);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  private refreshBa(): void {
    this.editableBa = new Trainer();
  }
}
