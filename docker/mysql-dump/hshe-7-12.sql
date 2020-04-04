-- MySQL dump 10.13  Distrib 5.6.36, for Linux (x86_64)
--
-- Host: localhost    Database: hshe
-- ------------------------------------------------------
-- Server version	5.6.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `hshe`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hshe` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hshe`;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `create_time` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'18信息1班','1516001859446'),(2,'18信息2班','1516001859446'),(3,'18软工1班','1516001859446'),(4,'18软工2班','1521453304189'),(5,'18软工3班','1521453304189');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes_topic`
--

DROP TABLE IF EXISTS `classes_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes_topic` (
  `classes_id` bigint(20) NOT NULL,
  `topic_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='班级-作业关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes_topic`
--

LOCK TABLES `classes_topic` WRITE;
/*!40000 ALTER TABLE `classes_topic` DISABLE KEYS */;
INSERT INTO `classes_topic` VALUES (2,11,13),(3,12,14),(4,13,15),(5,14,16),(3,15,17);
/*!40000 ALTER TABLE `classes_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(9999) DEFAULT NULL,
  `memory_limit` varchar(5) DEFAULT NULL,
  `time_limit` varchar(10) DEFAULT NULL,
  `creator` varchar(9) DEFAULT NULL,
  `create_time` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='题目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES (9,'A+B和C','给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。\n\n输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。\n\n对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。','64','1000','00079888','1522121719170'),(10,'数字分类','给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：\nA1 = 能被5整除的数字中所有偶数的和；\nA2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；\nA3 = 被5除后余2的数字的个数；\nA4 = 被5除后余3的数字的平均数，精确到小数点后1位；\nA5 = 被5除后余4的数字中最大数字。\n\n每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。\n\n对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。\n若其中某一类数字不存在，则在相应位置输出“N”。','64','1000','00079888','1522130345331'),(11,'去除空格','给定一个字符串，请你把这个字符串的所有空格都去掉并输出。\n\n包括字符串的首部和尾部的空格。','64','1000','00079888','1527530507884');
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siminfo`
--

DROP TABLE IF EXISTS `siminfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `siminfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source_sid` bigint(20) NOT NULL,
  `target_sid` bigint(20) DEFAULT NULL,
  `similarity` int(11) NOT NULL,
  `problem_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 COMMENT='相似度表-记录每个提交的最大相似';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siminfo`
--

LOCK TABLES `siminfo` WRITE;
/*!40000 ALTER TABLE `siminfo` DISABLE KEYS */;
INSERT INTO `siminfo` VALUES (9,54,0,0,9),(10,55,0,0,9),(11,56,0,0,10),(12,57,56,100,10),(13,58,0,0,10),(14,59,0,0,10),(15,61,0,0,10),(16,62,59,100,10),(17,63,59,100,10),(18,64,59,100,10),(19,65,59,100,10),(20,66,56,100,10),(21,72,55,100,9),(22,73,55,100,9),(23,74,0,0,9),(24,76,0,0,11),(25,78,76,100,11);
/*!40000 ALTER TABLE `siminfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` varchar(9) NOT NULL,
  `nickname` varchar(5) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `classes` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('180705201','吕尚霖','123456',NULL,2),('180705202','程禹皓','123456','tlyluvu@gmail.com',2),('180705203','郑华冬','123456',NULL,2),('180705204','刘进','123456',NULL,2),('180705205','王林阳','123456',NULL,2),('180705206','汪飞','123456',NULL,2),('180705207','李蕾','123456',NULL,2),('180705208','牛冬晓','123456',NULL,2),('180705209',NULL,'123456',NULL,2),('180705210',NULL,'123456',NULL,2),('180707101',NULL,'123456',NULL,3),('180707102',NULL,'123456',NULL,3),('180707103',NULL,'123456',NULL,3),('180707104',NULL,'123456',NULL,3);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `problem_id` bigint(20) NOT NULL,
  `user_id` varchar(9) NOT NULL,
  `lang` varchar(10) NOT NULL,
  `src` varchar(9999) DEFAULT NULL,
  `create_time` varchar(15) NOT NULL,
  `judged` int(11) DEFAULT '-1',
  `mem_used` int(11) DEFAULT '0',
  `time_used` int(11) DEFAULT '0',
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission`
--

LOCK TABLES `submission` WRITE;
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
INSERT INTO `submission` VALUES (53,9,'180705201','java','import java.util.Scanner;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        Scanner sc = new Scanner(System.in);\n        int i = 0;\n        int num = 0;\n        long a, b, c;\n        a = 0;\n        b = 0;\n        c = 0;\n        num = sc.nextInt();\n        while (i++ < num) {\n            a = sc.nextLong();\n            b = sc.nextLong();\n            c = sc.nextLong();\n            if ((a + b) > c) {\n                System.out.println(\"Case #\" + i + \":\" + \" true\");\n            } else {\n                System.out.println(\"Case #\" + i + \":\" + \" false\");\n            }\n        }\n    }\n\n}','1522128360769',1,21052,117,611),(54,9,'180705201','java','import java.util.Scanner;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        Scanner sc = new Scanner(System.in);\n        int i = 0;\n        int num = 0;\n        long a, b, c;\n        a = 0;\n        b = 0;\n        c = 0;\n        num = sc.nextInt();\n        while (i++ < num) {\n            a = sc.nextLong();\n            b = sc.nextLong();\n            c = sc.nextLong();\n            if ((a + b) > c) {\n                System.out.println(\"Case #\" + i + \":\" + \" true\");\n            } else {\n                System.out.println(\"Case #\" + i + \":\" + \" false\");\n            }\n        }\n    }\n\n}','1522128718699',0,21056,125,611),(55,9,'180705203','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1522129985736',0,21072,108,563),(56,10,'180705201','java','import java.util.Scanner;\nimport java.util.Arrays;\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.text.DecimalFormat;\nimport java.util.Collections;\npublic class Main{\n    public static void main(String[] args){\n        int i = 0;\n        int sum;\n        int countA2 = 0;\n        int countA4 = 0;\n        int countA5 = 0;\n        int A1 = 0;\n        int A2 = 0;\n        int A3 = 0;\n        double A4 = 0;\n        int A5 = 0;\n        List<Integer> list = new ArrayList<Integer>();\n        Scanner input = new Scanner(System.in);\n        sum = input.nextInt();\n        int[] array = new int[sum];\n        while(i<sum){\n            array[i] = input.nextInt();\n            i++;\n        }\n       // Arrays.sort(array);\n        for(int j=0;j<array.length;j++){\n            int r = array[j]%5;\n            switch(r){\n                case 0:{\n                    if(array[j]%2==0){\n                       A1+= array[j]; \n                    }\n                    break;\n                }\n                case 1:{\n                    A2 += (((countA2%2==0)?(1):(-1))*array[j]);\n                    countA2++;\n                    break;\n                }\n                 case 2:{\n                    A3 ++;\n                    break;\n                }\n                 case 3:{\n                    A4 += array[j];\n                    countA4++;\n                    break;\n                }\n                 case 4:{\n                    list.add(array[j]);\n                    A5 = list.get(countA5);\n                    countA5++;\n                    break;\n                }\n                default:\n                    break;\n            }\n        }\n        if(A1 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A1+\" \");\n        }\n          if(A2 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A2+\" \");\n        }\n          if(A3 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A3+\" \");\n        }\n          if(A4 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n             DecimalFormat df = new DecimalFormat(\"#.0\");\n            System.out.print(df.format(A4/countA4)+\" \");\n        }\n          if(A5 == 0){\n            System.out.print(\"N\");\n        }else{\n            A5 = Collections.max(list);\n            System.out.print(A5);\n        }\n    }\n     \n}','1522130568618',0,21188,110,2404),(57,10,'180705204','java','import java.util.Scanner;\nimport java.util.Arrays;\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.text.DecimalFormat;\nimport java.util.Collections;\npublic class Main{\n    public static void main(String[] args){\n        int i = 0;\n        int sum;\n        int ca2 = 0;\n        int ca4 = 0;\n        int ca5 = 0;\n        int A1 = 0;\n        int A2 = 0;\n        int A3 = 0;\n        double A4 = 0;\n        int A5 = 0;\n        List<Integer> list = new ArrayList<Integer>();\n        Scanner scan = new Scanner(System.in);\n        sum = scan.nextInt();\n        int[] array = new int[sum];\n        while(i<sum){\n            array[i] = scan.nextInt();\n            i++;\n        }\n       // Arrays.sort(array);\n        for(int j=0;j<array.length;j++){\n            int r = array[j]%5;\n            switch(r){\n                case 0:{\n                    if(array[j]%2==0){\n                       A1+= array[j]; \n                    }\n                    break;\n                }\n                case 1:{\n                    A2 += (((ca2%2==0)?(1):(-1))*array[j]);\n                    ca2++;\n                    break;\n                }\n                 case 2:{\n                    A3 ++;\n                    break;\n                }\n                 case 3:{\n                    A4 += array[j];\n                    ca4++;\n                    break;\n                }\n                 case 4:{\n                    list.add(array[j]);\n                    A5 = list.get(ca5);\n                    ca5++;\n                    break;\n                }\n                default:\n                    break;\n            }\n        }\n        if(A1 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A1+\" \");\n        }\n          if(A2 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A2+\" \");\n        }\n          if(A3 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A3+\" \");\n        }\n          if(A4 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n             DecimalFormat df = new DecimalFormat(\"#.0\");\n            System.out.print(df.format(A4/ca4)+\" \");\n        }\n          if(A5 == 0){\n            System.out.print(\"N\");\n        }else{\n            A5 = Collections.max(list);\n            System.out.print(A5);\n        }\n    }\n     \n}','1522130845960',0,20920,117,2365),(58,10,'180705208','java','\nimport java.math.RoundingMode;\nimport java.text.DecimalFormat;\nimport java.util.Scanner;\npublic class Main {\n    public static void main(String[] args) {\n        int[] a = new int[5];\n        boolean[] f = new boolean[5];\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        int j = 0;\n        int n2 = 0;\n        int n4 = 0;\n        while (j++ < n) {\n            int i = sc.nextInt();\n            int r = i % 5;\n            switch (r) {\n                case 0:\n                    if (i % 2 == 0) {\n                        f[0] = true;\n                        a[0] += i;\n                    }\n                    break;\n                case 1:\n                    f[1] = true;\n                    if (++n2 % 2 == 0) {\n                        a[1] -= i;\n                    } else {\n                        a[1] += i;\n                    }\n                    break;\n                case 2:\n                    f[2] = true;\n                    a[2]++;\n                    break;\n                case 3:\n                    f[3] = true;\n                    a[3] += i;\n                    n4++;\n                    break;\n                case 4:\n                    f[4] = true;\n                    a[4] = Math.max(a[4], i);\n                    break;\n                default:\n                    break;\n            }\n        }\n        StringBuffer sb = new StringBuffer();\n        for (int i = 0; i < 5; i++) {\n            if (f[i] == false) {\n                sb.append(\"N\");\n            } else {\n                if (i != 3) {\n                    sb.append(a[i]);\n                } else {\n                    DecimalFormat df = new DecimalFormat(\"0.0\");\n                    df.setRoundingMode(RoundingMode.HALF_UP);\n                    sb.append(df.format(((double) a[3]) / n4));\n                }\n            }\n            sb.append(\" \");\n        }\n        sb.deleteCharAt(sb.length()-1);\n        System.out.println(sb.toString());\n    }\n}','1522130881951',0,20928,117,1970),(59,10,'180705210','java','\n\nimport java.math.BigDecimal;\nimport java.util.Scanner;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        int A1 = 0, A2 = 0, A3 = 0, A5 = 0;\n        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;\n        int N;\n        float A4 = 0;\n        int index;\n        int flag = 1;\n        float count = 0;\n        int j = 0;\n        int i = 0;\n        int[] a = new int[1000];\n        Scanner scanner = new Scanner(System.in);\n        N = scanner.nextInt();\n        while (i < N) {\n            index = scanner.nextInt();\n            if (index % 5 == 0 && index % 2 == 0) {\n                a1 = 1;\n                A1 += index;\n            } else if (index % 5 == 2) {\n                a3 = 1;\n                A3++;\n            } else if (index % 5 == 1) {\n                a2 = 1;\n                A2 += (flag * index);\n                flag = -1 * flag;\n            } else if (index % 5 == 3) {\n                a4 = 1;\n                count += index;\n                j++;\n                A4 = count / j;\n            } else if (index % 5 == 4) {\n                if (index >= A5){\n                    a5 = 1;\n                    A5 = index;}\n            }\n            i++;\n\n        }\n\n        System.out\n                .println((a1 == 0 ? \"N\" : A1)\n                        + \" \"\n                        + (a2 == 0 ? \"N\" : A2)\n                        + \" \"\n                        + (a3 == 0 ? \"N\" : A3)\n                        + \" \"\n                        + (a4 == 0 ? \"N\" : (new BigDecimal(A4)).setScale(1,\n                        BigDecimal.ROUND_HALF_UP)) + \" \"\n                        + (a5 == 0 ? \"N\" : A5));\n\n    }\n}','1522137078774',0,21068,110,1635),(60,10,'180705209','java','\n\nimport java.util.Scanner;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner input = new Scanner(System.in);\n        int num = input.nextInt();\n        int A1, A2, A3, A5;\n        float A4 = 0.0f;\n        A1 = A2 = A3 = A5 = 0;\n        int A2Num = 0;\n        int A4Num = 0;\n        int[] arr = new int[num];\n        for (int i = 0; i < num; i++) {\n            if (input.hasNext())\n                arr[i] =  input.nextInt();\n            if (arr[i] % 10 == 0) A1 += arr[i];\n            if (arr[i] % 5 == 1) {\n                A2Num++;\n                if (A2Num % 2 != 0) A2 += arr[i];\n                if (A2Num % 2 == 0) A2 -= arr[i];\n            }\n            if (arr[i] % 5 == 2) A3 += 1;\n            if (arr[i] % 5 == 3) {\n                A4 += arr[i];\n                A4Num++;\n            }\n            if (arr[i] % 5 == 4 && arr[i] > A5) A5 = arr[i];\n        }\n        if (A1 == 0) System.out.print(\"N \");\n        else\n            System.out.print(A1 + \" \");\n        if (A2 == 0) System.out.print(\"N \");\n        else\n            System.out.print(A2 + \" \");\n        if (A3 == 0) System.out.print(\"N \");\n        else\n            System.out.print(A3 + \" \");\n        if (A4 == 0) System.out.print(\"N \");\n        else {\n            A4 = ((float) (int) (A4 / A4Num * 10 + 0.5)) / 10;\n            System.out.print(A4 + \" \");\n        }\n        if (A5 == 0) System.out.print(\"N\");\n        else\n            System.out.print(A5);\n    }\n}','1522137378717',7,0,0,1462),(61,10,'180705209','java','\n\nimport java.util.Scanner;\n\npublic class Main {\n    private final static Scanner input = new Scanner(System.in);\n    public static void main(String[] args) {\n        int number = input.nextInt();\n        float[] result = new float[5];\n        int exchange = 1, count = 0;\n        for (int i = 0; i < number; i++) {\n            int temp = input.nextInt();\n            if (temp % 5 == 0) {\n                if (temp % 2 == 0) {\n                    result[0] += temp;\n                }\n            }\n            if (temp % 5 == 1) {\n                result[1] += (temp * exchange);\n                exchange = -exchange;\n            }\n            if (temp % 5 == 2) {\n                ++result[2];\n            }\n            if (temp % 5 == 3) {\n                result[3] += temp;\n                ++count;\n            }\n            if (temp % 5 == 4) {\n                if (result[4] < temp) {\n                    result[4] = temp;\n                }\n            }\n        }\n        for (int i = 0; i < result.length; i++) {\n            if (result[i] == 0) {\n                System.out.println((i==4)?\"N\":\"N \");\n            } else if (i == 3) {\n                System.out.print(String.format(\"%.1f\", result[i] / count) + \" \");\n            } else if ((i == 4)) {\n                System.out.print((int) result[i]);\n            }else {\n                System.out.print((i==4)?(int) result[i]:(int) result[i] + \" \");\n            }\n        }\n    }\n}','1522137522238',0,20972,131,1435),(62,10,'180705207','java','\n\nimport java.math.BigDecimal;\nimport java.util.Scanner;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        int A1 = 0, A2 = 0, A3 = 0, A5 = 0;\n        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;\n        int N;\n        float A4 = 0;\n        int index;\n        int flag = 1;\n        float count = 0;\n        int j = 0;\n        int i = 0;\n        int[] a = new int[1000];\n        Scanner scanner = new Scanner(System.in);\n        N = scanner.nextInt();\n        while (i < N) {\n            index = scanner.nextInt();\n            if (index % 5 == 0 && index % 2 == 0) {\n                a1 = 1;\n                A1 += index;\n            } else if (index % 5 == 2) {\n                a3 = 1;\n                A3++;\n            } else if (index % 5 == 1) {\n                a2 = 1;\n                A2 += (flag * index);\n                flag = -1 * flag;\n            } else if (index % 5 == 3) {\n                a4 = 1;\n                count += index;\n                j++;\n                A4 = count / j;\n            } else if (index % 5 == 4) {\n                if (index >= A5){\n                    a5 = 1;\n                    A5 = index;}\n            }\n            i++;\n\n        }\n\n        System.out\n                .println((a1 == 0 ? \"N\" : A1)\n                        + \" \"\n                        + (a2 == 0 ? \"N\" : A2)\n                        + \" \"\n                        + (a3 == 0 ? \"N\" : A3)\n                        + \" \"\n                        + (a4 == 0 ? \"N\" : (new BigDecimal(A4)).setScale(1,\n                        BigDecimal.ROUND_HALF_UP)) + \" \"\n                        + (a5 == 0 ? \"N\" : A5));\n\n    }\n}','1522137901008',0,21316,118,1635),(63,10,'180705206','java','\n\nimport java.math.BigDecimal;\nimport java.util.Scanner;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        int A1 = 0, A2 = 0, A3 = 0, A5 = 0;\n        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;\n        int N;\n        float A4 = 0;\n        int index;\n        int flag = 1;\n        float count = 0;\n        int j = 0;\n        int i = 0;\n        int[] a = new int[1000];\n        Scanner scanner = new Scanner(System.in);\n        N = scanner.nextInt();\n        while (i < N) {\n            index = scanner.nextInt();\n            if (index % 5 == 0 && index % 2 == 0) {\n                a1 = 1;\n                A1 += index;\n            } else if (index % 5 == 2) {\n                a3 = 1;\n                A3++;\n            } else if (index % 5 == 1) {\n                a2 = 1;\n                A2 += (flag * index);\n                flag = -1 * flag;\n            } else if (index % 5 == 3) {\n                a4 = 1;\n                count += index;\n                j++;\n                A4 = count / j;\n            } else if (index % 5 == 4) {\n                if (index >= A5){\n                    a5 = 1;\n                    A5 = index;}\n            }\n            i++;\n\n        }\n\n        System.out\n                .println((a1 == 0 ? \"N\" : A1)\n                        + \" \"\n                        + (a2 == 0 ? \"N\" : A2)\n                        + \" \"\n                        + (a3 == 0 ? \"N\" : A3)\n                        + \" \"\n                        + (a4 == 0 ? \"N\" : (new BigDecimal(A4)).setScale(1,\n                        BigDecimal.ROUND_HALF_UP)) + \" \"\n                        + (a5 == 0 ? \"N\" : A5));\n\n    }\n}','1522138213206',0,21064,115,1635),(64,10,'180705205','java','\n\nimport java.math.BigDecimal;\nimport java.util.Scanner;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        int A1 = 0, A2 = 0, A3 = 0, A5 = 0;\n        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;\n        int N;\n        float A4 = 0;\n        int index;\n        int flag = 1;\n        float count = 0;\n        int j = 0;\n        int i = 0;\n        int[] a = new int[1000];\n        Scanner scanner = new Scanner(System.in);\n        N = scanner.nextInt();\n        while (i < N) {\n            index = scanner.nextInt();\n            if (index % 5 == 0 && index % 2 == 0) {\n                a1 = 1;\n                A1 += index;\n            } else if (index % 5 == 2) {\n                a3 = 1;\n                A3++;\n            } else if (index % 5 == 1) {\n                a2 = 1;\n                A2 += (flag * index);\n                flag = -1 * flag;\n            } else if (index % 5 == 3) {\n                a4 = 1;\n                count += index;\n                j++;\n                A4 = count / j;\n            } else if (index % 5 == 4) {\n                if (index >= A5){\n                    a5 = 1;\n                    A5 = index;}\n            }\n            i++;\n\n        }\n\n        System.out\n                .println((a1 == 0 ? \"N\" : A1)\n                        + \" \"\n                        + (a2 == 0 ? \"N\" : A2)\n                        + \" \"\n                        + (a3 == 0 ? \"N\" : A3)\n                        + \" \"\n                        + (a4 == 0 ? \"N\" : (new BigDecimal(A4)).setScale(1,\n                        BigDecimal.ROUND_HALF_UP)) + \" \"\n                        + (a5 == 0 ? \"N\" : A5));\n\n    }\n}','1522138324725',0,21328,117,1635),(65,10,'180705203','java','\n\nimport java.math.BigDecimal;\nimport java.util.Scanner;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        int A1 = 0, A2 = 0, A3 = 0, A5 = 0;\n        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;\n        int N;\n        float A4 = 0;\n        int index;\n        int flag = 1;\n        float count = 0;\n        int j = 0;\n        int i = 0;\n        int[] a = new int[1000];\n        Scanner scanner = new Scanner(System.in);\n        N = scanner.nextInt();\n        while (i < N) {\n            index = scanner.nextInt();\n            if (index % 5 == 0 && index % 2 == 0) {\n                a1 = 1;\n                A1 += index;\n            } else if (index % 5 == 2) {\n                a3 = 1;\n                A3++;\n            } else if (index % 5 == 1) {\n                a2 = 1;\n                A2 += (flag * index);\n                flag = -1 * flag;\n            } else if (index % 5 == 3) {\n                a4 = 1;\n                count += index;\n                j++;\n                A4 = count / j;\n            } else if (index % 5 == 4) {\n                if (index >= A5){\n                    a5 = 1;\n                    A5 = index;}\n            }\n            i++;\n\n        }\n\n        System.out\n                .println((a1 == 0 ? \"N\" : A1)\n                        + \" \"\n                        + (a2 == 0 ? \"N\" : A2)\n                        + \" \"\n                        + (a3 == 0 ? \"N\" : A3)\n                        + \" \"\n                        + (a4 == 0 ? \"N\" : (new BigDecimal(A4)).setScale(1,\n                        BigDecimal.ROUND_HALF_UP)) + \" \"\n                        + (a5 == 0 ? \"N\" : A5));\n\n    }\n}','1522139070875',0,21316,108,1635),(66,10,'180705202','java','import java.util.Scanner;\nimport java.util.Arrays;\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.text.DecimalFormat;\nimport java.util.Collections;\npublic class Main{\n    public static void main(String[] args){\n        int i = 0;\n        int sum;\n        int ca2 = 0;\n        int ca4 = 0;\n        int ca5 = 0;\n        int A1 = 0;\n        int A2 = 0;\n        int A3 = 0;\n        double A4 = 0;\n        int A5 = 0;\n        List<Integer> list = new ArrayList<Integer>();\n        Scanner scan = new Scanner(System.in);\n        sum = scan.nextInt();\n        int[] array = new int[sum];\n        while(i<sum){\n            array[i] = scan.nextInt();\n            i++;\n        }\n       // Arrays.sort(array);\n        for(int j=0;j<array.length;j++){\n            int r = array[j]%5;\n            switch(r){\n                case 0:{\n                    if(array[j]%2==0){\n                       A1+= array[j]; \n                    }\n                    break;\n                }\n                case 1:{\n                    A2 += (((ca2%2==0)?(1):(-1))*array[j]);\n                    ca2++;\n                    break;\n                }\n                 case 2:{\n                    A3 ++;\n                    break;\n                }\n                 case 3:{\n                    A4 += array[j];\n                    ca4++;\n                    break;\n                }\n                 case 4:{\n                    list.add(array[j]);\n                    A5 = list.get(ca5);\n                    ca5++;\n                    break;\n                }\n                default:\n                    break;\n            }\n        }\n        if(A1 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A1+\" \");\n        }\n          if(A2 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A2+\" \");\n        }\n          if(A3 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n            System.out.print(A3+\" \");\n        }\n          if(A4 == 0){\n            System.out.print(\"N\"+\" \");\n        }else{\n             DecimalFormat df = new DecimalFormat(\"#.0\");\n            System.out.print(df.format(A4/ca4)+\" \");\n        }\n          if(A5 == 0){\n            System.out.print(\"N\");\n        }else{\n            A5 = Collections.max(list);\n            System.out.print(A5);\n        }\n    }\n     \n}','1522229200124',0,21192,118,2365),(67,9,'180705202','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1524399087857',1,19920,425,563),(68,9,'180705202','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1524399544447',1,19932,336,563),(69,9,'180705202','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1524400138056',1,20240,184,563),(70,9,'180705202','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1524401357631',1,19988,171,563),(71,9,'180705202','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1524401899619',1,19984,153,563),(72,9,'180705202','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1524404233598',0,19996,166,563),(73,9,'180705209','java','import java.util.Scanner;\n\npublic class Main {\n    public static void main(String args[]) {\n        Scanner sc = new Scanner(System.in);\n        int n = sc.nextInt();\n        boolean[] result = new boolean[n];\n        for (int i = 0; i < n; i++) {\n            long a = sc.nextLong();\n            long b = sc.nextLong();\n            long c = sc.nextLong();\n            if ((c - a) < b) result[i] = true;\n            else result[i] = false;\n        }\n        for (int i = 0; i < n; i++)\n            System.out.println(\"Case #\" + (i + 1) + \": \" + result[i]);\n    }\n}','1524405230332',0,19992,153,563),(74,9,'180705207','java','import java.math.BigInteger;\nimport java.util.Scanner;\n\npublic class Main {\n    public static void main(String[] args) {\n        int n = 0;\n        Scanner in = new Scanner(System.in);\n        n = in.nextInt();\n        for (int i=1;i<=n;i++) {\n            BigInteger b1 = new BigInteger(in.next());\n            BigInteger b2 = new BigInteger(in.next());\n            BigInteger b3 = new BigInteger(in.next());\n            System.out.println(\"Case #\"+i+\": \"+ (b1.add(b2).compareTo(b3)>=1) );\n        }\n    }\n}\n','1524451958572',0,20100,200,508),(75,9,'180705204','java','public class Main {\npublic static void main(String[] args) {\nSystem.out.println(\"This is a TEST.\");\n}\n}','1524734082101',1,23368,108,103),(76,11,'180707101','java','import java.util.Scanner;\npublic class Main {\n    public static void main( String[] args) {\n        Scanner scan = new Scanner(System.in);\n        String str = scan.nextLine();\n        String strWithoutSpaces = str.replace(\" \", \"\");\n        System.out.println(strWithoutSpaces);\n    }\n}','1527530988818',0,23984,248,286),(77,11,'180707102','java','dfgdfgeger','1527659969141',7,0,0,10),(78,11,'180707102','java','import java.util.Scanner;\npublic class Main {\n    public static void main( String[] args) {\n        Scanner scan = new Scanner(System.in);\n        String str = scan.nextLine();\n        String strWithoutSpaces = str.replace(\" \", \"\");\n        System.out.println(strWithoutSpaces);\n    }\n}','1527659987702',0,23128,152,286);
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` varchar(9) NOT NULL,
  `nickname` varchar(10) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('00079888','张老师','123456',NULL,'17826879888');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testpoint`
--

DROP TABLE IF EXISTS `testpoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testpoint` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `indeex` int(11) DEFAULT NULL,
  `input` varchar(99) DEFAULT NULL,
  `output` varchar(99) DEFAULT NULL,
  `problem_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='测试点表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testpoint`
--

LOCK TABLES `testpoint` WRITE;
/*!40000 ALTER TABLE `testpoint` DISABLE KEYS */;
INSERT INTO `testpoint` VALUES (6,0,'4\n1 2 3\n2 3 4\n2147483647 0 2147483646\n0 -2147483648 -2147483647','Case #1: false\r\nCase #2: true\r\nCase #3: true\r\nCase #4: false',9),(7,0,'13 1 2 3 4 5 6 7 8 9 10 20 16 18','30 11 2 9.7 9',10),(8,0,'Hey this is a state of trance...It was deep, it was underground ','Heythisisastateoftrance...Itwasdeep,itwasunderground',11);
/*!40000 ALTER TABLE `testpoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `start_time` varchar(15) NOT NULL,
  `end_time` varchar(15) NOT NULL,
  `create_time` varchar(15) NOT NULL,
  `creator` varchar(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='作业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (11,'18电信2班Java练习01',NULL,'1522080000000','1527696000000','1522121486742','00079888'),(12,'18软工1班面向对象01',NULL,'1523462400000','1525017600000','1523503337193','00079888'),(13,'18软工2班Java游戏设计01',NULL,'1525017600000','1527782400000','1523503429735','00079888'),(14,'18软工3班Java字符串练习题',NULL,'1522512000000','1523030400000','1523503619157','00079888'),(15,'18软工1班面向对象02',NULL,'1527465600000','1530316800000','1527529582597','00079888');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_problem`
--

DROP TABLE IF EXISTS `topic_problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic_problem` (
  `topic_id` bigint(20) NOT NULL,
  `problem_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='作业-题目关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_problem`
--

LOCK TABLES `topic_problem` WRITE;
/*!40000 ALTER TABLE `topic_problem` DISABLE KEYS */;
INSERT INTO `topic_problem` VALUES (11,9,9),(11,10,10),(15,11,11);
/*!40000 ALTER TABLE `topic_problem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-12 22:08:56
