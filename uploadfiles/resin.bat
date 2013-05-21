@echo off

title Resin - node 1
set JAVA_HOME=C:\Java\jdk1.6.0_24
set RESIN_HOME=D:\XianProject\resin-3.0.28
set CLASS_PATH=%RESIN_HOME%\lib\activation.jar;%RESIN_HOME%\lib\aopalliance.jar;%RESIN_HOME%\lib\ejb-20.jar;%RESIN_HOME%\lib\ejb-30.jar;%RESIN_HOME%\lib\j2ee-deploy-10.jar;%RESIN_HOME%\lib\j2ee-management-10.jar;%RESIN_HOME%\lib\javamail-141.jar;%RESIN_HOME%\lib\jca-15.jar;%RESIN_HOME%\lib\jms-11.jar;%RESIN_HOME%\lib\jmx-12.jar;%RESIN_HOME%\lib\jsdk-24.jar;%RESIN_HOME%\lib\jstl-11.jar;%RESIN_HOME%\lib\jta-101.jar;%RESIN_HOME%\lib\portlet-10.jar;%RESIN_HOME%\lib\quercus.jar;%RESIN_HOME%\lib\resin-jdk15.jar;%RESIN_HOME%\lib\resin.jar;%RESIN_HOME%\lib\resinboot.jar;%RESIN_HOME%\lib\script-10.jar;%RESIN_HOME%\lib\webutil.jar;%RESIN_HOME%\lib\jaxws-api.jar;%RESIN_HOME%\lib\ojdbc14.jar;%RESIN_HOME%/mysql-connector-java-5.1.24-bin.jar

cd ..\demo

java -cp "%CLASS_PATH%" -Xms64m -Xmx512m -server -Djava.util.logging.manager=com.caucho.log.LogManagerImpl com.caucho.server.http.ResinServer -conf D:\XianProject\demo\resin\resin.conf