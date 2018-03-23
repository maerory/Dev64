package net.n1books.dev2.di;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="beaninit.xml")
public class MessageBeanJUnitTest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void testSayHello() {
		MessageBean mbean = (MessageBean) context.getBean("mbean");
		assertEquals("Hello~", mbean.sayhello());
	}
	
	@Test
	public void testJSONObject2json() { //json-simple
		JSONObject object = new JSONObject();
		object.put("name", "유주우");
		object.put("nick", "maeror");
		assertEquals("{\"nick\":\"maeror\",\"name\":\"유주우\"}", (String) object.toJSONString());
	}
	
	@Test
	public void testJson2JSONObject() {
		String str = "{\"nick\":\"maeror\",\"name\":\"유주우\"}";
		@SuppressWarnings("deprecation")
		JSONObject obj = (JSONObject) JSONValue.parse(str);
		System.out.println(obj);
		
		JSONObject source = new JSONObject();
		source.put("name", "유주우");
		source.put("nick", "maeror");
		
		assertEquals(source, obj);
	}
	
	@Test
	public void testJson2Gson() {
		String str = "{\"nick\":\"maeror\",\"name\":\"유주우\"}";
		JsonObject obj = new JsonParser().parse(str).getAsJsonObject();
		assertEquals("{\"nick\":\"maeror\",\"name\":\"유주우\"}", obj.toString());
		assertEquals("\"maeror\"", obj.get("nick").getAsString());
		assertEquals("\"유주우\"", obj.get("name").getAsString());
	}
	
	@Test
	public void testGson2Json() {
		JsonObject obj = new JsonObject();
		obj.addProperty("team", "Tottenham");
		obj.addProperty("name", "Son");
		
		assertEquals("{\"team\":\"Tottenham\",\"name\":\"Son\"}", obj.toString());
	}
	
	
}
