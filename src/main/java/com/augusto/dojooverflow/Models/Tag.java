package com.augusto.dojooverflow.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tags")
@NoArgsConstructor
@Getter
@Setter
public class Tag extends BaseModel{

    @Size(min = 2,max = 20, message = "Su tag tiene que tener entre 2 y 20 caracteres")
    private String subject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_tags",
        joinColumns = @JoinColumn(name="tag_id"),
        inverseJoinColumns = @JoinColumn(name="question_id")
    )
    private List<Question> questions;
}
