package org.ayty.hatcher.api.v1.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_user",uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", allocationSize = 1)
	@Id
	private Long id;
	
	@Column(nullable = false,unique = true)
	@NotBlank(message = "login field is mandatory")
	private String login;
	
	@Column(nullable = false)
	@NotBlank(message = "password field is mandatory")
	private String password;
	
	@Email(message = "field email invalid")
	private String email;
	@Length(min = 3 ,max = 255)
	private String fullName;
	private String image;
	private boolean admin;
	@Enumerated(EnumType.STRING)
	private Profile profile;
	/*
	@ManyToMany
	@JoinTable(name = "user_project",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_project"))
	List<Project> projects;
	*/
}











