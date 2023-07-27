package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quizentity;
import com.example.demo.repository.Quizrepo;

@Service
public class Quizservice
{
    @Autowired
    Quizrepo Quizrepo;
    public boolean addQuizentity(Quizentity Quizentity)
    {
    	return Quizrepo.save(Quizentity)!=null?true:false;
    }
    public List <Quizentity> getAllQuizentity()
    {
    return Quizrepo.findAll();
    }
	public List<Quizentity> getByType(int type) {
		return Quizrepo.getByQuizeType(type);
	}
	public Quizentity updateQuizentity(Integer id, Quizentity  Quizentity ) {
		Quizentity  stu = Quizrepo.findById(id).get();
		stu.setType(Quizentity.getType());
		stu.setQuestion(Quizentity .getQuestion());
		stu.setOption1(Quizentity .getOption1());
		stu.setOption2(Quizentity .getOption2());
		stu.setOption3(Quizentity .getOption3());
		stu.setOption4(Quizentity .getOption4());
		stu.setAnswer(Quizentity .getAnswer());
		stu.setScore(Quizentity .getScore());
		return Quizrepo.save(stu);
		}
	public boolean deleteQuizentity(Integer id) {
		if(Quizrepo.findById(id).isPresent()){
		Quizrepo.deleteById(id);
		return true;
		}
		return false;
		}
}
