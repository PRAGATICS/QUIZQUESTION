package org.codejudge.sb.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.codejudge.sb.controller.QuizService;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Question {
	
	
	@Id @NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	  @NotNull
	  private String name;
	  @NotNull
	  private String options;
	  @NotNull
	  private int correct_option;
	  @NotNull
	  private int points;
	  
	  
	  @ManyToOne(cascade=CascadeType.ALL)
	  @JsonIgnore
	  private Quiz quiz;
		

	   public Question() {
			// TODO Auto-generated constructor stub
		}


		public Question(String name, String options, int correct_option,int points,Quiz quiz) {
				super();
				this.name = name;
				this.options = options;
				this.correct_option = correct_option;
				this.points = points;
				this.quiz=quiz;
			
				
			}

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Quiz getQuiz() {
			return quiz;
		}


		public void setQuiz(Quiz quiz) {
			this.quiz = quiz;
		}

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getCorrect_option() {
		return correct_option;
	}

	public void setCorrect_option(int correct_option) {
		this.correct_option = correct_option;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", options=" + options + ", correct_option=" + correct_option
				+ ", points=" + points + ", quiz=" + quiz + "]";
	}
	

	
	

}
