package com.manage.dao.system;

import com.manage.system.MenuManage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuManageMapper {
    List<MenuManage> selectMenu();

    List<MenuManage> selectByParentId(Integer parentId);

    List<MenuManage> selectMenuAll(MenuManage menuManage);

    MenuManage selectMenuById(int id);

    int updateMenu(MenuManage menuManage);

    int addMenu(MenuManage menuManage);
    int delMenu(int id);

    MenuManage selectMenuByUrl(String url);
}
