/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : movie

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 14/06/2023 15:28:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `evaluateid` bigint(20) NOT NULL AUTO_INCREMENT,
  `movieid` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `evaluatetext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `evaluatetime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`evaluateid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES (1, 1, 'admin', 'aa', '2023-06-11 21:40:41');
INSERT INTO `evaluate` VALUES (2, 1, 'admin', '很好看，下次再来', '2023-06-11 21:42:56');
INSERT INTO `evaluate` VALUES (6, 1, 'throb', '很不错', '2023-06-14 15:12:56');
INSERT INTO `evaluate` VALUES (7, 14, 'throb', '很好看', '2023-06-14 15:15:55');

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `movieId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `director` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `actors` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `releasedate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `genres` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `durationminutes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `posterurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`movieId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES (1, '铃芽之旅', '新海诚', '岩户铃芽,宗像草太,大臣,岩户环,冈部稔,二之宫瑠美', '2023-03-24 00:00:00', '铃芽是一位生活在九州的一个宁静小镇上的17岁少女，某天她遇到了“正在找门”的旅行青年草太。跟随着他的脚步，铃芽来到了山上的废墟之地，她发现有一扇古老的门孤零零地伫立在那。铃芽仿佛被什么吸引了一般，将手伸向了那扇门……\r\n据说，灾祸将会从门的那一边降临于现世，所以草太作为将门锁上的“闭门师”在各地旅行。\r\n“铃芽，我喜欢”“至于你，碍事”\r\n大臣话音刚落，草太竟然变成了椅子！而且那是铃芽小时候妈妈作为生日礼物送给她的缺了一条腿的椅子。为了抓住大臣，草太以三条腿椅子的样子跑了出去，铃芽也慌忙地跟了上去。\r\n不久之后，日本各地的门开始一扇接一扇地打开。在不可思议的门和小猫的引导下，铃芽在九州、四国、关西，还有东京及日本列岛开始了“关门之旅”。途中铃芽得到了很多帮助，并且当她到达目的地时，她发现了一个被遗忘的真相。', '动漫', '0', 'http://localhost:9054/images/01.png', '120', '39.9');
INSERT INTO `movie` VALUES (2, '流浪地球2', '郭帆', '吴京,刘德华,李雪健,沙溢,宁理,王智,朱颜曼滋', '2023-01-22 00:00:00', '2044年至2058年，科学家们发现太阳正急速衰老、持续膨胀，数百年内将吞噬包括地球在内的整个太阳系。面临末日灾难与生命存续的双重挑战，联合政府成立，总部设立在美国纽约，但世界政局动荡不堪，人类纷纷自救但仍内斗不止，大大小小各种战争频发，伴随着重工业的无序扩张，世界一片荒芜，科技在重压下加速发展，人类转入以航天工业为主的计划经济社会，并举全球之力提出了数百个自救计划', '科幻、冒险、灾难', '0', 'http://localhost:9054/images/02.png', '156', '43.8');
INSERT INTO `movie` VALUES (3, '复仇者联盟4：终局之战', '凯文·费奇', '小罗伯特·唐尼,克里斯·埃文斯,马克·鲁法洛,克里斯·海姆斯沃斯,斯嘉丽·约翰逊,杰瑞米·雷纳', '2019-04-26 00:00:00', '来自泰坦星的灭霸为了解决宇宙资源匮乏、人口暴增的问题，集齐了所有无限宝石，一个响指成功地使全宇宙生命随机减半。\r\n宇宙由于灭霸的行动而变得满目疮痍，但是五年之后，被困在量子领域的蚁人意外回到现实世界，他的出现为幸存的复仇者点燃了希望。无论前方将遭遇怎样的后果，幸存的复仇者都必须在剩余盟友的帮助下再一次集结，以逆转灭霸的所作所为，彻底恢复宇宙的秩序', '剧情、动作、科幻、奇幻、冒险', '0', 'http://localhost:9054/images/03.png', '240', '38.99');
INSERT INTO `movie` VALUES (4, '阿凡达：水之道', '詹姆斯·卡梅隆', '萨姆·沃辛顿,佐伊·索尔达娜,西格妮·韦弗,史蒂芬·朗', '2022-12-16 00:00:00', '十多年过去了，曾经的截瘫的前海军士兵杰克·萨利（萨姆·沃辛顿饰）永久变身为拥有地球人基因和纳威人基因的“阿凡达”，并与奥马蒂卡亚部落的族长之女妮特丽（佐伊·索尔达娜饰）结为夫妇。杰克已经完全适应了他的新身体和族长的身份，并和奈蒂莉有了三个孩子，还收养了格蕾丝留下的女儿琪莉（西格妮·韦弗饰）。', '动作、科幻、冒险、奇幻', '0', 'http://localhost:9054/images/04.png', '90', '32.99');
INSERT INTO `movie` VALUES (5, '银河护卫队3', '詹姆斯·古恩', '克里斯·帕拉特,佐伊·索尔达娜,布莱德利·库珀,戴夫·巴蒂斯塔,范·迪塞尔', '2023-05-05 00:00:00', '银河护卫队成员们在“虚无知地”上安顿了下来。然而，由于火箭浣熊（布莱德利·库珀配音）的神秘往事侵扰，他们平静的生活很快被打破。“星爵”彼得·奎尔（克里斯·帕拉特饰）依然迷失在失去卡魔拉（佐伊·索尔达娜饰）的痛苦中，但是他必须团结起他的团队，前往执行一项危险的任务，只为营救火箭浣熊。如果这项任务失败，那么为人熟知的银河护卫队有可能就此走向终结', '科幻、动作、冒险', '0', 'http://localhost:9054/images/05.png', '125', '42.99');
INSERT INTO `movie` VALUES (6, '速度与激情10', '尼尔·H·莫瑞兹', '范·迪塞尔', '2023-05-19 00:00:00', '在完成了无数任务，克服了各种不可能的困难之后，唐老大（范·迪塞尔 Vin Diesel 饰）和他的家族以智慧、勇气和速度过五关斩六将，打败了一路上的所有敌人。如今，他们面对的是一名危险至极的对手：这个从过往阴影中浮出水面的具有致命威胁的人物，誓要报偿血海深仇，决心破坏这个家族，彻底摧毁唐老大所热爱的一切及其至亲至爱之人。', '动作、犯罪、剧情、惊悚', '0', ' http://localhost:9054/images/06.png', '129', '35.99');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `orderid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sessionid` int(11) NOT NULL,
  `seatidinfo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `seatinfo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` double NOT NULL,
  `userid` int(11) NOT NULL,
  `ordertime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('616236ebf9774e87ae063b1aa0627742', 1, '16879107,16879124,16879125', '1 排 9 座 ,2 排 10 座 ,2 排 11 座 ', 119.69999999999999, -1140203518, '2023-06-14 15:12:38');
INSERT INTO `orderinfo` VALUES ('a622920dcab948ef80426af8da8eab97', 1, '16879168,16879169,16879170', '5 排 6 座 ,5 排 7 座 ,5 排 8 座 ', 119.69999999999999, -318238719, '2023-06-14 14:58:35');
INSERT INTO `orderinfo` VALUES ('b57386e1e6254dfc951dc87a4b1994dc', 7, '16879152,16879153,16879154,16879155', '4 排 7 座 ,4 排 8 座 ,4 排 9 座 ,4 排 10 座 ', 144, -1140203518, '2023-06-14 15:15:38');
INSERT INTO `orderinfo` VALUES ('d57e31dc7622414e86dbd2b4eb7b2909', 1, '16879117', '2 排 4 座 ', 39.9, -1278734335, '2023-06-14 14:57:00');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `row1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `col` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `grow` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gcol` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES ('16879097', '1', '1', '1', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879099', '1', '2', '1', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879100', '1', '3', '1', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879101', '1', '4', '1', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879102', '1', '5', '1', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879103', '1', '6', '1', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879104', '1', '7', '1', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879105', '1', '8', '1', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879107', '1', '9', '1', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879113', '2', '1', '2', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879114', '2', '2', '2', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879116', '2', '3', '2', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879117', '2', '4', '2', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879118', '2', '5', '2', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879119', '2', '6', '2', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879120', '2', '7', '2', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879121', '2', '8', '2', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879122', '2', '9', '2', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879124', '2', '10', '2', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879125', '2', '11', '2', '15', '0', '0');
INSERT INTO `seat` VALUES ('16879128', '3', '1', '3', '1', '0', '0');
INSERT INTO `seat` VALUES ('16879129', '3', '2', '3', '2', '0', '0');
INSERT INTO `seat` VALUES ('16879130', '3', '3', '3', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879131', '3', '4', '3', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879133', '3', '5', '3', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879134', '3', '6', '3', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879135', '3', '7', '3', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879136', '3', '8', '3', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879137', '3', '9', '3', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879138', '3', '10', '3', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879139', '3', '11', '3', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879141', '3', '12', '3', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879142', '3', '13', '3', '15', '0', '0');
INSERT INTO `seat` VALUES ('16879143', '3', '14', '3', '16', '0', '0');
INSERT INTO `seat` VALUES ('16879144', '3', '15', '3', '17', '0', '0');
INSERT INTO `seat` VALUES ('16879145', '4', '1', '4', '1', '0', '0');
INSERT INTO `seat` VALUES ('16879146', '4', '2', '4', '2', '0', '0');
INSERT INTO `seat` VALUES ('16879147', '4', '3', '4', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879148', '4', '4', '4', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879150', '4', '5', '4', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879151', '4', '6', '4', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879152', '4', '7', '4', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879153', '4', '8', '4', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879154', '4', '9', '4', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879155', '4', '10', '4', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879156', '4', '11', '4', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879158', '4', '12', '4', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879159', '4', '13', '4', '15', '0', '0');
INSERT INTO `seat` VALUES ('16879160', '4', '14', '4', '16', '0', '0');
INSERT INTO `seat` VALUES ('16879161', '4', '15', '4', '17', '0', '0');
INSERT INTO `seat` VALUES ('16879162', '5', '1', '5', '1', '0', '0');
INSERT INTO `seat` VALUES ('16879163', '5', '2', '5', '2', '0', '0');
INSERT INTO `seat` VALUES ('16879164', '5', '3', '5', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879165', '5', '4', '5', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879167', '5', '5', '5', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879168', '5', '6', '5', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879169', '5', '7', '5', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879170', '5', '8', '5', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879171', '5', '9', '5', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879172', '5', '10', '5', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879173', '5', '11', '5', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879175', '5', '12', '5', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879176', '5', '13', '5', '15', '0', '0');
INSERT INTO `seat` VALUES ('16879177', '5', '14', '5', '16', '0', '0');
INSERT INTO `seat` VALUES ('16879178', '5', '15', '5', '17', '0', '0');
INSERT INTO `seat` VALUES ('16879196', '6', '1', '7', '1', '0', '0');
INSERT INTO `seat` VALUES ('16879197', '6', '2', '7', '2', '0', '0');
INSERT INTO `seat` VALUES ('16879198', '6', '3', '7', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879199', '6', '4', '7', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879201', '6', '5', '7', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879202', '6', '6', '7', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879203', '6', '7', '7', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879204', '6', '8', '7', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879205', '6', '9', '7', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879206', '6', '10', '7', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879207', '6', '11', '7', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879209', '6', '12', '7', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879210', '6', '13', '7', '15', '0', '0');
INSERT INTO `seat` VALUES ('16879211', '6', '14', '7', '16', '0', '0');
INSERT INTO `seat` VALUES ('16879212', '6', '15', '7', '17', '0', '0');
INSERT INTO `seat` VALUES ('16879213', '7', '1', '8', '1', '0', '0');
INSERT INTO `seat` VALUES ('16879214', '7', '2', '8', '2', '0', '0');
INSERT INTO `seat` VALUES ('16879215', '7', '3', '8', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879216', '7', '4', '8', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879218', '7', '5', '8', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879219', '7', '6', '8', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879220', '7', '7', '8', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879221', '7', '8', '8', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879222', '7', '9', '8', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879223', '7', '10', '8', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879224', '7', '11', '8', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879226', '7', '12', '8', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879227', '7', '13', '8', '15', '0', '0');
INSERT INTO `seat` VALUES ('16879228', '7', '14', '8', '16', '0', '0');
INSERT INTO `seat` VALUES ('16879229', '7', '15', '8', '17', '0', '0');
INSERT INTO `seat` VALUES ('16879230', '8', '1', '9', '1', '0', '0');
INSERT INTO `seat` VALUES ('16879231', '8', '2', '9', '2', '0', '0');
INSERT INTO `seat` VALUES ('16879232', '8', '3', '9', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879233', '8', '4', '9', '4', '0', '0');
INSERT INTO `seat` VALUES ('16879235', '8', '5', '9', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879236', '8', '6', '9', '7', '0', '0');
INSERT INTO `seat` VALUES ('16879237', '8', '7', '9', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879238', '8', '8', '9', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879239', '8', '9', '9', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879240', '8', '10', '9', '11', '0', '0');
INSERT INTO `seat` VALUES ('16879241', '8', '11', '9', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879243', '8', '12', '9', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879244', '8', '13', '9', '15', '0', '0');
INSERT INTO `seat` VALUES ('16879245', '8', '14', '9', '16', '0', '0');
INSERT INTO `seat` VALUES ('16879246', '8', '15', '9', '17', '0', '0');
INSERT INTO `seat` VALUES ('16879247', '9', '1', '10', '1', '0', '0');
INSERT INTO `seat` VALUES ('16879248', '9', '2', '10', '2', '2', '0');
INSERT INTO `seat` VALUES ('16879249', '9', '3', '10', '3', '0', '0');
INSERT INTO `seat` VALUES ('16879250', '9', '4', '10', '4', '2', '0');
INSERT INTO `seat` VALUES ('16879252', '9', '5', '10', '6', '0', '0');
INSERT INTO `seat` VALUES ('16879253', '9', '6', '10', '7', '2', '0');
INSERT INTO `seat` VALUES ('16879254', '9', '7', '10', '8', '0', '0');
INSERT INTO `seat` VALUES ('16879255', '9', '8', '10', '9', '0', '0');
INSERT INTO `seat` VALUES ('16879256', '9', '9', '10', '10', '0', '0');
INSERT INTO `seat` VALUES ('16879257', '9', '10', '10', '11', '2', '0');
INSERT INTO `seat` VALUES ('16879258', '9', '11', '10', '12', '0', '0');
INSERT INTO `seat` VALUES ('16879260', '9', '12', '10', '14', '0', '0');
INSERT INTO `seat` VALUES ('16879261', '9', '13', '10', '15', '2', '0');
INSERT INTO `seat` VALUES ('16879262', '9', '14', '10', '16', '0', '0');
INSERT INTO `seat` VALUES ('16879263', '9', '15', '10', '17', '2', '0');

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session`  (
  `sessionid` int(11) NOT NULL AUTO_INCREMENT,
  `movieid` int(11) NULL DEFAULT NULL,
  `site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sessionid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES (1, 1, '万达影院', '17:00', '1');
INSERT INTO `session` VALUES (2, 1, '中影影城', '12:00', '2');
INSERT INTO `session` VALUES (3, 1, '万科影院', '15:00', '1');
INSERT INTO `session` VALUES (4, 1, '万达影院', '10:00', '1');
INSERT INTO `session` VALUES (7, 14, '万达影院', '11:00', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `registrationdate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1158262786 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (-1140203518, 'throb', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2023-06-14 15:12:02');
INSERT INTO `user` VALUES (1, 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2023-06-11 21:40:41');

SET FOREIGN_KEY_CHECKS = 1;
