<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${entityType}">
  <resultMap id="baseResultMap" type="${entityType}">
      <result column="id" property="id" jdbcType="NUMERIC" javaType="long"/>
${resultMap}
  </resultMap>
    <!-- 批量新增信息到数据库中 -->
    <insert id="batchInsert" parameterType="java.util.List">
        <foreach collection="list" item="i" separator=";">
            insert into ${tableName}
            <trim prefix="(" suffix=")" suffixOverrides=",">
${insertIfColumns}
            </trim>
            <trim prefix="values (" suffix=")" suffixOverrides=",">
${insertIfProps}
            </trim>
        </foreach>
    </insert>

    <update id="batchUpdate" parameterType="${entityType}">
        <foreach collection="list" item="i" index="index" separator=";">
            UPDATE ${tableName}
            <trim prefix="set" suffixOverrides=",">
${updateColProps}
            </trim>
            <trim prefix="where" prefixOverrides="AND|OR">
                <if test="i.id != null">
                    AND id = <#noparse>#{i.id}</#noparse>
                </if>
            </trim>
        </foreach>
    </update>

    <!-- 通过主键批量物理删除数据 -->
    <delete id="batchDeleteByIds" parameterType="java.util.List">
        DELETE FROM ${tableName} WHERE ID IN
        <foreach collection="list" item="i" open="(" separator="," close=")">
        <#noparse>#{i}</#noparse>
        </foreach>
    </delete>

    <!-- 通用脚本查询条件 -->
    <sql id="selectSql">
        <trim prefix="where" prefixOverrides="AND|OR">
${selectSql}
        </trim>
    </sql>

    <!-- 通过指定条件查询信息总数，用于分页展示 -->
    <select id="countByMap" parameterType="java.util.Map" resultType="int">
        SELECT count(id) FROM ${tableName}
        <include refid="selectSql"/>
    </select>

    <!-- 通过指定条件查询信息 -->
    <select id="selectByMap" parameterType="java.util.Map" resultMap="baseResultMap" resultType="${entityType}">
        SELECT * FROM ${tableName}
        <include refid="selectSql"/>
        <if test="orderBy != null">
            ORDER BY <#noparse>${orderBy}</#noparse>
        </if>
        <if test="order != null">
        <#noparse>${order}</#noparse>
        </if>
    </select>

    <!-- 通过指定条件查询信息总数，用于分页展示 -->
    <select id="selectByMapCount" parameterType="java.util.Map" resultType="int">
        SELECT count(id) FROM ${tableName}
        <include refid="selectSql"/>
    </select>
    <!-- 查询唯一的信息 -->
    <select id="selectUniqueByProp" parameterType="java.util.Map" resultMap="baseResultMap" resultType="${entityType}">
        SELECT * FROM ${tableName}
        <include refid="selectSql"/>
    </select>
</mapper>