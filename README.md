<div align="center">
<br>
<h1>SimpleDataStorage</h1>
<br>
<br>
</div>

## 导入

1. 下载[最新版本](https://github.com/nitu2003/SimpleDataStorage/releases/latest)。
1. 导入IDE。

## 开发

```java
// 创建实例
File datafile = new File("data.dat");
SimpleDataStorage data = new SimpleDataStorage(datafile);

// 读取数据，其他类型相同
// "count" 代表键值，每个实例（实例对应的文件）中只允许存在一个同名键值
// 0 代表默认值，当文件中不存在目标键值，或者目标键值为 null 时，返回默认值
int count = data.getInteger("count", 0);

// 设置数据，其他类型相同
// "count" 代表键值，每个实例（实例对应的文件）中只允许存在一个同名键值
// count 代表存储的数据
data.setInteger("count", count);

// 消除数据
// "count" 代表键值，每个实例（实例对应的文件）中只允许存在一个同名键值
data.del("count");
data.set("count", null);

// 读取是否有数据
// "count" 代表键值，每个实例（实例对应的文件）中只允许存在一个同名键值
boolean b = data.has("count");

// 存储数据
// 修改数据后仅仅保存在内存中，只有save()后才会存入服务器中
data.save();
```
## 开源条款
本项目按照 EPLv1.0 开源
This project is licensed under EPLv1.0