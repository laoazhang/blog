package com.laoazhang.auth;

import cn.hutool.core.util.ClassUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.laoazhang.mapper.PermissionMapper;
import com.laoazhang.system.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author laoazhang
 * @CreateTime 2024/6/3 15:38
 * @Description: 初始化权限类
 * @Version 1.0
 */
@Component
public class PermissionScan {

    // 扫描路径包前缀
    private static final String PKG_PREFIX = "com.laoazhang";

    // 扫描路径包后缀
    private static final String PKG_SUFFIX = ".controller";

    private PermissionMapper permissionMapper;

    public PermissionScan(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }


//    public void scanPermissionBefore() {
//        String[] paths = {"/D:/GitHubProject/blog/blog-modules/blog-article/target/classes/com/laoazhang/",
//                "/D:/GitHubProject/blog/blog-modules/blog-system/target/classes/com/laoazhang/",
//                "/D:/GitHubProject/blog/blog-modules/blog-user/target/classes/com/laoazhang/"};
//        for (String path : paths) {
//            scanPermission(path);
//        }
//    }

    public void scanPermission() {
        // 1.获取com.laoazhang下面所有的模块目录

        // 获取当前JVM的类路径
//        String classPath = System.getProperty("java.class.path");
//        System.out.println("Classpath: " + classPath);

        // 分割类路径，以识别多个模块
//        String[] classPathEntries = classPath.split(System.getProperty("path.separator"));

        // 打印每个模块的路径
//        for (String entry : classPathEntries) {
//            System.out.println("Module path: " + entry);
//        }

//
//        ClassLoader classLoader = PermissionScan.class.getClassLoader();
//
//        URL url = classLoader.getResource("");
//
//        String absolutePath = url.getPath();
//        String modulePath = absolutePath.substring(0, absolutePath.indexOf("/target"));


        String path = this.getClass().getResource("/").getPath() + "com/laoazhang/";
        String newPath = path.replace("blog-admin","blog-modules/blog-system");
        File file = new File(newPath);
        File[] files = file.listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });

        // 2.获取com.laoazhang.*.controller里面所有的类
        Set<Class> clazzes = new HashSet<>();
        for (File fileTmp : files) {
            Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(PKG_PREFIX + PKG_SUFFIX, RestController.class);
            clazzes.addAll(classes);
        }

        // 3.遍历获取的每个类
        for (Class clazz : clazzes) {
            // 3.1得到类中的所有方法，如果类中没有方法那么结束本次循环
            Method[] methods = clazz.getMethods();
            if (methods == null || methods.length < 1) {
                return;
            }

            // 3.2遍历类中的所有方法
            for (Method method : methods) {
                // 1.得到该方法的请求地址
                String uri = getUri(clazz, method);
                try {
                    // 2.获取到类上我们的自定义注解，判断如果没有结束本次循环
                    PermissionScanAnno permissionScanAnnoAnno = method.getAnnotation(PermissionScanAnno.class);
                    if (permissionScanAnnoAnno == null) {
                        continue;
                    }
                    // 3.得到我们自定义注解中的name和sn
                    String name = permissionScanAnnoAnno.name();
                    String permissionSn = permissionScanAnnoAnno.sn();
                    // 4.根据sn编码查询权限对象
                    Permission permissionTmp = permissionMapper.selectBySn(permissionSn);
//                    Permission permissionTmp = permissionMapper.selectOne(new QueryWrapper<Permission>().eq("sn", permissionSn));
                    // 5.如果不存在就添加权限
                    if (permissionTmp == null) {
                        Permission permission = new Permission();
                        permission.setName(name);
                        permission.setSn(permissionSn);
                        permission.setUrl(uri);
                        permissionMapper.insert(permission);
                    } else { // 6.如果存在就修改权限
                        permissionTmp.setName(name);
                        permissionTmp.setSn(permissionSn);
                        permissionTmp.setUrl(uri);
                        permissionMapper.update(permissionTmp, new UpdateWrapper<Permission>().eq("id", permissionTmp.getId()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param clazz:  类字节码对象
     * @param method: 方法对象
     * @Description: 根据类的字节码和类的方法得到方法的请求地址
     * @Author: July
     * @Date: 2022/7/10 23:37
     * @return: java.lang.String
     **/
    private String getUri(Class clazz, Method method) {
        String classPath = "";
        Annotation annotation = clazz.getAnnotation(RequestMapping.class);
        if (annotation != null) {
            RequestMapping requestMapping = (RequestMapping) annotation;
            String[] values = requestMapping.value();
            if (values != null && values.length > 0) {
                classPath = values[0];
                if (!"".equals(classPath) && !classPath.startsWith("/")) {
                    classPath = "/" + classPath;
                }
            }
        }
        GetMapping getMapping = method.getAnnotation(GetMapping.class);
        String methodPath = "";
        if (getMapping != null) {
            String[] values = getMapping.value();
            if (values != null && values.length > 0) {
                methodPath = values[0];
                if (!"".equals(methodPath) && !methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
            }
        }
        PostMapping postMapping = method.getAnnotation(PostMapping.class);
        if (postMapping != null) {
            String[] values = postMapping.value();
            if (values != null && values.length > 0) {
                methodPath = values[0];
                if (!"".equals(methodPath) && !methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
            }
        }
        DeleteMapping deleteMapping = method.getAnnotation(DeleteMapping.class);
        if (deleteMapping != null) {
            String[] values = deleteMapping.value();
            if (values != null && values.length > 0) {
                methodPath = values[0];
                if (!"".equals(methodPath) && !methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
            }
        }
        PutMapping putMapping = method.getAnnotation(PutMapping.class);
        if (putMapping != null) {
            String[] values = putMapping.value();
            if (values != null && values.length > 0) {
                methodPath = values[0];
                if (!"".equals(methodPath) && !methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
            }

        }
        PatchMapping patchMapping = method.getAnnotation(PatchMapping.class);
        if (patchMapping != null) {
            String[] values = patchMapping.value();
            if (values != null && values.length > 0) {
                methodPath = values[0];
                if (!"".equals(methodPath) && !methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
            }
        }
        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
        if (requestMapping != null) {
            String[] values = requestMapping.value();
            if (values != null && values.length > 0) {
                methodPath = values[0];
                if (!"".equals(methodPath) && !methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
            }
        }
        return classPath + methodPath;
    }


}
