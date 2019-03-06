package com.manage.service.system;

import com.manage.datasourceAnnotation.SourcesEnum;
import com.manage.datasourceAnnotation.TargetDataSource;
import com.manage.model.ResultMsg;
import com.manage.model.page.Page;
import com.manage.system.MenuManage;

import java.util.List;

public interface IMenuService {
    List<MenuManage> first(Integer parentId)throws  Exception;

    ResultMsg menuByParentId(Integer parentId)throws  Exception;

    ResultMsg selectMenuAll(Page page, MenuManage menuManage);

    ResultMsg selectMenuById(int id);

    @TargetDataSource(SourcesEnum.write)
    ResultMsg updateMenu(MenuManage menuManage);
    @TargetDataSource(SourcesEnum.write)
    ResultMsg addMenu(MenuManage menuManage);
    @TargetDataSource(SourcesEnum.write)
    ResultMsg delMenu(int id);
}
