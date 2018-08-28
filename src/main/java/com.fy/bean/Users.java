package com.fy.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Users extends PageInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String KEY = "USER_KEY";
	
    private String userId;

    private String userName;

    private String userPassword;

    private String mobile;

    private String telephone;

    private String country;

    private String province;

    private String city;

    private String area;

    private String addressDetail;

    private String wxAuthorizationSign;

    private String wbAuthorizationSign;

    private Integer age;

    private Integer marriage;

    private Date birth;

    private Date registrationTime;

    private String registrationIp;

    private Date lastUpdateTime;

    private Integer state;
    
    private Date lastLoginTime;
    
    private String name;
    
    private String verifyCode;
    
    private Integer verifyCodeType;
    
    private String newPassword;
    
    private String headImg;
    
    private String email;
    
    private Integer level;
    
    private Integer politicalOutlook;
    
    private String postTitle;
    
    private String bmId;//部门ID
    private String bmName;//部门名称
    private List<String> permissionList;//拥有权限数组
    private Integer colorType;//积分等级颜色
    private Double reputationValue;//信用积分
    private Integer reputationColorType;//信用等级颜色
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getWxAuthorizationSign() {
        return wxAuthorizationSign;
    }

    public void setWxAuthorizationSign(String wxAuthorizationSign) {
        this.wxAuthorizationSign = wxAuthorizationSign == null ? null : wxAuthorizationSign.trim();
    }

    public String getWbAuthorizationSign() {
        return wbAuthorizationSign;
    }

    public void setWbAuthorizationSign(String wbAuthorizationSign) {
        this.wbAuthorizationSign = wbAuthorizationSign == null ? null : wbAuthorizationSign.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getRegistrationIp() {
        return registrationIp;
    }

    public void setRegistrationIp(String registrationIp) {
        this.registrationIp = registrationIp == null ? null : registrationIp.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public Integer getVerifyCodeType() {
		return verifyCodeType;
	}

	public void setVerifyCodeType(Integer verifyCodeType) {
		this.verifyCodeType = verifyCodeType;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getBmId() {
		return bmId;
	}

	public void setBmId(String bmId) {
		this.bmId = bmId;
	}

	public String getBmName() {
		return bmName;
	}

	public void setBmName(String bmName) {
		this.bmName = bmName;
	}

	public List<String> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}

	public Integer getPoliticalOutlook() {
		return politicalOutlook;
	}

	public void setPoliticalOutlook(Integer politicalOutlook) {
		this.politicalOutlook = politicalOutlook;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Integer getColorType() {
		return colorType;
	}

	public void setColorType(Integer colorType) {
		this.colorType = colorType;
	}

	public Double getReputationValue() {
		return reputationValue;
	}

	public void setReputationValue(Double reputationValue) {
		this.reputationValue = reputationValue;
	}

	public Integer getReputationColorType() {
		return reputationColorType;
	}

	public void setReputationColorType(Integer reputationColorType) {
		this.reputationColorType = reputationColorType;
	}


}