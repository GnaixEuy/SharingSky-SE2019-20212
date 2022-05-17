SET FOREIGN_KEY_CHECKS = 0;

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
  DEFAULT CHARSET = utf8;

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
