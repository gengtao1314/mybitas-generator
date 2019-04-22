package com.gtaotao.generator.handler.impl;

import com.gtaotao.generator.config.Configuration;
import com.gtaotao.generator.handler.BaseHandler;
import com.gtaotao.generator.model.DaoImplInfo;

import java.io.File;

/**
 * Created by gengtao on 2019/4/22.
 */
public class DaoImplHandler extends BaseHandler<DaoImplInfo> {
    public DaoImplHandler(String ftlName, DaoImplInfo info) {
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir")
                + File.separator + Configuration.getString("daoImpl.path")
                + File.separator + info.getClassName() + ".java";

    }

    @Override
    public void combineParams(DaoImplInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("className", info.getClassName());
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
    }
}
