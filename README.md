父工程用来聚合

### 逆向工程
先复制mapper, 后建service包，把implService拷进来

a 配置整合dubbo
b service 加dubbo的@Service注解，@Compent注册到容器

### 读写分离 
mybatis-plus&多数据源

MyCat：重，
**sharding-jdbc：增强版的数据库驱动。轻量级**
```xml
 <dependency>
        <groupId>io.shardingjdbc</groupId>
        <artifactId>sharding-jdbc-core</artifactId>
        <version>2.0.3</version>
    </dependency>
```
#### sharding-jdbc.yml
```yaml
dataSources:
  db_master: !!com.zaxxer.hikari.HikariDataSource
    driverClassName: com.mysql.jdbc.Driver
    jdbcUrl: jdbc:mysql://112.124.14.16:3306/gmall_pms?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: Yubobo1992!
  db_slave: !!com.zaxxer.hikari.HikariDataSource
    driverClassName: com.mysql.jdbc.Driver
    jdbcUrl: jdbc:mysql://47.99.154.227:3306/gmall_pms?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: Yubobo1992!
masterSlaveRule:
  name: db_ms
  masterDataSourceName: db_master
  slaveDataSourceNames: [db_slave]

###注意，这份文档直接从官网复制的。!!后面是DataSource的实现类全类名不能省略。
###多个slave加多份db_slaveXX配置即可，在slaveDataSourceNames列举这些slaver

```

#### elk 日志分析
ElasticSearch 存储和检索数据
Logstach  收集日志，还可以收集mysql数据库内的数据
Kibana  可视化界面

```shell
docker pull elasticsearch:5.6.11
docker pull kibana:5.6.11
docker pull logstash:5.6.15
```

### DOCKER安装 ElasticSearch
a). mkdir -p /mydata/elasticsearch/config
b). mkdir -p /mydata/elasticsearch/data
c). echo "http.host: 0.0.0.0" >> /mydata/elasticsearch/config/elasticsearch.yml

d). docker run --name elasticsearch -p 9200:9200 -p 9300:9300 \
-e "discovery.type=single-node" \
-e ES_JAVA_OPTS="-Xms256m -Xmx256m" \
-v /mydata/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
-v /mydata/elasticsearch/data:/usr/share/elasticsearch/data -d elasticsearch:5.6.11

特别注意：
-e ES_JAVA_OPTS="-Xms256m -Xmx256m" \ 测试环境下，设置ES的初始内存和最大内存，否则导致过大启动不了ES

### DOCKER安装Kibana
a). docker run --name kibana -e ELASTICSEARCH_URL=http://ip:9200 -p 5601:5601 \
-d kibana:5.6.11

### DOCKER安装Logstash
1）、在mydata/logstash中创建logstash.conf文件：文件内容如下
input {
    tcp {
        port => 4560
        codec => json_lines
    }
}
output{
  elasticsearch { 
	hosts => ["192.168.159.130:9200"] 
	index => "applog"
	}
  stdout { codec => rubydebug }
}

注意：
hosts一定不要写127或者localhost；这样docker容器内部127没有es实例，连不上
#### 运行
docker run -d -p 4560:4560 \
-v /mydata/logstash/logstash.conf:/etc/logstash.conf \
--link elasticsearch:elasticsearch \
--name logstash logstash:5.6.15 \
logstash -f /etc/logstash.conf

安装插件：
https://github.com/logstash-plugins
docker exec –it logstash /bin/bash （进入容器内容）
cd /usr/share/logstash/bin （可以whereis logstash找到这个位置）
logstash-plugin install logstash-codec-json_lines


我们对容器做了改变；为了以后方便，可以将这个容器再打包成新的镜像；
可以将修改好的容器制作为镜像，方便下次使用（也可直接推送到镜像仓库）；
docker commit logstash logstash_gmall:0.0.1


