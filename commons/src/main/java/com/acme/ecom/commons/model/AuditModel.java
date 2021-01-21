package com.acme.ecom.commons.model;

import java.util.Date;

public abstract class AuditModel implements BaseModel {

	private static final long serialVersionUID = -270197273662375367L;

	private Date creationAt;
	private String creator;

	private Date updateAt;
	private String updater;

	protected AuditModel() {
	}

	public Date getCreationAt() {
		return creationAt;
	}

	public void setCreationAt(Date creationAt) {
		this.creationAt = creationAt;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

}
