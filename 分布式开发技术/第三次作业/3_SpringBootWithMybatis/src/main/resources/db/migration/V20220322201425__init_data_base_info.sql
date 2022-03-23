SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
                            `cid` int NOT NULL AUTO_INCREMENT,
                            `cname` varchar(20) NOT NULL,
                            `mobile` varchar(20) DEFAULT NULL,
                            `status` varchar(20) DEFAULT NULL,
                            PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO `customer` (`cid`, `cname`, `mobile`, `status`) VALUES (1, '张三', '13333333344', '正常');
INSERT INTO `customer` (`cid`, `cname`, `mobile`, `status`) VALUES (2, '李四', '13855555555', '冻结');
INSERT INTO `customer` (`cid`, `cname`, `mobile`, `status`) VALUES (3, '王五', '13766666666', '正常');
INSERT INTO `customer` (`cid`, `cname`, `mobile`, `status`) VALUES (4, '柳七', '13877777777', '正常');
COMMIT;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
                         `gid` int NOT NULL AUTO_INCREMENT,
                         `gname` varchar(50) NOT NULL,
                         `type` varchar(20) DEFAULT NULL COMMENT '类型',
                         `price` double DEFAULT '0' COMMENT '单价',
                         `date` date DEFAULT NULL COMMENT '上架日期',
                         PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (1, 'VR头盔', '数码产品', 1267, '2018-05-11');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (2, '腾讯会员', '虚拟产品', 128, '2018-05-08');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (3, '运动衫', '服装', 200, '2018-05-12');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (4, '电风扇', '家电', 200, '2018-05-02');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (5, '刮胡刀', '日用品', 30, '2018-05-02');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (6, '跑鞋', '服装', 80, '2018-05-10');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (7, '游戏点卡', '虚拟产品', 40, '2018-05-09');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (8, 'IPhoneX', '数码产品', 8888, '2018-05-07');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (13, '三只松鼠', '食品', 20, '2020-07-08');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (15, '篮球', '日用品', 120, '2020-07-08');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (16, '三只松鼠', '食品', 30, '2020-07-13');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (17, '肥宅快乐水', '食品', 3.5, '2020-05-10');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (18, '拖把', '日用品', 20, '2020-12-23');
INSERT INTO `goods` (`gid`, `gname`, `type`, `price`, `date`) VALUES (20, '可乐', '食品', 3, '2021-07-24');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
