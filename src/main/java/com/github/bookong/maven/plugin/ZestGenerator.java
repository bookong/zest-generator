package com.github.bookong.maven.plugin;

import com.github.bookong.maven.plugin.util.ConsoleHelper;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * mvn zest-generator:generate
 *
 * @author Jiang Xu
 */
@Mojo(name = "generate")
public class ZestGenerator extends AbstractMojo {

    /** 项目根目录 */
    @Parameter(property = "basedir")
    private String basedir;

    @Parameter(property = "project.build.outputDirectory")
    private String projectBuildOutputDirectory;

    /**
     * 通过javap命令分析java汇编指令 https://www.jianshu.com/p/6a8997560b05<br>
     * Javap反汇编的使用 https://www.jianshu.com/p/08a6bd8fe606
     */
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Jiang Xu:" + projectBuildOutputDirectory);
        try {
            String cmd = "javap -c -l " + projectBuildOutputDirectory + "\\com\\github\\bookong\\example\\zest\\springmvc\\controller\\MyBatisUserController.class";
            // String result = cmd;
            String result = ConsoleHelper.execCmd(getLog(), cmd);
            // String result = ConsoleHelper.execCmd("javap -version");
            getLog().info(result);
        } catch (Exception e) {
            getLog().error(e);
        }

    }
}
