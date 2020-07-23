package org.codejudge.sb.controller;

import java.util.logging.Logger;

import org.codejudge.sb.MyLogger;
import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
import org.codejudge.sb.repository.QuestionRepository;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {
    private final QuizRepository QuizRepo;
    private final QuestionRepository QuestionRepository;

    public BootstrapData(QuizRepository QuizRepo, QuestionRepository QuestionRepository) {
        this.QuizRepo = QuizRepo;
        this.QuestionRepository = QuestionRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Logger log = Logger.getLogger(MyLogger.class.getName());
		/*Quiz quiz1=new Quiz(null,"Demo Quiz");
		Question question1=new Question("Question1","x,y,z,L",1,1L,10);
		
		
	
		
		QuizRepo.save(quiz1);
		
		QuestionRepository.save(question1);
		
		log.info("Quizes are"+quiz1.getid());
		log.info("Quizes are"+quiz1.getName());
		
		
		
		log.info("Questioid are"+question1.getid());*/


    }

}
