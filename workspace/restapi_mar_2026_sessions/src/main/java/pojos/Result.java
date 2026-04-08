package pojos;

import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName("sys_id")
	private String sysId;
	@SerializedName("opened_by")
	private OpenedBy openedBy;

	public OpenedBy getOpenedBy() {
		return openedBy;
	}

	public void setOpenedBy(OpenedBy openedBy) {
		this.openedBy = openedBy;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

}