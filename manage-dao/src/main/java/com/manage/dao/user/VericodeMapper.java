package com.manage.dao.user;

import com.manage.model.user.VeriCode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VericodeMapper {
    /**
     * 添加用户
     *
     * @param veriCode
     * @return
     */
    int addVericode(VeriCode veriCode);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<VeriCode> selectVericode(VeriCode veriCode);

    /**
     * 修改用户信息
     *
     * @param veriCode
     * @return
     */
    int updateVericode(VeriCode veriCode);



}
