package cc.jiuyi.bean;



/**
 * Bean类 - 文章图片
 */

public class ArticleImage {
	
	public static final String ARTICLE_IMAGE_FILE_EXTENSION = "jpg";// 文章图片文件名扩展名
	public static final String BIG_ARTICLE_IMAGE_FILE_NAME_SUFFIX = "_big";// 文章图片（大）文件名后缀
	public static final String SMALL_ARTICLE_IMAGE_FILE_NAME_SUFFIX = "_small";// 文章图片（小）文件名后缀
	public static final String THUMBNAIL_ARTICLE_IMAGE_FILE_NAME_SUFFIX = "_thumbnail";// 文章缩略图文件名后缀
	
	private String id;// ID
	private String sourceArticleImagePath;// 文章图片（原）路径
	private String bigArticleImagePath;// 文章图片（大）路径
	private String smallArticleImagePath;// 文章图片（小）路径
	private String thumbnailArticleImagePath;// 文章图片（缩略图）路径
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getSourceArticleImagePath() {
		return sourceArticleImagePath;
	}
	
	public void setSourceArticleImagePath(String sourceArticleImagePath) {
		this.sourceArticleImagePath = sourceArticleImagePath;
	}

	public String getBigArticleImagePath() {
		return bigArticleImagePath;
	}
	
	public void setBigArticleImagePath(String bigArticleImagePath) {
		this.bigArticleImagePath = bigArticleImagePath;
	}
	
	public String getSmallArticleImagePath() {
		return smallArticleImagePath;
	}
	
	public void setSmallArticleImagePath(String smallArticleImagePath) {
		this.smallArticleImagePath = smallArticleImagePath;
	}
	
	public String getThumbnailArticleImagePath() {
		return thumbnailArticleImagePath;
	}
	
	public void setThumbnailArticleImagePath(String thumbnailArticleImagePath) {
		this.thumbnailArticleImagePath = thumbnailArticleImagePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ArticleImage other = (ArticleImage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}