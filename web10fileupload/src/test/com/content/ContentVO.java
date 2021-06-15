package test.com.content;

import java.util.Date;

public class ContentVO {

	private int contentNum;
	private String contentTitle;
	//private String contentDirector;
	private Date contentDate;
	private String contentPoint;
	private String contentReview;
	private String contentPeopleName;
	private int contentRating;
	private String contentRecommend;
	private String contentSnack;
	
	
	@Override
	public String toString() {
		return "ContentVO [contentNum=" + contentNum + ", contentTitle=" + contentTitle + ", contentDate=" + contentDate + ", contentPoint=" + contentPoint
				+ ", contentReview=" + contentReview + ", contentPeopleName=" + contentPeopleName + ", contentRating="
				+ contentRating + ", contentRecommend=" + contentRecommend + ", contentSnack=" + contentSnack + "]";
	}


	public int getContentNum() {
		return contentNum;
	}


	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}


	public String getContentTitle() {
		return contentTitle;
	}


	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}


//	public String getContentDirector() {
//		return contentDirector;
//	}
//
//
//	public void setContentDirector(String contentDirector) {
//		this.contentDirector = contentDirector;
//	}


	public Date getContentDate() {
		return contentDate;
	}


	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}


	public String getContentPoint() {
		return contentPoint;
	}


	public void setContentPoint(String contentPoint) {
		this.contentPoint = contentPoint;
	}


	public String getContentReview() {
		return contentReview;
	}


	public void setContentReview(String contentReview) {
		this.contentReview = contentReview;
	}


	public String getContentPeopleName() {
		return contentPeopleName;
	}


	public void setContentPeopleName(String contentPeopleName) {
		this.contentPeopleName = contentPeopleName;
	}


	public int getContentRating() {
		return contentRating;
	}


	public void setContentRating(int contentRating) {
		this.contentRating = contentRating;
	}


	public String getContentRecommend() {
		return contentRecommend;
	}


	public void setContentRecommend(String contentRecommend) {
		this.contentRecommend = contentRecommend;
	}


	public String getContentSnack() {
		return contentSnack;
	}


	public void setContentSnack(String contentSnack) {
		this.contentSnack = contentSnack;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentDate == null) ? 0 : contentDate.hashCode());
		//result = prime * result + ((contentDirector == null) ? 0 : contentDirector.hashCode());
		result = prime * result + contentNum;
		result = prime * result + ((contentPeopleName == null) ? 0 : contentPeopleName.hashCode());
		result = prime * result + ((contentPoint == null) ? 0 : contentPoint.hashCode());
		result = prime * result + contentRating;
		result = prime * result + ((contentRecommend == null) ? 0 : contentRecommend.hashCode());
		result = prime * result + ((contentReview == null) ? 0 : contentReview.hashCode());
		result = prime * result + ((contentSnack == null) ? 0 : contentSnack.hashCode());
		result = prime * result + ((contentTitle == null) ? 0 : contentTitle.hashCode());
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
		ContentVO other = (ContentVO) obj;
		if (contentDate == null) {
			if (other.contentDate != null)
				return false;
		} else if (!contentDate.equals(other.contentDate))
			return false;
//		if (contentDirector == null) {
//			if (other.contentDirector != null)
//				return false;
//		} else if (!contentDirector.equals(other.contentDirector))
//			return false;
		if (contentNum != other.contentNum)
			return false;
		if (contentPeopleName == null) {
			if (other.contentPeopleName != null)
				return false;
		} else if (!contentPeopleName.equals(other.contentPeopleName))
			return false;
		if (contentPoint == null) {
			if (other.contentPoint != null)
				return false;
		} else if (!contentPoint.equals(other.contentPoint))
			return false;
		if (contentRating != other.contentRating)
			return false;
		if (contentRecommend == null) {
			if (other.contentRecommend != null)
				return false;
		} else if (!contentRecommend.equals(other.contentRecommend))
			return false;
		if (contentReview == null) {
			if (other.contentReview != null)
				return false;
		} else if (!contentReview.equals(other.contentReview))
			return false;
		if (contentSnack == null) {
			if (other.contentSnack != null)
				return false;
		} else if (!contentSnack.equals(other.contentSnack))
			return false;
		if (contentTitle == null) {
			if (other.contentTitle != null)
				return false;
		} else if (!contentTitle.equals(other.contentTitle))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
