///**
// * 
// */
//package com.sapient.newssearch.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//import org.hibernate.annotations.NaturalId;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//
//import java.io.Serializable;
//import java.time.Instant;
//import java.util.Calendar;
//import java.util.Date;
//
// /**
// * Rajesh Engimoori
// * Created on Jan 12, 2023
// * Email: rajesh.em@gmail.com
// **/
//
//@Data
//@Entity
//@Table(name = "news")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
//@Indexed
//@ToString
//@EqualsAndHashCode
//public class News implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 3323631620875530805L;
//
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @FullTextField()
//    @NaturalId()
//    private String headline;
//
//    @FullTextField()
//    @NaturalId()
//    private String author;
//
//    @FullTextField()
//    @NaturalId()
//    private String title;
//
//    @FullTextField()
//    @NaturalId()
//    private String description;
//
//    private String url;
//
//    private String urlToImage;
//
//    private Date publishedAt;
//
//    @Column(nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    private Date createdAt;
//
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
//    private Date updatedAt;
//
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "id", column = @Column(name = "source_id")),
//            @AttributeOverride(name = "name", column = @Column(name = "source_name"))})
//    private NewsSource source;
//    
//    /**
//	 * @param string
//	 * @param string2
//	 * @param string3
//	 * @param string4
//	 */
//	public News(String headline, String author, String title, String description) {
//		this.headline = headline;
//		this.author = author;
//		this.title = title;
//		this.description = description;
//		this.createdAt = new Date();
//		this.updatedAt = new Date();
//	}
//}
