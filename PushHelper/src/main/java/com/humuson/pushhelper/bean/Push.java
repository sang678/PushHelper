package com.humuson.pushhelper.bean;

import java.io.Serializable;

public class Push implements Serializable{
	private String biz_id;
	private String req_uid;
	private String msg_uid;
	private String cust_id;
	private String msg_type;
	private String push_title;
	private String push_msg;
	private String popup_content;
	private String inapp_content;
	private String reserve_time;
	private String reg_date;
	private String res_cd;
	private String res_date;
	private String info_na;
	private String info_cp;
	private String msg_grp_cd;
	private String expire_time;
	private String rtn_type;
	private String push_value;
	private int mb_seq;
	private int list_seq;
	private long seq;
	private int total;
	private int success;
	private int fail;
	private int read;
	private int click;
	private String smssend_check;
	
	
	public Push() {
	}
	
	//rawBean
	public Push(String req_uid, String cust_id) {
		this.req_uid = req_uid;
		this.cust_id = cust_id;
	}
	
	
	// T pm listBean
	public Push(String req_uid, String msg_type, String push_title,
			String push_msg, String inapp_content, int mb_seq, int total) {
		super();
		this.req_uid = req_uid;
		this.msg_type = msg_type;
		this.push_title = push_title;
		this.push_msg = push_msg;
		this.inapp_content = inapp_content;
		this.mb_seq = mb_seq;
		this.total = total;
	}


	// T p listBean
	public Push(String req_uid, String msg_type, String push_title,
			String push_msg, int mb_seq, int total) {
		super();
		this.req_uid = req_uid;
		this.msg_type = msg_type;
		this.push_title = push_title;
		this.push_msg = push_msg;
		this.mb_seq = mb_seq;
		this.total = total;
	}


	//T m listBean
	public Push(String req_uid, String msg_type, String inapp_content, int mb_seq, int total ) {
		super();
		this.req_uid = req_uid;
		this.msg_type = msg_type;
		this.inapp_content = inapp_content;
		this.mb_seq = mb_seq;
		this.total = total;
	}

	//H pm listBean
	public Push(int mb_seq, String req_uid, String msg_type, String push_title,
			String push_msg, String popup_content, String inapp_content,
			 int total) {
		super();
		this.mb_seq = mb_seq;
		this.req_uid = req_uid;
		this.msg_type = msg_type;
		this.push_title = push_title;
		this.push_msg = push_msg;
		this.popup_content = popup_content;
		this.inapp_content = inapp_content;
		this.total = total;
	}
	

	// H p listBean
	public Push(int mb_seq, String req_uid, String msg_type, String push_title,
			String push_msg, String popup_content, int total) {
		super();
		this.mb_seq = mb_seq;
		this.req_uid = req_uid;
		this.msg_type = msg_type;
		this.push_title = push_title;
		this.push_msg = push_msg;
		this.popup_content = popup_content;
		this.total = total;
	}

	
	// H m listBean
	public Push(int mb_seq, String req_uid, String msg_type, String inapp_content,
			 int total) {
		super();
		this.mb_seq = mb_seq;
		this.req_uid = req_uid;
		this.msg_type = msg_type;
		this.inapp_content = inapp_content;
		this.total = total;
	}


	// T pm pmslist
	public Push(String biz_id, String req_uid, String msg_uid,
			String cust_id, String msg_type, String push_title,
			String push_msg, String inapp_content, String info_na,
			String info_cp, String msg_grp_cd) {
		super();
		this.biz_id = biz_id;
		this.req_uid = req_uid;
		this.msg_uid = msg_uid;
		this.cust_id = cust_id;
		this.msg_type = msg_type;
		this.push_title = push_title;
		this.push_msg = push_msg;
		this.inapp_content = inapp_content;
		this.info_na = info_na;
		this.info_cp = info_cp;
		this.msg_grp_cd = msg_grp_cd;
	}
	
	//T p pmslist
	public Push(String biz_id, String req_uid, String msg_uid,
			String cust_id, String msg_type, String push_title,
			String push_msg, String info_na, String info_cp, String msg_grp_cd) {
		super();
		this.biz_id = biz_id;
		this.req_uid = req_uid;
		this.msg_uid = msg_uid;
		this.cust_id = cust_id;
		this.msg_type = msg_type;
		this.push_title = push_title;
		this.push_msg = push_msg;
		this.info_na = info_na;
		this.info_cp = info_cp;
		this.msg_grp_cd = msg_grp_cd;
	}
	
	//T m pmslist H m pmslist
	public Push(String biz_id, String req_uid, String msg_uid,
			String cust_id, String msg_type, String inapp_content,
			String info_na, String info_cp, String msg_grp_cd) {
		super();
		this.biz_id = biz_id;
		this.req_uid = req_uid;
		this.msg_uid = msg_uid;
		this.cust_id = cust_id;
		this.msg_type = msg_type;
		this.inapp_content = inapp_content;
		this.info_na = info_na;
		this.info_cp = info_cp;
		this.msg_grp_cd = msg_grp_cd;
	}
	
	//H pm pmslist
	public Push(String biz_id, String req_uid, String msg_uid,
			String cust_id, String msg_type, String push_title,
			String push_msg, String popup_content, String inapp_content,
			String info_na, String info_cp, String msg_grp_cd, String push_value) {
		this.biz_id = biz_id;
		this.req_uid = req_uid;
		this.msg_uid = msg_uid;
		this.cust_id = cust_id;
		this.msg_type = msg_type;
		this.push_title = push_title;
		this.push_msg = push_msg;
		this.popup_content = popup_content;
		this.inapp_content = inapp_content;
		this.info_na = info_na;
		this.info_cp = info_cp;
		this.msg_grp_cd = msg_grp_cd;
		this.push_value = push_value;
	}
	
	//H p pmslist
	public Push(String biz_id, String req_uid, String msg_uid,
				String cust_id, String msg_type, String push_title,
				String push_msg, String popup_content, String info_na,
				String info_cp, String msg_grp_cd, String push_value) {
			this.biz_id = biz_id;
			this.req_uid = req_uid;
			this.msg_uid = msg_uid;
			this.cust_id = cust_id;
			this.msg_type = msg_type;
			this.push_title = push_title;
			this.push_msg = push_msg;
			this.popup_content = popup_content;
			this.info_na = info_na;
			this.info_cp = info_cp;
			this.msg_grp_cd = msg_grp_cd;
			this.push_value = push_value;
		}

	
	
	
		


	public String getBiz_id() {
		return biz_id;
	}

	
	
	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}

	public String getRes_cd() {
		return res_cd;
	}

	public void setRes_cd(String res_cd) {
		this.res_cd = res_cd;
	}

	public void setBiz_id(String biz_id) {
		this.biz_id = biz_id;
	}
	public String getReq_uid() {
		return req_uid;
	}
	public void setReq_uid(String req_uid) {
		this.req_uid = req_uid;
	}
	public String getMsg_uid() {
		return msg_uid;
	}
	public void setMsg_uid(String msg_uid) {
		this.msg_uid = msg_uid;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getPush_title() {
		return push_title;
	}
	public void setPush_title(String push_title) {
		this.push_title = push_title;
	}
	public String getPush_msg() {
		return push_msg;
	}
	public void setPush_msg(String push_msg) {
		this.push_msg = push_msg;
	}
	public String getPopup_content() {
		return popup_content;
	}
	public void setPopup_content(String popup_content) {
		this.popup_content = popup_content;
	}
	public String getInapp_content() {
		return inapp_content;
	}
	public void setInapp_content(String inapp_content) {
		this.inapp_content = inapp_content;
	}
	public String getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getInfo_na() {
		return info_na;
	}
	public void setInfo_na(String info_na) {
		this.info_na = info_na;
	}
	public String getInfo_cp() {
		return info_cp;
	}
	public void setInfo_cp(String info_cp) {
		this.info_cp = info_cp;
	}
	public String getMsg_grp_cd() {
		return msg_grp_cd;
	}
	public void setMsg_grp_cd(String msg_grp_cd) {
		this.msg_grp_cd = msg_grp_cd;
	}
	public String getExpire_time() {
		return expire_time;
	}
	public void setExpire_time(String expire_time) {
		this.expire_time = expire_time;
	}

	public String getRtn_type() {
		return rtn_type;
	}

	public void setRtn_type(String rtn_type) {
		this.rtn_type = rtn_type;
	}

	public int getMb_seq() {
		return mb_seq;
	}

	public void setMb_seq(int mb_seq) {
		this.mb_seq = mb_seq;
	}

	public int getList_seq() {
		return list_seq;
	}

	public void setList_seq(int list_seq) {
		this.list_seq = list_seq;
	}
	
	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
	}

	

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}
	
	public String getPush_value() {
		return push_value;
	}


	public void setPush_value(String push_value) {
		this.push_value = push_value;
	}


	public String getSmssend_check() {
		return smssend_check;
	}

	public void setSmssend_check(String smssend_check) {
		this.smssend_check = smssend_check;
	}

	@Override
	public String toString() {
		return "Push [biz_id=" + biz_id + ", req_uid=" + req_uid + ", msg_uid="
				+ msg_uid + ", cust_id=" + cust_id + ", msg_type=" + msg_type
				+ ", push_title=" + push_title + ", push_msg=" + push_msg
				+ ", popup_content=" + popup_content + ", inapp_content="
				+ inapp_content + ", reserve_time=" + reserve_time
				+ ", reg_date=" + reg_date + ", res_cd=" + res_cd
				+ ", res_date=" + res_date + ", info_na=" + info_na
				+ ", info_cp=" + info_cp + ", msg_grp_cd=" + msg_grp_cd
				+ ", expire_time=" + expire_time + ", rtn_type=" + rtn_type
				+ ", push_value=" + push_value + ", mb_seq=" + mb_seq
				+ ", list_seq=" + list_seq + ", seq=" + seq + ", total="
				+ total + ", success=" + success + ", fail=" + fail + ", read="
				+ read + ", click=" + click + ", smssend_check="
				+ smssend_check + "]";
	}

	
	
}
