package com.augusto.dojooverflow.Services;

import org.springframework.stereotype.Service;

import com.augusto.dojooverflow.Models.Answer;
import com.augusto.dojooverflow.Repositories.AnswerRepository;

@Service
public class AnswerService extends BaseService<Answer>{

    public AnswerService(AnswerRepository answerRepository) {
        super(answerRepository);
    }
    
}
