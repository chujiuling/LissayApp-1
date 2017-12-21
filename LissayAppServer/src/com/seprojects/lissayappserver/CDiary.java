package com.seprojects.lissayappserver;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//�ࣺ�ռ�
public class CDiary
{
	private String diaryID;     // �ռ�ID
    private String userID;      // �ռǱ�д��ID
    private String tags;        // ��ǩ
    private String groupID;     // ����ID
    private String content;     // �ռ�����
    private int state;         	// �ռ�Ȩ��
    private String releaseDate; // ��������ʱ��
    
    // ���������캯��
    public CDiary()
    {
    }
    
    // ����������ռ�
    // ������_userID: �û�ID, _tags: ��ǩ, _groupID: ����ID, _content: ����, _state: �ռ�Ȩ�ޣ�1������ 2�ɹ�����
    // return: null(����ռǳɹ�) String(����ռ�ʧ����Ϣ)
    public String addDiary(String _userID, String _tags, String _groupID, String _content, int _state)
    {
    	// ���ɷ�������
    	JsonObject json = setData("20001", null, _userID, _tags, _groupID, _content, _state);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// ����ռǳɹ�
   		{
   				
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // ����ռ�ʧ�ܷ���״̬��ʶ
    	}
    }
    
   // ������ɾ���ռ�
   // return: null(ɾ���ռǳɹ�) String(ɾ���ռ�ʧ����Ϣ)
    public String delDiary()
    {
    	// ���ɷ�������
		JsonObject json = setData("20002", diaryID, null, null, null, null, -1);
				
		// ���ݷ���
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
				
		if (json.get("state").isJsonNull() == true)	// ɾ���ռǳɹ�
		{
			return null;
		}
		else
		{
			return json.get("state").getAsString(); // ɾ���ռ�ʧ�ܷ���״̬��ʶ
		}
    }
    
    // �����������ռ�Ȩ��
    // return: null(����ռǳɹ�) String(����ռ�ʧ����Ϣ)
 	public String setState()
 	{
 	    // ���ɷ�������
    	JsonObject json = setData("20003", diaryID, null, null, null, null, state);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// �����ռ�Ȩ�޳ɹ�
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // �����ռ�Ȩ��ʧ�ܷ���״̬��ʶ
    	}
 	}

 	// �����������ռǱ�ǩ
    // return: null(�����ռǱ�ǩ�ɹ�) String(�����ռǱ�ǩʧ����Ϣ)
 	public String setTags()
 	{
 		 // ���ɷ�������
    	JsonObject json = setData("20004", diaryID, null, null, null, null, -1);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// �����ռǱ�ǩ�ɹ�
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // �����ռǱ�ǩʧ�ܷ���״̬��ʶ
    	}
 	}
 
 	// �����������ռǷ���
    // return: null(�����ռǷ���ɹ�) String(�����ռǷ���ʧ����Ϣ)
 	public String setGroup()
 	{
 		// ���ɷ�������
    	JsonObject json = setData("20005", diaryID, null, null, groupID, null, -1);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// �����ռǷ���ɹ�
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // �����ռǷ���ʧ�ܷ���״̬��ʶ
    	}
 	}
 	
    // �������鿴�ռ�����
 	
    // return: null(�鿴�ռ����ݳɹ�) String(�鿴�ռ�����ʧ����Ϣ)
 	public String checkDiary(String _diaryID)
 	{
 		// ���ɷ�������
    	JsonObject json = setData("20006", _diaryID, null, null, null, null, -1);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// �鿴�ռ����ݳɹ�
   		{
   		    putInfo(json);
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // �鿴�ռ�����ʧ�ܷ���״̬��ʶ
    	}
 	}
 
 	// �������鿴����ȫ���ռ�
    // return: null(�鿴����ȫ���ռǳɹ�) String(�鿴����ȫ���ռ�ʧ����Ϣ)
 	public String checkMeDiary()
 	{
 		// ���ɷ�������
    	JsonObject json = setData("20007", null, userID, null, null, null, -1);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// �鿴����ȫ���ռǳɹ�
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // �鿴����ȫ���ռ�ʧ�ܷ���״̬��ʶ
    	}
 	}

 	// �������ռ�����
    // return: null(�ռ����ͳɹ�) String(�ռ�����ʧ����Ϣ)
 	public String tweetDiary()
 	{
 		// ���ɷ�������
    	JsonObject json = setData("20005", diaryID, null, null, groupID, null, -1);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// �ռ����ͳɹ�
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // �ռ�����ʧ�ܷ���״̬��ʶ
    	}
 	}
 
 	// �����������ʷ��¼
 	
    // return: null(�����ʷ��¼�ɹ�) String(�����ʷ��¼ʧ����Ϣ)
 	public String addHistory(String _userID)
 	{
 	    // ���ɷ�������
    	JsonObject json = setData("20009", diaryID, _userID, null, null, null, -1);
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// �����ʷ��¼�ɹ�
   		{
   			putInfo(json);
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // �����ʷ��¼ʧ�ܷ���״̬��ʶ
    	}
 	}
 	
 	// �������鿴������ʷ��¼
    // return: null(�鿴������ʷ��¼�ɹ�) String(�鿴������ʷ��¼ʧ����Ϣ)
 	public String checkHistory()
 	{
 		return null;
 		
 	}

 	// ������ɾ����ʷ��¼
    // return: null(ɾ����ʷ��¼�ɹ�) String(ɾ����ʷ��¼ʧ����Ϣ)
 	public String delHistory()
 	{
 	// ���ɷ�������
    	JsonObject json = setData("20011", diaryID, userID, null, null, null, -1);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// ɾ����ʷ��¼�ɹ�
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // ɾ����ʷ��¼ʧ�ܷ���״̬��ʶ
    	}
 	}
    
    // ���������� Json ��������
 	// ������_op: �����, _userID: �û�ID, _tags: ��ǩ, _groupID: ����ID, _content: ����, _state: �ռ�Ȩ��
 	// return: JsonObject
 	private JsonObject setData(String _op, String _diaryID, String _userID, String _tags, String _groupID, String _content, int _state)
 	{
 		// ���ɷ�������
 		JsonObject json = new JsonObject();
 		json.addProperty("op", _op);
 		JsonObject info = new JsonObject();
 		info.addProperty("diaryID", _diaryID);
 		info.addProperty("userID", _userID);
 		info.addProperty("tags", _tags);
 		info.addProperty("groupID", _groupID);
 		info.addProperty("content", _content);
 		info.addProperty("_state", _state);
 		json.add("info", info);
 		
 		return json;
 	}
 	
 	// ��������������Ը�ֵ
	// ������jsonData: jsonData����
 	private void putInfo(JsonObject jsonData)
	{
 		JsonArray array = jsonData.get("info").getAsJsonArray(); 	// �õ�jsonData��info������
		jsonData = array.get(0).getAsJsonObject();					// ��array[0]ת��ΪJsonObject
		
		// �����ֵ
		diaryID = jsonData.get("diaryID").getAsString();
		userID = jsonData.get("userID").getAsString();
		tags = jsonData.get("tags").getAsString();
		groupID = jsonData.get("groupID").getAsString();
		content = jsonData.get("content").getAsString();
		releaseDate = jsonData.get("releaseDate").getAsString();
	}
 
    // ���������� diaryID
  	// return: String
 	public String getDiaryID()
 	{
 		return diaryID;
 	};  
 	
    // ���������� userID
 	// return: String
 	public String getUserID() 
 	{
 		return userID;
 	}

 	//���������� tags
 	// return: String
 	public String getTags() 
 	{
 		return tags;
 	}

 	//���������� groupID
 	// return: String
 	public String getGroupID() 
 	{
 		return groupID;
 	}

 	//���������� content
 	// return: String
 	public String getContent()  
 	{
 		return content;
 	}

 	//���������� state
 	// return: int
 	public int getState()
 	{
 		return state;
 	}

 	//���������� releaseDate
 	// return: String
 	public String getReleaseDate()
 	{
 		return releaseDate;
 	}
}

class CGetDiary
{
	public CGetDiary()
	{
	}
	
	public List<CDiary> checkMeDiary()
	{
		return null;
	}
	
	public List<CDiary> tweetDiary()
	{
		// ���ɷ�������
    	//JsonObject json = setData("20005", null, null, null, null, null, -1);
    	//System.out.println(json.toString());//�ǵ�ɾ��
    	
    	// ���ݷ���
//		JsonObject json;
//    	JsonParser parser = new JsonParser();
//    	json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
		return null;
	}
}
