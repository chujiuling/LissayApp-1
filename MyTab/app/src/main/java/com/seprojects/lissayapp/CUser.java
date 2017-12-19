package com.seprojects.lissayapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CUser
{
	private String userID; 		// 用户ID
	private String passwd; 		// 登录密码
	private String phoneNum; 	// 手机号码
	private String photo; 		// 头像所用的照片的所在链接
	private String lastLogin; 	// 上次登录时间
	private String phoneModel; 	// 常用登录手机的型号
	private int diaryNum; 		// 可以查看他人的日记数目

	public CUser()
	{
	}

	// 函数：登录
	// 参数：_phoneNum: 手机号码 _passwd: 密码 _phoneModel: 手机型号
	// return: null(登录成功) String(登录失败信息)
	public String login(String _phoneNum, String _passwd, String _phoneModel)
	{
		// 生成发送数据
		JsonObject json = new JsonObject();
		json.addProperty("op", "10001");
		JsonObject info = new JsonObject();
		info.addProperty("phoneNum", _phoneNum);
		info.addProperty("passwd", _passwd);
		info.addProperty("phoneModel", _phoneModel);
		json.add("info", info);

		// 数据交换
		CSystem system = new CSystem();
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(system.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true) // 登录成功
		{
			//putInfo(json); 							// 对各属性值进行赋值
			return null;
		}
		else
		{
			return json.get("state").getAsString();
		}
	}

	// 函数：向对象属性赋值
	// 参数：json: json对象
	private void putInfo(JsonObject json)
	{
		JsonArray array = json.get("info").getAsJsonArray(); 	// 得到json中info的数组
		json = array.get(0).getAsJsonObject();					// 将array[0]转换为JsonObject
		
		// 逐个赋值
		userID = json.get("userID").getAsString();
		passwd = json.get("passwd").getAsString();
		phoneNum = json.get("phoneNum").getAsString();
		lastLogin = json.get("lastLogin").getAsString();
		phoneModel = json.get("phoneModel").getAsString();
		diaryNum = json.get("diaryNum").getAsInt();
	}
}
