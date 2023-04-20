package com.augusto.dojooverflow.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answers")
@NoArgsConstructor
@Getter
@Setter
public class Answer extends BaseModel{

    @Size (min = 2, message="Su respuesta debe tener minimo 2 caracteres")
    private String answerText;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
}
