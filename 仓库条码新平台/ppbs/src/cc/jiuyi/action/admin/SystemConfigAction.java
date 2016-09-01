package cc.jiuyi.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeanUtils;

import cc.jiuyi.bean.SystemConfig;
import cc.jiuyi.bean.SystemConfig.CurrencyType;
import cc.jiuyi.bean.SystemConfig.PointType;
import cc.jiuyi.bean.SystemConfig.RoundType;
import cc.jiuyi.bean.SystemConfig.StoreFreezeTime;
import cc.jiuyi.bean.SystemConfig.WatermarkPosition;
import cc.jiuyi.util.SystemConfigUtil;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 后台Action类 - 系统设置
 */

@ParentPackage("admin")
public class SystemConfigAction extends BaseAdminAction {

	private static final long serialVersionUID = -6200425957233641240L;

	private SystemConfig systemConfig;
	private File platformLogo;
	private String platformLogoFileName;
	private File defaultBigProductImage;
	private String defaultBigProductImageFileName;
	private File defaultSmallProductImage;
	private String defaultSmallProductImageFileName;
	private File defaultThumbnailProductImage;
	private String defaultThumbnailProductImageFileName;
	private File watermarkImage;
	private String watermarkImageFileName;

	// 编辑
	public String edit() {
		systemConfig = SystemConfigUtil.getSystemConfig();
		return INPUT;
	}

	// 更新
	@Validations(
		requiredFields = {
			@RequiredFieldValidator(fieldName = "systemConfig.isLoginFailureLock", message = "是否开启自动锁定账号功能不允许为空!"),
			@RequiredFieldValidator(fieldName = "systemConfig.loginFailureLockCount", message = "连续登录失败最大次数不允许为空!"),
			@RequiredFieldValidator(fieldName = "systemConfig.loginFailureLockTime", message = "自动解锁时间不允许为空!")
		}
	)
	@InputConfig(resultName = "error")
	public String update() throws Exception {
		if (systemConfig.getPointType() == PointType.orderAmount) {
			if (systemConfig.getPointScale() < 0) {
				addActionError("积分换算比率不允许小于0!");
				return ERROR;
			}
		} else {
			systemConfig.setPointScale(0D);
		}
		SystemConfig persistent = SystemConfigUtil.getSystemConfig();
		if (platformLogo != null || defaultBigProductImage != null || defaultSmallProductImage != null || defaultThumbnailProductImage != null || watermarkImage != null) {
			String allowedUploadImageExtension = getSystemConfig().getAllowedUploadImageExtension().toLowerCase();
			if (StringUtils.isEmpty(allowedUploadImageExtension)){
				addActionError("不允许上传图片文件!");
				return ERROR;
			}
			String[] imageExtensionArray = allowedUploadImageExtension.split(SystemConfig.EXTENSION_SEPARATOR);
			if (platformLogo != null) {
				String platformLogoExtension =  StringUtils.substringAfterLast(platformLogoFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, platformLogoExtension)) {
					addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
			if (defaultBigProductImage != null) {
				String defaultBigProductImageExtension =  StringUtils.substringAfterLast(defaultBigProductImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, defaultBigProductImageExtension)) {
					addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
			if (defaultSmallProductImage != null) {
				String defaultSmallProductImageExtension =  StringUtils.substringAfterLast(defaultSmallProductImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, defaultSmallProductImageExtension)) {
					addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
			if (defaultThumbnailProductImage != null) {
				String defaultThumbnailProductImageExtension =  StringUtils.substringAfterLast(defaultThumbnailProductImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, defaultThumbnailProductImageExtension)) {
					addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
			if (watermarkImage != null) {
				String watermarkImageExtension =  StringUtils.substringAfterLast(watermarkImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, watermarkImageExtension)) {
					addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
		}
		
		if (StringUtils.isEmpty(systemConfig.getSmtpPassword())) {
			systemConfig.setSmtpPassword(persistent.getSmtpPassword());
		}
		if (StringUtils.isEmpty(systemConfig.getSapPasswd())) {
			systemConfig.setSapPasswd(persistent.getSapPasswd());
		}
		if (systemConfig.getIsLoginFailureLock() == false) {
			systemConfig.setLoginFailureLockCount(3);
			systemConfig.setLoginFailureLockTime(10);
		}
		if (platformLogo != null) {
			File oldPlatformLogoFile = new File(ServletActionContext.getServletContext().getRealPath(persistent.getPlatformLogo()));
			if (oldPlatformLogoFile.isFile()) {
				oldPlatformLogoFile.delete();
			}
			String platformLogoFilePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.LOGO_UPLOAD_NAME + "." +  StringUtils.substringAfterLast(platformLogoFileName, ".").toLowerCase();
			File platformLogoFile = new File(ServletActionContext.getServletContext().getRealPath(platformLogoFilePath));
			FileUtils.copyFile(platformLogo, platformLogoFile);
			persistent.setPlatformLogo(platformLogoFilePath);
		}
		// 处理默认商品图片（大）
		if (defaultBigProductImage != null) {
			File oldDefaultBigProductImageFile = new File(ServletActionContext.getServletContext().getRealPath(persistent.getDefaultBigProductImagePath()));
			if (oldDefaultBigProductImageFile.exists()) {
				oldDefaultBigProductImageFile.delete();
			}
			String defaultBigProductImagePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.DEFAULT_BIG_PRODUCT_IMAGE_FILE_NAME + "." +  StringUtils.substringAfterLast(defaultBigProductImageFileName, ".").toLowerCase();
			File defaultBigProductImageFile = new File(ServletActionContext.getServletContext().getRealPath(defaultBigProductImagePath));
			FileUtils.copyFile(defaultBigProductImage, defaultBigProductImageFile);
			persistent.setDefaultBigProductImagePath(defaultBigProductImagePath);
		}
		// 处理默认商品图片（小）
		if (defaultSmallProductImage != null) {
			File oldDefaultSmallProductImageFile = new File(ServletActionContext.getServletContext().getRealPath(persistent.getDefaultSmallProductImagePath()));
			if (oldDefaultSmallProductImageFile.exists()) {
				oldDefaultSmallProductImageFile.delete();
			}
			String defaultSmallProductImagePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.DEFAULT_SMALL_PRODUCT_IMAGE_FILE_NAME + "." +  StringUtils.substringAfterLast(defaultSmallProductImageFileName, ".").toLowerCase();
			File defaultSmallProductImageFile = new File(ServletActionContext.getServletContext().getRealPath(defaultSmallProductImagePath));
			FileUtils.copyFile(defaultSmallProductImage, defaultSmallProductImageFile);
			persistent.setDefaultSmallProductImagePath(defaultSmallProductImagePath);
		}
		// 处理默认商品缩略图
		if (defaultThumbnailProductImage != null) {
			File oldDefaultThumbnailProductImageFile = new File(ServletActionContext.getServletContext().getRealPath(persistent.getDefaultThumbnailProductImagePath()));
			if (oldDefaultThumbnailProductImageFile.exists()) {
				oldDefaultThumbnailProductImageFile.delete();
			}
			String defaultThumbnailProductImagePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.DEFAULT_THUMBNAIL_PRODUCT_IMAGE_FILE_NAME + "."
					+  StringUtils.substringAfterLast(defaultThumbnailProductImageFileName, ".").toLowerCase();
			File defaultThumbnailProductImageFile = new File(ServletActionContext.getServletContext().getRealPath(defaultThumbnailProductImagePath));
			FileUtils.copyFile(defaultThumbnailProductImage, defaultThumbnailProductImageFile);
			persistent.setDefaultThumbnailProductImagePath(defaultThumbnailProductImagePath);
		}
		BeanUtils.copyProperties(systemConfig, persistent, new String[] {"systemName", "systemVersion", "systemDescription", "isInstalled", "platformLogo", "defaultBigProductImagePath", "defaultSmallProductImagePath", "defaultThumbnailProductImagePath", "watermarkImagePath"});
		SystemConfigUtil.update(persistent);
		redirectionUrl = "system_config!edit.action";
		return SUCCESS;
	}
	
	// 获取所有货币种类
	public List<CurrencyType> getAllCurrencyType() {
		List<CurrencyType> allCurrencyType = new ArrayList<CurrencyType>();
		for (CurrencyType currencyType : CurrencyType.values()) {
			allCurrencyType.add(currencyType);
		}
		return allCurrencyType;
	}
	
	// 获取所有小数位精确方式
	public List<RoundType> getAllRoundType() {
		List<RoundType> allRoundType = new ArrayList<RoundType>();
		for (RoundType roundType : RoundType.values()) {
			allRoundType.add(roundType);
		}
		return allRoundType;
	}
	
	// 获取所有库存预占时间点
	public List<StoreFreezeTime> getAllStoreFreezeTime() {
		List<StoreFreezeTime> allStoreFreezeTime = new ArrayList<StoreFreezeTime>();
		for (StoreFreezeTime storeFreezeTime : StoreFreezeTime.values()) {
			allStoreFreezeTime.add(storeFreezeTime);
		}
		return allStoreFreezeTime;
	}

	// 获取所有WatermarkPosition值
	public List<WatermarkPosition> getAllWatermarkPosition() {
		List<WatermarkPosition> allWatermarkPosition = new ArrayList<WatermarkPosition>();
		for (WatermarkPosition watermarkPosition : WatermarkPosition.values()) {
			allWatermarkPosition.add(watermarkPosition);
		}
		return allWatermarkPosition;
	}
	
	// 获取所有积分获取方式
	public List<PointType> getAllPointType() {
		List<PointType> allPointType = new ArrayList<PointType>();
		for (PointType pointType : PointType.values()) {
			allPointType.add(pointType);
		}
		return allPointType;
	}

	public SystemConfig getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	public File getPlatformLogo() {
		return platformLogo;
	}

	public void setPlatformLogo(File platformLogo) {
		this.platformLogo = platformLogo;
	}

	public String getPlatformLogoFileName() {
		return platformLogoFileName;
	}

	public void setPlatformLogoFileName(String platformLogoFileName) {
		this.platformLogoFileName = platformLogoFileName;
	}

	public File getDefaultBigProductImage() {
		return defaultBigProductImage;
	}

	public void setDefaultBigProductImage(File defaultBigProductImage) {
		this.defaultBigProductImage = defaultBigProductImage;
	}

	public String getDefaultBigProductImageFileName() {
		return defaultBigProductImageFileName;
	}

	public void setDefaultBigProductImageFileName(String defaultBigProductImageFileName) {
		this.defaultBigProductImageFileName = defaultBigProductImageFileName;
	}

	public File getDefaultSmallProductImage() {
		return defaultSmallProductImage;
	}

	public void setDefaultSmallProductImage(File defaultSmallProductImage) {
		this.defaultSmallProductImage = defaultSmallProductImage;
	}

	public String getDefaultSmallProductImageFileName() {
		return defaultSmallProductImageFileName;
	}

	public void setDefaultSmallProductImageFileName(String defaultSmallProductImageFileName) {
		this.defaultSmallProductImageFileName = defaultSmallProductImageFileName;
	}

	public File getDefaultThumbnailProductImage() {
		return defaultThumbnailProductImage;
	}

	public void setDefaultThumbnailProductImage(File defaultThumbnailProductImage) {
		this.defaultThumbnailProductImage = defaultThumbnailProductImage;
	}

	public String getDefaultThumbnailProductImageFileName() {
		return defaultThumbnailProductImageFileName;
	}

	public void setDefaultThumbnailProductImageFileName(String defaultThumbnailProductImageFileName) {
		this.defaultThumbnailProductImageFileName = defaultThumbnailProductImageFileName;
	}

	public File getWatermarkImage() {
		return watermarkImage;
	}

	public void setWatermarkImage(File watermarkImage) {
		this.watermarkImage = watermarkImage;
	}

	public String getWatermarkImageFileName() {
		return watermarkImageFileName;
	}

	public void setWatermarkImageFileName(String watermarkImageFileName) {
		this.watermarkImageFileName = watermarkImageFileName;
	}

}