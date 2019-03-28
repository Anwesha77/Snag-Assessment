
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.util.HashMap;

class Test {
	
	

	public static void main(String[] args) {
		
		 //Question String Array
		  HashMap<String, String> QuestionAns = new HashMap<String, String>();
		  String s[] = new String[10];
		  s[0] = (String) "{\"Id\":\"1\",\"Question\":\"Boyesh?\",\"Answer\":\"20\"}";
		  s[1]= (String) "{\"Id\":\"2\",\"Question\":\"Ki Chai?\",\"Answer\":\"Poisa\"}";
		  int ctr=0;
		  //Iterate over string array 
		  for(int i = 0; i < 2;i++){
			  Object o1 = JSONValue.parse(s[i]);
			  JSONObject jsonObj = (JSONObject) o1;
			  String Id = (String) jsonObj.get("Id");
			  String Question = (String) jsonObj.get("Question");
			  String Answer = (String) jsonObj.get("Answer");
			  QuestionAns.put(Id,Answer);
		  }
		 String a[] = new String[10]; 
		 a[0] = "{\"Name\":\"Bok\",\"Questions\":[{\"Id\":\"1\",\"Answer\":\"20\"},{\"Id\":\"2\",\"Answer\":\"Poisa\"}]}";
		 a[1] = "{\"Name\":\"Bal\",\"Questions\":[{\"Id\":\"1\",\"Answer\":\"20\"},{\"Id\":\"2\",\"Answer\":\"Poisa\"}]}";
		 
		 for(int i = 0; i < 2;i++){
			 Object obj = JSONValue.parse(a[i]);
			 JSONObject jsonstud = (JSONObject) obj;
			 String Name = (String) jsonstud.get("Name");
			 Object Questions = jsonstud.get("Questions");
			  //System.out.println(Questions);
			 String str = Questions.toString();
			 HashMap<String, String> q_map = new HashMap<String, String>();
			 String qstr=str.substring(1, str.length()-1);
			 //System.out.println(y);
			 String[] q_arr = qstr.replace("},{", "}&&{").split("&&");
			 for(int j = 0; j<2;j++){
				  Object ob = JSONValue.parse(q_arr[j]);
				  JSONObject job = (JSONObject) ob;
				  String Id = (String) job.get("Id");
				  String Answer = (String) job.get("Answer");
				  q_map.put(Id,Answer);
				  
				  if(q_map.equals(QuestionAns)){
					  ctr++;
					  System.out.println(Name);
				  }
			 }
		  }
		 System.out.println(ctr +" "+"applicant(s) are qualified");
		 }
		 
	}