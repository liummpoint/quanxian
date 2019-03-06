package com.manage.model;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dan on 2015/7/30.
 */
public class PageInfoResult {
    public static ResultMsg PageInfoMsg(PageInfo pageInfo){
        ResultMsg rmsg = new ResultMsg();
        if(pageInfo==null){
            rmsg.setResult(false);
            rmsg.setMsg("数据未查到");
            return rmsg;
        }
        rmsg.setResult(true);
        if(pageInfo.getTotal()==0 || pageInfo.getList()==null || pageInfo.getList().size()==0){
            rmsg.setRows(new ArrayList<Object>());
        }else {
            rmsg.setRows(pageInfo.getList());
        }
        rmsg.setTotal(pageInfo.getTotal());
        return rmsg;
    }

    /**
     * jqGrid 前台所要的数据结构，与easyui 所要的不一样
     * @param pageInfo
     * @return
     */
    public static ResultMsg jqGridPageInfoMsg(PageInfo pageInfo){
        ResultMsg rmsg = new ResultMsg();
        if(pageInfo==null){
            rmsg.setResult(false);
            rmsg.setMsg("数据未查到");
            return rmsg;
        }
        rmsg.setResult(true);
        if(pageInfo.getList()==null || pageInfo.getList().size()==0){
            rmsg.setRows(new ArrayList<Object>());
        }else {
            rmsg.setRows(pageInfo.getList());
        }
        rmsg.setTotal(pageInfo.getPages());
        rmsg.setRecords((int)pageInfo.getTotal());

        return rmsg;
    }
    
    public static ResultMsg PageInfoMsg(List list , int total){
        ResultMsg rmsg = new ResultMsg();
        if(list == null){
            rmsg.setResult(false);
            rmsg.setMsg("数据未查到");
            return rmsg;
        }
        rmsg.setResult(true);
        if(list.size()==0){
            rmsg.setRows(new ArrayList<Object>());
        }else {
            rmsg.setRows(list);
        }
        rmsg.setTotal(total);
        return rmsg;
    }
    
}
