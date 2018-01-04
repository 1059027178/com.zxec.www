package cn.webChatServer.ehr.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ehr系统用户信息
 * @author qianyang
 * @since 2017-12-28
 */
public class MyInfo implements Serializable{

	private static final long serialVersionUID = -2633031521792828203L;

	private String username;//用户名
	private String userno;//用户工号
	private Date entry;//入职日期
	private String gongling;//工龄
	private String useraddress;//家庭地址
	private String usertel;//联系电话
	private String email;//E-mail
	private String comp;//单位名称
	private String dept;//部门
	private String station;//职务
	private String post;//职等
	private String fatherName;//父亲姓名
	private String fatherBirth;//父亲生日
	private String motherName;//母亲姓名
	private String motherBirth;//母亲生日
	private String tel;//父母联系电话
	private String address;//父母联系地址
	public String getUsername() {
		return username == null ? "" : username.trim();
	}
	public String getUserno() {
		return userno == null ? "" : userno.trim();
	}
	public void setUserno(String userno) {
		this.userno = userno.trim();
	}
	public String getEntry() {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
		return dateFm.format(entry).trim();
	}
	public String getGongling() {
		return gongling.trim() == null ? "" : gongling.trim();
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress.trim();
	}
	public String getUseraddress() {
		return useraddress == null ? "" : useraddress.trim();
	}
	public String getComp() {
		return comp == null ? "" : comp.trim();
	}
	public String getDept() {
		return dept == null ? "" : dept.trim();
	}
	public String getStation() {
		return station == null ? "" : station.trim();
	}
	public String getPost() {
		return post == null ? "" : post.trim();
	}
	public String getUsertel() {
		return usertel == null ? "" : usertel.trim();
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel.trim();
	}
	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	public void setEmail(String email) {
		this.email = email.trim();
	}
	public String getFatherName() {
		return fatherName == null ? "" : fatherName.trim();
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName.trim();
	}
	public String getFatherBirth() {
		return fatherBirth == null ? "" : fatherBirth.trim();
	}
	public void setFatherBirth(String fatherBirth) {
		this.fatherBirth = fatherBirth.trim();
	}
	public String getMotherName() {
		return motherName == null ? "" : motherName.trim();
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName.trim();
	}
	public String getMotherBirth() {
		return motherBirth == null ? "" : motherBirth.trim();
	}
	public void setMotherBirth(String motherBirth) {
		this.motherBirth = motherBirth.trim();
	}
	public String getTel() {
		return tel == null ? "" : tel.trim();
	}
	public void setTel(String tel) {
		this.tel = tel.trim();
	}
	public String getAddress() {
		return address == null ? "" : address.trim();
	}
	public void setAddress(String address) {
		this.address = address.trim();
	}
	
}
