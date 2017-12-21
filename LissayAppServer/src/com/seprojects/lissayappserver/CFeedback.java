package com.seprojects.lissayappserver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CFeedback {
	private String writeUserID; //反馈者的ID
	private String category; //类型
	private String content; //内容
	private String fbDate; //反馈时间
	
	// 函数：添加反馈
	// return: null(添加反馈成功) String(添加反馈失败信息)
	public String addFeedback()
	{
		// 生成发送数据
		JsonObject json = setData("40001", writeUserID, category, content, null);
						
		// 数据发送
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// 添加反馈成功
		{
		    return null;
		}
		else
		{
			return json.get("state").getAsString(); // 添加反馈失败
		}
	}
	
	// 函数：删除反馈
	// return: null(删除反馈成功) String(删除反馈失败信息)
	public String delFeedback()
	{
		// 生成发送数据
		JsonObject json = setData("40002", writeUserID, null, null, fbDate);
						
		// 数据发送
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// 删除反馈成功
		{
		    return null;
		}
		else
		{
			return json.get("state").getAsString(); // 删除反馈失败
		}
	}
	
	
	
	 // 函数：生成 Json 发送数据
 	// 参数：_op: 请求号, _writeUserID: 反馈者的ID, category: 类型, content: 内容, fbDate: 反馈时间
 	// return: JsonObject
	private JsonObject setData(String _op, String _writeUserID, String _category, String _content, String _fbDate)
 	{
 		// 生成发送数据
 		JsonObject json = new JsonObject();
 		json.addProperty("op", _op);
 		JsonObject info = new JsonObject();
 		info.addProperty("writeUserID", _writeUserID);
 		info.addProperty("category",_category);
 		info.addProperty("content", _content);
 		info.addProperty("fbDate", _fbDate);
 		json.add("info", info);
 		
 		return json;
 	}
}
