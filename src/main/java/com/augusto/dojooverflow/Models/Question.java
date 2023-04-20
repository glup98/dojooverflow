package com.augusto.dojooverflow.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name="questions")
@NoArgsConstructor
@Getter
@Setter
public class Question extends BaseModel{

    @Size(min = 10, max = 200, message="Su pregunta tiene que tener entre 10 y 200 caracteres")
    private String questionText;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List <Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="questions_tags",
        joinColumns = @JoinColumn(name="question_id"),
        inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private List<Tag> tags;
}
