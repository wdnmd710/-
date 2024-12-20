package com.project.template.utils;

import com.project.template.enums.RoleType;
import com.project.template.vo.SysMenuVO;

import java.util.Arrays;

public class RoleMenuUtils {

    private final static SysMenuVO[] ADMIN = {
            new SysMenuVO("首页", "/home", "Home", "el-icon-s-home", false, null),
            new SysMenuVO("通知管理", "/noticeManage", "NoticeManage", "el-icon-chat-line-round", false, null),
            new SysMenuVO("轮播图管理", "/bannerManage", "BannerManage", "el-icon-document-copy", false, null),
            new SysMenuVO("资讯管理", "/newsManage", "NewsManage", "el-icon-mobile", false, null),
            new SysMenuVO("友链管理", "/linkManage", "LinkManage", "el-icon-link", false, null),
            new SysMenuVO("考试管理", "/examManage", "ExamManage", "el-icon-document-remove", false, null),
            new SysMenuVO("试题管理", "/examQuestionManage", "ExamQuestionManage", "el-icon-s-home", false, null),
            new SysMenuVO("成绩管理", "/scoreManage", "ScoreManage", "el-icon-tickets", false, null),
            new SysMenuVO("系统管理", "", "", "el-icon-setting", true,
                    Arrays.asList(
                            new SysMenuVO("角色管理", "/sysRoleManage", "SysRoleManage", "el-icon-user", false, null),
                            new SysMenuVO("用户信息", "/sysUserManage", "SysUserManage", "el-icon-user-solid", false, null))
            )
    };

    private final static SysMenuVO[] TEACHER = {
            new SysMenuVO("首页", "/home", "Home", "el-icon-s-home", false, null),
            new SysMenuVO("考试管理", "/examManage", "ExamManage", "el-icon-document-remove", false, null),
            new SysMenuVO("试题管理", "/examQuestionManage", "ExamQuestionManage", "el-icon-s-home", false, null),
            new SysMenuVO("成绩管理", "/scoreManage", "ScoreManage", "el-icon-tickets", false, null),
            new SysMenuVO("系统管理", "", "", "el-icon-setting", true,
                    Arrays.asList(
                            new SysMenuVO("用户信息", "/sysUserManage", "SysUserManage", "el-icon-user-solid", false, null))
            )
    };

    private final static SysMenuVO[] USER = {

    };


    public static SysMenuVO[] getRoleMenu(String role) {
        //管理员
        if (RoleType.ADMIN.getKey().equals(role)) {
            return ADMIN;
        }
        if (RoleType.TEACHER.getKey().equals(role)) {
            return TEACHER;
        }

        return null;
    }
}
