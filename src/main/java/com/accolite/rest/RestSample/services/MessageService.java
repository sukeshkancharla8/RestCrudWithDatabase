package com.accolite.rest.RestSample.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accolite.rest.RestSample.models.Message;
import com.accolite.rest.RestSample.utils.DataConnection;



public class MessageService {
	List<Message> messages;
	Connection con;
	public MessageService() {
		// TODO Auto-generated constructor stub
//		messages = new ArrayList<Message>();
//		Message m = new Message(1, "sukesh");
//		messages.add(m);
//		m = new Message(2, "rithvik");
//		messages.add(m);
		con = DataConnection.getConnection();
	}
	public List<Message> getMessages() {
		Statement st;
		List<Message> messages = new ArrayList<Message>();
		try {		
			st = con.createStatement();
			ResultSet resultset = st.executeQuery("select * from messages");
			while(resultset.next()) {
				messages.add(new Message(resultset.getInt(1),resultset.getString(2)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
	}
	public Message getMessageById(int id) {
//		for (int i=0;i<messages.size();i++) {
//			if(messages.get(i).getId()==id) {
//				return messages.get(i);
//			}
//		}
		Message m=null;
		try {		
			Statement st = con.createStatement();
			ResultSet resultset = st.executeQuery("select * from messages where id = "+id+";");
			if(resultset.next()) {
				m = new Message(resultset.getInt(1),resultset.getString(2));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	public boolean addMessage(Message msg) {
		try {		
			Statement st = con.createStatement();
			boolean b = st.execute("insert into messages (id,content) values ("+msg.getId()+",'"+msg.getContent()+"');");
			return b;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteMessage(String content) {
		try {		
			Statement st = con.createStatement();
			boolean b = st.execute("delete from messages where content = '"+content+"';");
			return b;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean modifyMessage(Message m) {
		// TODO Auto-generated method stub
		try {		
			Statement st = con.createStatement();
			boolean b = st.execute("update messages set content = '"+m.getContent()+"' where id = "+m.getId()+";");
			return b;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}