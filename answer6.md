# API

## 接口列表

| 接口     | 说明               |
| :------- | :----------------- |
| /class   | 基于班级的数据查询 |
| /student | 基于学生的数据查询 |

## 接口详情

### 获得班级所有学生信息

#### 请求

- 接口地址:/class

- 返回格式:Json

- 请求方式:Get

- 请求示例:

  ```http
  GET https://{server}/class?class_id=1234324
  ```

- 参数说明:

| 名称     | 类型   | 必填 | 说明     |
| -------- | ------ | ---- | -------- |
| class_id | string | true | 班级的id |

#### 响应

```json
{
    "msg":"success",
    "result":{
        "class_info":{
            "class_id":"1234324",
            "year":"2019级",
            "class_name":"计算机一班",
            "student_num":2
    	},
    	"student_list":[
            {
                "name":"小明",
                "student_id":"1234"
            },
            {
                "name":"小张",
                "student_id":"2345"
            }
    	]
    }
}
```

错误响应见错误码

### 获得学生详细信息

#### 请求

- 接口地址:/student

- 返回格式:Json

- 请求方式:Get

- 请求示例:

  ```http
  GET https://{server}/student?student_id=1234
  ```

- 参数说明:

| 名称       | 类型   | 必填 | 说明         |
| ---------- | ------ | ---- | ------------ |
| student_id | string | true | 学生自己的id |

#### 响应

```json
{
    "msg":"success",
    "result":{
        "name":"小明",
        "student_id":"1234"
	}	
}
```

错误响应见错误码

## 错误码列表

错误响应示例:

```json
{
    "msg":"fail",
    "result":{
        "errMsg":""
	}	
}
```