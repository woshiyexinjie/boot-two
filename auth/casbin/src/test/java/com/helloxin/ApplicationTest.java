package com.helloxin;

import org.casbin.jcasbin.main.Enforcer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {


    @Autowired
    Enforcer enforcer;

    @Test
    public void testTrancferFicusAnnoToKakapo() throws Exception {



        System.out.println(execCmd("pwd",null));
//        ClassPathResource classPathResource = new ClassPathResource("casbincfg/basic_model.conf");
//        InputStream inputStream =classPathResource.getInputStream();
//        File file = ResourceUtils.getFile("casbincfg/basic_model.conf");
//        File file2 = ResourceUtils.getFile("casbincfg/basic_policy.csv");
//        Enforcer enforcer = new Enforcer(file.getCanonicalPath(), file2.getCanonicalPath());
        String sub = "alice";
        String obj = "data1";
        String act = "read";

        if (enforcer.enforce(sub, obj, act) == true) {
            System.out.println("permit alice to read data1");
        } else {
            System.out.println("deny the request, show an error");
        }
    }

    //获取shell执行结果
    public static String execCmd(String cmd, File dir) throws Exception {
        StringBuilder result = new StringBuilder();

        Process process = null;
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null, dir);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                result.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                result.append(line).append('\n');
            }

        } finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }

        // 返回执行结果
        return result.toString();
    }

    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }
}