package com.gtaotao.generator.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.gtaotao.generator.model.DaoImplInfo;
import com.gtaotao.generator.model.DaoInfo;
import com.gtaotao.generator.util.PropertyUtil;
import com.gtaotao.generator.Constants;
import com.gtaotao.generator.config.Configuration;
import com.gtaotao.generator.framework.AbstractApplicationTask;
import com.gtaotao.generator.framework.context.ApplicationContext;
import com.gtaotao.generator.handler.BaseHandler;
import com.gtaotao.generator.handler.impl.EntityHandler;
import com.gtaotao.generator.model.EntityInfo;
import com.gtaotao.generator.model.VoInfo;

public class EntityTask extends AbstractApplicationTask {
    private static String ENTITY_FTL = "template/Entity.ftl";
    
    private List<EntityInfo> entityInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成实体");
        
        //获取实体信息
        entityInfos = (List<EntityInfo>) context.getAttribute("entityInfos");
        
        BaseHandler<EntityInfo> handler = null;
        for (EntityInfo entityInfo : entityInfos) {
            handler = new EntityHandler(ENTITY_FTL, entityInfo);
            handler.execute();
        }
        logger.info("生成实体类完成");
        return false;
    }
    
    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
        
        List<DaoInfo> daoList = new ArrayList<DaoInfo>();
        List<DaoImplInfo> daoImplInfoList = new ArrayList<>();
        List<VoInfo> voList = new ArrayList<VoInfo>();
        //组装Dao信息、组装Vo信息
        DaoInfo daoInfo = null;
        DaoImplInfo daoImplInfo = null;
        VoInfo voInfo = null;
        for (EntityInfo entityInfo : entityInfos) {
            daoInfo = new DaoInfo();
            daoInfo.setClassName(entityInfo.getEntityName() + Constants.DAO_SUFFIX);
            daoInfo.setEntityInfo(entityInfo);
            daoInfo.setImportStr("import " + entityInfo.getEntityPackage() + "." + entityInfo.getClassName() + ";");
            daoInfo.setPackageStr(Configuration.getString("dao.package"));
            daoList.add(daoInfo);

            daoImplInfo = new DaoImplInfo();
            daoImplInfo.setClassName(entityInfo.getEntityName() + Constants.DAO_IMPL_SUFFIX);
            daoImplInfo.setEntityInfo(entityInfo);
            daoImplInfo.setImportStr("import " + entityInfo.getEntityPackage() + "." + entityInfo.getClassName() + ";\r\n"
                                + "import " + daoInfo.getPackageStr() + "." + daoInfo.getClassName());
            daoImplInfo.setPackageStr(Configuration.getString("daoImpl.package"));
            daoImplInfoList.add(daoImplInfo);
            
            voInfo = new VoInfo();
            voInfo.setPackageStr(Configuration.getString("vo.package"));
            voInfo.setClassName(entityInfo.getEntityName() + Constants.VO_SUFFIX);
            voInfo.setEntityInfo(entityInfo);
            voList.add(voInfo);


        }
        
        context.setAttribute("daoList", daoList);
        context.setAttribute("voList", voList);
        context.setAttribute("daoIpmlList",daoImplInfoList);
    }
    
    public static void main(String[] args) {
        File file = new File("/D:\\devsoftware\\workspace\\winit-java-generator\\target\\classes\\template\\Entity.ftl");
        System.out.println(EntityTask.class.getClassLoader().getResource("").getPath());
        System.out.println(file.exists());
        
        PropertyUtil.setProperty("name", "qyk1");
        PropertyUtil.setProperty("NAME", "qyk22");
    }

}
