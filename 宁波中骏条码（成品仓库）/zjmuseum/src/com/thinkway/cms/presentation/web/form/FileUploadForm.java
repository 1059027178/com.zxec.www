package com.thinkway.cms.presentation.web.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import com.thinkway.cms.business.domains.FileUpload;



public class FileUploadForm implements Serializable {

	private static final long serialVersionUID = -4885036728491994931L;

	private FileUpload fileUpload = null;
	private Boolean isRead=true;
	private Boolean isWrite=true;
	private String showTextInput = null;
	private String srcField = null;
	private String retElement = null;
	private String retMessage = null;
	@SuppressWarnings("unchecked")
	
	public FileUploadForm() {
		this.fileUpload = new FileUpload();
		this.isRead=true;
		this.isWrite=true;
	}
	public FileUpload getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	
    /*
	private List<FileUpload> FUList = LazyList.decorate(
		      new ArrayList(),
		      FactoryUtils.instantiateFactory(FileUpload.class));
	public List<FileUpload> getFUList() {
		return FUList;
	}
	public void setFUList(List<FileUpload> list) {
		FUList = list;
	}
	*/
	public Boolean getIsRead() {
		return isRead;
	}
	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}
	public Boolean getIsWrite() {
		return isWrite;
	}
	public void setIsWrite(Boolean isWrite) {
		this.isWrite = isWrite;
	}
	public String getSrcField() {
		return srcField;
	}
	public void setSrcField(String srcField) {
		this.srcField = srcField;
	}
	public String getRetElement() {
		return retElement;
	}
	public void setRetElement(String retElement) {
		this.retElement = retElement;
	}
	public String getRetMessage() {
		return retMessage;
	}
	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}
	public String getShowTextInput() {
		return showTextInput;
	}
	public void setShowTextInput(String showTextInput) {
		this.showTextInput = showTextInput;
	}
}
