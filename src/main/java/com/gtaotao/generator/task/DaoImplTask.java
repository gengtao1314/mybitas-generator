package com.gtaotao.generator.task;

import com.gtaotao.generator.framework.AbstractApplicationTask;
import com.gtaotao.generator.framework.context.ApplicationContext;
import com.gtaotao.generator.handler.BaseHandler;
import com.gtaotao.generator.handler.impl.DaoImplHandler;
import com.gtaotao.generator.model.DaoImplInfo;

import java.util.List;

/**
 * Created by gengtao on 2019/4/22.
 */
public class DaoImplTask extends AbstractApplicationTask {
    private static String DAO_FTL = "template/DaoImpl.ftl";

    private List<DaoImplInfo> daoImplInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成daoImpl");

        daoImplInfos = (List<DaoImplInfo>) context.getAttribute("daoIpmlList");

        BaseHandler<DaoImplInfo> handler = null;
        for (DaoImplInfo daoImplInfo : daoImplInfos) {
            handler = new DaoImplHandler(DAO_FTL, daoImplInfo);
            handler.execute();
        }

        logger.info("生成daoImpl完成");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
    }

}
