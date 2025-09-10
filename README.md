# Ninja云图库项目
#### 一个菜鸡写的云图库项目后端
#### swagger地址：http://127.0.0.1:8123/api/doc.html
## 后端接口：
### 文件接口(FileController)(没啥用的接口)：

#### 下载文件：downloadFile(String filePath)

```cpp
请求类型：GET
请求地址：/api/file/download/
请求参数：
    filePath		//文件路径
```

***
#### 上传文件：uploadFile(MultipartFile multipartFile)

```cpp
请求类型：POST
请求地址：/api/file/upload
请求参数：
    multipartFile	//文件参数
```

***
### 图片接口(PictureController)：

#### 删除图片：deletePicture(DeleteRequest deleteRequest)
```cpp
请求类型：POST
请求权限：管理员或自己
请求地址：/api/picture/delete
请求参数：
	{
		"id":0		//图片id
	}
```

#### 编辑图片：editPicture(PictureEditRequest pictureEditRequest)
```cpp
请求类型：POST
请求权限：管理员或自己
请求地址：/api/picture/edit
请求参数：
    {
		"id": 0,				//图片id
		"url": ""				//图片地址
		"name": "",				//图片名称
		"introduction": "",		//图片简介
		"category": "",			//图片分类
		"tags": [],				//图片标签
	}
```

#### 根据id获取图片：getPictureById(long id)
```cpp
请求类型：GET
请求权限：管理员
请求地址：/api/picture/get
请求参数：
    id	//图片id
```

#### 根据id获取脱敏的图片：getPictureVOById(long id)
```cpp
请求类型：GET
请求地址：/api/picture/get/vo
请求参数：
    id	//图片id
```


