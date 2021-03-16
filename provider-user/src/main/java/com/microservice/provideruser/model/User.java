package com.microservice.provideruser.model;

/**
 * @ProjectName: springcloud
 * @Author: ZhangXiangQiang
 * @Create: 2021/3/16 15:36
 * @Description:
 */
public class User {
    private  String userName;
    private  Integer userAge;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
