package com.seprojects.lissayappserver;

import com.google.gson.JsonObject;

//类：日记
public class CDiary
{
	private String diaryID;     // 日记ID
    private String userID;      // 日记编写者ID
    private String tags;        // 标签
    private String groupID;     // 分组ID
    private String content;     // 日记内容
    private int state;         	// 日记权限
    private String releaseDate; // 发布日期时间
    
    // 函数：构造函数
    public CDiary()
    {
    }
    
    // 函数：添加日记
    // 参数：_userID: 用户ID, _tags: 标签, _groupID: 分组ID, _content: 内容, _state: 日记权限（1可评论 2可公开）
    public String addDiary(String _userID, String _tags, String _groupID, String _content, int _state)
    {
    	return "111";
    }
    
    // 函数：生成 Json 发送数据
 	// 参数：_op: 请求号, _userID: 用户ID, _tags: 标签, _groupID: 分组ID, _content: 内容, _state: 日记权限
 	// return: JsonObject
 	private JsonObject setData(String _op, String _userID, String _tags, String _groupID, String _content, int _state)
 	{
 		// 生成发送数据
 		JsonObject json = new JsonObject();
 		json.addProperty("op", _op);
 		JsonObject info = new JsonObject();
 		info.addProperty("userID", _userID);
 		info.addProperty("tags", _tags);
 		info.addProperty("groupID", _groupID);
 		info.addProperty("content", _content);
 		info.addProperty("state", _state);
 		json.add("info", info);
 		
 		return json;
 	}
}
