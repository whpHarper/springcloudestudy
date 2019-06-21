package com.springcloud.server1.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class AuRule implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;//

	@NotBlank
	@Size(min = 1, max = 200)
	private String ruleName;//

	@NotBlank
	@Size(min = 1, max = 255)
	private String description;//


	@NotBlank
	@Size(min = 1, max = 255)
	private String remark;//


	private Integer alertType;//

	private Integer eventTypeId;//


	private String ruleParameter;//

//	@NotBlank
//	@Size(min = 1, max = 65535)
	private String ruleDefinition;//

	private Integer alertLevel;//

	private Integer isEable;//

	private Integer isDelete;//

	private Date createTime;//

	private Date updateTime;//

	private Long createdBy;//

	private Long updatedBy;//

	private String pluginType;

	public String getPluginType() {
		return pluginType;
	}

	public void setPluginType(String pluginType) {
		this.pluginType = pluginType;
	}

	public AuRule() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAlertType() {
		return alertType;
	}

	public String getRuleParameter() {
		return ruleParameter;
	}

	public void setRuleParameter(String ruleParameter) {
		this.ruleParameter = ruleParameter;
	}

	public void setAlertType(Integer alertType) {
		this.alertType = alertType;
	}

	public Integer getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Integer eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getRuleDefinition() {
		return ruleDefinition;
	}

	public void setRuleDefinition(String ruleDefinition) {
		this.ruleDefinition = ruleDefinition;
	}

	public Integer getAlertLevel() {
		return alertLevel;
	}

	public void setAlertLevel(Integer alertLevel) {
		this.alertLevel = alertLevel;
	}

	public Integer getIsEable() {
		return isEable;
	}

	public void setIsEable(Integer isEable) {
		this.isEable = isEable;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
