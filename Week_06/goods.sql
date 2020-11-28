CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `phone` char(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `nickname` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `headimgurl` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `if_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用',
  `if_lock` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否被锁定（密码输入错误次数过多）',
  `last_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上一次登录时间',
  `pwd` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `salt` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '盐值',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间/注册时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

CREATE TABLE IF NOT EXISTS `brand`  (
  `id` bigint(20) NOT NULL,
  `chinese_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '品牌中文名',
  `logo_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'logo',
  `website` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '品牌网址',
  `remark` varchar(190) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '品牌描述',
  `if_show` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否显示 1:显示  0:隐藏',
  `rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `created_at` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='品牌表';

CREATE TABLE IF NOT EXISTS `category`  (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL DEFAULT 0 COMMENT '父级ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `level` int(4) NOT NULL COMMENT '类目级别',
  `remark` varchar(190) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '类别说明',
  `enable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态 1:启用  0:禁用',
  `created_at` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='分类表';

CREATE TABLE IF NOT EXISTS `spec_type`  (
  `id` bigint(20) NOT NULL,
  `specification_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格类型名称',
  `created_at` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='规格类型表';


CREATE TABLE IF NOT EXISTS `spec`  (
  `id` bigint(20) NOT NULL,
  `typeid` bigint(20) NOT NULL COMMENT '规格类型外键',
  `spec_name` varchar(190) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `specification` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规格值',
  `rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `created_at` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `typeid`(`typeid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='规格表';

CREATE TABLE IF NOT EXISTS `goods`  (
  `id` bigint(20) NOT NULL,
  `categoryid` bigint(20) NOT NULL COMMENT '类别外键',
  `brandid` bigint(20) NOT NULL COMMENT '品牌外键',
  `goods_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `goods_num` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品货号',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品简介',
  `actual_price` decimal(10, 2) NOT NULL COMMENT '实际售价',
  `market_price` decimal(10, 2) NOT NULL COMMENT '市场售价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `stock_warning` int(11) NOT NULL DEFAULT 0 COMMENT '库存预警',
  `weight` double NOT NULL DEFAULT 0 COMMENT '商品重量',
  `weight_unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '重量单位',
  `created_at` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`categoryid`) USING BTREE,
  INDEX `brand_id`(`brandid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='商品表';

CREATE TABLE IF NOT EXISTS `goods_detail`  (
  `id` bigint(20) NOT NULL,
  `goodsid` bigint(20) NOT NULL COMMENT '商品外键',
  `goods_detail_pc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品详细内容',
  `img` text COMMENT '商品图片',
  `created_at` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goods_id`(`goodsid`) USING BTREE,
  CONSTRAINT `goods_detail_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='商品详情表';



CREATE TABLE IF NOT EXISTS `goods_sku`  (
  `id` bigint(20) NOT NULL,
  `goodsid` bigint(20) NOT NULL COMMENT '商品外键',
  `sku_name` varchar(190) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'sku名称',
  `sell_price` decimal(10, 2) NOT NULL COMMENT '销售价',
  `market_price` decimal(10, 2) NOT NULL DEFAULT 0 COMMENT '市场价',
  `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存',
  `stock_warning` int(11) NOT NULL DEFAULT 0 COMMENT '库存预警',
  `sku_num` varchar(190) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'sku编号',
  `created_at` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `goods_sku_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='商品sku表';

CREATE TABLE IF NOT EXISTS `sku_goods_specification`  (
  `id` bigint(20) NOT NULL,
  `skuid` bigint(20) NOT NULL COMMENT 'sku外键',
  `goods_specid` bigint(20) NOT NULL COMMENT '商品规格值外键',
  `created_at` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_at` datetime(0) NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `skuid`(`skuid`) USING BTREE,
  INDEX `goods_specid`(`goods_specid`) USING BTREE,
  CONSTRAINT `sku_goods_spec_ibfk_2` FOREIGN KEY (`skuid`) REFERENCES `goods_sku` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sku_goods_spec_ibfk_1` FOREIGN KEY (`goods_specid`) REFERENCES `goods_specification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='sku规格值中间表';


CREATE TABLE `order` (
  `id` bigint(20) NOT NULL COMMENT '记录唯一标识',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL COMMENT '版本',
  `status` tinyint(4) NOT NULL COMMENT '订单状态',
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='订单';

CREATE TABLE `order` (
  `id` bigint(20) NOT NULL COMMENT '记录唯一标识',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL COMMENT '版本',
  `status` tinyint(4) NOT NULL COMMENT '订单状态',
  `user_id` bigint(20) NOT NULL,
  `total_price` decimal(18,4) NOT NULL COMMENT '总价',
  `total_freight` decimal(18,4) NOT NULL DEFAULT '0.0000' COMMENT '总运费',
  `order_identify` varchar(190) COLLATE utf8_unicode_ci NOT NULL COMMENT '订单号',
  `total_num` int(11) NOT NULL DEFAULT '0' COMMENT '总数量',
  `submit_order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交订单时间',
  `payment_time` timestamp NULL DEFAULT NULL COMMENT '付款时间',
  `transaction_complete_time` timestamp NULL DEFAULT NULL COMMENT '交易完成时间',
  `remark` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '留言备注',
  `province` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '省份',
  `city` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '市',
  `district` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '区',
  `street` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '街道',
  `address` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '地址',
  `phone` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '手机',
  `alternate_phone` varchar(190) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '备用手机',
  `address_type` int(4) NOT NULL DEFAULT '1' COMMENT '地址类型（1:家庭地址 2:工作地址 3:其他）',
  `invoice_type` int(4) DEFAULT NULL COMMENT '发票类型（1:纸质普通发票 2:电子普通发票 3:增值税专用发票）',
  `head_type` int(4) DEFAULT NULL COMMENT '发票抬头类型（1:个人 2:单位）',
  `head` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '抬头内容',
  `tax_identify` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '单位税号',
  `invoice_phone` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收票手机',
  `email` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='订单表';

CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL COMMENT '记录唯一标识',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  `version` bigint(20) NOT NULL COMMENT '版本',
  `goods_id` bigint(20) NOT NULL COMMENT '商品标识',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `price` decimal(18,4) NOT NULL DEFAULT '0.0000' COMMENT '商品单价',
  `sku_name` varchar(190) NOT NULL DEFAULT '' COMMENT 'sku名称',
  `skuid` bigint(20) DEFAULT NULL COMMENT 'skuID',
  `goods_no` varchar(100) DEFAULT NULL COMMENT '商品货号',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `goods_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细表';
