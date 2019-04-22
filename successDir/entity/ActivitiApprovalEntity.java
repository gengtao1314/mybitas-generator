package com.kfwy.park.exp.contract.entity;

import com.gniuu.framework.entity.BaseEntity;
import java.util.Date;


/**
 * 
 * 房租审核实体
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * kfwy_it_004 	1.0  2019年04月22日 Created
 *
 * </pre>
 * @since 1.
 */
public class ActivitiApprovalEntity extends BaseEntity  {
    
    /** 
    *null
    */
    private Long id;
    /** 
    *审批编码
    */
    private String approvalCode;
    /** 
    *申请ID
    */
    private String applyCode;
    /** 
    *申请人编码
    */
    private String applicantCode;
    /** 
    *审批状态
    */
    private String approvalStatus;
    /** 
    *审批意见
    */
    private String approveComment;
    /** 
    *任务ID
    */
    private String taskId;
    /** 
    *流程实例ID
    */
    private String executionId;
    /** 
    *流程实例ID
    */
    private String processInstanceId;
    /** 
    *流程定义ID
    */
    private String processDefinitionId;
    /** 
    *流程定义Key
    */
    private String processDefinitionKey;
    /** 
    *公司编号
    */
    private String cpyCode;
    /** 
    *公司名称
    */
    private String cpyName;
    /** 
    *所属用户编码
    */
    private String ownerCode;
    /** 
    *所属用户姓名
    */
    private String ownerName;
    /** 
    *数据所属部门
    */
    private String ownerDeptCode;
    /** 
    *数据所属部门名称
    */
    private String ownerDeptName;
    /** 
    *创建者
    */
    private String createCode;
    /** 
    *创建者名称
    */
    private String createName;
    /** 
    *创建者部门code
    */
    private String createDeptCode;
    /** 
    *创建者部门名称
    */
    private String createDeptName;
    /** 
    *最后更新者
    */
    private String lastUpdateCode;
    /** 
    *最后更新者名称
    */
    private String lastUpdateName;
    /** 
    *创建时间
    */
    private Date createTime;
    /** 
    *最后更新时间
    */
    private Date lastUpdateTime;
    /** 
    *是否删除
    */
    private Boolean isDeleted;
    /** 
    *备注
    */
    private String remark;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getApprovalCode() {
        return approvalCode;
    }
    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getApplyCode() {
        return applyCode;
    }
    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getApplicantCode() {
        return applicantCode;
    }
    public void setApplicantCode(String applicantCode) {
        this.applicantCode = applicantCode;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApproveComment() {
        return approveComment;
    }
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getExecutionId() {
        return executionId;
    }
    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }
    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }
    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getCpyCode() {
        return cpyCode;
    }
    public void setCpyCode(String cpyCode) {
        this.cpyCode = cpyCode;
    }

    public String getCpyName() {
        return cpyName;
    }
    public void setCpyName(String cpyName) {
        this.cpyName = cpyName;
    }

    public String getOwnerCode() {
        return ownerCode;
    }
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerDeptCode() {
        return ownerDeptCode;
    }
    public void setOwnerDeptCode(String ownerDeptCode) {
        this.ownerDeptCode = ownerDeptCode;
    }

    public String getOwnerDeptName() {
        return ownerDeptName;
    }
    public void setOwnerDeptName(String ownerDeptName) {
        this.ownerDeptName = ownerDeptName;
    }

    public String getCreateCode() {
        return createCode;
    }
    public void setCreateCode(String createCode) {
        this.createCode = createCode;
    }

    public String getCreateName() {
        return createName;
    }
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateDeptCode() {
        return createDeptCode;
    }
    public void setCreateDeptCode(String createDeptCode) {
        this.createDeptCode = createDeptCode;
    }

    public String getCreateDeptName() {
        return createDeptName;
    }
    public void setCreateDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
    }

    public String getLastUpdateCode() {
        return lastUpdateCode;
    }
    public void setLastUpdateCode(String lastUpdateCode) {
        this.lastUpdateCode = lastUpdateCode;
    }

    public String getLastUpdateName() {
        return lastUpdateName;
    }
    public void setLastUpdateName(String lastUpdateName) {
        this.lastUpdateName = lastUpdateName;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }


}