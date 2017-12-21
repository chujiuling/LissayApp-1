package com.seprojects.lissayappserver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CFeedback {
	private String writeUserID; //�����ߵ�ID
	private String category; //����
	private String content; //����
	private String fbDate; //����ʱ��
	
	// ��������ӷ���
	// return: null(��ӷ����ɹ�) String(��ӷ���ʧ����Ϣ)
	public String addFeedback()
	{
		// ���ɷ�������
		JsonObject json = setData("40001", writeUserID, category, content, null);
						
		// ���ݷ���
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// ��ӷ����ɹ�
		{
		    return null;
		}
		else
		{
			return json.get("state").getAsString(); // ��ӷ���ʧ��
		}
	}
	
	// ������ɾ������
	// return: null(ɾ�������ɹ�) String(ɾ������ʧ����Ϣ)
	public String delFeedback()
	{
		// ���ɷ�������
		JsonObject json = setData("40002", writeUserID, null, null, fbDate);
						
		// ���ݷ���
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// ɾ�������ɹ�
		{
		    return null;
		}
		else
		{
			return json.get("state").getAsString(); // ɾ������ʧ��
		}
	}
	
	
	
	 // ���������� Json ��������
 	// ������_op: �����, _writeUserID: �����ߵ�ID, category: ����, content: ����, fbDate: ����ʱ��
 	// return: JsonObject
	private JsonObject setData(String _op, String _writeUserID, String _category, String _content, String _fbDate)
 	{
 		// ���ɷ�������
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
