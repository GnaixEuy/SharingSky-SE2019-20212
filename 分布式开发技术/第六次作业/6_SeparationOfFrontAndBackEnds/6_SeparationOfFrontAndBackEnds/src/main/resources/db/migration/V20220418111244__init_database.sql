SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `aid`      int(11)     NOT NULL AUTO_INCREMENT,
    `aname`    varchar(20) NOT NULL,
    `password` varchar(20) NOT NULL,
    PRIMARY KEY (`aid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin`
VALUES ('1', 'wuxiaoyi', '123456');
INSERT INTO `admin`
VALUES ('2', 'shouting', '123456');
INSERT INTO `admin`
VALUES ('3', '张三', '123456');
INSERT INTO `admin`
VALUES ('4', 'GnaixEuy', '123456');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`
(
    `cid`    int(11)     NOT NULL AUTO_INCREMENT,
    `cname`  varchar(20) NOT NULL,
    `mobile` varchar(20) DEFAULT NULL,
    `status` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`cid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer`
VALUES ('1', '张三', '13333333344', '正常');
INSERT INTO `customer`
VALUES ('2', '李四', '13855555555', '冻结');
INSERT INTO `customer`
VALUES ('3', '王五', '13766666666', '正常');
INSERT INTO `customer`
VALUES ('4', '柳七', '13877777777', '正常');
INSERT INTO `customer`
VALUES ('5', '陈六', '13767676767', '正常');

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail`
(
    `did`    int(11) NOT NULL AUTO_INCREMENT,
    `oid`    int(11) NOT NULL,
    `gid`    int(11) NOT NULL,
    `count`  int(11) DEFAULT NULL COMMENT '购买数量',
    `amount` double  DEFAULT NULL COMMENT '单笔总价=数量*单价',
    PRIMARY KEY (`did`),
    KEY `fk_order` (`oid`),
    CONSTRAINT `fk_order` FOREIGN KEY (`oid`) REFERENCES `orderinfo` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail`
VALUES ('1', '1', '4', '2', '400');
INSERT INTO `detail`
VALUES ('2', '1', '6', '5', '400');
INSERT INTO `detail`
VALUES ('3', '2', '5', '10', '300');
INSERT INTO `detail`
VALUES ('4', '2', '2', '1', '128');
INSERT INTO `detail`
VALUES ('5', '2', '7', '6', '240');
INSERT INTO `detail`
VALUES ('6', '3', '8', '1', '7888');
INSERT INTO `detail`
VALUES ('7', '4', '1', '2', '2576');
INSERT INTO `detail`
VALUES ('8', '4', '3', '3', '600');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `gid`   int(11)     NOT NULL AUTO_INCREMENT,
    `gname` varchar(50) NOT NULL,
    `type`  varchar(20) NOT NULL COMMENT '类型',
    `price` double DEFAULT '0' COMMENT '单价',
    `date`  date   DEFAULT NULL COMMENT '上架日期',
    PRIMARY KEY (`gid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 26
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods`
VALUES ('1', 'VR头盔', '数码产品', '1267', '2018-05-11');
INSERT INTO `goods`
VALUES ('2', '腾讯会员', '虚拟产品', '128', '2018-05-08');
INSERT INTO `goods`
VALUES ('3', '运动衫', '服装', '200', '2018-05-12');
INSERT INTO `goods`
VALUES ('4', '电风扇', '家电', '200', '2018-05-02');
INSERT INTO `goods`
VALUES ('5', '刮胡刀', '日用品', '30', '2018-05-02');
INSERT INTO `goods`
VALUES ('6', '跑鞋', '服装', '80', '2018-05-10');
INSERT INTO `goods`
VALUES ('7', '游戏点卡', '虚拟产品', '40', '2018-05-09');
INSERT INTO `goods`
VALUES ('8', 'IPhoneX', '数码产品', '8888', '2018-05-07');
INSERT INTO `goods`
VALUES ('13', '三只松鼠', '食品', '20', '2020-07-08');
INSERT INTO `goods`
VALUES ('15', '篮球', '日用品', '120', '2020-07-08');
INSERT INTO `goods`
VALUES ('16', '三只松鼠', '食品', '30', '2020-07-13');
INSERT INTO `goods`
VALUES ('17', '肥宅快乐水', '食品', '3.5', '2020-05-10');
INSERT INTO `goods`
VALUES ('18', '拖把', '日用品', '20', '2020-12-23');
INSERT INTO `goods`
VALUES ('20', '可乐', '食品', '3', '2021-07-24');
INSERT INTO `goods`
VALUES ('21', '油条', '食品', '10', '2022-03-21');
INSERT INTO `goods`
VALUES ('23', '包子', '食品', '5', '2022-02-21');
INSERT INTO `goods`
VALUES ('25', '咖啡', '食品', '15', '2022-04-11');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`
(
    `oid`     int(11)     NOT NULL AUTO_INCREMENT,
    `orderNO` varchar(20) NOT NULL COMMENT '订单编号，由时间戳生成',
    `total`   double      NOT NULL COMMENT '总价',
    `cid`     int(11)     NOT NULL COMMENT '客户id',
    `status`  varchar(255) DEFAULT NULL COMMENT '订单状态',
    PRIMARY KEY (`oid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo`
VALUES ('1', '20180523162823', '800', '3', '已完成');
INSERT INTO `orderinfo`
VALUES ('2', '20180523164011', '668', '1', '2');
INSERT INTO `orderinfo`
VALUES ('3', '20180524204633', '7888', '2', '配送中');
INSERT INTO `orderinfo`
VALUES ('4', '20180527201222', '3176', '4', '配送中');
