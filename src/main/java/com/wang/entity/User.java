package com.wang.entity;

import java.util.Date;

public class User {
    /**
     * ID
     */
    private Integer id;

    /**
     * �ʺ�
     */
    private String account;

    /**
     * ����
     */
    private String password;

    /**
     * �ǳ�
     */
    private String username;

    /**
     * ע��ʱ��
     */
    private Date regtime;

    /**
     * ��ȡID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ����ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��ȡ�ʺ�
     *
     * @return account - �ʺ�
     */
    public String getAccount() {
        return account;
    }

    /**
     * �����ʺ�
     *
     * @param account �ʺ�
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * ��ȡ����
     *
     * @return password - ����
     */
    public String getPassword() {
        return password;
    }

    /**
     * ��������
     *
     * @param password ����
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ȡ�ǳ�
     *
     * @return username - �ǳ�
     */
    public String getUsername() {
        return username;
    }

    /**
     * �����ǳ�
     *
     * @param username �ǳ�
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ��ȡע��ʱ��
     *
     * @return regtime - ע��ʱ��
     */
    public Date getRegtime() {
        return regtime;
    }

    /**
     * ����ע��ʱ��
     *
     * @param regtime ע��ʱ��
     */
    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }
}