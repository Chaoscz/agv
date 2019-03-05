package com.chao.agv.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author LinHaiZhu
 *
 * 创建于：2017年11月10日-上午11:54:10
 */
@Entity
@Table(name="yg_forklift_line")
public class ForkliftLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9120758521613338731L;
	private Integer forkliftLineId;
	
	private Integer parentLineId;
	private Integer startSiteX;
	private Integer startSiteY;
	private Integer endSiteX;
	private Integer endSiteY;
	private String  lineAttr;
	
	private String lineName;
	private String startSiteId;
	private String startSiteName;
	private String endSiteId;
	private String endSiteName;
	private String deviceRegId;
	private Integer startSiteCode;
	private Integer endSiteCode;
	private Integer stepNumber;
	private String lineType;
	private String lineFlag;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private String createdBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;
	private String updatedBy;
	private Integer deviceImei;
	private String taskType;
	private Integer liftHeight;
	private String taskSpeed;
	private String isLoop;
	
	private String startHandel;
	private String endHandel;
	private String startStorage;
	private Integer startStorageH;
	private Integer endStorageH;
	private String endStorage;
	private Integer isBackingUp;
	private String startStorageId;
	private String endStorageId;
	private String startSiteAttr;
	private String endSiteAttr;
	private Integer userTaskId;
	private String parentId;
	private Integer returnParentId;
	private Integer returnLineId;
	public ForkliftLine() {}
	private String codeType;
	private Integer taskPriority;
	
	private String relationId;
	private String lineType2;
	private String lineType3;
	private Integer siteX2;
	private Integer siteY2;
	private Integer siteX3;
	private Integer siteY3;
	private Integer site;
	private boolean autoFlag;

	
	@Transient
	public boolean isAutoFlag() {
		return autoFlag;
	}
	public void setAutoFlag(boolean autoFlag) {
		this.autoFlag = autoFlag;
	}
	
	public ForkliftLine(Integer forkliftLineId) {
		this.forkliftLineId = forkliftLineId;
	}
	public ForkliftLine(Integer deviceImei,String startSiteId, String endSiteId) {
		this.deviceImei = deviceImei;
		this.startSiteId = startSiteId;
		this.endSiteId = endSiteId;
	}
	
	
	public ForkliftLine(Integer startSiteCode, Integer endSiteCode, Integer deviceImei) {
		this.startSiteCode = startSiteCode;
		this.endSiteCode = endSiteCode;
		this.deviceImei = deviceImei;
	}

	@Id
	@GeneratedValue(generator="programAssignment")
	@GenericGenerator(name="programAssignment",strategy="assigned")
	@Column(name="forklift_line_id" ,nullable=false,unique=true)
	public Integer getForkliftLineId() {
		return forkliftLineId;
	}
	public void setForkliftLineId(Integer forkliftLineId) {
		this.forkliftLineId = forkliftLineId;
	}
	@Column(name="line_name")
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	@Column(name="start_site_id")
	public String getStartSiteId() {
		return startSiteId;
	}
	public void setStartSiteId(String startSiteId) {
		this.startSiteId = startSiteId;
	}
	@Column(name="start_site_name")
	public String getStartSiteName() {
		return startSiteName;
	}
	public void setStartSiteName(String startSiteName) {
		this.startSiteName = startSiteName;
	}
	@Column(name="end_site_id")
	public String getEndSiteId() {
		return endSiteId;
	}
	public void setEndSiteId(String endSiteId) {
		this.endSiteId = endSiteId;
	}
	@Column(name="end_site_name")
	public String getEndSiteName() {
		return endSiteName;
	}
	public void setEndSiteName(String endSiteName) {
		this.endSiteName = endSiteName;
	}
	
	@Column(name="device_reg_id")
	public String getDeviceRegId() {
		return deviceRegId;
	}
	public void setDeviceRegId(String deviceRegId) {
		this.deviceRegId = deviceRegId;
	}

	
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name="updated_by")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name="start_site_code")
	public Integer getStartSiteCode() {
		return startSiteCode;
	}
	public void setStartSiteCode(Integer startSiteCode) {
		this.startSiteCode = startSiteCode;
	}
	@Column(name="end_site_code")
	public Integer getEndSiteCode() {
		return endSiteCode;
	}
	public void setEndSiteCode(Integer endSiteCode) {
		this.endSiteCode = endSiteCode;
	}
	
	@Column(name="step_number")
	public Integer getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}
	
	@Column(name="device_imei")
	public Integer getDeviceImei() {
		return deviceImei;
	}
	public void setDeviceImei(Integer deviceImei) {
		this.deviceImei = deviceImei;
	}
	
	@Column(name="parent_line_id")
	public Integer getParentLineId() {
		return parentLineId;
	}
	public void setParentLineId(Integer parentLineId) {
		this.parentLineId = parentLineId;
	}
	@Column(name="start_site_x")
	public Integer getStartSiteX() {
		return startSiteX;
	}
	public void setStartSiteX(Integer startSiteX) {
		this.startSiteX = startSiteX;
	}
	@Column(name="start_site_y")
	public Integer getStartSiteY() {
		return startSiteY;
	}
	public void setStartSiteY(Integer startSiteY) {
		this.startSiteY = startSiteY;
	}
	@Column(name="end_site_x")
	public Integer getEndSiteX() {
		return endSiteX;
	}
	public void setEndSiteX(Integer endSiteX) {
		this.endSiteX = endSiteX;
	}
	@Column(name="end_site_y")
	public Integer getEndSiteY() {
		return endSiteY;
	}
	public void setEndSiteY(Integer endSiteY) {
		this.endSiteY = endSiteY;
	}
	@Column(name="line_attr")
	public String getLineAttr() {
		return lineAttr;
	}
	public void setLineAttr(String lineAttr) {
		this.lineAttr = lineAttr;
	}
	@Transient
	public String getTaskType() {
		return taskType;
	}
	
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	
	@Transient
	public Integer getLiftHeight() {
		return liftHeight;
	}
	public void setLiftHeight(Integer liftHeight) {
		this.liftHeight = liftHeight;
	}
	
	@Transient
	public String getTaskSpeed() {
		return taskSpeed;
	}
	public void setTaskSpeed(String taskSpeed) {
		this.taskSpeed = taskSpeed;
	}
	
	@Transient
	public String getIsLoop() {
		return isLoop;
	}
	public void setIsLoop(String isLoop) {
		this.isLoop = isLoop;
	}
	
	
	
	@Transient
	public String getStartHandel() {
		return startHandel;
	}
	public void setStartHandel(String startHandel) {
		this.startHandel = startHandel;
	}
	@Transient
	public String getEndHandel() {
		return endHandel;
	}
	public void setEndHandel(String endHandel) {
		this.endHandel = endHandel;
	}

	@Transient
	public String getStartStorage() {
		return startStorage;
	}
	public void setStartStorage(String startStorage) {
		this.startStorage = startStorage;
	}
	
	@Transient
	public String getEndStorage() {
		return endStorage;
	}
	public void setEndStorage(String endStorage) {
		this.endStorage = endStorage;
	}
	
	@Column(name="is_backing_up")
	public Integer getIsBackingUp() {
		return isBackingUp;
	}
	public void setIsBackingUp(Integer isBackingUp) {
		this.isBackingUp = isBackingUp;
	}
	
	@Transient
	public Integer getStartStorageH() {
		return startStorageH;
	}
	public void setStartStorageH(Integer startStorageH) {
		this.startStorageH = startStorageH;
	}
	@Transient
	public Integer getEndStorageH() {
		return endStorageH;
	}
	public void setEndStorageH(Integer endStorageH) {
		this.endStorageH = endStorageH;
	}
	@Transient
	public String getStartStorageId() {
		return startStorageId;
	}
	public void setStartStorageId(String startStorageId) {
		this.startStorageId = startStorageId;
	}
	@Transient
	public String getEndStorageId() {
		return endStorageId;
	}
	public void setEndStorageId(String endStorageId) {
		this.endStorageId = endStorageId;
	}

	@Transient
	public String getStartSiteAttr() {
		return startSiteAttr;
	}

	public void setStartSiteAttr(String startSiteAttr) {
		this.startSiteAttr = startSiteAttr;
	}

	@Transient
	public String getEndSiteAttr() {
		return endSiteAttr;
	}

	public void setEndSiteAttr(String endSiteAttr) {
		this.endSiteAttr = endSiteAttr;
	}

	@Transient
	public Integer getUserTaskId() {
		return userTaskId;
	}

	public void setUserTaskId(Integer userTaskId) {
		this.userTaskId = userTaskId;
	}

	@Transient
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name="line_type")
	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	@Column(name="return_parent_id")
	public Integer getReturnParentId() {
		return returnParentId;
	}

	public void setReturnParentId(Integer returnParentId) {
		this.returnParentId = returnParentId;
	}

	@Column(name="return_line_id")
	public Integer getReturnLineId() {
		return returnLineId;
	}

	public void setReturnLineId(Integer returnLineId) {
		this.returnLineId = returnLineId;
	}

	@Transient
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	@Column(name="line_flag")
	public String getLineFlag() {
		return lineFlag;
	}

	public void setLineFlag(String lineFlag) {
		this.lineFlag = lineFlag;
	}
	@Transient
	public Integer getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}


	@Column(name="relation_id")
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	@Column(name="line_type2")
	public String getLineType2() {
		return lineType2;
	}
	public void setLineType2(String lineType2) {
		this.lineType2 = lineType2;
	}

	@Column(name="line_type3")
	public String getLineType3() {
		return lineType3;
	}
	public void setLineType3(String lineType3) {
		this.lineType3 = lineType3;
	}

	@Column(name="site_x2")
	public Integer getSiteX2() {
		return siteX2;
	}
	public void setSiteX2(Integer siteX2) {
		this.siteX2 = siteX2;
	}

	@Column(name="site_y2")
	public Integer getSiteY2() {
		return siteY2;
	}
	public void setSiteY2(Integer siteY2) {
		this.siteY2 = siteY2;
	}

	@Column(name="site_x3")
	public Integer getSiteX3() {
		return siteX3;
	}
	public void setSiteX3(Integer siteX3) {
		this.siteX3 = siteX3;
	}

	@Column(name="site_y3")
	public Integer getSiteY3() {
		return siteY3;
	}
	public void setSiteY3(Integer siteY3) {
		this.siteY3 = siteY3;
	}

	@Column(name="site")
	public Integer getSite() {
		return site;
	}
	public void setSite(Integer site) {
		this.site = site;
	}

	
	
	
}
