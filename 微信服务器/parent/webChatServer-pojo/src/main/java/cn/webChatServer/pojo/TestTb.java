package cn.webChatServer.pojo;

import java.io.Serializable;


/**
 * 
 * 测试表实体类
 * @author Administrator
 *
 */
public class TestTb implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Integer id;
		private String namea;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNamea() {
			return namea;
		}
		public void setName(String namea) {
			this.namea = namea;
		}

}
