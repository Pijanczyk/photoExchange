package com.photoexchange.models;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "photo")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;
	
	private Date date;

	@Lob
	private byte [] file;
	

	@ManyToOne()
	@JoinColumn(name="creator_id")
	private User creator;
	
	@OneToMany(mappedBy="photo")
	private List<Comment> comments;
	
	@ManyToMany
	@JoinTable(name = "share", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> sharedUsers;

	public Photo() { }

	public Photo(long id) { 
	    this.id = id;
	  }
	  
	public Photo(String name, User creator) {
		this.name = name;
		this.date = new Date();
		this.creator = creator;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Set<User> getSharedUsers() {
		return sharedUsers;
	}

	public void setSharedUsers(Set<User> sharedUsers) {
		this.sharedUsers = sharedUsers;
	}

	public byte [] getFile() {
		return file;
	}

	public void setFile(MultipartFile file) throws IOException {
		this.file = file.getBytes();
	}
	
}
