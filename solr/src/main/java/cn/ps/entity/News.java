package cn.ps.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName="mycore")
public class News {
	


	@Id
	@Field
	private String id;
	
	@Field
	private String username_ik;
	
	@Field
	private String money;
	
	@Field
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername_ik() {
		return username_ik;
	}

	public void setUsername_ik(String username_ik) {
		this.username_ik = username_ik;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	
}
