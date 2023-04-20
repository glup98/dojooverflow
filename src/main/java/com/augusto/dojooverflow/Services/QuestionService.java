package com.augusto.dojooverflow.Services;

import org.springframework.stereotype.Service;

import com.augusto.dojooverflow.Models.Question;
import com.augusto.dojooverflow.Repositories.QuestionRepository;

@Service
public class QuestionService extends BaseService<Question>{

    public QuestionService(QuestionRepository questionRepository) {
        super(questionRepository);
    }
    
}
