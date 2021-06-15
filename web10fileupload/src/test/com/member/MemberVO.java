package test.com.member;

//import java.util.Date;

public class MemberVO {
	
	private int memberNum;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberTel;
	private String memberBday;
	private String membership;
	private int memberPoint;
	private String memberNickname;
	private String memberGender;
	private String filename;
	
	
	

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((memberBday == null) ? 0 : memberBday.hashCode());
		result = prime * result + ((memberGender == null) ? 0 : memberGender.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberNickname == null) ? 0 : memberNickname.hashCode());
		result = prime * result + memberNum;
		result = prime * result + memberPoint;
		result = prime * result + ((memberPw == null) ? 0 : memberPw.hashCode());
		result = prime * result + ((memberTel == null) ? 0 : memberTel.hashCode());
		result = prime * result + ((membership == null) ? 0 : membership.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (memberBday == null) {
			if (other.memberBday != null)
				return false;
		} else if (!memberBday.equals(other.memberBday))
			return false;
		if (memberGender == null) {
			if (other.memberGender != null)
				return false;
		} else if (!memberGender.equals(other.memberGender))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberNickname == null) {
			if (other.memberNickname != null)
				return false;
		} else if (!memberNickname.equals(other.memberNickname))
			return false;
		if (memberNum != other.memberNum)
			return false;
		if (memberPoint != other.memberPoint)
			return false;
		if (memberPw == null) {
			if (other.memberPw != null)
				return false;
		} else if (!memberPw.equals(other.memberPw))
			return false;
		if (memberTel == null) {
			if (other.memberTel != null)
				return false;
		} else if (!memberTel.equals(other.memberTel))
			return false;
		if (membership == null) {
			if (other.membership != null)
				return false;
		} else if (!membership.equals(other.membership))
			return false;
		return true;
	}





	public String getFilename() {
		return filename;
	}





	public void setFilename(String filename) {
		this.filename = filename;
	}









	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberTel=" + memberTel + ", memberBday=" + memberBday
				+ ", membership=" + membership + ", memberPoint=" + memberPoint + ", memberNickname=" + memberNickname
				+ ", memberGender=" + memberGender + ", filename=" + filename + "]";
	}





	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberBday() {
		return memberBday;
	}
	public void setMemberBday(String memberBday) {
		this.memberBday = memberBday;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}





	

	
	
	
	
	
	
}
