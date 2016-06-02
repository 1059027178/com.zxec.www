package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.springframework.web.servlet.ModelAndView;

import com.thinkway.cms.business.domains.FileUpload;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.presentation.web.form.FileUploadForm;
import com.thinkway.cms.presentation.web.interceptors.BaseFormController;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.util.ScaleImage;

/**
 * FILE-UPLOAD
 * 
 * @author WELSON
 * 
 */
public class AuthFileUploadController extends BaseFormController implements AuthenticateController{
	private String uploadDir;// 上传文件路径
	private Long maxUploadSize;
	
	private long permission = 0L;
	private Authenticator authenticator = null;

	private String tokenNeed = null;
	public String getTokenNeed() {
		return tokenNeed;
	}

	public void setTokenNeed(String tokenNeed) {
		this.tokenNeed = tokenNeed;
	}
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public void setPermission(long permission) {
		this.permission = permission;
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		FileUploadForm fileUploadForm = new FileUploadForm();		
		fileUploadForm.setSrcField(ParamUtils.getParameter(request,"srcField",""));
		fileUploadForm.setRetElement(ParamUtils.getParameter(request,"retElement",""));
		fileUploadForm.setRetMessage(ParamUtils.getParameter(request,"retMessage",""));
		return fileUploadForm;
	}

	@SuppressWarnings("unchecked")
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object cmd, BindException errors)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String userId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		FileUploadForm formBean = (FileUploadForm) cmd;
		FileUpload bean = formBean.getFileUpload();
		PrintWriter out = response.getWriter();
		// 获取服务器上传路径
		String uploadDir = this.getUploadDir()+userId+"/";
		// URL返回地址
		String retUrl = "window.location.href=\"/authFileUpload.do?srcField="+formBean.getSrcField()+"&retElement="+formBean.getRetElement()+"&retMessage="+java.net.URLEncoder.encode(formBean.getRetMessage(),"UTF-8")+"\"";

		File dirPath = new File(uploadDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
		
		//MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		long totalSize = 0;
		//判断上传文件的size
		for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
			totalSize += multipartRequest.getFile((String)it.next()).getSize();
		}
		if(totalSize > this.getMaxUploadSize()){
			out.println("<script language=javascript>");
			out.println("alert('上传失败!此次文件上传超过了限制大小"+this.getMaxUploadSize()/1024/1024+"M')");
			out.println(retUrl);
			out.println("</script>"); 
			return null;
		}
		
		
		String sFileType =  "";
		String noTypeWJM =  "";
		
		// 上传文件
		for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
			String key = (String) it.next();
			MultipartFile file = multipartRequest.getFile(key);
			sFileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
			//System.out.println(sFileType);
			if(sFileType.equalsIgnoreCase(".jpg")||sFileType.equalsIgnoreCase(".jpeg")||sFileType.equalsIgnoreCase(".bmp")||sFileType.equalsIgnoreCase(".gif")||sFileType.equalsIgnoreCase(".png")){
				bean.setWJM(file.getOriginalFilename());
				noTypeWJM = userId+"_"+System.currentTimeMillis();
				bean.setZSWJM(noTypeWJM+sFileType);;
				bean.setBCLJ(uploadDir + "/" + bean.getZSWJM());
				bean.setZT(1);
				//bean.setTJR((request.getSession().getAttribute(SessionManager.USER_BH).toString()).toUpperCase());
				bean.setBDLJ("NO USE");
				//userService.createUpfile(bean);
				// 保存文件
				save(uploadDir + bean.getZSWJM(), file);
				//缩略图
				ScaleImage is = new ScaleImage();   
		        try {   
		        	is.saveImageAsJpg(uploadDir + bean.getZSWJM(),uploadDir + noTypeWJM + "_medium" + sFileType, 600, 600);
		            is.saveImageAsJpg(uploadDir + bean.getZSWJM(),uploadDir + noTypeWJM + "_small" + sFileType, 60, 60);   
		            //System.out.println("success");   
		        } catch (Exception e) {   
		            // TODO Auto-generated catch block   
		            e.printStackTrace();   
		        }   
			}else{
				out.println("<script language=javascript>");
				out.println("alert('上传失败!只允许上传JPG|JPEG|BMP|GIF|PNG格式的文件')");
				out.println(retUrl);
				out.println("</script>"); 
				return null;
			}
			
		}
		
		
		out.println("<script language=javascript>");
		if(formBean.getRetElement()!=null&&!formBean.getRetElement().equals("")){
			out.println("self.parent.document.getElementById('"+formBean.getRetElement()+"').innerHTML=self.parent.document.getElementById('"+formBean.getRetElement()+"').innerHTML+'<br/><img src="+this.uploadDir+userId + "/" + noTypeWJM + "_small" + sFileType+" border=0/>&nbsp;&nbsp;"+formBean.getRetMessage()+"';");
		    
		}
		out.println("self.parent.document.getElementById('"+formBean.getSrcField()+"').value=self.parent.document.getElementById('"+formBean.getSrcField()+"').value+'|"+bean.getZSWJM()+"';");
		out.println(retUrl);
		out.println("</script>"); 
		return null;
	}

	public boolean save(String fullPath, MultipartFile file) throws Exception {
		boolean result = false;
		if (file != null && !file.isEmpty()) {
			DataOutputStream out = null;
			InputStream is = null;
			try {
				out = new DataOutputStream(new FileOutputStream(fullPath));
				is = file.getInputStream();
				byte[] buffer = new byte[1024];
				while (is.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (is != null) {
					is.close();
				}
				if (out != null) {
					out.close();
				}
			}
			result = true;
		}
		return result;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public String getUploadDir() {
		return getServletContext().getRealPath("/")+this.uploadDir;
	}

	
	public Long getMaxUploadSize() {
		return maxUploadSize;
	}

	public void setMaxUploadSize(Long maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}

	public Authenticator getAuthenticator() {
		return authenticator;
	}

	public long getPermission() {
		return permission;
	}

}
