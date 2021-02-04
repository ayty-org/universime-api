package org.ayty.hatcher.api.v1.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_user",uniqueConstraints={@UniqueConstraint(columnNames={"login","password"})})
@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "User_generator")
	@SequenceGenerator(name = "User_generator", sequenceName = "User_sequence", allocationSize = 1)
	@Id
	private Long id;
	
	@Column(nullable = false,unique = true)
	private String login;
	@Column(nullable = false)
	private String password;
	
	@Email
	private String email;
	
	@Size(min = 3, max = 50)
	private String fullName;
	
	private String image;
	
	
	private boolean admin;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	
	

	
	
	


	
	

}
