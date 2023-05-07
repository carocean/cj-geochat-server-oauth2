说明：
使用配置中心必须使用bootstrap-xxx.yml
如果同时也使用application-xxx.yml这套，则：
注册中心不能配置在application-xxx.yml中，否则：
在docker中使用注册中心中的配置中心服务器名自动发现配置中心时，会由于注册中心配置晚于bootstrap-xxx.yml，导致发现配置中心的地址错误，但是：
在使用idea调试模式时，却能正确发现配置中心地址，可是：
此时自动发现的配置中心地址是docker内地址，因此也无法正确连接。

建议：但凡是与配置中心相连的项目，一律改为bootstrap-xxx.yml来配置。它的作用与application-xxx.yml对应等效，只是加载优先级不同。

与非采用配置中心的项目不同，spring.config.import在bootstrap-xxx.yml中必须加上前缀才能正确加载子配置文件
spring:
config:
#在bootstrap-xxx.yml中要加上optional:前缀，而在application-xxx.yml中不用
import: optional:db/mysql-dev.yml

从配置中心刷新最新配置：
management:
endpoints:
web:
exposure:
#在不重启应用的情况下，放开从配置中心刷新配置的方法，refresh|bus-refresh|*
#刷新原理是用actuator重启了应用
#不清楚支持哪些方法可在浏览器中查看支持的方法：http://localhost:30300/actuator/
#用postman刷新 POST http://localhost:30300/actuator/refresh
#POST http://localhost:30300/actuator/bus-refresh
include: refresh