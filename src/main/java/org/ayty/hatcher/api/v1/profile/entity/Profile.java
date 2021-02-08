package org.ayty.hatcher.api.v1.profile.entity;


//import org.ayty.hatcher.api.v1.project.model.Project;
//import org.ayty.hatcher.api.v1.course.dto.Course;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_profile")
public class Profile {
	
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "User_generator")
	@SequenceGenerator(name = "User_generator", sequenceName = "User_sequence", allocationSize = 1)
	@Id
	private long id;
	
	
	//private Course curso;
	
	@Size(min=10,max=1000)
	private String about;
	
	//private List<Project> projects;
	
	
}
