package com.it.controller;


import com.it.bean.Admin;
import com.it.bean.Permisson;
import com.it.bean.Role;
import com.it.service.AdminService;
import com.it.service.PermissonService;
import com.it.service.RoleService;
import com.it.utils.PageUtil;
import com.it.utils.ResultCode;
import com.it.utils.ResultCommon;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Resource
    AdminService adminService;

    @Resource
    PermissonService permissonService;

    @Resource
    RoleService roleService;

    @ResponseBody
    @PostMapping("/admin_login")
    public ResultCommon AdminLogin(Admin admin, String admincode, HttpSession session){
      //  Admin admin1 = adminService.AdminLogin(admin);
        String code = (String) session.getAttribute("code");

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken uToken = new UsernamePasswordToken(admin.getAdmin_name(), admin.getAdmin_password());

        try {
            if(code.equalsIgnoreCase(admincode)){
                //Shiro完成登录：进行验证，报错返回首页，不报错到达成功页面。
                subject.login(uToken);
            }else{
                //验证码错误
                return ResultCommon.fail(ResultCode.CODE_FAIL);
            }
        } catch (UnknownAccountException e) {
            // 用户名或密码错误
            return ResultCommon.fail(ResultCode.LOGIN_FAIL);
        } catch (IncorrectCredentialsException e) {
            // 用户名或密码错误
            return ResultCommon.fail(ResultCode.LOGIN_FAIL);
        }catch (Exception ex){
            return ResultCommon.fail(ResultCode.LOGIN_FAIL);
        }

        Admin admin1 = adminService.GetAdminByAdminName(admin.getAdmin_name());

        List<Permisson> menus = permissonService.GetPermissonsByAdminId(admin1.getAdmin_id(), "menu");

        session.setAttribute("menus",menus);

        List<Role> roles = roleService.findRoleByAdmin_Id(admin1.getAdmin_id());

        session.setAttribute("roles",roles);

        session.setAttribute("loginAdmin",admin1);
        return ResultCommon.success(ResultCode.SUCCESS);
    }

    @ResponseBody
    @PutMapping("/admin_update/{admin_id}")
    public ResultCommon AdminUpdate(@PathVariable("admin_id") Integer admin_id,Admin admin,String admin_newPassword,HttpSession session){

        admin.setAdmin_id(admin_id);

        System.out.println(admin_newPassword);
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        int count=0;
        if(admin.getAdmin_password().equals("")){
            count=adminService.UpdateAdmin(admin);
        }else {
            if(admin.getAdmin_password().equals(loginAdmin.getAdmin_password())){
               admin.setAdmin_password(admin_newPassword);
                System.out.println(admin);
                count = adminService.UpdateAdmin(admin);
            }else {
                return ResultCommon.fail(ResultCode.REPASSWORD_ERROR);
            }
        }

        if(count>0){
            session.invalidate();
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }

    }

   @RequestMapping("/admin_page")
    public String AdminPage(@RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "pageIndex",required = false,defaultValue = "1")  Integer pageIndex,
                            Model model, HttpSession session){

        Map<String,Object> map=new HashMap<>();
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put(("pageSize"),pageSize);
        List<Admin> admins = adminService.GetAdminsPage(map);
        Integer allCount = adminService.GetAllCount();
        for (Admin admin : admins) {
            StringBuffer sb =new StringBuffer();
            List<Role> roles = roleService.findRoleByAdmin_Id(admin.getAdmin_id());
            for (Role role : roles) {
                sb.append(role.getR_name()).append(" ");
            }
            admin.setRoles(sb.toString());
        }
        PageUtil pageUtil=new PageUtil(pageIndex,pageSize,allCount,admins);

        model.addAttribute("pageUtil",pageUtil);
        return "adminManagePage";
    }



}
