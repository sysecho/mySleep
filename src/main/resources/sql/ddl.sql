SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;


CREATE TABLE `voice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `object_id` varchar(64) DEFAULT NULL COMMENT 'MongoDB中id',
  `name` varchar(50) DEFAULT NULL COMMENT 'MongoDB中名称',
  `content_type` varchar(128) DEFAULT NULL COMMENT '图片类型',
  `size` DECIMAL(10,2) DEFAULT NULL COMMENT '图片大小M',
  `data_id` varchar(50) DEFAULT NULL COMMENT '数据ID',
  `image_url` varchar(125) DEFAULT NULL COMMENT '数据ID',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `created_by` int(11) DEFAULT -1 COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '最后更新人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8