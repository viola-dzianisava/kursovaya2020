export class Faq{
  idFaq: string;
  question: string;
  answer: string;



  static cloneBase(faq: Faq): Faq {
    const clonedNews: Faq = new Faq();
    clonedNews.idFaq = faq.idFaq;
    clonedNews.question = faq.question;
    clonedNews.answer = faq.answer;
    return clonedNews;
  }
}


