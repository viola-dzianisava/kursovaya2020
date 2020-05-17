package com.gym.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Faq {

    private int idFaq;
    private String question;
    private String answer;

    public Faq() {
    }

    public Faq(int idFaq, String question, String answer) {
        this.idFaq = idFaq;
        this.question = question;
        this.answer = answer;
    }

    public int getIdFaq() {
        return idFaq;
    }

    public void setIdFaq(int idFaq) {
        this.idFaq = idFaq;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
