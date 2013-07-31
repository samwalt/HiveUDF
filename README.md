HiveUDF
=======
创建hive数据表：create table visit_record(code string, created_at string, phone string, ip string) row format delimited fields terminated by ' ';
从本地磁盘载入数据到hive：load data local inpath '/home/hadoop/hive.txt' into table visit_record;

数据表的部分内容：
 14209  BIP1A021 20130403025046 13588086687 211.140.5.114
 14210	BIP1A021 20130403025047 15167826419 211.140.5.115
 14211	BIP1A021 20130403025047 15214769919 211.138.69.11
 14212	BIP1A021 20130403025047 15980854428 211.138.157.1
 14213	BIP1A021 20130403025048 13480783116 211.139.190.202
 14214	BIP1A021 20130403025049 13480783116 211.139.190.202
 14215	BIP1A021 20130403025050 13413209230 211.136.222.74
 14216	BIP1A021 20130403025050 13926281996 221.179.37.76
 14217	BIP1A021 20130403025050 15980854428 211.138.157.1
 14218	BIP1A021 20130403025050 15982530997 218.205.237.10


打好的jar包加入hive的类路径：add jar /home/hadoop/workspace/hiveUDF/target/hiveUDF-0.0.1-SNAPSHOT.jar;
创建临时的hive函数：create temporary function phone_prefix as 'com.xiaobiyu.HiveUDF'; 

执行的hive ql语句：select phone_prefix(phone) from visit_record where phone = '13855222636';
