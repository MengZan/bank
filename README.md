# bank
部署到linux: 
1、安装jdk1.7，配置环境变量 
2、安装maven，配置环境变量。运行mvn clean package打包项目，然后把bank-web\target下的WEB-INF文件夹放到对应位置，如/home/dmm/www/bank 
3、安装mysql5.6，用户名root，密码password。创建bank数据库，运行WEB-INF\classes\sql下的.sql文件 
4、安装tomcat7，修改conf下的server.xml文件，在host节点添加 Context docBase="/home/dmm/www/bank" path='' reloadable='true'/ 节点
5、运行tomcat
