package com.ssafy.dog.domain.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "Dog")
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dogId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	private String dogName;
	private String dogPicture;
	private LocalDateTime dogBirthdate;
	private String dogBreed;
	private String dogDisposition;
	private String dogAboutMe;
	private String dogSize;
}