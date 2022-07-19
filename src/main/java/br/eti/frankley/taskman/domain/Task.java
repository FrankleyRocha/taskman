package br.eti.frankley.taskman.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SQ_TASK", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Long index;
	
	private String title;
				
	private String status;

}
