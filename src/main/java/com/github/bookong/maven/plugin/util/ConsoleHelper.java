package com.github.bookong.maven.plugin.util;

import org.apache.log4j.lf5.util.StreamUtils;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.wagon.util.IoUtils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @author Jiang Xu
 */
public class ConsoleHelper {

    public static String execCmd(Log logger, String cmd) throws Exception {
        StringBuilder result = new StringBuilder();

        Process process = null;
        BufferedReader reader = null;
        try {
            logger.info("exec cmd:" + cmd);
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null);
            reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            logger.info("wait for process done.");
            // 方法阻塞, 等待命令执行完成（成功会返回0）
            logger.info("read output.");
            String line;
            while((line = reader.readLine())!= null){
                result.append(line).append('\n');
            }
            process.waitFor();
            return result.toString();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    // nothing
                }
            }

            if (process != null) {
                process.destroy();
            }
        }
    }

}
