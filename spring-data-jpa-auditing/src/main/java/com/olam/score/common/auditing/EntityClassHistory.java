package com.olam.score.common.auditing;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class EntityClassHistory {

	    @Id
	    @GeneratedValue
	    private Integer id;
	   
	    @ManyToOne
	    @JoinColumn(name = "entityClass_id", foreignKey = @ForeignKey(name = "FK_entityClass_history_data"))
	    private EntityClass entityClass;
	    
	    private String entityClassContent;
	   
	    @CreatedBy
	    private String modifiedBy;
	    
	    @CreatedDate
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date modifiedDate;
	   
	    @Enumerated(EnumType.STRING)
	    private AuditingAction action;
	  
	    public EntityClassHistory() {
	    }

		public EntityClassHistory(EntityClass target, AuditingAction action) {
	        this.entityClass = target;
	        this.entityClassContent = target.toString();
	        this.action = action;
		}

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public EntityClass getFile() {
	        return entityClass;
	    }

	    public void setFile(EntityClass entityClass) {
	        this.entityClass = entityClass;
	    }

	    public String getEntityClassContent() {
	        return entityClassContent;
	    }

	    public void setEntityClassContent(String fileContent) {
	        this.entityClassContent = fileContent;
	    }

	    public String getModifiedBy() {
	        return modifiedBy;
	    }

	    public void setModifiedBy(String modifiedBy) {
	        this.modifiedBy = modifiedBy;
	    }

	    public Date getModifiedDate() {
	        return modifiedDate;
	    }

	    public void setModifiedDate(Date modifiedDate) {
	        this.modifiedDate = modifiedDate;
	    }

	    public AuditingAction getAction() {
	        return action;
	    }

	    public void setAction(AuditingAction action) {
	        this.action = action;
	    }
}
