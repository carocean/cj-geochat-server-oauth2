# 规范
一个标准geochat工程包括，framework，remote，starter
> framework: 框架，为starter提供服务定义，同时也为别的工程提供feign的客户端接口定义。
> framework尽量少引用，多数引用放到starter  
> remote: 为连接其它工程的本地feign实现，一般引入别的framework，然后从其接口派生出feign接口  
> starter: 是具体的实现项目，依赖于framework,remote。