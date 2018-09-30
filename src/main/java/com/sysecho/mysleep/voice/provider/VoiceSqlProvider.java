package com.sysecho.mysleep.voice.provider;

import org.apache.ibatis.jdbc.SQL;

import com.sysecho.mysleep.voice.entity.Voice;

public class VoiceSqlProvider {

    public String insertSelective(Voice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("voice");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getObjectId() != null) {
            sql.VALUES("object_id", "#{objectId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContentType() != null) {
            sql.VALUES("content_type", "#{contentType,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            sql.VALUES("size", "#{size,jdbcType=DOUBLE}");
        }
        
        if (record.getDataId() != null) {
            sql.VALUES("data_id", "#{dataId,jdbcType=VARCHAR}");
        }
        
        if (record.getImageUrl() != null) {
            sql.VALUES("image_url", "#{imageUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedDate() != null) {
            sql.VALUES("created_date", "#{createdDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatedBy() != null) {
            sql.VALUES("created_by", "#{createdBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.VALUES("update_by", "#{updateBy,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Voice record) {
        SQL sql = new SQL();
        sql.UPDATE("voice");
        
        if (record.getObjectId() != null) {
            sql.SET("object_id = #{objectId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContentType() != null) {
            sql.SET("content_type = #{contentType,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            sql.SET("size = #{size,jdbcType=DOUBLE}");
        }
        
        if (record.getDataId() != null) {
            sql.SET("data_id = #{dataId,jdbcType=VARCHAR}");
        }
        
        if (record.getImageUrl() != null) {
            sql.SET("image_url = #{imageUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedDate() != null) {
            sql.SET("created_date = #{createdDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatedBy() != null) {
            sql.SET("created_by = #{createdBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{updateBy,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}