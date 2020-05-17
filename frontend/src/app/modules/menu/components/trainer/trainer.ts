export class Trainer{
  idTrainer: string;
  name: string;
  photo: string;
  style: string;
  experience: string;

  static cloneBase(trainer: Trainer): Trainer {
    const clonedTrainer: Trainer = new Trainer();
    clonedTrainer.idTrainer = trainer.idTrainer;
    clonedTrainer.name = trainer.name;
    clonedTrainer.photo = trainer.photo;
    clonedTrainer.style = trainer.style;
    clonedTrainer.experience = trainer.experience;
    return clonedTrainer;
  }
}


