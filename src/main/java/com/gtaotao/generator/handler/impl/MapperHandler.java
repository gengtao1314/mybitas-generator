package com.gtaotao.generator.handler.impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import com.gtaotao.generator.handler.BaseHandler;
import com.gtaotao.generator.config.Configuration;
import com.gtaotao.generator.model.MapperInfo;

public class MapperHandler extends BaseHandler<MapperInfo> {
    public MapperHandler(String ftlName, MapperInfo info) {
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") 
                + File.separator + Configuration.getString("mapperXml.path")
                + File.separator + info.getFileName() + ".xml";
        
    }
    
    @Override
    public void combineParams(MapperInfo info) {
      //<result column="SU_ROUTE_CODE" jdbcType="VARCHAR" property="suRouteCode" />
        this.param.put("namespace", info.getNamespace());
        this.param.put("entityType", info.getEntityInfo().getPackageClassName());
        this.param.put("tableName", info.getEntityInfo().getTableName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
        
        StringBuilder resultMap = new StringBuilder();
        StringBuilder insertIfColumns = new StringBuilder();
        StringBuilder insertIfProps = new StringBuilder();
        StringBuilder updateColProps = new StringBuilder();
        StringBuilder selectSql = new StringBuilder();
        //resultMap
        Map<String, String> propJdbcTypes = info.getEntityInfo().getPropJdbcTypes();
        for (Entry<String, String> entry : info.getEntityInfo().getPropNameColumnNames().entrySet()) {
            String propName = entry.getKey();
            String columnName = entry.getValue().toLowerCase();
            if(!"id".equals(propName)){
                resultMap.append("    <result column=\"").append(columnName).append("\" jdbcType=\"")
                        .append(propJdbcTypes.get(propName)).append("\" property=\"").append(propName)
                        .append("\" />\r\n");

                if(propJdbcTypes.get(propName).equals("VARCHAR")){
                    updateColProps.append("             <if test=\"i.").append(propName).append(" != null and i.").append(propName).append(" != ''\">\r\n                    ").append(columnName).append(" = #{i.")
                            .append(propName).append("},\r\n").append("             </if>\r\n");

                    insertIfColumns.append("                <if test=\"i.").append(propName).append(" != null and i.").append(propName).append(" != ''\">\r\n                   ").append(columnName).append(",\r\n")
                            .append("               </if>\r\n");

                    insertIfProps.append("              <if test=\"i.").append(propName).append(" != null and i.").append(propName).append(" != ''\">\r\n                 ").append("{i.").append(propName).append("},\r\n")
                            .append("               </if>\r\n");
                }else{
                    updateColProps.append("             <if test=\"").append(propName).append(" != null\">\r\n                   ").append(columnName).append(" = #{")
                            .append(propName).append("},\r\n").append("             </if>\r\n");

                    insertIfColumns.append("                <if test=\"i.").append(propName).append(" != null\"> \r\n                   ").append(columnName).append(",\r\n")
                            .append("               </if>\r\n");

                    insertIfProps.append("              <if test=\"i.").append(propName).append(" != null\">\r\n                  ").append("{i.").append(propName).append("},\r\n")
                            .append("               </if>\r\n");
                }
            }

            selectSql.append("           <if test= ").append(propName).append(" != null\"> \r\n                ").append("AND ").append(columnName).append(" = {").append(propName).append("}\r\n")
                    .append("           </if>\r\n");

        }
        this.param.put("resultMap", resultMap.toString());
        this.param.put("insertIfColumns", insertIfColumns.substring(0,insertIfColumns.length()-1));
        this.param.put("insertIfProps", insertIfProps.toString());
        this.param.put("updateColProps", updateColProps.toString());
        this.param.put("selectSql", selectSql.toString());
    }

}
