package com.gym.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "faq", schema = "gym")
public class FaqEntity {
    private int idFaq;
    private String question;
    private String answer;

    @Id
    @Column(name = "id_faq")
    public int getIdFaq() {
        return idFaq;
    }

    public void setIdFaq(int idFaq) {
        this.idFaq = idFaq;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FaqEntity faqEntity = (FaqEntity) o;

        if (idFaq != faqEntity.idFaq) return false;
        if (question != null ? !question.equals(faqEntity.question) : faqEntity.question != null) return false;
        if (answer != null ? !answer.equals(faqEntity.answer) : faqEntity.answer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFaq;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
