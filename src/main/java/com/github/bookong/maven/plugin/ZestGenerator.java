package com.github.bookong.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * @author Jiang Xu
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.TEST)
public class ZestGenerator extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {

    }
}
