package com.gtaotao.generator.framework;

import com.gtaotao.generator.framework.context.ApplicationContext;

public interface ApplicationTask extends Skipable {

    boolean perform(ApplicationContext context) throws Exception;

    void initLogger(String applicationTaskId, String applicationId);
}
