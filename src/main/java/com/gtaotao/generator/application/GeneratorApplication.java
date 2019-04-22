package com.gtaotao.generator.application;

import com.gtaotao.generator.framework.Application;
import com.gtaotao.generator.task.*;

//程序入口
public class GeneratorApplication {
    public static void main(String[] args) {
        Application application = new Application(GeneratorApplication.class.getSimpleName());
        application.setApplicationName(GeneratorApplication.class.getName());

        //添加任务
        application.addTask(InitTask.class)
                .addTask(CombineTask.class)
                .addTask(EntityTask.class)
                .addTask(DaoTask.class)
                .addTask(MapperTask.class)
        .addTask(DaoImplTask.class);
              //  .addTask(VoTask.class);

        application.work();
    }
}
