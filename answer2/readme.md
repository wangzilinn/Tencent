## TencentFeign

实现类Http客户端, 调用Feign进行Get请求,Feign基于动态代理, 因此无需实现方法体, 只需实现接口

## TencentResponse

是服务器响应结果的映射,使用@Data注解避免了繁杂的Get/Set及构造方法

## StartAppRunner

执行具体的请求及序列化逻辑

其中调用Jackson先将结果反序列化后调用正则表达式替换数字

## 注意

上述文件须在Spring boot环境中运行

