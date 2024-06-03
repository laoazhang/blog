package com.laoazhang.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author laoazhang
 * @Date 2024/6/3 16:21
 * @Description: 自定义注解监听器，注解生效就是依靠此类
 * @Version 1.0
 */
@Component
public class PermissionScanInitInstener implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PermissionScanInitInstener.class);


    private PermissionScan permissionScan;

    public PermissionScanInitInstener(PermissionScan permissionScan) {
        this.permissionScan = permissionScan;
    }

    @Override
    public void run(String... args) throws Exception {
        // 为了防止我们的代码比较复杂影响项目启动速度，我们创建线程来运行
        new Thread(new Runnable() {

            @Override
            public void run() {
                log.info("SpringBoot listener start...");
                // 执行permission数据添加方法
                permissionScan.scanPermission();
                log.info("SpringBoot listener stop...");
            }
        }).start();
    }
}
